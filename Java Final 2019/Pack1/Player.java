package Pack1;


import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;


public class Player 
{
	Circle model;
	boolean jumping;
	double position;
	double speed;
	double strength;
	double gravity;
	double ground;
	AnimateSprite playersprite;
	
	public Player()
	{
		model = new Circle(0, 0, 10);
		jumping = false;
		speed = 0.0;
		strength = 0.0;
		gravity = 0.0;
		ground = 0.0;
		position = 0.0;	
		
	}
	
	public Player(Circle model, double strength, double gravity, double ground, AnimateSprite playersprite)
	{
		this.model = model;
		this.strength = strength;
		this.ground = ground;
		this.gravity = gravity;
		this.position = ground - model.getRadius();    
		this.playersprite = playersprite;
		
	}
	
	public void jump()
	{
		if (!jumping)
		{
			speed = strength * -1;
			jumping = true;
		}
	}
	
	public void update() 
	{
		if (jumping)
		{
			speed += gravity;
			position += speed;
			
			if (position > ground - model.getRadius())
			{
				speed = 0.0;
				jumping = false;
				position = ground - model.getRadius();
			}
		}
		
		model.setCenterY(position);
		playersprite.move(model.getCenterX(), position);
	}
}
