package com.uce.edu.matriculacion.repository;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.matriculacion.repository.modelo.Propietario;

@Repository
public class PropietarioRepositoryImpl implements IPropietarioRepository{
	
	private List<Propietario> base = new ArrayList<Propietario>();

	@Override
	public Propietario seleccionar(String cedula) {
		// TODO Auto-generated method stub
		for(Propietario propietario: base) {
			if( propietario.getCedula().equals(cedula)) {
				Propietario tmpPropietario = new Propietario();
				tmpPropietario.setNombre(propietario.getNombre());;
				tmpPropietario.setApellido(propietario.getApellido());;
				tmpPropietario.setCedula(propietario.getCedula());
				tmpPropietario.setGenero(propietario.getGenero());
				return tmpPropietario;
			}
		}
		return null;
	}
	public Propietario seleccionarEliminar(String cedula) {
		// TODO Auto-generated method stub
		for(Propietario propietario: base) {
			if( propietario.getCedula().equals(cedula)) {
			
				return propietario;
			}
		}
		return null;
	}

	@Override
	public void insertar(Propietario propietario) {
		// TODO Auto-generated method stub
		base.add(propietario);

	}

	@Override
	public void actualizar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.eliminar(propietario.getCedula());
		this.insertar(propietario);

	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		Propietario tmpPropietario = this.seleccionar(cedula);
		base.remove(tmpPropietario);

	}

}
