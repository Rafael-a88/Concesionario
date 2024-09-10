package ProyectoFinal;

public class DatosBancarios {

	private Cliente titular;
	private String entidad;
	private String cuenta_iban;
	private String provincia;
	
	public DatosBancarios() {
		
	}

	public DatosBancarios(Cliente titular, String entidad, String cuenta_iban, String provincia) {
		
		this.titular = titular;
		this.entidad = entidad;
		this.cuenta_iban = cuenta_iban;
		this.provincia = provincia;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getCuenta_iban() {
		return cuenta_iban;
	}

	public void setCuenta_iban(String cuenta_iban) {
		this.cuenta_iban = cuenta_iban;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	
	
}
