package com.jfish.Zeb.Objects;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.jfish.Zeb.Assets;
import com.jfish.Zeb.Health;

public class Player extends GameObject {
    private Sprite player;
    public Health health;
    public boolean isAlive=true;

    public Player(Sprite sprite, float x, float y, float radius) {
        super(x, y, radius);
        player=sprite;
        health=new Health(6,.6f,100);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.enableBlending();
        player.setBounds(0, 0, Assets.scale, Assets.scale);
        player.setOrigin(.5f * Assets.scale, .5f * Assets.scale);
        player.setPosition(x, y);
        player.translate(-.5f,-.5f);
        player.setRotation(angle* MathUtils.radiansToDegrees);
        player.draw(batch);
    }

    public void update() {
        //setPostions(getX() * Assets.scale, getY() * Assets.scale);
        //setRadius(getRadius() * Assets.scale);
    }
}
