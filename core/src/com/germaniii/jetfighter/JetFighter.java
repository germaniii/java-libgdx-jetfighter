package com.germaniii.jetfighter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class JetFighter extends Game {
	ShapeRenderer shape;
	BitmapFont font;
	SpriteBatch batch;
	
	@Override
	public void create () {
		shape = new ShapeRenderer();
		font = new BitmapFont();
		batch = new SpriteBatch();
		setScreen(new TitleScreen(this));
	}

	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
		shape.dispose();
	}
}
