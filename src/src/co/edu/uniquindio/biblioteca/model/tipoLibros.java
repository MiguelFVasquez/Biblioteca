package src.co.edu.uniquindio.biblioteca.model;

public enum tipoLibros{
    CIENTIFICOS(0), BIOGRAFIAS(1), MONOGRAFIAS(2);
    int valor;

    tipoLibros(int valor){
        this.valor= valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }


}