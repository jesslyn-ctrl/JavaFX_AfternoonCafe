package Resources.Forms;

import Resources.GoTo.Home;
import Resources.GoTo.Music;
import Resources.Main;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static Resources.GlobalVar.*;

public class ThirdPage extends BorderPane implements EventHandler<ActionEvent> {
    private Group TopOpt[];
    private Group CenterOpt[];
    private Image[] Icons = new Image[Barbtn.length];
    private ImageView[] Iconsvw = new ImageView[Icons.length];
    private Image[] MenuImg = new Image[Menubtn.length];
    private ImageView[] MenuImgvw = new ImageView[MenuImg.length];
    private Button qtyplus, qtymin, qtyok, qtycancel;
    private int j, k, n = 0;
    private double  sum = 0;
    private ArrayList<Integer> choices = new ArrayList<Integer>();
    private DecimalFormat format = new DecimalFormat("##.00");


    public ThirdPage() {
        super();
        this.setId("ThirdPage");
        this.getStylesheets().addAll(this.getClass().getResource("/Resources/style.css").toExternalForm());

        AllForTop();
        AllForCenter();
        AllForBot();
    }

    private void AllForTop(){
        TopOpt = new Group[]{
                     new Group(Home()),
                     new Group(Menu()),
                     new Group(Music()),
        };
        TopPane = new StackPane();
        TopPane.getChildren().add(TopOpt[0]);
        this.setTop(TopPane);
    }
    private Label Home(){
        tptitle.setId("tptitle");
        tptitle.setFont(Font.font("Algerian", FontWeight.BOLD, 24));
        tptitle.setPrefHeight(50);
        tptitle.prefWidthProperty().bind(this.widthProperty());
        tptitle.setAlignment(Pos.BASELINE_CENTER);

        return tptitle;
    }
    private Label Menu(){
        Label menulbl = new Label("Menu");
        menulbl.setId("tptitle");
        menulbl.setFont(Font.font("Algerian", FontWeight.BOLD, 24));
        menulbl.setPrefHeight(50);
        menulbl.prefWidthProperty().bind(this.widthProperty());
        menulbl.setAlignment(Pos.BASELINE_CENTER);

        return menulbl;
    }
    private Label Music(){
        Label musiclbl = new Label("Music");
        musiclbl.setId("tptitle");
        musiclbl.setFont(Font.font("Algerian", FontWeight.BOLD, 24));
        musiclbl.setPrefHeight(50);
        musiclbl.prefWidthProperty().bind(this.widthProperty());
        musiclbl.setAlignment(Pos.BASELINE_CENTER);

        return musiclbl;
    }

