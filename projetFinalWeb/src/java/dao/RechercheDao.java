/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import common.AccesBdd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HotelModel;
import model.SiteModel;
import model.VolModel;

/**
 *
 * @author Hery
 */
public class RechercheDao {
    private String depart;
    private String destination;
    private int nbr;
    private  String date;

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
     
    public List<VolModel> findVol(){
    List<VolModel> volList= new ArrayList<VolModel>();
    String sql = "SELECT * FROM vol WHERE destination='"+this.destination+"' AND dispo>='"+this.nbr+"'AND date_vol='"+this.date+"' AND depart='"+this.depart+"'";
    AccesBdd acces = new AccesBdd();
    acces.loadDriver();
    ResultSet resultat= acces.executeSelect(sql);
        try {
            while(resultat.next()){
                VolModel vol = new VolModel();
                vol.setId_vol(resultat.getInt("id_vol"));
                vol.setDate_vol(resultat.getString("date_vol"));
                vol.setDepart(resultat.getString("depart"));
                vol.setDestination(resultat.getString("destination"));
                vol.setPrix(resultat.getInt("prix_vol"));
                vol.setImg_vol(resultat.getString("img_vol"));
                vol.setNom_comp(resultat.getString("nom_comp"));
                vol.setDuree_vol(resultat.getString("duree_vol"));
                vol.setNb_billet(resultat.getInt("nb_billet"));
                vol.setHeure_dep(resultat.getString("heure_dep"));
                volList.add(vol);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    acces.closeConnection();
    return volList;
    }
    
     public  List<HotelModel> findHotel(){
    List<HotelModel> hotelList= new ArrayList<HotelModel>();
    String sql = "SELECT * FROM hotel WHERE localisation='"+this.destination+"' AND  dispo>='"+this.nbr+"'";
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
            hotel.setDesc_hotel(resultat.getString("desc_hotel"));
            hotel.setNote_hotel(resultat.getInt("note_hotel"));
            hotelList.add(hotel);
            }
            
            
              } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        acces.closeConnection();
        return hotelList;
    }
    
    public  List<SiteModel> findSite(){
    List<SiteModel> siteList = new ArrayList<SiteModel>();
    String sql = "SELECT * FROM site WHERE local_site='"+this.destination+"'";
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
    
}
