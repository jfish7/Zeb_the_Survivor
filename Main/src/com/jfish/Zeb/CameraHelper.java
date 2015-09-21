package com.jfish.Zeb;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraHelper extends OrthographicCamera{
    private static OrthographicCamera camera;

    public CameraHelper (boolean yDown,float viewWidth, float viewHeight) {
        camera=new OrthographicCamera();
        camera.setToOrtho(yDown, viewportWidth, viewportHeight);
    }

    public static OrthographicCamera render(OrthographicCamera camera) {
        camera.setToOrtho(false, ZebGame.ViewWidth/2, ZebGame.ViewHeight/2);
        camera.update();
        return camera;
    }

    public static OrthographicCamera render(OrthographicCamera camera, float x, float y) {
        if(x-ZebGame.ViewWidth/4 > 0 && x+ZebGame.ViewWidth/4 < ZebGame.ViewWidth) {;
            camera.position.x=x;
        }
        if(y-ZebGame.ViewHeight/4 > 0 && y+ZebGame.ViewHeight/4 < ZebGame.ViewHeight) {
            camera.position.y=y;
        }
        camera.update();
        return camera;
    }
}
