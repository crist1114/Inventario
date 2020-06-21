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
public class Producto implements Comparable<Producto>{
    private String nombre;
    private String tipo;
    private int unidadesDisp;
    private int nNuevoPedido;
    private int precioBase;
    private int unidadesVendidas;

    public Producto(String nombre, String tipo, int unidadesDisp, int nNuevoPedido, int precioBase) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.unidadesDisp = unidadesDisp;
        this.nNuevoPedido = nNuevoPedido;
        this.precioBase = precioBase;
        this.unidadesVendidas = 0;
    }
    
    public int getPrecioFinal(){
        if(this.getTipo().equals("Papeleria"))
            return this.precioBase+(this.precioBase*16)/100;
        else if(this.getTipo().equals("Supermercado"))
            return this.precioBase+(this.precioBase*4)/100;
        else
            return this.precioBase+(this.precioBase*12)/100;
    }
    
    public boolean venderUnidades(int cant){
        if(this.unidadesDisp-cant >= 0){
            this.unidadesDisp-=cant;
            this.unidadesVendidas+=cant;
            return true;
        }
        return false;
    }
    
    public boolean pedir(){
        return this.unidadesDisp<=this.nNuevoPedido;
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
        return o.getNombre() != null && o.getNombre().equals(this.getNombre());
    }

    public int getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public void setUnidadesVendidas(int unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas;
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

    @Override
    public int compareTo(Producto o) {
        return nombre.compareTo(o.nombre);
    }
    
    
}
