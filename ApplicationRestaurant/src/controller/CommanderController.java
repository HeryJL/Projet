/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Dao.CommandeDao;
import Modele.DetailComande;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import view.Item;
import view.Menu;
import static controller.Verif.dash;
import javax.swing.JOptionPane;
import view.TableItem;

/**
 *
 * @author ACER
 */
public class CommanderController implements ActionListener{
    Item item;
    public CommanderController(Item item) {
        this.item = item;
    }
    @Override
    public void actionPerformed(ActionEvent event){
        DetailComande com = new DetailComande();
        com.setIdComande(TableItem.numeroCommande);
        com.setIdMenu(Integer.parseInt(item.labidmenu.getText()));
        int quantite;
         try {
            quantite=Integer.parseInt(item.quantiteCmd.getText());
            com.setQuantiter(quantite);
        } catch (java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La quantite doit etre en nombre \n jereo tsara!"," erreur d'insertion",JOptionPane.ERROR_MESSAGE);
        }
        
        com.setTotal(Integer.parseInt(item.p.getText())*com.getQuantiter());
        CommandeDao dao = new CommandeDao();
       
        try {
            if(com.getQuantiter() > 0){
                dao.ajoutCommander(com);
            }
            
            Menu menu = new Menu();
            dash.aseovo((JPanel) menu);
        } catch (SQLException ex) {
            Logger.getLogger(CommanderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
