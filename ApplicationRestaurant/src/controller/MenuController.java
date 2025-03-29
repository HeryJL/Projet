/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Dao.MenuDao;
import Modele.MenuModele;
import static controller.Verif.dash;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import view.AjoutMenu;
import view.ListesPlat;

/**
 *
 * @author macbook
 */
public class MenuController implements ActionListener{
    
     AjoutMenu menuP;
    public MenuController(AjoutMenu menuP) {
        this.menuP = menuP;
    }
     @Override
    public void actionPerformed(ActionEvent event){
        Object sourceEvenement=event.getSource();
        if(sourceEvenement==menuP.buttAjout){
                try {                                         
            // TODO add your handling code here:
            String photo = menuP.photoPlat.getText();
            Path source = Paths.get(photo);
            Path filename = source.getFileName();
            Path target = Paths.get(System.getProperty("user.dir")+"/src/images/"+filename);
            //JOptionPane.showMessageDialog(null, photo+"et le filename="+filename," erreur d'insertion",JOptionPane.ERROR_MESSAGE);
            try {
                Files.copy(source,target);
                photo = filename.toString();
            } catch (IOException e) {
                photo = "p.png";
            }
            String nom = menuP.nomPlat.getText();
            String prix = menuP.prixPlat.getText();
            String disponible = menuP.quantitePlat.getText();
            MenuModele menu = new MenuModele();
            menu.setPhoto(photo);
            menu.setNom(nom);
            menu.setDisponible(Integer.parseInt(disponible));
            menu.setPrix(Integer.parseInt(prix));
            MenuDao dao = new MenuDao();
            dao.ajoutMenu(menu);
            ListesPlat listesPlat = new ListesPlat();
            dash.aseovo(listesPlat);
        } catch (SQLException ex) {
            Logger.getLogger(AjoutMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else if (sourceEvenement==menuP.butImporter) {
                    try {
            JFileChooser f = new JFileChooser();
            f.showDialog(menuP.jPanel1,"Choisir un fichier image");
            File fichier = f.getSelectedFile();
            BufferedImage img = ImageIO.read(fichier);
           
            img.getScaledInstance(250,250,Image.SCALE_SMOOTH);
            menuP.photoPlat.setIcon(new ImageIcon(img));
            menuP.photoPlat.setText(fichier.getPath());
        } catch (Exception e) {
        }
             
         }

        
    }
}
