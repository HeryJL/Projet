/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import common.AccesBdd;
import java.io.FileWriter;
import java.io.IOException;
import model.VolModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ClientModel;
import model.HotelModel;
import model.PanierModel;
import model.SiteModel;

/**
 *
 * @author Hery
 */
public class CommandeDao {

    public int verifPanier(String nom) throws SQLException {
        int verif = 0;
        String sql = "SELECT * FROM panier WHERE nom_user='" + nom + "' AND payement='false'";
        AccesBdd acces = new AccesBdd();
        ResultSet rs = acces.executeSelect(sql);
        while (rs.next()) {
            verif = 1;
        }
        return verif;
    }

    public VolModel itemVol(int id_vol) {
        VolModel vol = new VolModel();
        AccesBdd acces = new AccesBdd();
        String sql = "SELECT * FROM vol WHERE id_vol='" + id_vol + "'";
        acces.loadDriver();
        ResultSet resultat = acces.executeSelect(sql);
        try {
            while (resultat.next()) {
                vol.setId_vol(resultat.getInt("id_vol"));
                vol.setNom_comp(resultat.getString("nom_comp"));
                vol.setDestination(resultat.getString("destination"));
                vol.setPrix(resultat.getInt("prix_vol"));
                vol.setDate_vol(resultat.getString("date_vol"));
                vol.setHeure_dep(resultat.getString("heure_dep"));
                vol.setDuree_vol(resultat.getString("duree_vol"));
                vol.setImg_vol(resultat.getString("img_vol"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        acces.closeConnection();

        return vol;
    }

    public HotelModel itemHotel(int id_hotel) {
        HotelModel hotel = new HotelModel();
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        String sql = "SELECT * FROM hotel WHERE id_hotel='" + id_hotel + "'";
        ResultSet resultat = acces.executeSelect(sql);
        try {
            while (resultat.next()) {
                hotel.setId_hotel(resultat.getInt("id_hotel"));
                hotel.setNom_hotel(resultat.getString("nom_hotel"));
                hotel.setVille(resultat.getString("localisation"));
                hotel.setPrix(resultat.getInt("prix_hotel"));
                hotel.setImg_hotel(resultat.getString("img_hotel"));
                hotel.setNb_chambre(resultat.getInt("nb_chambre"));
                hotel.setDesc_hotel(resultat.getString("desc_hotel"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        acces.closeConnection();
        return hotel;
    }

    public void annulerTout(String nom) {
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        String sql = "DELETE FROM panier WHERE nom_user='" + nom + "' AND payement=false";
        acces.executeUpdate(sql);

        acces.closeConnection();
    }

    public void ajoutClient(ClientModel client) {
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        boolean verif= verifCient(client.getNom_client());
        if (verif==false){
             String sql = "INSERT INTO client (nom_client,mail_client,localisation,montant,tel)VALUES"
                + "('" + client.getNom_client() + "','" + client.getMail() + "','" + client.getLocalisaion() + "','" + client.getMontant() + "','" + client.getTel() + "')";
        acces.executeUpdate(sql);
        sql = "UPDATE panier SET payement=true WHERE nom_user='" + client.getNom_client() + "'";
        acces.executeUpdate(sql);
        }
        else{
            int a= 0;
            int b= 0;
            String sql=sql = "SELECT* FROM client WHERE nom_client= '" + client.getNom_client() + "'";
            ResultSet res = acces.executeSelect(sql);
            try {
                while (res.next()){
                    a=Integer.parseInt(res.getString("montant"));
                    b= client.getMontant()+a;
                    sql = "UPDATE client SET montant='"+b+"' WHERE nom_client='" + client.getNom_client() + "'";
                    acces.executeUpdate(sql);
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(CommandeDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
        acces.closeConnection();
    }

    public void cheksite(String nom, int id_site) {
        String sql = "INSERT INTO cheksite (id_site,nom_client)VALUES ('" + id_site + "','" + nom + "')";
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        acces.executeUpdate(sql);
        acces.closeConnection();
    }

    public List<SiteModel> findsite(String nom) {
        List<SiteModel> sitelist = new ArrayList<SiteModel>();
        AccesBdd acces = new AccesBdd();
        String sql = "SELECT s.* FROM site s JOIN cheksite c ON c.id_site= s.id_site WHERE c.nom_client='" + nom + "' AND c.paye=false";
        ResultSet resultat = acces.executeSelect(sql);
        try {
            while (resultat.next()) {
                SiteModel site = new SiteModel();
                site.setId_site(resultat.getInt("id_site"));
                site.setImg_site(resultat.getString("img_site"));
                site.setNom_site(resultat.getString("nom_site"));
                site.setLoca_site(resultat.getString("local_site"));
                site.setPrix(resultat.getInt("Prix"));
                sitelist.add(site);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sitelist;
    }

    public void AnnulerSite(String nom, int id) {
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        String sql = "DELETE FROM cheksite WHERE nom_client = '" + nom + "' AND id_site='" + id + "'";
        acces.executeUpdate(sql);
        acces.closeConnection();
    }

    public void ajoutPanier(PanierModel panier) {
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        String sql = "INSERT INTO panier(nom_user,type_item,id_item,date_depart,nb_pers,duree,date_panier) VALUES('" + panier.getNom_user() + "','" + panier.getType_item() + "','" + panier.getId_item() + "','" + panier.getDate_depart() + "','" + panier.getNb_pers() + "','" + panier.getDuree() + "',NOW())";
        acces.executeUpdate(sql);
        acces.closeConnection();

    }

    public List<HotelModel> hotelPanier(String nom) {
        List<HotelModel> hotelPanier = new ArrayList<HotelModel>();
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        String sql = "SELECT h.*, p.id_panier FROM hotel h RIGHT JOIN panier p ON p.id_item = h.id_hotel WHERE p.nom_user='" + nom + "' AND p.payement=false AND p.type_item ='hotel'";
        ResultSet resultat = acces.executeSelect(sql);

        try {
            while (resultat.next()) {
                HotelModel hotel = new HotelModel();
                hotel.setPanier_id(resultat.getInt("id_panier"));
                hotel.setId_hotel(resultat.getInt("id_hotel"));
                hotel.setNom_hotel(resultat.getString("nom_hotel"));
                hotel.setVille(resultat.getString("localisation"));
                hotel.setPrix(resultat.getInt("prix_hotel"));
                hotel.setImg_hotel(resultat.getString("img_hotel"));
                hotel.setNb_chambre(resultat.getInt("nb_chambre"));
                hotel.setDesc_hotel(resultat.getString("desc_hotel"));
                hotelPanier.add(hotel);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hotelPanier;
    }

    public List<VolModel> volPanier(String nom) {
        List<VolModel> volPanier = new ArrayList<VolModel>();
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        String sql = "SELECT v.*, p.id_panier FROM vol v RIGHT JOIN panier p ON p.id_item = v.id_vol WHERE p.nom_user='" + nom + "' AND p.payement=false AND p.type_item ='vol'";
        ResultSet resultat = acces.executeSelect(sql);
        try {
            while (resultat.next()) {
                VolModel vol = new VolModel();
                vol.setPanier_id(resultat.getInt("id_panier"));
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
                volPanier.add(vol);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return volPanier;

    }

    public List<SiteModel> sitePanier(String nom) {
        List<SiteModel> sitePanier = new ArrayList<SiteModel>();
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        String sql = "SELECT s.* FROM site s JOIN panier p ON p.id_item  = s.id_site WHERE p.nom_user='" + nom + "' AND p.payement=false AND p.type_item ='site'";
        ResultSet resultat = acces.executeSelect(sql);
        try {
            while (resultat.next()) {
                SiteModel site = new SiteModel();
                site.setId_site(resultat.getInt("id_site"));
                site.setImg_site(resultat.getString("img_site"));
                site.setNom_site(resultat.getString("nom_site"));
                site.setLoca_site(resultat.getString("local_site"));
                site.setPrix(resultat.getInt("Prix"));
                sitePanier.add(site);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sitePanier;
    }

    public void annulerItem(int id_item, String nom) {
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        String sql = "DELETE FROM panier WHERE id_panier='" + id_item + "' AND nom_user='" + nom + "'";
        acces.executeUpdate(sql);
        acces.closeConnection();

    }

    public int Nb_pers(String nom) {
        int nb_pers = 0;
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        String sql = "SELECT * FROM panier WHERE nom_user='" + nom + "' AND payement=false";
        ResultSet resultat = acces.executeSelect(sql);
        try {
            while (resultat.next()) {
                nb_pers = nb_pers + Integer.parseInt(resultat.getString("nb_pers"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        acces.closeConnection();
        return nb_pers;
    }

    public void confirmCommande(String nom) {
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        String type;
        int id = 0;
        int nbr = 0;
        String sql = "SELECT * FROM panier WHERE nom_user='" + nom + "' AND payement = false ";
        ResultSet res = acces.executeSelect(sql);
        try {
            while (res.next()) {
                type = res.getString("type_item");
                id = Integer.parseInt(res.getString("id_item"));
                nbr = Integer.parseInt(res.getString("nb_pers"));
                updateDispo(type, id, nbr);
                visite(type, nbr, id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        sql = "UPDATE panier SET payement=true ,date_payement=Now()  WHERE nom_user='" + nom + "'";
        acces.executeUpdate(sql);
        acces.closeConnection();

    }

    public boolean verifCient(String nom) {
        boolean verif = false;
        AccesBdd accesBdd = new AccesBdd();
        String sql = "SELECT* FROM client WHERE nom_client= '" + nom + "'";
        ResultSet res = accesBdd.executeSelect(sql);
        try {
            while (res.next()) {
                verif = true;

            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return verif;
    }

    public void updateDispo(String type, int id, int nbr) {
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        int a = 0;
        int b = 0;
        String sql = "SELECT * FROM " + type + " WHERE id_" + type + "= '" + id + "'";
        ResultSet res = acces.executeSelect(sql);
        try {
            while (res.next()) {
                a = Integer.parseInt(res.getString("dispo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        b = a - nbr;
        if (b < 0) {
            b = 0;
        }
        sql = "UPDATE " + type + " SET dispo='" + b + "'WHERE id_" + type + "='" + id + "'";
        acces.executeUpdate(sql);
        acces.closeConnection();
    }

    public void visite(String type, int nbp, int id) {
        String dest = "Antsirabe";
        int a = 0;
        int c = 0;
        String local = "localisation";
        if (type.equals("vol")) {
            local = "destination";
        }
        String sql = "SELECT * FROM " + type + " WHERE id_" + type + "='" + id + "'";
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        ResultSet re = acces.executeSelect(sql);

        try {
            while (re.next()) {
                dest = re.getString(local);
                System.err.println(dest);
                System.err.println(type);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "SELECT * FROM ville WHERE nom_ville='" + dest + "'";
        re = acces.executeSelect(sql);
        try {
            while (re.next()) {
                a = Integer.parseInt(re.getString("nb_visite"));
                System.err.println(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        c = a + nbp;
        sql = "UPDATE ville SET nb_visite='" + c + "' WHERE nom_ville='" + dest + "'";
        acces.executeUpdate(sql);
    }

}
