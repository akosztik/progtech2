package harry.potter.view;

import harry.potter.controller.service.HouseService;
import harry.potter.model.House;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class searchName {
    JPanel panel;
    JPanel filterPanel;
    JPanel tablePanel;
    JComboBox selectBox;
    JButton button;
    String selectedFilter;
    JTextField text;


    public searchName() {
        this.panel = new JPanel();
        panel.setLayout(new BorderLayout());
        this.filterPanel= new JPanel();
        filterPanel.setLayout(new FlowLayout());
        String[] filterOptions= {"tanulók", "lények"};
        selectBox= new JComboBox(filterOptions);
        JLabel label= new JLabel("Válasszon filtert: ");
        JLabel labelName= new JLabel("név: ");
        text =new JTextField(20);
        button = new JButton("Szűrés");
        selectBox.setSelectedIndex(1);
        filterPanel.add(label);
        filterPanel.add(selectBox);
        filterPanel.add(labelName);
        filterPanel.add(text);
        filterPanel.add(button);
        panel.add(filterPanel,BorderLayout.NORTH);
        tablePanel= new JPanel(new CardLayout());
        panel.add(tablePanel, BorderLayout.CENTER);
    }
}

