package com.StudentManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.StudentManagement.Entity.Student;
import com.StudentManagement.Service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/list")
	public String getAllStudentList(Model model) {

		List<Student> allStudentsRecord = studentService.getAllStudentsRecord();
		model.addAttribute("list", allStudentsRecord);

		return "main-page";
	}

	@GetMapping("/addStudent")
	public String addStudentForm(Model model, Student student) {
		model.addAttribute("newStudent", student);
		return "add-student";

	}

	@PostMapping("/savestudent")
	public String saveStudent(@ModelAttribute("newStudent") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students/list";

	}

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int id) {
		studentService.deleteStudentById(id);
		return "redirect:/students/list";

	}

	@GetMapping("/update")
	public String updateStudent(@RequestParam("studentId") int id, Model model) {
		Student studentById = studentService.getStudentById(id);
		model.addAttribute("updateStudent", studentById);

		return "update-student";

	}

}
