package ProyectoFinal;

public interface IVehiculo {

	public String getMatricula();
    public String getBastidor();
    public String getMarca();
    public String getModelo();
    public int getAnyo();
    public Tipo_Vehiculos getTipo_Vehiculos();
    public Tipo_Motorizacion getTipo_Motorizacion();
    public int getPotencia();
    public double getDeposito();
    public int getN_Puertas();
    public double getConsumo();
    public String getFecha_Matricula();
    public String getNive();
    public Etiqueta_Eco getEtiqueta_Eco();
}
