/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hery
 */
public class VolModel {
    private int id_vol;
    private String depart;  
    private String destination;
    private int prix;
    private String date_vol;
    private String img_vol;
    private String nom_comp;
    private String duree_vol;
    private String heure_dep; 
    private int nb_billet;
    private int panier_id;
    private int dispo;

    public int getDispo() {
        return dispo;
    }

    public void setDispo(int dispo) {
        this.dispo = dispo;
    }

    public int getPanier_id() {
        return panier_id;
    }

    public void setPanier_id(int panier_id) {
        this.panier_id = panier_id;
    }

      public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }
    public int getNb_billet() {
        return nb_billet;
    }

    public void setNb_billet(int nb_billet) {
        this.nb_billet = nb_billet;
    }

    public String getHeure_dep() {
        return heure_dep;
    }

    public void setHeure_dep(String heure_dep) {
        this.heure_dep = heure_dep;
    }

    public String getDuree_vol() {
        return duree_vol;
    }

    public void setDuree_vol(String duree_vol) {
        this.duree_vol = duree_vol;
    }

    public String getNom_comp() {
        return nom_comp;
    }

    public void setNom_comp(String nom_comp) {
        this.nom_comp = nom_comp;
    }
       

    public int getId_vol() {
        return id_vol;
    }

    public void setId_vol(int id_vol) {
        this.id_vol = id_vol;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getDate_vol() {
        return date_vol;
    }

    public void setDate_vol(String date_vol) {
        this.date_vol = date_vol;
    }

    public String getImg_vol() {
        return img_vol;
    }

    public void setImg_vol(String img_vol) {
        this.img_vol = img_vol;
    }
    
}
