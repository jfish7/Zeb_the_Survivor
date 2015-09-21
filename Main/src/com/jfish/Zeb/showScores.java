package com.jfish.Zeb;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class showScores {
    public static int score=0;
    private static String show;

    public static void setScore() {
        show=""+score;
    }

    public static void drawScores(SpriteBatch batch, float x, float y) {
        batch.enableBlending();
        for(int i=0; i<show.length(); i++) {
        switch (show.charAt(show.length()-1-i)) {
            case '0': batch.draw(Assets.zero, x - (.27f * i * Assets.scale), y, .4996f * Assets.scale, .5f * Assets.scale);
                break;
            case '1': batch.draw(Assets.one, x - (.27f * i * Assets.scale), y, .5f * Assets.scale, .5f * Assets.scale);
                break;
            case '2': batch.draw(Assets.two, x - (.27f * i * Assets.scale), y, .5f * Assets.scale, .5f * Assets.scale);
                break;
            case '3': batch.draw(Assets.three, x - (.27f * i * Assets.scale), y, .5004f * Assets.scale, .5f * Assets.scale);
                break;
            case '4': batch.draw(Assets.four, x - (.27f * i * Assets.scale), y, .5004f * Assets.scale, .5f * Assets.scale);
                break;
            case '5': batch.draw(Assets.five,  x - (.27f * i * Assets.scale), y, .5004f * Assets.scale, .5f * Assets.scale);
                break;
            case '6': batch.draw(Assets.six,  x - (.27f * i * Assets.scale), y, .501f * Assets.scale, .5f * Assets.scale);
                break;
            case '7': batch.draw(Assets.seven,  x - (.27f * i * Assets.scale), y, .5f * Assets.scale, .5f * Assets.scale);
                break;
            case '8': batch.draw(Assets.eight,  x - (.27f * i * Assets.scale), y, .5004f * Assets.scale, .5f * Assets.scale);
                break;
            case '9': batch.draw(Assets.nine, x - (.27f * i * Assets.scale), y, .5004f * Assets.scale, .5f * Assets.scale);
                break;
        }}
    }
}
