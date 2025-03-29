/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import common.AccesBdd;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author Hery
 */
public class ExportData {

    public void export(String nom_table) throws SQLException, IOException {
        AccesBdd acces = new AccesBdd();
        acces.loadDriver();
        String sql = "SELECT * FROM "+nom_table+"";
        ResultSet rs = acces.executeSelect(sql);
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[");
        while (rs.next()) {
            jsonBuilder.append("{");
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                String value = rs.getString(i);
                jsonBuilder.append("\"").append(columnName).append("\":\"").append(value).append("\"");
                if (i < columnCount) {
                    jsonBuilder.append(",");
                }
            }
            jsonBuilder.append("}");

            if (!rs.isLast()) {
                jsonBuilder.append(",");
            }
        }

        jsonBuilder.append("]");
        
        try (FileWriter fileWriter = new FileWriter("D:\\Codage\\Java\\projetFinalWeb\\web\\data\\"+nom_table+".json")) {
                fileWriter.write(jsonBuilder.toString());
            }
    }
}
