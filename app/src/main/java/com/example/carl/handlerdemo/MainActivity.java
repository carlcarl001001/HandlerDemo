package com.example.carl.handlerdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void btnOnClick(View view) {
        new Thread(new ThreadRunnable()).start();
    }

    class ThreadRunnable implements Runnable{

        @Override
        public void run() {
            handler2.sendEmptyMessage(1);
        }
    }
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    log("into handler msg.what 1.");
                    break;
                case 2:
                    break;
                default:
                    break;
            }
        }
    };

    private final Handler handler2 = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case 1:
                    log("into handler2 msg.what 1.");
                    break;
                case 2:
                    break;
                default:
                    break;
            }
            return false;
        }
    });
    private void log(String str){
        Log.i("chen",str);
    }
}
