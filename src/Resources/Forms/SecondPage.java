package Resources.Forms;

import Resources.Function.ButtonFunction;
import Resources.GlobalVar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static Resources.GlobalVar.*;

public class SecondPage extends BorderPane {
    public SecondPage() {
        super();
        this.setId("SecondPage");
        this.getStylesheets().addAll(this.getClass().getResource("/Resources/style.css").toExternalForm());

        this.setTop(TopPane());
        this.setCenter(CenterPane());
    }

    private Label TopPane(){
        Label title = new Label("Afternoon Cafe");
        title.setId("sptitle");
        title.setFont(Font.font("Averia Sans Libre", FontWeight.BOLD, 26));
        title.setPrefHeight(70);
        title.prefWidthProperty().bind(this.widthProperty());
        title.setAlignment(Pos.BASELINE_CENTER);
        return title;
    }

    private GridPane CenterPane(){
        GridPane grid = new GridPane();
        grid.setId("scp");
        grid.setPadding(new Insets(40, 40, 40, 40));
        grid.setVgap(20);
        grid.setAlignment(Pos.BASELINE_CENTER);

        Label Name = new Label("Customer Name.");
        Name.setFont(Font.font("Averia Sans Libre", FontWeight.EXTRA_BOLD, 18));
        Name.setStyle("-fx-text-fill: #000000");
        grid.add(Name, 0, 5);

        Nametxt = new TextField();
        Nametxt.setPromptText("Enter Your Name");
        Nametxt.setFont(Font.font("Averia Sans Libre", FontWeight.MEDIUM, 18));
        grid.add(Nametxt, 0, 6);

        Nextbtn = new ButtonFunction("Next", GlobalVar.Nextfunc1);
        Nextbtn.setId("finalize");
        Nextbtn.setEffect(ds);
        Nextbtn.setFont(Font.font("Averia Sans Libre", FontWeight.BOLD, 16));
        Nextbtn.setPrefHeight(30);
        Nextbtn.setPrefWidth(80);

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        hbox.getChildren().add(Nextbtn);
        grid.add(hbox, 0, 7);

        return grid;
    }
}
