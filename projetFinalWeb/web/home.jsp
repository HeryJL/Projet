<%-- 
    Document   : home
    Created on : 9 sept. 2024, 09:30:44
    Author     : Hery
--%>

<%@include file="header.jsp"%>
<div class=" head">
    <div class="head-item">
        <div class="text-head" data-animate-effect="fadeInUp">
            <h1>Explorer le monde. </h1><br>
            <h2> Grace a nos offres, vous pouvez planifier vos prochains voyages en toute simplicite  </h2>
        </div>
        <div class="form-head">
            <form action="RechercheServlet" method="post">
                <div class="input--group" >
                    <!--         <span class="input-group-text" id="map"><i class="fas fa-map"></i></span>-->
                    <div class="list-input">
                        <label>Destination</label> 
                        <div class="input-item">
                            <span class="input-group-text" id="map"><i class="fas fa-map"></i></span>
                            <input type="text" name="destination" id="myInput" class="head-input" id="destination" placeholder="Où voulez-vous visiter ?" required>
                        </div>
                    </div>
                    <div class="list-input">
                        <label>Depart</label> 
                        <div class="input-item">
                            <span class="input-group-text" id="map"><i class="fas fa-location-dot"></i></span>
                            <input type="text" name="depart"  class="head-input"  id="depart" placeholder="D'où venez-vous ?" aria-describedby="map" required>
                        </div>
                    </div>
                    <div class="list-input">
                        <label>Date</label> 
                        <div class="input-item">
                            <span class="input-group-text" id="map"><i class="fas fa-location-dot"></i></span>
                            <input type="date" name="date_depart" class="head-input"  placeholder="Depart" required>
                        </div>
                    </div>
                    <div class="list-input">
                        <label>Duree</label> 
                        <div class="input-item">
                            <span class="input-group-text" id="map"><i class="fas fa-location-dot"></i></span>
                            <input type="number" name="duree" placeholder="Combien de jours ?" class="head-input"  min="1" max="5" required>
                        </div>
                    </div>
                    <div class="list-input">
                        <label>Voyageurs</label> 
                        <div class="input-item">
                            <span class="input-group-text" id="map"><i class="fas fa-person"></i></span>
                            <input type="number" name="nb" class="head-input"  placeholder="Combien êtes-vous?" min="1"  max="5" required>
                        </div>
                    </div>
                    <input type="submit" name="boutton" value="Explorer" >
                </div>
            </form>
        </div>
    </div>
</div>
<div class="extra">
    <h2 class="text-center">Les destination les plus visites</h2>
    <div class="pop-dest d-flex">
        <% for(VilleModel ville : villeTop) {%>
        <div class="item-pop">

            <img src="images/ville/<%=ville.getImg_ville()%>" alt="alt"/>

            <div class="text-pop">
                <h3 class="text-center" data-bs-toggle="modal" data-bs-target="#dest<%=ville.getId_ville()%>">
                    <%=ville.getNom_ville()%>
                </h3>

            </div>

        </div>

        <div class="modal fade" id ="dest<%=ville.getId_ville()%>" role="dialog" aria-labelledby="titleVille" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered " role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="titleVille">Visiter <%=ville.getNom_ville()%></h5>
                        <button class="btn" data-bs-dismiss="modal"></button>
                    </div>
                    <div class="modal-body hotel-res">
                        <form method="post"  action="RechercheServlet" name="formulaire">
                            <input type="hidden" name="destination" id="myInput" class="head-input" id="destination" placeholder="Où voulez-vous visiter ?" value="<%=ville.getNom_ville()%>">
                            <div class="hs-i">
                                <label>Ville</label></br>
                                <input type="text" name="depart"  class="head-input"  id="depart" placeholder="D'où venez-vous ?" aria-describedby="map" required>
                            </div>
                            <div class="hs-i">
                                <label>Date </label></br>
                                <input type="date" name="date_depart" class="head-input"  placeholder="Depart" required>
                            </div>
                            <div class="hs-i">
                                <label>Duree</label></br>
                                <input class="text-center" type="number" name="duree" value="1" min="1" placeholder="Pendant combietm de temps ?"  >
                            </div>
                            <div class="hs-i">
                                <label>nombre de personne</label></br>
                                <input type="number" name="nb" class="head-input"  placeholder="Combien êtes-vous?" min="1"  max="5" required>
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


    <%
        }
        
    %>


</div>
</div>
<div class="resa py-2">
    <h2 class="text-center mb-5 mt-3">Trouver un hotel ou un vol qui vous convient</h2>
    <div class="d-flex rech">
        <div class="rech-vol" data-bs-toggle="modal" data-bs-target="#vol">
            <i class="fas fa-plane"></i>
            <h3 class="mt-1">Reserver vol</h3>
        </div>
        <div class="rech-hotel" data-bs-toggle="modal" data-bs-target="#hotel"  >
            <i class="fas fa-hotel"></i>
            <h3 class="mt-1">Reserver hotel</h3>
        </div>
    </div>
</div>

<!--modal pour res-hotel-->

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
                        <input type="text" name="dest" placeholder="Ou voulez-vous aller" required>
                    </div>
                    <div class="hs-i">
                        <label>Date </label></br>
                        <input class="text-center" type="date" name="date_depart"  required>
                    </div>
                    <div class="hs-i">
                        <label>Duree</label></br>
                        <input class="text-center" type="text" name="duree" value="1" min="1" placeholder="Pendant combietm de temps ?"  >
                    </div>
                    <div class="hs-i">
                        <label>nombre de personne</label></br>
                        <input class="col-md-2" type="number" name="nbpers" min="1" max="10" value="1" required>
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


<!--modal pour res-vol-->

<div class="modal fade" id ="vol" role="dialog" aria-labelledby="titleVille" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered " role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="titleVille">Recherche des vols</h5>
                <button class="btn" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                <form method="post"  action="RechercheVol" name="formulaire">
                    <label>Ville de depart</label></br>
                    <input class="text-center" type="text" name="depart" placeholder="D'ou venez vous "></br>
                    <label>Ville d' arriver</label></br>
                    <input type="text" name="dest" placeholder="Ou voulez-vous aller"></br>
                    <label>Date de depart</label></br>
                    <input class="text-center" type="date" name="date_depart"  required></br>
                    <label>nombre de personne</label></br>
                    <input class="" type="number" name="nbpers" min="1"max="5" value="1" required></br>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-primary" type="submit" value="Rechercher">Rechercher</button>
                </form>
                <input type="reset" value="Annuler" class="btn btn-outline-secondary" data-bs-dismiss="modal">    
            </div>
        </div>
    </div> 
</div>

<script>

    function setMinDate() {
        const today = new Date().toISOString().split('T')[0];
        const dates = document.querySelectorAll('input[type="date"]');
        dates.forEach(input => {
            input.setAttribute('min', today);
            input.value = "";
        });
    }
    setMinDate();
</script> 
