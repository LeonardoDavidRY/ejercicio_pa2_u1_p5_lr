package com.uce.edu.matriculacion.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.matriculacion.repository.modelo.Matricula;
@Repository
public class MatriculaRepositoryImpl implements IMatriculaRepository {

	private static List<Matricula> base = new ArrayList<Matricula>();

	@Override
	public Matricula seleccionar(String placa) {
		// TODO Auto-generated method stub
		for(Matricula matricula: base) {
			if(matricula.getVehiculo().getPlaca().equals(placa)) {
				Matricula tmpMatricula = new Matricula();
				tmpMatricula.setFechaMatricula(matricula.getFechaMatricula());
				tmpMatricula.setPropietario(matricula.getPropietario());
				tmpMatricula.setValorMatricula(matricula.getValorMatricula());
				tmpMatricula.setVehiculo(matricula.getVehiculo());
				return tmpMatricula;
			}
		}
		return null;
	}
	public Matricula seleccionarEliminar(String cedula, String placa) {
		// TODO Auto-generated method stub
		for(Matricula matricula: base) {
			if(matricula.getPropietario().getCedula().equals(cedula) && matricula.getVehiculo().getPlaca().equals(placa)) {

				return matricula;
			}
		}
		return null;
	}

	@Override
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		base.add(matricula);

	}

	@Override
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.eliminar( matricula.getVehiculo().getPlaca());
		this.insertar(matricula);

	}

	@Override
	public void eliminar( String placa) {
		// TODO Auto-generated method stub
		Matricula tmpMatricula = this.seleccionar(placa);
		base.remove(tmpMatricula);

	}

}
