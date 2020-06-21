/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import java.awt.List;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Cristian
 */
public class Inventario {

    private TreeSet<Producto> productos;
    private Hashtable<String,Producto> productosAgotados;
    private double dineroEnCaja;

    public Inventario() {
        this.productos = new TreeSet();
        productosAgotados = new Hashtable();
        dineroEnCaja = 0;
    }
    
    public boolean venderProducto(int cantidad, String nombre){
        Producto p = existe(nombre);
        boolean vendio = false;
        if(p!=null){
            vendio = p.venderUnidades(cantidad);
            if(vendio)
                dineroEnCaja += (cantidad*p.getPrecioFinal());
        }
        hacerPedido(p);//despues de vender verifico si se agoto para agregarlo a la lista
        return vendio;
    }
    
    private void hacerPedido(Producto p){
        if(p.pedir()){
            if(this.productosAgotados.get(p.getNombre()) != null);
                productosAgotados.put(p.getNombre(), p);
        }
    }
    
    public LinkedList<Producto> getMasVendidos(){
        LinkedList<Producto> o = this.ordenar();
        LinkedList<Producto> masVendidos = new LinkedList();
        int mas = o.getFirst().getUnidadesVendidas();
        for (Producto p : o) {
            if(p.getUnidadesVendidas()==mas)
                masVendidos.add(p);
        }
        return masVendidos;
    }
    
    public LinkedList<Producto> getMenosVendidos(){
        LinkedList<Producto> o = this.ordenar();
        LinkedList<Producto> menosVendidos = new LinkedList();
        int mas = o.getLast().getUnidadesVendidas();
        for (Producto p : o) {
            if(p.getUnidadesVendidas()==mas)
                menosVendidos.add(p);
        }
        return menosVendidos;
    }
    
    public LinkedList<Producto> ordenar(){
        LinkedList<Producto> ordenado = new LinkedList();
        for (Producto p : productos) {
            ordenado.add(p);
        }
        Collections.sort(ordenado, new ComparadorCantidadVendida());
        return ordenado;
    }
    
    public boolean recargarProducto(String nombre, int cant){
        Producto p = productosAgotados.get(nombre);
        if(this.dineroEnCaja - (cant*p.getPrecioFinal()) > 0){
            p.setUnidadesDisp(p.getUnidadesDisp()+cant);
            this.dineroEnCaja -= (cant*p.getPrecioFinal());
            this.productosAgotados.remove(nombre);
            return true;
        }
        return false;
    }
    
    public double promedioVentas(){
        double total = getTotalDinero();
        double totalVendidos = 0;
        for (Producto p : this.productos) {
            totalVendidos+=p.getUnidadesVendidas();
        }
        return totalVendidos == 0 ? total : Math.round(total / totalVendidos);
    }
    
    public double getTotalDinero(){
       return this.dineroEnCaja;
    }
    
    private Producto existe(String nombre){
        Iterator i = productos.iterator();
           Producto p;
           while(i.hasNext()){
               p = (Producto)i.next();
               if(p.getNombre().equals(nombre))
                   return p;
           }
           return null;
    }

    public TreeSet<Producto> getProductos() {
        return productos;
    }

    public void setProductos(TreeSet<Producto> productos) {
        this.productos = productos;
    }

    public Hashtable<String, Producto> getProductosAgotados() {
        return productosAgotados;
    }

    public void setProductosAgotados(Hashtable<String, Producto> productosAgotados) {
        this.productosAgotados = productosAgotados;
    }

    public double getDineroEnCaja() {
        return dineroEnCaja;
    }

    public void setDineroEnCaja(double dineroEnCaja) {
        this.dineroEnCaja = dineroEnCaja;
    }
    
}
