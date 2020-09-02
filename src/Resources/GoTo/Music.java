package Resources.GoTo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class Music extends VBox {
    private ObservableList<String> musiclst;
    private ListView<String> musiclistView = new ListView<>();

    public Music() {
        super();
        this.setId("scp");
        this.setPrefSize(400, 480);

        musiclst = FXCollections.observableArrayList("Call Anytime - Kim Jin-Woo",
                                                     "Ice Queen - Baekhyun",
                                                     "DNA - BTS",
                                                     "Kill This Love - BLACKPINK",
                                                     "Hello, How Are You? - Hatsune Miku",
                                                     "Sasageyo - Linked Horizon",
                                                     "Nevereverland - Nano",
                                                     "Speechless - Naomi Scott",
                                                     "On My Way - Alan Walker");
        musiclistView.setItems(musiclst);
        musiclistView.setId("mylist");
        musiclistView.prefHeightProperty().bind(this.heightProperty());

        musiclistView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)){
                    if(event.getClickCount() == 2){
                        Alert m = new Alert(Alert.AlertType.INFORMATION);
                        m.setTitle("MUSIC INFORMATION");
                        m.setHeaderText(null);
                        m.setContentText("Your music request has been sent!");
                        m.show();
                    }
                }
            }
        });
        this.getChildren().add(musiclistView);
    }
}
