package pe.interbank.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.interbank.entity.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Integer>{

	@Query(value="select * from users_roles",nativeQuery=true)
	public abstract Collection<Object[]> findAll_withUsers1();
	
	@Query(value="SELECT us.user_id, us.usuario AS 'users', ro.rol_id, ro.nombre AS 'roles'\r\n"
			+ "FROM users_roles ur\r\n"
			+ "INNER JOIN users us ON ur.user_id = us.user_id\r\n"
			+ "INNER JOIN roles ro ON ur.rol_id = ro.rol_id\r\n"
			+ "ORDER BY us.user_id, ro.rol_id;",nativeQuery=true)
	public abstract Collection<Object[]> findAll_withUsers2();
	
	@Query(value="select * from users where usuario=?1", nativeQuery=true)
	public abstract Usuario findByUsername(String usuario);
}
