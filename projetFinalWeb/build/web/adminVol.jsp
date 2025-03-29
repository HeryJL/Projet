<%-- 
    Document   : adminVol
    Created on : 2 sept. 2024, 22:00:02
    Author     : Hery
--%>

<%@include file="admin.jsp"%>
<div class="home">
    <%@include file="sideBar.jsp"%>
    <div class="item-info">
        <h1 class="text-center"> LISTE DES VOLS </h1>
        <div class="text-center">
        <button class=" btn btn-outline-primary bt-ajout " data-bs-toggle="modal" data-bs-target="#ajoutVol"><i class=" fa fa-plane"></i> Ajouter un vol</button>
         </div>
        <div class="modal fade" id ="ajoutVol" role="dialog" aria-labelledby="titleVille" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered " role="document">
                <div class="modal-content">
                    <div class="modal-header text-center"">
                        <h5 class="modal-title" id="titleVille">Ajouter un vol</h5>
                          <button class="btn" data-bs-dismiss="modal"></button>
                    </div>
                    <div class="modal-body">
                        <form method="post"  action="AjoutVolSevlet" name="formulaire">
                         
                            <label>Nom de la companie </label></br>
                            <input class="text-center" type="text" name="companie" value="" placeholder="Nom de la companie" required></br>
                            <label>Depart</label></br>
                            <input class="text-center" type="text" name="depart" value="" placeholder="Ville de depart"required></br>
                            <label>Arrive</label></br>
                            <input class="text-center" type="text" name="arrive" value=""placeholder="Ville d'arrive" required></br>
     
                            <label>Date du vol</label><label>       Heure</label></br>
                            <input class="text-center" type="date" name="date" value="" placeholder="Date de depart">
                            <input class="text-center" type="time" name="heuredep" value="" >
                            <input class="text-center" type="time" name="duree" value="" ></br>
                            
                            <label>nombre de billet</label></br>
                            <input class="" type="number" name="nb" min="5" value="5" placeholder="Nombre de billet"required></br>
                            <label>Prix</label></br>
                            <input class="" type="number" name="prix" min="100" value="100" placeholder="Prix du billet" required></br>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-primary" type="submit" value="valider">Valider</button>
                        </form>
                        <input type="button" value="Annuler" class="btn btn-secondary" data-bs-dismiss="modal">    
                       
                    </div>
                </div>
            </div> 
        </div>
        <div class="listVol">
        <%
          Convert convert  = new Convert();
        
          String arr;
          
          for(VolModel vol : volList)  {  
        %>
         <div class="VolDesc " data-value="<%=vol.getId_vol()%>">
                            <div class="col-md-2">
                                <h5><%=vol.getNom_comp()%></h5>
                            </div>
                             <div class="col-md-2 text-center">
                                <h5> <i class="far fa-calendar "></i></h5>                  
                                <h5><%=vol.getDate_vol()%></h5>
                            </div>
                            <div class="col-md-2 ">
                                <h5 ><i class="fas fa-plane-departure "></i>:  <%=vol.getDepart()%></h5>
                                <h5 class=""><%=vol.getHeure_dep()%></h5>
                            </div>
                            <div class="col-md-2 ">
                                <h5><i class="fas fa-plane-arrival "></i>:  <%=vol.getDestination()%></h5>                  
                                <h5><%arr= convert.getArrive(vol.getHeure_dep(),vol.getDuree_vol());%>
                                    <%=arr%>
                                </h5>
                            </div>
                                <div class="col-md-1">
                                <div><h4><%=vol.getPrix()%>$</h4></div>
                            </div>
                            <div class="btn-group">
                                <button class="btn btn-outline-dark " data-bs-toggle="modal" data-bs-target="#m<%=vol.getId_vol()%>"><i class="fas fa-edit"></i></button>
                                <button class="btn btn-outline-dark " data-bs-toggle="modal" data-bs-target="#s<%=vol.getId_vol()%>"><i class="fas fa-trash "></i></button>
              
                            </div>
                        </div>
           <div class="modal fade" id ="m<%=vol.getId_vol()%>" role="dialog" aria-labelledby="titleVille" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered " role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="titleVille"><%=vol.getNom_comp()%></h5>
                          <button class="btn" data-bs-dismiss="modal"></button>
                    </div>
                    <div class="modal-body">
                        <form method="post"  action="ModifVolServlet" name="formulaire">
                            <input type="hidden" name="id_vol" value="<%=vol.getId_vol()%>"></br>
                            <label>Nom de la companie </label></br>
                            <input class="text-center" type="text" name="companie" value="<%=vol.getNom_comp()%>" required></br>
                            <label>Depart</label></br>
                            <input class="text-center" type="text" name="depart" value="<%=vol.getDepart()%>" required></br>
                            <label>Arrive</label></br>
                            <input class="text-center" type="text" name="arrive" value="<%=vol.getDestination()%>" required></br>
     
                            <label>Date du vol</label><label>       Heure</label></br>
                            <input class="text-center" type="date" name="date" value="<%=vol.getDate_vol()%>" >
                            <input class="text-center" type="time" name="heuredep" value="<%=vol.getHeure_dep()%>" >
                            <input class="text-center" type="time" name="duree" value="<%=vol.getDuree_vol()%>" ></br>
                            
                            <label>nombre de billet</label></br>
                            <input class="" type="number" name="nb" min="1" value="<%=vol.getNb_billet()%>" required></br>
                            <label>Prix</label></br>
                            <input class="" type="number" name="prix" min="1" value="<%=vol.getPrix()%>" required></br>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-primary" type="submit" value="valider">Valider</button>
                        </form>
                        <input type="button" value="Annuler" class="btn btn-secondary" data-bs-dismiss="modal">    
                       
                    </div>
                </div>
            </div> 
        </div>
        
        <div class="modal fade" id ="s<%=vol.getId_vol()%>" role="dialog" aria-labelledby="titleVille" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-lg " role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        
                    </div>
                    <div class="modal-body">
                        <form method="post"  action="DeletItemServlet" name="formulaire">
                            <input type="hidden" name="id" value="<%=vol.getId_vol()%>"></br>
                            <input type="hidden" name="type" value="Vol"></br>
                            <div class="text-center">
                                <h1>Voulez - vous vraiment supprimer</h1></br>   
                            <h1><%=vol.getNom_comp()%></h1></br>   
                            <h1><%=vol.getDepart()%> - <%=vol.getDestination()%></h1></br>
                            <h1><%=vol.getDate_vol()%></h1></br>
                            </div>
                            
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-outline-danger" type="submit" value="Supprimer">Supprimer</button>
                        </form>
                        <input type="button" value="Annuler" class="btn btn-dark " data-bs-dismiss="modal">    
                       
                    </div>
                </div>
            </div> 
        </div>
                            
        
          <% }%>               
        </div>
    </div>
      
</div>
  <script>
        
        function setMinDate() {
            const today = new Date().toISOString().split('T')[0];
            const dates = document.querySelectorAll('input[type="date"]');
            dates.forEach(input=> {
                input.setAttribute('min', today),input.value=today;
            });
        }
        setMinDate();
        </script> 
