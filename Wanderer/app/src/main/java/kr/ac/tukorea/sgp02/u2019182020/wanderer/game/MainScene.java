package kr.ac.tukorea.sgp02.u2019182020.wanderer.game;

import kr.ac.tukorea.sgp02.u2019182020.wanderer.framework.Scene;

public class MainScene extends Scene {
    //public static final String PARAM_STAGE_INDEX = "stage_index";
    //protected int mapIndex;

    private static MainScene singleton;

    public static MainScene get() {
        if (singleton == null) {
            singleton = new MainScene();
        }

        return singleton;
    }

    public enum Layer {

    }

    //public void setMapIndex(int mapIndex) {
        //this.mapIndex = mapIndex;
    //}

    public void init() {
        super.init();

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
