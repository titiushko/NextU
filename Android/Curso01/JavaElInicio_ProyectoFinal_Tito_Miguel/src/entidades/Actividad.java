package entidades;

import java.util.Date;

/**
 * @author titiushko
 */
public class Actividad {
	private String descripcion;
	private String tipo;
	private Date fecha;
	private Date hora;
	private int duracion;
	private int indicePersona;
	private int indiceOrganizacion;
	private int indiceNegocio;
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Date getHora() {
		return hora;
	}
	
	public void setHora(Date hora) {
		this.hora = hora;
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	public int getIndicePersona() {
		return indicePersona;
	}
	
	public void setIndicePersona(int indicePersona) {
		this.indicePersona = indicePersona;
	}
	
	public int getIndiceOrganizacion() {
		return indiceOrganizacion;
	}
	
	public void setIndiceOrganizacion(int indiceOrganizacion) {
		this.indiceOrganizacion = indiceOrganizacion;
	}
	
	public int getIndiceNegocio() {
		return indiceNegocio;
	}
	
	public void setIndiceNegocio(int indiceNegocio) {
		this.indiceNegocio = indiceNegocio;
	}
}
