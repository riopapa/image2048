package com.urrecliner.image2048;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Activity mActivity;
    Context mContext;
    File mOutPath;
    int [] colors;
    int inColor, lColor, dColor;
    int blockSize = 242;
    int xPos = 16, yPos = 16;

    int [][] colorTbl = new int[20][4];

    final int [][] cCode = new int [][] {
            // incolor,      light,         dark,       darker
            { 0xffa5c6ca,  0xffb5d9de,  0xff85a6ba,  0xff8080a0}, // 0 0
            { 0xff229a61,  0xff25bc6a,  0xff137a51,  0xff044020}, // 1 2
            { 0xff648f35,  0xff6d9d3a,  0xff486f25,  0xff404000}, // 2 4
            { 0xffa87236,  0xffcd7d3b,  0xff985216,  0xffa04000}, // 3 8
            { 0xff7e9e58,  0xff8caa60,  0xff5e7e38,  0xff604020}, // 4 16
            { 0xffaf8d40,  0xffc09b46,  0xff8f6d20,  0xff804020}, // 5 32
            { 0xff916fc1,  0xff9f7ad4,  0xff714fa1,  0xff6040a0}, // 6 64
            { 0xffbf6d30,  0xffd57734,  0xffaf4d10,  0xffc04000}, // 7 128
            { 0xff2493b3,  0xff27a4c4,  0xff047393,  0xff008080}, // 8 256
            { 0xff97816a,  0xffa58d74,  0xff77614a,  0xff604040}, // 9 512
            { 0xff9aa7a0,  0xffaac7cc,  0xff6a8788,  0xff5a6740}, // 10 1024
            { 0xff959a64,  0xffb0a66a,  0xff757a34,  0xff606020}, // 11 2048
            { 0xff85719e,  0xff927cad,  0xff65517e,  0xff704060}, // 12 4096
            { 0xff8e50a1,  0xff9c57b0,  0xff6e3081,  0xff704080}, // 13 8192
            { 0xff8d6b6a,  0xff9b7574,  0xff6d4b4a,  0xff60404c}, // 14 16384
            { 0xff83721f,  0xff907d22,  0xff6352ff,  0xff7050e0}, // 15 32768
            { 0xff936d9e,  0xffa177ad,  0xff734d7e,  0xff794f34}, // 16 65536
            { 0xff83721f,  0xff907d22,  0xff6352ff,  0xff7050e0}, // 17 131072
            {} };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!Environment.isExternalStorageManager()){
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                Uri uri = Uri.fromParts("package", this.getPackageName(), null);
                intent.setData(uri);
                startActivity(intent);
            }
        }

        View v = getLayoutInflater().inflate(R.layout.activity_main,null);
        // create an instance of the snackbar
        setContentView(v);
        askPermission();
        mActivity = this; mContext = getApplicationContext();

        mOutPath = new File(Environment.getExternalStorageDirectory(), "download/blocks");
        colors = getColors(mContext);

        Bitmap bigMap  = Bitmap.createBitmap(1400, 2800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bigMap);

        // 2,4,8, ...4096, ...
//        for (int num = 0; num < 18; num++) {
//            Bitmap bitmap = new BlockImage().make(blockSize,
//                    cCode[num][0], cCode[num][1], cCode[num][2], (num> 9)? cCode[num][3]:0, num, mContext);
//            canvas.drawBitmap(bitmap, xPos, yPos, null );
//            String nbr = "i"+(""+((num+100))).substring(1)+"_";
//            new Bitmap2File().save(bitmap, new File(mOutPath,nbr+calcNum(num)+".png"));
//            nextPos();
//        }

        // New Image
//        makeLightDark(colors[30]);
//        Log.w("bitmapNew", "color= "+Integer.toHexString(inColor) +
//                " light= "+Integer.toHexString(lColor) +
//                " dark= "+Integer.toHexString(dColor));
//        dColor = 0xff596285;
//        Bitmap bitmapNew = new NewImage().make(mContext, blockSize, inColor, lColor, dColor);
//        canvas.drawBitmap(bitmapNew, xPos, yPos, null);
//        new Bitmap2File().save(bitmapNew, new File(mOutPath,"a_new.png"));

        // yes Image
//        makeLightDark(colors[9]);
//        Log.w("bitmapYes", "color= "+Integer.toHexString(inColor) +
//                " light= "+Integer.toHexString(lColor) +
//                " dark= "+Integer.toHexString(dColor));
//        dColor = 0xff69633c;
//        Bitmap bitmapYes = new YesImage().make(mContext, blockSize, inColor, lColor, dColor);
//        nextPos();
//        canvas.drawBitmap(bitmapYes, xPos, yPos, null);
//        new Bitmap2File().save(bitmapYes, new File(mOutPath,"a_yes.png"));

        // no Image
