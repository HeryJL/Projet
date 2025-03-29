/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Modele.PayementModele;
import common.AccesBdd;

/**
 *
 * @author ACER
 */
public class PayementDao {
    public void payer(PayementModele modele){
        String sql = "INSERT INTO payement(id_commande,montant,date_payement) VALUES"
                + "('"+modele.getIdCommande()+"','"+modele.getMontant()+"',now())";
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        acces.executeUpdate(sql);
        acces.closeConnection();
    }
}
