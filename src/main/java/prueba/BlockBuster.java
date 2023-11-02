/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba;

import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class BlockBuster {
 private ArrayList<BlockBusterItem> items;
 int codigo;
 

    public BlockBuster() {
        items = new ArrayList<>();
        this.codigo=codigo;
    }

    public BlockBusterItem buscarItem(int codigo, String tipo) {
        for (BlockBusterItem item : items) {
            if (item.getCodigo() == codigo) {
                if ((tipo.equals("MOVIE") && item instanceof MovieItem) || (tipo.equals("GAME") && item instanceof VideoGameItem)) {
                    return item;
                }
            }
        }
        return null;
    }
    public void agregarItem(int codigo, String nombre, String tipoItem) {
        BlockBusterItem encontrado = buscarItem(codigo, tipoItem);
        if (encontrado == null) {
            if (tipoItem.equals("MOVIE")) {
    
                MovieItem nuevaPelicula = new MovieItem(nombre, codigo, 0); // El último 0 puede ser el precio de renta
          
                items.add(nuevaPelicula);
            } else if (tipoItem.equals("GAME")) {

                VideoGameItem nuevoVideoJuego = new VideoGameItem(nombre, codigo, 0, "PlayStation"); // El último "PlayStation" es un ejemplo de tipo de consola
              
                items.add(nuevoVideoJuego);
            }
        }
    }
    public void rentar(int codigo, String tipoItem, int dias) {
        BlockBusterItem item = buscarItem(codigo, tipoItem);
        if (item != null) {
            System.out.println(item); 
            System.out.println("Monto a pagar: " + item.pagoRenta(dias)); 
        } else {
            System.out.println("Item No Existe");
        }
    }

    public void auditarMovieEstados() {
        for (BlockBusterItem item : items) {
            if (item instanceof MovieItem) {
                ((MovieItem) item).evaluarEstado(); 
            }
        }
    }
    public int getCodigo() {
        return codigo;
    }
 
}
