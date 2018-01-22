package com.edgardo.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edgardo.entity.Course;
import com.edgardo.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	private static final String COURSES_VIEW = "courses";
	
	private static final Log LOG = LogFactory.getLog(CourseController.class);
	
	//Declarar el servicio
	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;
	//private static CourseService courseService;//Entrega error de variable null, sin indicar claramente cual es el problema
	
	@GetMapping("/listcourses")
	public ModelAndView listAllCourses() {
		LOG.info("Call: " + "listAllCourses()");
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		List<Course> l = courseService.listAllCourses();
		mav.addObject("courses",l);
		return mav;
	}
	
	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course") Course course) {
		LOG.info("Call: " + "addCourse()" + " -- Param: " + course.toString());
		courseService.addCourse(course);
		//return "redirect:/listCourses";//localhost:8181/listcourses//MAL
		return "redirect:/courses/listcourses";
	}
}
