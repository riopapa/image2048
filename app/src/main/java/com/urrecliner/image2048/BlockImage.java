package com.urrecliner.image2048;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import androidx.core.content.res.ResourcesCompat;

public class BlockImage {

    public Bitmap  make(int blockSize, int inColor, int lightColor, int darkColor,
                        int cirColor, int idx, Context context) {

        Bitmap bitmap = new CreateBlock().make(blockSize, inColor, lightColor, darkColor, cirColor);
        Canvas canvas = new Canvas(bitmap);

        int number = calcNum(idx);
        int txtSize = 120;
        String s = " "+number+" ";
        Paint tPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        tPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        int xOffset = blockSize / 2;
        int yOffset = blockSize / 2;

        int outColor;
        if (number == 0) {

        } else if (number <= 8) {
            yOffset += 32;
            tPaint.setTextSize(txtSize);
            tPaint.setStrokeWidth(8);
            tPaint.setTextAlign(Paint.Align.CENTER);
            tPaint.setColor(Color.YELLOW);
            tPaint.setTypeface(ResourcesCompat.getFont(context, R.font.titi_bold));
            canvas.drawText(s, (float) xOffset, (float) yOffset, tPaint);
            tPaint.setStrokeWidth(0);
            tPaint.setColor(0xff3333FF);
            tPaint.setTypeface(ResourcesCompat.getFont(context, R.font.titi_bold));
            canvas.drawText(s, (float) xOffset, (float) yOffset, tPaint);
        } else if (number <= 64) {
            yOffset += 32;
            tPaint.setTextSize(txtSize);
            tPaint.setStrokeWidth(8);
            tPaint.setTextAlign(Paint.Align.CENTER);
            tPaint.setColor(Color.WHITE);
            tPaint.setTypeface(ResourcesCompat.getFont(context, R.font.titi_black));
            canvas.drawText(s, (float) xOffset, (float) yOffset, tPaint);
            tPaint.setStrokeWidth(0);
            tPaint.setColor(0xff1111DD);
            tPaint.setTypeface(ResourcesCompat.getFont(context, R.font.titi_black));
            canvas.drawText(s, (float) xOffset, (float) yOffset, tPaint);
        } else if (number <= 128) {
            yOffset += 32;
            tPaint.setTextSize(110);
            tPaint.setStrokeWidth(8);
            tPaint.setTextAlign(Paint.Align.CENTER);
            tPaint.setColor(0xff202020);
            tPaint.setTypeface(ResourcesCompat.getFont(context, R.font.titi_black));
            canvas.drawText(s, (float) xOffset, (float) yOffset, tPaint);
            tPaint.setStrokeWidth(0);
            tPaint.setColor(0xffeeeeee);
            tPaint.setTypeface(ResourcesCompat.getFont(context, R.font.titi_black));
            canvas.drawText(s, (float) xOffset, (float) yOffset, tPaint);
        } else if (number <= 512) {
            yOffset += 24;
            tPaint.setTextSize(110);
            tPaint.setStrokeWidth(8);
            tPaint.setTextAlign(Paint.Align.CENTER);
            tPaint.setColor(0xff222222);
            tPaint.setTypeface(ResourcesCompat.getFont(context, R.font.titi_black));
            canvas.drawText(s, (float) xOffset, (float) yOffset, tPaint);
            tPaint.setStrokeWidth(0);
            tPaint.setColor(0xffdddddd);
            tPaint.setTypeface(ResourcesCompat.getFont(context, R.font.titi_black));
            canvas.drawText(s, (float) xOffset, (float) yOffset, tPaint);
        } else if (number <= 8192) {
            outColor = 0xffeeeeee;
            inColor = 0xff8E50A1;
            if (number <= 2048) {   // 1024, 2048
                inColor = Color.WHITE;
                outColor = Color.DKGRAY;
            }
            tPaint.setTextSize(90);
            tPaint.setStrokeWidth(0);
            tPaint.setTextAlign(Paint.Align.CENTER);
            tPaint.setTypeface(ResourcesCompat.getFont(context, R.font.titi_black));
            yOffset = 112;
            String s1 = "" + (number / 100);
            String s2 = "" + (number - (number / 100) * 100);
            tPaint.setStrokeWidth(12);
            tPaint.setColor(outColor);
            canvas.drawText(s1, (float) xOffset, (float) yOffset, tPaint);
            tPaint.setStrokeWidth(0);
            tPaint.setColor(inColor);
            canvas.drawText(s1, (float) xOffset, (float) yOffset, tPaint);
            yOffset += 76;
            tPaint.setStrokeWidth(12);
            tPaint.setColor(outColor);
            canvas.drawText(s2, (float) xOffset, (float) yOffset, tPaint);
            tPaint.setStrokeWidth(0);
            tPaint.setColor(inColor);
            canvas.drawText(s2, (float) xOffset, (float) yOffset, tPaint);
        } else if (number <= 65536) {
            tPaint.setTextSize(90);
            tPaint.setTextAlign(Paint.Align.CENTER);
            outColor = 0xffeeeeee;
            inColor = 0xff746454;
            tPaint.setTypeface(ResourcesCompat.getFont(context, R.font.titi_black));
            yOffset = 112;
            String s1 = "" + (number / 1000);
            String s2 = "" + (number - (number / 1000) * 1000);
            tPaint.setStrokeWidth(8);
            tPaint.setColor(outColor);
            canvas.drawText(s1, (float) xOffset, (float) yOffset, tPaint);
            tPaint.setColor(inColor);
            tPaint.setStrokeWidth(0);
            canvas.drawText(s1, (float) xOffset, (float) yOffset, tPaint);
            yOffset += 72;
            tPaint.setStrokeWidth(8);
            tPaint.setColor(outColor);
            canvas.drawText(s2, (float) xOffset, (float) yOffset, tPaint);
            tPaint.setStrokeWidth(0);
            tPaint.setColor(inColor);
            canvas.drawText(s2, (float) xOffset, (float) yOffset, tPaint);
        } else {
            tPaint.setTextSize(90);
            tPaint.setTextAlign(Paint.Align.CENTER);
            outColor =Color.BLUE;
            inColor = tPaint.getColor() | 0xFFE0A0A0;
            tPaint.setTypeface(ResourcesCompat.getFont(context, R.font.titi_black));
            yOffset = 108;
            String s1 = "" + (number / 1000);
            String s2 = "" + (number - (number / 1000) * 1000);
            if (s2.length() == 2)
                s2 = "0"+s2;
            tPaint.setStrokeWidth(16);
            tPaint.setColor(outColor);
            canvas.drawText(s1, (float) xOffset, (float) yOffset, tPaint);
            tPaint.setColor(inColor);
            tPaint.setStrokeWidth(0);
            canvas.drawText(s1, (float) xOffset, (float) yOffset, tPaint);
            yOffset += 76;
            tPaint.setStrokeWidth(16);
            tPaint.setColor(outColor);
            canvas.drawText(s2, (float) xOffset, (float) yOffset, tPaint);
            tPaint.setStrokeWidth(0);
            tPaint.setColor(inColor);
            canvas.drawText(s2, (float) xOffset, (float) yOffset, tPaint);
        }
        return bitmap;
    }
    public int calcNum(int index) {
        int number;
        if (index != 0) {
            number = 1;
            while (index-- > 0)
                number = number + number;
        } else
            number = 0;
        return number;
    }
}