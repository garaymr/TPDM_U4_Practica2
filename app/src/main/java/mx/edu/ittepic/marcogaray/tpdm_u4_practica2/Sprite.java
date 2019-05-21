package mx.edu.ittepic.marcogaray.tpdm_u4_practica2;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.Random;

public class Sprite {

    public int x = 10;
    public int y = 10;
    public int xSpeed = 25 ;
    public int ySpeed = 25 ;

    public Lienzo gameView;
    public Bitmap bmp;         // sprite Bitmap


    public Sprite(Lienzo gameView, Bitmap bmp) {
        this.gameView=gameView;
        this.bmp=bmp;
        Random rnd = new Random(System.currentTimeMillis());
        x = rnd.nextInt(400)+1;
        y= rnd.nextInt(800)+1;
        Random rnd2 = new Random(System.currentTimeMillis());
        xSpeed = rnd2.nextInt(50)+1;
        ySpeed = rnd2.nextInt(30)+1;
    }


    private void update() {

        if (x > gameView.getWidth() - bmp.getWidth() - xSpeed) {
            xSpeed = -xSpeed;
        }
        if (x + xSpeed< 0) {
            xSpeed = 15;
        }
        x = x + xSpeed;

        if (y > gameView.getHeight() - bmp.getHeight() - ySpeed) {
            ySpeed = -ySpeed;
        }
        if (y + ySpeed< 70) {
            ySpeed = 15;
        }
        y = y + ySpeed;
    }

    public void onDraw(Canvas canvas) {
        update();
        canvas.drawBitmap(bmp, x , y, null);
    }

    public boolean isColliding(int px, int py){
        return(px >= x && px <= x + bmp.getWidth() && py >= y && py <= y + bmp.getHeight());
    }

}