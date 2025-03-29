<%-- 
    Document   : panier
    Created on : 12 sept. 2024, 19:44:20
    Author     : Hery
--%>

<%@include file="header.jsp"%>

<div class="panier home">
    <div class="fact">
        <% 
        CommandeDao cmd =new CommandeDao();
        int a = cmd.verifPanier(login);
          if(a>0){
        %>
        <div class=" row  text-center list-panier">
            <%  
       
             a = 0;
            int h= 0;
            int v = 0;
            int s = 0;
            int nb= cmd.Nb_pers(login);
            List<HotelModel> listHotel=   cmd.hotelPanier(login);
            for(HotelModel hotel :listHotel){
              a++;
              h= h + (hotel.getPrix() *nb);
            %>
            <div class=" col-md-4">
                <div class="card item-panier">
                    <div class="card-header ">
                        <i class="fas fa-hotel" style="height: 50px;"></i>
                    </div>
                    <div class="card-body">
                        <h2><%=hotel.getNom_hotel()%></h2><br>
                        <h2>$<%=hotel.getPrix() *nb%></h2>
                        <form action="AnnulerItemServlet">
                            <input type="hidden" name="id_item" value="<%=hotel.getPanier_id()%>" >
                            <button class="btn btn-outline-danger"> Retirer</button> 
                        </form>
                    </div>

                </div>

            </div>

            <% }
              List<VolModel> volList=   cmd.volPanier(login);
              for(VolModel vol : volList){ 
            a++;
            v= v+(vol.getPrix()*nb);
            %>

            <div class=" col-md-6">
                <div class="card item-panier">
                    <div class="card-header">
                        <i class="fas fa-plane" style="height: 50px;"></i>
                    </div>
                    <div class="card-body">
                        <h2><%=vol.getNom_comp()%></h2><br>
                        <div class="d-flex dest">
                            <h3 class="col-5"><%=vol.getDepart()%> </h3>
                            <h1  class=""> - </h1>
                            <h3  class="col-5"><%=vol.getDestination()%></h3>
                        </div>
                        <h2>$<%=vol.getPrix() *nb%></h2>
                        <form action="AnnulerItemServlet" method="post">
                            <input type="hidden" name="id_item" value="<%=vol.getPanier_id()%>" >
                            <button class="btn btn-close btn-outline-danger"></button>
                        </form>
                    </div>

                </div>

            </div>

            <% 
                }
              
            %>
        </div>
        <div id="gtco-counter" class="gtco-section">
            <h2> TOTAL = <span class="counter js-counter" data-from="0" data-to="<%= v+ h%>" data-speed="500" data-refresh-interval="100">0</span>$ </h2>
        </div>
        <div class="info-facture coordonnes">

            <form action="ValidationServlet" method="post">
                <div class="d-flex info-pass row text-center col-md-9">

                </div>  

                <div>
                    <h2 class="text-center mb-4">Informations du  client </h2><br>
                    <div class=" row info-user"> 
                        <input type="hidden" name="nomClient" value="<%=login%>" >
                        <div class="col-md-5 my-3">
                            <label class="col-md-2" >Nom</label>

                            <input type="text" name="" placeholder="Nom"  class="col-md-6 input-info" required>
                        </div>
                        <div class="col-md-5">
                            <label class="col-md-3">Adresse mail</label>
                            <input type="email" name="mail"  placeholder=" Exemple@you.com" class="col-md-7 input-info" required>
                        </div>

                        <div class="col-md-5">
                            <label class="col-md-2">Adresse</label>
                            <input type="text" name="localisation" placeholder="Adresse" class="col-md-6 input-info" required>
                        </div>
                        <div class="col-md-5">
                            <label class="col-md-3" >Telephone</label>
                            <input type="number" name="tel" id="myInput" placeholder="Telephone" value=""class="col-md-7 input-info" required>
                            
                            <input type="hidden" name="montant"  value="<%= v+ h%>">
                        </div>
                    </div>
                </div>
                <div class="c d-flex">
                    <button class="bt-c" id="confirm">Confirmer</button>
                </div> 
            </form>
        </div>
        <% } 
        
 else {
        %>  


        <h1 class="text-center">Vous n'avez pas de reservation</h1>
        <% } %> 
    </div>
</div>
<script>
   
    
</script>

