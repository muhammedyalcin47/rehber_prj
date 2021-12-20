package com.bilgeadam.rehberprj.gui;

import com.bilgeadam.rehberprj.dao.KisiDAO;
import com.bilgeadam.rehberprj.dto.KisiDTO;
import com.bilgeadam.rehberprj.util.CevirmeIslemleri;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

public class EkleForm  extends JFrame{
    private JPanel jpanel1;
    private JTextField noTF;
    private JTextField adTF;
    private JButton EKLEButton;
    private JTextField soyadTF;
    private JTextField maasTF;
    private JTextField dogtarTF;
    private JTextField mobilTelTF;

    public EkleForm() {
        add(jpanel1);

        setTitle("Kişi Ekle Ekranı");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300,300);
        setLocationRelativeTo(null);
        EKLEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    KisiDTO kisi = new KisiDTO();

                    kisi.setNo(Integer.parseInt(noTF.getText()));
                    kisi.setAd(adTF.getText());
                    kisi.setSoyad(soyadTF.getText());
                    kisi.setMaas(Double.parseDouble(maasTF.getText()));
                    kisi.setDogtar(CevirmeIslemleri.strToUtilDate(dogtarTF.getText()));
                    kisi.setMobilTel(mobilTelTF.getText());


                    boolean sonuc = KisiDAO.ekle(kisi);

                    if (sonuc)
                    {
                        JOptionPane.showMessageDialog(null,"Kişi başarıyla eklendi");
                        temizle();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Kişi ekleme başarısız!!!");
                    }


                }
                catch (ParseException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Hata:" + ex.getMessage());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Hata:" + ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Hata:" + ex.getMessage());
                }


            }
        });
    }

    public void temizle()
    {
        noTF.setText("");
        adTF.setText("");
        soyadTF.setText("");
        maasTF.setText("");
        dogtarTF.setText("");
        mobilTelTF.setText("");
    }


//    public static void main(String[] args) {
//        EkleForm ef = new EkleForm();
//        ef.setVisible(true);
//    }
}
