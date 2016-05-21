/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *///cedula, nombreCompleto, nombreUsuario, contrasenna, tipo
package modelo;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Usuario implements Serializable
{
    
    private String cedula;
    private String nombreCompleto;
    private String nombreUsuario;
    private String contrasenna;
    private String tipo;

    public Usuario(String cedula, String nombreCompleto, String nombreUsuario, String contrasenna, String tipo) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.contrasenna = contrasenna;
        this.tipo = tipo;
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the nombreCompleto
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * @param nombreCompleto the nombreCompleto to set
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the contrasenna
     */
    public String getContrasenna() {
        return contrasenna;
    }

    /**
     * @param contrasenna the contrasenna to set
     */
    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
