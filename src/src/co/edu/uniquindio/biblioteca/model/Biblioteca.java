package src.co.edu.uniquindio.biblioteca.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class Biblioteca {

	
	//ATRIBUTOS
	private String nombre;
	private String direccion;
	private String telefono;
	private ArrayList<Estudiante> listaEstudiantes;
	private ArrayList<Libro> listaLibros;
	private ArrayList<Prestamo> listaPrestamos;
	private ArrayList<Empleado> listaEmpleados;

	public Biblioteca() {
	
	}

	/**
	 * Este es el metodo constructor de la clase biblioteca
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 */
	

	public Biblioteca(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.listaEstudiantes = new ArrayList<>();
        this.listaLibros = new ArrayList<>();
        this.listaPrestamos = new ArrayList<>();
        this.listaEmpleados = new ArrayList<>();
	}
    
    

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public ArrayList<Estudiante> getListaEstudiantes() {
		return listaEstudiantes;
	}

	public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}

        public ArrayList<Libro> getListaLibros() {
            return listaLibros;
        }

        public void setListaLibros(ArrayList<Libro> listaLibros) {
            this.listaLibros = listaLibros;
        }

        public ArrayList<Prestamo> getListaPrestamos() {
            return listaPrestamos;
        }

        public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
            this.listaPrestamos = listaPrestamos;
        }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
        
        
        
	@Override
	public String toString() {
		return "Biblioteca [nombre=" + nombre + ", direccion=" + direccion + "]";
	}

	/**
	 * Este metodo permite crear un estudiante
	 * @param nombres
	 * @param apellidos
	 * @param edad
	 * @param programa
	 * @param estado
	 * @param identificacion
	 * @throws Exception 
	 */
	public String crearEstudiante(String nombres, String apellidos, Integer edad, String programa, String estado,
               String identificacion) throws Exception{
		
		String mensaje = "El estudiante ha sido registrado";
		boolean estudianteEncontrado = verificarEstudiante(identificacion);
		if( estudianteEncontrado == true){
			throw new Exception("El estudiante ya existe");
		}else{
			Estudiante nuevoEstudiante = new Estudiante(nombres, apellidos, edad, programa, estado, identificacion);
			listaEstudiantes.add(nuevoEstudiante);
		}
		return mensaje;
	}

	private boolean verificarEstudiante(String identificacion) {
		boolean verificado = false;		
		for (Estudiante estudianteaux : listaEstudiantes) {
			if(estudianteaux.getIdentificacion().equals(identificacion)){
				verificado = true;
				return verificado;
			}
		}
		return verificado;
	}
	/**
	 * Obtener un estudiante
	 * @param identificacion
	 * @return
	 */
	public Estudiante obtenerEstudiante (String identificacion){
		
		Estudiante estudianteEncontrado = null;
		
		for (Estudiante estudiante : listaEstudiantes) {
			if(estudiante.getIdentificacion().equals(identificacion)){
				estudianteEncontrado = estudiante;
			}
		}
		return estudianteEncontrado;
	}
	
	public Empleado obtenerEmple (String nombre){
		
		Empleado empleadoEncontrado = null;
		
		for (Empleado empleado : listaEmpleados) {
			if(empleado.getNombre().equals(nombre)){
				empleadoEncontrado = empleado;
			}
		}
		return empleadoEncontrado;
	}
	


	public void eliminarEstudiante2(String identificacion) throws Exception{
		Estudiante estudianteEncontrado = obtenerEstudiante(identificacion);
		if(estudianteEncontrado == null){
			throw new Exception("El estudiante no esta registrado");
		}
		listaEstudiantes.remove(estudianteEncontrado);
	}

	/**
	 * 
	 * @param nombres
	 * @param apellidos
	 * @param identificacion
	 * @param edad
	 * @return
	 * @throws Exception
	 */
	public String actualizarEstudiante(String nombres , String apellidos , String identificacion, Integer edad) throws Exception{
		Estudiante estudianteEncontrado = obtenerEstudiante(identificacion);
		if(estudianteEncontrado == null){
			throw new Exception("El estudiante no esta registrado");
		}
       estudianteEncontrado.setNombres(nombres);
       estudianteEncontrado.setApellidos(apellidos);
       estudianteEncontrado.setEdad(edad);
       
       return " El estudiante ha sido actualizado " ;
	}
	
	
	public void ordenarLibrosPorISBN() {
        Collections.sort(listaLibros, new Comparator<Libro>() {
			@Override
			public int compare(Libro Libro1, Libro libro2) {
				return Libro1.getIsbn().compareTo(libro2.getIsbn());
			}
        });
    }
	
	
	public ArrayList<Estudiante> obtenerEstudiantesEdadMayor(int edad){
		
		ArrayList<Estudiante> estudiantesMayores= new ArrayList<>();
		
		for (Estudiante estudiante : listaEstudiantes) {
			if(estudiante.verificarEdad(edad)){
				estudiantesMayores.add(estudiante);
			}
		}
		return estudiantesMayores;
	}
        /**
         * 
         * @param total
         * @param autor
         * @return 
         */
	public ArrayList<Prestamo> obtenerPrestamoMayor(double total, String autor){
		ArrayList<Prestamo> prestamosEncontrados= new ArrayList<>();
		
		for (Prestamo prestamo : listaPrestamos) {
			if(prestamo.verificarTotalAutor(total,autor) == true){
				prestamosEncontrados.add(prestamo);
			}
		}
		
		return prestamosEncontrados;
	}

	public Empleado obtenerEmpleado( String isbn) {
		Empleado empleadoEncontrado = null;
		for (Empleado empleadoAux : listaEmpleados) {
			if(empleadoAux.verificarPrestamo(isbn)){
				empleadoEncontrado= empleadoAux;
			}
		}
		return empleadoEncontrado;
	}

	public Prestamo devolverPrestamoLibro(String titulo,int limiteInferior,int limiteSuperior,int aniosExperiencia){
		
		Prestamo prestamoEncontrado = null;
		for (Prestamo prestamo : listaPrestamos) {
			if(prestamo.cumpleLibro(titulo,limiteInferior,limiteSuperior,aniosExperiencia)){
				prestamoEncontrado = prestamo;
				return prestamoEncontrado;
			}
		}
		return prestamoEncontrado;
	}




	public tipoLibros libroMasPrestado(){
		tipoLibros tipoMasPrestado= tipoLibros.BIOGRAFIAS;

		int totalPrestadoBiografia= obtenerTotalPrestado(tipoLibros.BIOGRAFIAS);
		int totalPrestadoCientifico= obtenerTotalPrestado(tipoLibros.CIENTIFICOS);
		int totalPrestadoMonografia= obtenerTotalPrestado(tipoLibros.MONOGRAFIAS);

		if(totalPrestadoBiografia > totalPrestadoCientifico && totalPrestadoBiografia> totalPrestadoMonografia){
			tipoMasPrestado= tipoLibros.BIOGRAFIAS;
		}else{
			if(totalPrestadoCientifico > totalPrestadoMonografia){
				tipoMasPrestado= tipoLibros.CIENTIFICOS;
			}else{
				tipoMasPrestado= tipoLibros.MONOGRAFIAS;
			}
		}
		return tipoMasPrestado;

	}

		private int obtenerTotalPrestado(tipoLibros tipo) {
		
		int cantidad = 0;
		for (Prestamo prestamo : listaPrestamos) {
			cantidad += prestamo.obtenerCantidadTipo(tipo);
		}
		
		return cantidad;
	}


	
}
