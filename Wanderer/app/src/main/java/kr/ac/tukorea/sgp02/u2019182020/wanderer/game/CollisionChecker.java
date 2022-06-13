package kr.ac.tukorea.sgp02.u2019182020.wanderer.game;

import android.content.DialogInterface;
import android.graphics.Canvas;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

import kr.ac.tukorea.sgp02.u2019182020.wanderer.framework.BoxCollidable;
import kr.ac.tukorea.sgp02.u2019182020.wanderer.framework.CollisionHelper;
import kr.ac.tukorea.sgp02.u2019182020.wanderer.framework.GameObject;

public class CollisionChecker implements GameObject {
    private final Player player;

    public CollisionChecker(Player player) {
        this.player = player;
    }

    @Override
    public void update() {
        MainScene game = MainScene.get();
        ArrayList<GameObject> portals = game.objectsAt(MainScene.Layer.portal.ordinal());
        for (GameObject portal : portals)
            if (CollisionHelper.collides(player, (BoxCollidable) portal)) {
                Portal port = (Portal) portal;
                if (!port.valid) {
                    continue;
                }
                else {

                }
            }
    }

    @Override
    public void draw(Canvas canvas) {

    }
}
