<%-- 
    Document   : findVol
    Created on : 30 sept. 2024, 06:14:53
    Author     : Hery
--%>

<%@include file="header.jsp"%>
<% 
    String destination =(String) session.getAttribute("destination");
    int nbpers =(int) session.getAttribute("nbpers");
    String depart =(String) session.getAttribute("depart"); 
    String date_depart=(String) session.getAttribute("date_depart"); 
    RechercheDao rech= new RechercheDao();
    rech.setDate(date_depart);
    rech.setDepart(depart);
    rech.setDestination(destination);
    rech.setNbr(nbpers);
    String arr;
    Convert convert  = new Convert();

%>

<div class="content">
    <% 
                       List<VolModel> volList=rech.findVol();
                       if(volList.size()!= 0){
                             

    %>
    <h2 class="text-center titre">Les vols pour <%=rech.getDepart()%> - <%=rech.getDestination()%> </h2>
    <form action="PanierServlet" method="post" id="resForm">
        <input type="hidden" name="nb" value="<%=nbpers%>">
        <input type="hidden" name="login" value="<%=login%>">
        <input type="hidden" name="date_depart" value="<%=date_depart%>">
        <div id="list-item">
            <div>

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
                %>
            </div>
        </div>
        <div class="step-button text-center">
            <input type="Submit" value="Confirmer" id="Confirm" >
        </div>    

    </form>
    <% } 
else {

    %>
    
    <div class="no-result">
<h2 class="text-center titre">Desole , il n'y a pas de vol pour pour <%=rech.getDepart()%> - <%=rech.getDestination()%> </h2>
        <div class="no-btn">
            <form action="BackServelt" methode="post">
                <input type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#vol" value="Modifier">
                <input type="submit"class="btn btn-outline-dark" value="Revenir a l'accueil">
            </form>
            
        </div>
    </div>
    <%
        }
    %>
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
                        <input class="text-center" type="text" name="depart" placeholder="D'ou venez vous ?" value="<%=depart%>"></br>
                        <label>Ville d' arriver</label></br>
                        <input type="text" name="dest" placeholder="Ou voulez-vous aller" value="<%=destination%>"></br>
                        <label>Date de depart</label></br>
                        <input class="text-center" type="date" name="date_depart" value="<%=date_depart%>" required></br>
                        <label>nombre de personne</label></br>
                        <input class="" type="number" name="nbpers" min="1"max="5"  value="<%=nbpers%>" required></br>
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-primary" type="submit" value="Rechercher">Rechercher</button>
                    </form>
                    <input type="reset" value="Annuler" class="btn btn-outline-secondary" data-bs-dismiss="modal">    
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