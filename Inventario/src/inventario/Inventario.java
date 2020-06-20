/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Cristian
 */
public class Inventario {

    private TreeSet<Producto> productos;
    private Hashtable<String,Producto> productosAgotados;

    public Inventario() {
        this.productos = new TreeSet();
        productosAgotados = new Hashtable();
    }
    
    public boolean venderProducto(int cantidad, String nombre){
        Producto p = existe(nombre);
        boolean vendio = false;
        if(p!=null)
            vendio = p.venderUnidades(cantidad);
        hacerPedido(p);//despues de vender verifico si se agoto para agregarlo a la lista
        return vendio;
    }
    
    private void hacerPedido(Producto p){
        if(p.pedir()){
            if(this.productosAgotados.get(p.getNombre()) != null);
                productosAgotados.put(p.getNombre(), p);
        }
    }
    
    public boolean recargarProducto(String nombre){
        Producto p = productosAgotados.get(nombre);
        
        return false;
    }
    
    public void hacerPedido(String nombre){
        
    }
    
    public SortedSet getProductosAcabados(String nombre){
        Producto p = existe(nombre);
        if(p.getUnidadesDisp()<=p.getnNuevoPedido())
            return productos.headSet(p);
        return null;
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
        in.productos.add(new Producto("canela", "Supermercado",3,2,10000));
        in.productos.add(new Producto("Harina", "drogueria",3,2,10000));
        in.productos.add(new Producto("Cafe", "Supermercado",3,2,10000));
        in.productos.add(new Producto("Cafe", "Supermercado",3,2,10000));
        in.productos.add(new Producto("Cafe", "Supermercado",3,2,10000));
        in.productos.add(new Producto("Cafe", "Supermercado",3,2,10000));
        in.productos.add(new Producto("soya", "Supermercado",3,2,10000));
          
        TreeSet<Producto> t = in.productos;
        System.out.println(t.size());
        for (Producto p: t) {
            System.out.println(p.getNombre());
        }
        
        in.venderProducto(3, "Cafe");
        in.venderProducto(3, "Cafe");
        
        Hashtable<String,Producto> l = in.productosAgotados;
        System.out.println("productos agotados");
        Enumeration i = l.keys();
        while(i.hasMoreElements()){
            System.out.println(l.get(String.valueOf(i.nextElement())).getNombre());
        }
        
        
        
        
        
        
//        Producto p = new Producto("Cafe", "Drogueria", 3, 1, 13000);
//        Producto p2 = new Producto("Cafe", "Super", 3, 1, 13000);
        
//        s.add(p);
//        System.out.println("precio final "+p.getPrecioFinal());
////        s.add(p2);
////        System.out.println("hash 1 ..: "+p.getNombre().hashCode()+"\nhash 2 ..: "+p2.getNombre().hashCode());
////        System.out.println("Contiene: "+s.contains(p2));
    }
    
}
