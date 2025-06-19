package com.mycompany.mygame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.*;
import java.util.*;

public class Ball {
    float x;
    float y;
    float size;
    float xSpeed;
    float ySpeed;
	
    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public void update() {
        x += xSpeed;
        y += ySpeed;
        if (x < 50 || x > Gdx.graphics.getWidth()-50) {
            xSpeed = -xSpeed;
        }
        if (y < 50 || y > Gdx.graphics.getHeight()-50) {
            ySpeed = -ySpeed;
        }
    }
    public void draw(ShapeRenderer shape) {
        shape.circle(x, y, size);
	}
	private boolean collision(Paddle pad){
	 	float ballLeft = this.x - this.size;
		float ballRight = this.x + this.size;
		float ballTop = this.y + this.size;
		float ballBottom = this.y - this.size;
		float paddleLeft = pad.x;
		float paddleBottom = pad.y;
		float paddleRight = pad.x + pad.width;
		float paddleTop = pad.y+ pad.height;
		
	return ballLeft< paddleRight &&
	   	   ballRight> paddleLeft &&
		   ballTop > paddleBottom &&
		   ballBottom < paddleTop;
	}
	public void checkCollision(Paddle pad){
		if(collision(pad)){
			ySpeed= -ySpeed;
			y =pad.y + pad.height+size;
		}
	}
}
