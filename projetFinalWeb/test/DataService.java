
import common.AccesBdd;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/data")
@Produces(MediaType.APPLICATION_JSON)
public class DataService {

    @GET
    public List<DataPoint> getDataPoints() {
        List<DataPoint> dataPoints = new ArrayList<>();
        /*try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT x_value, y_value FROM data_table";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int x = rs.getInt("x_value");
                int y = rs.getInt("y_value");
                dataPoints.add(new DataPoint(x, y));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        AccesBdd a = new AccesBdd();
        a.loadDriver();
        String query = "SELECT nom_comp, nb_billet FROM vol";
        
      ResultSet rs= a.executeSelect(query);
        try {
            while (rs.next()) {
                String x = rs.getString("nom_comp");
                int y = rs.getInt("y_value");
                dataPoints.add(new DataPoint(x, y));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataPoints;
    }
}
