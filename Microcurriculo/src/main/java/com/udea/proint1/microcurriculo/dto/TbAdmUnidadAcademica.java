package com.udea.proint1.microcurriculo.dto;

// Generated 21/10/2014 12:17:56 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TbAdmUnidadAcademica generated by hbm2java
 */
public class TbAdmUnidadAcademica implements java.io.Serializable {

	private String vrIdunidad;
	private String vrNombre;
	private String vrModusuario;
	private Date dtModfecha;
	private Set tbAdmDependencias = new HashSet(0);


	public TbAdmUnidadAcademica() {
		super();
	}

	public TbAdmUnidadAcademica(String vrIdunidad) {
		this.vrIdunidad = vrIdunidad;
	}

	public TbAdmUnidadAcademica(String vrIdunidad, String vrNombre,
			String vrModusuario, Date dtModfecha, Set tbAdmDependencias) {
		this.vrIdunidad = vrIdunidad;
		this.vrNombre = vrNombre;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
		this.tbAdmDependencias = tbAdmDependencias;
	}

	public String getVrIdunidad() {
		return this.vrIdunidad;
	}

	public void setVrIdunidad(String vrIdunidad) {
		this.vrIdunidad = vrIdunidad;
	}

	public String getVrNombre() {
		return this.vrNombre;
	}

	public void setVrNombre(String vrNombre) {
		this.vrNombre = vrNombre;
	}

	public String getVrModusuario() {
		return this.vrModusuario;
	}

	public void setVrModusuario(String vrModusuario) {
		this.vrModusuario = vrModusuario;
	}

	public Date getDtModfecha() {
		return this.dtModfecha;
	}

	public void setDtModfecha(Date dtModfecha) {
		this.dtModfecha = dtModfecha;
	}

	public Set getTbAdmDependencias() {
		return this.tbAdmDependencias;
	}

	public void setTbAdmDependencias(Set tbAdmDependencias) {
		this.tbAdmDependencias = tbAdmDependencias;
	}

}