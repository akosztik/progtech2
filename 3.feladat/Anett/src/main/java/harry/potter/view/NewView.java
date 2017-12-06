package harry.potter.view;

import harry.potter.controller.service.CharacterService;
import harry.potter.controller.service.CreatureService;
import harry.potter.controller.service.HouseService;
import harry.potter.controller.service.StudentService;
import harry.potter.model.Creature;
import harry.potter.model.Character;
import harry.potter.model.House;
import harry.potter.model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NewView {
    private JDialog dialog;
    private JButton button;

    public NewView(String d, String l, Frame f) {
        JPanel pan = new JPanel();
        pan.setLayout(new BorderLayout());
        dialog = new JDialog(f);
        dialog.setResizable(true);
        dialog.setTitle(d);
        dialog.setModal(true);
        //dialog.add(new JLabel(l));
        pan.add(new JLabel(l),BorderLayout.WEST);
        JTextField text = new JTextField(20);
        pan.add(text, BorderLayout.EAST);
        //dialog.add(text);
        button = new JButton("Bevitel");
        //dialog.add(button);
        pan.add(button,BorderLayout.SOUTH);
        dialog.add(pan);
        dialog.pack();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (d == "uj leny felvitele") {
                    Creature creature = new Creature(text.getText());
                    CreatureService cs = new CreatureService();
                    cs.addCreature(creature);
                    dialog.setVisible(false);
                } else {
                    Character character = new Character(text.getText());
                    CharacterService cs = new CharacterService();
                    cs.addCharacter(character);
                    dialog.setVisible(false);
                }
            }
        });

    }

    public NewView(String d, String l, String ll, Frame f) {
        JPanel pan = new JPanel();
        pan.setLayout(new BorderLayout());
        JPanel pan2 = new JPanel();
        pan2.setLayout(new GridLayout(0,2));
        pan.add(pan2, BorderLayout.NORTH);
        dialog = new JDialog(f);
        dialog.setResizable(true);
        dialog.setTitle(d);
        //dialog.add(new JLabel(l));
        pan2.add(new JLabel(l));
        JTextField text = new JTextField(20);
        //dialog.add(text);
        pan2.add(text);
        //dialog.add(new JLabel(ll));
        pan2.add(new JLabel(ll));
        JTextField text2 = new JTextField(20);
        //dialog.add(text2);
        pan2.add(text2);
        button = new JButton("Bevitel");
        pan.add(button, BorderLayout.SOUTH);
        //dialog.add(button);
        dialog.add(pan);
        dialog.pack();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (d=="uj haz felvitele"){
                    House house= new House(text.getText(),text2.getText());
                    HouseService hs =new HouseService();
                    hs.addHouse(house);
                    dialog.setVisible(false);
                }else{
                    Student student= new Student(Integer.parseInt(text2.getText()), text.getText());
                    StudentService ss =new StudentService();
                    ss.addStudent(student);
                    dialog.setVisible(false);
                }

            }
        });

    }
    public Dialog getDialog(){
        return this.dialog;
    }

}
