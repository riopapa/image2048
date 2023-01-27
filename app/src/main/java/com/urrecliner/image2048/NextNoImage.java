package com.urrecliner.image2048;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.res.ResourcesCompat;

public class NextNoImage {

    public Bitmap  make(Context context, int blockSize, int inColor, int lightColor, int darkColor) {

        Bitmap bitmap = new CreateBlock().make(blockSize, inColor, lightColor, darkColor, 0);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setTextSize(100);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(0xffffffff);
        paint.setStrokeWidth(12);
        paint.setTypeface(ResourcesCompat.getFont(context, R.font.titi_bold));
        canvas.drawText("Next", (float) blockSize/2, (float) blockSize/2+26, paint);
        paint.setStrokeWidth(0);
        paint.setColor(0xff000000);
        canvas.drawText("Next", (float) blockSize/2, (float) blockSize/2+26, paint);


        return bitmap;
    }
}