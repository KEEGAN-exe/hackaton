package pe.interbank.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.interbank.entity.Usuario;

import pe.interbank.service.UserService;

@RestController
@RequestMapping("/user")
public class UsuarioController {
	
	@Autowired
	public UserService us;
	

	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		Collection<Usuario> collection = us.findAll();
		
		if(collection.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
		return new ResponseEntity<>(collection,HttpStatus.OK);
	}

	@PostMapping("/registrar")
	public ResponseEntity<?> resgistrar_POST(@RequestBody Usuario user){
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String contraseniaEncriptada = passwordEncoder.encode(user.getPassword());
		user.setPassword(contraseniaEncriptada);
		us.insert(user);
		
		return new ResponseEntity<> ("Usuario Creado", HttpStatus.CREATED);
	}

	@PutMapping("/editar/{userId}")
	public ResponseEntity<?> editar_PUT(@RequestBody Usuario userNew, @PathVariable Integer userId){
		
		Usuario db = us.findById(userId);
		
		if(db!=null) {
			
			db.setNombre(userNew.getNombre());
			db.setApellido(userNew.getApellido());
			db.setUsuario(userNew.getUsuario());
			db.setPassword(userNew.getPassword());
			
			us.update(db);		
			return new ResponseEntity<>("Usuario Editado", HttpStatus.OK);
		}		
		return new ResponseEntity<>("Usuario con ID "+userId+" no existe", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{userId}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer userId){
		
		Usuario db = us.findById(userId);
		
		if(db!=null) {
			
			us.delete(userId);						
			return new ResponseEntity<>("Usuario borrado", HttpStatus.OK);
		}				
		return new ResponseEntity<>("Usuario con ID "+userId+" no existe", HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/buscar/{userId}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer userId){
		
		Usuario db = us.findById(userId);
		
		if(db!=null) {
							
			return new ResponseEntity<>(db, HttpStatus.OK);
		}				
		return new ResponseEntity<>("Usuario con ID "+userId+" no existe", HttpStatus.NOT_FOUND);
	}

}
