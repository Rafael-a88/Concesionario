package ProyectoFinal;

public class Vehiculos implements IVehiculo {

	private String matricula;
	private String bastidor;
	private String marca;
	private String modelo;
	private int anyo;
	private Tipo_Vehiculos tipo_vehiculos;
	private Tipo_Motorizacion tipo_motorizacion;
	private int potencia;
	private double deposito;
	private int n_puertas;
	private double consumo;
	private String fecha_matricula;
	private String nive;
	private Etiqueta_Eco etiqueta_eco;
	
	public Vehiculos () {
		
	}

	public Vehiculos(String matricula, String bastidor, String marca, String modelo, int anyo,
			Tipo_Vehiculos tipo_vehiculos, Tipo_Motorizacion tipo_motorizacion, int potencia, double deposito, int n_puertas,
			double consumo, String fecha_matricula, String nive, Etiqueta_Eco etiqueta_eco) {
		
		this.matricula = matricula;
		this.bastidor = bastidor;
		this.marca = marca;
		this.modelo = modelo;
		this.anyo = anyo;
		this.tipo_vehiculos = tipo_vehiculos;
		this.tipo_motorizacion = tipo_motorizacion;
		this.potencia = potencia;
		this.deposito = deposito;
		this.n_puertas = n_puertas;
		this.consumo = consumo;
		this.fecha_matricula = fecha_matricula;
		this.nive = nive;
		this.etiqueta_eco = etiqueta_eco;
	}

	

	
	
	
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getBastidor() {
		return bastidor;
	}

	public void setBastidor(String bastidor) {
		this.bastidor = bastidor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public double getDeposito() {
		return deposito;
	}

	public void setDeposito(double deposito) {
		this.deposito = deposito;
	}

	public int getN_Puertas() {
		return n_puertas;
	}

	public void setN_Puertas(int n_puertas) {
		this.n_puertas = n_puertas;
	}


	public double getConsumo() {
		return consumo;
	}

	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}

	public String getFecha_Matricula() {
		return fecha_matricula;
	}

	public void setFecha_Matricula(String fecha_matricula) {
		this.fecha_matricula = fecha_matricula;
	}


	public String getNive() {
		return nive;
	}

	public void setNive(String nive) {
		this.nive = nive;
	}

	public Etiqueta_Eco getEtiqueta_Eco() {
		return etiqueta_eco;
	}

	public void setEtiqueta_Eco(Etiqueta_Eco etiqueta_eco) {
		this.etiqueta_eco = etiqueta_eco;
	}

	public Tipo_Vehiculos getTipo_Vehiculos() {
		return tipo_vehiculos;
	}
	
	public void setTipo_Vehiculos(Tipo_Vehiculos tipo_vehiculos) {
		this.tipo_vehiculos = tipo_vehiculos;
	}
	
	public Tipo_Motorizacion getTipo_Motorizacion() {
		return tipo_motorizacion;
	}
	
	public void setTipo_Motorizacion(Tipo_Motorizacion tipo_motorizacion) {
		this.tipo_motorizacion = tipo_motorizacion;
	}

	@Override
	public String toString() {
		return "Datos del vehículo:\n" +
				"Matrícula: " + matricula + "\n" +
				"Número de bastidor: " + bastidor + "\n" +
				"Marca: " + marca + "\n" +
				"Modelo: " + modelo + "\n" +
				"Año de producción: " + anyo + "\n" +
				"Tipo de vehículo: " + tipo_vehiculos + "\n" +
				"Motorización: " + tipo_motorizacion + "\n" +
				"Potencia: " + potencia + "\n" +
				"Tamaño de depósito: " + deposito + "\n" +
				"Número de puertas: " + n_puertas + "\n" +
				"Consumo a los 100km: " + consumo + "\n" +
				"Fecha de matriculación: " + fecha_matricula + "\n" +
				"NIVE: " + nive + "\n" +
				"Etiqueta Ecológica: " + etiqueta_eco;
	}

	

	

	

	

	
	
	
	
	
	
}
