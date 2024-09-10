package ProyectoFinal;

public class Vendedores extends Persona{

	
	private String categoria;
	private String departamento;
	private double sueldo_base;
	

	public Vendedores () {
	
	}
	
	public Vendedores (String nombre, String apellidos, String dni, String fechaNacimiento, int edad, char sexo, String direccion, String localidad, String provincia, int codigoPostal, String telefono, String correoElectronico, String categoria, String departamento, double sueldo_base) {
		super(nombre, apellidos, dni, fechaNacimiento, edad, sexo, direccion, localidad, provincia, codigoPostal, telefono, correoElectronico);
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public double getSueldo() {
		return sueldo_base;
	}

	public void setSueldo(double sueldo) {
		sueldo_base = sueldo;
	}

	@Override
	public String toString() {
		return "Vendedores [categoria=" + categoria + ", departamento=" + departamento + ", sueldo_base=" + sueldo_base
				+ ", getNombre()=" + getNombre() + ", getApellidos()=" + getApellidos() + ", getDni()=" + getDni()
				+ ", getFechaNacimiento()=" + getFechaNacimiento() + ", getEdad()=" + getEdad() + ", getSexo()="
				+ getSexo() + ", getDireccion()=" + getDireccion() + ", getLocalidad()=" + getLocalidad()
				+ ", getProvincia()=" + getProvincia() + ", getCodigoPostal()=" + getCodigoPostal() + ", getTelefono()="
				+ getTelefono() + ", getCorreoElectronico()=" + getCorreoElectronico() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
	
}
