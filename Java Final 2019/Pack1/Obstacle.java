package Pack1;


import javafx.scene.shape.Circle;

public class Obstacle 
{
	Circle model;
	double speed;
	double startspeed;
	double position;
	double ground;
	AnimateSprite scorpion;
	boolean done;
	
	public Obstacle() 
	{
		model = new Circle(0, 0, 10);
		speed = 0.0;
		startspeed = 0.0;
		position = 0.0;
		ground = 0.0;
		done = true;			
	}
	
	public Obstacle(double radius, double speed, double ground, AnimateSprite scorpion)
	{
		this.model = new Circle(ground, 435 - radius, radius);
		this.speed = speed;
		this.startspeed = speed;
		this.ground = ground;
		this.position = ground - model.getRadius();	
		this.scorpion = scorpion;
		this.done = false;
	}
	
	public void update()
	{
		if (!done)
		{
			position -= speed;
			model.setCenterX(position);
			if (position + model.getRadius() < 0)
			{
				done = true;
			}
			
		}
		scorpion.move(position, model.getCenterY() - 10);
	}
	
	public void reset()
	{
		done = false;
		speed = startspeed;
		position = ground - model.getRadius();
		model.setCenterX(position);
		
	}
}
