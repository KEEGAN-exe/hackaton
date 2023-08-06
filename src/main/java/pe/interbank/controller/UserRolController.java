package pe.interbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.interbank.entity.Rol;
import pe.interbank.entity.Usuario;
import pe.interbank.service.RolService;
import pe.interbank.service.UserService;
import pe.interbank.vo.UserRole;

@RestController
@RequestMapping("/user_role")
public class UserRolController {

		@Autowired
		private RolService roleService;
		
		@Autowired
		private UserService userService;

		public UserRolController() {
			// TODO Auto-generated constructor stub
		}
		

		@GetMapping("/listar1")
		public ResponseEntity<?> listar1_GET(){
			
			return new ResponseEntity<>(userService.findAll_withUsers1(),HttpStatus.OK);
		}
		
		@GetMapping("/listar2")
		public ResponseEntity<?> listar2_GET(){
			
			return new ResponseEntity<>(userService.findAll_withUsers2(),HttpStatus.OK);
		}
		
		@PostMapping("/registrar")
		public ResponseEntity<?> resgistrar_POST(@RequestBody UserRole userRole){
			
			Integer userId = userRole.getUser().getUserId();
			Usuario userDb = userService.findById(userId);
			
			if(userDb!= null) {
				
				Integer roleId = userRole.getRole().getRolId();
				Rol roleDb = roleService.findById(roleId);
				
				if(roleDb!= null) {
					
					userDb.addRole(roleDb); //user sufre cambio
					userService.update(userDb);//actualizar user en la base de datos
					
					return new ResponseEntity<>("User_Rol registrado", HttpStatus.OK);
				}
				return new ResponseEntity<>("Rol con ID "+roleId+" no existe", HttpStatus.NOT_FOUND);	
			}
			return new ResponseEntity<>("Usuario con ID "+userId+" no existe", HttpStatus.NOT_FOUND);
		}
	}