//        makeLightDark(colors[3]);
//        Log.w("bitmapNo", "color= "+Integer.toHexString(inColor) +
//                " light= "+Integer.toHexString(lColor) +
//                " dark= "+Integer.toHexString(dColor));
//        Bitmap bitmapNo = new NoImage().make(mContext, blockSize, inColor, lColor, dColor);
//        nextPos();
//        dColor = 0xffaa5428;
//        canvas.drawBitmap(bitmapNo,  xPos, yPos, null);
//        new Bitmap2File().save(bitmapNo, new File(mOutPath,"a_no.png"));
//

        // next image
//        makeLightDark(colors[11]);
//        Bitmap bitmapNxt = new NextNoImage().make(mContext, blockSize, 0xff0f0f0f, 0xff4f4f4f, 0xff000000);
//        nextPos();
//        canvas.drawBitmap(bitmapNxt,  xPos, yPos, null);
//        new Bitmap2File().save(bitmapNxt, new File(mOutPath,"a_next.png"));


        // quit Image
//        makeLightDark(colors[8]);
//        Bitmap bitmapQuit = new QuitImage().make(mContext, blockSize, inColor, lColor, dColor);
//        nextPos();
//        canvas.drawBitmap(bitmapQuit,  xPos, yPos, null);
//        new Bitmap2File().save(bitmapQuit, new File(mOutPath,"a_quit.png"));

        // swing Image
//        makeLightDark(colors[30]);
//        Bitmap bitmapSwing = new SwingImage().make(mContext, blockSize, inColor, lColor, dColor);
//        nextPos();
//        canvas.drawBitmap(bitmapSwing, xPos, yPos, null);
//        new Bitmap2File().save(bitmapSwing, new File(mOutPath,"a_swing.png"));

        // swing Image
