package com.uce.edu.matriculacion.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.uce.edu.matriculacion.repository.IMatriculaRepository;
import com.uce.edu.matriculacion.repository.modelo.Matricula;
import com.uce.edu.matriculacion.repository.modelo.Propietario;
import com.uce.edu.matriculacion.repository.modelo.Vehiculo;
@Service
public class MatriculaServiceImpl implements IMatriculacionService {
	
	private IMatriculaRepository iMatriculaRepository;

	@Override
	public Matricula buscar(String placa) {
		// TODO Auto-generated method stub
		return this.iMatriculaRepository.seleccionar(placa);
	}

	@Override
	public void guardar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.iMatriculaRepository.insertar(matricula);

	}

	@Override
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.iMatriculaRepository.actualizar(matricula);

	}

	@Override
	public void borrar(String placa) {
		// TODO Auto-generated method stub
		this.iMatriculaRepository.eliminar(placa);

	}
	@Override
	public void generarMatricula(Propietario propietario, Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		if (this.buscar(vehiculo.getPlaca())==null) {
			
			BigDecimal valorFinal=null;
			if (vehiculo.getTipo().toLowerCase().equals("pesado")) {
				BigDecimal valorPesado = new BigDecimal(0.25);
				System.out.println("El valor pesado es: " + valorPesado);
				valorFinal = vehiculo.getPrecio().multiply(valorPesado);
				System.out.println("El valor final es: " + valorFinal);
			} else if (vehiculo.getTipo().toLowerCase().equals("liviano")) {
				BigDecimal valorLiviano = new BigDecimal(0.20);
				System.out.println("El valor pesado es: " + valorLiviano);
				valorFinal = vehiculo.getPrecio().multiply(valorLiviano);
				System.out.println("El valor final es: " + valorFinal);
			}else {
				System.out.println("No entra en ningun tipo de vehiculo");
			}
			BigDecimal valorMaximo = new BigDecimal(2200);
			if(valorFinal.compareTo(valorMaximo)==1) {
				BigDecimal descuento = valorFinal.multiply(new BigDecimal(0.05));
				System.out.println("El descuento es: "+ descuento);
				valorFinal = valorFinal.subtract(descuento);

			}
			
			Matricula tmpMatricula = new Matricula();
			tmpMatricula.setFechaMatricula(LocalDateTime.now());
			tmpMatricula.setPropietario(propietario);
			tmpMatricula.setValorMatricula(valorFinal);
			tmpMatricula.setVehiculo(vehiculo);

			this.guardar(tmpMatricula);
			System.out.println("Se guardo:"+tmpMatricula);

		} else {
			System.out.println("Este vehiculo ya esta registrado");
		}

	}

}
