package com.jfish.Zeb;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopZeb {
    public static void main(String args[]) {
        LwjglApplicationConfiguration cfg=new LwjglApplicationConfiguration();
        //cfg.addIcon("character.png", Files.FileType.Absolute);
        cfg.title="Zeb: The Survivor";
        cfg.useGL20=false;
        cfg.width=800;
        cfg.height=480;
        new LwjglApplication(new ZebGame(), cfg);
    }
}
