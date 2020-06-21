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
    
    
    
    public static void main(String[] args) {
        Inventario in = new Inventario();
        in.productos.add(new Producto("canela", "Supermercado",30,2,10000));
        in.productos.add(new Producto("Harina", "drogueria",12,2,10000));
        in.productos.add(new Producto("Cafe", "Supermercado",3,2,10000));
        in.productos.add(new Producto("Cafe", "Supermercado",3,2,10000));
        in.productos.add(new Producto("Cafe", "Supermercado",3,2,10000));
        in.productos.add(new Producto("Cafe", "Supermercado",3,2,10000));
        in.productos.add(new Producto("soya", "Supermercado",10,2,10000));
          
        TreeSet<Producto> t = in.productos;
        System.out.println(t.size());
        for (Producto p: t) {
           System.out.println(p.getNombre()+" cantidad "+p.getUnidadesDisp()+" vendidos "+p.getUnidadesVendidas());
        }
        
        in.venderProducto(3, "Cafe");
        in.venderProducto(3, "Cafe");
        in.venderProducto(2, "canela");
        in.venderProducto(1, "soya");
        in.venderProducto(1, "Harina");
        
        
        Hashtable<String,Producto> l = in.productosAgotados;
        System.out.println("productos agotados");
        Enumeration i = l.keys();
        while(i.hasMoreElements()){
            System.out.println(l.get(String.valueOf(i.nextElement())).getNombre());
        }
        System.out.println("se recargo");
        in.recargarProducto("Cafe", 1);
        for (Producto p: t) {
            System.out.println(p.getNombre()+" cantidad "+p.getUnidadesDisp()+" vendidos "+p.getUnidadesVendidas());
        }
        System.out.println("Ordenado");
        //verificando orden
        LinkedList<Producto> orden = in.ordenar();
        for (Producto p: orden) {
            System.out.println(p.getNombre()+" cantidad "+p.getUnidadesDisp()+" vendidos "+p.getUnidadesVendidas());
        }
        System.out.println("Dinero en caja "+in.dineroEnCaja);
        
        System.out.println("Promedio ventas "+in.promedioVentas());
        
//        Producto p = new Producto("Cafe", "Drogueria", 3, 1, 13000);
//        Producto p2 = new Producto("Cafe", "Super", 3, 1, 13000);
        
//        s.add(p);
//        System.out.println("precio final "+p.getPrecioFinal());
////        s.add(p2);
////        System.out.println("hash 1 ..: "+p.getNombre().hashCode()+"\nhash 2 ..: "+p2.getNombre().hashCode());
////        System.out.println("Contiene: "+s.contains(p2));
    }
    
}
