/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

/**
 *
 * @author Cristian
 */
public class Producto {
    private String nombre;
    private String tipo;
    private int unidadesDisp;
    private int nNuevoPedido;
    private int precioBase;

    public Producto(String nombre, String tipo, int unidadesDisp, int nNuevoPedido, int precioBase) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.unidadesDisp = unidadesDisp;
        this.nNuevoPedido = nNuevoPedido;
        this.precioBase = precioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getUnidadesDisp() {
        return unidadesDisp;
    }

    public void setUnidadesDisp(int unidadesDisp) {
        this.unidadesDisp = unidadesDisp;
    }

    public int getnNuevoPedido() {
        return nNuevoPedido;
    }

    public void setnNuevoPedido(int nNuevoPedido) {
        this.nNuevoPedido = nNuevoPedido;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }
    
    
}
