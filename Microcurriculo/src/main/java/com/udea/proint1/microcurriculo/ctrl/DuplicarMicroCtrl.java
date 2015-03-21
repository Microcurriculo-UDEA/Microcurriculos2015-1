package com.udea.proint1.microcurriculo.ctrl;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Include;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisito;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisito;
import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicSubtemaxtema;
import com.udea.proint1.microcurriculo.dto.TbMicTemaxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidadxmicro;
import com.udea.proint1.microcurriculo.ngc.BiblioxunidadNGC;
import com.udea.proint1.microcurriculo.ngc.CorrequisitoNGC;
import com.udea.proint1.microcurriculo.ngc.EvaluacionxMicroNGC;
import com.udea.proint1.microcurriculo.ngc.MicrocurriculoNGC;
import com.udea.proint1.microcurriculo.ngc.ObjetivoxMicroNGC;
import com.udea.proint1.microcurriculo.ngc.PersonaNGC;
import com.udea.proint1.microcurriculo.ngc.PrerrequisitoNGC;
import com.udea.proint1.microcurriculo.ngc.SemestreNGC;
import com.udea.proint1.microcurriculo.ngc.SubtemaxTemaNGC;
import com.udea.proint1.microcurriculo.ngc.TemaxUnidadNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadxMicroNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

/**
 * Contiene los metodos de control para la vista de duplicar microcurriculos asociados a eventos
 * @author Elmer Urrea & Edwin Acosta
 *
 */
public class DuplicarMicroCtrl extends GenericForwardComposer{
	
	private static Logger logger = Logger.getLogger(DuplicarMicroCtrl.class);
	
	Button btnAddObjetivo;
	Button btnAddUnidad;
	Button btnAddTemas;
	Button btnAddSubTema;
	Button btnAddEvaluacion;
	Button btnAddBibliografia;
	Button btnAddCibergrafia;
	
	Include panelDuplicarMicro;
	
	Borderlayout blyDuplicarMicro;
	Borderlayout blyConsultarMicro;
	
	Tabbox fichaContenidos;
	
	Panel panelSemestre;
	Panel panelBuscarMicro;
	
	Combobox cmbSemestre2;
	Combobox cmbDocente;
	Combobox cmbSemestre;
	Combobox cmbUnidadAcademica;
	Combobox cmbDependencia;
	Combobox cmbNucleo;
	Combobox cmbMateria;
	Combobox cmbIdUnidad;
	Combobox cmbListaUnidades;
	Combobox cmbListaTemas;
	Combobox cmbListaUnidadBiblio;
	Combobox cmbTipoBibliografia;
	Combobox cmbTipoCibergrafia;
	
	Label lblIdMicrocurriculo;
	Label lblNombreUnidadAcademica;
	Label lblNombreDependencia;
	Label lblNombreNucleo;
	Label lblNombreMateria;
	Label lblNombreDocente;
	Label lblCreditosMateria;
	Label lblHtMateria;
	Label lblHpMateria;
	Label lblHtpMateria;
	Label lblHoraClaseSemestral;
	Label lblCampoFormacion;
	Label lblCorrequisitos;
	Label lblPrerrequisitos;
	Label lblProgramasVinculados;
	Label lblResumenMicro;
	Label lblPropositoMicro;
	Label lblJustificacionMicro;
	Label lblObjetivoGeneral;
	
	Checkbox ckbValidable;
	Checkbox ckbHabilitable;
	Checkbox ckbClasificable;
	
	Textbox txtPropositoMicro;
	Textbox txtJustificacionMicro;
	Textbox txtObjetivoGeneral;
	Textbox txtResumenMicro;
	Textbox txtObjetivoEspecifico;
	Textbox txtNombreUnidad;
	Textbox txtNombreTema;
	Longbox txtNumeroSemanas;
	Textbox txtSubTemas;
	Textbox txtActividadMicro;
	Longbox txtPorcentajeActividad;
	Textbox txtReferenciaBiblio;
	Textbox txtAutorBiblio;
	Textbox txtISBNBiblio;
	Textbox txtNombreSitioCiber;
	Textbox txtURLSitioCiber;
	
	Datebox dtFechaEvaluacion;
	
	Listbox listaObjetivosEspecificos;
	Listbox listaUnidades;
	Listbox listaTemas;
	Listbox listaSubtemas;
	Listbox listaEvaluaciones;
	Listbox listaBibliografia;
	Listbox listaCibergrafia;
	
	Toolbarbutton tool_save;
	Toolbarbutton tool_print;
	Toolbarbutton tool_duplica_otro;
	Toolbarbutton tool_consulta_otro;
	
	/**
	 * Formatos de fecha
	 */
	Date fechaEstimada = null;
	DateFormat formatoFecha = DateFormat.getDateInstance(DateFormat.MEDIUM);
	
	MicrocurriculoNGC microcurriculoNGC;
	SemestreNGC semestreNGC;
	PersonaNGC personaNGC;
	ObjetivoxMicroNGC objetivoxMicroNGC;
	CorrequisitoNGC correquisitoNGC;
	PrerrequisitoNGC prerrequisitoNGC;
	UnidadxMicroNGC unidadxMicroNGC;
	TemaxUnidadNGC temaxUnidadNGC;
	SubtemaxTemaNGC subtemaxTemaNGC;
	EvaluacionxMicroNGC evaluacionxMicroNGC;
	BiblioxunidadNGC biblioxUnidadNGC;
	
	/**
	 * Variable de control de porcentaje, que no sobrepase el 100%
	 */
	int porcentajeEvaluacion = 0;
	
