package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import com.udea.proint1.microcurriculo.dao.AreaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmArea;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.ngc.AreaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class AreaNGCImpl implements AreaNGC {
	
	AreaDAO areaDao;
	
	
	public void setAreaDao(AreaDAO areaDao) {
		this.areaDao = areaDao;
	}
	

	public AreaNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarArea(TbAdmArea area) throws ExcepcionesLogica,
			ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarArea(TbAdmArea area) throws ExcepcionesLogica,
			ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public TbAdmArea obtenerArea(String id) throws ExcepcionesLogica,
			ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbAdmArea> listarAreas() throws ExcepcionesLogica,
			ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbAdmArea> listarAreasPorNucleo(TbAdmNucleo nucleo)
			throws ExcepcionesLogica, ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

}