//        makeLightDark(colors[30]);
//        Bitmap bitmapSwingF = new SwingOffImage().make(mContext, blockSize, inColor, lColor, dColor);
//        nextPos();
//        canvas.drawBitmap(bitmapSwingF, xPos, yPos, null);
//        new Bitmap2File().save(bitmapSwingF, new File(mOutPath,"a_swing_f.png"));

        // bonus Image
        Bitmap [] bonusMap = new BonusImage().make(mContext, blockSize-20);
        for (int i = 0; i < bonusMap.length; i++) {
            nextPos();
            Log.w("a "+i,"xPos "+xPos);
            canvas.drawBitmap(bonusMap[i], xPos, yPos, null);
            new Bitmap2File().save(bonusMap[i], new File(mOutPath,"z"+(100+i)+".png"));
        }

        ImageView imageView = findViewById(R.id.image1);
        imageView.setImageBitmap(bigMap);


    }

    void nextPos () {
        xPos += 270;
        if (xPos > 1200) {
            xPos = 16;
            yPos += 270;
        }
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

    int [] generateLightDark( int nbr) {
        int [] rtnColor = new int[4];
        int color = colors[nbr];
        rtnColor[0] = color;

        int R = Color.red(color);
        int G = Color.green(color);
        int B = Color.blue(color);

        int dR = (R > 220) ? R : R - 32;
        int dG = (G > 220) ? G: G-32;
        int dB = (B > 220) ? B: B-32;

        int lR = R*155/141; if(lR > 255) lR = 254;
        int lG = G*155/141; if(lG > 255) lG = 254;
        int lB = B*155/141; if(lB > 255) lB = 254;

        dR = (dR << 16) & 0x00FF0000;
        dG = (dG << 8) & 0x0000FF00;
        dB = dB & 0x000000FF;
        int dColor =
        lR = (lR << 16) & 0x00FF0000;
        lG = (lG << 8) & 0x0000FF00;
        lB = lB & 0x000000FF;

        rtnColor[1] = 0xFF000000 | lR | lG | lB;
        rtnColor[2] = 0xFF000000 | dR | dG | dB;
        rtnColor[3] = rtnColor[2] & 0xFFE0C0E0;

        return rtnColor;
    }

    void makeLightDark(int color) {
        inColor = color;
        int R = Color.red(inColor);
        int G = Color.green(inColor);
        int B = Color.blue(inColor);
        int dR = (R > 220) ? R : R - 30;
        int dG = (G > 220) ? G: G-30;
        int dB = (B > 220) ? B: B-30;
        int lR = R*155/145; if(lR > 255) lR = 254;
        int lG = G*155/145; if(lG > 255) lG = 254;
        int lB = B*155/145; if(lB > 255) lB = 254;
        int delta = blockSize / 6;

        dR = (dR << 16) & 0x00FF0000;
        dG = (dG << 8) & 0x0000FF00;
        dB = dB & 0x000000FF;
        dColor = 0xFF000000 | dR | dG | dB;
        lR = (lR << 16) & 0x00FF0000;
        lG = (lG << 8) & 0x0000FF00;
        lB = lB & 0x000000FF;
        lColor = 0xFF000000 | lR | lG | lB;

    }
    int[] getColors(Context context) {
        int []colors = {
                ContextCompat.getColor(context, R.color.c00000),    // 0    blank
                ContextCompat.getColor(context, R.color.c00002),    // 1    2
                ContextCompat.getColor(context, R.color.c00004),    // 2    4
                ContextCompat.getColor(context, R.color.c00008),    // 3    8
                ContextCompat.getColor(context, R.color.c00016),    // 4    16
                ContextCompat.getColor(context, R.color.c00032),    // 5    32
                ContextCompat.getColor(context, R.color.c00064),    // 6    64
                ContextCompat.getColor(context, R.color.c00128),    // 7    128
                ContextCompat.getColor(context, R.color.c00256),    // 8    256
                ContextCompat.getColor(context, R.color.c00512),    // 9    512
                ContextCompat.getColor(context, R.color.c01024),    // 10   1024
                ContextCompat.getColor(context, R.color.c02048),    // 11   2048
                ContextCompat.getColor(context, R.color.c04096),    // 12   4096
                ContextCompat.getColor(context, R.color.c08192),    // 13   8192
                ContextCompat.getColor(context, R.color.c16384),    // 14   16384, just in case
                ContextCompat.getColor(context, R.color.c32768),    // 15   32768
                ContextCompat.getColor(context, R.color.c65356),    // 16   65536
                ContextCompat.getColor(context, R.color.c32768),    // 17   65536
                ContextCompat.getColor(context, R.color.c32768),    // 18   65536
                ContextCompat.getColor(context, R.color.c32768),    // 19   65536
                ContextCompat.getColor(context, R.color.c32768),    // 20   65536
                ContextCompat.getColor(context, R.color.c32768),    // 21   65536
                ContextCompat.getColor(context, R.color.c32768),    // 22   65536
                ContextCompat.getColor(context, R.color.c32768),    // 23   65536
                ContextCompat.getColor(context, R.color.c32768),    // 24   65536
                ContextCompat.getColor(context, R.color.blue),      // 25   65536
                ContextCompat.getColor(context, R.color.teal_200),  // 26   65536
                ContextCompat.getColor(context, R.color.purple_500), // 27   65536
                ContextCompat.getColor(context, R.color.white),    // 28   65536
                ContextCompat.getColor(context, R.color.gray),    // 29   65536
                ContextCompat.getColor(context, R.color.new_game),    // 30   65536
                ContextCompat.getColor(context, R.color.c32768),    // 20   65536
                ContextCompat.getColor(context, R.color.c32768),    // 20   65536
                0x000000
        };
        return colors;
    }
    // ↓ ↓ ↓ P E R M I S S I O N    RELATED /////// ↓ ↓ ↓ ↓
    ArrayList<String> permissions = new ArrayList<>();
    private final static int ALL_PERMISSIONS_RESULT = 101;
    ArrayList<String> permissionsToRequest;
    ArrayList<String> permissionsRejected = new ArrayList<>();

    private void askPermission() {
//        permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
        permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        permissionsToRequest = findUnAskedPermissions(permissions);
        if (permissionsToRequest.size() != 0) {
            requestPermissions(permissionsToRequest.toArray(new String[0]),
//            requestPermissions(permissionsToRequest.toArray(new String[permissionsToRequest.size()]),
                    ALL_PERMISSIONS_RESULT);
        }
    }

    private ArrayList<String> findUnAskedPermissions(ArrayList<String> wanted) {
        ArrayList <String> result = new ArrayList<>();
        for (String perm : wanted) if (hasPermission(perm)) result.add(perm);
        return result;
    }
    private boolean hasPermission(String permission) {
        return (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == ALL_PERMISSIONS_RESULT) {
            for (String perms : permissionsToRequest) {
                if (hasPermission(perms)) {
                    permissionsRejected.add(perms);
                }
            }
            if (permissionsRejected.size() > 0) {
                if (shouldShowRequestPermissionRationale(permissionsRejected.get(0))) {
                    String msg = "These permissions are mandatory for the application. Please allow access.";
                    showDialog(msg);
                }
            } else
                Toast.makeText(getApplicationContext(), "Permissions not granted.", Toast.LENGTH_LONG).show();
        }
    }
    private void showDialog(String msg) {
        showMessageOKCancel(msg,
                (dialog, which) -> requestPermissions(permissionsRejected.toArray(
                        new String[0]), ALL_PERMISSIONS_RESULT));
    }
    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

// ↑ ↑ ↑ ↑ P E R M I S S I O N    RELATED /////// ↑ ↑ ↑

}