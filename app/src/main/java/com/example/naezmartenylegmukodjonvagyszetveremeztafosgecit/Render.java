package com.example.naezmartenylegmukodjonvagyszetveremeztafosgecit;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import java.io.IOException;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


public class Render implements GLSurfaceView.Renderer{

   // private  Square msquer;
    private static Context context;

    private Bitmap bitmap;

    public Render(Context context) {
       this.context = context;
       // bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.karakter);
    }

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {

        /*try {
           msquer = new Square();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int i, int i1) {

    }

    @Override
    public void onDrawFrame(GL10 gl10) {


        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
       // msquer.draw();
    }

    public static int loadShader(int type, String shaderCode) {


        int shader = GLES20.glCreateShader(type);

        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);

        return shader;
    }

    public  int loadTexture(int resourceId) throws IOException {
        final int[] textureId = new int[1];
        GLES20.glGenTextures(1, textureId, 0);

        //final BitmapFactory.Options options = new BitmapFactory.Options();
        //options.inScaled = false

        Bitmap bmp = BitmapFactory.decodeResource(context.getResources(),resourceId);

        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureId[0]);

        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, GLES20.GL_NEAREST);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, GLES20.GL_NEAREST);

        GLUtils.texImage2D(GLES20.GL_TEXTURE_2D, 0, bmp, 0);

        bmp.recycle();

        return textureId[0];

    }

   /* public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }*/
}
