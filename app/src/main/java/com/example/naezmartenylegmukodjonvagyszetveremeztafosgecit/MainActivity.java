package com.example.naezmartenylegmukodjonvagyszetveremeztafosgecit;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private GLSurfaceView GLView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.karakter);
       // System.out.println("Valami");
        Render render = new Render(this);
       // render.setBitmap(bmp);

       GLView = new GL_Surface(this);
       GLView.setEGLContextClientVersion(2);
       GLView.setRenderer(new Render(this));

       //ez itt a biztos alap a imageview tesztelésére
      /*  setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView2);
        imageView.setImageBitmap(render.getBitmap());*/

    }
}