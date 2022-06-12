package kr.ac.tukorea.sgp02.u2019182020.wanderer.game;

import android.graphics.Rect;
import android.graphics.RectF;

import kr.ac.tukorea.sgp02.u2019182020.wanderer.R;
import kr.ac.tukorea.sgp02.u2019182020.wanderer.framework.BoxCollidable;
import kr.ac.tukorea.sgp02.u2019182020.wanderer.framework.Sprite;

public class Player extends Sprite implements BoxCollidable {
    private static final String TAG = Player.class.getSimpleName();

    private enum State {
        idle, left, right, up, down, jump, fall;

        void applyInsets(RectF dstRect) {

        }
    }

    protected RectF collisionBox = new RectF();

    public Player(float x, float y, float w, float h) {
        super(x, y, w, h, R.mipmap.player);
        this.x = x;
        this.y = y;
        setDstRect(w, h);
        //float bottom = dstRect.bottom;
        //float size = MainScene.get().size(R.dimen.player_width * 4f / 270);
    }

    @Override
    public RectF getBoundingRect() {
        return collisionBox;
    }

    @Override
    public void update() {

    }


}
