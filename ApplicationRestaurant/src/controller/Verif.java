/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Dao.UserDao;
import Modele.UserModele;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.Dashboard;
import view.Login;

/**
 *
 * @author ACER
 */
public class Verif implements ActionListener{    
    Login login;
    public static view.Dashboard dash;
    public Verif(Login login) {
        this.login = login;
    }
    public void actionPerformed(ActionEvent event){
        try {
            String nom = login.email.getText();
            String pwd = login.password.getText();
            UserModele user = new UserModele();
            user.setNom(nom);
            user.setPassword(pwd);
            UserDao dao = new UserDao();
            boolean verif = dao.verifUser(user);
            if (verif){
                login.setVisible(false);
                dash = new Dashboard();
                dash.setVisible(true);
     //             Dashboard.main();
            } else {
                     JOptionPane.showMessageDialog(null, "Erreur d'authentification veuillez taper votre nouveau login et votre mot de passe ","Authentification diso",JOptionPane.ERROR_MESSAGE);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Verif.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
