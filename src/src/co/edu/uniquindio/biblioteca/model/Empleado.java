
package src.co.edu.uniquindio.biblioteca.model;

import java.util.ArrayList;


public class Empleado {
    
    private String nombre;
    private Double pago;
    private String cargo;
    private int aniosExperiencia;
    private ArrayList<Prestamo> listaPrestamos;
    
    
    public Empleado() {
    }

    public Empleado(String nombre, Double pago, String cargo) {
        this.nombre = nombre;
        this.pago = pago;
        this.cargo = cargo;
        this.listaPrestamos = new ArrayList<>();
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public ArrayList<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }
    
        
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public boolean verificarPrestamo(String isbn){
        boolean verificado= false;
        for (Prestamo prestamoAux : listaPrestamos) {
            if(prestamoAux.verificarISBN(isbn)){
                verificado= true;
            }
            
        }
        return verificado;
    }
    /**
     * 
     * @return
     */
    public boolean verificarNombre(){
        boolean cumple= false; 
        String nombreEmpleado= this.getNombre().toLowerCase();
        int contador= 0;
        for (int i = 0; i < nombreEmpleado.length(); i++) {
            char caracter = nombreEmpleado.charAt(i);
            if(caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u' ){
                contador++;
            }
        }

        if(contador>=3){
            cumple= true;
        }

        return cumple;
    }


    @Override
    public String toString() {
        return "Empleado"+"\nNombre: "+nombre + "\nPago: " + pago + "\nCargo: " + cargo ;
    }


    
    
    
    
}
