package com.mycompany.mygame;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.graphics.GL20;
import java.util.*;

public class Block
{
	float x,y;
	float width,height;

	public Block(float x,float y,float width,float height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void draw(ShapeRenderer shape){
		shape.rect(x,y,width,height);
	}
	
	public boolean Collision(Ball ball){
		float ballLeft = ball.x - ball.size;
		float ballRight = ball.x + ball.size;
		float ballTop = ball.y + ball.size;
		float ballBottom = ball.y - ball.size;
		float blockLeft = x;
		float blockBottom = y;
		float blockRight = x + width;
		float blockTop = y+ height;
		
		return ballLeft< blockRight &&
			ballRight> blockLeft &&
			ballTop > blockBottom &&
			ballBottom < blockTop;
	}
}
