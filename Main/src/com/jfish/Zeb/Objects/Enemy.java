package com.jfish.Zeb.Objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.jfish.Zeb.Assets;
import com.jfish.Zeb.Health;

public class Enemy extends GameObject{
    private Sprite enemy;
    public Health health;
    public float speed;
    public float attackTime;

    public Enemy(Sprite sprite, float x, float y, float radius, float speed) {
        super(x, y, radius);
        enemy=sprite;
        this.speed=speed;
        health=new Health(1f,.2f,100);
    }

    public void render(SpriteBatch batch) {
        batch.enableBlending();
        enemy.setBounds(0,0,Assets.scale,Assets.scale);
        enemy.setOrigin(.5f*Assets.scale,.5f*Assets.scale);
        enemy.setPosition(x, y);
        enemy.translate(-.5f, -.5f);
        enemy.setRotation(angle);
        enemy.draw(batch);
        if(health.heal<100)
            health.render(batch,x-.5f,y+.4f);
    }

    public void update() {
        setPostions(getX() * Assets.scale, getY() * Assets.scale);
        setRadius(getRadius() * Assets.scale);
    }
    public void add(Vector3 temp,float deltaTime) {
        Vector3 targetVelocity = temp.sub(getX(), getY(), 0).nor();
        targetVelocity.scl(speed);
        setX(x+=targetVelocity.x*deltaTime);
        setY(y+=targetVelocity.y*deltaTime);
        angle = MathUtils.atan2(targetVelocity.y, targetVelocity.x)*MathUtils.radiansToDegrees;
    }

    public void attack(float deltaTime) {
        attackTime+=deltaTime;
    }
}
