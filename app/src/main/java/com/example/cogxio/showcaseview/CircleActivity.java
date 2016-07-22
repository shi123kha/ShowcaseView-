package com.example.cogxio.showcaseview;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

import java.util.ArrayList;



/**
 * Created by cogxio on 15/7/16.
 */
public class CircleActivity extends Activity {
    float x, y;
    double width;
    int i = 0;
    Handler handler;
String text;
    TextView text1;


    private ArrayList<ShowcaseListArray> myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        CanvasCircle();



    }


    private void CanvasCircle() {



        Bundle bundle = getIntent().getExtras();
        myList = bundle.getParcelableArrayList("mylist");
        Log.e("height in view",""+myList.get(i).getHeight()/2);


        x = (myList.get(i).getX())+(myList.get(i).getWidth()/2);
        y = (myList.get(i).getY());
        width =(myList.get(i).getWidth()+myList.get(i).getWidth()*.1);
        text=myList.get(i).gettext();


    setContentView(new CustomView(this, x, y, (width/2) ,text));


        handler = new Handler();

        final Runnable r = new Runnable() {
            public void run() {

                i++;

                if (i < 3) {

                    CanvasCircle();
                } else {
                    finish();
                }

            }
        };

        handler.postDelayed(r, 3000);

        Thread thread = new Thread() {
            public void run() {
                Looper.prepare();

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {


                            }
                        });

                    }
                }, 15000);

                Looper.loop();
            }
        }; thread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {


            finish();
        }
        return true;
    }
}



