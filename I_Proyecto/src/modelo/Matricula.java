/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Casa
 */
public class Matricula 
{
    private String codigo;
    private String sigla;
    private String cedula;

    public Matricula(String codigo, String siglas, String cedula) {
        this.codigo = codigo;
        this.sigla = sigla;
        this.cedula = cedula;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the siglas
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param siglas the siglas to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
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
    
    
}