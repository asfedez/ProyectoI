/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import vista.FRM_MantenimientoMatricula;
//import vista.FRM_Matricula;

/**
 *
 * @author Usuario
 */
public class ConexionBD {

    Connection con = null;
    String arregloInformacionConsultadaCursos[] = new String[4];
    String arregloInformacionConsultadaEstudiantes[] = new String[3];
    String arregloInformacionConsultadaMatricula[] = new String[2];
    String arregloInformacionConsultadaMatriculaDetalle[] = new String[4];
    String arregloInformacionConsultadaUsuarios[] = new String[5];
    FRM_MantenimientoMatricula frm_MantenimientoMatricula;

    public ConexionBD() {
       realizarConexion();
    }
    
    public ConexionBD(FRM_MantenimientoMatricula frm_MantenimientoMatricula)
    {
        realizarConexion();
        this.frm_MantenimientoMatricula=frm_MantenimientoMatricula;
    }


    public void realizarConexion() {
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/matricula";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Conexión Realizada");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
     //////////////////////////BD_Cursos/////////////////////////

    public boolean registrarCurso(String arreglo[]) {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
            cmd = con.createStatement();
            ejecuto = cmd.execute("INSERT INTO `cursos`(`sigla`, `nombre`, `creditos`, `horario`) VALUES ('" + arreglo[0] + "','" + arreglo[1] + "','" + Integer.parseInt(arreglo[2]) + "','" + arreglo[3] + "')");

            return true;
            // rs.close();
        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }

    }

    public boolean consultarCurso(String siglas) {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto = false;
        try {
            cmd = con.createStatement();
            rs = cmd.executeQuery("SELECT * FROM cursos WHERE sigla='" + siglas + "'");
            while (rs.next()) {
                arregloInformacionConsultadaCursos[0] = rs.getString("sigla");
                arregloInformacionConsultadaCursos[1] = rs.getString("nombre");
                arregloInformacionConsultadaCursos[2] = "" + rs.getString("creditos");
                arregloInformacionConsultadaCursos[3] = rs.getString("horario");
                ejecuto = true;
            }
            rs.close();

        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());

        }
        return ejecuto;
    }

    public String[] devolverInformacionConsultadaCursos() {
        return arregloInformacionConsultadaCursos;
    }

    public boolean eliminarCurso(String siglas) {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
            cmd = con.createStatement();
            ejecuto = cmd.execute("DELETE FROM `cursos` WHERE sigla=" + siglas);
            return true;

        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
    }

    public int modificarCurso(String arreglo[]) {
        ResultSet rs = null;
        Statement cmd = null;
        int ejecuto = 99;
        try {
            cmd = con.createStatement();
            ejecuto = cmd.executeUpdate("UPDATE `cursos` SET `nombre`='" + arreglo[1] + "',`creditos`='" + arreglo[2] + "',`horario`='" + arreglo[3] + "' WHERE sigla=" + arreglo[0]);
        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());

        }
        return ejecuto;
    }

    ////////////////////////BD_Estudiantes//////////////////////////////////
    public boolean registrarEstudiante(String arreglo[]) {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {

            cmd = con.createStatement();
            ejecuto = cmd.execute("INSERT INTO `estudiantes`(`cedula`, `nombre`, `direccion`) VALUES ( '" + arreglo[0] + "','" + arreglo[1] + "','" + arreglo[2] + "')");

            return true;
            // rs.close();
        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }

    }

    public boolean consultarEstudiante(String cedula) {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto = false;
        try {
            cmd = con.createStatement();
            rs = cmd.executeQuery("SELECT * FROM `estudiantes` WHERE cedula='" + cedula + "'");
            while (rs.next()) {
                arregloInformacionConsultadaEstudiantes[0] = rs.getString("cedula");
                arregloInformacionConsultadaEstudiantes[1] = rs.getString("nombre");
                arregloInformacionConsultadaEstudiantes[2] = rs.getString("direccion");
                ejecuto = true;
            }
            rs.close();

        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());

        }
        return ejecuto;
    }

    public String[] devolverInformacionConsultadaEstudiantes() {
        return arregloInformacionConsultadaEstudiantes;
    }

    public boolean eliminarEstudiante(String cedula) {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
            cmd = con.createStatement();
            ejecuto = cmd.execute("DELETE FROM `estudiantes` WHERE cedula=" + cedula);
            return true;

        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
    }

    public int modificarEstudiante(String arreglo[]) {
        ResultSet rs = null;
        Statement cmd = null;
        int ejecuto = 99;
        try {
            cmd = con.createStatement();
            ejecuto = cmd.executeUpdate("UPDATE `estudiantes` SET `nombre`='" + arreglo[1] + "',`direccion`='" + arreglo[2] + "' WHERE cedula =" + arreglo[0]);
        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());

        }
        return ejecuto;
    }

    ///////////////////////////////BD_Matricula///////////////////////////////////
    public boolean registrarMatricula(String arreglo[]) {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {

            cmd = con.createStatement();
            ejecuto = cmd.execute("INSERT INTO `matricula`(`codigo`, `cedula`) VALUES ('" + arreglo[0] + "','" + arreglo[1] + "')");

            return true;
            // rs.close();
        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }

    }

    public boolean consultarMatricula(String codigo) {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto = false;
        try {
            cmd = con.createStatement();
            rs = cmd.executeQuery("SELECT * FROM `matricula` WHERE codigo=" + codigo);
            while (rs.next()) {
                arregloInformacionConsultadaMatricula[0] = rs.getString("codigo");
                arregloInformacionConsultadaMatricula[1] = rs.getString("cedula");
                ejecuto = true;
            }
            rs.close();

        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());

        }
        return ejecuto;
    }

    public String[] devolverInformacionConsultadaMatricula() {
        return arregloInformacionConsultadaMatricula;
    }

    public boolean eliminarMatricula(String codigo) {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
            cmd = con.createStatement();
            ejecuto = cmd.execute("DELETE FROM `matricula` WHERE codigo=" + codigo);
            return true;

        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
    }

    public int modificarMatricula(String arreglo[])//metodo no funciona
    {
        ResultSet rs = null;
        Statement cmd = null;
        int ejecuto = 99;
        try {
            cmd = con.createStatement();
            ejecuto = cmd.executeUpdate("UPDATE `estudiantes` SET `nombre`='" + arreglo[1] + "',`direccion`='" + arreglo[2] + "' WHERE cedula =" + arreglo[0]);
        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());

        }
        return ejecuto;
    }

    public ArrayList<String> consultarCodigoMatriculas() {
        ArrayList<String> lista = new ArrayList<String>();
        ResultSet rs = null;
        Statement cmd = null;
        try {
            cmd = con.createStatement();
            rs = cmd.executeQuery("SELECT * FROM `matricula`");
            while (rs.next()) {
                lista.add(rs.getString("codigo"));
            }
            rs.close();

        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());

        }
        return lista;
    }

    /////////////////////////////BD_MatriculaDetalle///////////////////////////
    public boolean registrarMatriculaDetalle(String arreglo[]) {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {

            cmd = con.createStatement();
            ejecuto = cmd.execute("INSERT INTO `detalle_matricula`(`codigo`, `cedula`, `sigla`) VALUES ( '" + arreglo[0] + "','" + arreglo[1] + "','" + arreglo[2] + "')");

            return true;
            // rs.close();
        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }

    }

    public String[] devolverInformacionConsultadaMatriculaDetalle() {
        return arregloInformacionConsultadaMatriculaDetalle;
    }

    public boolean eliminarMatriculaDetalle(String arreglo[]) {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
            cmd = con.createStatement();
            ejecuto = cmd.execute("DELETE FROM `detalle_matricula` WHERE codigo='"+ arreglo[0]+"'and sigla ='"+arreglo[1]+"'");
            return true;

        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
    }

    public int modificarMatriculaDetalle(String arreglo[])//metodo sin fincion
    {
        ResultSet rs = null;
        Statement cmd = null;
        int ejecuto = 99;
        try {
            cmd = con.createStatement();
            ejecuto = cmd.executeUpdate("UPDATE `estudiantes` SET `nombre`='" + arreglo[1] + "',`direccion`='" + arreglo[2] + "' WHERE cedula =" + arreglo[0]);
        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());

        }
        return ejecuto;
    }

    public boolean consultarMatriculaDetalle(String codigo) {

        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto = false;
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `matricula_detalle` WHERE codigo="+codigo);
                
                while (rs.next()) 
                {
                    arregloInformacionConsultadaMatriculaDetalle[0] = rs.getString("codigo");
                    arregloInformacionConsultadaMatriculaDetalle[1] = rs.getString("cedula");
                    arregloInformacionConsultadaMatriculaDetalle[2] = consultarNombreEstudiante(arregloInformacionConsultadaMatriculaDetalle);
                    arregloInformacionConsultadaMatriculaDetalle[3] = rs.getString("siglas");
                    frm_MantenimientoMatricula.agregarInformacionTabla(arregloInformacionConsultadaMatriculaDetalle);
                    ejecuto= true;
                }
                rs.close();

        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());

        }
        return ejecuto;
    }
    
     public String consultarNombreEstudiante(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        
        String nombre="";
        boolean ejecuto = false;
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT nombre FROM `estudiantes` WHERE cedula="+arreglo[1]);
                while (rs.next()) 
                {
                    nombre = rs.getString("nombre");
                    ejecuto= true;
                }
                rs.close();
                
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
          
        }
        return nombre;
    }
    
    public String[] devolverInformacionConsultada()
    {
        return arregloInformacionConsultadaMatriculaDetalle;
    }

    public String devolverNombre(String cedula)
    {
      ResultSet rs = null;
        Statement cmd = null;
        String nombreObtenido = "";
        try {
            cmd = con.createStatement();
            rs = cmd.executeQuery("SELECT * FROM `estudiantes` WHERE cedula='" + cedula + "'");
            while (rs.next()) {
               nombreObtenido = rs.getString("nombre");             

            }
            rs.close();

        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());

        }
        return nombreObtenido;
    }


    ////////////////////////BD_Usuarios///////////////////////////////
    public boolean registrarUsuarios(String arreglo[]) {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
            cmd = con.createStatement();
            ejecuto = cmd.execute("INSERT INTO `usuarios`(`cedula`, `nombreCompleto`, `nombreUsuario`, `contrasenna`, `tipo`) VALUES ('" + arreglo[0] + "','" + arreglo[1] + "','" + arreglo[2] + "','" + arreglo[3] + "','" + arreglo[4] + "')");

            return true;
            // rs.close();
        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }

    }

    public boolean consultarUsuario(String cedula) {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto = false;
        try {
            cmd = con.createStatement();
            rs = cmd.executeQuery("SELECT * FROM `usuarios` WHERE cedula=" + cedula);
            while (rs.next()) {
                arregloInformacionConsultadaUsuarios[0] = rs.getString("cedula");
                arregloInformacionConsultadaUsuarios[1] = rs.getString("nombreCompleto");
                arregloInformacionConsultadaUsuarios[2] = rs.getString("nombreUsuario");
                arregloInformacionConsultadaUsuarios[3] = rs.getString("contrasenna");
                arregloInformacionConsultadaUsuarios[4] = rs.getString("tipo");
                ejecuto = true;
            }
            rs.close();

        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());

        }
        return ejecuto;
    }

    public String[] devolverInformacionConsultadaUsuarios() {
        return arregloInformacionConsultadaUsuarios;
    }

    public boolean eliminarUsuario(String cedula) {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
            cmd = con.createStatement();
            ejecuto = cmd.execute("DELETE FROM `usuarios` WHERE cedula=" + cedula);
            return true;

        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
    }

    public int modificarUsuario(String arreglo[]) {
        ResultSet rs = null;
        Statement cmd = null;
        int ejecuto = 99;
        try {
            cmd = con.createStatement();
            ejecuto = cmd.executeUpdate("UPDATE `usuarios` SET `nombreCompleto`='" + arreglo[1] + "',`nombreUsuario`='" + arreglo[2] + "',`contrasenna`='" + arreglo[3] + "',`tipo`='" + arreglo[4] + "' WHERE cedula =" + arreglo[0]);
        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());

        }
        return ejecuto;
    }
    
    public boolean verificarUsuarios()
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto = true;
        try {
            cmd = con.createStatement();
            rs = cmd.executeQuery("SELECT * FROM `usuarios`");
            while (rs.next()) {
              
                ejecuto = false;
            }
            rs.close();

        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());

        }
        return ejecuto;
    }
    
    public boolean iniciarSesion(String informacion[])
    {
         ResultSet rs = null;
        Statement cmd = null;
        boolean iniciarSesion = false;
        try {
            cmd = con.createStatement();
            rs = cmd.executeQuery("SELECT * FROM `usuarios` WHERE nombreUsuario='"+informacion[0]+"' and contrasenna='"+informacion[1]+"'");
            while (rs.next()) {
                
                iniciarSesion = true;
            }
            rs.close();

        } catch (Exception e) {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());

        }
        return iniciarSesion;
    }
}
