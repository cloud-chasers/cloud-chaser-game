package com.example.froezac17.myapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Zach Froeber on 4/4/2016.
 */
public class Background {
    private Bitmap ground, background;
    private int x, y, dx;

    public Background(Bitmap g, Bitmap bg) {
        ground = g;
        background = bg;
        dx = GamePanel.MOVESPEED;

    }

    public void update() {

        x += dx;
        if ((2*GamePanel.WIDTH)+x <= (GamePanel.WIDTH)) {
            x = 0;
        }

    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(background, 0, 0, null);
        canvas.drawBitmap(ground, x, y, null);
        canvas.drawBitmap(ground, x + GamePanel.WIDTH, y, null);


    }

    public Bitmap getImage() {
        return ground;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

