package com.jfish.Zeb;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sun.deploy.uitoolkit.impl.text.TextUIToolkit;

public class Assets {
    public static final float textWidth=0.06225680933852140077821011673152f;
    public static TextureRegion background;
    public static TextureRegion projectile;
    public static Texture character;
    public static Texture enemy1;
    public static TextureRegion heal;
    public static Texture healthBar;
    public static Texture menu;
    public static Texture pauseBackground;
    public static Texture play;
    public static Texture restart;
    public static Texture title;

    public static Texture numSheet;
    public static TextureRegion zero;
    public static TextureRegion one;
    public static TextureRegion two;
    public static TextureRegion three;
    public static TextureRegion four;
    public static TextureRegion five;
    public static TextureRegion six;
    public static TextureRegion seven;
    public static TextureRegion eight;
    public static TextureRegion nine;

    public static Sprite bullet;
    public static Sprite enemy;
    public static Sprite menuButton;
    public static Sprite playButton;
    public static Sprite player;
    public static Sprite restartButton;

    public static float scale;
    public static float yOffset;

    public static void load () {
        loadTextures();
        loadSprites();
    }

    private static void loadTextures () {
        setScale(ZebGame.ViewWidth, ZebGame.ViewHeight);
        System.out.println(scale);
        background=new TextureRegion(new Texture("background.png"),0,0,512,512*(int)(ZebGame.ViewWidth/ ZebGame.ViewHeight));
        projectile=new TextureRegion(new Texture("atlas.png"),0.0f,0.5f,.25f,.75f);
        character=new Texture("character.png");
        enemy1=new Texture("enemy1.png");
        heal=new TextureRegion(new Texture("health.png"),0.0f,0.0f,1,1);
        healthBar=new Texture("healthBar.png");
        menu=new Texture("menu.png");
        pauseBackground=new Texture("pauseScreen.png");
        play=new Texture("play.png");
        restart=new Texture("restart.png");
        title=new Texture("Title.png");
        System.out.println(ZebGame.ViewWidth+" "+ZebGame.ViewHeight);

        numSheet=new Texture("numberSheet.png");
        zero=new TextureRegion(numSheet, .002f, 0, Assets.textWidth - .002f, 1f);
        one=new TextureRegion(numSheet, Assets.textWidth + .002f, 0, Assets.textWidth * 2 - .002f, 1f);
        two=new TextureRegion(numSheet, Assets.textWidth * 2 + .002f, 0, Assets.textWidth * 3 - .002f, 1f);
        three=new TextureRegion(numSheet, Assets.textWidth * 3 + .002f, 0, Assets.textWidth * 4 - .002f, 1f);
        four=new TextureRegion(numSheet, Assets.textWidth * 4 + .002f, 0, Assets.textWidth * 5 - .002f, 1f);
        five=new TextureRegion(numSheet, Assets.textWidth * 5 + .002f, 0, Assets.textWidth * 6 - .002f, 1f);
        six=new TextureRegion(numSheet, Assets.textWidth * 6 + .002f, 0, Assets.textWidth * 7 - .002f, 1f);
        seven=new TextureRegion(numSheet, Assets.textWidth * 7 + .002f, 0, Assets.textWidth * 8 - .002f, 1f);
        eight=new TextureRegion(numSheet, Assets.textWidth * 8 + .002f, 0, Assets.textWidth * 9 - .002f, 1f);
        nine=new TextureRegion(numSheet, Assets.textWidth * 9 + .002f, 0, Assets.textWidth * 10 - .002f, 1f);
    }

    private static void loadSprites() {
        player=new Sprite(character);
        enemy=new Sprite(enemy1);
        bullet=new Sprite(projectile);
        menuButton=new Sprite(menu);
        playButton=new Sprite(play);
        restartButton=new Sprite(restart);
    } 
    public static void setScale(float viewWidth, float viewHeight) {
        scale=(viewWidth/viewHeight)/(16/9.6f)*(viewHeight/9.6f);
        yOffset=((viewHeight-9.6f)/9.6f);
        if(yOffset!=0)
            yOffset=1-yOffset;
        System.out.println(yOffset);
    }
}
