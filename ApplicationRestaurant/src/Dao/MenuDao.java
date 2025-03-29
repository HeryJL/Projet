package Dao;

import Modele.MenuModele;
import common.AccesBdd;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MenuDao {
    public List<MenuModele> listes(String sql) throws SQLException{
        List<MenuModele> tousLesPlat = new ArrayList<MenuModele>();
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        ResultSet resultat = acces.executeSelect(sql);
        while(resultat.next()){
            MenuModele menu = new MenuModele();
            menu.setId(resultat.getInt("id"));
            menu.setNom(resultat.getString("nom"));
            menu.setPrix(resultat.getInt("prix"));
            menu.setDisponible(resultat.getInt("disponibilite"));
            menu.setPhoto(resultat.getString("photo"));
            tousLesPlat.add(menu);
        }
        acces.closeConnection();
        return tousLesPlat;
    }
    public List<MenuModele> listePlat() throws SQLException{
        String sql = "SELECT * FROM menu";
        List<MenuModele> tousLesPlat = listes(sql);
        return tousLesPlat;
    }
    public List<MenuModele> listePlatRechercher(String mots) throws SQLException{
        String sql = "SELECT * FROM menu WHERE nom LIKE '%"+mots+"%'";
        List<MenuModele> tousLesPlat = listes(sql);
        return tousLesPlat;
    }
    public MenuModele elementModif(int id) throws SQLException{
        String sql = "SELECT * FROM menu WHERE id = '"+id+"'";
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        ResultSet resultat = acces.executeSelect(sql); 
        MenuModele menu = new MenuModele();
        if(resultat.next()){          
            menu.setId(resultat.getInt("id"));
            menu.setNom(resultat.getString("nom"));
            menu.setPrix(resultat.getInt("prix"));
            menu.setDisponible(resultat.getInt("disponibilite"));
            menu.setPhoto(resultat.getString("photo"));
        }
        acces.closeConnection();
        return menu;
    }
    public void ajoutMenu(MenuModele menu){
        String sql = "INSERT INTO menu(nom,prix,disponibilite,photo) VALUES"
                + "('"+menu.getNom()+"','"+menu.getPrix()+"','"+menu.getDisponible()+"','"+menu.getPhoto()+"')";
        AccesBdd acces = new AccesBdd();
        acces.executeUpdate(sql);
        acces.closeConnection();
    }
    public void modifMenu(MenuModele menu){
        String sql = "UPDATE menu SET nom='"+menu.getNom()+"',prix='"+menu.getPrix()+"',disponibilite='"+menu.getDisponible()+"'"
                + ",photo='"+menu.getPhoto()+"'  WHERE id='"+menu.getId()+"'";
        AccesBdd acces = new AccesBdd();
        acces.executeUpdate(sql);
        acces.closeConnection();
    }
    public void supprimerMenu(int id){
        String sql = "DELETE FROM menu WHERE id='"+id+"'";
        AccesBdd acces = new AccesBdd();
        acces.executeUpdate(sql);
        acces.closeConnection();
    }
    public int retounerNombre(String table) {
        int nombre=0;
        String sql = "SELECT SUM("+table+") AS somme  FROM menu ";
        AccesBdd acces = new AccesBdd();
        ResultSet r=acces.executeSelect(sql);
        try {
            while (r.next()) {
                nombre=r.getInt("somme");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        acces.closeConnection();
        
        
        return nombre;
    }
}
