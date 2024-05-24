/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
/**
 *
 * @author jesus
 */
public class Productos {
//Se declaran los cuatro vectores para registrar la información de los productos. 
    
    private int codigoProducto[];
    private String nombreProducto[];
    private float precioProducto[];
    private int cantidad[];
   

    public Productos( JTextField jtfNElem){ 
        int i;
        nombreProducto = new String[Integer.parseInt(jtfNElem.getText())];
        codigoProducto = new int[Integer.parseInt(jtfNElem.getText())];
        precioProducto = new float[Integer.parseInt(jtfNElem.getText())];
        cantidad       = new int[Integer.parseInt(jtfNElem.getText())];
        
        //Inicializamos los vectores vacíos:
        for (i = 0; i < cantidad.length; i++) {
            codigoProducto[i] = 0;
            nombreProducto[i] = "";
            precioProducto[i] = 0;
            cantidad[i]       = 0;
        }
        JOptionPane.showMessageDialog(null, 
            "Vectores Inicializados!");
        
    }
  
//Métodos modificadores para cada vector.
    
    public void setCodigoProducto(int p, int dato){
        codigoProducto[p] = dato;
    }
    
    public void setNombreProducto(int p, String dato){
        nombreProducto[p] = dato;
    }
    
    public void setPrecioProducto(int p, float dato){
        precioProducto[p] = dato;
    }
    
    public void setCantidad(int p, int dato){
        cantidad[p] = dato;
    }

//Métodos selectores para cada vector. 

    public int getCodigoProducto(int p){
        return codigoProducto[p];
    }
    
    public String getNombreProducto(int p){
        return nombreProducto[p];
    }
    
    public float getPrecioProducto(int p){
        return precioProducto[p];
    }
    
    public int getCantidad(int p){
        return cantidad[p];
    }
    
    //Método que devuelve el mayor precio. 
    public float mayorPrecio(){
        float mayor = getPrecioProducto(0); 
        
        for (int i=0; i<=cantidad.length-1; i++){
            if (getPrecioProducto(i) > mayor){
        mayor = getPrecioProducto(i);

            }

        }

        return mayor;

    }
}
