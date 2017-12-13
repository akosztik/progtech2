package harry.potter.view;

import harry.potter.controller.service.CharacterService;
import harry.potter.controller.service.CreatureService;
import harry.potter.controller.service.HouseService;
import harry.potter.controller.service.StudentService;
import harry.potter.model.Creature;
import harry.potter.model.House;
import harry.potter.model.Student;
import harry.potter.model.Character;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainMenu{

    private JMenuBar menuBar;
    private JMenu newData;
    private JMenu modify;
    private JMenu filter;
    private JMenuItem addFirstMet;
    private JMenuItem addCreature;
    private JMenuItem addHouse;
    private JMenuItem addStudent;
    private JMenuItem addCharacter;
    private JMenuItem changeCharacter;
    private JMenuItem solveHousing;
    private JMenuItem list;
    private JMenuItem searchNames;


    /**
     * Ezzel a konstruktorral peldanyositjuk a MainMenu nevu osztalyt.
     */

    public MainMenu(JFrame frame, JPanel panel){

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
                dialog.getDialog().setLocationRelativeTo(frame);
                dialog.getDialog().setVisible(true);
            }
        });
        newData.add(addCharacter);
        addCharacter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("addCharacter");
                NewView dialog= new NewView("uj karakter felvitele","Adja meg a karakter nevet: ",frame);
                dialog.getDialog().setLocationRelativeTo(frame);
                dialog.getDialog().setVisible(true);
            }
        });
        newData.add(addHouse);
        addHouse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("addHouse");
                NewView dialog= new NewView("uj haz felvitele","Adja meg a haz nevet: ","cimer: ",frame);
                dialog.getDialog().setLocationRelativeTo(frame);
                dialog.getDialog().setVisible(true);
            }
        });
        newData.add(addStudent);
        addStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("addStudent");
                NewView dialog= new NewView("uj tanulo felvitele","Adja meg a tanulo nevet: ","eletkor: ",frame);
                dialog.getDialog().setLocationRelativeTo(frame);
                dialog.getDialog().setVisible(true);
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
                ModifyCharacter mc = new ModifyCharacter("Jellemváltozás", "Válasszon : ", frame);
                mc.getDialog().setLocationRelativeTo(frame);
                mc.getDialog().setVisible(true);

            }
        });
        modify.add(solveHousing);
        solveHousing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("solveHousing");
                SolveHousing sh = new SolveHousing("Teszlek Süveg :)", "Válasszon diákot! ", frame);
                sh.getDialog().setLocationRelativeTo(frame);
                sh.getDialog().setVisible(true);
            }
        });
        filter.add(list);
        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("list");
                FilterView filter = new FilterView();
                filter.selectBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == filter.selectBox) {
                            JComboBox cb = (JComboBox) e.getSource();
                            String selectedFilter = (String) cb.getSelectedItem();
                            DefaultTableModel tableModel;
                            JTable table;
                            JPanel pan;
                            switch (selectedFilter) {
                                case "házak":
                                    System.out.println("házak");
                                    HouseService hs = new HouseService();
                                    List<House> houses = hs.listHouses();
                                    System.out.println("házak");
                                    String colH[] = {"azonosító", "név", "címer"};
                                    tableModel = new DefaultTableModel(colH, 0);
                                    table = new JTable(tableModel);
                                    for (House house : houses) {
                                        Object[] rowInput = {house.getId(), house.getName(), house.getCrest()};
                                        tableModel.addRow(rowInput);
                                    }
                                    pan = new JPanel(new BorderLayout());
                                    pan.add(table.getTableHeader(), BorderLayout.PAGE_START);
                                    pan.add(table, BorderLayout.CENTER);
                                    //remove panels:
                                    filter.tablePanel.removeAll();
                                    filter.tablePanel.repaint();
                                    filter.tablePanel.revalidate();
                                    //adding panels:
                                    filter.tablePanel.add(pan);
                                    filter.tablePanel.repaint();
                                    filter.tablePanel.revalidate();
                                    System.out.println("házak");
                                    break;
                                case "tanulók":
                                    System.out.println("tanulók");
                                    StudentService ss = new StudentService();
                                    List<Student> Student = ss.listStudents();
                                    String colS[] = {"azonosító", "név", "kor", "jellem"};
                                    tableModel = new DefaultTableModel(colS, 0);
                                    table = new JTable(tableModel);
                                    for (Student student : Student) {
                                        Object[] rowInput = {student.getId(), student.getName(), student.getAge(), student.getCharacter()};
                                        tableModel.addRow(rowInput);
                                    }
                                    pan = new JPanel(new BorderLayout());
                                    pan.add(table.getTableHeader(), BorderLayout.PAGE_START);
                                    pan.add(table, BorderLayout.CENTER);
                                    //remove panels:
                                    filter.tablePanel.removeAll();
                                    filter.tablePanel.repaint();
                                    filter.tablePanel.revalidate();
                                    //adding panels:
                                    filter.tablePanel.add(pan);
                                    filter.tablePanel.repaint();
                                    filter.tablePanel.revalidate();
                                    System.out.println("házak");
                                    break;

                                case "jellemek":
                                    System.out.println("jellemek");
                                    CharacterService cs = new CharacterService();
                                    List<Character> characters = cs.listCharacters();
                                    String colC[] = {"azonosító", "név"};
                                    tableModel = new DefaultTableModel(colC, 0);
                                    table = new JTable(tableModel);
                                    for (Character character : characters) {
                                        Object[] rowInput = {character.getId(), character.getName()};
                                        tableModel.addRow(rowInput);
                                    }
                                    pan = new JPanel(new BorderLayout());
                                    pan.add(table.getTableHeader(), BorderLayout.PAGE_START);
                                    pan.add(table, BorderLayout.CENTER);
                                    //remove panels:
                                    filter.tablePanel.removeAll();
                                    filter.tablePanel.repaint();
                                    filter.tablePanel.revalidate();
                                    //adding panels:
                                    filter.tablePanel.add(pan);
                                    filter.tablePanel.repaint();
                                    filter.tablePanel.revalidate();
                                    break;
                                case "lények":
                                    System.out.println("lények");
                                    CreatureService crs = new CreatureService();
                                    List<Creature> creatures = crs.listCreatures();
                                    String colCR[] = {"azonosító", "név", "jellem"};
                                    tableModel = new DefaultTableModel(colCR, 0);
                                    table = new JTable(tableModel);
                                    for (Creature creature : creatures) {
                                        Object[] rowInput = {creature.getId(), creature.getName(), creature.getCharacter()};
                                        tableModel.addRow(rowInput);
                                    }
                                    pan = new JPanel(new BorderLayout());
                                    pan.add(table.getTableHeader(), BorderLayout.PAGE_START);
                                    pan.add(table, BorderLayout.CENTER);
                                    //remove panels:
                                    filter.tablePanel.removeAll();
                                    filter.tablePanel.repaint();
                                    filter.tablePanel.revalidate();
                                    //adding panels:
                                    filter.tablePanel.add(pan);
                                    filter.tablePanel.repaint();
                                    filter.tablePanel.revalidate();
                                    break;
                            }
                        }
                    }
                });
                //remove panels:
                panel.removeAll();
                panel.repaint();
                panel.revalidate();
                //adding panels:
                panel.add(filter.panel);
                panel.repaint();
                panel.revalidate();
            }
        });
        filter.add(searchNames);
        searchNames.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("searchNames");
                searchName sn = new searchName();
                sn.selectBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == sn.selectBox) {
                            JComboBox cb = (JComboBox) e.getSource();
                            sn.selectedFilter = (String) cb.getSelectedItem();
                        }
                    }
                });
                sn.button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DefaultTableModel tableModel;
                        JTable table;
                        JPanel pan;
                        switch (sn.selectedFilter) {
                            case "tanulók":
                                System.out.println("search tanulók");
                                StudentService ss = new StudentService();
                                Student student = ss.getStudentsByName(sn.text.getText());
                                String colS[] = {"azonosító", "név", "kor", "jellem"};
                                tableModel = new DefaultTableModel(colS, 0);
                                table = new JTable(tableModel);
                                pan = new JPanel(new BorderLayout());
                                try {
                                    Object[] rowInputS = {student.getId(), student.getName(), student.getAge(), student.getCharacter()};
                                    tableModel.addRow(rowInputS);
                                    pan.add(table.getTableHeader(), BorderLayout.PAGE_START);
                                    pan.add(table, BorderLayout.CENTER);
                                }catch(Exception exception){
                                    Alert.infoBox("A név nem létezik!","tanuló ellenőrzése");
                                }
                                //remove panels:
                                sn.tablePanel.removeAll();
                                sn.tablePanel.repaint();
                                sn.tablePanel.revalidate();
                                //adding panels:
                                sn.tablePanel.add(pan);
                                sn.tablePanel.repaint();
                                sn.tablePanel.revalidate();
                                System.out.println("házak");
                                break;
                            case "lények":
                                System.out.println("search lények");
                                CreatureService crs = new CreatureService();
                                Creature creature = crs.getCreatureByName(sn.text.getText());
                                String colCR[] = {"azonosító", "név", "jellem"};
                                tableModel = new DefaultTableModel(colCR, 0);
                                table = new JTable(tableModel);
                                pan = new JPanel(new BorderLayout());
                                try{
                                    Object[] rowInput = {creature.getId(), creature.getName(), creature.getCharacter()};
                                    tableModel.addRow(rowInput);
                                    pan.add(table.getTableHeader(), BorderLayout.PAGE_START);
                                    pan.add(table, BorderLayout.CENTER);
                                }catch(Exception exception){
                                    Alert.infoBox("A név nem létezik!","lény ellenőrzése");
                                }
                                //remove panels:
                                sn.tablePanel.removeAll();
                                sn.tablePanel.repaint();
                                sn.tablePanel.revalidate();
                                //adding panels:
                                sn.tablePanel.add(pan);
                                sn.tablePanel.repaint();
                                sn.tablePanel.revalidate();
                                break;
                        }

                    }
                });
                //remove panels:
                panel.removeAll();
                panel.repaint();
                panel.revalidate();
                //adding panels:
                panel.add(sn.panel);
                panel.repaint();
                panel.revalidate();
            }

        });
        }

}