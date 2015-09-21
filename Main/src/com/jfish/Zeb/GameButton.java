package com.jfish.Zeb;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class GameButton {
    Sprite button;
    Array <Vector2> postions;
    public GameButton(Sprite sprite) {
        this.button=sprite;
        postions=new Array<Vector2>();
        postions.add(new Vector2(sprite.getX(),sprite.getY()));
        postions.add(new Vector2(sprite.getX()+sprite.getWidth(),sprite.getY()));
        postions.add(new Vector2(sprite.getX()+sprite.getWidth(),sprite.getY()+sprite.getHeight()));
        postions.add(new Vector2(sprite.getX(),sprite.getY()+sprite.getHeight()));
    }
    public GameButton(Sprite sprite, float x, float y, float width, float height) {
        sprite.setBounds(x, y, width, height);
        this.button=sprite;
        postions=new Array<Vector2>();
        postions.add(new Vector2(sprite.getX(),sprite.getY()));
        postions.add(new Vector2(sprite.getX()+sprite.getWidth(),sprite.getY()));
        postions.add(new Vector2(sprite.getX()+sprite.getWidth(),sprite.getY()+sprite.getHeight()));
        postions.add(new Vector2(sprite.getX(),sprite.getY()+sprite.getHeight()));
    }

    public Sprite update(Sprite sprite) {
        button.setBounds(sprite.getX() * Assets.scale, sprite.getY() * (Assets.scale - Assets.yOffset),
                sprite.getWidth() * Assets.scale, sprite.getHeight() * Assets.scale);
        return sprite;
    }

    public Sprite onTouch(Sprite sprite) {
        button.setBounds(sprite.getX() -.1f * Assets.scale, sprite.getY() -.1f * Assets.scale,
                sprite.getWidth() +.2f * Assets.scale, sprite.getHeight() +.2f * Assets.scale);
        return sprite;
    }
}
