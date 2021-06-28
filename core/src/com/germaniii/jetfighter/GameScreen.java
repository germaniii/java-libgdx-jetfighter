package com.germaniii.jetfighter;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.germaniii.jetfighter.gameobjects.Fighter;

public class GameScreen extends ScreenAdapter {
    JetFighter game;
    Fighter jet1, jet2;
    ShapeRenderer shapeRenderer = new ShapeRenderer();

    boolean is_running = false;
    int player1_score = 0, player2_score = 0;
    float delta;

    Vector3 touchPoint;

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

        jet1 = new Fighter(game.screenWidth * 3/12, game.screenHeight * 8/15);
        jet2 = new Fighter(game.screenWidth * 9/12, game.screenHeight * 8/15);

        touchPoint = new Vector3();
    }

    @Override
    public void render(float delta){
        this.delta = delta;
        // Background Render
        Gdx.gl.glClearColor(.25f, .25f, .25f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        inputHandler(delta);

        if (is_running){

        }

        // Render Segment
        game.batch.begin();
        game.font.draw(game.batch, "Black", game.screenWidth * 3/12, game.screenHeight * 14/15);
        game.font.draw(game.batch, Integer.toString(player1_score), game.screenWidth * 1/4, game.screenHeight * 9/10);
        game.font.draw(game.batch, "White", game.screenWidth * 9/12, game.screenHeight * 14/15);
        game.font.draw(game.batch, Integer.toString(player2_score), game.screenWidth * 3/4, game.screenHeight * 9/10);
        game.batch.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(0,0, 0, 1);
        shapeRenderer.circle(jet1.getX(), jet1.getY(), jet1.getRad());
        shapeRenderer.setColor(1,1, 1, 1);
        shapeRenderer.circle(jet2.getX(), jet2.getY(), jet2.getRad());
        shapeRenderer.end();

    }

    @Override
    public void hide(){
        shapeRenderer.dispose();
        game.batch.dispose();
    }

    private void inputHandler(float delta){
        /* ----------------------------------------------------------------------------------------
		*	Input Handling
		 ----------------------------------------------------------------------------------------*/
        // Keyboard Player 1
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            jet1.incrementY(delta);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            jet1.decrementY(delta);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            jet1.incrementX(delta);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            jet1.decrementX(delta);
        }

        //Android Touch
        for(int i = 0; i < 20; i++){
            if(Gdx.input.isTouched(i)) {
                // Player 1
                if ((Gdx.input.getX(i) < game.screenWidth * 1 / 4 && Gdx.input.getX(i) > game.screenWidth * 0 / 4 ) && Gdx.input.getY(i) > game.screenHeight / 2) {
                    jet1.decrementX(delta);
                    jet1.decrementY(delta);
                }
                if ((Gdx.input.getX(i) < game.screenWidth * 2 / 4 && Gdx.input.getX(i) > game.screenWidth * 1 / 4 )  && Gdx.input.getY(i) > game.screenHeight / 2) {
                    jet1.incrementX(delta);
                    jet1.decrementY(delta);
                }
                if ((Gdx.input.getX(i) < game.screenWidth * 2 / 4 && Gdx.input.getX(i) > game.screenWidth * 1 / 4 )  && Gdx.input.getY(i) < game.screenHeight / 2) {
                    jet1.incrementX(delta);
                    jet1.incrementY(delta);
                }
                if ((Gdx.input.getX(i) < game.screenWidth * 1 / 4 && Gdx.input.getX(i) > game.screenWidth * 0 / 4 )  && Gdx.input.getY(i) < game.screenHeight / 2) {
                    jet1.decrementX(delta);
                    jet1.incrementY(delta);
                }

                if(Gdx.input.getX(i) == game.screenWidth * 1/4 && Gdx.input.getY(i) == game.screenHeight /2){
                    //shoot some shit jet 1
                }

                //Player 2
                if ((Gdx.input.getX(i) < game.screenWidth * 3 / 4 && Gdx.input.getX(i) > game.screenWidth * 2 / 4 ) && Gdx.input.getY(i) > game.screenHeight / 2) {
                    jet2.decrementX(delta);
                    jet2.decrementY(delta);
                }
                if ((Gdx.input.getX(i) < game.screenWidth * 4 / 4 && Gdx.input.getX(i) > game.screenWidth * 3 / 4 )  && Gdx.input.getY(i) > game.screenHeight / 2) {
                    jet2.incrementX(delta);
                    jet2.decrementY(delta);
                }
                if ((Gdx.input.getX(i) < game.screenWidth * 4 / 4 && Gdx.input.getX(i) > game.screenWidth * 3 / 4 )  && Gdx.input.getY(i) < game.screenHeight / 2) {
                    jet2.incrementX(delta);
                    jet2.incrementY(delta);
                }
                if ((Gdx.input.getX(i) < game.screenWidth * 3 / 4 && Gdx.input.getX(i) > game.screenWidth * 2 / 4 )  && Gdx.input.getY(i) < game.screenHeight / 2) {
                    jet2.decrementX(delta);
                    jet2.incrementY(delta);
                }

                if(Gdx.input.getX(i) == game.screenWidth * 3/4 && Gdx.input.getY(i) == game.screenHeight /2){
                    //shoot some shit jet 2
                }
            }
        }

        // Keyboard Player 2
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            jet2.incrementY(delta);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            jet2.decrementY(delta);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            jet2.incrementX(delta);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            jet2.decrementX(delta);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
            game.setScreen(new EndScreen(game));

    }

    public float getDelta(){
        return delta;
    }
}
