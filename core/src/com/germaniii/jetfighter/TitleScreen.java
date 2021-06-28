package com.germaniii.jetfighter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class TitleScreen extends ScreenAdapter{
    JetFighter game;

    TitleScreen(JetFighter game){
        this.game = game;
    }

    @Override
    public void show(){
        // This are event driven inputs and can be accessed anytime (like interrupts)
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.SPACE)
                    game.setScreen(new GameScreen(game));
                return true;
            }

            @Override
            public boolean touchDown(int x, int y, int pointer, int button){
                game.setScreen(new GameScreen(game));
                return true;
            }
        });


    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(.20f, .20f, .20f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        game.font.draw(game.batch, "German III's Jet Fighter", game.screenWidth * 4/10, game.screenHeight * 7/8);
        game.font.draw(game.batch, "W, A, S, D for Player 1", game.screenWidth * 4/10, game.screenHeight * 5/8);
        game.font.draw(game.batch, "Up, Down, Left, Right for Player 2", game.screenWidth * 4/10, game.screenHeight * 4/8);
        game.font.draw(game.batch, "Press Space to Fight!", game.screenWidth * 4/10, game.screenHeight * 2/8);
        game.batch.end();
    }

    @Override
    public void hide(){

    }

}
