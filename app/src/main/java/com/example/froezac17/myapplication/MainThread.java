package com.example.froezac17.myapplication;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by Zach Froeber on 4/4/2016.
 */
public class MainThread extends Thread {
    private int IFPS = 30;
    private double DaverageFPS;
    private SurfaceHolder surfaceHolder;
    private GamePanel gamePanel;
    private boolean Brunning = true;
    public static Canvas canvas;

    public MainThread(SurfaceHolder surfaceHolder, GamePanel gamePanel){
        super();
        this.surfaceHolder= surfaceHolder;
        this.gamePanel = gamePanel;

    }

    @Override
    public void run(){
        long LstartTime;
        long LtimeMillis;
        long LwaitTime;
        long LtotalTime = 0;
        int IframeCount = 0;
        long LtargetTime = 1000/IFPS;

        while (Brunning){
            LstartTime = System.nanoTime();
            canvas = null;

            //lock canvas
            try{
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder){
                    this.gamePanel.update();
                    this.gamePanel.draw(canvas);
                }
            } catch (Exception e) {}
            LtimeMillis = (System.nanoTime()- LstartTime)/1000000;
            LwaitTime = LtargetTime-LtimeMillis;

            try {
                this.sleep(LwaitTime);
            }catch (Exception e){}

            finally{
                if (canvas!= null){
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                    catch (Exception e) {e.printStackTrace();}
                }
            }

            LtotalTime += System.nanoTime()-LstartTime;
            IframeCount++;
            if (IframeCount == IFPS){
                DaverageFPS = 1000/((LtotalTime/IframeCount)/1000000);
                IframeCount = 0;
                LtotalTime = 0;
                System.out.println(DaverageFPS);
            }
        }

    }

    public void setBrunning(boolean brunning) {
        this.Brunning = brunning;
    }
}

