package com.example.cogxio.showcaseview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cogxio on 12/7/16.
 */
public class ShowcaseMainActivity extends Activity {
    final int numberOfSpots = 5;
    int spotArrayIndex = 0;
    float timeDelay = 1000f;
    Button bt1,bt2;
    TextView text1,text2,text3;
    public   float X,Y;
    public int width1;
    int height;
    final ArrayList<ShowcaseListArray> arraylist = new ArrayList<ShowcaseListArray>();
    int[] viewids =  {R.id.text41, R.id.text42, R.id.text43};
    String arr[]={"Welcome to text1....","welcome in text2","welcome text3...."};
    int count=0;



public RelativeLayout rl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.toolbar);


        for(int i=0; i<viewids.length; i++) {
           final View text= (View) findViewById(viewids[i]);
            Log.e("view",""+text);
//            Set the treeviewObserver for the view
            treeobserver(text,arr[i].toString());



        }

    }


    public void treeobserver(final View text,final String arr1)

    {

        ViewTreeObserver vto1 = text.getViewTreeObserver();



        if (vto1.isAlive()) {
            vto1.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {

            width1=text.getWidth();
                    height   = text.getHeight();
                    X= text.getX();
                    Y= text.getY();
                    int id1 = text.getId();
//

                    ShowcaseListArray array  = new ShowcaseListArray(X,Y,width1,height,arr1);
                    arraylist.add(array);

                    Log.e("x1", "" + X);
                    Log.e("y1", "" + Y);
                    Log.e("weight1", "" + width1);
                    count++;
                    if(count == 3) {
                        Log.e("array size", "" + arraylist.size());
                        Intent intent = new Intent(ShowcaseMainActivity.this, CircleActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList("mylist", arraylist);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }

                }

            });
        }
    }

}