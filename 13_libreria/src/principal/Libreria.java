package principal;

import java.util.Scanner;

public class Libreria {

	public static void main(String[] args) {
		StringBuilder titulos;
		int opcion;
			
		titulos = new StringBuilder ("");
		do
		{
			opcion = menu();	
			switch (opcion)
			{
				case 1:
					ingresarLibros(titulos);
					System.out.println(titulos);
					break;
				case 2:
					buscarLibros(titulos);
					break;
				case 3:
					eliminarLibros(titulos);
					System.out.println("Libros disponibles: " + titulos);
					break;
				case 4:
					break;
				default:
					System.out.println("Ingrese una opcion correcta.");
			}
		} while (opcion != 4);
	}
	
	
	static int menu ()
	{
		Scanner sc;
		
		sc = new Scanner(System.in);
		System.out.println("Menu: ");
		System.out.println("1: Ingresar ");
		System.out.println("2: Buscar ");
		System.out.println("3: Eliminar ");
		System.out.println("4: Salir ");
		System.out.print("Seleccionar opcion: ");
		return sc.nextInt();
	}
	
	static void ingresarLibros (StringBuilder valores) 
	{
		Scanner sc;
				
		sc = new Scanner(System.in);
		System.out.print("Ingresar titulo del libro: ");
		valores.append(sc.nextLine().toLowerCase());
		valores.append(",");
	}
	
	
	static void buscarLibros (StringBuilder valores) 
	{
		Scanner sc;
		String[] libros;
		String titulo;
		
		sc = new Scanner(System.in);
		System.out.print("Ingresar titulo del libro a buscar: ");
		titulo = sc.nextLine().toLowerCase();
		libros = valores.toString().split(",");
		for (String libro: libros)
		{
			if (libro.indexOf(titulo) != -1)
			{
				System.out.println(libro);
			}
		}
	}
	
	
	static void eliminarLibros (StringBuilder valores) 
	{
		Scanner sc;
		String[] libros;
		String titulo;
		
		sc = new Scanner(System.in);
		System.out.print("Ingresar titulo del libro a eliminar: ");
		titulo = sc.nextLine().toLowerCase();
		libros = valores.toString().split(",");
		for (String libro: libros)
		{
			if (libro.compareTo(titulo) == 0)
			{
				valores.delete(valores.indexOf(titulo), valores.indexOf(titulo)+titulo.length()+1);
				System.out.println("Libro borrado: " + titulo);
				return;
			}
		}
		System.out.println("No existe el libro: " + titulo);
	}

}
