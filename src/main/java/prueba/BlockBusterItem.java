/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba;
import java.util.Calendar;

/**
 *
 * @author danie
 */
public abstract class BlockBusterItem {
   protected String nombre;
    protected int codigo;
    protected double precioRenta;
    private Calendar fecha;

    public BlockBusterItem(String nombre, int codigo, double precioRenta) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precioRenta = precioRenta;
        fecha=Calendar.getInstance();
    }
    
    public Calendar getFecha(){
        return fecha;
    }
    public int getCodigo() {
        return codigo;
    }
    
    public String toString() {
        return "Nombre: "+nombre+", Código: "+codigo+", Precio de renta: Lps. "+precioRenta;
    }
    public abstract double pagoRenta(int dias); 
    
}
