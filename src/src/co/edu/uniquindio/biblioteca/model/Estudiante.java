package src.co.edu.uniquindio.biblioteca.model;

import java.util.ArrayList;

public class Estudiante {

	
	//Atributos
	private String nombres;
	private String apellidos;
	private Integer edad;
	private String programa;
	private String estado;
	private String identificacion;
        private ArrayList<Prestamo> listaPrestamos;

    
	
	public Estudiante() {
	}

	/**
	 * 
	 * @param nombres
	 * @param apellidos
	 * @param edad
	 * @param programa
	 * @param estado
	 * @param identificacion
	 */
	

	public Estudiante(String nombres, String apellidos, Integer edad, String programa, String estado, String identificacion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.programa = programa;
        this.estado = estado;
        this.identificacion = identificacion;
        this.listaPrestamos = new ArrayList<>();
	}


    public String getNombres() {
        return nombres;
    }

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public ArrayList<Prestamo> getListaPrestamos() {
		return listaPrestamos;
	}

	public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
		this.listaPrestamos = listaPrestamos;
	}
	
	
	public boolean verificarEdad(int edad){
		return getEdad() >=edad;
	}
        
	/**
	 * 
	 * @param identificacion
	 * @return
	 */
	public boolean verificarIdentificacion(String identificacion){
		return this.getIdentificacion().equals(identificacion);
	}
	/**
	 * 
	 * @param programa
	 * @return
	 */
	public boolean verificarPrograma(String programa){
		return this.getPrograma().equals(programa);
	}

	/**
	 * 
	 * @param identificacion
	 * @param programa
	 * @return
	 */
	public boolean verificarIdenPrograma(String identificacion, String programa){
		boolean cumple= false;
		if(verificarIdentificacion(identificacion) && verificarPrograma(programa) == true){
			cumple= true;
		}
		return cumple;
	}


	@Override
	public String toString() {
		return "Nombre: " + nombres + " "+apellidos + "\n Edad: " + edad + "\nPrograma: "
				+ programa + "\nEstado: " + estado + "\nIdentificacion: " + identificacion;
	}
	
	


}
