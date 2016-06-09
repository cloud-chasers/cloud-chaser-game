package com.example.froezac17.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Zach Froeber on 4/4/2016.
 */
public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

    public static final int WIDTH = 2560;
    public static final int HEIGHT = 1440;
    public static final int MOVESPEED = -5;
    private MainThread thread;
    private Background bg;
    private Player player;
    private Arrow up, down, left, right;


    public GamePanel(Context contect){
        super(contect);

        //add callback to surface holder to intercept events
        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);

        //make gamepanel focusable
        setFocusable(true);

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        bg = new Background(BitmapFactory.decodeResource(getResources(),R.mipmap.ground), BitmapFactory.decodeResource(getResources(), R.mipmap.background));
        player = new Player(BitmapFactory.decodeResource(getResources(), R.mipmap.player), 178, 282, 5);
        up = new Arrow(BitmapFactory.decodeResource(getResources(), R.mipmap.arrow), 200, 1200);

        thread.setBrunning(true);
        thread.start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry){
            try {
                thread.setBrunning(false);
                thread.join();

            } catch (InterruptedException e) {e.printStackTrace();}
            retry = false;
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event){

        if (event.getAction()==MotionEvent.ACTION_DOWN) {
            player.setDdya(100);
            System.out.println("X Value " + (int) event.getX());
            System.out.println("Y Value " + (int)event.getY());
        }
        return super.onTouchEvent(event);

    }


    public void update() {
        bg.update();
        player.update();


    }


    @Override
    public void draw(Canvas canvas) {
        final float scaleFactorX = getWidth() / (WIDTH*1.f);
        final float scaleFactorY = getHeight() / (HEIGHT*1.f);
        System.out.println(scaleFactorX + scaleFactorY);
        if (canvas != null) {
            final int savedState = canvas.save();
            canvas.scale(scaleFactorX, scaleFactorY);
            bg.draw(canvas);
            up.draw(canvas);
            player.draw(canvas);
            canvas.restoreToCount(savedState);
        }
    }
}

