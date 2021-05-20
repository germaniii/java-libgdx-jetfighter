package com.germaniii.jetfighter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;

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
        });

    }

    @Override
    public void render(float delta){


        game.batch.begin();
        game.font.draw();
        game.batch.end();
    }

    @Override
    public void hide(){

    }

}
