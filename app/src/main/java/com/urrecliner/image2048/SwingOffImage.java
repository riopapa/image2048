package com.urrecliner.image2048;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class SwingOffImage {

    public Bitmap  make(Context context, int blockSize, int inColor, int lightColor, int darkColor) {

        Bitmap bitmap = new CreateBlock().make(blockSize, inColor, lightColor, darkColor, 0);
        Canvas canvas = new Canvas(bitmap);
//        canvas.save();
//        canvas.rotate(-20);
        Paint paint = new Paint();
        paint.setTextSize(100);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(Color.DKGRAY);
        paint.setStrokeWidth(8);
        paint.setLetterSpacing(-0.2f);
//        paint.setTypeface(ResourcesCompat.getFont(context, R.font.ticking_regular));
        canvas.drawText("▮▮", (float) blockSize/2, (float) blockSize/2+24, paint);
        paint.setStrokeWidth(0);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.GRAY);
        canvas.drawText("▮▮", (float) blockSize/2, (float) blockSize/2+24, paint);

//        canvas.restore();
        return bitmap;
    }
}