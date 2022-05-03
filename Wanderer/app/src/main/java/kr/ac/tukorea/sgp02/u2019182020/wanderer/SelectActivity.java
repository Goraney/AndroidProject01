package kr.ac.tukorea.sgp02.u2019182020.wanderer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SelectActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
    }

    public void onBtnSelect(View view) {
//        Log.d("tag", "onBtnStage()");
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
