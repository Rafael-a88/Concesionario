package ProyectoFinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Gestion_Ventas2 {

	Gestion_Vehiculos2 miVehiculo = new Gestion_Vehiculos2();
	Gestion_Vendedores2 miVendedor = new Gestion_Vendedores2();

	Scanner miScan = new Scanner(System.in);
	Scanner miScan2 = new Scanner(System.in);

	

	public void realizarVenta() {

		System.out.println("Introduce un id de venta");
		int idventa = miScan2.nextInt();
		miScan2.nextLine();
		boolean idExistente = verificarIdVenta(idventa);
		while (idExistente) {
			System.out.println(
					"El Id introducido ya esta en uso, elige otro Id diferente, te muestro las ventas y los ID ya elegidos");
			listarVentas();
			System.out.println("Introduce un id de venta");
			idventa = miScan2.nextInt();

			idExistente = verificarIdVenta(idventa);
		}

		Gestion_Vehiculos2 mivehiculo = new Gestion_Vehiculos2();
		mivehiculo.listarVehiculos();
		System.out.println("Introduce la matrícula del vehículo:");
		String vehiculo = miScan.nextLine();

		Gestion_Clientes2 miCliente = new Gestion_Clientes2();
		miCliente.listarTodosLosClientes();
		System.out.println("Introduce el DNI del cliente:");
		String cliente = miScan.nextLine();

		Gestion_Vendedores2 miVendedor = new Gestion_Vendedores2();
		miVendedor.listaVendedores();
		System.out.println("Introduce el DNI del vendedor:");
		String vendedor = miScan.nextLine();

		System.out.println("Introduce la fecha de operación (DD/MM/YYYY):");
		String fecha_opera_str = miScan.nextLine();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date fecha_opera = null;
		try {
			java.util.Date parsed = format.parse(fecha_opera_str);
			fecha_opera = new java.sql.Date(parsed.getTime());
		} catch (ParseException e) {
			System.out.println("Formato de fecha no válido. Por favor, use el formato DD/MM/YYYY.");
			return;
		}

		System.out.println("Introduce el tipo de operación (VENTA, RENTING, LEASING, ALQUILER, OTRO):");
		Tipo_Operacion tipo_operacion = Tipo_Operacion.valueOf(miScan.nextLine().toUpperCase());

		System.out.println("Introduce el tipo de venta (NUEVO, SEMINUEVO, USADO, DEMO, OTRO):");
		Tipo_Venta tipo_venta = Tipo_Venta.valueOf(miScan.nextLine().toUpperCase());

		System.out.println("Asignando cuenta bancaria, tiene que ser la misma que utiliza el cliente");
		String cuenta_bancaria = miCliente.obtenerCuentaBancariaPorDNI(cliente);
		System.out.println();

		String mysql = "INSERT INTO venta (idventa, vehiculo, cliente, vendedor, cuenta_bancaria, fecha_opera, tipo_operacion, tipo_venta) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(mysql)) {

			pstmt.setInt(1, idventa);
			pstmt.setString(2, vehiculo);
			pstmt.setString(3, cliente);
			pstmt.setString(4, vendedor);
			pstmt.setString(5, cuenta_bancaria);
			pstmt.setDate(6, fecha_opera);
			pstmt.setString(7, tipo_operacion.toString());
			pstmt.setString(8, tipo_venta.toString());

			int registros = pstmt.executeUpdate();
			if (registros > 0) {
				System.out.println("Venta realizada con éxito.");
			} else {
				System.out.println("No se pudo realizar la venta.");
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error al intentar realizar la venta. Intentelo de nuevo.");

		}
	}

	public void consultarVentasAnio() {

		System.out.println("Introduce el año de las ventas que deseas consultar:");
		int anio = miScan.nextInt();

		String mysql = "SELECT * FROM venta WHERE YEAR(fecha_opera) = ?";

		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(mysql)) {

			pstmt.setInt(1, anio);
			ResultSet rs = pstmt.executeQuery();

			boolean hayVentas = false;
			while (rs.next()) {
				hayVentas = true;
				imprimirVenta(rs);
			}

			if (!hayVentas) {
				System.out.println("No se encontraron ventas para el año " + anio + ".");
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error al intentar consultar las ventas por año.");
			e.printStackTrace();
		}
	}

	public void consultarVentasPorDni() {
		System.out.println("Introduce el DNI del vendedor para consultar sus ventas:");
		String dniVendedor = miScan.nextLine();

		String mysql = "SELECT * FROM venta WHERE vendedor = ?";

		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(mysql)) {

			pstmt.setString(1, dniVendedor);
			ResultSet rs = pstmt.executeQuery();

			boolean hayVentas = false;
			while (rs.next()) {
				hayVentas = true;
				imprimirVenta(rs);
			}

			if (!hayVentas) {
				System.out.println("No se encontraron ventas para el vendedor con DNI " + dniVendedor + ".");
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error al intentar consultar las ventas por DNI del cliente.");
			e.printStackTrace();
		}
	}

	public void consultarVentasPorTipoOperacion() {
		System.out.println("Introduce el tipo de operacion a consultar: VENTA, RENTING, LEASING, ALQUILER, OTRO ");
		String tipoOperacion = miScan.nextLine();

		String mysql = "SELECT * FROM venta WHERE tipo_operacion = ?";

		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(mysql)) {

			pstmt.setString(1, tipoOperacion);
			ResultSet rs = pstmt.executeQuery();

			boolean hayVentas = false;
			while (rs.next()) {
				hayVentas = true;
				imprimirVenta(rs);
			}

			if (!hayVentas) {
				System.out.println("No se encontraron ventas para el tipo de operación " + tipoOperacion + ".");
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error al intentar consultar las ventas por DNI del cliente.");
			e.printStackTrace();
		}
	}

	public void consultarVentasPorTipoVenta() {

		System.out.println("Introduce el tipo de operacion a consultar: NUEVO, SEMINUEVO, USADO, DEMO, OTRO ");
		String tipoVenta = miScan.nextLine();

		String mysql = "SELECT * FROM venta WHERE tipo_venta = ?";

		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(mysql)) {

			pstmt.setString(1, tipoVenta);
			ResultSet rs = pstmt.executeQuery();

			boolean hayVentas = false;
			while (rs.next()) {
				hayVentas = true;
				imprimirVenta(rs);
			}

			if (!hayVentas) {
				System.out.println("No se encontraron ventas para el tipo de operación " + tipoVenta + ".");
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error al intentar consultar las ventas por DNI del cliente.");
			e.printStackTrace();
		}
	}

	public void listarVentas() {

		String mysql = "SELECT * FROM venta";

		try (Connection conn = Conexion.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(mysql);
				ResultSet rs = pstmt.executeQuery()) {

			int contador = 0;
			while (rs.next()) {
				contador++;
				System.out.println("Venta #" + contador + ":");
				imprimirVenta(rs);
				System.out.println();
			}

			if (contador == 0) {
				System.out.println("No hay clientes registrados en la base de datos.");
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error al listar los clientes.");
			e.printStackTrace();
		}
	}

	public void imprimirVenta(ResultSet rs) throws SQLException {
		System.out.println("ID Venta: " + rs.getInt("idventa"));
		System.out.println("Vehículo: " + rs.getString("vehiculo"));
		System.out.println("Cliente: " + rs.getString("cliente"));
		System.out.println("Vendedor: " + rs.getString("vendedor"));
		System.out.println("Cuenta Bancaria: " + rs.getString("cuenta_bancaria"));
		System.out.println("Fecha de Operación: " + rs.getDate("fecha_opera"));
		System.out.println("Tipo de Operación: " + rs.getString("tipo_operacion"));
		System.out.println("Tipo de Venta: " + rs.getString("tipo_venta"));
		System.out.println();
	}

	public boolean verificarIdVenta(int idventa) {
		String sql = "SELECT COUNT(*) FROM venta WHERE idventa = ?";

		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, idventa);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) > 0;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error al verificar el ID de la venta.");
			e.printStackTrace();
		}
		return false;
	}
}
