package pe.interbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.interbank.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
