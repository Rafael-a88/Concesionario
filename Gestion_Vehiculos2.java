package ProyectoFinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Gestion_Vehiculos2 {

	private Scanner miScan = new Scanner(System.in);
	private Scanner miScan2 = new Scanner(System.in);

	Vehiculos miVehiculo = new Vehiculos();

	public void altaVehiculo() {

		System.out.println("Introduce la matrícula del vehículo:");
		miVehiculo.setMatricula(miScan.nextLine());

		System.out.println("Introduce el número de bastidor:");
		miVehiculo.setBastidor(miScan.nextLine());

		System.out.println("Introduce la marca del vehículo:");
		miVehiculo.setMarca(miScan.nextLine());

		System.out.println("Introduce el modelo del vehículo:");
		miVehiculo.setModelo(miScan.nextLine());

		System.out.println("Introduce el año de producción del vehículo:");
		miVehiculo.setAnyo(miScan2.nextInt());
		miScan2.nextLine();

		System.out.println("Introduce el tipo de vehículo (AUTOMOVIL, MOTOCICLETA, CICLOMOTOR, FURGONETA, CAMION):");
		miVehiculo.setTipo_Vehiculos(Tipo_Vehiculos.valueOf(miScan.nextLine().toUpperCase()));

		System.out.println(
				"Introduce la motorización del vehículo (GASOLINA, DIESEL, HIBRIDO, HIBRIDOENCHUFABLE, ELECTRICO, GLP, HIDROGENO):");
		miVehiculo.setTipo_Motorizacion(Tipo_Motorizacion.valueOf(miScan.nextLine().toUpperCase()));

		System.out.println("Introduce la potencia del vehículo:");
		miVehiculo.setPotencia(miScan2.nextInt());
		miScan2.nextLine();

		System.out.println("Introduce el tamaño del depósito del vehículo:");
		miVehiculo.setDeposito(miScan2.nextDouble());
		miScan2.nextLine();

		System.out.println("Introduce el número de puertas del vehículo:");
		miVehiculo.setN_Puertas(miScan2.nextInt());
		miScan2.nextLine();

		System.out.println("Introduce el consumo a los 100km del vehículo:");
		miVehiculo.setConsumo(miScan2.nextDouble());
		miScan2.nextLine();

		System.out.println("Introduce la fecha de matriculación del vehículo (formato dd/MM/yyyy):");
		miVehiculo.setFecha_Matricula(miScan.nextLine());
		System.out.println();

		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 32; i++) {
			int num = random.nextInt(10);
			sb.append(num);
		}
		String mirandom = sb.toString();
		System.out.println("Tu NIVE: " + mirandom);
		miVehiculo.setNive(mirandom);
		System.out.println();

		System.out.println("Introduce la etiqueta ecológica del vehículo (0, ECO, C, B, A):");
		miVehiculo.setEtiqueta_Eco(Etiqueta_Eco.valueOf(miScan.nextLine().toUpperCase()));

		String mysql = "INSERT INTO vehiculo (matricula, bastidor, marca, modelo, anyo, tipo_vehiculo, motorizacion, "
				+ "potencia, deposito, n_puertas, consumo, fecha_matricula, nive, etiqueta_eco) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(mysql)) {

			pstmt.setString(1, miVehiculo.getMatricula());
			pstmt.setString(2, miVehiculo.getBastidor());
			pstmt.setString(3, miVehiculo.getMarca());
			pstmt.setString(4, miVehiculo.getModelo());
			pstmt.setInt(5, miVehiculo.getAnyo());
			pstmt.setString(6, miVehiculo.getTipo_Vehiculos().toString());
			pstmt.setString(7, miVehiculo.getTipo_Motorizacion().toString());
			pstmt.setInt(8, miVehiculo.getPotencia());
			pstmt.setDouble(9, miVehiculo.getDeposito());
			pstmt.setInt(10, miVehiculo.getN_Puertas());
			pstmt.setDouble(11, miVehiculo.getConsumo());
			pstmt.setString(12, miVehiculo.getFecha_Matricula());
			pstmt.setString(13, miVehiculo.getNive());
			pstmt.setString(14, miVehiculo.getEtiqueta_Eco().toString());

			pstmt.executeUpdate();
			System.out.println("Vehículo añadido con éxito.");
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error al añadir el vehículo a la base de datos.");
			e.printStackTrace();
		}
	}

	public void consultarVehiculo() {
		System.out.println("Introduce la matrícula del vehículo a consultar:");
		String matricula = miScan.nextLine();

		String sql = "SELECT * FROM vehiculo WHERE matricula = ?";

		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, matricula);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				miVehiculo.setMatricula(rs.getString("matricula"));
				miVehiculo.setBastidor(rs.getString("bastidor"));
				miVehiculo.setMarca(rs.getString("marca"));
				miVehiculo.setModelo(rs.getString("modelo"));
				miVehiculo.setAnyo(rs.getInt("anyo"));
				miVehiculo.setTipo_Vehiculos(Tipo_Vehiculos.valueOf(rs.getString("tipo_vehiculo").toUpperCase()));
				miVehiculo.setTipo_Motorizacion(Tipo_Motorizacion.valueOf(rs.getString("motorizacion").toUpperCase()));
				miVehiculo.setPotencia(rs.getInt("potencia"));
				miVehiculo.setDeposito(rs.getDouble("deposito"));
				miVehiculo.setN_Puertas(rs.getInt("n_puertas"));
				miVehiculo.setConsumo(rs.getDouble("consumo"));
				miVehiculo.setFecha_Matricula(rs.getString("fecha_matricula"));
				miVehiculo.setNive(rs.getString("nive"));
				miVehiculo.setEtiqueta_Eco(Etiqueta_Eco.valueOf(rs.getString("etiqueta_eco").toUpperCase()));

				System.out.println();
				System.out.println("Datos del vehículo con matrícula " + miVehiculo.getMatricula() + ":");
				System.out.println("Número de bastidor: " + miVehiculo.getBastidor());
				System.out.println("Marca: " + miVehiculo.getMarca());
				System.out.println("Modelo: " + miVehiculo.getModelo());
				System.out.println("Año de producción: " + miVehiculo.getAnyo());
				System.out.println("Tipo de vehículo: " + miVehiculo.getTipo_Vehiculos());
				System.out.println("Motorización: " + miVehiculo.getTipo_Motorizacion());
				System.out.println("Potencia: " + miVehiculo.getPotencia());
				System.out.println("Tamaño del depósito: " + miVehiculo.getDeposito());
				System.out.println("Número de puertas: " + miVehiculo.getN_Puertas());
				System.out.println("Consumo a los 100km: " + miVehiculo.getConsumo());
				System.out.println("Fecha de matriculación: " + miVehiculo.getFecha_Matricula());
				System.out.println("NIVE: " + miVehiculo.getNive());
				System.out.println("Etiqueta ecológica: " + miVehiculo.getEtiqueta_Eco());
				System.out.println();
			} else {
				System.out.println("Vehículo no encontrado con la matrícula proporcionada.");
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("NO PUEDEN HABER CAMPOS NULL.");

		}
	}

	public void bajaVehiculo() {
		System.out.println("Introduce la matrícula del vehículo a eliminar:");
		String matricula = miScan.nextLine();

		String mysql = "DELETE FROM vehiculo WHERE matricula = ?";

		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(mysql)) {

			pstmt.setString(1, matricula);

			int registro = pstmt.executeUpdate();

			if (registro > 0) {
				System.out.println("Vehículo con matrícula " + matricula + " eliminado con éxito.");
			} else {
				System.out.println("Vehículo no encontrado con la matrícula proporcionada.");
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error al intentar eliminar el vehículo.");
			e.printStackTrace();
		}
	}

	public void modificarVehiculo() {

		System.out.println("Introduce la matrícula del vehículo a modificar:");
		String matricula = miScan.nextLine();

		System.out.println(
				"¿Qué campo deseas modificar? (bastidor, marca, modelo, anyo, tipo_vehiculo, motorizacion, potencia, deposito, n_puertas, consumo, fecha_matricula, nive, etiqueta_eco):");
		String campo = miScan.nextLine();

		System.out.println("Introduce el nuevo valor para " + campo + ":");
		String nuevoValor = miScan.nextLine();

		String sql = "UPDATE vehiculo SET " + campo + " = ? WHERE matricula = ?";

		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, nuevoValor);
			pstmt.setString(2, matricula);

			int registrosModificados = pstmt.executeUpdate();

			if (registrosModificados > 0) {
				System.out
						.println("Vehículo con matrícula " + matricula + " modificado con éxito en el campo " + campo);
			} else {
				System.out.println(
						"No se encontró un vehículo con la matrícula proporcionada o no se pudo modificar el campo.");
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error al intentar modificar el vehículo.");
			e.printStackTrace();
		}
	}

	public void listarVehiculos() {
    String sql = "SELECT * FROM vehiculo";

    try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
          
            System.out.println("Matrícula: " + rs.getString("matricula"));
            System.out.println("Número de bastidor: " + rs.getString("bastidor"));
            System.out.println("Marca: " + rs.getString("marca"));
            System.out.println("Modelo: " + rs.getString("modelo"));
            System.out.println("Año de producción: " + rs.getInt("anyo"));
            System.out.println("Tipo de vehículo: " + rs.getString("tipo_vehiculo"));
            System.out.println("Motorización: " + rs.getString("motorizacion"));
            System.out.println("Potencia: " + rs.getInt("potencia") + " CV");
            System.out.println("Tamaño del depósito: " + rs.getDouble("deposito") + " litros");
            System.out.println("Número de puertas: " + rs.getInt("n_puertas"));
            System.out.println("Consumo a los 100km: " + rs.getDouble("consumo") + " litros");
            System.out.println("Fecha de matriculación: " + rs.getString("fecha_matricula"));
            System.out.println("NIVE: " + rs.getString("nive"));
            System.out.println("Etiqueta ecológica: " + rs.getString("etiqueta_eco"));
            System.out.println("-------------------------------------------");
        }
        
       
        conn.close();
    } catch (SQLException e) {
        System.out.println("Error al listar los vehículos.");
        e.printStackTrace();
    }
}

}
