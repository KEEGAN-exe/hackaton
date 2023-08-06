package pe.interbank.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.interbank.entity.Pedido;
import pe.interbank.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	public PedidoController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public PedidoService ps;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		Collection<Pedido> collection = ps.findAll();
		
		if(collection.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
		return new ResponseEntity<>(collection,HttpStatus.OK);
	}

	@PostMapping("/registrar")
	public ResponseEntity<?> resgistrar_POST(@RequestBody Pedido pedido){
		ps.insert(pedido);
		return new ResponseEntity<> ("Pedido Creado", HttpStatus.CREATED);
	}

	@PutMapping("/editar/{pedidoId}")
	public ResponseEntity<?> editar_PUT(@RequestBody Pedido pedidoNew, @PathVariable Integer pedidoId){
		
		Pedido db = ps.findById(pedidoId);
		
		if(db!=null) {
			
			db.setEstado(pedidoNew.getEstado());
			db.setFecha(pedidoNew.getFecha());
			db.setIgv(pedidoNew.getIgv());
			db.setSubtotal(pedidoNew.getSubtotal());
			db.setTotal(pedidoNew.getTotal());
			db.setUser(pedidoNew.getUser());
			
			ps.update(db);		
			return new ResponseEntity<>("Pedido Editado", HttpStatus.OK);
		}		
		return new ResponseEntity<>("Pedido con ID "+pedidoId+" no existe", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{pedidoId}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer pedidoId){
		
		Pedido db = ps.findById(pedidoId);
		
		if(db!=null) {
			
			ps.delete(pedidoId);						
			return new ResponseEntity<>("Producto borrado", HttpStatus.OK);
		}				
		return new ResponseEntity<>("Pedido con ID "+pedidoId+" no existe", HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/buscar/{pedidoId}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer pedidoId){
		
		Pedido db = ps.findById(pedidoId);
		
		if(db!=null) {
			return new ResponseEntity<>(db, HttpStatus.OK);
		}				
		return new ResponseEntity<>("Pedido con ID "+pedidoId+" no existe", HttpStatus.NOT_FOUND);
	}
}
