/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba;

/**
 *
 * @author danie
 */
public class VideoGameItem extends BlockBusterItem {
    private String tipoConsola;
public static final String PLAYSTATION="PlayStation";
public static final String XBOX="XBOX";
public static final String WII="WII";


    public VideoGameItem(String nombre,int codigo,double precioRenta,String tipoConsola) {
      super(nombre, codigo, 30);
      this.tipoConsola=tipoConsola;  
    }

    @Override
    public String toString(){
        return super.toString()+", Tipo de Consola: "+tipoConsola+" Game";
    }
    
    @Override
    public double pagoRenta(int dias) {
        return precioRenta * dias;
    }
    
}
