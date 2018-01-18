package com.edgardo.controller;

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
	
	//Declarar el servicio
	@Autowired
	@Qualifier("courseServiceImpl")
	private static CourseService courseService;
	
	@GetMapping("/listcourses")
	public ModelAndView listAllCourses() {
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("courses",courseService.listAllCourses());
		return mav;
	}
	
	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course") Course course) {
		courseService.addCourse(course);
		return "redirect:/listCourses";
	}
}
