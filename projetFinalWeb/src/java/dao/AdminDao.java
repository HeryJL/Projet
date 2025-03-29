/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import common.AccesBdd;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.ClientModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HotelModel;
import model.PanierModel;
import model.VilleModel;
import model.VolModel;

/**
 *
 * @author Hery
 */
public class AdminDao {

    public List<ClientModel> clientList() throws SQLException, SQLException, SQLException {
        List<ClientModel> clientList = new ArrayList<ClientModel>();
        String sql = "SELECT * FROM client";
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        ResultSet reusltat = acces.executeSelect(sql);
        try {
            while (reusltat.next()) {
                ClientModel client = new ClientModel();
                client.setIdClient(reusltat.getInt("id_client"));
                client.setNom_client(reusltat.getString("nom_client"));
                client.setMail(reusltat.getString("mail_client"));
                client.setLocalisaion(reusltat.getString("localisation"));
                client.setTel(reusltat.getInt("tel"));
                client.setMontant(Integer.parseInt(reusltat.getString("montant")));
                clientList.add(client);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        acces.closeConnection();
        return clientList;
    }

    public List<VolModel> volList() {
        List<VolModel> volList = new ArrayList<VolModel>();
        String sql = "SELECT * FROM vol";
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        ResultSet resultat = acces.executeSelect(sql);
        try {
            while (resultat.next()) {
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
                vol.setDispo(resultat.getInt("dispo"));
                volList.add(vol);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        acces.closeConnection();
        return volList;
    }

    public List<HotelModel> hotelList() {
        List<HotelModel> hotelList = new ArrayList<HotelModel>();
        String sql = "SELECT * FROM hotel";
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        ResultSet resultat = acces.executeSelect(sql);
        try {
            while (resultat.next()) {
                HotelModel hotel = new HotelModel();
                hotel.setId_hotel(resultat.getInt("id_hotel"));
                hotel.setNom_hotel(resultat.getString("nom_hotel"));
                hotel.setVille(resultat.getString("localisation"));
                hotel.setPrix(resultat.getInt("prix_hotel"));
                hotel.setImg_hotel(resultat.getString("img_hotel"));
                hotel.setNb_chambre(resultat.getInt("nb_chambre"));
                hotel.setDesc_hotel(resultat.getString("desc_hotel"));
                hotel.setNote_hotel(resultat.getInt("note_hotel"));
                hotel.setDispo(resultat.getInt("dispo"));
                hotelList.add(hotel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        acces.closeConnection();
        return hotelList;
    }

    public void modifVol(VolModel vol) throws IOException, SQLException {
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        String sql = "UPDATE vol SET nom_comp='" + vol.getNom_comp() + "',nb_billet='" + vol.getNb_billet() + "',dispo='" + vol.getNb_billet() + "',prix_vol='" + vol.getPrix() + "',depart='" + vol.getDepart() + "',destination='" + vol.getDestination() + "',date_vol='" + vol.getDate_vol() + "',heure_dep='" + vol.getHeure_dep() + "',duree_vol='" + vol.getDuree_vol() + "' WHERE id_vol='" + vol.getId_vol() + "' ";
        acces.executeUpdate(sql);
        acces.closeConnection();
        

    }

    public void ajoutVol(VolModel vol) throws SQLException {
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        String sql = "INSERT INTO vol (nom_comp,prix_vol,depart,destination,date_vol,heure_dep,duree_vol,nb_billet,dispo) VALUES ('" + vol.getNom_comp() + "','" + vol.getPrix() + "','" + vol.getDepart() + "','" + vol.getDestination() + "','" + vol.getDate_vol() + "','" + vol.getHeure_dep() + "','" + vol.getDuree_vol() + "','" + vol.getNb_billet() + "','" + vol.getNb_billet() + "') ";
        acces.executeUpdate(sql);
        acces.closeConnection();
        try {
            export("vol");
        } catch (IOException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modifHotel(HotelModel hotel) throws SQLException, IOException {
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        String sql = "UPDATE hotel SET nom_hotel='" + hotel.getNom_hotel() + "',nb_chambre='" + hotel.getNb_chambre() + "',dispo='" + hotel.getNb_chambre() + "',prix_hotel='" + hotel.getPrix() + "',note_hotel='" + hotel.getNote_hotel() + "',desc_hotel='" + hotel.getDesc_hotel() + "',localisation='" + hotel.getVille() + "',img_hotel='" + hotel.getImg_hotel() + "' WHERE id_hotel='" + hotel.getId_hotel() + "'";
        acces.executeUpdate(sql);
        acces.closeConnection();
       

    }

    public void ajoutHotel(HotelModel hotel) throws SQLException, IOException {
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        String sql = "INSERT INTO hotel (nom_hotel,nb_chambre,dispo,localisation,note_hotel,prix_hotel,desc_hotel,img_hotel)VALUES('" + hotel.getNom_hotel() + "','" + hotel.getNb_chambre() + "','" + hotel.getNb_chambre() + "','" + hotel.getVille() + "','" + hotel.getNote_hotel() + "','" + hotel.getPrix() + "','" + hotel.getDesc_hotel() + "','" + hotel.getImg_hotel() + "')";
        acces.executeUpdate(sql);
        acces.closeConnection();
       
    }

    public List<VilleModel> villeList() {
        List<VilleModel> villeList = new ArrayList<VilleModel>();
        String sql = "SELECT * FROM ville";
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        ResultSet resultat = acces.executeSelect(sql);
        try {
            while (resultat.next()) {
                VilleModel ville = new VilleModel();
                ville.setId_ville(resultat.getInt("id_ville"));
                ville.setNom_ville(resultat.getString("nom_ville"));
                ville.setPays(resultat.getString("pays"));
                ville.setImg_ville(resultat.getString("img_ville"));
                ville.setNb_visite(Integer.parseInt(resultat.getString("nb_visite")));
                villeList.add(ville);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return villeList;
    }

    public void modifVille(VilleModel ville) throws SQLException, IOException {
        AccesBdd acces = new AccesBdd();
        String sql = "UPDATE ville SET nom_ville='" + ville.getNom_ville() + "',pays='" + ville.getPays() + "',img_ville='" + ville.getImg_ville() + "' WHERE id_ville='" + ville.getId_ville() + "'";
        acces.loadDriver();
        acces.executeUpdate(sql);
        acces.closeConnection();
       
    }

    public void insertVille(VilleModel ville) throws SQLException, IOException {
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        String sql = "INSERT INTO ville(nom_ville,pays,img_ville,nb_visite) VAlUES ('" + ville.getNom_ville() + "','" + ville.getPays() + "','" + ville.getImg_ville() + "','"+ville.getNb_visite()+"')";
        acces.executeUpdate(sql);
        acces.closeConnection();
    }

    public void deletItem(String type, int id) throws SQLException, IOException {
        AccesBdd acces = new AccesBdd();
        String sql = "DELETE FROM " + type + " WHERE id_" + type + "='" + id + "'";
        acces.loadDriver();
        acces.executeUpdate(sql);
        acces.closeConnection();
       
    }

    public List<PanierModel> listPanier() throws SQLException{
    List<PanierModel> listPanier = new ArrayList<PanierModel>();
    String sql = "SELECT * FROM panier ";
    AccesBdd acces = new AccesBdd(); 
    acces.loadDriver();
    ResultSet rs = acces.executeSelect(sql);
    while(rs.next()){
        PanierModel panier= new PanierModel();
        panier.setDate_panier(rs.getString("date_panier"));
        panier.setDate_depart(rs.getString("date_depart"));
        panier.setType_item(rs.getString("type_item"));
        panier.setNb_pers(rs.getInt("nb_pers"));
        panier.setPayement(rs.getBoolean("payement"));
        panier.setNom_user(rs.getString("nom_user"));
        listPanier.add(panier);
    }
    acces.closeConnection();
     return listPanier;
    }
    
    public List<PanierModel> panierDate(){
     List<PanierModel> listPanier = new ArrayList<PanierModel>();
    String sql = "SELECT SUM(`nb_pers`) AS `nb_pers` ,`date_depart` FROM `panier` GROUP BY(`date_depart`)";
    AccesBdd acces = new AccesBdd(); 
    acces.loadDriver();
    ResultSet rs = acces.executeSelect(sql);
        try {
            while(rs.next()){
                PanierModel panier= new PanierModel();
              
                panier.setDate_depart(rs.getString("date_depart"));
 
                panier.setNb_pers(rs.getInt("nb_pers"));
        
                listPanier.add(panier);
            }   } catch (SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
      return listPanier;
    }
       
    public void export(String nom_table) throws SQLException, IOException {
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        String sql = "SELECT * FROM " + nom_table + "";
        ResultSet rs = acces.executeSelect(sql);
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[");
        while (rs.next()) {
            jsonBuilder.append("{");
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                String value = rs.getString(i);
                jsonBuilder.append("\"").append(columnName).append("\":\"").append(value).append("\"");
                if (i < columnCount) {
                    jsonBuilder.append(",");
                }
            }
            jsonBuilder.append("}");

            if (!rs.isLast()) {
                jsonBuilder.append(",");
            }
        }

        jsonBuilder.append("]");

        try (FileWriter fileWriter = new FileWriter("D:\\Codage\\Java\\projetFinalWeb\\web\\data\\"+nom_table +".json")) {
            fileWriter.write(jsonBuilder.toString());
        }
    }
}
