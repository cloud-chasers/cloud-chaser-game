package com.example.froezac17.myapplication;

import android.graphics.Rect;

/**
 * Created by Zach Froeber on 4/4/2016.
 */
public abstract class GameObject {
    protected int Ix, Iy, Idy, Idx, Iwidth, Iheight;



    public Rect getReactangle(){
        return new Rect(Ix, Iy, Ix+Iwidth, Iy+Iheight);
    }

    public int getIdx() {
        return Idx;
    }

    public int getIdy() {
        return Idy;
    }

    public int getIheight() {
        return Iheight;
    }

    public int getIwidth() {
        return Iwidth;
    }

    public int getIx() {
        return Ix;
    }

    public int getIy() {
        return Iy;
    }

    public void setIdx(int idx) {
        Idx = idx;
    }

    public void setIdy(int idy) {
        Idy = idy;
    }

    public void setIheight(int iheight) {
        Iheight = iheight;
    }

    public void setIwidth(int iwidth) {
        Iwidth = iwidth;
    }

    public void setIx(int ix) {
        Ix = ix;
    }

    public void setIy(int iy) {
        Iy = iy;
    }

}
