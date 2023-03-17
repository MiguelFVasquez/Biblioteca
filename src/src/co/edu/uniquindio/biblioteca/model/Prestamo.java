package src.co.edu.uniquindio.biblioteca.model;

import java.util.ArrayList;


public class Prestamo {
    
    private String fecha;
    private double total;
    private Integer tiempoEntrega;
    private String codigo;
    private Libro libro;
    private static ArrayList<DetallePrestamo> listaDetallePrestamos;
    
    public Prestamo() {
    }

    public Prestamo(String fecha, double total, Integer tiempoEntrega, String codigo, Libro libro) {
        this.fecha = fecha;
        this.total = total;
        this.tiempoEntrega = tiempoEntrega;
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

    public Integer getTiempoEntrega() {
        return tiempoEntrega;
    }

    public void setTiempoEntrega(Integer tiempoEntregea) {
        this.tiempoEntrega = tiempoEntregea;
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


    public boolean verificarFechas(int fecha1, int fecha2){
        boolean cumple= false;

        if(getTiempoEntrega()>= fecha1 && getTiempoEntrega()<=fecha2){
            cumple=true;
        }
        return cumple;
    }

    public int unidadesPrestadas(){
        int cant=0;
        for (DetallePrestamo detalleAUX : listaDetallePrestamos) {
            cant= detalleAUX.cantidadDeLibrosPrestados();
        }
        return cant;
    }


    public boolean cumpleLibro(String titulo, int limiteInferior, int limiteSuperior, int aniosExperiencia) {
	
        for (DetallePrestamo detallePrestamo : listaDetallePrestamos) {
            if(detallePrestamo.cumpleLibro(titulo,limiteInferior,limiteSuperior)){
                return true;
            }
        }
        return false;
    }
    



    public int obtenerCantidadTipo(tipoLibros tipo) {
        int cantidad = 0;
        for (DetallePrestamo detallePrestamo : listaDetallePrestamos) {
            if(detallePrestamo.cumpleTipo(tipo)){
                cantidad += detallePrestamo.getCantidad();
            }
        }
        return cantidad;
    }
    
    /**
     * 
     * @param tipo
     * @return
     */
    public boolean verificarTipoTotal(tipoLibros tipo){
        boolean cumple= false;
        if(verificarTipo(tipo) && verificarTotal()){
            cumple= true;
        }
        return cumple;
    }

    public boolean verificarTipo(tipoLibros tipo){
        boolean cumple= false;
        for (DetallePrestamo detallePrestamo : listaDetallePrestamos) {
            if(detallePrestamo.cumpleTipo(tipo)){
                cumple= true;
            }
        }

        return cumple;
    }
    public boolean verificarTotal(){
        return this.getTotal()>10.000 && this.getTotal()<20.000;
    }
    /**
     * 
     * @param autor
     * @param cant
     * @return
     */
    public boolean cumpleCantidadAutor(String autor, int cant){
        boolean cumple= false;

        for (DetallePrestamo detallePrestamo : listaDetallePrestamos) {
            if(detallePrestamo.verificarAutorCantidad(autor,cant)){
                cumple= true;
            }
        }


        return cumple;
    }

    @Override
    public String toString() {
        return "Prestamo: " + "Fecha: " + fecha + "\nTotal=" + total + "\nTiempo de entrega: " + tiempoEntrega + "\nCodigo: " + codigo + "\nLibro: " + libro.getTitulo();
    }
    
    
    
    


    
}
