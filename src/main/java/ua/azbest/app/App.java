package ua.azbest.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //String styleFile = "../../style.css";
        FXMLLoader loader = new FXMLLoader();
        //Parent root = (Parent) loader.load(getClass().getResourceAsStream("../../../forms/Exercises.fxml"));
        Parent root = (Parent) loader.load(getClass().getResourceAsStream("../../../forms/Exercises.fxml"));
        primaryStage.setTitle("Exercises");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        //scene.getStylesheets().add(App.class.getResource(styleFile).toExternalForm());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
