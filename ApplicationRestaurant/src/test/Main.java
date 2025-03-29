/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import Dao.MenuDao;
import Modele.MenuModele;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ACER
 */
public class Main {
    public static void main(String[] args) throws SQLException {
       MenuDao menu = new MenuDao();
//        List<MenuModele> listee = menu.listePlat();
//        for(MenuModele l : listee){
//            System.out.println(l.getNom());
//            System.out.println(l.getPrix());
//        }
    String dir=System.getProperty("user.dir");
        System.err.println(dir);
        System.err.println(menu.retounerNombre("disponibilite"));
            
    }
}
