<%-- 
    Document   : Nuevo
    Created on : 08-mar-2017, 21:19:05
    Author     : JUAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Usuario</title>
    </head>
    <body>
        <h1>Registrar Usuario</h1>
        
        <hr />
        
        <form action="Insert" method="POST" name="form">
            <p>Nombre: <input type ="text" name ="NOMBRE">
            <p>Correo Electronico: <input type ="text" name ="CORREO" /> </p>
            <p>Direccion: </p>
            <textarea name="DIRECCION" cols="50" rows="5"> </textarea>
            <p>Telefono: <input type ="text" name ="TELEFONO" maxilength="10"/> </p>
           
           
            
            <p>Pais: <select name="PAIS">
                    <option value ="Peru">Peru</option>
                    <option value ="Italia">Italia</option>
                    <option value ="Colombia">Colombia</option>
                    <option value ="Brasil">Brasil</option>
                    <option value ="Argentina">Argentina</option>
                    
                    </select></p>
            <p>Sexo: Masculino <input type="radio" name="SEXO"value="Masculino" />
                Femenino <input type="radio"name="SEXO"value="Femenino"/></p>
            
            <hr />
            <div align="center">
                <input type="submit" value ="Enviar " title="Enviar"/>
                <input type="reset" value ="Limpiar" name="Limpiar"/>
                <input type="button" value ="Volver" name="Volver" onclick="location.href='Index.jsp'"/>
           </div>
        </form>         
    </body>
</html>
