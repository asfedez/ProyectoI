/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
import vista.FRM_MantenimientoUsuarios;

public class ArchivosXMLUsuarios {
    
    DocumentBuilderFactory factory;
    DocumentBuilder builder;
    DOMImplementation implementation;
    Document document;
    ArrayList titulos;
    ArrayList valores;
    Element raiz;
    String arregloInformacion[];
    FRM_MantenimientoUsuarios frm_MantenimientoUsuarios;

    public ArchivosXMLUsuarios(FRM_MantenimientoUsuarios frm_MantenimientoUsuarios) {
        this.frm_MantenimientoUsuarios = frm_MantenimientoUsuarios;
        crearArchivo("Cursos");
        arregloInformacion=new String[3];
        titulos = new ArrayList();
        valores = new ArrayList();
    }
    public void agregarUsuarioAlArray(String informacion[])
    {   
        titulos.add("cedula");
        valores.add(informacion[0]);
 
        titulos.add("nombreCompleto");
        valores.add(informacion[1]);
 
        titulos.add("nombreUsuario");
        valores.add(informacion[2]);
        
        titulos.add("contrasenna");
        valores.add(informacion[3]);
        
        titulos.add("tipo");
        valores.add(informacion[4]);
    }
    
    public void crearArchivo(String nombreArchivo) 
    {
        try{
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, nombreArchivo, null);
            document.setXmlVersion("1.0");
            raiz = document.getDocumentElement();
            
            
            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File(nombreArchivo+".xml")); 
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            System.out.println("Archivo XML creado con el nombre: "+nombreArchivo);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ArchivosXMLUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (TransformerException ex) {
            Logger.getLogger(ArchivosXMLUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void cargarInformacionAlXML()
    {
        raiz = document.getDocumentElement();
        Text texto;
            
            for(int contador=0; contador<titulos.size();contador++)
            {
                Element item = document.createElement("ITEM"); 
                Element titulo = document.createElement("TITULO"); 
                texto = document.createTextNode(titulos.get(contador).toString());
                titulo.appendChild(texto);      
                Element valor = document.createElement("VALOR"); 
                texto = document.createTextNode(valores.get(contador).toString());                
                valor.appendChild(texto);
                item.appendChild(titulo);
                item.appendChild(valor);
                raiz.appendChild(item);
            }
           
            
    }
    
        public boolean consultarInformacionDelXml(String cedula)
        { 
             Element raiz = document.getDocumentElement();
             NodeList listaDeItems = raiz.getElementsByTagName("ITEM");
             Node tag=null,datoContenido=null;
             
             boolean itemEncontrado=false,tituloCedula=false;
             int contador=0;
             
             for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
             {   
                 Node item = listaDeItems.item(contadorItems);
                 NodeList datosItem = item.getChildNodes();
                 for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
                 {
                     tag = datosItem.item(contadorTags); 
                     datoContenido = tag.getFirstChild();
                     if(tituloCedula && datoContenido.getNodeValue().equals(cedula))
                     {
                         itemEncontrado=true;
                     }
                     if(tag.getNodeName().equals("TITULO") && datoContenido.getNodeValue().equals("cedula") )
                     {
                         tituloCedula=true;
                     }
                 }
                 if(itemEncontrado && contador<3)
                 {
                    arregloInformacion[contador]=datoContenido.getNodeValue();
                    contador++;
                 }
             }
             return itemEncontrado;
        }
        public void modificarInformacionDelXml(String[] informacion)
        { 
             Element raiz = document.getDocumentElement();
             NodeList listaDeItems = raiz.getElementsByTagName("ITEM");
             Node tag=null,datoContenido=null;
             String arregloInformacion[]=new String[3];
             boolean itemEncontrado=false,tituloCedula=false;
             int contador=0;
             
             for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
             {   
                 Node item = listaDeItems.item(contadorItems);
                 NodeList datosItem = item.getChildNodes();
                 for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
                 {
                     tag = datosItem.item(contadorTags); 
                     datoContenido = tag.getFirstChild();
                     if(tituloCedula && datoContenido.getNodeValue().toString().equals(informacion[0]))
                     {
                         itemEncontrado=true;
                     }
                     if(tag.getNodeName().toString().equals("TITULO") && datoContenido.getNodeValue().toString().equals("cedula") )
                     {
                         tituloCedula=true;
                     }
                 }
                 if(itemEncontrado && contador<3)
                 {
                    datoContenido.setNodeValue(informacion[contador]);
                    contador++;
                 }
             }
             
        }
        public void eliminarInformacionDelXml(String cedula)
        { 
             Element raiz = document.getDocumentElement();
             NodeList listaDeItems = raiz.getElementsByTagName("ITEM");
             Node tag=null,datoContenido=null;
             String arregloInformacion[]=new String[3];
             boolean itemEncontrado=false,tituloCedula=false;
             
             for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
             {   
                 Node item = listaDeItems.item(contadorItems);
                 NodeList datosItem = item.getChildNodes();
                 for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
                 {
                     tag = datosItem.item(contadorTags); 
                     datoContenido = tag.getFirstChild();
                     if(tituloCedula && datoContenido.getNodeValue().toString().equals(cedula))
                     {
                         itemEncontrado=true;
                     }
                     if(tag.getNodeName().toString().equals("TITULO") && datoContenido.getNodeValue().toString().equals("cedula") )
                     {
                         tituloCedula=true;
                     }
                 }
                 if(itemEncontrado)
                 {
                    raiz.removeChild(item);
                    itemEncontrado=false;
                 }
             }
             
        }
        public String[] getArregloInformacion()
        {
            return arregloInformacion;
        }
    
    
}
