/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import java.sql.ResultSet; 
import Modele.UserModele;
import common.AccesBdd;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class UserDao {
    public boolean verifUser(UserModele user) throws SQLException{
        boolean verif = false;
        String sql = "SELECT * FROM user WHERE nom='"+user.getNom()+"' AND password='"+user.getPassword()+"'";
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        ResultSet resultat = acces.executeSelect(sql);
        while(resultat.next()){
            verif = true;
        }
        return verif;
    
    }
    
    
}
