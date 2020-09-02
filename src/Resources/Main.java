package Resources;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage window;

    @Override
    public void start(Stage primaryStage){
        window = primaryStage;
        window.getIcons().add(new Image(getClass().getResourceAsStream("/Images/cof.PNG")));
        window.setTitle("Afternoon Cafe");
        window.setResizable(false);
        new GlobalVar();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
