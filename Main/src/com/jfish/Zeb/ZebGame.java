package com.jfish.Zeb;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ZebGame extends Game{
    public static final String LOG=ZebGame.class.getSimpleName();
    private FPSLogger fpsLogger;
    Screen mainMenuScreen;
    Screen playingScreen;
    Screen pauseScreen;
    Screen scoresScreen;
    SpriteBatch batch;
    public static float ViewWidth=16f; public static float ViewHeight=9.6f;

    @Override
    public void create () {
        Gdx.app.log(ZebGame.LOG, "Creating game");
        fpsLogger=new FPSLogger();
        Assets.load();
        batch= new SpriteBatch();
        mainMenuScreen = new MainMenuScreen(this);
        playingScreen = new GameScreen(this);
        //scoresScreen = new ScoresScreen(this);
        setScreen(mainMenuScreen);
    }
    @Override
    public void resize( int width, int height ) {
        super.resize( width, height );
        ViewWidth = width/50f;
        ViewHeight = height/50f;
        Gdx.app.log( ZebGame.LOG, "Resizing game to: " + width + " x " + height );
    }

    @Override
    public void render() {
        super.render();
        fpsLogger.log(); //outputs Frame rate
    }

    @Override
    public void pause() {
        super.pause();
        Gdx.app.log( ZebGame.LOG, "Pausing game" );
    }

    @Override
    public void resume() {
        super.resume();
        Gdx.app.log( ZebGame.LOG, "Resuming game" );
    }

    @Override
    public void setScreen(Screen screen) {
        super.setScreen( screen );
        Gdx.app.log( ZebGame.LOG, "Setting screen: " + screen.getClass().getSimpleName() );
    }

    @Override
    public void dispose() {
        super.dispose();
        Gdx.app.log( ZebGame.LOG, "Disposing game" );
    }
}
