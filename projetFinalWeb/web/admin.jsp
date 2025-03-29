<%-- 
    Document   : admin
    Created on : 31 août 2024, 17:31:18
    Author     : Hery
--%>
<%@page import="java.util.List"%>
<%@page import="dao.AdminDao"%>
<%@page import="model.VolModel"%>
<%@page import="model.HotelModel"%>
<%@page import="model.SiteModel"%>
<%@page import="model.VilleModel"%>
<%@page import="model.ClientModel"%>
<%@page import="model.PanierModel"%>
<%@page import="dao.Convert"%>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/ajax.aspnetcdn.com_ajax_jQuery_jquery-3.7.0.js"></script>
<script src="js/font-awesome/all.js"></script>
<script src="js/bootstrap.bundle.js"></script>
<link rel="stylesheet" href="css/all.min.css"/>
<script src="js/fontawesome.min.js"></script>
<script src="js/chart.js"></script>
<script src="js/Charthotel.js"></script>
<% 
    AdminDao dao = new AdminDao();
    List<HotelModel> hotelList = dao.hotelList();
    List<VolModel> volList = dao.volList();
    List<VilleModel> villelList = dao.villeList();
    List<PanierModel> panierList = dao.listPanier();
    List<PanierModel> list= dao.panierDate();
    List<ClientModel> listClient= dao.clientList();
%>
