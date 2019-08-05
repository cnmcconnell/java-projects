package Pack1;

import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MainClass extends Application
{

	public static void main(String[] args) 
	{
		launch(args);
	}

	Pane p;
	
	public void start(Stage stage)
	{
		
		Pane p = new Pane();
		p.setMinSize(350, 325);
		
		p.setBackground(new Background(new BackgroundFill( Color.rgb(190, 220, 190), null, null) ));
		
		// Circles
		Circle c1 = new Circle(100, 100, 32);
		c1.setFill(Color.rgb(220, 20, 60));
		c1.setStroke(Color.BLACK);
		
		Circle c2 = new Circle(200, 120, 32);
		c2.setFill(Color.PURPLE);
		c2.setStroke(Color.BLACK);
		
		int x = 150;
		int y = 200;
	
		p.getChildren().addAll(c1, c2);
		
		
		// Create horizontal box for buttons 
		HBox hb = new HBox(); 
		hb.setMinSize(100, 50); 
		hb.setPadding(new Insets(10,10,10,10));
		hb.setSpacing(15);
		hb.setBackground(new Background(new BackgroundFill( Color.rgb(150, 200, 150), null, null) ));
		
		
		
		Button btn = new Button("Display Coordinates");
		btn.setFocusTraversable(false);
		btn.setOnAction((ActionEvent e) -> {
			System.out.println("C1: (" + c1.getCenterX() + " , " + c1.getCenterY() + ")");
			System.out.println("C2: (" + c2.getCenterX() + " , " + c2.getCenterY() + ")");			
		});
		
		// VBox to hold buttons
	
		
		hb.getChildren().addAll(btn);
		
		// Create vertical box
		VBox vb = new VBox(); 
		vb.setPadding(new Insets(15,15,15,15));
		vb.setSpacing(15);
		vb.setBackground(new Background(new BackgroundFill( Color.rgb(100, 100, 100), null, null) ));
		vb.getChildren().addAll(p, hb);
		
		/*
		* To Do
		* Implement your code here
		*/
		
		Scene scene = new Scene(vb); 
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>()
		{
			public void handle (KeyEvent event)
			{
				switch (event.getCode())
				{
				case UP:
					c1.setCenterY(c1.getCenterY() - 10);
					break;
				case DOWN:
					c1.setCenterY(c1.getCenterY() + 10);
					break;
				case LEFT:
					c1.setCenterX(c1.getCenterX() - 10);
					break;
				case RIGHT:
					c1.setCenterX(c1.getCenterX() + 10);
					break;
				default:
						// No default
				} // end switch
			}
		});
		
		stage.setScene(scene);
		stage.setTitle("Circle Coordinates");
		stage.setWidth(500.0); 
		stage.setHeight(460.0);
		
		
		stage.show();
		
	}
}
