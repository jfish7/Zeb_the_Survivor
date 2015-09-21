package com.jfish.Zeb;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.jfish.Zeb.Objects.GameObject;
import com.jfish.Zeb.Objects.Player;

public class InputHandler {
    public InputHandler() {

    }

    public static GameObject update(GameObject sprite) {

        return sprite;
    }

    public static Player update(Player player) {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)||Gdx.input.isKeyPressed(Input.Keys.A)) {
            if(player.x - player.radius/2 > 0)
                player.setX(player.x-=.08f * Assets.scale);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)||Gdx.input.isKeyPressed(Input.Keys.D)) {
            if(player.x + player.radius/2 < ZebGame.ViewWidth)
                player.setX(player.x+=.08f * Assets.scale);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)||Gdx.input.isKeyPressed(Input.Keys.W)) {
            if(player.y + player.radius/2 < ZebGame.ViewHeight)
                player.setY(player.y+=.08f * (Assets.scale-Assets.yOffset));
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)||Gdx.input.isKeyPressed(Input.Keys.S)) {
            if(player.y - player.radius/2 > 0)
                player.setY(player.y-=.08f * Assets.scale);
        }
        return player;
    }
}
