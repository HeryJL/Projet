/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hery
 */
public class PanierModel {
    private int id_panier;
    private String nom_user;
    private String type_item;
    private int id_item ;
    private int nb_pers;
    private String date_panier;
    private boolean payement;
    private String date_depart;
    private int duree;

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(String date_depart) {
        this.date_depart = date_depart;
    }

    public boolean isPayement() {
        return payement;
    }

    public void setPayement(boolean payement) {
        this.payement = payement;
    }

    public int getId_panier() {
        return id_panier;
    }

    public void setId_panier(int id_panier) {
        this.id_panier = id_panier;
    }

    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public String getType_item() {
        return type_item;
    }

    public void setType_item(String type_item) {
        this.type_item = type_item;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public int getNb_pers() {
        return nb_pers;
    }

    public void setNb_pers(int nb_pers) {
        this.nb_pers = nb_pers;
    }

    public String getDate_panier() {
        return date_panier;
    }

    public void setDate_panier(String date_panier) {
        this.date_panier = date_panier;
    }
}
