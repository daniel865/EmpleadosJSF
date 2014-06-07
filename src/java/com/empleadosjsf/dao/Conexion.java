/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.empleadosjsf.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Daniel
 */
public class Conexion {
    
    String user;
    String pass;
    String url;

    public Conexion(String user, String pass, String url) {
        this.user = user;
        this.pass = pass;
        this.url = url;
    }
    
    public Connection conectar()throws Exception{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            throw new Exception("Error al conectar",e);
        }
    }
    
    public void cerrar(Connection connection)throws Exception{
        try {
            if ( connection!=null && !connection.isClosed() ){
                connection.close();
            }
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión");
        }
    }
    
}
