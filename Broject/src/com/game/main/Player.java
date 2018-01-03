package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{

	Random r = new Random();
	Handler handler;
	
	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id); 
		this.handler = handler;
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 37);
		y = Game.clamp(y, 0, Game.HEIGHT - 60);
		
		// handler.addObject(new Trail(x, y, ID.Trail, Color.white, 32, 32, 0.05f, handler));

		collision();
		
	}
	
	private void collision() {
		ID id;
		for (int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			id = tempObject.getId();
			if (id != ID.Player && id != ID.Trail) {
				if (getBounds().intersects(tempObject.getBounds())) {
					// collision code
					HUD.HEALTH -= 2;
				}
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int) x, (int) y, 32, 32);
	}
}
