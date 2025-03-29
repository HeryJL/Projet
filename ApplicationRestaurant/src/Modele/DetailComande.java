package Modele;

public class DetailComande {
    private int id;
    private int idComande;
    private int idMenu;
    private int quantiter;
    private int total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdComande() {
        return idComande;
    }

    public void setIdComande(int idComande) {
        this.idComande = idComande;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getQuantiter() {
        return quantiter;
    }

    public void setQuantiter(int quantiter) {
        this.quantiter = quantiter;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
