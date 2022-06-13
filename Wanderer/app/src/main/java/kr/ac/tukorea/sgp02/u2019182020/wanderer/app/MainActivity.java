package kr.ac.tukorea.sgp02.u2019182020.wanderer.app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import kr.ac.tukorea.sgp02.u2019182020.wanderer.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void onBtnStart(View view) {
        Intent intent = new Intent(this, SelectActivity.class);
        startActivity(intent);
    }

    public void onBtnQuit(View view) {
        askQuit();
    }

    private void askQuit() {
        new AlertDialog.Builder(this)
                .setTitle("Quit")
                .setMessage("Do you really want to Quit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(0);
                    }
                })
                .setNegativeButton("No", null)
                .create()
                .show();
    }
}