package com.example.demo.bcp.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.bcp.exception.ModelNotFoundException;
import com.example.demo.bcp.model.TipoCambio;
import com.example.demo.bcp.service.TipoCambioService;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

@RestController
@RequestMapping("/tc")
public class TipoCambioController {

	@Autowired
	TipoCambioService tipoCambioService;
	public TipoCambio respuesta = new TipoCambio();

	@GetMapping("/version")
	public String version() {
		return "tipocambio v1.2"; 
	}
	
	@PostMapping("/calcular")
	public TipoCambio calcular2(@RequestBody TipoCambio t) throws InterruptedException {
		observadorPrecio2(t);
		return respuesta;
	}
	
	@PostMapping("/update")
	public TipoCambio update(@RequestBody TipoCambio o) {
		return tipoCambioService.update(o);
	}
	
	@PostMapping("/save")
	public long save(@RequestBody TipoCambio o) {
		tipoCambioService.save(o);
		return o.getId();
	}

	@GetMapping("/listAll")
	public Iterable<TipoCambio> listAllPersons() {
		return tipoCambioService.list();
	}

	@GetMapping("/list/{id}")
	public TipoCambio listPersonById(@PathVariable("id") int id) {
		Optional<TipoCambio> o = tipoCambioService.listId(id);
		if (o.isPresent()) {
			return o.get();
		}
		throw new ModelNotFoundException("Invalid find person provided");
	}

	@PostMapping("/delete")
	public void delete(@RequestBody TipoCambio o) {
		tipoCambioService.delete(o);
	}

	
	private TipoCambio observadorPrecio2(TipoCambio tipoCambio) {
		
		Subscriber<TipoCambio> s7 = new Subscriber<TipoCambio>() {
			@Override
			public void onNext(TipoCambio s) {
				System.out.println("OneNext ANTES DE INSERTAR: " + s);
				respuesta=tipoCambioService.save(s);
				System.out.println("OneNext Despues de INSERTAR: " + s);
			}

			@Override
			public void onCompleted() {
				System.out.println("onCompleted ANTES DE INSERTAR: " );
				System.out.println("onCompleted Despues de INSERTAR: ");
			}

			@Override
			public void onError(Throwable e) {
				System.out.println("OnError");
			}
		};

		
		Observable<TipoCambio> o7 = Observable.just(tipoCambio)
		.map(new Func1<TipoCambio,TipoCambio>() {
			@Override
			public TipoCambio call(TipoCambio t) {
				System.out.println("ANTES de calcular : " + t);
				if(t.getId()==null){
					Double respuesta=getMonto(tipoCambio);
					tipoCambio.setRespuesta(respuesta);
					System.out.println("DESPUES de calcular : " + t);
					return tipoCambio;
				}
				return null;
			};
		});
		
		o7.subscribe(s7);
		System.out.println("Procesando...");
		return null; 
		 
	}
	
	public static Double getMonto(TipoCambio tipocambio) {
		if(tipocambio.getMonedades().equals("dolar")) {
			return tipocambio.getMonto()*tipocambio.getTipocam();	
		}else {
			return tipocambio.getMonto()/tipocambio.getTipocam();
		}
		
	}
	
}
