package com.developer.asyncdemo;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

public class Worker extends AsyncTask<TextView, String, Boolean> {

    private TextView textView;
    private  static final  String LOG_ASYNC = "AsyncDemo";

    @Override
    protected Boolean doInBackground(TextView... textViews) {
        textView = textViews[0];
        int i = 0;
        while (i++ <15){
            try{
                Thread.sleep(1000);
                publishProgress(String.format("Value of i = %d", i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    protected void onProgressUpdate(String... value) {
        textView.setText(value[0]);
        Log.i(LOG_ASYNC, String.format(value[0]));
    }
}
