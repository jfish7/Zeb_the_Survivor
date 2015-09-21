package com.jfish.Zeb.Objects;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.jfish.Zeb.Assets;

public class Bullet extends GameObject {
    private Sprite bullet;
    public static float speed=20f;
    public float moveX;
    public float moveY;

    public Bullet(Sprite sprite, float x, float y, float radius, float angle) {
        super(x, y, radius);
        bullet=sprite;
        this.angle=angle;
    }
    public void render(SpriteBatch batch) {
        batch.enableBlending();
        bullet.setOrigin(0,0);
        bullet.setBounds(0f,0f,.15f*Assets.scale,.15f*Assets.scale);
        moveX=(x+(MathUtils.cos((angle-45))/4f) * Assets.scale);
        moveY=(y+(MathUtils.sin((angle-45))/4f) * Assets.scale);
        bullet.setPosition(moveX, moveY);
        bullet.setRotation(angle);
        bullet.draw(batch);
    }
    public void update() {
        setPostions(getX() * Assets.scale, getY() * Assets.scale);
        setRadius(getRadius()* Assets.scale);
    }

    public void add(float deltaTime) {
        setX(x+= MathUtils.cos(angle) * speed * deltaTime);
        setY(y+= MathUtils.sin(angle) * speed * deltaTime);
    }

    public boolean checkBounds(float frustrum_width, float frustrum_height) {
        if(x>frustrum_width+1.0f||x<-1.0f||
                y>frustrum_height+1.0f||y<-1.0f)
            return true;
        else
            return false;
    }
}
