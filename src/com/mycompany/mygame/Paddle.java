package com.mycompany.mygame;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.glutils.*;

public class Paddle
{
	float x,y;
	float width,height;
	
	public Paddle(float y,float width,float height){
		this.x = Gdx.graphics.getWidth()/2;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void update(){
		x = Gdx.input.getX()-width/2;
	}
	
	public void draw(ShapeRenderer shape){
		shape.rect(x,y,width,height);
	}
}
