package kr.ac.tukorea.sgp02.u2019182020.wanderer.game;

import android.graphics.Canvas;

import kr.ac.tukorea.sgp02.u2019182020.wanderer.framework.GameObject;

public class CollisionChecker implements GameObject {
    private final Player player;

    public CollisionChecker(Player player) {
        this.player = player;
    }

    @Override
    public void update() {
        MainScene game = MainScene.get();

    }

    @Override
    public void draw(Canvas canvas) {

    }
}
