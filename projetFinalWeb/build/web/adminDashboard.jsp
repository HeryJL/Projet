<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : chart
    Created on : 25 sept. 2024, 09:30:56
    Author     : Hery
--%>
<%
int a= 100;    

%>
<%@include file="admin.jsp"%>
<div class="home">
    <%@include file="sideBar.jsp"%>
    <div class="item-info">
        <div class="info-count col-md-10">
            <div class="count-item col-md-3">
                <div class="text-count">
                    <h4>Reservation</h4>
                    <h1 id="count-res">0</h1>
                </div>
                <div clas="icon-count" id="res">
                    <i class="fa fa-check-to-slot" ></i>
                </div>
            </div>
            <div class="count-item col-md-3">
                <div class="text-count">
                    <h4>Hotel</h4>
                    <h1 id="count-hotel">0</h1>
                </div>
                <div clas="icon-count" id="a">
                    <i class="fa fa-hotel" ></i>
                </div>
            </div>
            <div class="count-item col-md-3">
                <div class="text-count">
                    <h4>Vol</h4>
                    <h1 id="count-vol">0</h1>
                </div>
                <div clas="icon-count" id="b">
                    <i class="fa fa-plane" ></i>
                </div>
            </div>


        </div>


        <div class="d-flex mx-2 bar">
            <div class="col-md-5 chart-bar">
                <div class="titre-chart text-center">Hotel</div>
                <canvas id="hotel" class="chartBar"></canvas>
            </div>

            <div class="col-md-5 chart-bar">
                <div class="titre-chart text-center">Vol</div>
                <canvas id="vol" class="chartBar"></canvas>
            </div>
        </div>

        <div class="col-md-7  chart-bar">
            <div class="titre-chart text-center">Reservation</div>
            <canvas id="panier" class="chartBar"></canvas>
        </div>
        <div class="col-md-6 mx-10 chart-bar">
            <div class="titre-chart text-center">Listes des client</div>
            <div class="client-list">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Oo</th>
                            <th>xcv</th>
                            <th>v</th>
                            <th>df</th>
                            <th>sdf</th>
                            <th>yu</th>
                        </tr>
                    </thead>
                    <tbody>

                    
               

                <% for(ClientModel client :listClient){
                    
                %>
                <tr>
                    <td><%=client.getNom_client()%></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <% }
                %>
                     </tbody>
                </table>
            </div>
        </div>

    </div>
</div>
<script>

    var chambre = [
    <% for (HotelModel hotel : hotelList) { %>
        "<%= hotel.getNb_chambre() %>",
    <% } %>];
    const hotel = [
    <% for (HotelModel hotel : hotelList) { %>
        "<%= hotel.getNom_hotel()%>",
    <% } %>];

    const hotocup = [
    <% for (HotelModel hotel : hotelList) { %>
        " <%=hotel.getNb_chambre()- hotel.getDispo()%>",
    <% } %>

    ];

    const vol = [<% for (VolModel vol : volList) { %>
    " <%=vol.getNb_billet()%>",
    <% } %>
    ];

    const comp = [
    <% for (VolModel vol : volList) { %>
        " <%=vol.getNom_comp()%>",
    <% } %>
    ];
    const dispovol = [
    <% for (VolModel vol : volList) { %>
        " <%=vol.getDispo()%>",
    <% } %>

    ];

    var datePanier = [
    <% for (PanierModel panier : list) { %>
        " <%=panier.getDate_depart()%>",
    <% } %>

    ];

    const nbpanier = [
    <% for (PanierModel panier : list) { %>
        " <%=panier.getNb_pers()%>",
    <% } %>

    ];

    decont("count-hotel", <%=hotelList.size()%>);
    decont("count-vol", <%=volList.size()%>);
    decont("count-res", <%=panierList.size()%>);
    line("panier", datePanier, nbpanier, 'rgb(60, 11 ,91)');
    chart("vol", vol, "bar", comp, "Nombre de vol ", 'rgb(60, 121 ,91)', 'list des vols');
    MultipleBar("hotel", [chambre, hotocup], hotel, ["Nombre de chambre", "occupe"], ['rgb(5, 11 , 1)', 'rgb(255, 191, 2)']);
</script>




