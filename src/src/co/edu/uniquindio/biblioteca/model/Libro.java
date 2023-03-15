package src.co.edu.uniquindio.biblioteca.model;

public class Libro {
	
    private String titulo;
    private String autor;
    private String isbn;
    private tipoLibros tipo;
    
    /**
     * 
     * @param titulo
     * @param autor
     * @param editorial 
     */

    public Libro(String titulo, String autor, String isbn, tipoLibros tipo) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn= isbn;
        this.tipo= tipo;
        
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    

    public tipoLibros getTipo() {
        return tipo;
    }

    public void setTipo(tipoLibros tipo) {
        this.tipo = tipo;
    }


    public boolean verificarAutor(String autor){
    
        return getAutor().equals(autor);
    }


    public boolean verificarTipo(tipoLibros tipo){
        boolean cumple= false;
        if(this.getTipo().equals(tipo)){
            cumple= true;
        }
        return cumple;
    }
    public tipoLibros tipoLibro(){
        return getTipo();
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + ", Autor: " + autor  + ", Codigo ISBN: "+ isbn + ", Tipo de libro: " + tipo;
    }

    
}
