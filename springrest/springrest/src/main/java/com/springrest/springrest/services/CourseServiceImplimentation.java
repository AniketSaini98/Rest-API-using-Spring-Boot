package com.springrest.springrest.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Courses;

@Service
public class CourseServiceImplimentation implements CourseServices {

	@Autowired
	private CourseDao courseDao;
	//List<Courses> list;
	
	public CourseServiceImplimentation() {
//		list = new ArrayList<>();
//		list.add(new Courses(10, "FrontEnd Development", "This course contains Basic Concepts of FrontEnd Development"));
//		list.add(new Courses(20, "BackEnd Development", "This course contains Basic Concepts of BackEnd Development"));
	}
	
	@Override
	public List<Courses> getCourses() {
		return courseDao.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Courses getCourse(long courseId) {
		
//		Courses c = null;
//		
//		for(Courses course : list) {
//			
//			if(course.getId() == courseId) {
//				c = course;
//				break;
//			}
//		}
		
		return courseDao.getOne(courseId);
	}

	@Override
	public Courses addCourse(Courses course) {
//		list.add(course);
		courseDao.save(course);
		return course;
	}

	@Override
	public Courses updateCourse(Courses course) {
		
//		list.forEach(e -> {
//			if(e.getId() == course.getId()) {
//				e.setCourseName(course.getCourseName());
//				e.setCourseDescription(course.getCourseDescription());
//			}
//		});
		
		courseDao.save(course);
		return course;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteCourse(long parseLong) {
//		list = this.list.stream().filter(e -> e.getId() != parseLong).collect(Collectors.toList());
		Courses entity = courseDao.getOne(parseLong);
		courseDao.delete(entity);
	}

}