	/**
	 * Metodo set para la inyecci�n de dependencia y gestionar datos en la tabla TbMicMicrocurriculo
	 * @param microcurriculoNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setMicrocurriculoNGC(MicrocurriculoNGC microcurriculoNGC) {
		this.microcurriculoNGC = microcurriculoNGC;
	}

	/**
	 * Metodo set para la inyecci�n de dependencia y gestionar datos en la tabla TbAdmSemestre
	 * @param semestreNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setSemestreNGC(SemestreNGC semestreNGC) {
		this.semestreNGC = semestreNGC;
	}

	/**
	 * Metodo set para la inyecci�n de dependencia y gestionar datos en la tabla TbAdmPersona
	 * @param personaNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setPersonaNGC(PersonaNGC personaNGC) {
		this.personaNGC = personaNGC;
	}

	/**
	 * Metodo set para la inyecci�n de dependencia y gestionar datos en la tabla TbMicObjetivoxMicro
	 * @param objetivoxMicroNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setObjetivoxMicroNGC(ObjetivoxMicroNGC objetivoxMicroNGC) {
		this.objetivoxMicroNGC = objetivoxMicroNGC;
	}

	/**
	 * Metodo set para la inyecci�n de dependencia y gestionar datos en la tabla TbMicCorrequisito
	 * @param correquisitoNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setCorrequisitoNGC(CorrequisitoNGC correquisitoNGC) {
		this.correquisitoNGC = correquisitoNGC;
	}

	/**
	 * Metodo set para la inyecci�n de dependencia y gestionar datos en la tabla TbMicPrerrequisito
	 * @param prerrequisitoNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setPrerrequisitoNGC(PrerrequisitoNGC prerrequisitoNGC) {
		this.prerrequisitoNGC = prerrequisitoNGC;
	}

	/**
	 * Metodo set para la inyecci�n de dependencia y gestionar datos en la tabla TbMicUnidad
	 * @param unidadxMicroNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setUnidadxMicroNGC(UnidadxMicroNGC unidadxMicroNGC) {
		this.unidadxMicroNGC = unidadxMicroNGC;
	}

	/**
	 * Metodo set para la inyecci�n de dependencia y gestionar datos en la tabla TbMicTemaxUnidad
	 * @param temaxUnidadNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setTemaxUnidadNGC(TemaxUnidadNGC temaxUnidadNGC) {
		this.temaxUnidadNGC = temaxUnidadNGC;
	}

	/**
	 * Metodo set para la inyecci�n de dependencia y gestionar datos en la tabla TbMicSubtemaxTema
	 * @param subtemaxTemaNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setSubtemaxTemaNGC(SubtemaxTemaNGC subtemaxTemaNGC) {
		this.subtemaxTemaNGC = subtemaxTemaNGC;
	}

	/**
	 * Metodo set para la inyecci�n de dependencia y gestionar datos en la tabla TbMicEvaluacionxMicro
	 * @param evaluacionxMicroNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setEvaluacionxMicroNGC(EvaluacionxMicroNGC evaluacionxMicroNGC) {
		this.evaluacionxMicroNGC = evaluacionxMicroNGC;
	}

	/**
	 * Metodo set para la inyecci�n de dependencia y gestionar datos en la tabla TbMicBiblioxUnidad
	 * @param biblioxUnidadNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setBiblioxUnidadNGC(BiblioxunidadNGC biblioxUnidadNGC) {
		this.biblioxUnidadNGC = biblioxUnidadNGC;
	}
	
	/**
	 * Solicita de la capa del negocio todos los semestres disponibles para ese tipo de microcurriculos
	 * se tiene en cuanta la materia asociada para saber en que semestres no se ha registrado y se llenan
	 * en el combobox cmbSemestre
	 * @param idMicrocurriculo cadena de caracteres con identificacion del microcurriculo
	 */
	public void cargarSemestres(String idMicrocurriculo){
		TbMicMicrocurriculo microcurriculo = null;
		try {
			microcurriculo = microcurriculoNGC.obtenerMicrocurriculos(idMicrocurriculo);
		} catch (ExcepcionesLogica e) {
			logger.error(e);
		}
		String idMateria = microcurriculo.getTbAdmMateria().getVrIdmateria();
		
		List<TbMicMicrocurriculo> listaMicrocurriculos = null;
		try {
			listaMicrocurriculos = microcurriculoNGC.listarMicrocurriculos();
		} catch (ExcepcionesLogica e) {
			logger.error("problemas al invocar metodo obtenerMicrocurriculos de la clase MicrocurriculoNGC "+e);
		}
		
		List<TbAdmSemestre> semestres = null;
		try {
			semestres = semestreNGC.listarSemestres();
		} catch (ExcepcionesLogica e) {
			logger.error("problemas al invocar metodo listarSemestres de la clase SemestreNGC "+e);
		}
		
		cmbSemestre2.getItems().clear();
		cmbSemestre2.appendChild(new Comboitem("[Seleccione]"));
		
		if(semestres != null){
			for(TbAdmSemestre semestre: semestres){
				
				/**
				 * se verifica en los microcurriculos asociado a la materia si el semestre ya fue registrado
				 */
				
				boolean semestreOcupado = false;
				if(listaMicrocurriculos != null){
					for(TbMicMicrocurriculo microRecorer: listaMicrocurriculos){
						if(idMateria.equals(microRecorer.getTbAdmMateria().getVrIdmateria())&&(semestre.getVrIdsemestre().equals(microRecorer.getTbAdmSemestre().getVrIdsemestre()))){
							semestreOcupado = true;
						}
					}
				}
				
				/**
				 * se verifica si el semestre no esta ocupado para agregarlo al combobox cmbSemestre
				 */
				
				if(!semestreOcupado){
					Comboitem item = new Comboitem(semestre.getVrIdsemestre());
					cmbSemestre2.appendChild(item);
				}
			}
		}
		cmbSemestre2.setValue("[Seleccione]");
	}
	
	/**
	 * Solicita de la capa del negocio todos los docentes existentes y los ubica en el combobox cmbDocente
	 */
	private void cargarDocentes(){
		try {
			List<TbAdmPersona> listaDocentes = personaNGC.obtenerDocentes();
			cmbDocente.getItems().clear();
			cmbDocente.appendChild(new Comboitem("[Seleccione]"));
			if (listaDocentes != null){
				for(TbAdmPersona docente : listaDocentes){
					Comboitem item = new Comboitem(docente.getVrIdpersona());
					item.setDescription(docente.getVrApellidos()+" "+docente.getVrNombres());
					cmbDocente.appendChild(item);
				}
			} else
				Messagebox.show("No Se Hallaron Registros de Docentes");
			cmbDocente.setValue("[Seleccione]");
		} catch (ExcepcionesLogica e) {
			logger.error("problemas al invocar metodo listaDocentes de la clase PersonaNGC "+e);
		}
	}
	
	/**
	 * El Metodo gestiona el llenado de datos a duplicar en el nuevo microcurriculo
	 * @param idMicro cadena de caracteres con identificacion de microcurriculo
	 * @param idSemestre cadena de caracteres con identificacion de semestre
	 */
	public void llenarDatos(String idMicro, String idSemestre){
		
		TbMicMicrocurriculo microcurriculo = null;
		
		if(!idMicro.equals("") && (!idMicro.equals(null))){
			try {
				microcurriculo = microcurriculoNGC.obtenerMicrocurriculos(idMicro);
			} catch (ExcepcionesLogica e) {
				logger.error("problemas al invocar metodo obtenerMicrocurriculos de la clase MicrocurriculoNGC "+e);
			}
			
			/**
			 * Verifica que el microcurriculo retornado no es nulo o si no reinicia busqueda para seleccionar nuevo
			 * microcurriculo a duplicar
			 */
			
			if(microcurriculo!= null){
				if(microcurriculo.getTbMicEstado().getNbIdestado() == 6){
					llenarDatosDependencias(microcurriculo);
					llenarPrerrequisitos(microcurriculo.getTbAdmMateria().getVrIdmateria());
					llenarCorrequisitos(microcurriculo.getTbAdmMateria().getVrIdmateria());
					llenarDatosMateria(microcurriculo.getTbAdmMateria());
					llenarDatosComplementarios(microcurriculo);
					llenarUnidadesTemasBiblios(microcurriculo.getVrIdmicrocurriculo());
					cmbSemestre.setValue(idSemestre);
					cmbSemestre.setDisabled(true);
					lblIdMicrocurriculo.setValue(microcurriculo.getTbAdmMateria().getVrIdmateria()+"-"+idSemestre);
					
				}else{
					ReiniciarBusqueda();
				}
			}else{
				ReiniciarBusqueda();
			}
		}
	}
	
	/**
	 * El Metodo gestiona el llenado de datos a consultar y son mostrados en la vista
	 * @param idMicro cadena de caracteres con identificacion de microcurriculo
	 */
	public void llenarDatos(String idMicro){
		
		TbMicMicrocurriculo microcurriculo = null;
		
		if(!idMicro.equals("") && (!idMicro.equals(null))){
			try {
				microcurriculo = microcurriculoNGC.obtenerMicrocurriculos(idMicro);
			} catch (ExcepcionesLogica e) {
				logger.error("problemas al invocar metodo obtenerMicrocurriculos de la clase MicrocurriculoNGC "+e);
			}
			
			/**
			 * Verifica que el microcurriculo retornado no es nulo o si no reinicia busqueda para seleccionar nuevo
			 * microcurriculo a consultar
			 */
			
			if(microcurriculo!= null){
				llenarDatosDependencias(microcurriculo);
				llenarPrerrequisitos(microcurriculo.getTbAdmMateria().getVrIdmateria());
				llenarCorrequisitos(microcurriculo.getTbAdmMateria().getVrIdmateria());
				llenarDatosMateria(microcurriculo.getTbAdmMateria());
				llenarDatosComplementarios(microcurriculo);
				llenarUnidadesTemasBiblios(microcurriculo.getVrIdmicrocurriculo());
				llenarEvaluaciones(microcurriculo.getVrIdmicrocurriculo());
				cmbSemestre.setValue(microcurriculo.getTbAdmSemestre().getVrIdsemestre());
				cmbSemestre.setDisabled(true);
				lblIdMicrocurriculo.setValue(microcurriculo.getVrIdmicrocurriculo());
				
				/**
				 * Ocultando campos de la vista consultar y poniendolos en modo label
				 */
				
				cmbDocente.setValue(microcurriculo.getTbAdmPersona().getVrIdpersona());
				cmbDocente.setDisabled(true);
				lblNombreDocente.setValue(microcurriculo.getTbAdmPersona().getVrNombres()+" "+microcurriculo.getTbAdmPersona().getVrApellidos());
				txtResumenMicro.setVisible(false);
				txtJustificacionMicro.setVisible(false);
				txtObjetivoGeneral.setVisible(false);
				txtPropositoMicro.setVisible(false);
				lblResumenMicro.setValue(microcurriculo.getVrResumen());
				lblJustificacionMicro.setValue(microcurriculo.getVrJustificacion());
				lblPropositoMicro.setValue(microcurriculo.getVrProposito());
				
				
			}else{
				ReiniciarBusqueda2();
			}
		}
	}
	
