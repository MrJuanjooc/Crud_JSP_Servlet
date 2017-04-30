<%-- 
    Document   : Mostrar
    Created on : 05-mar-2017, 21:18:27
    Author     : JUAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Usuarios</title>
    </head>
    <body>
        <h1>Mostrar Usuarios</h1>
        <form action="Mostrar" method = "POST" name = "form">
        <p>Ingrese el nombre del usuario: </p><input type="text" name ="Usuario" />
            <input type="submit" value ="Buscar " name ="Buscar"/>
        </form>
        <input type="button" value ="Mostrar Todos" onclick="location.href='Mostrar'"/>
        </body>
</html>
