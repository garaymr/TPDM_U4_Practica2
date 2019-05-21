package mx.edu.ittepic.marcogaray.tpdm_u4_practica2;

import android.graphics.Canvas;


public class GameLoopThread extends Thread {
    private Lienzo view;
    private boolean running = false;

    public GameLoopThread(Lienzo view) {
        this.view = view;
    }
    public void setRunning(boolean run) {
        running = run;
    }

    @Override
    public void run() {
        while (running) {
            Canvas c = null;
            try {
                c = view.getHolder().lockCanvas();
                synchronized (view.getHolder()) {
                    view.onDraw(c);
                }
            } finally {
                if (c != null) {
                    view.getHolder().unlockCanvasAndPost(c);
                }
            }
        }
    }
}

