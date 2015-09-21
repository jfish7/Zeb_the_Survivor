package com.jfish.Zeb;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class PauseScreen implements Screen{
    Screen gameScreen;
    private ZebGame game;
    private SpriteBatch batch;
    OrthographicCamera PauseCamera;
    GameButton restart;
    GameButton menu;
    boolean start=false;
    boolean beginning=false;

    public PauseScreen(ZebGame game, GameScreen screen, SpriteBatch batch) {

        this.game=game;
        this.batch=batch;
        gameScreen=screen;
        PauseCamera=new OrthographicCamera(ZebGame.ViewWidth/2, ZebGame.ViewHeight/2);
        PauseCamera=CameraHelper.render(PauseCamera);
        restart=new GameButton(Assets.restartButton,4f,2.7f,2f,.5f);
        menu=new GameButton(Assets.menuButton,4f, 1.7f, 2f, .5f);
    }

    @Override
    public void render(float deltaTime) {
        gameScreen.render(deltaTime);
        batch.setProjectionMatrix(PauseCamera.combined);
        batch.begin();
        batch.draw(Assets.pauseBackground, ZebGame.ViewWidth / 8, ZebGame.ViewHeight / 8, ZebGame.ViewWidth / 4, ZebGame.ViewHeight / 4);
        restart.button.draw(batch);
        menu.button.draw(batch);
        if(Gdx.input.justTouched()) {
            Vector3 touchPos=new Vector3(Gdx.input.getX(), Gdx.input.getY(),0);
            PauseCamera.unproject(touchPos);
            if(Intersector.isPointInPolygon(restart.postions, new Vector2(touchPos.x, touchPos.y))) {
                start=true;
                restart.onTouch(restart.button);
            }
            if(Intersector.isPointInPolygon(menu.postions, new Vector2(touchPos.x, touchPos.y))) {
                beginning=true;
                menu.onTouch(menu.button);
            }
        }
        if(!Gdx.input.isTouched() && start) {
            game.setScreen(new GameScreen(game));
        }
        if(!Gdx.input.isTouched() && beginning) {
            game.setScreen(new MainMenuScreen(game));
        }
        showScores.drawScores(batch, ZebGame.ViewWidth/4 - .5f * Assets.scale,
                ZebGame.ViewHeight/4 - .3f * (Assets.scale-Assets.yOffset));
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
        PauseCamera=CameraHelper.render(PauseCamera);
        restart.update(restart.button);
        restart=new GameButton(restart.button);
        menu.update(menu.button);
        menu=new GameButton(menu.button);
    }

    @Override
    public void resume () {
    }

    @Override
    public void show () {
    }
}
