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
public class MovieItem extends BlockBusterItem {
    private String estado;
    private Calendar fecha;
    
    MovieItem(String nombre, int codigo, double precioRenta){
        super(nombre, codigo, precioRenta);
        estado = "ESTRENO";
        this.fecha=fecha;
    }
    
    public String toString(){
        return super.toString()+", Estado: "+estado+" - Movie";
    }
    public double pagoRenta(int dias){
        double mili = super.getFecha().getTimeInMillis()+(86400000*dias);
        double renta = 45;
        if(estado.equals("ESTRENO") && mili+getFecha().getTimeInMillis()>getFecha().getTimeInMillis()+(86400000*2)){
            return renta+(50*dias-2);
        }
        else if(estado.equals("NORMAL") && mili+getFecha().getTimeInMillis()>getFecha().getTimeInMillis()+(86400000*5)){
            return renta+(30*dias-5);
        }
        return renta;
    }
    public void evaluarEstado(){
        Calendar fechaActual = Calendar.getInstance();
        getFecha().add(Calendar.MONTH, 5);
        if(fechaActual.after(getFecha())==true){
            estado = "NORMAL";
        }
    }
        public Calendar getFecha(){
        return fecha;
        
    }
    

    
}
