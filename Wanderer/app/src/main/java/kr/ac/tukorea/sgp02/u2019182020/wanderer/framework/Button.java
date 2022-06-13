package kr.ac.tukorea.sgp02.u2019182020.wanderer.framework;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.MotionEvent;

public class Button extends Sprite implements Touchable {
    protected final Callback callback;
    private final Bitmap buttonBitmap;
    private Bitmap pressedBitmap;
    private boolean pressed;

    public enum Action {
        pressed, released
    }

    public interface Callback {
        public boolean onTouch(Action action);
    }

    public Button(float x, float y, float w, float h, int bitmapResId, int pressedResId, Callback callback) {
        super(x, y, w, h, bitmapResId);
        buttonBitmap = bitmap;
        if (pressedResId != 0) {
            pressedBitmap = BitmapPool.get(pressedResId);
        }
        this.callback = callback;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float x = e.getX();
        float y = e.getY();

        if (!pressed && !dstRect.contains(x, y)) {
            return false;
        }

        int action = e.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                pressed = true;
                bitmap = pressedBitmap;
                callback.onTouch(Action.pressed);
                return true;

            case MotionEvent.ACTION_UP:
                pressed = false;
                bitmap = buttonBitmap;
                return callback.onTouch(Action.released);

            case MotionEvent.ACTION_MOVE:
                return pressed;
        }
        
        return false;
    }

}
