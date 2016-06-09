package com.example.froezac17.myapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Zach Froeber on 4/4/2016.
 */
public class Player extends GameObject {

    private Bitmap spritesheet;
    private final int GRAVITY = 5;
    private int Iscore;
    private int dx;
    private double Ddya;
    private boolean Bup;
    private boolean Bplaying;
    public Animation animation = new Animation();
    private long LstartTime;
    private int movement;


    public Player (Bitmap res, int w, int h, int numFrames){
        this.Ix=700;
        this.Iy = 918;
        Iscore = 0;
        Iheight = h;
        Iwidth = w;
        movement = 5;

        Bitmap [] image = new Bitmap [numFrames];
        spritesheet = res;

        for (int i = 0; i < numFrames; i++){
            image [i] = Bitmap.createBitmap(spritesheet, i*Iwidth, 0, Iwidth, Iheight);
        }

        animation.setFrames(image);
        animation.setLdelay(100);
        LstartTime = System.nanoTime();

    }


    public void setUp (boolean b) {Bup = b;}

    public void update(){
        long Lelapsed = (System.nanoTime()-LstartTime)/1000000;
        if (Lelapsed > 100){
            Iscore++;
            LstartTime = System.nanoTime();

        }
        Ddya -= GRAVITY;
        Iy -= Ddya;
        Ix += dx;
        if (Ix+Iwidth > 2560){
            dx = 0;}
        if (Iy < 0){
            Iy += Ddya;
            Ddya = 0;}
        if (Iy > 918)
            Iy = 918;
        animation.update();
        //Ix += movement;
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(animation.getImage(), Ix, Iy, null);                 //remove hard code

    }
    public int getScore() {return Iscore;}
    public boolean getPlaying() {return Bplaying;}
    public void setPlaying (boolean a) {Bplaying = a;}
    public void resetDdya () {Ddya = 0;}
    public void resetScore () {Iscore = 0;}
    public Bitmap getSpritesheet() {
        return spritesheet;
    }

    public int getIscore() {
        return Iscore;
    }

    public double getDdya() {
        return Ddya;
    }

    public boolean isBup() {
        return Bup;
    }

    public boolean isBplaying() {
        return Bplaying;
    }

    public Animation getAnimation() {
        return animation;
    }

    public long getLstartTime() {
        return LstartTime;
    }

    public void setSpritesheet(Bitmap spritesheet) {
        this.spritesheet = spritesheet;
    }

    public void setIscore(int iscore) {
        Iscore = iscore;
    }

    public void setDdya(double ddya) {
        Ddya = ddya;
    }

    public void setBup(boolean bup) {
        Bup = bup;
    }

    public void setBplaying(boolean bplaying) {
        Bplaying = bplaying;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    public void setLstartTime(long lstartTime) {
        LstartTime = lstartTime;
    }

    public void setMovement (int m) {movement = movement*m;}

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }


}


