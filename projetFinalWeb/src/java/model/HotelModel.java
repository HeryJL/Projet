/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hery
 */
public class HotelModel {
    private int id_hotel;
    private String nom_hotel;
    private String ville;
    private int prix;
    private String img_hotel;
    private int nb_chambre;
    private String desc_hotel;
    private int note_hotel;
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

    public int getNote_hotel() {
        return note_hotel;
    }

    public void setNote_hotel(int note_hotel) {
        this.note_hotel = note_hotel;
    }

    public String getDesc_hotel() {
        return desc_hotel;
    }

    public void setDesc_hotel(String desc_hotel) {
        this.desc_hotel = desc_hotel;
    }

    public int getNb_chambre() {
        return nb_chambre;
    }

    public void setNb_chambre(int nb_chambre) {
        this.nb_chambre = nb_chambre;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public String getNom_hotel() {
        return nom_hotel;
    }

    public void setNom_hotel(String nom_hotel) {
        this.nom_hotel = nom_hotel;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getImg_hotel() {
        return img_hotel;
    }

    public void setImg_hotel(String img_hotel) {
        this.img_hotel = img_hotel;
    }
    
}
