package kr.ac.tukorea.sgp02.u2019182020.wanderer;

import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.ArrayList;

public class BaseGame {
    protected static BaseGame singleton;
    public float frameTime;
    public float elapsedTime;

    public static BaseGame getInstance() {
        return singleton;
    }

    public static void clear() {
        singleton = null;
    }

    protected ArrayList<ArrayList<GameObject>> layers;

    public void init() {
        elapsedTime = 0;
    }

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

    public void draw(Canvas canvas) {
        for (ArrayList<GameObject> gameObjects : layers) {
            for (GameObject gobj : gameObjects) {
                gobj.draw(canvas);
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
                        RecycleBin.add((Recyclable) gameObject);
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
}
