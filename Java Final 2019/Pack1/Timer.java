package Pack1;

import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;


public class Timer extends AnimationTimer 
{
	Obstacle obstacle;
	Player player;
	Label scorecount;
	Label score;
	Label over;
	int cntspeed = 0;
	int cnt = 0; 
	
	public Timer(Obstacle obstacle, Player player, Label scorecount, Label score, Label over)
	{
		this.obstacle =	obstacle;
		this.player = player;
		this.scorecount = scorecount;
		this.score = score;
		this.over = over;
			
	}
	
	public void handle()
	{
		
	}
	
	public void handle(long now)
	{
		Point2D p1 = new Point2D(player.model.getCenterX(), player.model.getCenterY());
		Point2D p2 = new Point2D(obstacle.model.getCenterX(), obstacle.model.getCenterY());
		
		obstacle.update();
		player.update();		
		
		if (obstacle.done)
		{
			obstacle.position = obstacle.ground - obstacle.model.getRadius();
			obstacle.done = false;
		}
		
		if (cntspeed > 500)
		{
			obstacle.speed = obstacle.speed + 2;
			cntspeed = 0;
		}
		
		if (p1.distance(p2) < player.model.getRadius() + obstacle.model.getRadius())
		{
			obstacle.reset();
			player.playersprite.animation.stop();
			score.setText("SCORE TO BEAT: " + cnt);
			over.setText("GAME OVER");
			cnt = 0;
			stop();
		}
		
		scorecount.setText("SCORE: " + cnt);		
		cnt++;
		cntspeed++;
		
	}
	
}