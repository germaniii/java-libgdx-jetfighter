package com.germaniii.jetfighter.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.germaniii.jetfighter.JetFighter;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "German III's Jet Fighter";
		config.height = 600;
		config.width = 800;
		new LwjglApplication(new JetFighter(), config);
	}
}
