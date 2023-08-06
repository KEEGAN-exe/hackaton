package pe.interbank.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.interbank.entity.Rol;
import pe.interbank.entity.Usuario;
import pe.interbank.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService, UserDetailsService{

	@Autowired
	public UserRepository ur;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario userDb = this.findByUsername(username);
		
		if(userDb!= null) {
			
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			
			for(Rol role : userDb.getRoles()) {
				authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getNombre()));
			}
			
			User user= new User(userDb.getUsuario(),userDb.getPassword(), authorities);
			
			return user;	
		}
		 
		throw new UsernameNotFoundException("Error, Usuario no encontrado!!!");
	}

	@Override
	public void insert(Usuario user) {
		ur.save(user);
	}

	@Override
	public void update(Usuario user) {
		ur.save(user);
	}

	@Override
	public void delete(Integer userId) {
		ur.deleteById(userId);
	}

	@Override
	public Usuario findById(Integer userId) {
		return ur.findById(userId).orElse(null);
	}

	@Override
	public Collection<Usuario> findAll() {
		return ur.findAll();
	}

	@Override
	public Collection<Object[]> findAll_withUsers1() {
		return ur.findAll_withUsers1();
	}

	@Override
	public Collection<Object[]> findAll_withUsers2() {
		return ur.findAll_withUsers2();
	}

	@Override
	public Usuario findByUsername(String usuario) {
		return ur.findByUsername(usuario);
	}

	
}
