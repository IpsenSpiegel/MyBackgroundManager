package com.example.ipsenspiegel.mybackgroundmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    public static final String TAG = "TAG_MAIN_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button startThread_Btn = (Button) this.findViewById(R.id.btnStartThread);
        startThread_Btn.setOnClickListener(this);
        final Button startAsyncTask_Btn = (Button) this.findViewById(R.id.btnStartAsyncTask);
        startAsyncTask_Btn.setOnClickListener(this);
    }


    private void sleepForAWhile(int numSeconds) {
        long endTime = System.currentTimeMillis() + (numSeconds * 1000);

        while (System.currentTimeMillis() < endTime) {
            synchronized (this) {
                try {
                    Log.i(MainActivity.TAG, "Sleeping...");
                    this.wait(endTime - System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onClick(View whichView) {
        if (whichView.getId() == R.id.btnStartAsyncTask) {
            Log.d(TAG, "Pulsado botón  de Stard async task");

        } else if (whichView.getId() == R.id.btnStartThread) {
            Log.d(TAG, "Pulsado botón  de Thread");
        }
    }
}