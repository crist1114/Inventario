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

    @Override
    public int hashCode(){
        return this.nombre.hashCode();
    }
    ///UTILIZO EL HASHCODE PARA SABER POR QUE PROPIEDAD LO VOY A COMPARAR
    //EL EQUALS NO VA A PERMITIR QUE SE AGREGUEN DUPLICADOS AL SETHASH
    @Override
    public boolean equals(Object otro){
        if(otro.getClass() != this.getClass())
            return false;
        Producto o = (Producto)otro;
        if(o.nombre == this.nombre)
            return true;
        return o.getNombre() != null && o.getTipo().equals(this.getNombre());
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
