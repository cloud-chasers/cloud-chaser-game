package com.example.froezac17.myapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Zach Froeber on 6/8/2016.
 */
public class Arrow extends GameObject {

    private Bitmap img;

    public Arrow(Bitmap res, int x, int y){

        this.Ix = x;
        this.Iy = y;
        img = res;

    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(img, Ix, Iy, null);

    }

}
