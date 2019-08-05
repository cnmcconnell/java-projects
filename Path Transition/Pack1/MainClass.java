// Name: Christina McConnell
// Class: COP2800
// Project: XtraCr#2

package Pack1;



import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.stage.*;
public class MainClass extends Application
{
public static void main(String[] args)
{
launch(args);
}
public void start(Stage stage)
{
//***********************************************************
 // Create the animation objects
 //***********************************************************
Circle c1 = new Circle(200, 160, 30);
c1.setStroke(Color.rgb(190,190,190));
c1.setFill(Color.YELLOW);
Circle c2 = new Circle(300, 160, 18);
c2.setStroke(Color.rgb(190,190,190));
c2.setFill(Color.BLUE);
//***********************************************************
 // Create the path for the objects
 //***********************************************************
Arc arcc2 = new Arc(200, 160, 100, 100, 0, 360);
arcc2.setStroke(Color.rgb(210,210,210));
arcc2.setFill(null);

//***********************************************************
// Create the Transitions
//***********************************************************

PathTransition pt1 = new PathTransition();
pt1.setInterpolator(Interpolator.LINEAR);
pt1.setDuration(Duration.millis(5000));
pt1.setPath(arcc2);
pt1.setNode(c2);

//***********************************************************
 // Add the animation component to the animation pane
 //***********************************************************
Pane paneAnimate = new Pane();
paneAnimate.setMinSize(300, 300);
 
 paneAnimate.getChildren().addAll(c1,
 arcc2,
c2);

//***********************************************************
 // Start Animation
 //***********************************************************
 Button startBtn = new Button("Start");
 startBtn.setOnAction((ActionEvent e) -> {
pt1.play();
 });

 //***********************************************************
 // Stop Animation
 //***********************************************************
 Button stopBtn = new Button("Stop");
 stopBtn.setOnAction((ActionEvent e) -> {
 pt1.stop();
 });

 //***********************************************************
 // Add the buttons to the hbS pane
 //***********************************************************
 HBox hbS = new HBox();
 hbS.setSpacing(10);
 hbS.setPadding(new Insets(0, 0, 0, 150));
 hbS.getChildren().addAll(startBtn, stopBtn);


 //***********************************************************
 // Add components to VBox
 //***********************************************************
 VBox vb = new VBox();
 vb.setSpacing(7);
 vb.setPadding(new Insets(10, 0, 0, 10));
 vb.getChildren().addAll(paneAnimate, hbS);

 //***********************************************************
 // Prepare the stage
 //***********************************************************
 Scene scene = new Scene (vb, 200, 200);
 stage.setScene(scene);
stage.setTitle("Animation");
 stage.setWidth(450);
 stage.setHeight(400);
stage.show();
}
}