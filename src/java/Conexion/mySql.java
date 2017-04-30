/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import static java.lang.System.out;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JUAN
 */
public class mySql 
{
    private Connection Conn;
    private PreparedStatement consulta;
    private ResultSet rs;
    String base,contraseña, usuario;
    
    public mySql()
    {
        this.base="usuario";
        this.usuario="root";
        this.contraseña="";
    }

public void conectar() throws SQLException
{
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            this.Conn =DriverManager.getConnection("jdbc:mysql://localhost/"+this.base, this.usuario, this.contraseña);
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(mySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
public void desconectar() throws SQLException
{
    this.Conn.close();
}

public ResultSet mostrar_datos(String usuario) throws SQLException
{
    this.consulta= this.Conn.prepareStatement("SELECT * FROM persona WHERE NOMBRE='"+usuario+"'");
    this.rs=this.consulta.executeQuery();
    return rs;
}

public ResultSet mostrar_todos() throws SQLException
{
    this.conectar();
    this.consulta=this.Conn.prepareStatement("SELECT * FROM persona");
    this.rs= this.consulta.executeQuery();
    return rs;
}

public boolean Insert(String NOMBRE, String CORREO, String DIRECCION, String TELEFONO, String PAIS, String SEXO) throws SQLException
{
    this.conectar();
    try{
            this.consulta = this.Conn.prepareStatement("INSERT INTO persona (NOMBRE, CORREO, DIRECCION, TELEFONO, PAIS, SEXO)" 
                    + "VALUES('"+NOMBRE+"', '" +CORREO+"', '"+DIRECCION+"', '"
                    +TELEFONO+"', '"+PAIS+"', '"+SEXO+"')");
            
            boolean resultado = this.consulta.execute();
            return true;
            
        }catch(Exception ex)
        {
            out.println(ex.getMessage());
            return false;
        }
}
    
    
}
