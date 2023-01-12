package com.urrecliner.image2048;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

public class NoImage {

    public Bitmap  make(Context context, int blockSize, int inColor, int lightColor, int darkColor) {

        Bitmap bitmap = new CreateBlock().make(blockSize, inColor, lightColor, darkColor, 0);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint();
        paint.setTextSize(120);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(12);
        paint.setLetterSpacing(0.2f);
        paint.setTypeface(ResourcesCompat.getFont(context, R.font.ticking_regular));
        canvas.drawText("No", (float) blockSize/2, (float) blockSize/2+32, paint);
        paint.setStrokeWidth(0);
        paint.setColor(0xff648f35);
        canvas.drawText("No", (float) blockSize/2, (float) blockSize/2+32, paint);
        return bitmap;
    }
}