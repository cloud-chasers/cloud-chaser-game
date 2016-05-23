package com.example.froezac17.myapplication;

import android.graphics.Bitmap;

/**
 * Created by Zach Froeber on 4/5/2016.
 */
public class Animation {

    private Bitmap[] frames;
    private int IcurrentFrame;
    private long LstartTime;
    private long Ldelay;
    private boolean BplayedOnce;

    public void setFrames(Bitmap[] frames){
        this.frames = frames;
        IcurrentFrame = 0;
        LstartTime = System.nanoTime();
    }

    public void update(){
        long elapsed = (System.nanoTime()-LstartTime)/1000000;

        if (elapsed > Ldelay){
            IcurrentFrame++;
            LstartTime = System.nanoTime();
        }
        if (IcurrentFrame == frames.length){
            IcurrentFrame = 0;
            BplayedOnce = true;
        }

    }

    public Bitmap getImage(){
        return frames[IcurrentFrame];
    }


    public Bitmap[] getFrames() {
        return frames;
    }

    public boolean isBplayedOnce() {
        return BplayedOnce;
    }

    public int getIcurrentFrame() {
        return IcurrentFrame;
    }

    public long getLdelay() {
        return Ldelay;
    }

    public long getLstartTime() {
        return LstartTime;
    }

    public void setBplayedOnce(boolean bplayedOnce) {
        BplayedOnce = bplayedOnce;
    }

    public void setIcurrentFrame(int icurrentFrame) {
        IcurrentFrame = icurrentFrame;
    }

    public void setLdelay(long ldelay) {
        Ldelay = ldelay;
    }

    public void setLstartTime(long lstartTime) {
        LstartTime = lstartTime;
    }
}

