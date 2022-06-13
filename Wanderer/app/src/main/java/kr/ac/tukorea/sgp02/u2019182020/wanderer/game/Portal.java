package kr.ac.tukorea.sgp02.u2019182020.wanderer.game;

import android.graphics.Canvas;
import android.graphics.RectF;

import kr.ac.tukorea.sgp02.u2019182020.wanderer.R;
import kr.ac.tukorea.sgp02.u2019182020.wanderer.framework.BitmapPool;
import kr.ac.tukorea.sgp02.u2019182020.wanderer.framework.BoxCollidable;
import kr.ac.tukorea.sgp02.u2019182020.wanderer.framework.Sprite;

public class Portal extends Sprite implements BoxCollidable {
    protected RectF collisionBox = new RectF();

    public Portal(float x, float y, float w, float h) {
        super(x, y, w, h, R.mipmap.portal);
        this.x = x;
        this.y = y;
        setDstRect(w, h);
        collisionBox.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2);
    }

    @Override
    public void update() {

    }

    @Override
    public RectF getBoundingRect() {
        return collisionBox;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, null, dstRect, null);
    }

}
