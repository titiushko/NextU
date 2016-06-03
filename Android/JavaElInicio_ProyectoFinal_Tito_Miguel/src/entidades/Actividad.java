package entidades;

import java.sql.Time;
import java.util.Date;

/**
* @author titiushko
*/
public class Actividad {
	private int codigo;
	private String descripcion;
	private String tipo;
	private Date fecha;
	private Time hora;
	private int duracion;
	private int codigoPersona;
	private int codigoOrganizacion;
	private int codigoNegocio;
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
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
	
	public Time getHora() {
		return hora;
	}
	
	public void setHora(Time hora) {
		this.hora = hora;
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	public int getCodigoPersona() {
		return codigoPersona;
	}
	
	public void setCodigoPersona(int codigoPersona) {
		this.codigoPersona = codigoPersona;
	}
	
	public int getCodigoOrganizacion() {
		return codigoOrganizacion;
	}
	
	public void setCodigoOrganizacion(int codigoOrganizacion) {
		this.codigoOrganizacion = codigoOrganizacion;
	}
	
	public int getCodigoNegocio() {
		return codigoNegocio;
	}
	
	public void setCodigoNegocio(int codigoNegocio) {
		this.codigoNegocio = codigoNegocio;
	}
}
