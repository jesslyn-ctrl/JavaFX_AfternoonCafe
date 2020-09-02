package Resources.Forms;

import Resources.GlobalVar;
import Resources.Main;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class FirstPage extends StackPane {
    private Image img1;

    public FirstPage() {
        super();
        this.setId("FirstPage");
        this.getStylesheets().addAll(this.getClass().getResource("/Resources/style.css").toExternalForm());

        img1 = new Image("/Images/tap-to-start.png");
        ImageView imgv1 = new ImageView(img1);
        imgv1.setFitWidth(400);
        imgv1.setFitHeight(600);
        imgv1.setId("Start");
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(imgv1);

        imgv1.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            Main.window.setScene(GlobalVar.secondpage);
        });
    }
}
