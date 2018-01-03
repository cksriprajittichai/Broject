package com.game.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick(){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
		
	}
	
	public void render(Graphics g){
		for (int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void clearEnemys() {
		int numEnemies = object.size();
		for (int i = 0, x = 0; i < numEnemies; i++){
			GameObject tempObject = object.get(x);
			
			if (tempObject.getId() != ID.Player) {
				removeObject(tempObject);
			} else x++;
		}	
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
}
