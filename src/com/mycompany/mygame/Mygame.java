package com.mycompany.mygame;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;
import java.util.*;

public class Mygame extends ApplicationAdapter {
    ShapeRenderer shape;
	Paddle paddle;
	Ball ball;
	
    @Override
    public void create () {
		shape = new ShapeRenderer();
		paddle = new Paddle(0f,100f,30f);
		ball = new Ball(50,50,50,5,5);
    }

    @Override
    public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		ball.checkCollision(paddle);
		ball.update();
		paddle.update();
		shape.begin(ShapeRenderer.ShapeType.Filled);
		ball.draw(shape);
		paddle.draw(shape);
		shape.end();
	}
}

