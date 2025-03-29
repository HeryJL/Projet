<%-- 
    Document   : profil
    Created on : 9 sept. 2024, 09:39:46
    Author     : Hery
--%>

<%@include file="header.jsp"%>
<% 
    UserModel user = new UserModel();
    user=dao.findUser(login);
    int achat = dao.achat(login); ;
    int montant= dao.total(login);
   



%>
<div class="home">
    <div class="profil">
        <div class="info-profil d-flex">
            <div >
                <img src="images/user/449345806_796061856037680_4159070321549942722_n.jpg" alt="<%=user.getImg()%>" class="img-profil" />
            </div>
            <div>
                <h1><%=login%></h1>
                <h1><%=user.getMail()%></h1>
            </div>
        </div> 
     <div class="info-client d-flex">
        <div class="nb-achat it ">
            <div class="d-flex t">
              <h3>Achat </h3>
              <i class="fas fa-wallet" style="width: 30px; height:30px;"></i>
            </div>
            
            <div class="text-center ti">
                <h3><%=achat%></h3>
                
            </div>
        </div>
         <div class="montant achat it ">
             <div class="d-flex t">
                  <h3>Montant</h3> 
                <i class="fas fa-money-bill" style="width: 30px; height:30px;"></i>
             </div>
            <div class="text-center ti">
                <h3><%=montant%>$</h3>
            </div>
         </div>
    </div>      
    <div class="historique">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Date</th>
                    <th>Type</th>
                    <th>Quantite</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    int a= 3;
                 List<PanierModel> panierlist= dao.listPanier(login);
                 for(PanierModel panier :  panierlist){
                    
                %>
                <tr>
                    <td class="col-md-3"><%=panier.getDate_panier()%></td>
                    <td><%=panier.getType_item()%></td>
                    <td><%=panier.getNb_pers()%></td>
                </tr>
                <%}%>
            </tbody>
        </table>

    </div>        
    
    </div>  
</div>