package com.uce.edu.matriculacion.service;

import com.uce.edu.matriculacion.repository.modelo.Matricula;
import com.uce.edu.matriculacion.repository.modelo.Propietario;
import com.uce.edu.matriculacion.repository.modelo.Vehiculo;

public interface IMatriculacionService {
	
	public Matricula buscar(String placa);
	public void guardar(Matricula matricula);
	public void actualizar (Matricula matricula);
	public void borrar(String placa);
	public void generarMatricula(Propietario propietario, Vehiculo vehiculo);

}
