/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hery
 */
public class SiteModel {
    private int id_site;
    private String nom_site;
    private String loca_site;
    private int prix;
    private String img_site;

    public String getImg_site() {
        return img_site;
    }

    public void setImg_site(String img_site) {
        this.img_site = img_site;
    }

    public int getId_site() {
        return id_site;
    }

    public void setId_site(int id_site) {
        this.id_site = id_site;
    }

    public String getNom_site() {
        return nom_site;
    }

    public void setNom_site(String nom_site) {
        this.nom_site = nom_site;
    }

    public String getLoca_site() {
        return loca_site;
    }

    public void setLoca_site(String loca_site) {
        this.loca_site = loca_site;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