	/**
	 * Para la vista duplicar, reinicia la busqueda de nuevo microcurriculo y semestre a duplicar
	 */
	public void ReiniciarBusqueda(){
		panelDuplicarMicro.setVisible(true);
		blyDuplicarMicro.setVisible(false);
		tool_print.setVisible(false);
		tool_save.setVisible(false);
		/**
		 * Remueve variables de sesion si existen
		 */
		if(Executions.getCurrent().getSession().hasAttribute("idMicro")){
			Executions.getCurrent().getSession().removeAttribute("idMicro");
		}
		if(Executions.getCurrent().getSession().hasAttribute("semestre")){
			Executions.getCurrent().getSession().removeAttribute("semestre");
		}
	}
	
	/**
	 * Para la vista consultar, reinicia la busqueda del nuevo microcurriculo a consultar
	 */
	public void ReiniciarBusqueda2(){
		panelBuscarMicro.setVisible(true);
		blyConsultarMicro.setVisible(true);
		fichaContenidos.setVisible(false);
		tool_print.setVisible(false);
		tool_consulta_otro.setVisible(false);
		/**
		 * Remueve variables de sesion si existen
		 */
		if(Executions.getCurrent().getSession().hasAttribute("idMicro")){
			Executions.getCurrent().getSession().removeAttribute("idMicro");
		}
		if(Executions.getCurrent().getSession().hasAttribute("semestre")){
			Executions.getCurrent().getSession().removeAttribute("semestre");
		}
	}
	
	/**
	 * Permite mostrar en la vista los datos asociados a las dependencias del microcurriculo y son controladas
	 * para evitar errores del usuario
	 * @param microcurriculo objeto con parametros definidos para microcurriculo
	 */
	public void llenarDatosDependencias(TbMicMicrocurriculo microcurriculo){
		
		cmbUnidadAcademica.setValue(microcurriculo.getTbAdmMateria().getTbAdmNucleo().getTbAdmDependencia().getTbAdmUnidadAcademica().getVrIdunidad());
		cmbUnidadAcademica.setDisabled(true);
		lblNombreUnidadAcademica.setValue(microcurriculo.getTbAdmMateria().getTbAdmNucleo().getTbAdmDependencia().getTbAdmUnidadAcademica().getVrNombre());
		cmbDependencia.setValue(microcurriculo.getTbAdmMateria().getTbAdmNucleo().getTbAdmDependencia().getVrIddependencia());
		cmbDependencia.setDisabled(true);
		lblNombreDependencia.setValue(microcurriculo.getTbAdmMateria().getTbAdmNucleo().getTbAdmDependencia().getVrNombre());
		cmbNucleo.setValue(microcurriculo.getTbAdmMateria().getTbAdmNucleo().getVrIdnucleo());
		cmbNucleo.setDisabled(true);
		lblNombreNucleo.setValue(microcurriculo.getTbAdmMateria().getTbAdmNucleo().getVrNombre());
		cmbMateria.setValue(microcurriculo.getTbAdmMateria().getVrIdmateria());
		cmbMateria.setDisabled(true);
		lblNombreMateria.setValue(microcurriculo.getTbAdmMateria().getVrNombre());
		
	}
	
	/**
	 * Permite mostrar en la vista los datos de la materia asociada al microcurriculo a duplicar o consultar
	 * @param materia objeto con parametros definidos para materia
	 */
	public void llenarDatosMateria(TbAdmMateria materia){
		
		lblCreditosMateria.setValue(Integer.toString(materia.getNbCreditos()));
		lblHtMateria.setValue(Integer.toString(materia.getNbHt()));
		lblHpMateria.setValue(Integer.toString(materia.getNbHp()));
		lblHtpMateria.setValue(Integer.toString(materia.getNbHtp()));
		
		int ht = materia.getNbHt();
		int hp = materia.getNbHp();
		int htp = materia.getNbHtp();
		int horasSemestral = (ht+hp+htp)*16;
		
		lblHoraClaseSemestral.setValue(Integer.toString(horasSemestral));
		if((materia.getBlClasificable())==1){
			ckbClasificable.setChecked(true);
		}else if((materia.getBlClasificable())==0){
			ckbClasificable.setChecked(false);
		}
		if((materia.getBlHabilitable()) == 1){
			ckbHabilitable.setChecked(true);
		}else if((materia.getBlHabilitable()) == 0){
			ckbHabilitable.setChecked(false);
		}
		if((materia.getBlValidable()) == 1){
			ckbValidable.setChecked(true);
		}else if((materia.getBlValidable()) == 0){
			ckbValidable.setChecked(false);
		}
		
	}
	
	/**
	 * Hace busqueda y muestra al usuario los correquisitos asociados a la materia
	 * @param idMateria cadena de caracteres con identificacion de la materia
	 */
	public void llenarCorrequisitos(String idMateria){
		String listaCorrequisitos = "";
		 
		List<TbAdmCorrequisito> correquisitos = null;
		try {
			correquisitos = correquisitoNGC.listarCorrequisitosxMateria(idMateria);
		} catch (ExcepcionesLogica e) {
			logger.error("problemas al invocar metodo listarCorrequisitosxMateria de la clase CorrequisitoNGC "+e);
		}
		
		/**
		 * la bandera permite gestionar la concatenacion de los datos de los microcurriculos para ser mostrados
		 */
		
		boolean bandera = true;
		for(TbAdmCorrequisito correquisito: correquisitos){
			if(bandera){
				listaCorrequisitos = correquisito.getTbAdmMateriasByVrCorrequisito().getVrIdmateria()+" - "+correquisito.getTbAdmMateriasByVrCorrequisito().getVrNombre();
				bandera = false;
			}else{
				listaCorrequisitos = listaCorrequisitos + "\n"+(correquisito.getTbAdmMateriasByVrCorrequisito().getVrIdmateria()+" - "+correquisito.getTbAdmMateriasByVrCorrequisito().getVrNombre());
			}
		}
		lblCorrequisitos.setValue(listaCorrequisitos);
	}
	
	/**
	 * Hace busqueda y muestra al usuario los prerrequisitos asociados a la materia
	 * @param idMateria cadena de caracteres con identificacion de la materia
	 */
	public void llenarPrerrequisitos(String idMateria){
		String listaPrerrequisitos = "";
		
		List<TbAdmPrerrequisito> prerrequisitos = null;
		try {
			prerrequisitos = prerrequisitoNGC.listarPrerrequisitosxMateria(idMateria);
		} catch (ExcepcionesDAO e) {
			logger.error("problemas al invocar metodo listarPrerrequisitosxMateria de la clase PrerrequisitoNGC "+e);
		}
		
		/**
		 * la bandera permite gestionar la concatenacion de los datos de los microcurriculos para ser mostrados
		 */
		
		boolean bandera2 = true;
		for(TbAdmPrerrequisito prerrequisito: prerrequisitos){
			if(bandera2){
				listaPrerrequisitos = prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrIdmateria()+" - "+prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrNombre();
				bandera2 = false;
			}else{
				listaPrerrequisitos = listaPrerrequisitos + "\n"+(prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrIdmateria()+" - "+prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrNombre());
			}
		}
		lblPrerrequisitos.setValue(listaPrerrequisitos);
	}
	
