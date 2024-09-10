package ProyectoFinal;

public class Cliente implements IClientes {

	private String nombre;
	private String apellidos;
	private String dni;
	private String fecha_nacimiento;
	private int edad;
	private char sexo;
	private String direccion;
	private String localidad;
	private String provincia;
	private int cod_postal;
	private String telefono;
	private String correo_e;
	private String cuenta_bancaria;
	private String fecha_alta;
	private String mayor_edad;
	private String representante_dni;
	
	public Cliente() {
		
	}
	
	public Cliente(String nombre, String apellidos, String dNI, String fechaNacimiento, int edad, char sexo, String direccion,
			String localidad, String provincia, int codigoPostal, String telefono, String correoElectronico,
			String cuenta_bancaria, String fecha_alta, String mayor_edad, String representante_dni) {
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dNI;
		this.fecha_nacimiento = fechaNacimiento;
		this.edad = edad;
		this.sexo = sexo;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.cod_postal = codigoPostal;
		this.telefono = telefono;
		this.correo_e = correoElectronico;
		this.cuenta_bancaria = cuenta_bancaria;
		this.fecha_alta = fecha_alta;
		this.mayor_edad = mayor_edad;
		this.representante_dni = representante_dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellidos;
	}


	public void setApellido(String apellido) {
		this.apellidos = apellido;
	}

	public String getDNI() {
		return dni;
	}


	public void setDNI(String dNI) {
		this.dni = dNI;
	}


	public String getFechaNacimiento() {
		return fecha_nacimiento;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fecha_nacimiento = fechaNacimiento;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public char getSexo() {
		return sexo;
	}


	public void setSexo(char sexo) {
		this.sexo = sexo;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public int getCodigoPostal() {
		return cod_postal;
	}


	public void setCodigoPostal(int codigoPostal) {
		cod_postal = codigoPostal;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getCorreoElectronico() {
		return correo_e;
	}


	public void setCorreoElectronico(String correoElectronico) {
		correo_e = correoElectronico;
	}


	public String getDatosBancarios() {
		return cuenta_bancaria;
	}


	public void setDatosBancarios(String cuenta_bancaria) {
		this.cuenta_bancaria = cuenta_bancaria;
	}


	public String getFechaRegistro() {
		return fecha_alta;
	}


	public void setFechaRegistro(String fechaRegistro) {
		fecha_alta = fechaRegistro;
	}


	public String isMayorEdad() {
		return mayor_edad;
	}


	public void setMayorEdad(String mayorEdad) {
		mayor_edad = mayorEdad;
	}


	public String getRepresentante() {
		return representante_dni;
	}


	public void setRepresentante(String representante) {
		representante_dni = representante;
	}


	
	
	
	
	
	

}
