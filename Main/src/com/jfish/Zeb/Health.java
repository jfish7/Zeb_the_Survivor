package com.jfish.Zeb;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Health {
    public Sprite health;
    public float heal;
    public float width;
    public float height;

    public Health(float width, float height, float heal) {
        this.width=width;
        this.height=height;
        this.heal=heal;
        health=new Sprite(Assets.heal);
    }

    public void render(SpriteBatch batch, float x, float y) {
        batch.enableBlending();
        health.setPosition(x, y);
        health.setU2(heal/100);
        health.setBounds(x, y, width* heal/100 * Assets.scale, height * Assets.scale);
        health.draw(batch);
    }
}
