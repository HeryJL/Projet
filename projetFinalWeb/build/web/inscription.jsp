<%-- 
    Document   : inscription
    Created on : 16 août 2024, 21:30:47
    Author     : Hery
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/inscr.css"/>
        <title>Inscription</title>
    </head>
    <body>
        <form action="InscriptionServlet" method="post">
            <h1>Inscription</h1>
            <div>
                <input type="text" name="login" placeholder="Nom d'utilisateur" required><br/>
                <input type="password" name="mdp"  id="mdp" placeholder="Mot de passe" required><br/>
                <input type="password" name="cmdp" id="cmdp" placeholder="confirmer le mot de passe" required><br/>
                <input type="email" name="mail" placeholder="Adresse mail" required><br/>
                <input type="submit" id='sub' name="S'inscrire" value="S'inscrire"  required>
                <h3>Deja encore inscri ?<a href="Lien?page=index"> Se connecter</a></h3>
            </div>
        </form>   
        
        
  
    </body>

</html>
