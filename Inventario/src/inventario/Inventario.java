/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Cristian
 */
public class Inventario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Producto p = new Producto("Cafe", "Super", 3, 1, 13000);
        Producto p2 = new Producto("Cafe", "Super", 3, 1, 13000);
        Set<Producto> s = new HashSet();
        s.add(p);
//        s.add(p2);
        System.out.println("hash 1 ..: "+p.getNombre().hashCode()+"\nhash 2 ..: "+p2.getNombre().hashCode());
        System.out.println("Contiene: "+s.contains(p2));
    }
    
}
