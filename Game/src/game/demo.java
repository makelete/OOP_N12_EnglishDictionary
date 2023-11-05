package game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class demo extends Application {

    Stage window = new Stage();
    Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        // setup Scene1.
        Label label1 = new Label("welcum to mai chanel");
        Button button1 = new Button("go to mai videos");
        button1.setOnAction(event -> {
            window.setScene(scene2);
        });
        VBox layout1 = new VBox();
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 400, 400);

        // setup Scene2.
        Label label2 = new Label("nhieu vid ko?");
        Button button2 = new Button("Thoat thi nhan day");
        button2.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Thoat di");
            alert.setContentText("Thoat that a");

            ButtonType buttonTypeYes = new ButtonType("Co", ButtonBar.ButtonData.YES);
            ButtonType buttonTypeNo = new ButtonType("Khong", ButtonBar.ButtonData.NO);

            alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo );

            Optional<ButtonType> result = alert.showAndWait();

            if(result.get().getButtonData() == ButtonBar.ButtonData.NO){

            } else {

            }
        });
        VBox layout2 = new VBox();
        layout2.getChildren().addAll(label2, button2);
        scene2 = new Scene(layout2, 400, 200);

        window.setScene(scene1);
        window.show();
    }
}
