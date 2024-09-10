package ProyectoFinal;

import java.util.Scanner;

public class App_principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner miScan = new Scanner(System.in);

		Gestion_Clientes2 gestionClientes = new Gestion_Clientes2();
		Gestion_Vehiculos2 gestionVehiculos = new Gestion_Vehiculos2();
		Gestion_Vendedores2 gestionVendedores = new Gestion_Vendedores2();
		Gestion_Ventas2 gestionVentas = new Gestion_Ventas2();
		

		int opcion;
		do {
			System.out.println("----- Menú Principal -----");
			System.out.println("1. Gestionar Clientes");
			System.out.println("2. Gestionar Vehículos");
			System.out.println("3. Gestionar Vendedores");
			System.out.println("4. Gestionar Ventas");
			System.out.println("0. Salir");
			System.out.print("Seleccione una opción: ");
			opcion = miScan.nextInt();

			switch (opcion) {
			case 1:
				
				gestionClientesMenu(gestionClientes, miScan);
				break;
			case 2:
				gestionVehiculosMenu(gestionVehiculos, miScan);
				break;
			case 3:
				gestionVendedoresMenu(gestionVendedores, miScan);
				break;
			case 4:
				gestionVentasMenu(gestionVentas, miScan);
				break;
			case 0:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
			}
		} while (opcion != 0);

		miScan.close();
	}

	public static void gestionClientesMenu(Gestion_Clientes2 gestionClientes2, Scanner scanner) {
		int opcion;
		do {
			System.out.println("\n----- Menú Gestionar Clientes -----");
			System.out.println("1. Alta Cliente");
			System.out.println("2. Consultar Cliente");
			System.out.println("3. Asignar Cuenta Bancaria");
			System.out.println("4. Listar Todos los Clientes");
			System.out.println("5. Listar Clientes Menores de Edad");
			System.out.println("6. Listar Clientes Según Año de Alta");
			System.out.println("7. Modificar Datos del Cliente");
			System.out.println("0. Volver al Menú Principal");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				gestionClientes2.altaCliente();
				break;
			case 2:
				gestionClientes2.consultarCliente();
				break;
			case 3:
				gestionClientes2.asignarCuentaBancaria();
				break;
			case 4:
				gestionClientes2.listarTodosLosClientes();
				break;
			case 5:
				gestionClientes2.listarClientesMenoresDeEdad();
				break;
			case 6:
				gestionClientes2.listarClientesSegunAnoAlta();
				break;
			case 7:
				gestionClientes2.modificarDatosCliente();
				break;
			case 0:
				System.out.println("Volviendo al Menú Principal...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
			}
		} while (opcion != 0);
	}

	public static void gestionVehiculosMenu(Gestion_Vehiculos2 gestionVehiculos2, Scanner scanner) {
		int opcion;
		do {
			System.out.println("\n----- Menú Gestionar Vehículos -----");
			System.out.println("1. Alta Vehículo");
			System.out.println("2. Baja Vehículo");
			System.out.println("3. Consultar Vehículo");
			System.out.println("4. Modificar Vehículo");
			System.out.println("5. Listar todos los vehiculos");
			System.out.println("0. Volver al Menú Principal");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				gestionVehiculos2.altaVehiculo();
				break;
			case 2:
				gestionVehiculos2.bajaVehiculo();
				break;
			case 3:
				gestionVehiculos2.consultarVehiculo();
				break;
			case 4:
				gestionVehiculos2.modificarVehiculo();
				break;
			case 5:
				gestionVehiculos2.listarVehiculos();
			case 0:
				System.out.println("Volviendo al Menú Principal...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
			}
		} while (opcion != 0);
	}

	public static void gestionVendedoresMenu(Gestion_Vendedores2 gestionVendedores2, Scanner scanner) {
		int opcion;
		do {
			System.out.println("\n----- Menú Gestionar Vendedores -----");
			System.out.println("1. Alta Vendedor");
			System.out.println("2. Baja Vendedor");
			System.out.println("3. Modificar Sueldo");
			System.out.println("4. Modificar Datos del Vendedor");
			System.out.println("5. Listar Vendedores");
			System.out.println("6. Listar Vendedores por Departamento");
			System.out.println("7. Listar Vendedores por Categoría");
			System.out.println("0. Volver al Menú Principal");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				gestionVendedores2.altaVendedor();
				break;
			case 2:
				gestionVendedores2.bajaVendedor();
				break;
			case 3:
				gestionVendedores2.modificarSueldo();
				break;
			case 4:
				gestionVendedores2.modificarDatosVendedor();
				break;
			case 5:
				gestionVendedores2.listaVendedores();
				break;
			case 6:
				gestionVendedores2.vendedoresDepartamento();
				break;
			case 7:
				gestionVendedores2.vendedoresCategoria();
				break;
			case 0:
				System.out.println("Volviendo al Menú Principal...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
			}
		} while (opcion != 0);
	}

	public static void gestionVentasMenu(Gestion_Ventas2 gestionVentas2, Scanner scanner) {
		int opcion;
		do {
			System.out.println("\n----- Menú Gestionar Ventas -----");
			System.out.println("1. Realizar Venta");
			System.out.println("2. Consultar Ventas por Año");
			System.out.println("3. Consultar Ventas por DNI de Vendedor");
			System.out.println("4. Consultar Ventas por Tipo de Operación");
			System.out.println("5. Consultar Ventas por Tipo de Venta");
			System.out.println("0. Volver al Menú Principal");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				gestionVentas2.realizarVenta();
				break;
			case 2:
				gestionVentas2.consultarVentasAnio();
				break;
			case 3:
				gestionVentas2.consultarVentasPorDni();
				break;
			case 4:
				gestionVentas2.consultarVentasPorTipoOperacion();
				break;
			case 5:
				gestionVentas2.consultarVentasPorTipoVenta();
				break;
			case 0:
				System.out.println("Volviendo al Menú Principal...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
			}
		} while (opcion != 0);
	}
}



