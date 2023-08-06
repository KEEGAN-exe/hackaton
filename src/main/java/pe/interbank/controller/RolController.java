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

import pe.interbank.entity.Rol;
import pe.interbank.service.RolService;

@RestController
@RequestMapping("/rol")
public class RolController {
	@Autowired
	private RolService rs;
	
	public RolController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		Collection<Rol> collection = rs.findAll();
		
		if(collection.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
		return new ResponseEntity<>(collection,HttpStatus.OK);
	}
	

	@PostMapping("/registrar")
	public ResponseEntity<?> resgistrar_POST(@RequestBody Rol role){
		rs.insert(role);
		return new ResponseEntity<> ("Rol Creado", HttpStatus.CREATED);
	}
	

	@PutMapping("/editar/{roleId}")
	public ResponseEntity<?> editar_PUT(@RequestBody Rol roleNew, @PathVariable Integer roleId){
		
		Rol db = rs.findById(roleId);
		
		if(db!=null) {
			
			db.setNombre(roleNew.getNombre());
			
			rs.update(db);		
			return new ResponseEntity<>("Rol Editado", HttpStatus.OK);
		}		
		return new ResponseEntity<>("Rol con ID "+roleId+" no existe", HttpStatus.NOT_FOUND);
	}
	

	@DeleteMapping("/borrar/{roleId}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer roleId){
		
		Rol db = rs.findById(roleId);
		
		if(db!=null) {
			
			rs.delete(roleId);						
			return new ResponseEntity<>("Rol borrado", HttpStatus.OK);
		}				
		return new ResponseEntity<>("Rol con ID "+roleId+" no existe", HttpStatus.NOT_FOUND);
	}
	
	

	@GetMapping("/buscar/{roleId}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer roleId){
		
		Rol db = rs.findById(roleId);
		
		if(db!=null) {
							
			return new ResponseEntity<>(db, HttpStatus.OK);
		}				
		return new ResponseEntity<>("Rol con ID "+roleId+" no existe", HttpStatus.NOT_FOUND);
	}
	
}
