package kr.ac.tukorea.sgp02.u2019182020.wanderer.game;

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
