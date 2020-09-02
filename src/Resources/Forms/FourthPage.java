package Resources.Forms;

import Resources.GlobalVar;
import Resources.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static Resources.GlobalVar.*;

public class FourthPage extends BorderPane implements EventHandler<ActionEvent> {
    private Button finalize;
    private Button backbtn;

    public FourthPage() {
        super();
        this.setId("FourthPage");
        this.getStylesheets().addAll(this.getClass().getResource("/Resources/style.css").toExternalForm());

        this.setTop(Toppane());
        this.setCenter(CenterPane());
        this.setBottom(BotPane());
            }

    private Label Toppane(){
        Label Bill_lbl = new Label("Here is Your Order!");
        Bill_lbl.setId("tptitle");
        Bill_lbl.setFont(Font.font("Algerian", FontWeight.BOLD, 20));
        Bill_lbl.setPrefHeight(70);
        Bill_lbl.prefWidthProperty().bind(this.widthProperty());
        Bill_lbl.setAlignment(Pos.BASELINE_CENTER);

        return Bill_lbl;
    }

    private VBox CenterPane(){
        VBox vbox = new VBox();
        listView.setId("mylist");
        listView.prefHeightProperty().bind(this.heightProperty());
        vbox.getChildren().add(listView);
        return vbox;
    }

    private HBox BotPane() {
        HBox hBox = new HBox();
        hBox.setId("scp");
        sumlbl.setPrefHeight(80);
        sumlbl.setFont(Font.font("Averia Sans Libre", FontWeight.EXTRA_BOLD, 18));

        finalize = new Button("Order");
        finalize.setId("finalize");
        finalize.setEffect(ds);
        finalize.setFont(Font.font("Averia Sans Libre", FontWeight.BOLD, 16));

        backbtn = new Button("Back");
        backbtn.setId("finalize");
        backbtn.setEffect(ds);
        backbtn.setFont(Font.font("Averia Sans Libre", FontWeight.BOLD, 16));

        TilePane tptp = new TilePane();
        tptp.setHgap(192);
        tptp.getChildren().addAll(backbtn, finalize);

        HBox hBox1 = new HBox(tptp);
        hBox1.setAlignment(Pos.BOTTOM_RIGHT);
        hBox1.setPadding(new Insets(0, 35, 25, 33));
        hBox1.setPrefWidth(400);
        hBox1.setPrefHeight(30);

        FlowPane fpforbot = new FlowPane();
        fpforbot.getChildren().addAll(sumlbl, hBox1);
        hBox.getChildren().add(fpforbot);

        finalize.setOnAction(this);
        backbtn.setOnAction(this);
        return hBox;
    }

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == finalize){
            Alert sent = new Alert(Alert.AlertType.INFORMATION);
            sent.setTitle("ORDER INFORMATION");
            sent.setHeaderText(null);
            sent.setContentText("Your order has been finalized.\n" +
                                "Please wait for your order to arrive..");
            sent.showAndWait();
            Main.window.close();
        }
        if(event.getSource() == backbtn){
            Main.window.setScene(GlobalVar.thirdpage);
            items.clear();
            item_list.clear();
            listView.setItems(null);
        }
    }
}
