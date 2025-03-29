package Dao;

import Modele.Commande;
import Modele.DetailComande;
import Modele.FactureModele;
import common.AccesBdd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CommandeDao {
      public void commander(int id){
            String sql = "INSERT INTO commande(id_tables,date_commande,etat_commande) VALUES"
                  + "('"+id+"',now(),'en attente')";
            AccesBdd acces = new AccesBdd();
            acces.loadDriver();
            acces.executeUpdate(sql);
            acces.closeConnection();
      }
      public int numeroCommande(int idTable) throws SQLException{
            int id = 0;
            String sql = "SELECT id FROM commande WHERE id_tables='"+idTable+"' AND etat_commande!='paye'";
            AccesBdd acces = new AccesBdd();
            acces.loadDriver();
            ResultSet resultat = acces.executeSelect(sql);
            while(resultat.next()){
                id = resultat.getInt("id");
            }
            acces.closeConnection();
            return id; 
      }
      public int totalFact(int idcomm) throws SQLException{
            int id = 0;
            String sql = "SELECT SUM(prix_total) as prix FROM detailcomande WHERE id_commande='"+idcomm+"'";
            AccesBdd acces = new AccesBdd();
            acces.loadDriver();
            ResultSet resultat = acces.executeSelect(sql);
            while(resultat.next()){
                id = resultat.getInt("prix");
            }
            acces.closeConnection();
            return id; 
      }
      public void ajoutCommander(DetailComande detail) throws SQLException{
            int reste = restePlat(detail.getIdMenu()) - detail.getQuantiter();
            String sql = "INSERT INTO detailcomande(id_commande,id_menu,quantite,prix_total) VALUES"
                  + "('"+detail.getIdComande()+"','"+detail.getIdMenu()+"','"+detail.getQuantiter()+"','"+detail.getTotal()+"')";
            String sqlUpdate = "UPDATE menu SET disponibilite='"+reste+"' WHERE id='"+detail.getIdMenu()+"'";
            AccesBdd acces = new AccesBdd();
            if(reste >= 0){
                acces.loadDriver();
                acces.executeUpdate(sql);
                acces.executeUpdate(sqlUpdate);
                acces.closeConnection();
            }else{
            JOptionPane.showMessageDialog(null, "tsy ampy anio tsony ny quantite tavela \n jereo tsara!"," erreur d'insertion",JOptionPane.ERROR_MESSAGE);
            }
      }
      public int restePlat(int id) throws SQLException{
            String sql = "SELECT disponibilite FROM menu WHERE id='"+id+"'";
            int reste = 0;
            AccesBdd acces = new AccesBdd();
            acces.loadDriver();
            ResultSet r = acces.executeSelect(sql);
            if(r.next()){
                reste = r.getInt("disponibilite");
            }
            return reste;
      }
      public List<FactureModele> toutCommande(int idCommande) throws SQLException{
          String sql = "SELECT menu.id as id,menu.nom as nom,SUM(detailcomande.quantite) as q,SUM(detailcomande.prix_total) as t FROM menu,detailcomande"
                  + " WHERE detailcomande.id_commande = '"+idCommande+"' and detailcomande.id_menu = menu.id GROUP BY menu.id";
        List<FactureModele> com = new ArrayList<FactureModele>();
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        ResultSet r = acces.executeSelect(sql);
        while (r.next()) {
            FactureModele fact = new FactureModele();
            fact.setId(r.getInt("id"));
            fact.setNom(r.getString("nom"));
            fact.setQuantite(r.getInt("q"));
            fact.setTotalP(r.getInt("t"));
            com.add(fact);
        }
        return com;
      }
    public void updateEtatCommande(int id, String etat){
        String sql = "UPDATE commande SET etat_commande = '"+etat+"' WHERE id='"+id+"'";
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        acces.executeUpdate(sql);
        acces.closeConnection();
    }
}
