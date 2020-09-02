package Resources;

import Resources.Forms.FirstPage;
import Resources.Forms.FourthPage;
import Resources.Forms.SecondPage;
import Resources.Forms.ThirdPage;
import Resources.Function.HandlerFunction;
import Resources.GoTo.GoToThirdPage;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class GlobalVar {
    public static Scene firstpage, secondpage, thirdpage, fourthpage;
    public static final int W = 400, H = 600;
    public static HandlerFunction Nextfunc1;
    public static TextField Nametxt;
    public static Button Nextbtn;
    public static Pane CardPane, TopPane;

    public static final Label tptitle = new Label();
    public static final Label qtylbl = new Label();
    public static Button[] Barbtn = new Button[5];
    public static Button[] Menubtn = new Button[14];

    public static int[] count = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static  int[] qty_arr = new int[Menubtn.length];
    public static ArrayList<String> items = new ArrayList<String>();
    public static ObservableList<String> item_list;
    public static ListView<String> listView = new ListView<String>();
    public static Label sumlbl = new Label();
    public static String[] item_name = {"Espresso", "Hot Coffee", "Hot Chocolate", "Green Tea Latte", "Piccolo", "Tea",
                                        "Iced Coffee", "Iced Mochaccino", "Iced Vanilla Latte", "Iced Tea",
                                        "Tiramisu", "Sandwich", "Waffle", "Cupcake"};
    public static double[] prices = {3.00, 2.50, 3.20, 3.20, 2.00, 2.00,
                                     3.00, 2.50, 3.20, 2.00,
                                     3.00, 2.50, 2.00, 2.00};
    public static DropShadow ds = new DropShadow();

    public GlobalVar(){
        Nextfunc1 = new GoToThirdPage();

        ds.setOffsetX(1.2);
        ds.setOffsetY(1.2);
        ds.setColor(Color.BLACK);

        firstpage = new Scene(new FirstPage(), W, H);
        secondpage = new Scene(new SecondPage(), W, H);
        thirdpage = new Scene(new ThirdPage(), W, H);
        fourthpage = new Scene(new FourthPage(), W, H);
        Main.window.setScene(firstpage);
        Main.window.show();
    }
}
