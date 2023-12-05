package com.uce.edu.matriculacion.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.matriculacion.repository.modelo.Vehiculo;

@Repository
public class VehiculoRepositoryImpl implements IVehiculoRepository {
	
	private List<Vehiculo> base = new ArrayList<Vehiculo>();

	@Override
	public Vehiculo seleccionar(String placa) {
		// TODO Auto-generated method stub
		for(Vehiculo vehiculo: base) {
			if( vehiculo.getPlaca().equals(placa)) {
				Vehiculo tmpVehiculo = new Vehiculo();
				tmpVehiculo.setMarca(vehiculo.getMarca());;
				tmpVehiculo.setPlaca(vehiculo.getPlaca());;
				tmpVehiculo.setPrecio(vehiculo.getPrecio());;
				tmpVehiculo.setTipo(vehiculo.getTipo());;
				return tmpVehiculo;
			}
		}
		return null;
	}
	public Vehiculo seleccionarEliminar(String placa) {
		// TODO Auto-generated method stub
		for(Vehiculo vehiculo: base) {
			if( vehiculo.getPlaca().equals(placa)) {
				
				return vehiculo;
			}
		}
		return null;
	}

	@Override
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		base.add(vehiculo);

	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.eliminar(vehiculo.getPlaca());
		this.insertar(vehiculo);

	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		Vehiculo tmpVehiculo = this.seleccionar(placa);
		base.remove(tmpVehiculo);

	}

}
