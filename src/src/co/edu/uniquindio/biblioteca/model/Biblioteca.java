package src.co.edu.uniquindio.biblioteca.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;



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

	public Empleado obtenerEmpleado( String isbn){
		Empleado empleadoEncontrado = null;
		for (Empleado empleadoAux : listaEmpleados) {
			if(empleadoAux.verificarPrestamo(isbn)){
				empleadoEncontrado= empleadoAux;
			}
		}




		return empleadoEncontrado;
	}

	public ArrayList<Prestamo> obtenerPrestamosEntreTiempo(int fecha1, int fecha2){
		ArrayList<Prestamo> prestamosTiempo = new ArrayList<>();

		for (Prestamo prestamoAUX : listaPrestamos) {
			if(prestamoAUX.verificarFechas(fecha1, fecha2)){
				prestamosTiempo.add(prestamoAUX);
			}
		}

		return prestamosTiempo;
	}




	public tipoLibros libroMasVendido(){
		
		HashMap<tipoLibros, Integer> unidadesPrestadasPorTipo = new HashMap<>();
		    // Recorrer la lista de préstamos y acumular las unidades prestadas por tipo de libro

		for (Prestamo prestamo : listaPrestamos) {
			tipoLibros tipoLibro = prestamo.getLibro().tipoLibro();
			int unidadesPrestadas = prestamo.unidadesPrestadas();
	
			int unidadesRegistradas = unidadesPrestadasPorTipo.getOrDefault(tipoLibro, 0);
			unidadesPrestadasPorTipo.put(tipoLibro, unidadesRegistradas + unidadesPrestadas);
		}

		tipoLibros tipoMasPrestado= null;
		int unidadesMasPrestadas= 0;
		for (tipoLibros tipo : unidadesPrestadasPorTipo.keySet()) {
			int unidadesPrestadas = unidadesPrestadasPorTipo.get(tipo);
			if(unidadesPrestadas > unidadesMasPrestadas){
				unidadesMasPrestadas = unidadesPrestadas;
				tipoMasPrestado= tipo;
			}
		}


		return tipoMasPrestado;
	}

	
}
