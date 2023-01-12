package com.urrecliner.image2048;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

public class QuitImage {

    public Bitmap  make(Context context, int blockSize, int inColor, int lightColor, int darkColor) {

        Bitmap bitmap = new CreateBlock().make(blockSize, inColor, lightColor, darkColor, 0);
        Canvas canvas = new Canvas(bitmap);
//        canvas.save();
//        canvas.rotate(-20);
        Paint paint = new Paint();
        paint.setTextSize(100);
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(2);
        paint.setTypeface(ResourcesCompat.getFont(context, R.font.ticking_regular));
//        canvas.drawText("Quit", (float) blockSize/2, (float) blockSize/2+30, paint);
        paint.setStrokeWidth(2);
        paint.setLetterSpacing(0.1f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.BLUE);
        canvas.drawText("Quit", (float) blockSize/2, (float) blockSize/2+30, paint);

//        canvas.restore();
        return bitmap;
    }
}