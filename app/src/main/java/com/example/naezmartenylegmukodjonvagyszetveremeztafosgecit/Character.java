package com.example.naezmartenylegmukodjonvagyszetveremeztafosgecit;

import android.opengl.GLES20;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class Character {

    private FloatBuffer vertBuf;
    private ShortBuffer draworderBuf;
    private FloatBuffer TextCordinat;
    private final String vertexShaderCode =
            "attribute vec4 vPosition;" +
                    "attribute vec2 vTexCoord;" +
                    "varying vec2 fTexCoord;" +
                    "void main() {" +
                    "  gl_Position = vPosition;" +
                    "  fTexCoord = vTexCoord;" +
                    "}";

    private short draworder[] ={0,1,2,0,2,3};
    private final String fragmentShaderCode =
            "precision mediump float;" +
                    "uniform sampler2D uTexture;" +
                    "varying vec2 fTexCoord;" +
                    "void main() {" +
                    "  gl_FragColor = texture2D(uTexture, fTexCoord);" +
                    "}";


    private int Program;
    private int TextureID;

    private float Cordinates[] = {
            -0.5f, 0.5f, 0.0f,      // top left
            -0.5f, -0.5f, 0.0f,     // bottom left
            0.5f, -0.5f, 0.0f,      // bottom right
            0.5f, 0.5f, 0.0f};      // top right

    private float texCoords[] = {
            0.0f, 0.0f,
            0.5f, 0.0f,
            0.5f, 0.5f,
            0.0f, 0.5f
    };

    public Character() {
        Program = GLES20.glCreateProgram();
        int TestureID = R.drawable.karakter;
        int vert = Render.loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderCode);
        int frag = Render.loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode);


        GLES20.glAttachShader(Program, vert);
        GLES20.glAttachShader(Program, frag);
        GLES20.glLinkProgram(Program);

        ByteBuffer bb = ByteBuffer.allocateDirect(Cordinates.length * 4);
        bb.order(ByteOrder.nativeOrder());
        vertBuf = bb.asFloatBuffer();
        vertBuf.put(Cordinates);
        vertBuf.position(0);

        bb = ByteBuffer.allocateDirect(draworder.length * 2);
        bb.order(ByteOrder.nativeOrder());
        draworderBuf = bb.asShortBuffer();
        draworderBuf.put(draworder);
        draworderBuf.position(0);

        bb = ByteBuffer.allocateDirect(texCoords.length * 4);
        bb.order(ByteOrder.nativeOrder());
        TextCordinat = bb.asFloatBuffer();
        TextCordinat.put(texCoords);
        TextCordinat.position(0);
    }
    public void draw () {
        int position = GLES20.glGetAttribLocation(Program,"vPosition");
        int TextureCordinat =GLES20.glGetAttribLocation(Program,"aTexCoord");
        int TextureHandel = GLES20.glGetAttribLocation(Program,"uTesture");

        GLES20.glUseProgram(Program);
        GLES20.glVertexAttribPointer(position,3,GLES20.GL_FLOAT,false,12,vertBuf);
        GLES20.glEnableVertexAttribArray(position);

        GLES20.glVertexAttribPointer(TextureCordinat,4,GLES20.GL_FLOAT,false,8,TextureCordinat);


        GLES20.glDrawArrays(GLES20.GL_TRIANGLE_FAN,0,4);

    }

}
