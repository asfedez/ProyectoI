/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Curso implements Serializable
{
    
    private String sigla;
    private String nombre;
    private int credito;
    private String horario;

    public Curso(String sigla, String nombre, int credito, String horario) {
        this.sigla = sigla;
        this.nombre = nombre;
        this.credito = credito;
        this.horario = horario;
    }

    /**
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the credito
     */
    public int getCredito() {
        return credito;
    }

    /**
     * @param credito the credito to set
     */
    public void setCredito(int credito) {
        this.credito = credito;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }
    
}
