package com.jfish.Zeb.Objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.jfish.Zeb.Assets;

public abstract class GameObject {
    public Circle postions;
    public float x;
    public float y;
    public float radius;
    public float angle;

    public GameObject(float x, float y, float radius) {
        this.x=x;
        this.y=y;
        this.radius=radius * Assets.scale;
        this.postions=new Circle(x, y, radius);
    }

    public abstract void render(SpriteBatch batch);
    public abstract void update();

    public void setX(float x) {
        postions.x=x;
    }
    public void setY(float y) {
        postions.y=y;
    }
    public void setPostions(float x, float y) {
        postions.set(x, y, this.radius);
    }
    public void setRadius(float radius) {
        this.radius=radius;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public float getRadius() {return radius;}
}
