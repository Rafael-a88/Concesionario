package ProyectoFinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Gestion_Vendedores2 {

	private Scanner miScan = new Scanner(System.in);
	private Scanner miScan2 = new Scanner(System.in);

	Vendedores miVendedor= new Vendedores();

	public void altaVendedor() {

		System.out.println("Introduzca los datos del nuevo vendedor:");
		
		String nombre = "";
	    while (nombre.isEmpty() || contieneNumeros(nombre)) {
	        System.out.print("Nombre: ");
	        nombre = miScan.nextLine();
	        if (contieneNumeros(nombre)) {
	            System.out.println("El nombre no puede contener números. Inténtelo de nuevo.");
	        }
	    }
	    miVendedor.setNombre(nombre);

	    String apellidos = "";
	    while (apellidos.isEmpty() || contieneNumeros(apellidos)) {
	        System.out.print("Apellidos: ");
	        apellidos = miScan.nextLine();
	        if (contieneNumeros(apellidos)) {
	            System.out.println("Los apellidos no pueden contener números. Inténtelo de nuevo.");
	        }
	    }
	    miVendedor.setApellidos(apellidos);

		
	    String dni = "";
	    while (!validarDNI(dni)) {
	        System.out.print("DNI (8 números seguidos de una letra): ");
	        dni = miScan.nextLine();
	        if (!validarDNI(dni)) {
	            System.out.println("El DNI debe contener 8 números seguidos de una letra. Inténtelo de nuevo.");
	        }
	    }
	    miVendedor.setDni(dni);
		
	    String fechaNacimiento = "";
	    while (!validarFormatoFecha(fechaNacimiento)) {
	        System.out.print("Fecha de nacimiento (DD/MM/YYYY): ");
	        fechaNacimiento = miScan.nextLine();
	        if (!validarFormatoFecha(fechaNacimiento)) {
	            System.out.println("El formato de fecha debe ser DD/MM/YYYY. Inténtelo de nuevo.");
	        }
	    }
	    miVendedor.setFechaNacimiento(fechaNacimiento);
		
	    int edad = -1;
	    while (edad < 0) {
	        System.out.print("Edad: ");
	        if (miScan2.hasNextInt()) {
	            edad = miScan2.nextInt();
	            if (edad < 0) {
	                System.out.println("La edad no puede ser un valor negativo. Inténtelo de nuevo.");
	            }
	        } else {
	            System.out.println("Por favor, introduzca un número entero válido para la edad.");
	            miScan2.next(); 
	        }
	    }
	    miVendedor.setEdad(edad);
	    miScan2.nextLine(); 
		
	    char sexo = ' ';
	    while (sexo != 'M' && sexo != 'F') {
	        System.out.print("Sexo (M/F): ");
	        String inputSexo = miScan.nextLine().toUpperCase();
	        if (inputSexo.length() == 1 && (inputSexo.charAt(0) == 'M' || inputSexo.charAt(0) == 'F')) {
	            sexo = inputSexo.charAt(0);
	        } else {
	            System.out.println("Por favor, introduzca 'M' para masculino o 'F' para femenino.");
	        }
	    }
	    miVendedor.setSexo(sexo);

		
		System.out.print("Dirección: ");
		miVendedor.setDireccion(miScan.nextLine());
		
		String localidad = "";
	    while (!soloLetras(localidad)) {
	        System.out.print("Localidad: ");
	        localidad = miScan.nextLine();
	        if (!soloLetras(localidad)) {
	            System.out.println("La localidad solo puede contener letras. Inténtelo de nuevo.");
	        }
	    }
	    miVendedor.setLocalidad(localidad);
		
	    String provincia = "";
	    while (!soloLetras(provincia)) {
	        System.out.print("Provincia: ");
	        provincia = miScan.nextLine();
	        if (!soloLetras(provincia)) {
	            System.out.println("La provincia solo puede contener letras. Inténtelo de nuevo.");
	        }
	    }
	    miVendedor.setProvincia(provincia);
		
	    int codigoPostal = -1;
	    while (codigoPostal < 0 || String.valueOf(codigoPostal).length() != 5) {
	        System.out.print("Código Postal (5 dígitos): ");
	        if (miScan2.hasNextInt()) {
	            codigoPostal = miScan2.nextInt();
	            if (String.valueOf(codigoPostal).length() != 5) {
	                System.out.println("El código postal debe contener exactamente 5 dígitos. Inténtelo de nuevo.");
	            }
	        } else {
	            System.out.println("Por favor, introduzca un número entero válido para el código postal.");
	            miScan2.next(); 
	        }
	    }
	    miVendedor.setCodigoPostal(codigoPostal);
	    miScan2.nextLine(); 
		
	    String telefono = "";
	    while (telefono.length() != 9 || !esNumero(telefono)) {
	        System.out.print("Teléfono móvil (9 dígitos): ");
	        telefono = miScan.nextLine();
	        if (telefono.length() != 9 || !esNumero(telefono)) {
	            System.out.println("El teléfono móvil debe contener exactamente 9 dígitos numéricos. Inténtelo de nuevo.");
	        }
	    }
	    miVendedor.setTelefono(telefono);
		
	    String correoElectronico = "";
	    while (!correoElectronico.contains("@")) {
	        System.out.print("Correo Electrónico: ");
	        correoElectronico = miScan.nextLine();
	        if (!correoElectronico.contains("@")) {
	            System.out.println("El correo electrónico debe contener el símbolo '@'. Inténtelo de nuevo.");
	        }
	    }
	    miVendedor.setCorreoElectronico(correoElectronico);
		
	    String categoria = "";
	    while (!soloLetras(categoria)) {
	        System.out.print("Categoría: ");
	        categoria = miScan.nextLine();
	        if (!soloLetras(categoria)) {
	            System.out.println("La categoría solo puede contener letras. Inténtelo de nuevo.");
	        }
	    }
	    miVendedor.setCategoria(categoria);
		
	    String departamento = "";
	    while (!soloLetras(departamento)) {
	        System.out.print("Departamento: ");
	        departamento = miScan.nextLine();
	        if (!soloLetras(departamento)) {
	            System.out.println("La departamento solo puede contener letras. Inténtelo de nuevo.");
	        }
	    }
	    miVendedor.setDepartamento(departamento);
		
	    double sueldo = -1;
	    while (sueldo < 0) {
	        System.out.print("Sueldo base: ");
	        if (miScan2.hasNextDouble()) {
	            sueldo = miScan2.nextDouble();
	            if (sueldo < 0) {
	                System.out.println("El sueldo base no puede ser negativo. Inténtelo de nuevo.");
	            }
	        } else {
	            System.out.println("Por favor, introduzca un valor numérico válido para el sueldo base.");
	            miScan2.next(); 
	        }
	    }
	    miVendedor.setSueldo(sueldo);
	    miScan2.nextLine();

		String mysql = "INSERT INTO vendedor (dni, nombre, apellidos, fecha_nacimiento, edad, sexo, direccion,"
				+ " localidad, provincia, cod_postal, telefono, correo_e, categoria, departamento, sueldo_base) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(mysql)) {

			pstmt.setString(1, miVendedor.getDni());
			pstmt.setString(2, miVendedor.getNombre());
			pstmt.setString(3, miVendedor.getApellidos());
			pstmt.setString(4, miVendedor.getFechaNacimiento());
			pstmt.setInt(5, miVendedor.getEdad());
			pstmt.setString(6, String.valueOf(miVendedor.getSexo()));;
			pstmt.setString(7, miVendedor.getDireccion());
			pstmt.setString(8, miVendedor.getLocalidad());
			pstmt.setString(9, miVendedor.getProvincia());
			pstmt.setInt(10, miVendedor.getCodigoPostal());
			pstmt.setString(11, miVendedor.getTelefono());
			pstmt.setString(12, miVendedor.getCorreoElectronico());
			pstmt.setString(13, miVendedor.getCategoria());
			pstmt.setString(14, miVendedor.getDepartamento());
			pstmt.setDouble(15, miVendedor.getSueldo());

			pstmt.executeUpdate();
			System.out.println("Vendedor añadido con éxito.");
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error al añadir el vendedor a la base de datos.");
			e.printStackTrace();
		}
	}

	public void bajaVendedor() {
		System.out.println("Introduce la dni del vendedor a eliminar:");
		String dni = miScan.nextLine();

		String mysql = "DELETE FROM vendedor WHERE dni = ?";

		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(mysql)) {

			pstmt.setString(1, dni);

			int registro = pstmt.executeUpdate();

			if (registro > 0) {
				System.out.println("Vendedor con " + dni + " eliminado con éxito.");
			} else {
				System.out.println("Vendedor no encontrado con el dni proporcionada.");
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error al intentar eliminar el vendedor.");
			e.printStackTrace();
		}
	}

	public void modificarDatosVendedor() {
		System.out.println("Introduce la dni del vendedor a modificar:");
		String dni = miScan.nextLine();

		System.out.println(
				"¿Qué campo deseas modificar? (dni, nombre, apellidos, fecha_nacimiento, edad, sexo, direccion, localidad, provincia, cod_postal, telefono, correo_e, categoria, departamento, sueldo_base):");
		String campoAModificar = miScan.nextLine();

		System.out.println("Introduce el nuevo valor para " + campoAModificar + ":");
		String nuevoValor = miScan.nextLine();

		String sql = "UPDATE vendedor SET " + campoAModificar + " = ? WHERE dni = ?";

		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, nuevoValor);
			pstmt.setString(2, dni);

			int registrosModificados = pstmt.executeUpdate();

			if (registrosModificados > 0) {
				System.out.println("Vendedor con dni " + dni + " modificado con éxito en el campo " + campoAModificar);
			} else {
				System.out.println("No se encontró un vendedor con el dni proporcionada o no se pudo modificar el campo.");
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error al intentar modificar el vehículo.");
			e.printStackTrace();
		}
	}

	public void modificarSueldo() {
		System.out.println("Introduce el DNI del vendedor a modificar:");
		String dni = miScan.nextLine();

		String sqlConsulta = "SELECT sueldo_base FROM vendedor WHERE dni = ?";
		double sueldoActual = 0;

		try (Connection conn = Conexion.getConnection();
				PreparedStatement pstmtConsulta = conn.prepareStatement(sqlConsulta)) {
			pstmtConsulta.setString(1, dni);
			ResultSet rs = pstmtConsulta.executeQuery();

			if (rs.next()) {
				sueldoActual = rs.getDouble("sueldo_base");
				System.out.println("Sueldo actual del vendedor con DNI " + dni + ": " + sueldoActual);
			} else {
				System.out.println("No se encontró un vendedor con el DNI proporcionado.");
				return;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error al intentar consultar el sueldo actual del vendedor.");
			e.printStackTrace();
			return;
		}

		System.out.println("Introduce el nuevo valor para el sueldo del vendedor:");
		double nuevoValor = miScan2.nextDouble();

		String sqlUpdate = "UPDATE vendedor SET sueldo_base = ? WHERE dni = ?";

		try (Connection conn = Conexion.getConnection();
			PreparedStatement pstmtUpdate = conn.prepareStatement(sqlUpdate)) {
			pstmtUpdate.setDouble(1, nuevoValor);
			pstmtUpdate.setString(2, dni);

			int registrosModificados = pstmtUpdate.executeUpdate();

			if (registrosModificados > 0) {
				System.out.println("El sueldo del vendedor con DNI " + dni + " se ha modificado correctamente de "
						+ sueldoActual + " a " + nuevoValor);
			} else {
				System.out.println(
						"No se encontró un vendedor con el DNI proporcionado o no se pudo modificar el campo.");
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error al intentar modificar el sueldo del vendedor.");
			e.printStackTrace();
		}
	}

	public void listaVendedores() {
		
		String mysql = "SELECT * FROM vendedor";

		try (Connection conn = Conexion.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(mysql);
				ResultSet rs = pstmt.executeQuery()) {

			int contador = 1;
			while (rs.next()) {
				System.out.println();
				System.out.println("Vendedor " + contador + ":");
				imprimirDatosVendedores(rs);
				contador++;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error al intentar listar los vehículos.");
			e.printStackTrace();
		}
	}

	public void vendedoresDepartamento() {
		System.out.println("Introduzca el departamento para buscar a los vendedores:");
		String departamento = miScan.nextLine();
		int contador = 0;

		String sql = "SELECT * FROM vendedor WHERE departamento = ?";

		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, departamento);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				contador++;
				System.out.println();
				System.out.println("Vendedor "+ contador + ":");
				imprimirDatosVendedores(rs);

			}

			if (contador == 0) {
				System.out.println("No se encontraron vendedores en el departamento proporcionado.");
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error al intentar recuperar los vendedores del departamento.");
			e.printStackTrace();
		}
	}

	public void vendedoresCategoria() {
		System.out.println("Introduzca la categoria para buscar a los vendedores:");
		String categoria = miScan.nextLine();
		int contador = 0;

		String sql = "SELECT * FROM vendedor WHERE categoria = ?";

		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, categoria);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				contador++;
				System.out.println();
				System.out.println("Vendedor "+ contador + ":");
				imprimirDatosVendedores(rs);

			}

			if (contador == 0) {
				System.out.println("No se encontraron vendedores en el departamento proporcionado.");
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error al intentar recuperar los vendedores del departamento.");
			e.printStackTrace();
		}
	}

	public void imprimirDatosVendedores(ResultSet rs) throws SQLException {
    
    System.out.println("Datos del Vendedor:");
    System.out.println("DNI: " + rs.getString("dni"));
    System.out.println("Nombre: " + rs.getString("nombre"));
    System.out.println("Apellidos: " + rs.getString("apellidos"));
    System.out.println("Fecha de Nacimiento: " + rs.getString("fecha_nacimiento"));
    System.out.println("Edad: " + rs.getInt("edad"));
    System.out.println("Sexo: " + rs.getString("sexo")); 
    System.out.println("Dirección: " + rs.getString("direccion"));
    System.out.println("Localidad: " + rs.getString("localidad"));
    System.out.println("Provincia: " + rs.getString("provincia"));
    System.out.println("Código Postal: " + rs.getInt("cod_postal"));
    System.out.println("Teléfono: " + rs.getString("telefono"));
    System.out.println("Correo Electrónico: " + rs.getString("correo_e"));
    System.out.println("Categoría: " + rs.getString("categoria"));
    System.out.println("Departamento: " + rs.getString("departamento"));
    System.out.println("Sueldo Base: " + rs.getDouble("sueldo_base"));
    System.out.println("----------------------------------------");
}
	
	private boolean contieneNumeros(String cadena) {
	    for (char c : cadena.toCharArray()) {
	        if (Character.isDigit(c)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	private boolean validarDNI(String dni) {
	    if (dni.length() != 9) {
	        return false;
	    }

	    String numeros = dni.substring(0, 8);
	    String letra = dni.substring(8);

	    return numeros.matches("\\d{8}") && letra.matches("[a-zA-Z]");
	}

	private boolean validarFormatoFecha(String fecha) {
	    if (fecha.length() != 10) {
	        return false;
	    }

	    String[] partesFecha = fecha.split("/");
	    if (partesFecha.length != 3) {
	        return false;
	    }

	    try {
	        int dia = Integer.parseInt(partesFecha[0]);
	        int mes = Integer.parseInt(partesFecha[1]);
	        int anio = Integer.parseInt(partesFecha[2]);

	      
	        if (dia < 1 || dia > 31 || mes < 1 || mes > 12) {
	            return false;
	        }

	        

	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	private boolean soloLetras(String cadena) {
	    for (char c : cadena.toCharArray()) {
	        if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
	            return false;
	        }
	    }
	    return true;
	}
	
	private boolean esNumero(String cadena) {
	    return cadena.matches("\\d+");
	}
}
