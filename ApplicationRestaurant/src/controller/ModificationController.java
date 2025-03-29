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
import view.ListesPlat;
import static view.ListesPlat.idModif;
import view.Modifier;
import static  view.Modifier.photo;

/**
 *
 * @author macbook
 */
public class ModificationController implements  ActionListener{
    Modifier modifPanel;
    public ModificationController(Modifier modifPanel){
        this.modifPanel=modifPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object sourceEvenement=e.getSource();
       if(sourceEvenement==modifPanel.btnModif){
                   try {
            // TODO add your handling code here:
            String photos =photo;
            if(!"".equals(modifPanel.lblcadre.getText())){
             photos = modifPanel.lblcadre.getText();
            Path source = Paths.get(photos);
            Path filename = source.getFileName();
            Path target = Paths.get(System.getProperty("user.dir")+"/src/images/"+filename);
            //JOptionPane.showMessageDialog(null, photo+"et le filename="+filename," erreur d'insertion",JOptionPane.ERROR_MESSAGE);
            try {
                Files.copy(source,target);
                photos = filename.toString();
            } catch (Exception ex) {
                photos = photo;
            }
            }
           
            MenuModele m = new MenuModele();
            m.setId(idModif);
            m.setNom(modifPanel.nomModif.getText());
            m.setDisponible(Integer.parseInt(modifPanel.quantiteModif.getText()));
            m.setPrix(Integer.parseInt(modifPanel.prixModif.getText()));
            m.setPhoto(photos);
            MenuDao menuDao = new MenuDao();
            menuDao.modifMenu(m);
            ListesPlat admin = new ListesPlat();
            dash.aseovo(admin);
        } catch (SQLException ex) {
            Logger.getLogger(ModificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       }else if (sourceEvenement==modifPanel.btnChanger) {
            
            JFileChooser f = new JFileChooser();
            f.showDialog(modifPanel,"Choisir un fichier image");
            File fichier = f.getSelectedFile();
            BufferedImage img;       
            try {
                img = ImageIO.read(fichier);
               img.getScaledInstance(250,250,Image.SCALE_SMOOTH);
                modifPanel.lblcadre.setIcon(new ImageIcon(img));
                modifPanel.lblcadre.setText(fichier.getPath());
            } catch (IOException ex) {
                Logger.getLogger(ModificationController.class.getName()).log(Level.SEVERE, null, ex);
            }


           
        }
    }
}
