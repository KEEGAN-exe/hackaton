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

import pe.interbank.entity.Categoria;
import pe.interbank.service.CategoriaService;

@RequestMapping("/categoria")
@RestController
public class CategoriaController {

	@Autowired
	public CategoriaService cs;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		Collection<Categoria> collection = cs.findAll();
		
		if(collection.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
		return new ResponseEntity<>(collection,HttpStatus.OK);
	}

	@PostMapping("/registrar")
	public ResponseEntity<?> resgistrar_POST(@RequestBody Categoria categoria){
		cs.insert(categoria);
		return new ResponseEntity<> ("Categoria Creado", HttpStatus.CREATED);
	}

	@PutMapping("/editar/{categoriaId}")
	public ResponseEntity<?> editar_PUT(@RequestBody Categoria categoriaNew, @PathVariable Integer categoriaId){
		
		Categoria db = cs.findById(categoriaId);
		
		if(db!=null) {
			
			db.setNombre(categoriaNew.getNombre());
			
			cs.update(db);		
			return new ResponseEntity<>("Categoria Editada", HttpStatus.OK);
		}		
		return new ResponseEntity<>("Categoria con ID "+categoriaId+" no existe", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{categoriaId}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer categoriaId){
		
		Categoria db = cs.findById(categoriaId);
		
		if(db!=null) {
			
			cs.delete(categoriaId);						
			return new ResponseEntity<>("Usuario borrado", HttpStatus.OK);
		}				
		return new ResponseEntity<>("Usuario con ID "+categoriaId+" no existe", HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/buscar/{categoriaId}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer categoriaId){
		
		Categoria db = cs.findById(categoriaId);
		
		if(db!=null) {
							
			return new ResponseEntity<>(db, HttpStatus.OK);
		}				
		return new ResponseEntity<>("Usuario con ID "+categoriaId+" no existe", HttpStatus.NOT_FOUND);
	}
}
