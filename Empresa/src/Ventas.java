/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernando Alberto
 */
public class Ventas {
    private String Cliente;
    private String Fecha;
    private String Producto;
    private int Cantidad;
    private float IVA;
    private float Total;

    public Ventas(String Cliente, String Fecha, String Producto, int Cantidad, float IVA, float Total) {
        this.Cliente = Cliente;
        this.Fecha = Fecha;
        this.Producto = Producto;
        this.Cantidad = Cantidad;
        this.IVA = IVA;
        this.Total = Total;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
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

    public float getIVA() {
        return IVA;
    }

    public void setIVA(float IVA) {
        this.IVA = IVA;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }
}
