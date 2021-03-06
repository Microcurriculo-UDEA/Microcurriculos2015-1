package com.udea.proint1.microcurriculo.dto;

// Generated 21/10/2014 12:17:56 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TbAdmDependencia generated by hbm2java
 */
public class TbAdmDependencia implements java.io.Serializable {

	private String vrIddependencia;
	private TbAdmUnidadAcademica tbAdmUnidadAcademica;
	private String vrNombre;
	private String vrAlias;
	private TbAdmPersona vrResponsable;
	private String vrModusuario;
	private Date dtModfecha;
	private Set tbAdmNucleo = new HashSet(0);
	private Set tbAdmDocentexDependencias = new HashSet(0);

	public TbAdmDependencia() {
		super();
	}
	
	public TbAdmDependencia(String vrIddependencia,
			TbAdmUnidadAcademica tbAdmUnidadAcademica, String vrNombre,
			String vrAlias, TbAdmPersona vrResponsable, String vrModusuario,
			Date dtModfecha) {
		super();
		this.vrIddependencia = vrIddependencia;
		this.tbAdmUnidadAcademica = tbAdmUnidadAcademica;
		this.vrNombre = vrNombre;
		this.vrAlias = vrAlias;
		this.vrResponsable = vrResponsable;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
	}



	public TbAdmDependencia(String vrIddependencia,	TbAdmUnidadAcademica tbAdmUnidadAcademica, String vrNombre,
			String vrModusuario, Date dtModfecha) {
		super();
		this.vrIddependencia = vrIddependencia;
		this.tbAdmUnidadAcademica = tbAdmUnidadAcademica;
		this.vrNombre = vrNombre;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
	}

	public TbAdmDependencia(String vrIddependencia, String vrNombre, String vrModusuario, Date dtModfecha) {
		this.vrIddependencia = vrIddependencia;
		this.vrNombre = vrNombre;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;		
	}

	public String getVrIddependencia() {
		return this.vrIddependencia;
	}

	public void setVrIddependencia(String vrIddependencia) {
		this.vrIddependencia = vrIddependencia;
	}

	public TbAdmUnidadAcademica getTbAdmUnidadAcademica() {
		return this.tbAdmUnidadAcademica;
	}

	public void setTbAdmUnidadAcademica(
			TbAdmUnidadAcademica tbAdmUnidadAcademica) {
		this.tbAdmUnidadAcademica = tbAdmUnidadAcademica;
	}

	public String getVrNombre() {
		return this.vrNombre;
	}

	public void setVrNombre(String vrNombre) {
		this.vrNombre = vrNombre;
	}

	public String getVrAlias() {
		return vrAlias;
	}

	public void setVrAlias(String vrAlias) {
		this.vrAlias = vrAlias;
	}

	public TbAdmPersona getVrResponsable() {
		return vrResponsable;
	}

	public void setVrResponsable(TbAdmPersona vrResponsable) {
		this.vrResponsable = vrResponsable;
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

	public Set getTbAdmNucleo() {
		return this.tbAdmNucleo;
	}

	public void setTbAdmNucleo(Set tbAdmNucleo) {
		this.tbAdmNucleo = tbAdmNucleo;
	}
	
	public Set getTbAdmDocentexDependencias() {
		return tbAdmDocentexDependencias;
	}

	public void setTbAdmDocentexDependencias(Set tbAdmDocentexDependencias) {
		this.tbAdmDocentexDependencias = tbAdmDocentexDependencias;
	}
}
