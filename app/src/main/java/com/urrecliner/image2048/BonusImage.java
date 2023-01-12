package com.urrecliner.image2048;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import androidx.core.content.res.ResourcesCompat;

public class BonusImage {

    public Bitmap[]  make(Context context, int blockSize) {
        final int sz = 12;
        Bitmap [] numberMaps = new Bitmap[sz];

        for (int nbr = 0; nbr < sz; nbr++) {
            numberMaps[nbr] = getBitmaps(context, blockSize, nbr+2);
        }
        return numberMaps;
    }

    private Bitmap getBitmaps(Context context, int blockSize, int nbr) {

        Paint paint = new Paint();
        Bitmap bitmap = Bitmap.createBitmap(blockSize, blockSize, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        int outColor = 0xFF00BB00;
        int inColor = 0xFFA0FFA0;
        canvas.save();
        canvas.rotate(15);
        int xx = blockSize/2; int yy = 40;
        paint.setTextSize(60);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(outColor);
        paint.setStrokeWidth(6);
        paint.setTypeface(ResourcesCompat.getFont(context, R.font.segoescb));
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        canvas.drawText("Bonus", xx, yy, paint);

        paint.setColor(inColor);
        paint.setStrokeWidth(0);
        canvas.drawText("Bonus", xx-2, yy-2, paint);

        xx = 70; yy = blockSize/2+20; int w = 4;
        paint.setTextSize(70);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(outColor);
        paint.setStrokeWidth(w);
        paint.setTypeface(ResourcesCompat.getFont(context, R.font.segoescb));
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        canvas.drawText("x", xx, yy, paint);
        paint.setStrokeWidth(0);
        paint.setColor(inColor);
        canvas.drawText("x", xx-2, yy-2, paint);

        xx = 130; yy = blockSize/2+30;
        paint.setTextAlign(Paint.Align.LEFT);
//        paint.setLetterSpacing(0.01f);
        if (nbr > 9) {
            paint.setTextSize(90);
            paint.setColor(outColor);
            paint.setTypeface(ResourcesCompat.getFont(context, R.font.segoescb));
            paint.setStrokeWidth(12);
            canvas.drawText("1", xx-16, yy, paint);
            paint.setStrokeWidth(3);
            paint.setColor(inColor);
            canvas.drawText("1", xx-18, yy-2, paint);

            paint.setStrokeWidth(12);
            paint.setColor(outColor);
            canvas.drawText(""+(nbr-10), xx+50, yy, paint);
            paint.setStrokeWidth(3);
            paint.setColor(inColor);
            canvas.drawText(""+(nbr-10), xx+46, yy-2, paint);
        } else {
            paint.setTextSize(120);
            paint.setColor(outColor);
            paint.setTypeface(ResourcesCompat.getFont(context, R.font.segoescb));
            paint.setStrokeWidth(12);
            canvas.drawText("" + nbr, xx, yy, paint);
            paint.setStrokeWidth(3);
            paint.setColor(inColor);
            canvas.drawText("" + nbr, xx-2, yy-2, paint);
        }
        canvas.restore();
        return bitmap;
    }
}