package Pack1;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class AnimateSprite 
{
	Image IMAGE;
	int COLUMNS;
	int COUNT;
	int OFFSET_X;
	int OFFSET_Y;
	int WIDTH;
	int HEIGHT;
	int duration;
	ImageView imageView;
	Animation animation;
	
	public AnimateSprite()
	{
		COLUMNS = 0;
		COUNT = 0;
		OFFSET_X = 0;
		OFFSET_Y = 0;
		WIDTH = 0;
		HEIGHT = 0;	
		duration = 0;
	}
	
	public AnimateSprite(int COLUMNS, int COUNT, int OFFSET_X, int OFFSET_Y, int WIDTH, int HEIGHT, int duration, String IMAGE)
	{
		this.COLUMNS = COLUMNS;
		this.COUNT = COUNT;
		this.OFFSET_X = OFFSET_X;
		this.OFFSET_Y = OFFSET_Y;
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		this.duration = duration;
		this.IMAGE = new Image(IMAGE);
		
		this.imageView = new ImageView(this.IMAGE);
		
		imageView.setPreserveRatio(true);
		  imageView.setSmooth(true);
		  imageView.setCache(true);
		  imageView.setLayoutX(40);		  
		  imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
		  
		  animation = new Animate(
	              imageView,
	              Duration.millis(duration),
	              COUNT, COLUMNS,
	              OFFSET_X, OFFSET_Y,
	              WIDTH, HEIGHT
	      );
	      animation.setCycleCount(Animation.INDEFINITE);
	}
	
	public void move(double x, double y)
	{
		imageView.setLayoutX(x - (WIDTH/2));
		imageView.setLayoutY(y - (HEIGHT/2));
	}
	
}
