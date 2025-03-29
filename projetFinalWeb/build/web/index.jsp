<%-- 
    Document   : index
    Created on : 15 août 2024, 20:20:24
    Author     : Hery
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/index.css"/>
        <title>MANDEHA</title>
    </head>
    <body>
        <form action="AutentServlet" method="post">
            <h1>Authentification</h1>
            <div>
                <input type="text" name="login" placeholder="Nom d'utilisateur"><br/>
                <input type="password" name="mdp" placeholder="Mot de passe"><br/>
                <input type="submit" name="se connecter" value="Se connecter">
                <h3>Pas encore inscri ?<a href="Lien?page=inscription"> S'inscrire</a></h3>
            </div>
        </form>
    </body>
</html>
