package com.example.naezmartenylegmukodjonvagyszetveremeztafosgecit;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

public class GL_Surface extends GLSurfaceView {

    private Render render;
    private Context context;
    private float previousX;
    private float previousY;

    public GL_Surface(Context context) {
        super(context);
        this.context= context;
        render = new Render(context);
    }
    @Override
    public boolean onTouchEvent(MotionEvent e) {

        float x = e.getX();
        float y = e.getY();

        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:
                float dx = x - previousX;
                float dy = y - previousY;
               // render.Change_Playesr(dx,dy);
                requestRender();
        }
        previousX = x;
        previousY = y;
        return true;
    }


}
