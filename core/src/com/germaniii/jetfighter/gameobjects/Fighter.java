package com.germaniii.jetfighter.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.CircleShape;

public class Fighter{
    float x, y, rad;
    float speedX, speedY;
    float planeHeight, planeWidth;

    public Fighter(float x, float y) {
        this.x = x;
        this.y = y;
        planeHeight = 100;
        planeWidth = 100;
        speedX = 100;
        speedY = 100;
        rad = 25.f;
    }

    public void incrementX(float delta){
        this.x += speedX * delta;
    }

    public void incrementY(float delta){
        this.y += speedY * delta;
    }

    public void decrementX(float delta){
        this.x -= speedX * delta;
    }

    public void decrementY(float delta){
        this.y -= speedY * delta;
    }

    public float getRad(){
        return rad;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getSpeedX() {
        return speedX;
    }

    public float getSpeedY() {
        return speedY;
    }
}
