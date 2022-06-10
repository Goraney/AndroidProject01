package kr.ac.tukorea.sgp02.u2019182020.wanderer;

import android.graphics.Canvas;

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

    public void init() {
        elapsedTime = 0;
    }

    public void update(int elapsedNanos) {
        frameTime = (float) (elapsedNanos / 1_000_000_000f);
        elapsedTime += frameTime;

        // 오브젝트 업데이트할것
    }

    public void draw(Canvas canvas) {
        // 오브젝트 드로우할것
    }


}
