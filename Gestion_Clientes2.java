package ProyectoFinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Gestion_Clientes2 {

	private Scanner miScan = new Scanner(System.in);
	private Scanner miScan2 = new Scanner(System.in);

	Cliente miCliente = new Cliente();

	Gestion_DatosBancarios gestionBanco = new Gestion_DatosBancarios();

	public void altaCliente() {
    System.out.println("Introduzca los datos del nuevo cliente:");
    
    String nombre = "";
    while (nombre.isEmpty() || contieneNumeros(nombre)) {
        System.out.print("Nombre: ");
        nombre = miScan.nextLine();
        if (contieneNumeros(nombre)) {
            System.out.println("El nombre no puede contener números. Inténtelo de nuevo.");
        }
    }
    miCliente.setNombre(nombre);

    String apellidos = "";
    while (apellidos.isEmpty() || contieneNumeros(apellidos)) {
        System.out.print("Apellidos: ");
        apellidos = miScan.nextLine();
        if (contieneNumeros(apellidos)) {
            System.out.println("Los apellidos no pueden contener números. Inténtelo de nuevo.");
        }
    }
    miCliente.setApellido(apellidos);

 
    String dni = "";
    while (!validarDNI(dni)) {
        System.out.print("DNI (8 números seguidos de una letra): ");
        dni = miScan.nextLine();
        if (!validarDNI(dni)) {
            System.out.println("El DNI debe contener 8 números seguidos de una letra. Inténtelo de nuevo.");
        }
    }
    miCliente.setDNI(dni);

    String fechaNacimiento = "";
    while (!validarFormatoFecha(fechaNacimiento)) {
        System.out.print("Fecha de nacimiento (DD/MM/YYYY): ");
        fechaNacimiento = miScan.nextLine();
        if (!validarFormatoFecha(fechaNacimiento)) {
            System.out.println("El formato de fecha debe ser DD/MM/YYYY. Inténtelo de nuevo.");
        }
    }
    miCliente.setFechaNacimiento(fechaNacimiento);

   
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
    miCliente.setEdad(edad);
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
    miCliente.setSexo(sexo);

    System.out.print("Dirección: ");
    miCliente.setDireccion(miScan.nextLine());

    String localidad = "";
    while (!soloLetras(localidad)) {
        System.out.print("Localidad: ");
        localidad = miScan.nextLine();
        if (!soloLetras(localidad)) {
            System.out.println("La localidad solo puede contener letras. Inténtelo de nuevo.");
        }
    }  
    miCliente.setLocalidad(localidad);

    String provincia = "";
    while (!soloLetras(provincia)) {
        System.out.print("Provincia: ");
        provincia = miScan.nextLine();
        if (!soloLetras(provincia)) {
            System.out.println("La provincia solo puede contener letras. Inténtelo de nuevo.");
        }
    }
    miCliente.setProvincia(provincia);

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
    miCliente.setCodigoPostal(codigoPostal);
    miScan2.nextLine(); 

    String telefono = "";
    while (telefono.length() != 9 || !esNumero(telefono)) {
        System.out.print("Teléfono móvil (9 dígitos): ");
        telefono = miScan.nextLine();
        if (telefono.length() != 9 || !esNumero(telefono)) {
            System.out.println("El teléfono móvil debe contener exactamente 9 dígitos numéricos. Inténtelo de nuevo.");
        }
    }
    miCliente.setTelefono(telefono);

    String correoElectronico = "";
    while (!correoElectronico.contains("@")) {
        System.out.print("Correo Electrónico: ");
        correoElectronico = miScan.nextLine();
        if (!correoElectronico.contains("@")) {
            System.out.println("El correo electrónico debe contener el símbolo '@'. Inténtelo de nuevo.");
        }
    }
    miCliente.setCorreoElectronico(correoElectronico);

    System.out.println("Cuenta Bancaria: ");
    miCliente.setDatosBancarios(gestionBanco.agregarCuentaBancaria());

    String fechaAlta = "";
    while (!validarFormatoFecha(fechaAlta)) {
        System.out.print("Fecha de alta (DD/MM/YYYY): ");
        fechaAlta = miScan.nextLine();
        if (!validarFormatoFecha(fechaAlta)) {
            System.out.println("El formato de fecha debe ser DD/MM/YYYY. Inténtelo de nuevo.");
        }
    }
    miCliente.setFechaRegistro(fechaAlta);

    
    String esMayorEdad = miCliente.getEdad() >= 18 ? "S" : "N";
    
    String dniRepresentante = null; 
    if ("N".equals(esMayorEdad)) {
        System.out.print("DNI del Representante: ");
        dniRepresentante = miScan.nextLine();
        
       
        if (!dniRepresentante(dniRepresentante)) {
            System.out.println("El DNI del representante no está registrado como cliente. Por favor, registre primero al representante.");
            return; 
        }
    }
    String mysql = "INSERT INTO cliente (dni, nombre, apellidos, fecha_nacimiento, edad, sexo, direccion, localidad, provincia, cod_postal, telefono, correo_e, cuenta_bancaria, fecha_alta, mayor_edad, representante_dni) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(mysql)) {
        pstmt.setString(1, miCliente.getDNI());
        pstmt.setString(2, miCliente.getNombre());
        pstmt.setString(3, miCliente.getApellido());
        pstmt.setString(4, miCliente.getFechaNacimiento());
        pstmt.setInt(5, miCliente.getEdad());
        pstmt.setString(6, String.valueOf(miCliente.getSexo()));
        pstmt.setString(7, miCliente.getDireccion());
        pstmt.setString(8, miCliente.getLocalidad());
        pstmt.setString(9, miCliente.getProvincia());
        pstmt.setInt(10, miCliente.getCodigoPostal());
        pstmt.setString(11, miCliente.getTelefono());
        pstmt.setString(12, miCliente.getCorreoElectronico());
        pstmt.setString(13, miCliente.getDatosBancarios());
        pstmt.setString(14, miCliente.getFechaRegistro());
        pstmt.setString(15, esMayorEdad);
        pstmt.setString(16, dniRepresentante);

        pstmt.executeUpdate();
        System.out.println("Cliente añadido con éxito.");
    } catch (SQLException e) {
        System.out.println("Error al añadir el cliente a la base de datos.");
        e.printStackTrace();
    }
}
	
	private boolean dniRepresentante(String dni) {
    String query = "SELECT COUNT(*) FROM cliente WHERE dni = ?";
    
    try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setString(1, dni);
        
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al verificar el DNI del representante en la base de datos.");
        e.printStackTrace();
    }
    
    return false;
}

	public void consultarCliente() {

		System.out.println("Introduce el dni del cliente a consultar");
		String dniCliente = miScan.nextLine();

		String mysql = "SELECT * FROM cliente WHERE dni = ?";

		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(mysql)) {

			pstmt.setString(1, dniCliente);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				imprimirDatosCliente(rs);
			} else {
				System.out.println("Cliente con DNI " + dniCliente + " no encontrado.");
			}
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error al consultar el cliente en la base de datos.");
			e.printStackTrace();
		}
	}

	public void asignarCuentaBancaria() {

		System.out.println("Introduce el DNI del cliente a quien deseas asignar una cuenta bancaria:");
		String dniCliente = miScan.nextLine();

		System.out.println("Introduce los siguientes datos:");
		String cuentaAsignada = gestionBanco.agregarCuentaBancaria();

		String mysql = "UPDATE cliente SET cuenta_bancaria = ? WHERE dni = ?";

		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(mysql)) {

			pstmt.setString(1, cuentaAsignada);
			pstmt.setString(2, dniCliente);

			int registros = pstmt.executeUpdate();

			if (registros > 0) {
				System.out.println("Cuenta bancaria asignada correctamente al cliente con DNI " + dniCliente);
			} else {
				System.out.println("No se encontró un cliente con el DNI proporcionado.");
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Ocurrió un error al intentar asignar la cuenta bancaria.");
			e.printStackTrace();
		}

	}

	public void listarTodosLosClientes() {

		String mysql = "SELECT * FROM cliente";

		try (Connection conn = Conexion.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(mysql);
				ResultSet rs = pstmt.executeQuery()) {

			int contador = 0;
			while (rs.next()) {
				contador++;
				System.out.println("Cliente #" + contador + ":");
				imprimirDatosCliente(rs);
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

	public void listarClientesMenoresDeEdad() {
		String mysql = "SELECT * FROM cliente WHERE mayor_edad = 'N'";

		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(mysql)) {

			ResultSet rs = pstmt.executeQuery();

			int contador = 0;
			if (rs.next()) {
				contador++;
				System.out.println("Cliente #" + contador + ":");
				imprimirDatosCliente(rs);
			}

			if (contador == 0) {
				System.out.println("No hay clientes menores de edad registrados en la base de datos.");
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error al consultar el cliente en la base de datos.");
			e.printStackTrace();
		}
	}

	public void listarClientesSegunAnoAlta() {

		System.out.println("Introduce el año para filtrar los clientes según la fecha de alta:");
		int anio = miScan.nextInt();

		String mysql = "SELECT * FROM cliente WHERE YEAR(STR_TO_DATE(fecha_alta, '%d/%m/%Y')) = ?";
		

		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(mysql)) {
			
			pstmt.setInt(1, anio);

			ResultSet rs = pstmt.executeQuery();

			int contador = 0;
			while (rs.next()) {
				contador++;
				System.out.println("Cliente #" + contador + ":");
				imprimirDatosCliente(rs);
				System.out.println();
			}

			if (contador == 0) {
				System.out.println("No hay clientes registrados en el año " + anio + ".");
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error al listar los clientes según el año de alta.");
			e.printStackTrace();
		}
	}

	public void modificarDatosCliente() {

		System.out.println("Introduce el DNI del cliente que deseas modificar:");
		String dniCliente = miScan.nextLine();

		System.out.println("¿Qué dato deseas modificar? (Introduce el nombre del campo):");
		String campoAModificar = miScan.nextLine();

		System.out.println("Introduce el nuevo valor para " + campoAModificar + ":");
		String nuevoValor = miScan.nextLine();

		if (campoAModificar.equalsIgnoreCase("representante_dni")) {
			if (nuevoValor.equalsIgnoreCase("null")) {
				System.out.println(
						"No se puede modificar este campo. Debe borrar el usuario y crearlo de nuevo. Ya que tiene asignada una foreign key");
				return;
			}

		}

		String mysql = "UPDATE cliente SET " + campoAModificar + " = ? WHERE dni = ?";

		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(mysql)) {

			pstmt.setString(1, nuevoValor);
			pstmt.setString(2, dniCliente);

			int registros = pstmt.executeUpdate();

			if (registros > 0) {
				System.out.println("Datos del cliente actualizados correctamente.");
			} else {
				System.out.println("No se encontró un cliente con el DNI proporcionado.");
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Ocurrió un error al intentar modificar los datos del cliente.");
			e.printStackTrace();
		}
	}

	public String obtenerCuentaBancariaPorDNI(String dni) {
		String cuentaBancaria = null;
		String mysql = "SELECT cuenta_bancaria FROM cliente WHERE dni = ?";

		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(mysql)) {

			pstmt.setString(1, dni);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				cuentaBancaria = rs.getString("cuenta_bancaria");
				if (cuentaBancaria == null) {
					System.out.println();
					System.err.println("Error el cliente no tiene una cuenta bancaria asignada");
					System.err.println(
							"Si quiere utilizar este cliente, previamente debe de tener una cuenta bancaria asignada.");
					System.err.println("Vaya a la gestion cliente para solucionar el problema");
					return null;
				}
			} else {
				System.out.println("Este DNI no está en la base de datos.");
				return null;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error al obtener la cuenta bancaria del cliente.");
			e.printStackTrace();
			return null;
		}

		return cuentaBancaria;
	}

	public void imprimirDatosCliente(ResultSet rs) throws SQLException {
		System.out.println("Datos del cliente:");
		System.out.println("DNI: " + rs.getString("dni"));
		System.out.println("Nombre: " + rs.getString("nombre"));
		System.out.println("Apellidos: " + rs.getString("apellidos"));
		System.out.println("Fecha de nacimiento: " + rs.getString("fecha_nacimiento"));
		System.out.println("Edad: " + rs.getInt("edad"));
		System.out.println("Sexo: " + rs.getString("sexo"));
		System.out.println("Dirección: " + rs.getString("direccion"));
		System.out.println("Localidad: " + rs.getString("localidad"));
		System.out.println("Provincia: " + rs.getString("provincia"));
		System.out.println("Código Postal: " + rs.getInt("cod_postal"));
		System.out.println("Teléfono: " + rs.getString("telefono"));
		System.out.println("Correo Electrónico: " + rs.getString("correo_e"));
		System.out.println("Cuenta Bancaria: " + rs.getString("cuenta_bancaria"));
		System.out.println("Fecha de Alta: " + rs.getString("fecha_alta"));
		System.out.println("Mayor de Edad: " + (rs.getString("mayor_edad").equals("S") ? "Sí" : "No"));
		System.out.println("DNI del Representante: " + rs.getString("representante_dni"));
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
