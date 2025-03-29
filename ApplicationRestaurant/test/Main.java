
import Dao.CommandeDao;
import Modele.FactureModele;
import java.sql.SQLException;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        CommandeDao com = new CommandeDao();
        List<FactureModele> comall = com.toutCommande(0);
        for(FactureModele factmod:comall){
            System.err.println(factmod.getNom()+":"+factmod.getQuantite()+":"+factmod.getTotalP());
        }
    }
}
