package kr.ac.tukorea.sgp02.u2019182020.wanderer.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import kr.ac.tukorea.sgp02.u2019182020.wanderer.R;

public class SelectActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
    }

    public void onBtnSelect(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
        //startActivity(new Intent(this, GameActivity.class));
    }

    public void onBtnBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        //startActivity(new Intent(this, MainActivity.class));
    }
}
