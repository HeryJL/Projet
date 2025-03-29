/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import common.AccesBdd;
import java.sql.SQLException;
import model.UserModel;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ClientModel;
import model.HotelModel;
import model.PanierModel;
import model.SiteModel;
import model.VilleModel;
import model.VolModel;
import org.jboss.weld.module.web.servlet.SessionHolder;

/**
 *
 * @author Hery
 */
public class Dao {
    public boolean verifUser(UserModel user) throws SQLException{
        boolean verif =false;
        String sql = "SELECT * FROM USER WHERE nom='"+user.getNom()+"' AND password = '"+user.getPws()+"'";
        AccesBdd acces =new AccesBdd();
        acces.loadDriver();
        ResultSet result = acces.executeSelect(sql);
        while(result.next()){
            verif=true; 
        }   
        acces.closeConnection();
        System.out.println(verif);
        return verif;
    }
    public void insertUser(UserModel user){
       AccesBdd acces =new AccesBdd();
       acces.loadDriver();
       String sql = "INSERT INTO USER (nom,mail,password,statut) VALUES('"+user.getNom()+"','"+user.getMail()+"','"+user.getPws()+"','"+user.getStatut()+"')";
       acces.executeUpdate(sql);
    }
    public List<VilleModel> findVille(){
    List<VilleModel> villeliste=new ArrayList<VilleModel>();
    String sql = "SELECT * FROM VILLE";
    AccesBdd acces = new AccesBdd();
    acces.loadDriver();
    ResultSet resultat= acces.executeSelect(sql);
        try {
            while(resultat.next()){
                VilleModel ville = new VilleModel();
                ville.setId_ville(resultat.getInt("id_ville"));
                ville.setNom_ville(resultat.getString("nom_ville"));
                ville.setPays(resultat.getString("pays"));
                ville.setImg_ville(resultat.getString("img_ville"));
                villeliste.add(ville);
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        acces.closeConnection();
    return  villeliste;
    }
     public List<VilleModel> topVille(){
    List<VilleModel> villeliste=new ArrayList<VilleModel>();
    String sql = "SELECT * FROM ville ORDER BY nb_visite DESC LIMIT 3";
    AccesBdd acces = new AccesBdd();
    acces.loadDriver();
    ResultSet resultat= acces.executeSelect(sql);
        try {
            while(resultat.next()){
                VilleModel ville = new VilleModel();
                ville.setId_ville(resultat.getInt("id_ville"));
                ville.setNom_ville(resultat.getString("nom_ville"));
                ville.setPays(resultat.getString("pays"));
                ville.setImg_ville(resultat.getString("img_ville"));
                villeliste.add(ville);
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        acces.closeConnection();
    return  villeliste;
    }
    
    
    
    public List<VolModel> findVol( ){
    List<VolModel> volList= new ArrayList<VolModel>();
    String sql = "SELECT * FROM vol";
    AccesBdd acces = new AccesBdd();
    acces.loadDriver();
    ResultSet resultat= acces.executeSelect(sql);
        try {
            while(resultat.next()){
                VolModel vol = new VolModel();
                vol.setId_vol(resultat.getInt("id_vol"));
                vol.setDate_vol(resultat.getString("date_vol"));
                vol.setDestination(resultat.getString("destination"));
                vol.setPrix(resultat.getInt("prix_vol"));
                vol.setImg_vol(resultat.getString("img_vol"));
                vol.setNom_comp(resultat.getString("nom_comp"));
                vol.setDuree_vol(resultat.getString("duree_vol"));
                vol.setNb_billet(resultat.getInt("nb_billet"));
                volList.add(vol);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return volList;
    }
    
    
    public  List<HotelModel> findHotel(){
    List<HotelModel> hotelList= new ArrayList<HotelModel>();
    String sql = "SELECT * FROM hotel";
    AccesBdd acces = new AccesBdd();
    acces.loadDriver();
    ResultSet resultat = acces.executeSelect(sql);
        try {
            while(resultat.next()){
            HotelModel hotel = new HotelModel();
            hotel.setId_hotel(resultat.getInt("id_hotel"));
            hotel.setNom_hotel(resultat.getString("nom_hotel"));
            hotel.setVille(resultat.getString("localisation"));
            hotel.setPrix(resultat.getInt("prix_hotel"));
            hotel.setImg_hotel(resultat.getString("img_hotel"));
            hotel.setNb_chambre(resultat.getInt("nb_chambre"));
            hotelList.add(hotel);
            }
            {
            }   } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        acces.closeConnection();
        return hotelList;
    }
     public  List<SiteModel> findSite(){
    List<SiteModel> siteList = new ArrayList<SiteModel>();
    String sql = "SELECT * FROM site ";
    AccesBdd acces =new AccesBdd();
    acces.loadDriver();
    ResultSet resultat = acces.executeSelect(sql);
        try {
            while (resultat.next()){
                SiteModel site = new SiteModel();
                site.setId_site(resultat.getInt("id_site"));
                site.setNom_site(resultat.getString("nom_site"));
                site.setLoca_site(resultat.getString("local_site"));
                site.setPrix(resultat.getInt("Prix"));
                siteList.add(site);
            }   
        } 
        catch (SQLException ex) {
            Logger.getLogger(RechercheDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    return  siteList;
    }
    
     public UserModel findUser(String nom) throws SQLException{
     UserModel user = new UserModel();
     AccesBdd acces= new AccesBdd();
     acces.loadDriver();
     String sql ="SELECT * FROM user WHERE nom='"+nom+"'";
     ResultSet res= acces.executeSelect(sql);
         while (res.next()) {             
            user.setMail(res.getString("mail"));
            user.setStatut(res.getString("statut"));
            user.setImg(res.getString("img_user"));
         }
     return user;
     }
     
     
    public  ClientModel findClient(String nom) throws SQLException{
    ClientModel client= new ClientModel();
     AccesBdd acces= new AccesBdd();
     acces.loadDriver();
     String sql ="SELECT * FROM client WHERE nom='"+nom+"'";
     ResultSet res= acces.executeSelect(sql);
    while(res.next()){
        client.setIdClient(Integer.parseInt(res.getString("id_client")));
        client.setLocalisaion(res.getString("locqlisqtion"));
        client.setNom_client(res.getString("nom_client"));
        client.setMail(res.getString("mail_client"));
        client.setDate(res.getString("date"));
        client.setMontant(Integer.parseInt(res.getString("montant")));
        client.setTel(Integer.parseInt(res.getString("tel")));
    }
    return client;
    }
    public int total(String nom) throws SQLException{
    int total = 0;
    AccesBdd acces= new AccesBdd();
    acces.loadDriver();
    String sql ="SELECT SUM(montant) as total FROM client WHERE nom_client='"+nom+"'";
     ResultSet res= acces.executeSelect(sql);
     while(res.next()){
         total=res.getInt("total");
        }
    return total;
    }
    
    
    public  int achat(String nom) throws SQLException{
      int total = 0;
    AccesBdd acces= new AccesBdd();
    acces.loadDriver();
    String sql ="SELECT COUNT(nom_client) as total FROM client WHERE nom_client='"+nom+"'";
     ResultSet res= acces.executeSelect(sql);
     while(res.next()){
         total=res.getInt("total");
        }
    return total;
    }
    
    public List<PanierModel> listPanier(String nom) throws SQLException{
    List<PanierModel> listPanier = new ArrayList<PanierModel>();
    String sql = "SELECT * FROM panier WHERE nom_user='"+nom+"' AND payement='1N'";
    AccesBdd acces = new AccesBdd(); 
    acces.loadDriver();
    ResultSet rs = acces.executeSelect(sql);
    while(rs.next()){
        PanierModel panier= new PanierModel();
        panier.setDate_panier(rs.getString("date_panier"));
        panier.setType_item(rs.getString("type_item"));
        panier.setNb_pers(rs.getInt("nb_pers"));
        panier.setPayement(rs.getBoolean("payement"));
        listPanier.add(panier);
   
    }
     return listPanier;
    }
}