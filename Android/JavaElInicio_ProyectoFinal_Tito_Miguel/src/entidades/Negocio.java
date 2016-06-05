package entidades;

import java.util.Date;

/**
 * @author titiushko
 */
public class Negocio {
	private String titulo;
	private String descripcion;
	private int indiceOrganizacion;
	private int indicePersona;
	private double valor;
	private Date fechaEstimadaCierre;
	private String estado;
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getIndiceOrganizacion() {
		return indiceOrganizacion;
	}
	
	public void setIndiceOrganizacion(int indiceOrganizacion) {
		this.indiceOrganizacion = indiceOrganizacion;
	}
	
	public int getIndicePersona() {
		return indicePersona;
	}
	
	public void setIndicePersona(int indicePersona) {
		this.indicePersona = indicePersona;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Date getFechaEstimadaCierre() {
		return fechaEstimadaCierre;
	}
	
	public void setFechaEstimadaCierre(Date fechaEstimadaCierre) {
		this.fechaEstimadaCierre = fechaEstimadaCierre;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
