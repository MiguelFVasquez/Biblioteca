
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
    

    public int cantidadDeLibrosPrestados(){
        return getCantidad();
    }


    public boolean cumpleLibro(String titulo, int limiteInferior, int limiteSuperior) {
		
		boolean cumpleNombre = false;
		boolean cumpleCantidad = false;
		
		cumpleCantidad = verificarRango(limiteInferior,limiteSuperior);
		cumpleNombre = verificarNombre(titulo);
		
		if(cumpleCantidad && cumpleNombre){
			return true;
		}
		return false;
	}


    private boolean verificarNombre(String titulo) {
		return getLibro().getTitulo().equals(titulo);
	}

    private boolean verificarRango(int limiteInferior, int limiteSuperior) {
		if(cantidad >= limiteInferior && cantidad < limiteSuperior) return true;
		return false;
	}

    public boolean cumpleTipo(tipoLibros tipo) {
		return getLibro().getTipo() == (tipo);
	}

    public boolean verificarAutor(String autor){
        return getLibro().verificarAutor(autor);
    }

    public boolean verificarCantidad(int cantidad){
        return this.getCantidad()>=cantidad;
    }
    
    /**
     * 
     * @param autor
     * @param cantidad
     * @return
     */
    public boolean verificarAutorCantidad(String autor, int cantidad){
        boolean cumple= false;
        if( verificarAutor(autor) && verificarCantidad(cantidad)){
            cumple= true;
        }
        return cumple;
    }


    @Override
    public String toString() {
        return "DetallePrestamo{" + "codigo=" + codigo + ", subTotal=" + subTotal + ", cantidad=" + cantidad + '}';
    }

    
   
    
}
