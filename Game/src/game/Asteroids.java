package game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Asteroids extends Application {
    public static void main(String[] args) {
        try {
            launch(args);
        }
        catch (Exception error) {
            error.printStackTrace();
        }
        finally {
            System.exit(0);
        }
    }

    public void start(Stage mainStage) {
        mainStage.setTitle("Asteroids");

        BorderPane root = new BorderPane();
        Scene mainScene = new Scene(root);
        mainStage.setScene(mainScene);

        Canvas canvas = new Canvas(800, 600);
        GraphicsContext context = canvas.getGraphicsContext2D();
        root.setCenter(canvas);

        Sprite background = new Sprite("image/back_space.png");
        background.position.set(400, 300);
        background.render(context);

        mainStage.show();
    }
}
