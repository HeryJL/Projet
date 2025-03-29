<%-- 
    Document   : listvol
    Created on : 14 sept. 2024, 17:03:11
    Author     : Hery
--%>
<div class="tab">
    <%      int x= 0;
            List<VolModel> volList=rech.findVol();
            if(volList.size() != 0){
    x=x+1;        
    %>
    <h2 class="text-center titre">Listes des vols pour <%=rech.getDepart()%> - <%=rech.getDestination()%></h2>
    <%
        for(VolModel vol : volList)  {  

    %>

    <input class="radioVol" type="radio" name="vol"  value="<%=vol.getId_vol()%>" >
    <div class="VolDesc" data-value="<%=vol.getId_vol()%>">
        <div class="col-md-3">
            <h2><%=vol.getNom_comp()%></h2>
        </div>
        <div class="col-md-2">
            <h5>Depart <i class="fas fa-plane-departure "></i></h5>
            <h5><%=vol.getHeure_dep()%></h5>
        </div>
        <div class="col-md-2">
            <h5>Duree <i class="far fa-clock "></i></h5>                  
            <h5><%=vol.getDuree_vol()%></h5>
        </div>
        <div class="col-md-1">
            <h5>Arrive <i class="fas fa-plane-arrival "></i></h5>                  
            <h5><%arr= convert.getArrive(vol.getHeure_dep(),vol.getDuree_vol());%>
                <%=arr%>
            </h5>
        </div>
        <div class="col-md-1">
            <div class="check vc"><i class="fa fa-check "></i></div>
            <div class="prix-vol"><h4><%=vol.getPrix()%>$</h4></div>
        </div>
    </div>


    <%
        }
    }

else {

%>

    <div class="no-result">
        <h2 class="text-center titre">Desole , il n'y a pas de vol disponible pour <%=rech.getDepart()%> - <%=rech.getDestination()%> </h2>
         <a href="BackServelt" class="btn btn-dark retour">Retourner vers l'acceuil</a>
    </div>
<%
}
%>
</div>


