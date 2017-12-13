package harry.potter.view;

import harry.potter.controller.service.CharacterService;
import harry.potter.controller.service.CreatureService;
import harry.potter.controller.service.HouseService;
import harry.potter.controller.service.StudentService;
import harry.potter.model.Character;
import harry.potter.model.Creature;
import harry.potter.model.House;
import harry.potter.model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SolveHousing {

    private JDialog dialog;
    private JButton button;
    private JPanel card;
    private JComboBox selectName;
    String selectedName;

    public SolveHousing(String d,String l,JFrame f) {
        JPanel pan = new JPanel();
        pan.setLayout(new BorderLayout());
        JPanel pan2 = new JPanel();
        pan2.setLayout(new FlowLayout());
        card = new JPanel();
        card.setLayout(new CardLayout());

        dialog = new JDialog(f);
        dialog.setResizable(true);
        dialog.setTitle(d);

        StudentService ss = new StudentService();
        java.util.List<Student> students = ss.listStudents();
        String[] filterOptions = ss.toArray(students);
        selectName = new JComboBox(filterOptions);
        selectName.setSelectedIndex(1);

        pan2.add(new JLabel(l));
        pan2.add(selectName);
        dialog.getContentPane().add(pan);
        pan.add(pan2, BorderLayout.NORTH);
        pan.add(card, BorderLayout.CENTER);
        pan.setVisible(true);
        dialog.pack();
        selectName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == selectName) {
                    JComboBox cb = (JComboBox) e.getSource();
                    selectedName = (String) cb.getSelectedItem();
                    JPanel combos;
                    combos = new JPanel(new GridLayout(1, 1));
                    HouseService hs = new HouseService();
                    List<House> houses = hs.listHouses();
                    Random rand = new Random();
                    int  n = rand.nextInt(houses.size());
                    String selectedHouse=houses.get(n).getName();
                    ss.setStudentHouse(selectedName,selectedHouse);
                    JTextArea msg=new JTextArea("Nos  lássuk, lássuk, sok mindenben jó vagy, nehéz dönteni! ....  "+selectedHouse+"! Gratulálok!");
                    combos.add(msg);
                    //remove panels:
                    card.removeAll();
                    card.repaint();
                    card.revalidate();
                    //adding panels:
                    card.add(combos);
                    card.repaint();
                    card.revalidate();
                    dialog.pack();


                }
            }
        });
    }
    public SolveHousing(String d,String l,String ll,JFrame f) {
        JPanel pan = new JPanel();
        pan.setLayout(new BorderLayout());
        JPanel pan2 = new JPanel();
        pan2.setLayout(new FlowLayout());
        card = new JPanel();
        card.setLayout(new CardLayout());

        dialog = new JDialog(f);
        dialog.setResizable(true);
        dialog.setTitle(d);

        CreatureService ss = new CreatureService();
        java.util.List<Creature> creatures = ss.listCreatures();
        String[] filterOptions = ss.toArray(creatures);
        selectName = new JComboBox(filterOptions);
        selectName.setSelectedIndex(1);

        pan2.add(new JLabel(l));
        pan2.add(selectName);
        pan2.add(new JLabel(ll));
        JTextField dateString=new JTextField();
        pan2.add(dateString);

        dialog.getContentPane().add(pan);
        pan.add(pan2, BorderLayout.NORTH);
        pan.add(card, BorderLayout.CENTER);
        pan.setVisible(true);
        dialog.pack();
        selectName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == selectName) {
                    JComboBox cb = (JComboBox) e.getSource();
                    selectedName = (String) cb.getSelectedItem();
                    JPanel combos;
                    combos = new JPanel(new GridLayout(1, 1));
                    CreatureService cres = new CreatureService();
                    JTextArea msg;
                    try{
                        cres.updateCreature(selectedName,dateString.getText());
                        msg=new JTextArea("Hozzáadtuk az első fellelést ....  ");
                    }catch(Exception error){
                        Alert.infoBox("Helyesformátum:YYMMDD!","helytelen formatum");
                        msg=new JTextArea("Hozzáadtuk az első fellelést ....  ");
                    }
                    combos.add(msg);
                    //remove panels:
                    card.removeAll();
                    card.repaint();
                    card.revalidate();
                    //adding panels:
                    card.add(combos);
                    card.repaint();
                    card.revalidate();
                    dialog.pack();


                }
            }
        });
    }

    public JDialog getDialog() {
        return dialog;
    }
}
