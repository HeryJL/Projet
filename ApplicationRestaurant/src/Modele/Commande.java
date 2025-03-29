package Modele;

public class Commande {
    private int idTable;
    private String dateComande;
    private String etatCommande;

    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idUser) {
        this.idTable = idUser;
    }

    public String getDateComande() {
        return dateComande;
    }

    public void setDateComande(String dateComande) {
        this.dateComande = dateComande;
    }

    public String getEtatCommande() {
        return etatCommande;
    }

    public void setEtatCommande(String etatCommande) {
        this.etatCommande = etatCommande;
    }
}
