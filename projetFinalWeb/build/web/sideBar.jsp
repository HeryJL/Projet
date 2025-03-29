<%-- 
    Document   : sideBar
    Created on : 31 août 2024, 20:00:59
    Author     : Hery
--%>
<%
        response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");
        response.setHeader("Pragma", "no-cache"); // Pour les anciens navigateurs
        response.setDateHeader("Expires", 0);
         String login = (String)session.getAttribute("nom");
       
       if(login == null){
     
          request.getRequestDispatcher("Link?page=index").forward(request,response);
        }
%>

<div class="navbar bg-dark text-white  fixed">
    <ul class="menu-list">
        <li><i class="fas fa-user-astronaut"></i> <a><a href="Link?page=adminDashboard"> Admin</a></li>
        <li><i class="fas fa-map"></i><a href="Link?page=adminDestination"> Destination</a></li>
        <li><i class="fas fa-hotel"></i><a href="Link?page=adminHotel"> Hotel </a></li>
        <li><i class="fas fa-plane"></i><a href="Link?page=adminVol"> Vol</a> </li>
        <li><i class="fas fa-door-open"></i><a href="DeconnectServlet"> Sortir</a>
    </ul> 
</div>