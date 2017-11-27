package harry.potter.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu{

    JMenuBar menuBar;
    JMenu newData;
    JMenu modify;
    JMenu filter;
    JMenuItem addFirstMet;
    JMenuItem addCreature;
    JMenuItem addHouse;
    JMenuItem addStudent;
    JMenuItem addCharacter;
    JMenuItem changeCharacter;
    JMenuItem solveHousing;
    JMenuItem list;
    JMenuItem searchNames;

    public MainMenu(JFrame frame){
        this.menuBar= new JMenuBar();
        this.newData= new JMenu("uj adatok felvitele");
        this.modify= new JMenu("adatok modositasa");
        this.filter= new JMenu("adatok szurese");
        menuBar.add(newData);
        menuBar.add(modify);
        menuBar.add(filter);
        frame.setJMenuBar(menuBar);
        this.addFirstMet= new JMenuItem("elso tallalkozasi datum felvitele");
        this.addCreature= new JMenuItem("uj leny felvitele");
        this.addHouse= new JMenuItem("uj haz felvitele");
        this.addStudent= new JMenuItem("uj tanulo felvitele");
        this.addCharacter= new JMenuItem("uj karakter felvitele");
        this.changeCharacter= new JMenuItem("tanulok/lenyek jellemenek modositasa");
        this.solveHousing= new JMenuItem("tanulo elhelyezese");
        this.list= new JMenuItem("haz/jellem/tanulo/leny listazasa");
        this.searchNames= new JMenuItem("szures: tanulok/lenyek nevere");
        newData.add(addCreature);
        addCreature.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("addCreature");
                NewView dialog= new NewView("uj leny felvitele","Adja meg a leny nevet: ",frame);
                dialog.dialog.setLocationRelativeTo(frame);
                dialog.dialog.setVisible(true);
            }
        });
        newData.add(addCharacter);
        addCharacter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("addCharacter");
                NewView dialog= new NewView("uj karakter felvitele","Adja meg a karakter nevet: ",frame);
                dialog.dialog.setLocationRelativeTo(frame);
                dialog.dialog.setVisible(true);
            }
        });
        newData.add(addHouse);
        addHouse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("addHouse");
                NewView dialog= new NewView("uj haz felvitele","Adja meg a haz nevet: ","cimer: ",frame);
                dialog.dialog.setLocationRelativeTo(frame);
                dialog.dialog.setVisible(true);
            }
        });
        newData.add(addStudent);
        addStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("addStudent");
                NewView dialog= new NewView("uj tanulo felvitele","Adja meg a tanulo nevet: ","eletkor: ",frame);
                dialog.dialog.setLocationRelativeTo(frame);
                dialog.dialog.setVisible(true);
            }
        });
        newData.add(addFirstMet);
        addFirstMet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("addFirstMet");
            }
        });
        modify.add(changeCharacter);
        changeCharacter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("changeCharacter");
            }
        });
        modify.add(solveHousing);
        solveHousing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("solveHousing");
            }
        });
        filter.add(list);
        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("list");
            }
        });
        filter.add(searchNames);
        searchNames.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("searchNames");
            }
        });

    }
}
