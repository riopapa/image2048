package com.urrecliner.image2048;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

public class SwingImage {

    public Bitmap  make(Context context, int blockSize, int inColor, int lightColor, int darkColor) {

        Bitmap bitmap = new CreateBlock().make(blockSize, inColor, lightColor, darkColor, 0);
        Canvas canvas = new Canvas(bitmap);
//        canvas.save();
//        canvas.rotate(-20);
        Paint paint = new Paint();
        paint.setTextSize(100);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(8);
        paint.setLetterSpacing(-0.05f);
//        paint.setTypeface(ResourcesCompat.getFont(context, R.font.ticking_regular));
        canvas.drawText("⟪⟪ ⟫⟫", (float) blockSize/2, (float) blockSize/2+32, paint);
        paint.setStrokeWidth(0);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.BLUE);
        canvas.drawText("⟪⟪ ⟫⟫", (float) blockSize/2, (float) blockSize/2+32, paint);

//        canvas.restore();
        return bitmap;
    }
}