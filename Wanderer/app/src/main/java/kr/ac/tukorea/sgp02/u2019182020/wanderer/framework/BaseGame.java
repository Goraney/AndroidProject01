package kr.ac.tukorea.sgp02.u2019182020.wanderer.framework;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;

import java.util.ArrayList;

import kr.ac.tukorea.sgp02.u2019182020.wanderer.BuildConfig;

public class BaseGame {
    public float frameTime, elapsedTime;

    public static BaseGame getInstance() {
        int lastIndex = sceneStack.size() - 1;

        if (lastIndex < 0) {
            return null;
        }

        return sceneStack.get(lastIndex);
    }

    public static void clear() {
        //while (sceneStack.size() > 0) {
            //BaseGame scene = sceneStack.remove(0);
            //scene.end();
        //}
        sceneStack.clear();
    }

    protected ArrayList<ArrayList<GameObject>> layers;
    protected Paint collisionPaint;

    protected static ArrayList<BaseGame> sceneStack = new ArrayList<>();

    public static void start(BaseGame scene) {
        int lastIndex = sceneStack.size() - 1;

        if (lastIndex >= 0) {
            BaseGame top = sceneStack.remove(lastIndex);
            top.end();
            sceneStack.set(lastIndex, scene);
        } else {
            sceneStack.add(scene);
        }

        scene.start();
    }

    public static void push(BaseGame scene) {
        int lastIndex = sceneStack.size() - 1;

        if (lastIndex >= 0) {
            BaseGame top = sceneStack.get(lastIndex);
            top.pause();
        }

        sceneStack.add(scene);
        scene.start();
    }

    public static void popScene() {
        int lastIndex = sceneStack.size() - 1;

        if (lastIndex >= 0) {
            BaseGame top = sceneStack.remove(lastIndex);
            top.end();
        }

        lastIndex--;

        if (lastIndex >= 0) {
            BaseGame top = sceneStack.get(lastIndex);
            top.resume();
        }
    }

    public void init() {
        // 디버그
        collisionPaint = new Paint();
        collisionPaint.setStyle(Paint.Style.STROKE);
        collisionPaint.setColor(Color.RED);

        elapsedTime = 0;
    }

    //public boolean isTransparent() { return false; }
    public void start(){}
    public void pause(){}
    public void resume(){}
    public void end(){}

    protected void initLayers(int count) {
        layers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            layers.add(new ArrayList<>());
        }
    }

    public void update(int elapsedNanos) {
        frameTime = (float) (elapsedNanos / 1_000_000_000f);
        elapsedTime += frameTime;

        for (ArrayList<GameObject> gameObjects : layers) {
            for (GameObject gobj : gameObjects) {
                gobj.update();
            }
        }
    }

//    public void draw(Canvas canvas) {
//        draw(canvas, sceneStack.size() - 1);
//    }

//    protected void draw(Canvas canvas, int index) {
//        BaseGame scene = sceneStack.get(index);
//
//        if (scene.isTransparent() && index > 0) {
//            draw(canvas, index - 1);
//        }
//
//        ArrayList<ArrayList<GameObject>> layers = scene.layers;
//
//        for (ArrayList<GameObject> gameObjects : layers) {
//            for (GameObject gobj : gameObjects) {
//                gobj.draw(canvas);
//            }
//        }
//    }
    public void draw(Canvas canvas) {
        for (ArrayList<GameObject> gameObjects : layers) {
            for (GameObject gobj : gameObjects) {
                gobj.draw(canvas);
            }
        }
    }

    public void drawBoxCollidables(Canvas canvas) {
        for (ArrayList<GameObject> gameObjects : layers) {
            for (GameObject gobj : gameObjects) {
                if (gobj instanceof BoxCollidable) {
                    RectF box = ((BoxCollidable) gobj).getBoundingRect();
                    canvas.drawRect(box, collisionPaint);
                }
            }
        }
    }

    public void add(int layerIndex, GameObject gameObject) {
        GameView.view.post(new Runnable() {
            @Override
            public void run() {
                    ArrayList<GameObject> gameObjects = layers.get(layerIndex);
                    gameObjects.add(gameObject);
            }
        });
    }

    public void remove(GameObject gameObject) {
        GameView.view.post(new Runnable() {
            @Override
            public void run() {
                for (ArrayList<GameObject> gameObjects : layers) {
                    boolean removed = gameObjects.remove(gameObject);
                    if (!removed) continue;
                    if (gameObject instanceof Recyclable) {
                        Recyclable recyclable = (Recyclable) gameObject;
                        recyclable.finish();
                        RecycleBin.add(recyclable);
                    }
                    break;
                }
            }
        });
    }

    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    public ArrayList<GameObject> objectsAt(int layerIndex) {
        return layers.get(layerIndex);
    }

    public int objectCount() {
        int count = 0;

        for (ArrayList<GameObject> gameObjects : layers) {
            count += gameObjects.size();
        }

        return count;
    }

    public void finish() {
        GameView.view.getActivity().finish();
    }

    public boolean handleBackKey() {
        return false;
    }
}
