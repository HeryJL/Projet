<%-- 
    Document   : adminHotel
    Created on : 2 sept. 2024, 21:14:07
    Author     : Hery
--%>

<%@include file="admin.jsp"%>
<div class="home">
    <%@include file="sideBar.jsp"%>
    <div class="item-info">
        <h1 class="text-center"> LISTE DES HOTELS </h1>
         <div class="nb-info col-md-10">
            <div class="nb-item col-md-3">
                <div class="text-nb">
                    <h4>Reservation</h4>
                    <div class="cercle">
                        <div class="rotate">
                            <svg width="120" height="120" >
                        <circle id="v" cx="60" cy="60" r="40" fill="none" stroke="blue" stroke-width="10" 
                                stroke-dasharray="400"stroke-linecap="round" stroke-dashoffset="0" />
                        
                        </svg>
                        </div>
                        
                        <div class="pourectage">
                            <h1><%=panierList.size()%></h1>
                        </div>
                        
                    </div>
                </div>
            </div>
            <div class="nb-item col-md-3">
                <div class="text-nb">
                    <h4>Reservation</h4>
                    <div class="cercle">
                        <div class="rotate">
                            <svg width="120" height="120" >
                        <circle id="v" cx="60" cy="60" r="40" fill="none" stroke="blue" stroke-width="10" 
                                stroke-dasharray="400"stroke-linecap="round" stroke-dashoffset="0" />
                        
                        </svg>
                        </div>
                        
                        <div class="pourectage">
                            <h1><%= hotelList.size()%></h1>
                        </div>
                        
                    </div>
                </div>
            </div>
            <div class="nb-item col-md-3">
                <div class="text-nb">
                    <h4>Reservation</h4>
                    <div class="cercle">
                        <div class="rotate">
                            <svg width="120" height="120" >
                        <circle id="v" cx="60" cy="60" r="40" fill="none" stroke="blue" stroke-width="10" 
                                stroke-dasharray="400"stroke-linecap="round" stroke-dashoffset="0" />
                        
                        </svg>
                        </div>
                        
                        <div class="pourectage">
                            <h1><%=volList.size()%></h1>
                        </div>
                        
                    </div>
                </div>
            </div>
            
        </div>
        <div class="text-center">
            <button class=" btn btn-outline-primary bt-ajout " data-bs-toggle="modal" data-bs-target="#ajoutHotel"><i class=" fa fa-hotel"></i> Ajouter Hotel</button>
        </div>
        <div class="modal fade" id ="ajoutHotel" role="dialog" aria-labelledby="titleVille" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered " role="document">
                <div class="modal-content">
                    <div class="modal-header text-center">
                        <h5 class="modal-title" id="titleVille">Ajouter un hotel </h5>
                        <button class="btn" data-bs-dismiss="modal"></button>
                    </div>
                    <div class="modal-body">
                        <form method="post"  action="AjoutHotelServlet" >

                            <label>Nom de l'hotel</label></br>
                            <input class="text-center" type="text" name="hotel" placeholder="Nom de l'hotel" required></br>
                            <label>Localisation</label></br>
                            <input class="text-center" type="text" name="localisation" placeholder="Ou se trouve l'hotel" required></br>
                            <label>Nombre de chambre</label></br>
                            <input class="text-center" type="number" name="nb" min="5" value="5" placeholder="Nombre de chambre" required></br>
                            <label>Prix</label></br>
                            <input class="" type="number" name="prix" min="100" value="100" placeholder="Prix" required></br>
                            <label>Note</label></br>
                            <input class="" type="number" name="note" min="1" max="5" value="1" placeholder="Note" required></br>
                            <label>Description</label></br>
                            <input  type="text" name="desc"  placeholder="Ajouter une description de l'hotel" required></br>
                            <label>Photo</label></br>
                            <input type="file"  name="img" placeholder="Phote de l'hotel" required >
                            </div>
                            <div class="modal-footer">
                                <button class="btn btn-primary" type="submit" value="valider">Valider</button>
                        </form>
                        <input type="button" value="Annuler" class="btn btn-secondary" data-bs-dismiss="modal">    

                    </div>
                </div>
            </div> 
        </div> 
        <div class="listHotel row" >
            <%
           
              for(HotelModel hotel : hotelList  ){
            %>
            <div class=" col-md-3 col-sm-12 my-3 my-md-3 ">
                <div class="HotelDesc"> 
                    <div class="card-shadow ">
                        <img class="card-img-top img-hotel "  src="images/hotel/<%=hotel.getImg_hotel()%>">
                    </div>
                    <div class="card-body ">
                        <h5 class="card-title"></h5>
                        <div class="text-center">
                            <h4> <%=hotel.getNom_hotel()%></h4>
                            <% for (int i =0 ;i< hotel.getNote_hotel();i++){ %>
                            <i class="fas fa-star "></i>
                            <% }%>

                        </div><br>
                        <div class="hdesk">
                            <h5> <%=hotel.getDesc_hotel()%></h5>
                        </div>
                        <div class="d-flex ">
                            <h6 class="col-md-5"><i class="fas fa-location-dot"></i> <%=hotel.getVille()%></h6>
                            <h6 class="col-md-4"><i class="fas fa-bed"></i> <%=hotel.getDispo()%>/<%=hotel.getNb_chambre()%></h6>
                            <h6 class="col-md-3"><i class="fas fa-money-bill"></i> <%=hotel.getPrix()%>$</h6>
                        </div><br>
                        <div class="text-center">
                            <button class="btn btn-outline-dark bt-info" data-bs-toggle="modal" data-bs-target="#e<%=hotel.getId_hotel()%>"><i class="fas fa-edit"></i></button> 
                            <button class="btn btn-outline-dark bt-info" data-bs-toggle="modal" data-bs-target="#d<%=hotel.getId_hotel()%>"><i class="fas fa-trash"></i></button> 
                        </div>
                    </div> 

                </div>
            </div>

            <div class="modal fade" id ="e<%=hotel.getId_hotel()%>" role="dialog" aria-labelledby="titleVille" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered " role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="titleVille"><%=hotel.getNom_hotel()%></h5>
                            <button class="btn" data-bs-dismiss="modal"></button>
                        </div>
                        <div class="modal-body">
                            <form method="post"  action="ModifHotelServlet" name="formulaire">
                                <input type="hidden" name="id_hotel" value="<%=hotel.getId_hotel()%>"></br>
                                <label>Nom de l'hotel</label></br>
                                <input class="text-center" type="text" name="hotel" value="<%=hotel.getNom_hotel()%>" placeholder="<%=hotel.getNom_hotel()%>" required></br>
                                <label>Localisation</label></br>
                                <input class="text-center" type="text" name="localisation" value="<%=hotel.getVille()%>" placeholder="<%=hotel.getVille()%>" required></br>
                                <label>Nombre de chambre</label></br>
                                <input class="text-center" type="number" name="nb" min="5" value="<%=hotel.getNb_chambre()%>" required></br>
                                <label>Prix</label></br>
                                <input class="" type="number" name="prix" min="100"  value="<%=hotel.getPrix()%>" required></br>
                                <label>Note</label></br>
                                <input class="" type="number" name="note" min="1" max="5"  value="<%=hotel.getNote_hotel()%>" required></br>

                                <label>Description</label></br>
                                <input  type="text" name="desc"  value="<%=hotel.getDesc_hotel()%>" required></br>
                                <label>Photo</label></br>
                                <input type="file"  name="img" value="<%=hotel.getImg_hotel()%>" required >
                                </div>
                                <div class="modal-footer">
                                    <button class="btn btn-primary" type="submit" value="valider">Valider</button>
                            </form>
                            <input type="button" value="Annuler" class="btn btn-secondary" data-bs-dismiss="modal">    

                        </div>
                    </div>
                </div> 
            </div>    
            <div class="modal fade" id ="d<%=hotel.getId_hotel()%>" role="dialog" aria-labelledby="titleVille" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-lg " role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                        </div>
                        <div class="modal-body">
                            <form method="post"  action="DeletItemServlet" name="formulaire">
                                <input type="hidden" name="id" value="<%=hotel.getId_hotel()%>"></br>
                                <input type="hidden" name="type" value="Hotel"></br>
                                <div class="text-center">
                                    <h1>Voulez - vous vraiment supprimer</h1></br>   
                                    <h1><%=hotel.getNom_hotel()%></h1></br>   

                                    <h1><%=hotel.getVille()%></h1></br>
                                </div>

                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-outline-danger" type="submit" value="Supprimer">Supprimer</button>
                            </form>
                            <input type="button" value="Annuler" class="btn btn-dark" data-bs-dismiss="modal">    

                        </div>
                    </div>
                </div> 
            </div>


            <%  } 
            
            %>  

        </div>
    </div> 
</div>
