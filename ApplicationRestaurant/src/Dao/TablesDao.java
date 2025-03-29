package Dao;

import Modele.MenuModele;
import Modele.TablesModele;
import common.AccesBdd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablesDao {
     public List<TablesModele> listeTable() throws SQLException{
        List<TablesModele> tousLesTables = new ArrayList<TablesModele>();
        String sql = "SELECT * FROM tables";
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        ResultSet resultat = acces.executeSelect(sql);
        while(resultat.next()){
            TablesModele tab = new TablesModele();
            tab.setId(resultat.getInt("id"));
            tab.setNumero(resultat.getInt("numero"));
            tab.setEtat(resultat.getString("etat"));
            tousLesTables.add(tab);
        }
        acces.closeConnection();
        return tousLesTables;
    }
    public boolean verifTable(int id) throws SQLException{
        boolean verif = false;
        String sql = "SELECT * FROM tables WHERE numero='"+id+"' AND etat='libre'";
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        ResultSet resultat = acces.executeSelect(sql);
        while(resultat.next()){
            verif = true;
        }
        acces.closeConnection();
         return verif; 
     }
    public void updateTable(TablesModele tab){
        String sql = "UPDATE tables SET etat = '"+tab.getEtat()+"' WHERE id='"+tab.getId()+"'";
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        acces.executeUpdate(sql);
        acces.closeConnection();
    }
}
