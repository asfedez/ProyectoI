
package modelo;

import java.io.Serializable;


public class Estudiante implements Serializable
{
    private String carne;
    private String nombre;
    private String direccion;

    public Estudiante(String carne, String nombre, String direccion) {
        this.carne = carne;
        this.nombre = nombre;
        this.direccion = direccion;
    }
     
    /**
     * @return the cedula
     */
    public String getCarne() {
        return carne;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCarne(String carne) {
        this.carne = carne;
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
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
    
}
