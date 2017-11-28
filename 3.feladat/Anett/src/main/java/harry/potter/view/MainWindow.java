package harry.potter.view;

import javax.swing.*;
import java.awt.*;

public class MainWindow {
    JFrame frame;
    MainMenu mainMenu;

    /**
     * Ezzel a konstruktorral peldanyositjuk a MainWindow nevu osztalyt.
     * Amely a frame-et es a fomenut generalja.
     */

    public MainWindow(){
        this.frame= new JFrame("Magiaugyi nyilvantarto");
        this.mainMenu = new MainMenu(frame);
        frame.setVisible(true);
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //frame.setSize(screenSize.width, screenSize.height);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
