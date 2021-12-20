package com.bilgeadam.rehberprj.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuForm  extends JFrame{
    private JPanel panel1;
    private JButton ekleButton;


    public  MenuForm()
    {
        add(panel1);



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Menü Ekranı");
        setSize(300,200);
        setLocationRelativeTo(null);

        ekleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EkleForm ekle = new EkleForm();
                ekle.setVisible(true);
            }
        });
    }


   //public static void main(String[] args) {
     //   MenuForm menu =new MenuForm();
       // menu.setVisible(true);
    //}

}
