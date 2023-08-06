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

import pe.interbank.entity.Producto;
import pe.interbank.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {

	public ProductoController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public ProductoService ps;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		Collection<Producto> collection = ps.findAll();
		
		if(collection.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
		return new ResponseEntity<>(collection,HttpStatus.OK);
	}

	@PostMapping("/registrar")
	public ResponseEntity<?> resgistrar_POST(@RequestBody Producto producto){
		ps.insert(producto);
		return new ResponseEntity<> ("Producto Creado", HttpStatus.CREATED);
	}

	@PutMapping("/editar/{productoId}")
	public ResponseEntity<?> editar_PUT(@RequestBody Producto productoNew, @PathVariable Integer productoId){
		
		Producto db = ps.findById(productoId);
		
		if(db!=null) {
			
			db.setNombre(productoNew.getNombre());
			db.setImage(productoNew.getImage());
			db.setPrecio(productoNew.getPrecio());
			db.setStock(productoNew.getStock());
			db.setCategoria(productoNew.getCategoria());
			
			ps.update(db);		
			return new ResponseEntity<>("Producto Editado", HttpStatus.OK);
		}		
		return new ResponseEntity<>("Producto con ID "+productoId+" no existe", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{productoId}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer productoId){
		
		Producto db = ps.findById(productoId);
		
		if(db!=null) {
			
			ps.delete(productoId);						
			return new ResponseEntity<>("Producto borrado", HttpStatus.OK);
		}				
		return new ResponseEntity<>("Producto con ID "+productoId+" no existe", HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/buscar/{productoId}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer productoId){
		
		Producto db = ps.findById(productoId);
		
		if(db!=null) {
			return new ResponseEntity<>(db, HttpStatus.OK);
		}				
		return new ResponseEntity<>("Producto con ID "+productoId+" no existe", HttpStatus.NOT_FOUND);
	}
}
