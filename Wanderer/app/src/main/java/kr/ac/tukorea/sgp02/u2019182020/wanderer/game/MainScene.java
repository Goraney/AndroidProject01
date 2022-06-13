package kr.ac.tukorea.sgp02.u2019182020.wanderer.game;

import kr.ac.tukorea.sgp02.u2019182020.wanderer.R;
import kr.ac.tukorea.sgp02.u2019182020.wanderer.framework.Button;
import kr.ac.tukorea.sgp02.u2019182020.wanderer.framework.Metrics;
import kr.ac.tukorea.sgp02.u2019182020.wanderer.framework.Scene;

public class MainScene extends Scene {
    //public static final String PARAM_STAGE_INDEX = "stage_index";
    //protected int mapIndex;
    private Player player;
    private Portal portal;

    private static MainScene singleton;

    public static MainScene get() {
        if (singleton == null) {
            singleton = new MainScene();
        }

        return singleton;
    }

    public enum Layer {
        portal, player, button, controller, COUNT;
    }

    public float size(float unit) {
        return Metrics.height / 10f * unit;
    }

    //public void setMapIndex(int mapIndex) {
        //this.mapIndex = mapIndex;
    //}

    public void init() {
        super.init();

        initLayers(Layer.COUNT.ordinal());

        portal = new Portal(0 + 500, 0 + 300, 64 + 100, 64 + 100);
        add(Layer.portal.ordinal(), portal);

        //player = new Player(size(1), size(1), size(3), size(3));
        player = new Player(0 + 100, 0 + 100, 64 + 100, 64 + 100);
        add(Layer.player.ordinal(), player);

        float button_x = 90, button_y = 900, button_w = 64 + 100, button_h = 64 + 100;
        // left
        add(Layer.button.ordinal(), new Button(
                button_x, button_y, button_w, button_h, R.mipmap.key_left, R.mipmap.key_left_pressed,
                new Button.Callback() {
                    @Override
                    public boolean onTouch (Button.Action action){
                        int flag = 0;
                        player.move(action == Button.Action.pressed, flag);
                        return true;
                    }
                })
        );
        // right
        add(Layer.button.ordinal(), new Button(
                button_x + (2 * button_w) + 10, button_y, button_w, button_h, R.mipmap.key_right, R.mipmap.key_right_pressed,
                new Button.Callback() {
                    @Override
                    public boolean onTouch (Button.Action action){
                        int flag = 1;
                        player.move(action == Button.Action.pressed, flag);
                        return true;
                    }
                })
        );
        // up
        add(Layer.button.ordinal(), new Button(
                button_x + button_w + 5, button_y - button_h - 5, button_w, button_h, R.mipmap.key_up, R.mipmap.key_up_pressed,
                new Button.Callback() {
                    @Override
                    public boolean onTouch (Button.Action action){
                        int flag = 2;
                        player.move(action == Button.Action.pressed, flag);
                        return true;
                    }
                })
        );
        // down
        add(Layer.button.ordinal(), new Button(
                button_x + button_w + 5, button_y, button_w, button_h, R.mipmap.key_down, R.mipmap.key_down_pressed,
                new Button.Callback() {
                    @Override
                    public boolean onTouch (Button.Action action){
                        int flag = 3;
                        player.move(action == Button.Action.pressed, flag);
                        return true;
                    }
                })
        );

        add(Layer.controller.ordinal(), new CollisionChecker(player));
    }

    @Override
    protected int getTouchLayerIndex() {
        return Layer.button.ordinal();
    }

    @Override
    public void start() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void end() {

    }

    @Override
    public boolean handleBackKey() {
        popScene();
        return true;
    }
}
