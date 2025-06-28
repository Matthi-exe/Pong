package com.mycompany.mygame;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;
import java.util.*;
import com.badlogic.gdx.audio.*;

public class Mygame extends ApplicationAdapter {
    ShapeRenderer shape;
	Paddle paddle;
	Ball ball;
	ArrayList<Block>blocks = new ArrayList<>();
	Music music;
	
    @Override
    public void create () {
	 
		shape = new ShapeRenderer();
		paddle = new Paddle(0f,100f,30f);
		ball = new Ball(50,50,20,5,5);
		float blockWidth = 150f;
		float blockHeight = 50f;
	  for(int x=0;x<Gdx.graphics.getWidth();x+=blockWidth+10){
		  for(int y = Gdx.graphics.getHeight()/2; y<Gdx.graphics.getHeight();y+=blockHeight+10){
			  blocks.add(new Block(x,y,blockWidth,blockHeight));
			  music.play();
		  }
	  }
    }

    @Override
    public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		ball.checkCollision(paddle);
		ball.update();
		paddle.update();
		for(int i=0;i<blocks.size();i++){
			Block b = blocks.get(i);
			if(b.Collision(ball)){
				blocks.remove(b);
				ball.ySpeed = - ball.ySpeed;
			}
		}
		shape.begin(ShapeRenderer.ShapeType.Filled);
		ball.draw(shape);
		paddle.draw(shape);
		for(Block b : blocks){
			b.draw(shape);
		}
		shape.end();
	}
}

