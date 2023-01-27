package com.urrecliner.image2048;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class CreateBlock {

    public Bitmap make(int blockSize, int inColor, int lightColor, int darkColor, int circleColor) {
        int delta = blockSize/6;
        Paint paint = new Paint();
        Bitmap bitmap = Bitmap.createBitmap(blockSize, blockSize, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        paint.setStrokeWidth(6);
        paint.setColor(lightColor);
        canvas.drawRoundRect(0,0, blockSize, delta*4, delta, delta, paint);

        paint.setColor(darkColor);
        canvas.drawRoundRect(0,delta/8, blockSize, blockSize, delta, delta, paint);

        // center rect
        paint.setColor(inColor);
        paint.setStrokeWidth(0);
        canvas.drawRoundRect(delta/4,delta/4, blockSize-delta/4,
                blockSize - delta/2, delta*3/4, delta*3/4, paint);

        if (circleColor != 0) {
            Paint cirPaint = new Paint();
            cirPaint.setColor(circleColor);
            cirPaint.setAlpha(180);
            int rad = delta*5/16;
            for (int y = delta; y < blockSize - delta/2 ; y+= delta/3) {
                canvas.drawCircle(delta*2/3, y, rad*3/4, cirPaint);
                canvas.drawCircle(blockSize-delta*2/3, y, rad, cirPaint);
            }
            for (int x = delta; x < blockSize - delta/2 ; x+= delta/3) {
                canvas.drawCircle(x, delta*2/3, rad*3/4, cirPaint);
                canvas.drawCircle(x, blockSize-delta*2/3, rad, cirPaint);
            }
        }

        return bitmap;
    }
}