package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.layout.HBox;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("lesson10");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
//		grid.setGridLinesVisible(true);

        Text scenetitle = new Text("Dog");
        scenetitle.setId("welcome-text");

        grid.add(scenetitle, 0, 0, 1, 1);
        Label dogName = new Label("Dog Name:");
        grid.add(dogName, 0, 1);
        TextField dogTextField = new TextField();
        grid.add(dogTextField, 1, 1);

        Label dogAge = new Label("Dog Age:");
        grid.add(dogAge, 0, 2);
        TextField dogTextAge = new TextField();
        grid.add(dogTextAge, 1, 2);

        Label dogOwner = new Label("Owner name:");
        grid.add(dogOwner, 0, 3);
        TextField dogTextOwner = new TextField();
        grid.add(dogTextOwner, 1, 3);

        Button btn1 = new Button("create");
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn1.getChildren().add(btn1);
        grid.add(hbBtn1, 2, 2);

        Button btn2 = new Button("get");
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn2.getChildren().add(btn2);
        grid.add(hbBtn2, 1, 4);

        Button btn3 = new Button("gc");
        HBox hbBtn3 = new HBox(10);
        hbBtn3.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn3.getChildren().add(btn3);
        grid.add(hbBtn3, 2, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actiontarget.setId("actiontarget");
                actiontarget.setText("create");
            }
        });

        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actiontarget.setId("actiontarget");
                actiontarget.setText("get");
            }
        });

        btn3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actiontarget.setId("actiontarget");
                actiontarget.setText("gc");
            }
        });
        Scene scene = new Scene(grid, 400, 275);
        primaryStage.setScene(scene);

        scene.getStylesheets().add
                (Main.class.getResource("Style.css").toExternalForm());

        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
