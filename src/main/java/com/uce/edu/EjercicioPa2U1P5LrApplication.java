package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.matriculacion.repository.modelo.Propietario;
import com.uce.edu.matriculacion.repository.modelo.Vehiculo;
import com.uce.edu.matriculacion.service.IMatriculacionService;
import com.uce.edu.matriculacion.service.IPropietarioService;
import com.uce.edu.matriculacion.service.IVehiculoService;

@SpringBootApplication
public class EjercicioPa2U1P5LrApplication implements CommandLineRunner{
	@Autowired
	private IMatriculacionService iMatriculaService;
	@Autowired
	private IPropietarioService iPropietarioService;
	@Autowired
	private IVehiculoService iVehiculoService;


	public static void main(String[] args) {
		SpringApplication.run(EjercicioPa2U1P5LrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Vehiculo vehiculo = new Vehiculo();

		vehiculo.setMarca("Chevrolet");
		vehiculo.setPlaca("PDG-123");
		vehiculo.setPrecio(new BigDecimal(2000));
		vehiculo.setTipo("liviano");
		System.out.println(vehiculo);
		this.iVehiculoService.guardar(vehiculo);

		System.out.println("Nuevos Atributos ");
		vehiculo.setMarca("iZAYA");
		vehiculo.setPrecio(new BigDecimal(1500));
		System.out.println(vehiculo);
		this.iVehiculoService.actualizar(vehiculo);


		Propietario propietario = new Propietario();
		propietario.setApellido("Perez");
		propietario.setCedula("1750697898");
		propietario.setNombre("Alberto");
		propietario.setGenero("Masculino");

		this.iPropietarioService.guardar(propietario);

		this.iMatriculaService.generarMatricula(propietario, vehiculo);
		this.iMatriculaService.generarMatricula(propietario, vehiculo);
	}

}
