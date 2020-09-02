package Resources.GoTo;

import Resources.Function.HandlerFunction;
import Resources.GlobalVar;
import Resources.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

import static Resources.GlobalVar.*;

public class GoToThirdPage extends HandlerFunction implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event){
        if(Nametxt.getText().trim().isEmpty()){
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Warning!");
            a.setHeaderText("Warning!");
            a.setContentText("Please, input your customer's name!");
            a.show();
        }
        else{
            Main.window.setScene(GlobalVar.thirdpage);
            tptitle.setText("Welcome " + Nametxt.getText() + "!");
        }
    }
}
