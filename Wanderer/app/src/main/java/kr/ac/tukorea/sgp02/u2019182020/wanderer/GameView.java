package kr.ac.tukorea.sgp02.u2019182020.wanderer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class GameView extends View {
    public static GameView view;
    private static final String TAG = GameView.class.getSimpleName();
    private long lastTimeNanos;
    private boolean initialized;
    private boolean running;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = this;
    }

    public void doFrame(long currentTimeNanos) {

    }

    private void initView() {
        BaseGame.getInstance().init();
    }

    protected void onDraw(Canvas canvas) {
        BaseGame.getInstance().draw(canvas);
    }
}
