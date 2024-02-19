import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.geometry.Pos;
import java.util.Random;

public class DessertGame extends Application {

    private int score;
    
    @Override
    public void start(final Stage stage) {
        // Step 3 & 4
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 640, 480);
        stage.setTitle("Dessert in the Desert JavaFX Game");
        
        // Step 5
        Label scoreLabel = new Label("Score: " + score);
        borderPane.setTop(scoreLabel);
        BorderPane.setAlignment(scoreLabel, Pos.TOP_LEFT);

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> {
            Platform.exit();
        });
        exitButton.requestFocus();
        borderPane.setBottom(exitButton);
        BorderPane.setAlignment(exitButton, Pos.BOTTOM_RIGHT);
        
        // Step 6
        
        // TODO: Step 7-10
        Button[] barray = new Button[8];
        //step 7
        Button bdess = new Button("Dessert");
        barray[0] = bdess;
        Button bdes1 = new Button("Desert");
        barray[1] = bdes1;
        Button bdes2 = new Button("Desert");
        barray[2] = bdes2;
        Button bdes3 = new Button("Desert");
        barray[3] = bdes3;
        Button bdes4 = new Button("Desert");
        barray[4] = bdes4;
        Button bdes5 = new Button("Desert");
        barray[5] = bdes5;
        Button bdes6 = new Button("Desert");
        barray[6] = bdes6;
        Button bdes7 = new Button("Desert");
        barray[7] = bdes7;

        Pane pane = new Pane(bdess, bdes1, bdes2, bdes3, bdes4, bdes5, bdes6, bdes7);
        borderPane.setCenter(pane);
        BorderPane.setAlignment(pane, Pos.CENTER);
        
        bdess.setOnAction(event -> {
          exitButton.requestFocus();
          method(new Random(), barray);
          score ++;
          scoreLabel.setText("Score: " + score);
        });
        bdes1.setOnAction(event -> {
          exitButton.requestFocus();
          method(new Random(), barray);
          score --;
          scoreLabel.setText("Score: " + score);
        });
        bdes2.setOnAction(event -> {
          exitButton.requestFocus();
          method(new Random(), barray);
          score --;
          scoreLabel.setText("Score: " + score);
        });
        bdes3.setOnAction(event -> {
          exitButton.requestFocus();
          method(new Random(), barray);
          score --;
          scoreLabel.setText("Score: " + score);
        });
        bdes4.setOnAction(event -> {
          exitButton.requestFocus();
          method(new Random(), barray);
          score --;
          scoreLabel.setText("Score: " + score);
        });
        bdes5.setOnAction(event -> {
          exitButton.requestFocus();
          method(new Random(), barray);
          score --;
          scoreLabel.setText("Score: " + score);
        });
        bdes6.setOnAction(event -> {
          exitButton.requestFocus();
          method(new Random(), barray);
          score --;
          scoreLabel.setText("Score: " + score);
        });
        bdes7.setOnAction(event -> {
          exitButton.requestFocus();
          method(new Random(), barray);
          score --;
          scoreLabel.setText("Score: " + score);
        });
        method(new Random(), barray);
        
        
        stage.setScene(scene);
        stage.show();
    }
    
    private void method(Random r, Button[] barray) {
      for(int i = 0 ; i < barray.length; i ++) {
        barray[i].setLayoutX(r.nextInt(601));
        barray[i].setLayoutY(r.nextInt(401));
      }
    }
    

    public static void main(String[] args) {
        Application.launch();
    }
}