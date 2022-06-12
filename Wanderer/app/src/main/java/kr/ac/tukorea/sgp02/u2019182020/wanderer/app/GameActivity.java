package kr.ac.tukorea.sgp02.u2019182020.wanderer.app;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import kr.ac.tukorea.sgp02.u2019182020.wanderer.framework.BaseGame;
import kr.ac.tukorea.sgp02.u2019182020.wanderer.framework.GameView;
import kr.ac.tukorea.sgp02.u2019182020.wanderer.game.MainGame;

public class GameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        setContentView(new GameView(this, null));

        MainGame game = MainGame.get();
        BaseGame.push(game);
    }

    @Override
    protected void onPause() {
        GameView.view.pauseGame();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        GameView.view.resumeGame();
    }

    @Override
    protected void onDestroy() {
        GameView.view = null;
        BaseGame.clear();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (GameView.view.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }
}
