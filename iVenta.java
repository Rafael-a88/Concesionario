package ProyectoFinal;

import java.time.LocalDate;

public interface iVenta {

	public int getIdventa();
	public String getCliente();
	public String getVendedores();
	public String getCuenta_bancaria();
	public LocalDate getFecha_opera();
	public Tipo_Operacion getTipo_operacion();
	public Tipo_Venta getTipo_venta();
}
