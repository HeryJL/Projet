<%-- 
    Document   : findHotel
    Created on : 30 sept. 2024, 19:52:50
    Author     : Hery
--%>
<%@include file="header.jsp"%>

<% 
            String destination =(String) session.getAttribute("destination");
            int nbpers =(int) session.getAttribute("nbpers");
            String date_depart=(String) session.getAttribute("date_depart"); 
            int duree=(int) session.getAttribute("duree"); 
            RechercheDao rech= new RechercheDao();
            rech.setDate(date_depart);
            rech.setDestination(destination);
            rech.setNbr(nbpers);
%>
<div class="content">
    <%  
       List<HotelModel> listHotel=rech.findHotel();
       if ( listHotel.size() !=0){ %>
    <h2 class="text-center titre">Les hotels disponibles a <%=rech.getDestination()%> </h2>
    <form action="PanierServlet" method="post" id="resForm">
        <input type="hidden" name="nb" value="<%=nbpers%>">
        <input type="hidden" name="login" value="<%=login%>">
        <input type="hidden" name="date_depart" value="<%=date_depart%>">
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


        <!------------Modala pour hotel-->

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

        <% } %>
        <div class="step-button text-center">
            <input type="Submit" value="Confirmer" id="Confirm" >
        </div>    
    </form>

    <%
    }
    else {%>
    <div class="no-result">
        <h2 class="text-center titre">Desole , il n'y a pas d'hotel disponible a   <%=rech.getDestination()%> </h2>
        <div class="no-btn">
            <form action="BackServelt" methode="post">
                <input type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#hotel" value="Modifier">
                <input type="submit"class="btn btn-outline-dark" value="Revenir a l'accueil">
            </form>
            
        </div>
    </div>
    <%
        }
    %>
</div>

<!--Modal pour modifier hotel-->

<div class="modal fade" id ="hotel" role="dialog" aria-labelledby="titleVille" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered " role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="titleVille">Recherche des Hotels</h5>
                <button class="btn" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body hotel-res">
                <form method="post"  action="RechercheHotel" name="formulaire">
                    <div class="hs-i">
                        <label>Ville</label></br>
                        <input type="text" name="dest" placeholder="Ou voulez-vous aller" value="<%=destination%>" required>
                    </div>
                    <div class="hs-i">
                        <label>Date </label></br>
                        <input class="text-center" type="date" name="date_depart" value="<%=date_depart%>" required>
                    </div>
                    <div class="hs-i">
                        <label>Duree</label></br>
                        <input class="text-center" type="text" name="duree" value="<%=duree%>" min="1" placeholder="Pendant combietm de temps ?"  >
                    </div>
                    <div class="hs-i">
                        <label>nombre de personne</label></br>
                        <input class="col-md-2" type="number" name="nbpers" value="<%=nbpers%>"  min="1" max="10" required>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-primary" type="submit" value="valider">Valider</button>
                </form>
                <input type="button" value="Annuler" class="btn btn-secondary" data-bs-dismiss="modal">    
            </div>
        </div>
    </div> 
</div>
</div>


<script>
    var k = document.getElementById("k");
    function checkVol(valeur) {
        const radioVh = document.querySelectorAll('input[class="radioVol"]');
        radioVh.forEach(radio => {
            radio.checked = (radio.value == valeur);


        });
    }

    const vh = document.querySelectorAll('div[class="VolDesc"]');
    vh.forEach(div => {
        div.addEventListener('click', () => {
            const dal = div.getAttribute('data-value');
            checkVol(dal);
        });
    });



    function checkHotel(valeur) {
        const radio = document.querySelectorAll('input[class="radioHotel"]');
        radio.forEach(radio => {
            radio.checked = (radio.value == valeur);


        });
    }

    const hv = document.querySelectorAll('input[class="btn btn-secondary r"]');
    hv.forEach(input => {
        input.addEventListener('click', () => {

            const val = input.getAttribute('data-value');
            checkHotel(val);
        });
    });
    function setMinDate() {
        const today = new Date().toISOString().split('T')[0];
        const dates = document.querySelectorAll('input[type="date"]');
        dates.forEach(input => {
            input.setAttribute('min', today), input.value = today;
        });
    }
    setMinDate();

</script>