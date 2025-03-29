<%-- 
    Document   : liste
    Created on : 9 sept. 2024, 09:40:46
    Author     : Hery
--%>

<%@include file="header.jsp"%>
<% 
            String destination =(String) session.getAttribute("destination");
            int nbpers =(int) session.getAttribute("nbpers");
            String depart =(String) session.getAttribute("depart"); 
            String date_depart=(String) session.getAttribute("date_depart"); 
            int duree=(int) session.getAttribute("duree"); 
            RechercheDao rech= new RechercheDao();
            rech.setDate(date_depart);
            rech.setDepart(depart);
            rech.setDestination(destination);
            rech.setNbr(nbpers);
            String arr;
            Convert convert  = new Convert();
            int con= 0;

%>
<div class="content">
    <form action="PanierServlet" method="post" id="resForm">
        <input type="hidden" name="nb" value="<%=nbpers%>">
        <input type="hidden" name="login" value="<%=login%>">
        <input type="hidden" name="duree" value="<%=duree%>">
        <input type="hidden" name="date_depart" value="<%=date_depart%>">
        <div id="list-item">
            <h3 id="k"></h3>

            <%@include file="listvol.jsp"%>  
            <%@include file="listhotel.jsp"%> 

        </div>
           
            <% if (x>0){ %>        
        <div class="step-button">
            <input type="Button" value="Precedent" class="btn btn-outline-dark" id="prevBtn" onclick="nextPrev(-1)">
            <input type="Button" value="Suivant" class="btn btn-primary" id="nextBtn" onclick="nextPrev(1)">
            <input type="Submit" class="btn btn-primary" value="Continuer" id="Confirm" >
        </div> 
       
            <% }
            
            else
{%>
<div class="retour-all">
    <h1>Nous n'avons pas trouve des resultats correspondants a vos recherches </h1>
<a href="BackServelt" class="btn btn-dark " >retour</a>
</div>
<%}
            
            %>
     </form>

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

    const volRadios = document.querySelectorAll('input[name="vol"]');
    const hotelRadios = document.querySelectorAll('input[name="hotel"]');
    var k = 0;

    const checkRadios = () => {
        // Vérifie si au moins un radio est sélectionné dans les deux groupes
        const volChecked = Array.from(volRadios).some(radio => radio.checked);
        const hotelChecked = Array.from(hotelRadios).some(radio => radio.checked);

        if (volChecked || hotelChecked) {
            k = 1; // Affiche le bouton
        }  // Cache le bouton si aucun n'est sélectionné
        consol.log(k);
    };
    volRadios.forEach(radio => {
        radio.addEventListener('change', checkRadios);
    });

    hotelRadios.forEach(radio => {
        radio.addEventListener('change', checkRadios);
    });

    function setMinDate() {
        const today = new Date().toISOString().split('T')[0];
        const dates = document.querySelectorAll('input[type="date"]');
        dates.forEach(input => {
            input.setAttribute('min', today), input.value = today;
        });
    }
    setMinDate();





    var currentTab = 0; // Current tab is set to be the first tab (0)
    showTab(currentTab); // Display the current tab


    function showTab(n) {
        document.getElementById("Confirm").style.display = "none";


        var x = document.getElementsByClassName("tab");
        x[n].style.display = "block";

        if (n === 0) {
            document.getElementById("prevBtn").style.display = "none";
            document.getElementById("nextBtn").style.display = "inline";

        } else {

            document.getElementById("prevBtn").style.display = "inline";

        }
        if (n === (x.length - 1)) {
            document.getElementById("Confirm").style.display = "inline";
            document.getElementById("prevBtn").style.display = "inline";
            document.getElementById("nextBtn").style.display = "none";
        }

    }


    function nextPrev(n) {
        // This function will figure out which tab to display
        var x = document.getElementsByClassName("tab");
        // Exit the function if any field in the current tab is invalid:

        x[currentTab].style.display = "none";
        currentTab = currentTab + n;
        showTab(currentTab);

    }




</script>