    private void AllForCenter(){
        CenterOpt = new Group[]{
                        new Group(new Home()),
                        new Group(MenuScroll()),
                        new Group(new Music())
        };
        CardPane = new StackPane();
        CardPane.getChildren().add(CenterOpt[0]);
        this.setCenter(CardPane);
    }
    private HBox HotDrinks(){
        HBox hotbox = new HBox();
        hotbox.setId("hotbox");
        hotbox.setPrefWidth(400);
        hotbox.setAlignment(Pos.BASELINE_CENTER);
        Label hotlbl = new Label("Hot Drinks");
        hotlbl.setFont(Font.font("Averia Sans Libre", FontWeight.BOLD, 24));
        hotlbl.setId("hotlbl");
        hotlbl.setPrefHeight(40);
        hotbox.getChildren().add(hotlbl);

        return hotbox;
    }
    private HBox ColdDrinks(){
        HBox coldbox = new HBox();
        coldbox.setId("hotbox");
        coldbox.setPrefWidth(400);
        coldbox.setAlignment(Pos.CENTER);
        Label coldlbl = new Label("Cold Drinks");
        coldlbl.setFont(Font.font("Averia Sans Libre", FontWeight.BOLD, 24));
        coldlbl.setId("hotlbl");
        coldlbl.setPrefHeight(40);
        coldbox.getChildren().add(coldlbl);

        return coldbox;
    }
    private HBox Desserts(){
        HBox desbox = new HBox();
        desbox.setId("hotbox");
        desbox.setPrefWidth(400);
        desbox.setAlignment(Pos.CENTER);
        Label deslbl = new Label("Desserts");
        deslbl.setFont(Font.font("Averia Sans Libre", FontWeight.BOLD, 24));
        deslbl.setId("hotlbl");
        deslbl.setPrefHeight(40);
        desbox.getChildren().add(deslbl);

        return desbox;
    }
    private ScrollPane MenuScroll(){
        ScrollPane spmenu = new ScrollPane();
        spmenu.setPrefSize(400, 480);
        spmenu.setId("spmenu");
        spmenu.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        FlowPane fpmenu = new FlowPane();
        fpmenu.setHgap(10);
        fpmenu.setVgap(10);

        for(int i = 0; i < MenuImg.length; i++){
            MenuImg[i] = new Image("Images/Menus/Menu" + (i+1) + ".png");
            MenuImgvw[i] = new ImageView(MenuImg[i]);
            MenuImgvw[i].setFitWidth(170);
            MenuImgvw[i].setFitHeight(200);
        }

        fpmenu.getChildren().add(HotDrinks());
        for(int i = 0; i < 6; i++){
            Menubtn[i] = new Button("", MenuImgvw[i]);
            fpmenu.getChildren().add(Menubtn[i]);
        }

        fpmenu.getChildren().add(ColdDrinks());
        for(int i = 6; i < 10; i++){
            Menubtn[i] = new Button("", MenuImgvw[i]);
            fpmenu.getChildren().add(Menubtn[i]);
        }

        fpmenu.getChildren().add(Desserts());
        for(int i = 10; i < 14; i++){
            Menubtn[i] = new Button("", MenuImgvw[i]);
            fpmenu.getChildren().add(Menubtn[i]);
        }

        for(int i = 0; i < Menubtn.length; i++){
            Menubtn[i].setOnAction(this);
        }
        spmenu.setContent(fpmenu);
        return spmenu;
    }
    private StackPane CartPane(){
        VBox vbox = new VBox(50);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);
        Label cartlbl = new Label("Add to cart.");
        cartlbl.setId("cartlbl");

        ImageView plusvw = new ImageView(new Image("/Images/Icon/Plusicon.png"));
        ImageView minvw = new ImageView(new Image("/Images/Icon/Minusicon.png"));
        ImageView okvw = new ImageView(new Image("/Images/Icon/Okicon.png"));
        ImageView cancelvw = new ImageView(new Image("/Images/Icon/Cancelicon.png"));
        plusvw.setFitWidth(30);
        plusvw.setFitHeight(30);
        minvw.setFitWidth(30);
        minvw.setFitHeight(30);
        okvw.setFitWidth(70);
        okvw.setFitHeight(40);
        cancelvw.setFitWidth(70);
        cancelvw.setFitHeight(40);

        for(int i = 0; i < Menubtn.length; i++){
            qtylbl.setText(String.valueOf(count[i]));
        }
        qtylbl.setFont(Font.font("'DejaVu Serif', Georgia, \"Times New Roman\", Times, serif", FontWeight.MEDIUM, 20));
        qtyplus = new Button("", plusvw);
        qtyplus.setId("qty");
        qtymin = new Button("", minvw);
        qtymin.setId("qty");
        qtyok = new Button("", okvw);
        qtyok.setAlignment(Pos.BASELINE_RIGHT);
        qtyok.setId("qty");
        qtycancel = new Button("", cancelvw);
        qtycancel.setAlignment(Pos.BOTTOM_LEFT);
        qtycancel.setId("qty");

        TilePane tpqty = new TilePane();
        tpqty.setHgap(7);
        tpqty.setAlignment(Pos.CENTER);

        TilePane tpokcancel = new TilePane();
        tpokcancel.setHgap(30);
        tpokcancel.setAlignment(Pos.BOTTOM_CENTER);

        tpqty.getChildren().addAll(qtymin, qtylbl, qtyplus);
        tpokcancel.getChildren().addAll(qtycancel, qtyok);

        qtyplus.setOnAction(this);
        qtymin.setOnAction(this);
        qtyok.setOnAction(this);
        qtycancel.setOnAction(this);
        vbox.getChildren().addAll(cartlbl, tpqty, tpokcancel);

