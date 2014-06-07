/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.empleadosjsf.beans;

import com.empleadosjsf.dao.Conexion;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import com.empleadosjsf.dao.EmpleadoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
@Named(value = "empleadoBean")
@Dependent
public class EmpleadoBean {

    private String nro_identificacion;
    private String nombres;
    private String apellido1;
    private String apellido2;
    private String direccion;
    private String telefono;
    private String cargo;
    
    public EmpleadoBean() { }

    public EmpleadoBean(String nro_identificacion, String nombres, String apellido1, String apellido2, String direccion, String telefono, String cargo) {
        this.nro_identificacion = nro_identificacion;
        this.nombres = nombres;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cargo = cargo;
    }
    
    public String getNro_identificacion() {
        return nro_identificacion;
    }

    public void setNro_identificacion(String nro_identificacion) {
        this.nro_identificacion = nro_identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public void crearEmpleado()throws Exception{
        EmpleadoDAO empleadoDAO = new EmpleadoDAO(new Conexion("dba_empleados", "polijic", "dbempleados"));
        try {
            empleadoDAO.crearEmpleado(this);
        } catch (Exception e) {
            Logger.getLogger(EmpleadoBean.class.getName()).log(Level.SEVERE, null, e);
        }        
    }
    
    public EmpleadoBean buscarEmpleado()throws Exception{
        EmpleadoDAO empleadoDAO = new EmpleadoDAO(new Conexion("dba_empleados", "polijic", "dbempleados"));
        EmpleadoBean empleadoBean;
        try {
            empleadoBean = empleadoDAO.buscarEmpleado(nro_identificacion);
            return empleadoBean;
        } catch (Exception e) {
             Logger.getLogger(EmpleadoBean.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public void modificarEmpleado()throws Exception{
        EmpleadoDAO empleadoDAO = new EmpleadoDAO(new Conexion("dba_empleados", "polijic", "dbempleados"));
        try {
            empleadoDAO.modificarEmpleado(this);
        } catch (Exception e) {
             Logger.getLogger(EmpleadoBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void eliminarEmpleado()throws Exception{
        EmpleadoDAO empleadoDAO = new EmpleadoDAO(new Conexion("dba_empleados", "polijic", "dbempleados"));
        try {
            empleadoDAO.eliminarEmpleado(nro_identificacion);
        } catch (Exception e) {
            Logger.getLogger(EmpleadoBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    
    
    
    
    
}
