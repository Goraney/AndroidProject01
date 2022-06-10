package kr.ac.tukorea.sgp02.u2019182020.wanderer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class GameView extends View {
    public static GameView view;
    private static final String TAG = GameView.class.getSimpleName();

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = this;
    }


}
