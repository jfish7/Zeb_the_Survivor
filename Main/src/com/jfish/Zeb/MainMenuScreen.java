package com.jfish.Zeb;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public class MainMenuScreen implements Screen {
    private ZebGame game;
    private final SpriteBatch batch;
    OrthographicCamera MenuCamera;
    GameButton play;
    boolean start=false;

    public MainMenuScreen(ZebGame game) {
        this.game=game;
        MenuCamera=new OrthographicCamera(ZebGame.ViewWidth/2, ZebGame.ViewHeight/2);
        MenuCamera=CameraHelper.render(MenuCamera);
        batch=new SpriteBatch();
        play=new GameButton(Assets.playButton, 3f, .3f, 2f, .8f);
    }
    @Override
    public void render(float deltaTime) {
        MenuCamera=CameraHelper.render(MenuCamera);
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(MenuCamera.combined);
        batch.enableBlending();
        batch.begin();
        batch.draw(Assets.background,0,0,ZebGame.ViewWidth,ZebGame.ViewHeight);
        batch.draw(Assets.title,0,.75f, 8f * Assets.scale, 4f * Assets.scale);
        play.button.draw(batch);
        if(Gdx.input.justTouched()) {
            Vector3 touchPos=new Vector3(Gdx.input.getX(), Gdx.input.getY(),0);
            MenuCamera.unproject(touchPos);
            if(Intersector.isPointInPolygon(play.postions,new Vector2(touchPos.x,touchPos.y))) {
                start=true;
                play.onTouch(play.button);
            }
        }
        if(!Gdx.input.isTouched() && start) {
            game.setScreen(new GameScreen(game));
        }
        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
    }

    @Override
    public void hide () {
    }

    @Override
    public void pause () {
    }

    @Override
    public void resize (int width, int height) {
        ZebGame.ViewWidth = width/50f;
        ZebGame.ViewHeight = height/50f;
        Assets.setScale(ZebGame.ViewWidth,ZebGame.ViewHeight);
        MenuCamera=CameraHelper.render(MenuCamera);
        play.update(play.button);
        play=new GameButton(play.button);
    }

    @Override
    public void resume () {
    }

    @Override
    public void show () {
    }
}
