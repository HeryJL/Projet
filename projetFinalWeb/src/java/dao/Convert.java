/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hery
 */
public class Convert {

    public String getArrive(String depart, String duree) {
        String arriv = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime tempsdep = LocalTime.parse(depart, formatter);
        LocalTime tempsdur = LocalTime.parse(duree, formatter);
        Duration dur1 = Duration.between(LocalTime.MIDNIGHT, tempsdep);
        Duration dur2 = Duration.between(LocalTime.MIDNIGHT, tempsdur);
        Duration dutotal = dur1.plus(dur2);
        LocalTime total = LocalTime.MIDNIGHT.plus(dutotal);
        arriv = total.format(formatter);
        return arriv;
    }

    public String date(String d) {
         String ok = "00-00-0000";
        try {
           
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            
            // Conversion de la chaîne en objet Date
            Date date = inputFormat.parse(d);
            // Conversion de la date en format dd-MM-yy
            ok = outputFormat.format(date);
            System.out.println("Date formatée : " + ok);
         
        } catch (ParseException ex) {
            Logger.getLogger(Convert.class.getName()).log(Level.SEVERE, null, ex);
        }
       return ok;
    }

    
    public String heure(String d)  {
        String heure = "HH:mm:ss";
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");
   
        try {
           Date date = inputFormat.parse(d);
            heure = outputFormat.format(date);
        } catch (ParseException ex) {
            Logger.getLogger(Convert.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        System.out.println("Date formatée : " + heure);
        return heure;
    }
}
