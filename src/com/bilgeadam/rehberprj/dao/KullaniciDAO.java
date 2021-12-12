package com.bilgeadam.rehberprj.dao;

import com.bilgeadam.rehberprj.dto.KullaniciDTO;
import com.bilgeadam.rehberprj.vt.VTBaglanti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KullaniciDAO {

    public static boolean girişeYetkilimi(KullaniciDTO kullanici)
            throws SQLException, ClassNotFoundException {

        String vtSifre = null;

        Connection conn = VTBaglanti.baglantiGetir();

        String sorgu ="select sifre from kullanici where kullanici_adi=?";


                PreparedStatement ps = conn.prepareStatement(sorgu);

                ps.setString(1, kullanici.getKullaniciAdi());

                ResultSet rs = ps.executeQuery();

                while (rs.next())
                {
                    vtSifre = rs.getString("sifre");
                }

                rs.close();

                ps.close();
                VTBaglanti.baglantiKapat(conn);

                if(kullanici.getSifre().equals(vtSifre))
                    return true;
                else
                    return false;

    }

}
