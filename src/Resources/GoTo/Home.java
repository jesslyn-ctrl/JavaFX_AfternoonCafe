package Resources.GoTo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Home extends GridPane {
    public Home() {
        super();
        this.setId("scp");
        this.setPrefSize(400, 480);
        this.setAlignment(Pos.BASELINE_LEFT);
        this.add(box1(), 0, 0);
        this.add(box2(), 0, 1);
    }
    private VBox box1(){
        VBox vbox = new VBox();
        vbox.setSpacing(15);
        vbox.setPadding(new Insets(25, 15, 0, 15));

        Label lbl = new Label("What's New?");
        lbl.setFont(Font.font("Averia Sans Libre", FontWeight.EXTRA_BOLD, 18));
        ImageView imgvw1 = new ImageView(new Image("/Images/Home/greentea.png"));
        imgvw1.setFitWidth(100);
        imgvw1.setFitHeight(100);

        Label lbl1 = new Label("Green Tea Latte");
        lbl1.setFont(Font.font("Averia Sans Libre", FontWeight.BOLD, 18));
        lbl1.setStyle("-fx-text-fill: darkseagreen;");
        Text text = new Text();
        text.setText("Derived from original \n" +
                     "green tea leaves, mixed with \n" +
                     "best of quality milk that will \n" +
                     "warm your day.");
        text.setFont(Font.font("Averia Sans Libre", FontWeight.MEDIUM, 14));
        HBox hBox1 = new HBox();
        hBox1.setSpacing(15);
        hBox1.getChildren().addAll(imgvw1, text);

        vbox.getChildren().addAll(lbl, lbl1, hBox1);

        return vbox;
    }
    private VBox box2(){
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(85, 15, 15, 15));

        //1
        Label lbl = new Label("-Recommended Menu-");
        lbl.setFont(Font.font("Averia Sans Libre", FontWeight.EXTRA_BOLD, 18));

        Label lbl1 = new Label("Green Tea Latte");
        lbl1.setFont(Font.font("Averia Sans Libre", FontWeight.BOLD, 16));
        lbl1.setStyle("-fx-text-fill: darkseagreen;");

        ImageView imgvw1 = new ImageView(new Image("/Images/Home/greentea.png"));
        imgvw1.setFitWidth(100);
        imgvw1.setFitHeight(100);

        VBox vBox1 = new VBox();
        vBox1.setId("greenteabox");
        vBox1.getChildren().addAll(lbl1, imgvw1);

        //2
        Label lbl2 = new Label("Tiramisu");
        lbl2.setFont(Font.font("Averia Sans Libre", FontWeight.BOLD, 16));
        lbl2.setStyle("-fx-text-fill: darkseagreen;");

        ImageView imgvw2 = new ImageView(new Image("/Images/Home/tiramisu.png"));
        imgvw2.setFitWidth(100);
        imgvw2.setFitHeight(100);

        VBox vBox2 = new VBox();
        vBox2.getChildren().addAll(lbl2, imgvw2);

        //hbox
        HBox hBox = new HBox();
        hBox.setSpacing(50);
        hBox.getChildren().addAll(vBox1, vBox2);

        vBox.getChildren().addAll(lbl, hBox);
        return vBox;
    }
}
