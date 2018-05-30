
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernando Alberto
 */
public class Principal {
    
    static ArrayList<Inventario> ArrayInventario = new ArrayList<Inventario>();
    static ArrayList<Ventas> ArrayVentas = new ArrayList<Ventas>();
    public static String Archivo_Inventario= "Inventario.csv";
    public static String Archivo_Ventas= "Ventas.dat";
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo CSV", "csv");
    static BufferedReader br= null;
    static String line= "";
    static String cvsSplitBy= ",";
    static String[] country;
    
    public static void main(String[] args) {
        File Secuencial = new File(Archivo_Ventas);
        File CSV = new File(Archivo_Inventario);
        if(!CSV.exists() || !Secuencial.exists()){
        try{
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(Archivo_Inventario));
        bw = new BufferedWriter(new FileWriter(Archivo_Ventas));
        }catch(Exception e){}
        }
        Menu conector= new Menu();
        conector.setVisible(true);
        conector.setTitle("Menú");
    }
    public static void LeerTodo() throws IOException{
     LeerCSV();
     LeerSecuencial();
    }
    
    public static void LeerCSV(){
        //Leer CSV
        ArrayInventario.clear();
        int i=0;
        try {
            br = new BufferedReader(new FileReader(Archivo_Inventario));
            System.out.println("-CSV-");
            while ((line = br.readLine()) != null) {
                country = line.split(cvsSplitBy);
                ArrayInventario.add(new Inventario(country[0], country[1], Integer.parseInt(country[2]), Float.parseFloat(country[3]), country[4]));
                System.out.println("Proveedor= " + country[0] + "\nProducto= " + country[1] + "\nCantidad= " + country[2] + "\nPrecio Unitario= " + country[3]);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static void Ingresar_Inventario(String Proveedor, String Nombre, int Cantidad, float PrecioUnitario, String Fecha){
        try{
            RandomAccessFile xFileAleatorio;
            xFileAleatorio=new RandomAccessFile(Archivo_Inventario,"rw"); 
            xFileAleatorio.seek(xFileAleatorio.length());
            xFileAleatorio.writeBytes(Proveedor + ",");
            xFileAleatorio.writeBytes(Nombre + ",");
            xFileAleatorio.writeBytes(Cantidad + ",");
            xFileAleatorio.writeBytes(PrecioUnitario + ",");
            xFileAleatorio.writeBytes(Fecha + "\n");
            xFileAleatorio.close();
        }catch(FileNotFoundException e){e.printStackTrace();}catch (IOException e){e.printStackTrace();}
    }
    
    public static void Venta(int Indice, int CantidadVendida){
        ArrayInventario.get(Indice).setCantidad(ArrayInventario.get(Indice).getCantidad()-CantidadVendida);
        try{
            File archivo = new File(Archivo_Inventario);
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));;
            bw.write("");
            bw.close();
        }catch(Exception e){}
        for(int x=0; x<Principal.ArrayInventario.size(); x++){
        try{
            RandomAccessFile xFileAleatorio;
            xFileAleatorio=new RandomAccessFile(Archivo_Inventario,"rw"); 
            xFileAleatorio.seek(xFileAleatorio.length());
            xFileAleatorio.writeBytes(ArrayInventario.get(x).getProveedor() + ",");
            xFileAleatorio.writeBytes(ArrayInventario.get(x).getProducto()+ ",");
            xFileAleatorio.writeBytes(ArrayInventario.get(x).getCantidad()+ ",");
            xFileAleatorio.writeBytes(ArrayInventario.get(x).getPrecioUnitario()+ ",");
            xFileAleatorio.writeBytes(ArrayInventario.get(x).getFecha()+ "\n");
            xFileAleatorio.close();
        }catch(FileNotFoundException e){e.printStackTrace();}catch (IOException e){e.printStackTrace();}
        }
    }
    
    public static void Editar_Producto(int Indice, int CantidadNueva, float PrecioUnitarioNuevo){
        ArrayInventario.get(Indice).setCantidad(CantidadNueva);
        ArrayInventario.get(Indice).setPrecioUnitario(PrecioUnitarioNuevo);
        try{
            File archivo = new File(Archivo_Inventario);
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));;
            bw.write("");
            bw.close();
        }catch(Exception e){}
        for(int x=0; x<Principal.ArrayInventario.size(); x++){
        try{
            RandomAccessFile xFileAleatorio;
            xFileAleatorio=new RandomAccessFile(Archivo_Inventario,"rw"); 
            xFileAleatorio.seek(xFileAleatorio.length());
            xFileAleatorio.writeBytes(ArrayInventario.get(x).getProveedor() + ",");
            xFileAleatorio.writeBytes(ArrayInventario.get(x).getProducto()+ ",");
            xFileAleatorio.writeBytes(ArrayInventario.get(x).getCantidad()+ ",");
            xFileAleatorio.writeBytes(ArrayInventario.get(x).getPrecioUnitario()+ ",");
            xFileAleatorio.writeBytes(ArrayInventario.get(x).getFecha()+ "\n");
            xFileAleatorio.close();
        }catch(FileNotFoundException e){e.printStackTrace();}catch (IOException e){e.printStackTrace();}
        }
    }
    
    public static void LeerSecuencial() throws IOException{
        //Leer Secuencial     
        ArrayVentas.clear();
        DataInputStream Archi = null;
        try{
        Archi = new DataInputStream( new FileInputStream(Archivo_Ventas) );
        System.out.println("-Secuencial-");
        while (true){
         String Cliente= Archi.readUTF();
         String Fecha= Archi.readUTF();
         String Producto= Archi.readUTF();
         int Cantidad= Archi.readInt();
         float IVA= Archi.readFloat();
         float Total= Archi.readFloat();
         ArrayVentas.add(new Ventas(Cliente, Fecha, Producto, Cantidad, IVA, Total));
            System.out.println("Cliente=" + Cliente + "\nFecha= " + Fecha + "\nProducto= " + Producto + "\nCantidad= " + Cantidad + "\nIVA= " + IVA + "\nTotal= " + Total);
    }
    }catch (Exception e){
    }
    }
    
    public static void Realizar_Venta(String Cliente, String Fecha, String Producto, int Cantidad, float IVA, float Total){
        DataOutputStream Archi = null;
        try{
        Archi = new DataOutputStream( new FileOutputStream(Archivo_Ventas,true) );
         Archi.writeUTF(Cliente);
         Archi.writeUTF(Fecha);
         Archi.writeUTF(Producto);
         Archi.writeInt(Cantidad);
         Archi.writeFloat(IVA);
         Archi.writeFloat(Total);
         Archi.close();
        }catch(FileNotFoundException fnfe) {}
    catch (IOException ioe) {}
    }
}