	/**
	 * Permite mostrar en la vista los datos complementarios asociados al microcurriculo a duplicar
	 * dejandolos listos para ser modificados
	 * @param microcurriculo objeto con parametros definidos para materia
	 */
	public void llenarDatosComplementarios(TbMicMicrocurriculo microcurriculo){
		
		txtJustificacionMicro.setValue(microcurriculo.getVrJustificacion());
		txtPropositoMicro.setValue(microcurriculo.getVrProposito());
		txtResumenMicro.setValue(microcurriculo.getVrResumen());
		List<TbMicObjetivoxmicro> objetivosxMicro = null;
		try {
			objetivosxMicro = objetivoxMicroNGC.obtenerObjetivosxMicroxMicro(microcurriculo.getVrIdmicrocurriculo());
		} catch (ExcepcionesLogica e) {
			logger.error("problemas al invocar metodo obtenerObjetivosxMicroxMicro de la clase ObjetivoxMicroNGC "+e);
		}
		
		for(TbMicObjetivoxmicro objetivoxMicro: objetivosxMicro){
			if(objetivoxMicro.getBlTipo()=='1'){
				txtObjetivoGeneral.setValue(objetivoxMicro.getTbMicObjetivo().getVrDescripcion());
				if(lblObjetivoGeneral != null){
					lblObjetivoGeneral.setValue(objetivoxMicro.getTbMicObjetivo().getVrDescripcion());
				}
			}else{
				
				/**
				 * implantacion del metodo de borrado de item, a trav�s del doble click
				 */
				
				final Listitem item = new Listitem();
				item.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
					@Override
					public void onEvent(Event arg0) throws Exception {
						eliminaListItem(item,"");
					}
				});
				
				Listcell celda = new Listcell(objetivoxMicro.getTbMicObjetivo().getVrDescripcion());
				item.appendChild(celda);
				listaObjetivosEspecificos.appendChild(item);
				
			}
		}
	}
	
	/**
	 * Metodo a la espera del evento click en el boton btnAddObjetivo para validar si la informaci�n se ingres�
	 * para luego ser adicionada al listbox
	 * @param event
	 */
	public void onClick$btnAddObjetivo(Event event){
		if(txtObjetivoEspecifico.getValue() != null && (txtObjetivoEspecifico.getValue().trim().length() >0)){	
			final Listitem listaItem = new Listitem();
			listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
				@Override
				public void onEvent(Event arg0) throws Exception {
					eliminaListItem(listaItem,"");
				}
			});
			Listcell celda = new Listcell(txtObjetivoEspecifico.getValue());
			listaItem.appendChild(celda);			
			listaObjetivosEspecificos.appendChild(listaItem);
			txtObjetivoEspecifico.setText(null);
			txtObjetivoEspecifico.setValue(null);
		} else {
			Messagebox.show("Se Requiere informaci�n en el Campo <Objetivo Especifico>");
		}
	}
	
	/**
	 * El metodo procede a llenar los datos encontrados de unidades,temas, subtemas y bibliografias del microcurriculo
	 * @param idMicrocurriculo cadena de caracteres con identificacion de microcurriculo
	 */
	public void llenarUnidadesTemasBiblios(String idMicrocurriculo){
		List<TbMicUnidadxmicro> unidadesxMicro = null;
		try {
			unidadesxMicro = unidadxMicroNGC.listarUnidadesXMicroxMicro(idMicrocurriculo);
		} catch (ExcepcionesLogica e) {
			logger.error("problemas al invocar metodo listarUnidadesXMicroxMicro de la clase UnidadxMicroNGC "+e);
		}
		/**
		 * Inicia buscando unidades relacionadas al microcurriculo y luego son agregadas
		 * a los listbox y combobox
		 */
		
		for(TbMicUnidadxmicro unidadxMicro: unidadesxMicro){
			final Listitem item = new Listitem();
			final String tmpUnidad = unidadxMicro.getTbMicUnidad().getVrNombre(); 
			item.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
				@Override
				public void onEvent(Event arg0) throws Exception {
					eliminaListItem(item, tmpUnidad);
				}
			});
			
			Listcell celda1 = new Listcell("");
			item.appendChild(celda1);
			Listcell celda2 = new Listcell(unidadxMicro.getTbMicUnidad().getVrNombre());
			item.appendChild(celda2);
			listaUnidades.appendChild(item);
			
			Comboitem comboUnidad1 = new Comboitem(unidadxMicro.getTbMicUnidad().getVrNombre());
			cmbIdUnidad.appendChild(comboUnidad1);
			Comboitem comboUnidad2 = new Comboitem(unidadxMicro.getTbMicUnidad().getVrNombre());
			cmbListaUnidades.appendChild(comboUnidad2);
			Comboitem comboUnidad3 = new Comboitem(unidadxMicro.getTbMicUnidad().getVrNombre());
			cmbListaUnidadBiblio.appendChild(comboUnidad3);
			
			/**
			 * busca todos los temas x unidad asociados a las unidades y se ubican extraen los temas
			 * para llenar los listbox
			 */
			
			List<TbMicTemaxunidad> temasxUnidad = null;
			try {
				temasxUnidad = temaxUnidadNGC.ListarTemasxUnidadxUnidad(unidadxMicro.getTbMicUnidad().getNbIdunidad());
			} catch (ExcepcionesLogica e) {
				logger.error("problemas al invocar metodo ListarTemasxUnidadxUnidad de la clase TemaxUnidadNGC "+e);
			}
			if(temasxUnidad != null){
				for(TbMicTemaxunidad temaxUnidad: temasxUnidad){
					final Listitem itemTemas = new Listitem();
					itemTemas.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
						@Override
						public void onEvent(Event arg0) throws Exception {
							eliminaListItem(itemTemas, "");
						}
					});
					
					Listcell celdaTemas1 = new Listcell(temaxUnidad.getTbMicUnidad().getVrNombre());
					itemTemas.appendChild(celdaTemas1);
					Listcell celdaTemas2 = new Listcell(temaxUnidad.getTbMicTema().getVrDescripcion());
					itemTemas.appendChild(celdaTemas2);
					Listcell celdaTemas3 = new Listcell(Integer.toString(temaxUnidad.getNbSemanasRequeridas()));
					itemTemas.appendChild(celdaTemas3);
					listaTemas.appendChild(itemTemas);
					
					/**
					 * Busca los subtemas x unidad y los extrae para ser agregados al listbox listaSubtemas
					 */
					
					List<TbMicSubtemaxtema> subtemasxTema = null;
					try {
						subtemasxTema = subtemaxTemaNGC.listarSubtemaxTema_Tema(temaxUnidad.getTbMicTema().getNbIdtema());
					} catch (ExcepcionesLogica e) {
						logger.error("problemas al invocar metodo listarSubtemaxTema_Tema de la clase SubtemaxTemaNGC "+e);
					}
					if(subtemasxTema != null){
						for(TbMicSubtemaxtema subtemaxTema: subtemasxTema){
							final Listitem itemSubtemas = new Listitem();
							itemSubtemas.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
								@Override
								public void onEvent(Event arg0) throws Exception {
									eliminaListItem(itemSubtemas, "");
								}
							});
							
							Listcell celdaSubtemas1 = new Listcell(temaxUnidad.getTbMicUnidad().getVrNombre());
							itemSubtemas.appendChild(celdaSubtemas1);
							Listcell celdaSubtemas2 = new Listcell(subtemaxTema.getTbMicTema().getVrDescripcion());
							itemSubtemas.appendChild(celdaSubtemas2);
							Listcell celdaSubtemas3 = new Listcell(subtemaxTema.getTbMicSubtema().getVrDescripcion());
							itemSubtemas.appendChild(celdaSubtemas3);
							listaSubtemas.appendChild(itemSubtemas);
							
						}
					}
				}
			}
			
			/**
			 * Hace la busqueda de las bibliografias asociadas a las unidades del microcurriculo y las agrega
			 * finalmente a los list box de las bibliografias
			 */
			
			List<TbMicBiblioxunidad> bibliosxUnidad = null;
			try {
				bibliosxUnidad = biblioxUnidadNGC.listadoBiblioxUnidad(unidadxMicro.getTbMicUnidad().getNbIdunidad());
			} catch (ExcepcionesLogica e) {
				logger.error("problemas al invocar metodo listadoBiblioxUnidad de la clase BiblioxUnidadNGC "+e);
			}
			
			if(bibliosxUnidad!=null){
				for(TbMicBiblioxunidad biblioxUnidad: bibliosxUnidad){
					if(biblioxUnidad.getTbMicBibliografia().getVrSitioweb() == null){
						final Listitem itemBiblio = new Listitem();
						itemBiblio.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
							@Override
							public void onEvent(Event arg0) throws Exception {
								eliminaListItem(itemBiblio, "");
							}
						});
						
						Listcell celdaBiblio0 = new Listcell(biblioxUnidad.getTbMicUnidad().getVrNombre());
						itemBiblio.appendChild(celdaBiblio0);
						Listcell celdaBiblio1 = new Listcell(biblioxUnidad.getTbMicBibliografia().getVrNombre());
						itemBiblio.appendChild(celdaBiblio1);
						Listcell celdaBiblio2 = new Listcell(biblioxUnidad.getTbMicBibliografia().getVrAutor());
						itemBiblio.appendChild(celdaBiblio2);
						Listcell celdaBiblio3 = new Listcell(biblioxUnidad.getTbMicBibliografia().getVrIsbn());
						itemBiblio.appendChild(celdaBiblio3);
						if(biblioxUnidad.getTbMicBibliografia().getBlTipo()=='1'){
							Listcell celdaBiblio4 = new Listcell("COMPLEMENTARIA");
							itemBiblio.appendChild(celdaBiblio4);
						}else if(biblioxUnidad.getTbMicBibliografia().getBlTipo()=='0'){
							Listcell celdaBiblio4 = new Listcell("B�SICA");
							itemBiblio.appendChild(celdaBiblio4);
						}
						listaBibliografia.appendChild(itemBiblio);
						
					}else{
						final Listitem itemBiblio = new Listitem();
						itemBiblio.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
							@Override
							public void onEvent(Event arg0) throws Exception {
								eliminaListItem(itemBiblio, "");
							}
						});
						
						Listcell celdaBiblio0 = new Listcell(biblioxUnidad.getTbMicUnidad().getVrNombre());
						itemBiblio.appendChild(celdaBiblio0);
						Listcell celdaBiblio1 = new Listcell(biblioxUnidad.getTbMicBibliografia().getVrNombre());
						itemBiblio.appendChild(celdaBiblio1);
						Listcell celdaBiblio2 = new Listcell(biblioxUnidad.getTbMicBibliografia().getVrSitioweb());
						itemBiblio.appendChild(celdaBiblio2);
						if(biblioxUnidad.getTbMicBibliografia().getBlTipo()=='1'){
							Listcell celdaBiblio3 = new Listcell("COMPLEMENTARIA");
							itemBiblio.appendChild(celdaBiblio3);
						}else if(biblioxUnidad.getTbMicBibliografia().getBlTipo()=='0'){
							Listcell celdaBiblio3 = new Listcell("B�SICA");
							itemBiblio.appendChild(celdaBiblio3);
						}
						listaCibergrafia.appendChild(itemBiblio);
						
					}
				}
			}
		}
		
	}
	
	/**
	 * El metodo procede a llenar las evaluaciones encontradas del microcurriculo
	 * Solo aplica para la consulta, porque para el duplicado se asumen fechas diferentes de evaluaciones
	 * @param idMicrocurriculo cadena de caracteres con identificacion del microcurriculo
	 */
	public void llenarEvaluaciones(String idMicrocurriculo){
		List<TbMicEvaluacionxmicro> evaluacionesxMicro = null;
		try {
			evaluacionesxMicro = evaluacionxMicroNGC.ListarEvaluacionxMicroxMicro(idMicrocurriculo);
		} catch (ExcepcionesLogica e) {
			logger.error("problemas al invocar metodo ListarEvaluacionxMicroxMicro de la clase EvaluacionxMicroNGC "+e);
		}
		for(TbMicEvaluacionxmicro evaluacionxmicro: evaluacionesxMicro){
			Listitem item = new Listitem();
			
			Listcell celda1 = new Listcell(evaluacionxmicro.getTbMicEvaluacion().getVrDescripcion());
			item.appendChild(celda1);
			Listcell celda2 = new Listcell(Integer.toString(evaluacionxmicro.getNbPorcentaje()));
			item.appendChild(celda2);
			Listcell celda3 = new Listcell(evaluacionxmicro.getDtFechaestimada().toString());
			item.appendChild(celda3);
			listaEvaluaciones.appendChild(item);
			
		}
	}
	
	/**
	 * Atiende a los eventos de doble click en las listas que corresponden al borrado de items
	 * El metodo revisa la lista que hizo el llamado y procede a borrar en cascada (y/o) borrar item
	 * @param item fila a borrar en la lista
	 * @param clave identificacion del objeto borrado no siempre es enviado
	 */
	private void eliminaListItem(Listitem item, String clave){
		if(item.getParent().getId().toString().equals("listaUnidades")){
			eliminaCascadaUnidad(item, clave.toUpperCase());
			item.detach();
			recargarCombosUnidades(listaUnidades);
		} else if (item.getParent().getId().toString().equals("listaTemas")){
			eliminaCascadaTema(item, clave.toUpperCase());
			item.detach();
			recargarCombosTemas(listaTemas);
		} else if(item.getParent().getId().toString().equals("listaSubtemas")){
			item.detach();
		} else if(item.getParent().getId().toString().equals("listaEvaluaciones")){
			Listcell celdaPorcentaje = (Listcell)item.getChildren().get(1);
			porcentajeEvaluacion = porcentajeEvaluacion - Integer.parseInt(celdaPorcentaje.getLabel());
			item.detach();
		} else if(item.getParent().getId().toString().equals("listaBibliografia")){
			item.detach();
		} else if(item.getParent().getId().toString().equals("listaCibergrafia")){
			item.detach();
		} else if(item.getParent().getId().toString().equals("listaObjetivosEspecificos")){
			item.detach();
		}
	}
	
	/**
	 * Elimina todos los subtemas asociados al tema que se borrar� para que no queden sueltos
	 * sin refencia de alguno
	 * @param item fila a eliminar
	 * @param clave identificacion de tema
	 */
	private void eliminaCascadaTema(Listitem item, String clave){
		Listcell celda = (Listcell)item.getChildren().get(1);
		clave = celda.getLabel().toUpperCase();
		if (listaSubtemas.getItems().size() > 0){
			for(int i=1; i<=listaSubtemas.getItems().size(); i++){
				Listitem itemSubtema = (Listitem)listaSubtemas.getChildren().get(i);
				Listcell celdaTema = (Listcell)itemSubtema.getChildren().get(1);
				if(clave.equals(celdaTema.getLabel().trim().toUpperCase())){
					itemSubtema.detach();
					i--;
				}
			}
		}
	}
	
	/**
	 * Hace la carga de los combos de los temas actuales, para facilitar la eleccion del usuario
	 * @param lista objeto lista de temas a llenar
	 */
	private void recargarCombosTemas(Listbox lista){
		cmbListaTemas.getItems().clear();
		
		if(lista.getItems().size() > 0){
			for(int i=1; i<= lista.getItemCount(); i++){
				Listitem listaItem = (Listitem)lista.getChildren().get(i); 
				Listcell celda = (Listcell)listaItem.getChildren().get(1);
				Comboitem item = new Comboitem(celda.getLabel());
				cmbListaTemas.appendChild(item);
			}
		}
	}
	
	/**
	 * Elimina en cascada los items asociados a la Unidad a borrar, para que no queden
	 * referencias sueltas
	 * @param item objeto fila a borrar
	 * @param clave identificacion de unidad a borrar
	 */
	private void eliminaCascadaUnidad(Listitem item, String clave){
		if (listaBibliografia.getItems().size() > 0){
			for (int i=1; i<=listaBibliografia.getItems().size(); i++){
				Listitem itemBiblio = (Listitem)listaBibliografia.getChildren().get(i);
				Listcell celdaUnidad = (Listcell)itemBiblio.getChildren().get(0);
				if (clave.equals(celdaUnidad.getLabel().trim().toUpperCase())){
					itemBiblio.detach();
					i--;
				}				
			}
		}
		
		if (listaCibergrafia.getItems().size() > 0){
			for(int i=1; i<=listaCibergrafia.getItems().size(); i++){
				Listitem itemCiber = (Listitem)listaCibergrafia.getChildren().get(i);
				Listcell celdaUnidad = (Listcell)itemCiber.getChildren().get(0);
				if(clave.equals(celdaUnidad.getLabel().trim().toUpperCase())){
					itemCiber.detach();
					i--;
				}
			}
		}
		
		if (listaSubtemas.getItems().size() > 0){
			for(int i=1; i<=listaSubtemas.getItems().size(); i++){
				Listitem itemSubtema = (Listitem)listaSubtemas.getChildren().get(i);
				Listcell celdaUnidad = (Listcell)itemSubtema.getChildren().get(0);
				if(clave.equals(celdaUnidad.getLabel().trim().toUpperCase())){
					itemSubtema.detach();
					i--;
				}
			}
		}
		if (listaTemas.getItems().size() > 0){
			for(int i=1;i<=listaTemas.getItems().size(); i++){
				Listitem itemTema = (Listitem)listaTemas.getChildren().get(i);
				Listcell celdaTema = (Listcell)itemTema.getChildren().get(0);
				if (clave.equals(celdaTema.getLabel().trim().toUpperCase())){
					itemTema.detach();
					i--;
				}
			}
		}
	}
	
	/**
	 * Hace la carga de unidades existentes en los combobox de busqueda para
	 * facilitar la eleccion del usuario
	 * @param lista objeto listado de unidades a recargar en los combobox
	 */
	private void recargarCombosUnidades(Listbox lista){
		cmbIdUnidad.getItems().clear();
		cmbListaUnidades.getItems().clear();
		cmbListaUnidadBiblio.getItems().clear();
		cmbListaTemas.getItems().clear();

		if (lista.getItems().size() > 0){
			for (int i=1; i <= lista.getItems().size(); i++ ){
				Listitem listaItem = (Listitem)lista.getChildren().get(i); 
				Listcell celda = (Listcell)listaItem.getChildren().get(1);

				Comboitem itemUnidadTema = new Comboitem(celda.getLabel());
				cmbIdUnidad.appendChild(itemUnidadTema);
				Comboitem item2 = new Comboitem(celda.getLabel());
				cmbListaUnidades.appendChild(item2); 
				Comboitem item3 = new Comboitem(celda.getLabel());
				cmbListaUnidadBiblio.appendChild(item3);
			}	
		}	
	}
	
	/**
	 * Ante la eleccion del semestre a duplicar, se guarda en session 
	 * el id de semestre a duplicar
	 */
	public void onSelect$cmbSemestre2(){
		String semestreDuplicar = cmbSemestre2.getValue().toString();
		if(!semestreDuplicar.equals("[Seleccione]")&&(!semestreDuplicar.equals(""))){
			Executions.getCurrent().getSession().setAttribute("semestre", semestreDuplicar);
		}else{
			if(Executions.getCurrent().getSession().hasAttribute("semestre")){
				Executions.getCurrent().getSession().removeAttribute("semestre");
			}
		}
	}
	
	/**
	 * Ante el evento click en el bot�n de reinicio de duplicado, procede a
	 * llamar el metodo que reinicia el duplicado
	 */
	public void onClick$tool_duplica_otro(){
		ReiniciarBusqueda();
	}
	
	/**
	 * Ante el evento click en el bot�n de reiniciar busqueda, procede a
	 * llamar el metodo que muestra el men� para buscar otro microcurriculo a mostrar
	 */
	public void onClick$tool_consulta_otro(){
		ReiniciarBusqueda2();
	}
	
	/**
	 * Boton btnAddTemas Evento onClick
	 * 
	 * Captura el contenido de los campos idUnidad, nombreTema y numeroSemanas, la cual se almacena en una 
	 * lista previa validaci�n de contenido existente.
	 * 
	 * @param event
	 */
	public void onClick$btnAddTemas(Event event){		
		validarCamposTemas(txtNombreTema.getValue().toString());
					
	}
	
	/**
	 * Captura el contenido de los campos idUnidad, nombreTema y numeroSemanas, la cual se almacena en una 
	 * lista previa validaci�n de contenido existente.
	 * 
	 */
	private void validarCamposTemas(String nombreTema){
		if(cmbIdUnidad.getValue().trim().length() > 0)
			if (txtNombreTema.getValue().trim().length() > 0 && (!"".equals(txtNombreTema.getValue())))
				if(txtNumeroSemanas.longValue() > 0){
					
					llenarListaTemas(nombreTema);
					cmbListaUnidades.setSelectedIndex(-1);
					cmbListaUnidades.setValue("");
				}else{
					Messagebox.show("Se requiere informaci�n en el campo <Tiempo (Semanas)>");
					txtNumeroSemanas.focus();
				}
			else{
				Messagebox.show("Se requiere informaci�n en el campo <Nombre Tema>");
				txtNombreTema.focus();
			}
		else{
			Messagebox.show("Se requiere informaci�n en el campo <Nombre Unidad>");
			cmbIdUnidad.focus();
		}
	}
	
	/**
	 * El metodo valida que no exista y agrega nuevos temas al listbox cmbListaTemas
	 * @param tema objeto tema con parametros definidos para ser ubicado junto a los otros temas existentes en la lista
	 */
	public void llenarListaTemas(String tema){
		final Listitem listaItem = new Listitem();
		final String tmpTema = tema.toUpperCase().trim();
		
		listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {
				eliminaListItem(listaItem, tmpTema);
			}
		});
		
		if (!existeTema(tmpTema)){
			Listcell celdaUnidad = new Listcell(cmbIdUnidad.getValue());
			Listcell celdaTema = new Listcell(txtNombreTema.getValue().toUpperCase());		
			Listcell celdaTiempo = new Listcell(txtNumeroSemanas.getValue().toString());		
			listaItem.appendChild(celdaUnidad);
			listaItem.appendChild(celdaTema);
			listaItem.appendChild(celdaTiempo);
			
			Comboitem item = new Comboitem(txtNombreTema.getValue().toUpperCase());		
			cmbListaTemas.appendChild(item);
			
			listaTemas.appendChild(listaItem);
			cmbIdUnidad.setValue("");
			txtNombreTema.setValue("");
			txtNumeroSemanas.setValue(null);
		} else{
			Messagebox.show("El Tema a Ingresar ya Existe.");
		}
	}
	
	/**
	 * Metodo de validaci�n si el tema existe
	 * @param tema variable objeto que contiene el nombre del tema a verificar
	 * @return true si el tema existe o sino retorna falso indicando que no existe tema con dicho nombre
	 */
	private boolean existeTema(String tema){
		boolean estado = false;
		for(int i=1; i<=listaTemas.getItems().size(); i++){
			Listitem item = (Listitem)listaTemas.getChildren().get(i);
			Listcell celdaTema = (Listcell)item.getChildren().get(1);
			if (tema.equals(celdaTema.getLabel().trim().toUpperCase())){
				estado = true;
				break;
			}
		}
		return estado;
	}
	
	/**
	 * Metodo a la espera de click en el boton agregar unidad y procede a enviar a metodo
	 * que agrega la unidad si cumple los parametros de guardado
	 * @param event
	 */
	public void onClick$btnAddUnidad(Event event){
		llenarListaUnidades(txtNombreUnidad.getValue());
	}
	
	/**
	 * Procede a verificar si la unidad cumple con los parametros de guardado y la grega a la lista de
	 * unidades existentes
	 * @param nombreUnidad nombre de la unidad a agregar en la lista de unidades
	 */
	private void llenarListaUnidades(String nombreUnidad){
		if(!("".equals(nombreUnidad)) && (nombreUnidad.trim().length() > 0)){			
			final Listitem listaItem = new Listitem();
			final String tmpUnidad = nombreUnidad;
			
			listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
				@Override
				public void onEvent(Event arg0) throws Exception {
					eliminaListItem(listaItem, tmpUnidad);					
				}
			});
			if (!existeUnidad(tmpUnidad)){
				Listcell celdaVacia = new Listcell("");
				listaItem.appendChild(celdaVacia);
				Listcell celdaUnidad = new Listcell(nombreUnidad.toUpperCase());
				listaItem.appendChild(celdaUnidad);
				llenarCombosUnidades(nombreUnidad.toUpperCase());
				listaUnidades.appendChild(listaItem);
				txtNombreUnidad.setValue("");
				txtNombreUnidad.setFocus(true);
			}else
				Messagebox.show("Existe un unidad con el mismo nombre.");
			
		} else
			if (listaUnidades.getItems().size() > 0)
				cmbIdUnidad.focus();
			else
				Messagebox.show("Se Requiere informaci�n en el Campo <Nombre de la Unidad>");
	}
	
	/**
	 * Verifica si existe la unidad a guardar
	 * @param unidad nombre de unidad a verificar
	 * @return true si la unidad ya existe y false si no existe con ese nombre
	 */
	private boolean existeUnidad(String unidad){
		boolean estado = false;
		for (int i=1;i<=listaUnidades.getItems().size(); i++){
			Listitem item = (Listitem)listaUnidades.getChildren().get(i);
			Listcell celdaUnidad = (Listcell)item.getChildren().get(1);
			if (unidad.toUpperCase().equals(celdaUnidad.getLabel())){
				estado = true;
				break;
			}	
		}
		return estado;
	}
	
	/**
	 * El metodo agrega la unidad nueva a los combobox
	 * @param unidad nombre de unidad a agregar en los combobox
	 */
	private void llenarCombosUnidades(String unidad){
		Comboitem item = new Comboitem(unidad);		
		cmbIdUnidad.appendChild(item);
		Comboitem item2 = new Comboitem(unidad);
		cmbListaUnidades.appendChild(item2);
		Comboitem item3 = new Comboitem(unidad);
		cmbListaUnidadBiblio.appendChild(item3);
	}
	
	public void onClick$btnAddSubTema(Event event){
		validarCamposSubtemas(cmbListaUnidades.getValue(), cmbListaTemas.getValue(), txtSubTemas.getValue());
	}
	
	private void validarCamposSubtemas(String listaUnidades, String listaTemas, String subTema){
		if (cmbListaUnidades.getValue() != null && (cmbListaUnidades.getValue().trim().length() > 0)){
			if (cmbListaTemas.getValue() != null && (cmbListaTemas.getValue().trim().length() > 0)){
				if (txtSubTemas.getValue() != null && (txtSubTemas.getValue().trim().length() > 0)){
					llenarListaSubTemas();
					cmbListaTemas.getItems().clear();
					cmbListaTemas.setValue("");
					cmbListaUnidades.focus();
				} else
					Messagebox.show("Se Requiere informaci�n en el Campo <Subtema>");
			} else
				Messagebox.show("Se Requiere informaci�n en el Campo <Tema>");			
		} else
			Messagebox.show("Se Requiere informaci�n en el Campo <Unidad>");
	}
	
	private void llenarListaSubTemas(){
		final Listitem listaItem = new Listitem();
		listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {

			@Override
			public void onEvent(Event arg0) throws Exception {						
				eliminaListItem(listaItem,"");
			}
		});			
		
		Listcell celdaUnidad = new Listcell(cmbListaUnidades.getValue());
		Listcell celdaTema = new Listcell(cmbListaTemas.getValue());
		Listcell celdaSubtema = new Listcell(txtSubTemas.getValue());
		listaItem.appendChild(celdaUnidad);
		listaItem.appendChild(celdaTema);
		listaItem.appendChild(celdaSubtema);
		
		listaSubtemas.appendChild(listaItem);
		txtSubTemas.setValue("");
	}
	
	/**
	 * Este metodo de encarga de Cargar, en el ComboBox de Temas de la pesta�a Subtemas, los datos hallados de acuerdo a la unidad Seleccionada.
	 * 
	 * @param lista.  Recibe el ListBox de donde se Extraeran los registros.
	 * @param unidad. Es el valor que se utilizar� para comparar.
	 */
	private void cargarTemasEnSubtemas(Listbox lista, String unidad){
		
		cmbListaTemas.getItems().clear();
		if (lista.getItemCount() > 0){
			for(int i=1;i<=lista.getItemCount(); i++){
				Listitem listaItem = (Listitem)lista.getChildren().get(i); 
				Listcell celdaTema = (Listcell)listaItem.getChildren().get(1);
				Listcell celdaUnidad = (Listcell)listaItem.getChildren().get(0);
				Comboitem itemTema = new Comboitem(celdaTema.getLabel());
				
				if (unidad.equals(celdaUnidad.getLabel()))
					cmbListaTemas.appendChild(itemTema);
			}
		}		
	}
	
	private void verificarCamposBibliografia(){
		if (!"".equals(cmbListaUnidadBiblio.getValue())){
			if (txtReferenciaBiblio.getValue() != null && (txtReferenciaBiblio.getValue().trim().length() > 0)){
				if (txtAutorBiblio.getValue() != null && (txtAutorBiblio.getValue().trim().length() > 0)){
					if (txtISBNBiblio.getValue() != null && (txtISBNBiblio.getValue().trim().length() > 0)){
						if (cmbTipoBibliografia.getValue() != null && (cmbTipoBibliografia.getValue().trim().length() > 0)){
							llenarListaBibliografia();
						} else
							Messagebox.show("Se Requiere informaci�n en el Campo <Tipo Bibliografia>");					
					} else
						Messagebox.show("Se Requiere informaci�n en el Campo <ISBN>");
				} else
					Messagebox.show("Se Requiere informaci�n en el Campo <Autor>");				
			} else
				Messagebox.show("Se Requiere informaci�n en el Campo <Referencia Bibliografica>");
		} else 
			Messagebox.show("Se Requiere informaci�n en el Campo <Nombre de la Unidad>");
	}
	
	private void llenarListaBibliografia(){
		final Listitem listaItem = new Listitem();
		
		listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {						
				eliminaListItem(listaItem,"");
			}
		});
		
		Listcell celdaUnidad = new Listcell(cmbListaUnidadBiblio.getValue());
		Listcell celdaReferencia = new Listcell(txtReferenciaBiblio.getValue());
		Listcell celdaAutor = new Listcell(txtAutorBiblio.getValue().toUpperCase());
		Listcell celdaISBN = new Listcell(txtISBNBiblio.getValue().toUpperCase());
		Listcell celdaTipo = new Listcell(cmbTipoBibliografia.getValue().toUpperCase());
		listaItem.appendChild(celdaUnidad);
		listaItem.appendChild(celdaReferencia);
		listaItem.appendChild(celdaAutor);
		listaItem.appendChild(celdaISBN);
		listaItem.appendChild(celdaTipo);
		listaBibliografia.appendChild(listaItem);		
		
		limpiarCamposBibliografia();
		txtReferenciaBiblio.focus();
	}
	
	private void limpiarCamposBibliografia(){
		txtReferenciaBiblio.setValue("");
		txtAutorBiblio.setValue("");
		txtISBNBiblio.setValue("");
		cmbTipoBibliografia.setValue("");
	}
	
	public void onClick$btnAddEvaluacion(Event event){
		verificarCamposEvaluacion();
	}
	
	private void verificarCamposEvaluacion(){
		if (txtActividadMicro.getValue() != null && (txtActividadMicro.getValue().trim().length() > 0)){
			if (txtPorcentajeActividad.getValue() != null && (txtPorcentajeActividad.getValue() > 0)){
				if (dtFechaEvaluacion.getValue() != null) {
					llenarListaActividades();
				} else{
					Messagebox.show("La Informaci�n del Campo <fecha> no es v�lida");
					dtFechaEvaluacion.setFocus(true);
				}					
			} else{
				Messagebox.show("Se Requiere informaci�n en el Campo <Porcentaje>");
				txtPorcentajeActividad.setFocus(true);
			}	
		} else {
			Messagebox.show("Se Requiere informaci�n en el Campo <Actividad>");
			txtActividadMicro.setFocus(true);
		}			
	}
	
	public void llenarListaActividades() {
		final Listitem listaItem = new Listitem();				
		listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {		
				eliminaListItem(listaItem,"");
			}
		});
		
		Listcell celdaActividad = new Listcell(txtActividadMicro.getValue());
		Listcell celdaPorcentaje = new Listcell(txtPorcentajeActividad.getValue().toString());
		String tmpFecha = formatoFecha.format(dtFechaEvaluacion.getValue());
		Listcell celdaFecha = new Listcell(tmpFecha);
		
		porcentajeEvaluacion = calcularPorcentaje();
		if (porcentajeEvaluacion > 100){
			Messagebox.show("No es posible agregar el registro a la lista. El porcentaje de las Evaluaciones supera el 100%. " +
					"\n Por favor verifique los valores.");			
		} else {
			listaItem.appendChild(celdaActividad);
			listaItem.appendChild(celdaPorcentaje);
			listaItem.appendChild(celdaFecha);
			listaEvaluaciones.appendChild(listaItem);
			txtActividadMicro.setValue("");
			txtPorcentajeActividad.setValue(null);
			dtFechaEvaluacion.setValue(null);
			txtActividadMicro.focus();
		}
	}
	
	private int calcularPorcentaje(){
		int porcentaje = Integer.parseInt(txtPorcentajeActividad.getValue().toString());
		for (int i=1; i <= listaEvaluaciones.getItems().size();i++){
			Listitem item = (Listitem) listaEvaluaciones.getChildren().get(i);
			Listcell celdaPorcentaje = (Listcell)item.getChildren().get(1);
			porcentaje = porcentaje + Integer.parseInt(celdaPorcentaje.getLabel());
		}
		
		return porcentaje;
	}
	
	private void verificarCamposCibergrafia(){
		if (!"".equals(cmbListaUnidadBiblio.getValue())){
			if (txtNombreSitioCiber.getValue() != null && (txtNombreSitioCiber.getValue().trim().length() > 0)){
				if (!"".equals(txtURLSitioCiber.getValue())){
					if (!"".equals(cmbTipoCibergrafia.getValue())){
						llenarListaCibergrafia();
					} else {
						Messagebox.show("Se Requiere informaci�n en el Campo <Tipo Cibergraf�a>");
					}
				} else {
					Messagebox.show("Se Requiere informaci�n en el Campo <URL Sitio>");
				}
			} else {
				Messagebox.show("Se Requiere informaci�n en el Campo <Nombre Sitio>");
			}				
		} else {
			Messagebox.show("Se Requiere informaci�n en el Campo <Nombre de la Unidad>");
		}
	}
	
	/**
	 * Este Metodo se encarga de llenar 
	 */
	private void llenarListaCibergrafia(){
		final Listitem listaItem = new Listitem();				
		listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {						
				eliminaListItem(listaItem, "");
			}
		});
		Listcell celdaUnidad = new Listcell(cmbListaUnidadBiblio.getValue());
		Listcell celdaSitio = new Listcell(txtNombreSitioCiber.getValue());
		Listcell celdaURL = new Listcell(txtURLSitioCiber.getValue());
		Listcell celdaTipo = new Listcell(cmbTipoCibergrafia.getValue());
		listaItem.appendChild(celdaUnidad);
		listaItem.appendChild(celdaSitio);
		listaItem.appendChild(celdaURL);
		listaItem.appendChild(celdaTipo);
		listaCibergrafia.appendChild(listaItem);
		txtNombreSitioCiber.setValue("");
		txtURLSitioCiber.setValue("");
		txtNombreSitioCiber.focus();
	}
	
	private String mostrarNombreDocente(String idDocente){
		String nombre = "";
		TbAdmPersona persona = null;
	
		try {
			persona = personaNGC.obtenerPersona(idDocente);
		} catch (ExcepcionesLogica e) {
			logger.error(e);
		}
		
		if (persona != null){
			nombre = persona.getVrApellidos()+" "+persona.getVrNombres();
		}	
		return nombre;
	}
	
	/**
	 * Este evento ocurre cuando se hace click en sobre el boton <AddCibergrafia>.
	 * 
	 * Captura y valora los valores y los adiciona al ListBox Listacibergrafia a traves del m�todo llenarListaCibergrafia
	 * 
	 * @param event
	 */
	public void onClick$btnAddCibergrafia(Event event){
		verificarCamposCibergrafia();
	}
	
	/**
	 * Eventos durante edicion
	 */
	
	public void onOK$cmbListaUnidadBiblio(){
		txtReferenciaBiblio.focus();
	}
	
	public void onOK$txtReferenciaBiblio(){
		txtAutorBiblio.focus();
	}
	
	public void onOK$txtAutorBiblio(){
		txtISBNBiblio.focus();
	}
	
	public void onOK$txtISBNBiblio(){
		cmbTipoBibliografia.focus();
	}
	
	public void onOK$cmbTipoBibliografia(){
		verificarCamposBibliografia();
	}
		
	public void onClick$btnAddBibliografia(Event event){
		verificarCamposBibliografia();
	}
	
	public void onOK$txtNombreSitioCiber(){
		txtURLSitioCiber.focus();
	}
	
	public void onOK$txtURLSitioCiber(){
		cmbTipoCibergrafia.focus();
	}
	
	public void onOK$cmbTipoCibergrafia(){
		verificarCamposCibergrafia();
	}
	
	public void onOK$cmbIdUnidad(){
		txtNombreTema.setFocus(true);
	}
	
	public void onOK$txtNombreTema(){
		txtNumeroSemanas.focus();
	}
	
	public void onOK$txtNumeroSemanas(){
		validarCamposTemas(txtNombreTema.getValue());
		cmbIdUnidad.setFocus(true);
	}
		
	public void onOK$txtSubTemas(){
		validarCamposSubtemas(cmbListaUnidades.getValue(), cmbListaTemas.getValue(), txtSubTemas.getValue());
		cmbListaUnidades.setFocus(true);
	}
	
	public void onOK$txtActividadMicro(){
		txtPorcentajeActividad.focus();
	}
	
	public void onOK$txtPorcentajeActividad(){
		dtFechaEvaluacion.focus();
	}
	
	public void onOK$dtFechaEvaluacion(){
		verificarCamposEvaluacion();
	}
	
	public void onSelect$cmbListaTemas(){
		txtSubTemas.setFocus(true);
	}
	
	public void onOK$cmbListaTemas(){
		txtSubTemas.setFocus(true);
	}
	
	
	public void onSelect$cmbDocente(){
		lblNombreDocente.setValue(mostrarNombreDocente(cmbDocente.getValue()));
	}
	
	public void onOK$cmbDocente(){
		lblNombreDocente.setValue(mostrarNombreDocente(cmbDocente.getValue()));
		if (!(lblNombreDocente.getValue().equals("") && (lblNombreDocente.getValue().trim().length() > 0)))
			cmbSemestre.focus();				
	}
	
	public void onOK$txtNombreUnidad(){
		llenarListaUnidades(txtNombreUnidad.getValue());
	}
	
	public void onOK$cmbListaUnidades(){		
		cargarTemasEnSubtemas(listaTemas, cmbListaUnidades.getValue());
		cmbListaTemas.focus();
	}
	
	public void onSelect$cmbListaUnidades(){
		cargarTemasEnSubtemas(listaTemas, cmbListaUnidades.getValue());
	}
	
	public void onSelect$fichaContenidos(){
		Tabpanel tabpanels = (Tabpanel)fichaContenidos.getSelectedPanel();
		int indice = tabpanels.getIndex();
		if (indice == 0){
			cmbDocente.focus();
		}else if (indice == 1){
			txtPropositoMicro.focus();
		}else if (indice == 2){
			txtNombreUnidad.focus();
		}else if (indice == 3){
			cmbListaUnidades.focus();
		}else if (indice == 4){
			txtActividadMicro.focus();
		}else if (indice == 5){
			cmbListaUnidadBiblio.focus();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {				
		super.doAfterCompose(comp);
		if("formaDuplicarMicro".equals(comp.getParent().getId().toString())){
			
			if(Executions.getCurrent().getSession().hasAttribute("idMicro")&&(Executions.getCurrent().getSession().hasAttribute("semestre"))){
				panelDuplicarMicro.setVisible(false);
				blyDuplicarMicro.setVisible(true);
				panelSemestre.setVisible(false);
				fichaContenidos.setVisible(true);
				cargarDocentes();
				
				String idMicrocurriculo = Executions.getCurrent().getSession().getAttribute("idMicro").toString();
				String idSemestre = Executions.getCurrent().getSession().getAttribute("semestre").toString();
				llenarDatos(idMicrocurriculo, idSemestre);
				
			}else if(Executions.getCurrent().getSession().hasAttribute("idMicro")){
				panelDuplicarMicro.setVisible(false);
				blyDuplicarMicro.setVisible(true);
				panelSemestre.setVisible(true);
				fichaContenidos.setVisible(false);
				String idMicrocurriculo = Executions.getCurrent().getSession().getAttribute("idMicro").toString();
				cargarSemestres(idMicrocurriculo);
				tool_print.setVisible(false);
				tool_save.setVisible(false);
			}else{
				panelDuplicarMicro.setVisible(true);
				blyDuplicarMicro.setVisible(false);
				tool_print.setVisible(false);
				tool_save.setVisible(false);
			}
		}else if("formaDetallesMicro".equals(comp.getParent().getId().toString())){
			if(Executions.getCurrent().getSession().hasAttribute("idMicro")){
				panelBuscarMicro.setVisible(false);
				blyConsultarMicro.setVisible(true);
				fichaContenidos.setVisible(true);
				if(Executions.getCurrent().getSession().hasAttribute("idMicro")){
					String idMicro = Executions.getCurrent().getSession().getAttribute("idMicro").toString();
					llenarDatos(idMicro);
				}
			}else{
				panelBuscarMicro.setVisible(true);
				blyConsultarMicro.setVisible(true);
				fichaContenidos.setVisible(false);
				tool_print.setVisible(false);
				tool_consulta_otro.setVisible(false);
			}
		}
		
	}
}