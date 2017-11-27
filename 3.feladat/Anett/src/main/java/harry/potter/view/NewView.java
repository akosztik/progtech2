package harry.potter.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NewView{
    JDialog dialog;
    JButton button;

    public NewView(String d,String l, Frame f){
        JPanel pan= new JPanel();
        pan.setLayout(new FlowLayout());
        dialog= new JDialog(f);
        dialog.setResizable(true);
        dialog.setTitle(d);
        dialog.setModal(true);
        //dialog.add(new JLabel(l));
        pan.add(new JLabel(l));
        JTextField text = new JTextField(20);
        pan.add(text);
        //dialog.add(text);
        button = new JButton("Bevitel");
        //dialog.add(button);
        pan.add(button);
        dialog.add(pan);
        dialog.pack();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("new Item: " +text.getText() + " , " );
                
            }
        });

    }
    public NewView(String d,String l,String ll,Frame f){
        JPanel pan= new JPanel();
        pan.setLayout(new FlowLayout());
        dialog= new JDialog(f);
        dialog.setResizable(true);
        dialog.setTitle(d);
        //dialog.add(new JLabel(l));
        pan.add(new JLabel(l));
        JTextField text = new JTextField(20);
        //dialog.add(text);
        pan.add(text);
        //dialog.add(new JLabel(ll));
        pan.add(new JLabel(ll));
        JTextField text2 = new JTextField(20);
        //dialog.add(text2);
        pan.add(text2);
        button = new JButton("Bevitel");
        pan.add(button);
        //dialog.add(button);
        dialog.add(pan);
        dialog.pack();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("new Item: " +text.getText() + " , " );

            }
        });

    }

}
