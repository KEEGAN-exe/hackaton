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

import pe.interbank.entity.Detalle;
import pe.interbank.service.DetalleService;

@RestController
@RequestMapping("/detalle")
public class DetalleController {
	
	@Autowired
	public DetalleService ds;
	
	public DetalleController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		Collection<Detalle> collection = ds.findAll();
		
		if(collection.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
		return new ResponseEntity<>(collection,HttpStatus.OK);
	}

	@PostMapping("/registrar")
	public ResponseEntity<?> resgistrar_POST(@RequestBody Detalle detalle){
		ds.insert(detalle);
		return new ResponseEntity<> ("Detalle Creado", HttpStatus.CREATED);
	}

	@PutMapping("/editar/{detalleId}")
	public ResponseEntity<?> editar_PUT(@RequestBody Detalle detalleNew, @PathVariable Integer detalleId){
		
		Detalle db = ds.findById(detalleId);
		
		if(db!=null) {
			
			db.setCantidad(detalleNew.getCantidad());
			db.setPrecioUnitario(detalleNew.getPrecioUnitario());
			db.setSubtotal(detalleNew.getSubtotal());
			db.setPedido(detalleNew.getPedido());
			db.setProducto(detalleNew.getProducto());
			ds.update(db);		
			return new ResponseEntity<>("Detalle Editado", HttpStatus.OK);
		}		
		return new ResponseEntity<>("Detalle con ID "+detalleId+" no existe", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{detalleId}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer detalleId){
		
		Detalle db = ds.findById(detalleId);
		
		if(db!=null) {
			
			ds.delete(detalleId);						
			return new ResponseEntity<>("Detalle borrado", HttpStatus.OK);
		}				
		return new ResponseEntity<>("Detalle con ID "+detalleId+" no existe", HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/buscar/{detalleId}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer detalleId){
		
		Detalle db = ds.findById(detalleId);
		
		if(db!=null) {
			return new ResponseEntity<>(db, HttpStatus.OK);
		}				
		return new ResponseEntity<>("Detalle con ID "+detalleId+" no existe", HttpStatus.NOT_FOUND);
	}
}
