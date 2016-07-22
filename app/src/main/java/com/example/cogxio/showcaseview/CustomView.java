package com.example.cogxio.showcaseview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;

/**
 * Created by cogxio on 13/7/16.
*/
public class CustomView extends View {
    Animation anim;
    //     Handler handler;
    private Bitmap bitmap;
    private Canvas cn;
    private int w;
    private int h;
    private PointF point;
    Bitmap mBitmap;
    static int i = 1;
    private int state = 0;
    Handler handler;
    float x;
    float y;
    float radius;
    int drawCount = 0;
    int delayMillis = 3000;
    private Paint paint;
    public int counter = 1;
    LayoutInflater inflater;
    Context context;
     View view;
    TextView text1;
    String text;

    public CustomView(Context context) {
        super(context);


//        init(context);
    }

    public CustomView(Context context, float x, float y, double radius, String text) {


        super(context);
        this.x = x;
        this.y = y;
        this.text=text;
        this.radius=(float)radius;
        w=(int)x;
        h=(int)y;
        Log.e("w", "" + w);
        Log.e("custom", "" + x + y + radius);
        paint = new Paint();
        paint.setColor(Color.TRANSPARENT);
        paint.setAlpha(80);

        Log.e("text1", "" + text1);
    }


    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);

//

        paint = new Paint();
        //color
        paint.setColor(Color.GRAY);
        paint.setAlpha(230);

        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);



//        canvas.drawRect(0,x,y,radius,paint);
        Log.e("custom_draw", "" + x + y + radius);
        drawCount++;
        Log.w(this.getClass().getName(), "onDraw of Balls called. Total draws:" + Integer.toString(drawCount));



        paint = new Paint();
       paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
       paint.setAntiAlias(true);

        canvas.drawCircle(x, y, radius, paint);


        paint.setAntiAlias(true);
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAlpha(60);
        paint.setTextSize(30f);
        paint.setAntiAlias(true);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setTextAlign(Paint.Align.CENTER);

        canvas.drawText(text, getWidth()/2, getHeight()/2, paint);
    }
}


//    public  void clear()
//    {
//        state++;
//        Log.e("state", "" + state);
////        invalidate();
//    }


