
package src.co.edu.uniquindio.biblioteca.model;

import java.util.ArrayList;


public class Empleado {
    
    private String nombre;
    private Double pago;
    private String cargo;
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
    
    
    public boolean verificarPrestamo(String isbn){
        boolean verificado= false;
        for (Prestamo prestamoAux : listaPrestamos) {
            if(prestamoAux.verificarISBN(isbn)){
                verificado= true;
            }
            
        }
        return verificado;
    }

    @Override
    public String toString() {
        return "Empleado"+"\nNombre: "+nombre + "\nPago: " + pago + "\nCargo: " + cargo ;
    }


    
    
    
    
}
