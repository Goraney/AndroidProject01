package kr.ac.tukorea.sgp02.u2019182020.wanderer.game;

import androidx.constraintlayout.helper.widget.Layer;

import java.util.ArrayList;

import kr.ac.tukorea.sgp02.u2019182020.wanderer.framework.BaseGame;
import kr.ac.tukorea.sgp02.u2019182020.wanderer.framework.GameObject;

public class MainGame extends BaseGame {
    //public static final String PARAM_STAGE_INDEX = "stage_index";
    //protected int mapIndex;

    private static MainGame singleton;

    public static MainGame get() {
        if (singleton == null) {
            singleton = new MainGame();
        }

        return singleton;
    }

    //public void setMapIndex(int mapIndex) {
        //this.mapIndex = mapIndex;
    //}

    public void init() {
        super.init();
    }


}
