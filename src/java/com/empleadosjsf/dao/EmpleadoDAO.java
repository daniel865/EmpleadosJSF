/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.empleadosjsf.dao;

import com.empleadosjsf.beans.EmpleadoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class EmpleadoDAO extends BaseDAO{

    public EmpleadoDAO(Conexion connectionManager) {
        super(connectionManager);
    }

    public void crearEmpleado(EmpleadoBean empleadoBean)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("INSERT INTO EMPLEADOS(identificacion_emp, nombres_emp, apellido1_emp, apellido2_emp, direccion_emp, telefono_emp, cargo_emp) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, empleadoBean.getNro_identificacion());
            ps.setString(2, empleadoBean.getNombres());
            ps.setString(3, empleadoBean.getApellido1());
            ps.setString(4, empleadoBean.getApellido2());
            ps.setString(5, empleadoBean.getDireccion());
            ps.setString(6, empleadoBean.getTelefono());
            ps.setString(7, empleadoBean.getCargo());
            ps.execute();
        } catch (Exception e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new Exception("Error al crear empleado",e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
    }
    
    public EmpleadoBean buscarEmpleado(String id)throws Exception{
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {
            connection = connectionManager.conectar();
            ps = connection.prepareStatement("");
            rs = ps.executeQuery();
            while (rs.next()) {                
                return new EmpleadoBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
        } catch (Exception e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            try {
                if ( ps!=null && !ps.isClosed() ){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionManager.cerrar(connection);
        }
        return null;
    }
    
    
    public void modificarEmpleado(EmpleadoBean empleadoBean)throws Exception{
        
    }
    
    public void eliminarEmpleado(String id)throws Exception{
        
    }
    
    
    
}
