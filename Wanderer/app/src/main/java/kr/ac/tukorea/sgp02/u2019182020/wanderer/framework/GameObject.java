package kr.ac.tukorea.sgp02.u2019182020.wanderer.framework;

import android.graphics.Canvas;

public interface GameObject {
    public void update(float frameTime);
    public void draw(Canvas canvas);
}
