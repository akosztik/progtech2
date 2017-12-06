package harry.potter.view;

import harry.potter.controller.service.HouseService;
import harry.potter.model.House;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FilterView {
    JPanel panel;
    JPanel filterPanel;
    JPanel tablePanel;
    JComboBox selectBox;



    public FilterView() {
        this.panel = new JPanel();
        panel.setLayout(new BorderLayout());
        this.filterPanel= new JPanel();
        filterPanel.setLayout(new FlowLayout());
        String[] filterOptions= {"házak", "tanulók","jellemek", "lények"};
        selectBox= new JComboBox(filterOptions);
        JLabel label= new JLabel("Válasszon filtert: ");
        selectBox.setSelectedIndex(1);
        filterPanel.add(label);
        filterPanel.add(selectBox);
        panel.add(filterPanel,BorderLayout.NORTH);
        tablePanel= new JPanel(new CardLayout());
        panel.add(tablePanel, BorderLayout.CENTER);
    }
}
