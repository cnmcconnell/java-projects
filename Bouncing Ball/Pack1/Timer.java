package Pack1;


import javafx.animation.AnimationTimer;

public class Timer extends AnimationTimer 
{
	Ball ball;
	
	public Timer(Ball ball)
	{
		this.ball = ball;
	}
	
	public void handle()
	{
		
	}
	
	public void handle(long now)
	{
		ball.update();
	}
	
}
