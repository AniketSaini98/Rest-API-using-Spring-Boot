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
	
	public CourseServiceImplimentation() {
	}
	
	@Override
	public List<Courses> getCourses() {
		return courseDao.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Courses getCourse(long courseId) {
		return courseDao.getOne(courseId);
	}

	@Override
	public Courses addCourse(Courses course) {
		courseDao.save(course);
		return course;
	}

	@Override
	public Courses updateCourse(Courses course) {
		courseDao.save(course);
		return course;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteCourse(long parseLong) {
		Courses entity = courseDao.getOne(parseLong);
		courseDao.delete(entity);
	}

}
