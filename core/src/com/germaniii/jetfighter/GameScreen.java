package com.germaniii.jetfighter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen extends ScreenAdapter {
    JetFighter game;

    boolean is_running = false;
    int player1_score = 0, player2_score = 0;

    GameScreen(JetFighter game){
        this.game = game;
    }

    @Override
    public void show(){
        // This are event driven inputs and can be accessed anytime (like interrupts)
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.ESCAPE)
                    game.setScreen(new EndScreen(game));
                return true;
            }
        });

    }

    @Override
    public void render(float delta){
        // Background Render
        Gdx.gl.glClearColor(.25f, .25f, .25f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (is_running){


        }

        // Render Segment
        game.batch.begin();
        game.font.draw(game.batch, "Black", game.screenWidth * 3/12, game.screenHeight * 14/15);
        game.font.draw(game.batch, Integer.toString(player1_score), game.screenWidth * 1/4, game.screenHeight * 9/10);
        game.font.draw(game.batch, "White", game.screenWidth * 9/12, game.screenHeight * 14/15);
        game.font.draw(game.batch, Integer.toString(player2_score), game.screenWidth * 3/4, game.screenHeight * 9/10);
        game.batch.end();

    }

    @Override
    public void hide(){

    }
}
