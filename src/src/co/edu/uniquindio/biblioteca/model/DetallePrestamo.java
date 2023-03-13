
package src.co.edu.uniquindio.biblioteca.model;


public class DetallePrestamo {
    
    private String codigo;
    private Double subTotal;
    private Integer cantidad;
    public Libro libro;

    public DetallePrestamo() {
    }

    public DetallePrestamo(String codigo, Double subTotal, Integer cantidad, Libro libro) {
        this.codigo = codigo;
        this.subTotal = subTotal;
        this.cantidad = cantidad;
        this.libro= libro;
    }

    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }


    public boolean verificarISBN(String isbn){
        return getLibro().getIsbn().equals(isbn);
    }
    

    
    @Override
    public String toString() {
        return "DetallePrestamo{" + "codigo=" + codigo + ", subTotal=" + subTotal + ", cantidad=" + cantidad + '}';
    }

    
   
    
}
