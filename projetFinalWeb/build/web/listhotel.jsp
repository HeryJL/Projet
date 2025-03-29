<%-- 
    Document   : listhotel
    Created on : 14 sept. 2024, 17:05:16
    Author     : Hery
--%>

<div class="tab">
    
    <%  
        List<HotelModel> listHotel=rech.findHotel();
        if(listHotel.size()!=0){
        x= x+1;
        
        %> 
    <h2 class="text-center titre">Les hotels disponibles a <%=rech.getDestination()%> </h2>
    <%
            for(HotelModel hotel : listHotel ){
    %>
    <div data-bs-toggle="modal" data-bs-target="#ih<%=hotel.getId_hotel()%>">
        <input class="radioHotel"  type="radio" name = "hotel" value="<%=hotel.getId_hotel()%>" >
        <div class="HotelDesc">
            <div >
                <img src="images/hotel/<%=hotel.getImg_hotel()%>" class="img-hotel" alt="fghg">
            </div>
            <div class="col-md-5 hotel-nom">
                <h1><%=hotel.getNom_hotel()%> </h1> 
                <div class="note-hotel">
                    <% for (int i =0 ;i< hotel.getNote_hotel();i++){ %>
                    <i class="fas fa-star "></i></br>
                    <% }%>
                </div>
            </div>
            <div class="act col-md-2">

                <div class="check hc">
                    <i class="fa fa-check "></i>
                </div>
                <div class="prix">    
                    <h4><%=hotel.getPrix()%>$</h4></br> 
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id ="ih<%=hotel.getId_hotel()%>" role="dialog" aria-labelledby="titleVille" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-lg " role="document">
            <div class="modal-content">
                <div class="modal-body">
                    <img class="card-img-top" src="images/hotel/<%=hotel.getImg_hotel()%>" alt="<%=hotel.getNom_hotel()%>">

                    <h1><%=hotel.getDesc_hotel()%></h1></br>
                    <h1><%=hotel.getPrix()%></h1></br>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-secondary r" data-bs-dismiss="modal" value="Choisir" data-value="<%=hotel.getId_hotel()%>">
                </div>
            </div>
        </div> 
    </div>

    <%      }  
        
    }
        
    else {

    %>
    <div class="no-result">
        <h2 class="text-center titre">Desole , il n'y a pas d'hotel disponible a   <%=rech.getDestination()%> </h2>
        <div class="no-btn">
            <a href="BackServelt" class="btn btn-dark retour">Retourner vers l'acceuil</a> 
        </div>
         
    </div>
    <%
    }
    %>
</div>
<!--        <a href="listvol.jsp"></a>-->