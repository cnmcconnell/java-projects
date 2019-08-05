// Name: Christina McConnell
// Class: COP2800
// Project: XtraCr#3

package Pack1;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets; import
javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background; 
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox; 
import javafx.scene.layout.Pane; 
import javafx.scene.layout.VBox; 
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
public class MainClass extends Application
{
	
Pane p; 
public static void main(String[] args)
{
launch(args);
}
public void start(Stage stage)
{
	// Create images	
	Image bouncyball = new Image("Untitled.png");
	Image kitchen = new Image("kitchen.jpg");
	
	// Create bouncy ball
	Circle c = new Circle(200, 100, 20);
	c.setFill(new ImagePattern(bouncyball));
	
	double[] speed = {0, 0};
	double[] gravity = {0, .8};
	double bouncy = .8;
	double[] bounds = {580, 440};
			
	Ball ball = new Ball(c, speed, gravity, bouncy, bounds);
	
	// Create a Pane
	p = new Pane(c);
	p.setMinHeight(480);
	p.setMaxHeight(480);
	p.setBackground(new Background(new BackgroundImage(kitchen, null, null, null, null)));
	
	// p.setBackground(new Background(new BackgroundImage(kitchen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.AUTO)));
	
	
	// Create Buttons and HB
	Timer t = new Timer(ball);
	
	Button btnRun = new Button("Run");
	btnRun.setFocusTraversable(false);
	btnRun.setOnAction((ActionEvent e) -> {
		
		t.start();
		ball.position[0] = 200;
		ball.position[1] = 100;
		
	});
	
	HBox hb = new HBox(btnRun);
	hb.setMinSize(100, 50);
	hb.setPadding(new Insets(10,10,10,10));
	hb.setSpacing(7);
	hb.setBackground(new Background(new BackgroundFill( Color.rgb(150, 200, 150), null, null) ));
	
	
	// Create vertical box
	VBox vb = new VBox();
	vb.setSpacing(15);
	vb.setBackground(new Background(new BackgroundFill( Color.rgb(100, 100, 100), null, null) ));
	vb.getChildren().addAll(p, hb);
	
	 // Create scene 
	Scene scene = new Scene(vb);
	stage.setScene(scene);
	stage.setTitle("Basic JavaFx Configuration");
	stage.setWidth(600.0);
	stage.setHeight(580.0);
	stage.show();

} // End Start
} // End MainClass 