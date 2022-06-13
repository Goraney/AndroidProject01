package kr.ac.tukorea.sgp02.u2019182020.wanderer.game;

import kr.ac.tukorea.sgp02.u2019182020.wanderer.framework.Metrics;
import kr.ac.tukorea.sgp02.u2019182020.wanderer.framework.Scene;

public class MainScene extends Scene {
    //public static final String PARAM_STAGE_INDEX = "stage_index";
    //protected int mapIndex;
    private Player player;

    private static MainScene singleton;

    public static MainScene get() {
        if (singleton == null) {
            singleton = new MainScene();
        }

        return singleton;
    }

    public enum Layer {
        player, controller, COUNT;
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

        //player = new Player(size(6), size(5), size(2), size(2));
        player = new Player(0 + 100, 0 + 100, 64 + 100, 64 + 100);

        add(Layer.player.ordinal(), player);
        add(Layer.controller.ordinal(), new CollisionChecker(player));
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
        Scene.popScene();
        return true;
    }
}
