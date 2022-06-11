package kr.ac.tukorea.sgp02.u2019182020.wanderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;

public class Sprite implements GameObject {
    protected Bitmap bitmap;
    protected RectF dstRect = new RectF();

    @Override
    public void update() {

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, null, dstRect, null);
    }
}
