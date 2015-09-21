package com.jfish.Zeb;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;

/**
 * Created by Jonathan on 7/8/2014.
 */
public class TestScreen implements Screen {
    ShapeRenderer renderer;
    Circle LeftOuter;
    Circle LeftInner;
    public TestScreen(ZebGame game) {
        LeftOuter=new Circle();
        LeftInner=new Circle();
    }
    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer=new ShapeRenderer();
    }

    @Override
    public void resize(int i, int i2) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
