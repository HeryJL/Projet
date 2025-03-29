/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hery
 */
public class VilleModel {
    private int id_ville;
    private String nom_ville;
    private String pays;
    private String img_ville;
    private  int nb_visite;

    public int getNb_visite() {
        return nb_visite;
    }

    public void setNb_visite(int nb_visite) {
        this.nb_visite = nb_visite;
    }

    public int getId_ville() {
        return id_ville;
    }

    public void setId_ville(int id_ville) {
        this.id_ville = id_ville;
    }

    public String getNom_ville() {
        return nom_ville;
    }

    public void setNom_ville(String nom_ville) {
        this.nom_ville = nom_ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getImg_ville() {
        return img_ville;
    }

    public void setImg_ville(String img_ville) {
        this.img_ville = img_ville;
    }
    
}
