<?php
    include ("connectBDD.php");
    $id=$_POST["id"];
    $requete=$bdd->query("DELETE FROM personnel WHERE id_personnel='".$id."'");
    header('location:page.php?id=admin');

?>