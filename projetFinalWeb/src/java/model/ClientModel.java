/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hery
 */
public class ClientModel {
    private int idClient;
    private String nom_client;
    private String localisaion;
    private String mail;
    private int tel;
    private int montant;
    private String date;
    private int nb_pers;

    public int getNb_pers() {
        return nb_pers;
    }

    public void setNb_pers(int nb_pers) {
        this.nb_pers = nb_pers;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
   

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public String getLocalisaion() {
        return localisaion;
    }

    public void setLocalisaion(String localisaion) {
        this.localisaion = localisaion;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
}
