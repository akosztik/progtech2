package harry.potter.view;

import javax.swing.*;
import java.awt.*;

public class MainWindow {
    JFrame frame;
    MainMenu mainMenu;

    public MainWindow(){
        this.frame= new JFrame("Magiaugyi nyilvantarto");
        JPanel panel = new JPanel();
        panel.setLayout(new CardLayout());
        frame.getContentPane().add(panel);
        this.mainMenu = new MainMenu(frame, panel);
        frame.setVisible(true);
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //frame.setSize(screenSize.width, screenSize.height);
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