        return new StackPane(vbox);
    }

    private void AllForBot(){this.setBottom(BottomPane());}
    private HBox BottomPane(){
        HBox hbox = new HBox();
        hbox.setId("hboxBot");
        FlowPane Menubars = new FlowPane();
        Menubars.setAlignment(Pos.CENTER_LEFT);
        Menubars.setHgap(5);

        for(int i = 0; i < Icons.length; i++){
            Icons[i] = new Image("/Images/Icon/Icon" + (i+1) + ".png");
            Iconsvw[i] = new ImageView(Icons[i]);
            Iconsvw[i].setFitHeight(35);
        }

        Iconsvw[0].setFitWidth(35);
        Iconsvw[1].setFitWidth(30);
        Iconsvw[2].setFitWidth(30);
        Iconsvw[3].setFitWidth(25);
        Iconsvw[4].setFitWidth(25);

        Barbtn = new Button[]{
                new Button("Home", Iconsvw[0]),
                new Button("Menu", Iconsvw[1]),
                new Button("Music", Iconsvw[2]),
                new Button("", Iconsvw[3]),
                new Button("", Iconsvw[4])
        };

        for(int i = 0; i < Barbtn.length; i++){

            Barbtn[i].setId("Barbtn");
            Menubars.getChildren().add(Barbtn[i]);
        }

        for(int i = 0; i < Barbtn.length; i++)
        {
            if(i == 3)
                Barbtn[i].setOnAction(this);
            else if(i == 4)
                Barbtn[i].setOnAction(this);
            else
                Barbtn[i].setOnAction(this);
        }

        hbox.getChildren().add(Menubars);
        return hbox;
    }

    @Override
    public void handle(ActionEvent event){
        for(int i = 0; i < Barbtn.length; i++){
            if(event.getSource() == Barbtn[i]){
                TopPane.getChildren().clear();
                CardPane.getChildren().clear();
                if(i < 3){
                    TopPane.getChildren().add(TopOpt[i]);
                    CardPane.getChildren().add(CenterOpt[i]);
                }
                else{
                    if(event.getSource() == Barbtn[3]){
                        Main.window.setScene(secondpage);
                        this.getChildren().clear();
                        AllForTop();
                        AllForCenter();
                        AllForBot();
                    }
                    if(event.getSource() == Barbtn[4]){
                        if(n > 0){
                            TopPane.getChildren().add(TopOpt[1]);
                            CardPane.getChildren().add(CenterOpt[1]);

                            sum=0;
                            Main.window.setScene(fourthpage);
                            for(int x = 0; x < n; x++){
                                items.add(item_name[choices.get(x)] + "\n" + qty_arr[choices.get(x)] + "x\t\t\t\t\t\t\t\t\t$"
                                          + prices[choices.get(x)]);
                                sum += qty_arr[choices.get(x)] * prices[choices.get(x)];
                            }
                            item_list = FXCollections.observableArrayList(items);
                            listView.setItems(item_list);
                            sumlbl.setText("  Total Price\t\t\t\t\t\t$" + (Double.parseDouble(format.format(sum))));


                        }
                        else {
                            TopPane.getChildren().add(TopOpt[1]);
                            CardPane.getChildren().add(CenterOpt[1]);
                            Alert v = new Alert(Alert.AlertType.INFORMATION);
                            v.setTitle("ORDER INFORMATION");
                            v.setHeaderText(null);
                            v.setContentText("Please order something..");
                            v.show();
                        }
                    }
                }
            }
        }

        for(k = 0; k < Menubtn.length; k++){
            if(event.getSource() == Menubtn[k]){
                CardPane.getChildren().clear();
                CardPane.getChildren().add(CartPane());
                j = k;
            }
        }
        if(event.getSource() == qtyplus){
            count[j]++;
            qtylbl.setText(String.valueOf(count[j]));
        }

        if(event.getSource() == qtymin){
            if(count[j] > 0){
                count[j]--;
                qtylbl.setText(String.valueOf(count[j]));
            }

        }
        if(event.getSource() == qtyok){
            if(count[j] == 0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Quantity INFORMATION");
                alert.setHeaderText("Increase or decrease the quantity");
                alert.setContentText("Cannot OK if quantity 0");
                alert.show();
            }
            else{
                qty_arr[j] = count[j];
                CardPane.getChildren().clear();
                CardPane.getChildren().add(CenterOpt[1]);
                n++;
                choices.add(j);
            }
        }
        if(event.getSource() == qtycancel){
            CardPane.getChildren().clear();
            CardPane.getChildren().add(CenterOpt[1]);
        }
    }
}
