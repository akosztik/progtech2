package harry.potter.view;

import harry.potter.controller.service.CharacterService;
import harry.potter.controller.service.CreatureService;
import harry.potter.controller.service.StudentService;
import harry.potter.model.Character;
import harry.potter.model.Creature;
import harry.potter.model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ModifyCharacter {

    private JDialog dialog;
    private JButton button;
    private JPanel card;
    private JComboBox selectType;
    private JComboBox selectName;
    private JComboBox selectChar;
    String selectedName;
    String selectedChar;

    public ModifyCharacter(String d,String l,JFrame f) {
        JPanel pan = new JPanel();
        pan.setLayout(new BorderLayout());
        JPanel pan2 = new JPanel();
        pan2.setLayout(new FlowLayout());
        card = new JPanel();
        card.setLayout(new CardLayout());

        dialog = new JDialog(f);
        dialog.setResizable(true);
        dialog.setTitle(d);

        String[] filterOptions = {"tanulók", "lények"};
        selectType = new JComboBox(filterOptions);
        selectType.setSelectedIndex(1);

        pan2.add(new JLabel(l));
        pan2.add(selectType);
        button = new JButton("Módosítás");
        dialog.getContentPane().add(pan);
        pan.add(pan2, BorderLayout.NORTH);
        pan.add(card, BorderLayout.CENTER);
        pan.setVisible(true);
        dialog.pack();
        selectType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == selectType) {
                    JComboBox cb = (JComboBox) e.getSource();
                    String selectedFilter = (String) cb.getSelectedItem();
                    JPanel combos;
                    switch (selectedFilter) {
                        case "lények":
                            System.out.println("lények");
                            CreatureService cs = new CreatureService();
                            java.util.List<Creature> creatures = cs.listCreatures();
                            String[] filterOptions = cs.toArray(creatures);
                            selectName = new JComboBox(filterOptions);
                            combos = new JPanel(new GridLayout(3, 1));
                            combos.add(selectName);
                            selectName.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == selectName) {
                                        JComboBox comboName = (JComboBox) e.getSource();
                                        selectedName = (String) comboName.getSelectedItem();
                                        System.out.println("setselected name");
                                    }
                                }
                            });
                            CharacterService chars = new CharacterService();
                            java.util.List<Character> characters = chars.listCharacters();
                            String[] filterOpt = chars.toArray(characters);
                            selectChar = new JComboBox(filterOpt);
                            combos.add(selectChar);
                            System.out.println("setselected name");
                            selectChar.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == selectChar) {
                                        JComboBox comboChar = (JComboBox) e.getSource();
                                        selectedChar = (String) comboChar.getSelectedItem();
                                        System.out.println("setselected char");
                                    }
                                }
                            });
                            combos.add(button);
                            button.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    System.out.println("changeCharOfCreature");
                                    CreatureService cs = new CreatureService();
                                    cs.changeCharacter(selectedName, selectedChar);
                                    dialog.setVisible(false);
                                }
                            });
                            card.removeAll();
                            card.repaint();
                            card.revalidate();
                            //adding panels:
                            card.add(combos);
                            card.repaint();
                            card.revalidate();
                            dialog.pack();
                            break;

                        case "tanulók":
                            System.out.println("tanulók");
                            StudentService ss = new StudentService();
                            java.util.List<Student> students = ss.listStudents();
                            String[] filterOptionsS = ss.toArray(students);
                            selectName = new JComboBox(filterOptionsS);
                            combos = new JPanel(new GridLayout(3, 1));
                            combos.add(selectName);
                            selectName.setSelectedIndex(1);
                            selectName.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == selectName) {
                                        JComboBox comboName = (JComboBox) e.getSource();
                                        selectedName = (String) comboName.getSelectedItem();
                                    }
                                }
                            });
                            CharacterService charsS = new CharacterService();
                            List<Character> charactersS = charsS.listCharacters();
                            String[] filterOptS = charsS.toArray(charactersS);
                            selectChar = new JComboBox(filterOptS);
                            combos.add(selectChar);
                            selectChar.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == selectChar) {
                                        JComboBox comboChar = (JComboBox) e.getSource();
                                        selectedChar = (String) comboChar.getSelectedItem();
                                    }
                                }
                            });
                            combos.add(button);
                            button.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    System.out.println("changeCharOfStudent");
                                    CreatureService cs = new CreatureService();
                                    cs.changeCharacter(selectedName, selectedChar);
                                    dialog.setVisible(false);
                                }
                            });
                            //remove panels:
                            card.removeAll();
                            card.repaint();
                            card.revalidate();
                            //adding panels:
                            card.add(combos);
                            card.repaint();
                            card.revalidate();
                            dialog.pack();
                            break;
                    }
                }
            }
        });
    }

    public JDialog getDialog() {
        return dialog;
    }
}
