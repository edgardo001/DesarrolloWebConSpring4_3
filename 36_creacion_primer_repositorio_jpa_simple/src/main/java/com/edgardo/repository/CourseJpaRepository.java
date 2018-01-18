package com.edgardo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edgardo.entity.Course;

//Repositorio JPA simple.
// Al extender de JpaRepository, 
// se implementan metodos por defecto 
// para el uso de consulta a la DB.
// El interface tambien permite poder crear metodos personalizados que sigan una logica que JPA Repository acepte
@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course,Serializable>{
	//Implementando metodos personalizados
	public abstract Course findByPrice(int price);
	public abstract Course findByPriceAndName(int price, String name);
	public abstract List<Course> findByNameOrderByHours(String name);
	public abstract Course findByNameOrPrice(String name, int price);
	
	//Tambien se puede implementar queryDSL para realizar consultas mas complejas
}
