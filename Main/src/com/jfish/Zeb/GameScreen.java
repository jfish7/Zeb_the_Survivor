package com.jfish.Zeb;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.jfish.Zeb.Objects.Bullet;
import com.jfish.Zeb.Objects.Enemy;
import com.jfish.Zeb.Objects.Player;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class GameScreen implements Screen {
	private ZebGame game;
    private final SpriteBatch batch;
    private Player player;
    private List<Bullet> bullets;
    private List<Enemy> enemies;
    OrthographicCamera GameCamera;
    OrthographicCamera HealthCamera;
    float gameTime=0;
    boolean pause=false;

	public GameScreen(ZebGame game) {
		this.game = game;
        batch=new SpriteBatch();
        GameCamera=new OrthographicCamera(ZebGame.ViewWidth/2, ZebGame.ViewHeight/2);
        GameCamera=CameraHelper.render(GameCamera);
        HealthCamera=new OrthographicCamera(ZebGame.ViewWidth/2, ZebGame.ViewHeight/2);
        HealthCamera=CameraHelper.render(HealthCamera);
        showScores.score=0;
        player=new Player(Assets.player, ZebGame.ViewWidth/2,ZebGame.ViewHeight/2,.5f * Assets.scale);
        bullets=new ArrayList<Bullet>();
        enemies=new ArrayList<Enemy>();
        addEnemy();
	}

    @Override
    public void render (float deltaTime) {
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameTime+=deltaTime;
        GameCamera=CameraHelper.render(GameCamera, player.x, player.y);
        batch.setProjectionMatrix(GameCamera.combined);

        batch.begin();
        batch.draw(Assets.background,0,0,ZebGame.ViewWidth,ZebGame.ViewHeight);

        player.render(batch);
        for(Enemy enemy: enemies) {
            enemy.speed=((float)showScores.score/70f)+.75f;
            if(player.isAlive)
                enemy.add(new Vector3(player.x,player.y, 0),deltaTime);
            enemy.render(batch);
        }

        if(player.isAlive) {
        if(Gdx.input.isTouched()) {
            Vector3 touchPos=new Vector3(Gdx.input.getX(), Gdx.input.getY(),0);
            GameCamera.unproject(touchPos);
            Vector3 bulletVelocity = touchPos.sub(player.x,player.y,0).nor();
            player.angle = MathUtils.atan2(bulletVelocity.y, bulletVelocity.x);
        }

        if(Gdx.input.justTouched()) {
            bullets.add(new Bullet(Assets.bullet, player.x, player.y, .075f, player.angle));
        }}

        try{
        for(Bullet bullet:bullets) {
            bullet.add(deltaTime);
            bullet.render(batch);

            for(Enemy enemy:enemies) {
                if(Intersector.overlaps(new Circle(bullet.moveX,bullet.moveY,bullet.getRadius()), enemy.postions)) {
                    enemy.health.heal-=20;
                    bullets.remove(bullet);
                    if(enemy.health.heal<=0){
                        enemies.remove(enemy);
                        showScores.score+=10;
                    }
                }
            }
            if(bullet.checkBounds(ZebGame.ViewWidth,ZebGame.ViewHeight)) {
                bullets.remove(bullet);
            }
        }}
        catch (ConcurrentModificationException e) {
            //nothing
        }

        for(Enemy enemy:enemies) {
            enemy.attack(deltaTime);
            if(enemy.attackTime>.4) {
                if(Intersector.overlaps(enemy.postions,player.postions)) {
                    player.health.heal-=8;
                }
                enemy.attackTime=0;
            }
        }
        if(gameTime>4 && player.isAlive) {
            addEnemy();
            gameTime=0;
        }
        if(player.health.heal<=0) {
            player.isAlive=false;
        }
        if(!player.isAlive && !pause) {
            game.setScreen(new PauseScreen(game, this, batch));
            pause=true;
        }

        if(player.isAlive)
            player=InputHandler.update(player);
        batch.end();
        batch.flush();
        batch.begin();
        batch.setProjectionMatrix(HealthCamera.combined);
        batch.draw(Assets.healthBar,0,ZebGame.ViewHeight/2-.6f*Assets.scale,6 * Assets.scale,.6f * Assets.scale);
        if(player.isAlive) {
            player.health.render(batch,0,ZebGame.ViewHeight/2-.6f * Assets.scale);
        }
        showScores.setScore();
        showScores.drawScores(batch, ZebGame.ViewWidth/2- (.5f * Assets.scale),
                ZebGame.ViewHeight/2-.6f*Assets.scale);
        batch.end();
    }
    public void addEnemy() {
        float x= (float) (Math.random()*ZebGame.ViewWidth);
        float y= (float) (Math.random()*ZebGame.ViewHeight);

        enemies.add(new Enemy(Assets.enemy, x,y,.5f * Assets.scale, .75f));
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

	}

	@Override
	public void resume () {
	}

	@Override
	public void show () {
	}
}