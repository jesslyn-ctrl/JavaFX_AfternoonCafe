package Resources.Function;

import javafx.scene.control.Button;

public class ButtonFunction extends Button {
    public ButtonFunction(String btn_name, HandlerFunction func) {
        super(btn_name);
        this.setOnAction(func);
    }
}
