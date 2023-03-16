package src.co.edu.uniquindio.biblioteca.views;

import java.util.ArrayList;
//, el identificador, el nombre, el color, el área y el perímetro. 

import javax.swing.JOptionPane;

import src.co.edu.uniquindio.biblioteca.model.Biblioteca;
import src.co.edu.uniquindio.biblioteca.model.DetallePrestamo;
import src.co.edu.uniquindio.biblioteca.model.Empleado;
import src.co.edu.uniquindio.biblioteca.model.Estudiante;
import src.co.edu.uniquindio.biblioteca.model.Funciones;
import src.co.edu.uniquindio.biblioteca.model.Libro;
import src.co.edu.uniquindio.biblioteca.model.Prestamo;
//import src.co.edu.uniquindio.biblioteca.model.PrestamoException;
import src.co.edu.uniquindio.biblioteca.model.tipoLibros;

public class Test {

	public static void main(String[] args) throws Exception {

		menu();

	}

	public static void menu() throws Exception{
		Biblioteca biblioteca = new Biblioteca("Mi biblioteca","calle 12","1234567");


//Creacion de libros


		//Creacion de libros
		Libro libro1= new Libro("Cien años de soledad", "Gabriel Garcia Marquez", "2131",tipoLibros.BIOGRAFIAS);
		Libro libro2= new Libro("El ladron del rayo", "Rick Riordan", "1012",tipoLibros.CIENTIFICOS);
		Libro libro3= new Libro("El mar de los monstruos", "Rick Riordan", "3102",tipoLibros.MONOGRAFIAS);
		Libro libro4= new Libro("La maldicion del titan", "Rick Riordan", "2345",tipoLibros.CIENTIFICOS);
		biblioteca.getListaLibros().add(libro1);
		biblioteca.getListaLibros().add(libro2);
		biblioteca.getListaLibros().add(libro3);
		biblioteca.getListaLibros().add(libro4);
		//Creacion de prestamos
		Prestamo prestamo= new Prestamo("11-03-23",10.000,10,"0001",libro1);
		Prestamo prestamo2= new Prestamo("12-02-23",30.000,30,"0002",libro2);
		biblioteca.getListaPrestamos().add(prestamo);
		biblioteca.getListaPrestamos().add(prestamo2);
		//Creacion de detalles
		DetallePrestamo detalle1= new DetallePrestamo("0001",5.000,14,libro1);
		DetallePrestamo detalle2= new DetallePrestamo("0002",10.000,25,libro2);
		Prestamo.getListaDetallePrestamos().add(detalle1);
		Prestamo.getListaDetallePrestamos().add(detalle2);

		ArrayList<DetallePrestamo> detallePrestamo1= new ArrayList<>();
		detallePrestamo1.add(detalle1);
		detallePrestamo1.add(detalle2);

		prestamo.setListaDetallePrestamos(detallePrestamo1);


		//Creacion de la lista de prestamos para cada empleado
		ArrayList<Prestamo> prestamoEmpleado1= new ArrayList<>();
		prestamoEmpleado1.add(prestamo);
		prestamoEmpleado1.add(prestamo2);

		//ArrayList<Prestamo> prestamoEmpleado2= new ArrayList<>();
		//prestamoEmpleado2.add(prestamo);
		//prestamoEmpleado2.add(prestamo2);

		//Creacion de empleados
		Empleado empleado1= new Empleado("Santiago", 1.300000, "Tendero");
		Empleado empleado2= new Empleado("Juan", 1.000000, "Bibliotecario");
		biblioteca.getListaEmpleados().add(empleado1);
		biblioteca.getListaEmpleados().add(empleado2);

		empleado1.setListaPrestamos(prestamoEmpleado1);
		//empleado2.setListaPrestamos(prestamoEmpleado2);

		int opc;
		String resultado= "";
		do{
			opc= Funciones.leerNumero("""
				1. Crear estudiante
				2. Consultar estudiante
				3. Eliminar estudiante
				4. Actualizar estudiante
				5. Obtener estudiantes mayores de edad
				6. Ordenar libros por ISBN y mostrar
				7. Mostrar libros
				8. Mostar empleado de acuerdo al prestamo de un libro por isbn
				9. Mostrar Prestamos
				10. Mostrar prestamo con tiempo de entrega superior a  dias y menor a  dias 
				11. Tipo de libro que mas se presta
				12. Salir
				""");

			switch(opc){
				case 1:
				
				String nombre= Funciones.leerCadena("Ingrese el nombre del estudiante: ");
				String apellido= Funciones.leerCadena("Ingrese el apellido: ");
				int edad= Funciones.leerNumero("Ingrese la edad: ");
				String programa= Funciones.leerCadena("Ingrese al programa al que pertenece: ");
				String estado= Funciones.leerCadena("Ingrese el estado, Activo/Inactivo: ");
				String identificacion= Funciones.leerCadena("Ingrese la identificacion: ");
				try {
					resultado= biblioteca.crearEstudiante(nombre, apellido, edad, programa, estado, identificacion);
				} catch (Exception e) {
					resultado= e.getMessage();
				}
				JOptionPane.showMessageDialog(null, resultado);
				break;

				case 2:
				String identificacionBus= Funciones.leerCadena("Ingrese la identificacion del estudiante que desea conocer: ");
				if(biblioteca.obtenerEstudiante(identificacionBus)==null){
					JOptionPane.showMessageDialog(null, "No hay informacion para mostrar");
				}else{
					JOptionPane.showMessageDialog(null, biblioteca.obtenerEstudiante(identificacionBus).toString());
				}
				break;

				case 3:
				String identificacionEli= Funciones.leerCadena("Ingrese la identificacion del estudiante que desea eliminar");
				biblioteca.eliminarEstudiante2(identificacionEli);
				JOptionPane.showMessageDialog(null, "El estudiante ha sido eliminado con exito");
				break;

				case 4:
				String identificacionAct= Funciones.leerCadena("Ingrese la identificacion del estudiante del que desea actualizar la informacion");
				String nombreAct= Funciones.leerCadena("Ingrese el nombre del estudiante: ");
				String apellidoAct= Funciones.leerCadena("Ingrese el apellido: ");
				int edadAct= Funciones.leerNumero("Ingrese la edad: ");
				JOptionPane.showMessageDialog(null, biblioteca.actualizarEstudiante(nombreAct, apellidoAct, identificacionAct, edadAct));
				break;

				case 5:
				ArrayList<Estudiante> estudiantesMayores = new ArrayList<>();
				estudiantesMayores= biblioteca.obtenerEstudiantesEdadMayor(18);
				StringBuilder sb = new StringBuilder();

				estudiantesMayores.stream()
				.forEach(s-> sb.append(s).append("\n"))
				;
				JOptionPane.showMessageDialog(null, sb.toString());;
				break;

				case 6:
				biblioteca.ordenarLibrosPorISBN();
				ArrayList<Libro> librosOrdenados= new ArrayList<>();
				librosOrdenados= biblioteca.getListaLibros();
				StringBuilder constructor= new StringBuilder();
				librosOrdenados.stream()
				.forEach(c -> constructor.append(c).append("\n"))
				;
				JOptionPane.showMessageDialog(null, constructor.toString());
				break;

				case 7:
				StringBuilder cons= new StringBuilder();

				biblioteca.getListaLibros().stream()
				.forEach(c -> cons.append(c).append("\n"))
				;

				JOptionPane.showMessageDialog(null, cons.toString());
				
				break;
				
				case 8:

				
				String busquedaISBN= Funciones.leerCadena("Ingrese el codigo isbn del libro");
				if(biblioteca.obtenerEmpleado(busquedaISBN)== null){
					JOptionPane.showMessageDialog(null, "Ningun libro con ese isbn ha sido prestado");
				}else{	
					JOptionPane.showMessageDialog(null, biblioteca.obtenerEmpleado(busquedaISBN));
				}
				
				break;
				
				case 9:
				StringBuilder pres= new StringBuilder();
				biblioteca.getListaPrestamos().stream()
				.forEach(p -> pres.append(p).append("\n"));
				;
				JOptionPane.showMessageDialog(null, pres.toString());

				break;

				case 10:
				//int cantiDias= Funciones.leerNumero("El prestamo que quiere buscar tiene que tener un tiempo de entrega superior a: ");
				//int cantiDias2= Funciones.leerNumero("El prestamo que quiere buscar tiene que tener un tiempo de entrega inferior a: ");
				if((biblioteca.devolverPrestamoLibro("El ladron del rayo",5,15,2)) == null ){
					JOptionPane.showMessageDialog(null, "No hay nada que mostrar");
				}else{
					JOptionPane.showMessageDialog(null, biblioteca.devolverPrestamoLibro("El ladron del rayo",5,15,2));
				}

				break;
				case 11:

				if(biblioteca.libroMasPrestado()== null){
					JOptionPane.showMessageDialog(null, "No hay nada que mostrar,vaya y revise esa logica");
				}else{
					JOptionPane.showMessageDialog(null, biblioteca.libroMasPrestado());
				}

				break;
				case 12:
				JOptionPane.showMessageDialog(null, "bye");
				break;
				default:
				JOptionPane.showMessageDialog(null, "Opcion valida");
				break;
			}



		}while(opc!=12);

	}



}
