/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernando Alberto
 */
public class Inventario {
    private String Proveedor;
    private String Producto;
    private int Cantidad;
    private float PrecioUnitario;
    private String Fecha;

    public Inventario(String Proveedor, String Producto, int Cantidad, float PrecioUnitario, String Fecha) {
        this.Proveedor = Proveedor;
        this.Producto = Producto;
        this.Cantidad = Cantidad;
        this.PrecioUnitario = PrecioUnitario;
        this.Fecha = Fecha;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public float getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(float PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
}
