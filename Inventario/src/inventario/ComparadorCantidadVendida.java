/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import java.util.Comparator;

/**
 *
 * @author Cristian
 */
public class ComparadorCantidadVendida implements Comparator<Producto>{

    @Override
    public int compare(Producto o1, Producto o2) {
        if(o1.getUnidadesVendidas()<o2.getUnidadesVendidas())
            return 1;
        else if(o1.getUnidadesVendidas()>o2.getUnidadesVendidas())
            return -1;
        else 
            return 0;
    }
    
}
