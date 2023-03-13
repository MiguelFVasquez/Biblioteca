package src.co.edu.uniquindio.biblioteca.model;

import java.util.ArrayList;


public class Prestamo {
    
    private String fecha;
    private double total;
    private Integer tiempoEntregea;
    private String codigo;
    private Libro libro;
    private static ArrayList<DetallePrestamo> listaDetallePrestamos;
    
    public Prestamo() {
    }

    public Prestamo(String fecha, double total, Integer tiempoEntregea, String codigo, Libro libro) {
        this.fecha = fecha;
        this.total = total;
        this.tiempoEntregea = tiempoEntregea;
        this.codigo = codigo;
        this.libro = libro;
        Prestamo.listaDetallePrestamos = new ArrayList<>();
    }

   

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Integer getTiempoEntregea() {
        return tiempoEntregea;
    }

    public void setTiempoEntregea(Integer tiempoEntregea) {
        this.tiempoEntregea = tiempoEntregea;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public static ArrayList<DetallePrestamo> getListaDetallePrestamos() {
        return listaDetallePrestamos;
    }

    public void setListaDetallePrestamos(ArrayList<DetallePrestamo> listaDetallePrestamos) {
        Prestamo.listaDetallePrestamos = listaDetallePrestamos;
    }
    
    public boolean verificarTotal(double total){
       return getTotal() >total;
        
    }
    
    
    public boolean verificarTotalAutor(double total, String autor){
        boolean cumple= false;
        boolean totalVerificado= false;
        boolean autorVerificado= false;
        
        totalVerificado= verificarTotal(total);
        for(DetallePrestamo detalle: listaDetallePrestamos){
            if(detalle.getLibro().getAutor().equals(autor))
                autorVerificado= true;
        }
        
        if(totalVerificado && autorVerificado){
            cumple= true;
        }
        
        return cumple;
    }

    public boolean verificarISBN(String isbn){
        boolean cumple= false;
        boolean isbnVerificado= false;
        for (DetallePrestamo detalle : listaDetallePrestamos) {
            if(detalle.verificarISBN(isbn)){
                isbnVerificado=true;
            }
        }

        if(isbnVerificado){
            cumple= true;
        }

        return cumple;
    }
    
    @Override
    public String toString() {
        return "Prestamo{" + "fecha=" + fecha + ", total=" + total + ", tiempoEntregea=" + tiempoEntregea + ", codigo=" + codigo + '}';
    }
    
    
    
    
    
}
