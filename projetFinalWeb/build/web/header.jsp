
<%-- 
    Document   : header.jsp
    Created on : 15 août 2024, 21:28:45
    Author     : Hery
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/font-awesome/all.js"></script>
<script src="js/bootstrap.bundle.js"></script>
<link rel="stylesheet" href="css/list.css"/>
<link rel="stylesheet" href="css/header.css"/>
<link rel="stylesheet" href="css/home.css"/>
<link rel="stylesheet" href="css/panier.css"/>
<link rel="stylesheet" href="css/site.css"/>
<link rel="stylesheet" href="css/profil.css"/>
<link rel="stylesheet" href="css/accueil.css"/>
<link rel="stylesheet" href="css/fontawesome.min.css"/>
<link rel="stylesheet" href="css/all.min.css"/>
<link rel="stylesheet" href="css/animate.css"/>
<script src="js/fontawesome.min.js"></script>
<script src="js/jquery.countTo.js"></script>
<script src="js/main.js"></script>
<script src="js/jquery.waypoints.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<title>MANDEHA</title>
<nav>
    <%@page import="model.VolModel"%>
    <%@page import="model.HotelModel"%>
    <%@page import="dao.CommandeDao"%>
    <%@page import="model.PanierModel"%>
    <%@page import="java.util.List"%>
    <%@page import="dao.Dao"%>
    <%@page import="model.VilleModel"%>
    <%@page import="model.UserModel"%>
    <%@page import="dao.Convert"%>
    <%@page import="dao.RechercheDao"%>
    <%@page import="java.time.format.DateTimeFormatter"%>
    <% 
        Dao dao = new Dao();
        List<VilleModel> villeTop= dao.topVille();
   
        String login = (String)session.getAttribute("nom");
       
       if(login == null){
     
          request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        if (login.equals("hery")){%>

    <a href="Link?page=adminDashboard" ><%= login%></a>
    <%
          } else { %>
    <a href="Link?page=profil" ><%= login%></a>

    <%}

    %>
    <a href="Link?page=home" >Accueil</a>
    <a href="Link?page=panier" >Reservation</a>
    <a data-bs-toggle="modal" data-bs-target="#dec"><i class="fa fa-power-off"></i></a>

</nav>
<div class="modal fade" id ="dec" role="dialog" aria-labelledby="titleVille" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-lg " role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                        </div>
                        <div class="modal-body">
                            <form method="post"  action="DeconnectServlet" name="formulaire">
                                
                                <div class="text-center">
                                    <h1>Voulez - vous vraiment sortir ?</h1></br>   
                                   
                                </div>

                        </div>
                        <div class="modal-footer bt-dec">
                            <button class="btn btn-outline-danger" type="submit" value="Supprimer">oui</button>
                            </form>
                            <input type="button" value="Non" class="btn btn-dark" data-bs-dismiss="modal">    

                        </div>
                    </div>
                </div> 
            </div>



