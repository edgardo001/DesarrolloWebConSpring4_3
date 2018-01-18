package com.edgardo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edgardo.entity.Course;
import com.edgardo.repository.CourseJpaRepository;
import com.edgardo.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService{

	//Instancia de courseJpaRepository
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	@Override
	public List<Course> listAllCourses() {		
		return courseJpaRepository.findAll();
	}

	@Override
	public Course addCourse(Course course) {
		return courseJpaRepository.save(course);
	}

	@Override
	public int removeCourse(int id) {
		courseJpaRepository.delete(id);
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		//Es igual al addCourse.
		//Intentara actualizar el curso, 
		//si el curso tiene un id asociado, 
		//ira a la DB y consultara si existe, 
		//si existe en la db, realizara una sobreescritura(update) 
		//del curso entregado
		courseJpaRepository.save(course);
		return null;
	}

}
