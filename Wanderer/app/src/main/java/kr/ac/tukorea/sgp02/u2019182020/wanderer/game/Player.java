package kr.ac.tukorea.sgp02.u2019182020.wanderer.game;

import android.graphics.Rect;
import android.graphics.RectF;

import kr.ac.tukorea.sgp02.u2019182020.wanderer.R;
import kr.ac.tukorea.sgp02.u2019182020.wanderer.framework.BoxCollidable;
import kr.ac.tukorea.sgp02.u2019182020.wanderer.framework.Metrics;
import kr.ac.tukorea.sgp02.u2019182020.wanderer.framework.Sprite;

public class Player extends Sprite implements BoxCollidable {
    private static final String TAG = Player.class.getSimpleName();

    private enum State {
        idle, left, right, up, down, jump, fall;

        void applyInsets(RectF dstRect) {

        }
    }

    private State state = State.idle;
    protected RectF collisionBox = new RectF();
    private final float moveSpeed;

    public Player(float x, float y, float w, float h) {
        super(x, y, w, h, R.mipmap.player);
        this.x = x;
        this.y = y;
        setDstRect(w, h);
        collisionBox.set(x - w / 2, y - h / 2, x + w / 2, y + h / 2);
        moveSpeed = Metrics.size(R.dimen.player_speed);
    }

    @Override
    public RectF getBoundingRect() {
        return collisionBox;
    }

    @Override
    public void update(float frameTime) {
        float dx = moveSpeed * frameTime;
        float dy = moveSpeed * frameTime;

        switch (state) {
            case idle:
                break;
            case left:
                x -= dx;
                dstRect.offset(-dx, 0);
                collisionBox.offset(-dx, 0);
                break;

            case right:
                x += dx;
                dstRect.offset(dx, 0);
                collisionBox.offset(dx, 0);
                break;

            case up:
                y -= dy;
                dstRect.offset(0, -dy);
                collisionBox.offset(0, -dy);
                break;

            case down:
                y += dy;
                dstRect.offset(0, dy);
                collisionBox.offset(0, dy);
                break;
        }
    }

    public void move(boolean startsButton, int flag) {
        if (startsButton) {
            if (flag == 0) {
                setState(State.left);
                return;
            }
            else if (flag == 1) {
                setState(State.right);
                return;
            }
            else if (flag == 2) {
                setState(State.up);
                return;
            }
            else if (flag == 3) {
                setState(State.down);
                return;
            }
        }
        if (state != State.idle && !startsButton) {
            setState(State.idle);
        }
    }

    private void setState(State state) {
        this.state = state;
    }
}
