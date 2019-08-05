package Pack1;

import javafx.scene.shape.Circle;

public class Ball 
{
	Circle model;
	double position[];
	double speed[];
	double gravity[];
	double radius;
	double bouncy;
	double bounds[];
	
	public Ball()
	{
		model = new Circle(0, 0, 10);
		position = new double[] {0, 0};
		speed = new double[] {0, 0};
		gravity = new double[] {0, 0};
		radius = 10;
		bouncy = 0.0;
		bounds = new double[] {0, 0};
	}
	
	public Ball(Circle model, double[] speed, double[] gravity, double bouncy, double[] bounds)
	{
		this.model = model;
		this.position = new double[] {model.getCenterX(), model.getCenterY()};
		this.speed = speed;
		this.gravity = gravity;
		this.radius = model.getRadius();
		this.bouncy = bouncy;
		this.bounds = bounds;
	}
	
	public void checkCollision() {
		if (position[0] - radius < 0)
		{
			position[0] = radius;
			speed[0] *= -1 * bouncy;
		}
		
		if (position[0] + radius > bounds[0])
		{
			position[0] = bounds[0] - radius;
			speed[0] *= -1 * bouncy;
		}
		
		if (position[1] - radius < 0)
		{
			position[1] = radius;
			speed[1] *= -1 * bouncy;
		}
		
		if (position[1] + radius > bounds[1])
		{
			position[1] = bounds[1] - radius;
			speed[1] *= -1 * bouncy;
		}
	}
	
	public void update() {
		
		speed[0] += gravity[0];
		speed[1] += gravity[1];
		
		
		position[0] += speed[0];
		position[1] += speed[1];
		
		
		checkCollision();
		
		model.setCenterX(position[0]);
		model.setCenterY(position[1]);
	}
}
