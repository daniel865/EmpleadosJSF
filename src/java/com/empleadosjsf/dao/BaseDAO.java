/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.empleadosjsf.dao;

/**
 *
 * @author Daniel
 */
public class BaseDAO {
    
    Conexion connectionManager;

    public BaseDAO(Conexion connectionManager) {
        this.connectionManager = connectionManager;
    }
    
    
    
}
