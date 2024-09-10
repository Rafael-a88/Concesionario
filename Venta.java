package ProyectoFinal;

import java.time.LocalDate;

public class Venta implements iVenta{

	private int idventa;
	private String vehiculo;
	private String cliente;
	private String vendedor;
	private String cuenta_bancaria;
	private LocalDate fecha_opera;
	private Tipo_Operacion tipo_operacion;
	private Tipo_Venta tipo_venta;
	
	public Venta() {
		
	}
	
	public Venta(int idventa, String vehiculo, String cliente, String vendedor, String cuenta_bancaria,
			LocalDate fecha_opera, Tipo_Operacion tipo_operacion, Tipo_Venta tipo_venta) {
	
		this.idventa = idventa;
		this.vehiculo = vehiculo;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.cuenta_bancaria = cuenta_bancaria;
		this.fecha_opera = fecha_opera;
		this.tipo_operacion = tipo_operacion;
		this.tipo_venta = tipo_venta;
	}


	public int getIdventa() {
		return idventa;
	}


	public void setIdventa(int idventa) {
		this.idventa = idventa;
	}


	public String getVehiculo() {
		return vehiculo;
	}


	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}


	public String getCliente() {
		return cliente;
	}


	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	public String getVendedores() {
		return vendedor;
	}


	public void setVendedores(String vendedor) {
		this.vendedor = vendedor;
	}


	public String getCuenta_bancaria() {
		return cuenta_bancaria;
	}


	public void setCuenta_bancaria(String cuenta_bancaria) {
		this.cuenta_bancaria = cuenta_bancaria;
	}


	public LocalDate getFecha_opera() {
		return fecha_opera;
	}


	public void setFecha_opera(LocalDate fecha_opera) {
		this.fecha_opera = fecha_opera;
	}


	public Tipo_Operacion getTipo_operacion() {
		return tipo_operacion;
	}


	public void setTipo_operacion(Tipo_Operacion tipo_operacion) {
		this.tipo_operacion = tipo_operacion;
	}


	public Tipo_Venta getTipo_venta() {
		return tipo_venta;
	}


	public void setTipo_venta(Tipo_Venta tipo_venta) {
		this.tipo_venta = tipo_venta;
	}


	@Override
	public String toString() {
		return "Venta [idventa=" + idventa + ", vehiculo=" + vehiculo + ", cliente=" + cliente + ", vendedor="
				+ vendedor + ", cuenta_bancaria=" + cuenta_bancaria + ", fecha_opera=" + fecha_opera
				+ ", tipo_operacion=" + tipo_operacion + ", tipo_venta=" + tipo_venta + "]";
	}


	

	
	


	
	
	
	
}
