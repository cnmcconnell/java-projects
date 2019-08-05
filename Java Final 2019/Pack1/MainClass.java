// Name: Christina McConnell
// Class: COP2800
// Project: Final Project

package Pack1;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background; 
import javafx.scene.layout.BackgroundFill; 
import javafx.scene.layout.Pane; 
import javafx.scene.layout.VBox; 
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;



public class MainClass extends Application
{
	Pane p;
	Pane pmenu;
	Circle pCircle;
	Font font;
	Font titlefont;

public static void main(String[] args)
{
	launch(args);
}

public void start(Stage stage)
{	
	// Create background images
	Image background = new Image("forest.png");
	ImageView bv = new ImageView(background);
	
	Group forest = new Group();
	forest.getChildren().addAll(bv);
	
	Image menubackground = new Image("menu.jpg");
	ImageView bg = new ImageView(menubackground);
	
	Group menu = new Group();
	menu.getChildren().addAll(bg);

	
	// Create a Pane
	p = new Pane();
	p.setMinHeight(background.getHeight());
	p.setMaxHeight(background.getHeight());


	// Create fonts and labels
	font = Font.font("", FontWeight.BOLD, FontPosture.REGULAR, 20);	 
	titlefont = Font.font("", FontWeight.BOLD, FontPosture.REGULAR, 40);
			
	Label scorecount = new Label("");
	Label score = new Label("");
	Label title = new Label("Poison Avoidin'");
	Label over = new Label("");
	
	score.setFont(font);
	score.setLayoutY(10);
	score.setLayoutX(10);
	score.setStyle("-fx-text-fill: white");	
	
	scorecount.setFont(font);
	scorecount.setLayoutY(38);
	scorecount.setLayoutX(10);
	scorecount.setStyle("-fx-text-fill: white");
	
	title.setFont(titlefont);
	title.setLayoutX(260);
	title.setLayoutY(20);
	title.setBackground(new Background( new BackgroundFill(Color.rgb(35, 35, 35), null, null)));
	title.setPadding(new Insets(0, 10, 0, 10));
	title.setStyle("-fx-text-fill: gold");
	
	over.setFont(titlefont);
	over.setLayoutX(290);
	over.setLayoutY(100);
	over.setPadding(new Insets(0, 10, 0, 10));
	over.setStyle("-fx-text-fill: red");
	

	// Create Player
	AnimateSprite playersprite = new AnimateSprite(8, 8, -1, 5, 100, 100, 700, "punk.png");
	pCircle = new Circle(100, p.getMaxHeight() - 90, 35);	
	Player player = new Player(pCircle, 25, 2, p.getMaxHeight() - 55, playersprite);
	playersprite.move(pCircle.getCenterX(), pCircle.getCenterY());
	
	
	// Create Scorpion
	AnimateSprite scorpion = new AnimateSprite(4, 4, -1, 5, 128, 100, 700, "Scorpion.png");
	Obstacle obstacle = new Obstacle(30, 10, 900, scorpion);
	scorpion.move(obstacle.position, obstacle.model.getCenterY() - 10);
	
	
	p.getChildren().addAll(forest, title, over, playersprite.imageView, scorpion.imageView);
	
	
	//Create buttons		
	Timer t = new Timer(obstacle, player, score, scorecount, over);
	Button btnRun = new Button("START");
	btnRun.setFont(font);
	btnRun.setStyle("-fx-text-fill: white");
	btnRun.setBackground(new Background(new BackgroundFill( Color.rgb(150, 200, 150), null, null)));
	btnRun.setFocusTraversable(false);
	btnRun.setLayoutX(320);
	btnRun.setLayoutY(20);
	btnRun.setOnAction((ActionEvent e) -> {
		t.start();
		playersprite.animation.play();
		scorpion.animation.play();	
		over.setText("");
	});
		
	
	Button btnStop = new Button("STOP");
	btnStop.setFont(font);
	btnStop.setStyle("-fx-text-fill: white");
	btnStop.setBackground(new Background(new BackgroundFill( Color.rgb(150, 200, 150), null, null)));
	btnStop.setFocusTraversable(false);
	btnStop.setLayoutX(420);
	btnStop.setLayoutY(20);
	btnStop.setOnAction((ActionEvent e) -> {
		t.stop();
		playersprite.animation.stop();
		scorpion.animation.stop();
	});
	
	// Create menu pane
	pmenu = new Pane();
	pmenu.setMinHeight(100);
	pmenu.setMaxHeight(100);	
	pmenu.getChildren().addAll(menu, btnRun, btnStop, score, scorecount);
	

	// Create vertical box
	VBox vb = new VBox();
	vb.setSpacing(5);
	vb.setBackground(new Background(new BackgroundFill( Color.rgb(0, 0, 0), null, null) ));
	vb.getChildren().addAll(p, pmenu);
	
	
	// Create scene and controls	
	Scene scene = new Scene(vb);

scene.setOnKeyPressed(new EventHandler<KeyEvent>()
{
	public void handle (KeyEvent event)
	{
		switch (event.getCode())
		{
			case SPACE:
				player.jump();
				break;
			case RIGHT:
				player.model.setCenterX(player.model.getCenterX() + 10);
				break;
			case LEFT:
				player.model.setCenterX(player.model.getCenterX() - 10);
			default:		
				// No default
		} // end switch
		
	}
});

// Set stage
stage.setScene(scene);
stage.setTitle("Poison Avoidin'");
stage.setResizable(false);
stage.setWidth(900.0);
stage.setHeight(600.0);
stage.show();

} // End Start
} // End MainClass 