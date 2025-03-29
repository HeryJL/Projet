<%-- 
    Document   : adminDestination
    Created on : 3 sept. 2024, 23:15:18
    Author     : Hery
--%>

<%@include file="admin.jsp"%>
<div class="home">
    <%@include file="sideBar.jsp"%>
    <div class="item-info">

        <div class="text-center">
            <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#ajout"><i class="fas fa-map" ></i> Ajouter une ville</button>
            <div class="modal fade" id ="ajout" role="dialog" aria-labelledby="titleVille" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered " role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="titleVille">Ajout d'une ville</h5>
                            <button class="btn" data-bs-dismiss="modal"></button>
                        </div>
                        <div class="modal-body">
                            <form method="post"  action="AjoutDestination" name="formulaire">

                                <label>Nom</label>
                                <input type="text" name="nom" value="" placeholder="Nom de la ville" required="">
                                <label>Pays</label>
                                <input type="text" name="Pays" value="" placeholder="Pays" required="">
                                <label>Photo</label>
                                <input type="file" name="photo" placeholder="Photo required="">
                                </div>
                                <div class="modal-footer">
                                    <button class="btn btn-primary" type="submit" value="valider">Ajouter</button>
                            </form>
                            <input type="button" value="Annuler" class="btn btn-secondary" data-bs-dismiss="modal">    

                        </div>
                    </div>
                </div> 
            </div>

        </div><br>
        <div class="listVille row">



            <%
            
            
            for(VilleModel ville :  villelList ){
            
            %>
            <div class="col-md-4 col-sm-12 my-3  ville-item" >
                <div class="card-shadow card">
                    <div class="img-dest">
                        <img class="card-img-top"  src="images/ville/<%=ville.getImg_ville()%>" >
                    </div>
                    <div class="card-body">
                        <h5 class="card-title"></h5>
                        <h5>
                            <span ><i class="fas fa-city"></i><%=ville.getNom_ville()%></span>
                            <span ><i class="fas fa-city"></i><%=ville.getNb_visite()%></span>
                        </h5>
                        <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#i<%=ville.getId_ville()%>">Modifier</button> 
                        <button class="btn btn-outline-secondary" data-bs-toggle="modal" data-bs-target="#is<%=ville.getId_ville()%>"><i class="fas fa-trash"></i></button> 
                    </div>        
                </div>       
            </div>

            <div class="modal fade" id ="i<%=ville.getId_ville()%>" role="dialog" aria-labelledby="titleVille" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered " role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="titleVille">Modifier <%=ville.getNom_ville()%></h5>
                            <button class="btn" data-bs-dismiss="modal"></button>
                        </div>
                        <div class="modal-body">
                            <form method="post"  action="ModifierDestination" name="formulaire">
                                <input type="hidden" name="id" value="<%=ville.getId_ville()%>">
                                <label>Nom</label>
                                <input type="text" name="nom" value="<%=ville.getNom_ville()%>" placeholder="<%=ville.getNom_ville()%>" required="">
                                <label>Pays</label>
                                <input type="text" name="Pays" value="<%=ville.getPays()%>" placeholder="<%=ville.getPays()%>" required="">
                                <label>Photo</label>
                                <input type="file" name="photo" placeholder="<%=ville.getPays()%>" required="">
                                </div>
                                <div class="modal-footer">
                                    <button class="btn btn-primary" type="submit" value="valider">Modifier</button>
                            </form>
                            <input type="button" value="Annuler" class="btn btn-secondary" data-bs-dismiss="modal">    

                        </div>
                    </div>
                </div> 
            </div> 


            <div class="modal fade" id ="is<%=ville.getId_ville()%>" role="dialog" aria-labelledby="titleVille" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered " role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="titleVille"></h5>
                            <button class="btn" data-bs-dismiss="modal"></button>
                        </div>
                        <div class="modal-body">
                            <form method="post"  action="DeletItemServlet" name="formulaire">
                                <input type="hidden" name="id" value="<%=ville.getId_ville()%>">
                                <input type="hidden" name="type" value="Ville">

                                <label>Voulez-vous vraiment supprimer</label><br>
                                <h3> <%=ville.getNom_ville()%></h3>
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-primary" type="submit" value="valider">Modifier</button>
                            </form>
                            <input type="button" value="Annuler" class="btn btn-secondary" data-bs-dismiss="modal">    

                        </div>
                    </div>
                </div> 
            </div>            
            <%   
                }
            %>
        </div>
    </div>
</div>