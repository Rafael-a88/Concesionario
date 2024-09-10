package ProyectoFinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Gestion_DatosBancarios {
	Scanner miScan = new Scanner(System.in);

	public String agregarCuentaBancaria() {

		System.out.println("Introduce el titular de la cuenta: ");
		String titular = miScan.nextLine();

		System.out.print("Introduce la entidad: ");
		String entidad = miScan.nextLine();

		System.out.print("Introduce la provincia: ");
		String provincia = miScan.nextLine();

		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 22; i++) {
			sb.append(random.nextInt(10));
		}
		String cuenta_iban = "ES" + sb.toString();
		System.out.println("IBAN generado: " + cuenta_iban);

		String mysql = "INSERT INTO cuentabancaria (entidad,titular, cuenta_iban, provincia) VALUES (?, ?, ?, ?)";

		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(mysql)) {

			pstmt.setString(1, entidad);
			pstmt.setNString(2, titular);
			pstmt.setString(3, cuenta_iban);
			pstmt.setString(4, provincia);

			int registros = pstmt.executeUpdate();

			if (registros > 0) {
				System.out.println("Cuenta bancaria agregada con éxito.");
			} else {
				System.out.println("No se pudo agregar la cuenta bancaria.");
			}
			
		} catch (SQLException e) {
			System.out.println("Error al agregar la cuenta bancaria a la base de datos.");
			e.printStackTrace();
		}
		return cuenta_iban;
	}
}
