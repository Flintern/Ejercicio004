package actividad004;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;

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

    public Productos(JTextField jtfNElem) {
        int i;
        nombreProducto = new String[Integer.parseInt(jtfNElem.getText())];
        codigoProducto = new int[Integer.parseInt(jtfNElem.getText())];
        precioProducto = new float[Integer.parseInt(jtfNElem.getText())];
        cantidad = new int[Integer.parseInt(jtfNElem.getText())];

        //Inicializamos los vectores vacíos:
        for (i = 0; i < cantidad.length; i++) {
            codigoProducto[i] = 0;
            nombreProducto[i] = "";
            precioProducto[i] = 0;
            cantidad[i] = 0;
        }
        JOptionPane.showMessageDialog(null,
                "Vectores Inicializados!");

    }

//Métodos modificadores para cada vector.
    public void setCodigoProducto(int p, int dato) {
        codigoProducto[p] = dato;
    }

    public void setNombreProducto(int p, String dato) {
        nombreProducto[p] = dato;
    }

    public void setPrecioProducto(int p, float dato) {
        precioProducto[p] = dato;
    }

    public void setCantidad(int p, int dato) {
        cantidad[p] = dato;
    }

//Métodos selectores para cada vector. 
    public int getCodigoProducto(int p) {
        return codigoProducto[p];
    }

    public String getNombreProducto(int p) {
        return nombreProducto[p];
    }

    public float getPrecioProducto(int p) {
        return precioProducto[p];
    }

    public int getCantidad(int p) {
        return cantidad[p];
    }

    public int getTam() {
        return cantidad.length;
    }

    //Método que devuelve el mayor precio. 
    public float mayorPrecio() {
        float mayor = getPrecioProducto(0);

        for (int i = 0; i <= cantidad.length - 1; i++) {
            if (getPrecioProducto(i) > mayor) {
                mayor = getPrecioProducto(i);

            }

        }

        return mayor;

    }

    public String generarInforme() {
        String informe = "";

        for (int i = 0; i < cantidad.length; i++) {

            if (precioProducto[i] > 2500 && cantidad[i] < 5) {

                informe += "Nombre: " + nombreProducto[i] + "\n";
            }
        }

        return informe;
    }

    public int getBuscarCodigo(int cod) {
        int i;
        for (i = 0; i < cantidad.length; i++) {
            if (codigoProducto[i] == cod) {
                return i;
            }
        }
        return -1;
    }

    public float[] totalXProducto() {
        float[] resultado = new float[cantidad.length];

        // Multiplicar los elementos correspondientes de los vectores
        for (int i = 0; i < cantidad.length; i++) {
            resultado[i] = precioProducto[i] * cantidad[i];
        }
        return resultado;
    }

    public float total() {
        float sumaTotal = 0;

        for (int i = 0; i < cantidad.length; i++) {
            sumaTotal += totalXProducto()[i];
        }
        return sumaTotal;
    }

    public boolean setAddInfo(JTextField jtCodigo, JTextField jtNombre, JTextField jtPrecio, JTextField jtCantidad, int indice) {
        try {
            if (getBuscarCodigo(Integer.parseInt(jtCodigo.getText())) != -1) {
                JOptionPane.showMessageDialog(null,
                        "El codigo del producto ya se encuentra "
                        + "registrado!  Intente nuevamente.");
                jtCodigo.setText("");
                jtNombre.requestFocus();
                return false;
            } else {
                codigoProducto[indice] = Integer.parseInt(jtCodigo.getText());
                nombreProducto[indice] = jtNombre.getText();
                precioProducto[indice] = Float.parseFloat(jtPrecio.getText());
                cantidad[indice] = Integer.parseInt(jtCantidad.getText());

                jtCodigo.setText("");
                jtNombre.setText("");
                jtPrecio.setText("");
                jtCantidad.setText("");

                jtCodigo.requestFocus();
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error: " + e);
            return false;
        }
    }

    public void setRegistrarFilaJTable(DefaultTableModel miModelo, int Fila, int indiceArray) {

        miModelo.setValueAt(codigoProducto[indiceArray], Fila, 0);
        miModelo.setValueAt(nombreProducto[indiceArray], Fila, 1);
        miModelo.setValueAt(precioProducto[indiceArray], Fila, 2);
        miModelo.setValueAt(cantidad[indiceArray], Fila, 3);
    }

    public void setLlenarJTable(JTable tabla) {
        int indice = 0; //Este índice recorre los elementos del ArrayList
        int i = 0;  //Este índice para ubicar posición de fila en el JTable
        DefaultTableModel miModelo = new DefaultTableModel();
        miModelo.addColumn("Codigo");
        miModelo.addColumn("Producto");
        miModelo.addColumn("Precio");
        miModelo.addColumn("Cantidad");
        while (indice < cantidad.length) {
            miModelo.addRow(new Object[]{"", "", "", ""});
            setRegistrarFilaJTable(miModelo, i, indice);
            i++;
            indice++;
        }
        tabla.setModel(miModelo);
    }

    public void getMostrarInfo(int pos) {
        String info = "La información del producto es: \n";
        info += "Codigo del producto: " + codigoProducto[pos] + "\n";
        info += "Nombre del producto: " + nombreProducto[pos] + "\n";
        info += "Precio del producto: " + precioProducto[pos] + "\n";
        info += "Cantidad de producto: " + cantidad[pos] + "\n";
        JOptionPane.showMessageDialog(null, info);
    }

}
