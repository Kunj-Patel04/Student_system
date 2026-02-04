package com.example.StudentInfo.Controller;

import com.example.StudentInfo.Model.Student;
import com.example.StudentInfo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/st")
    public Student addstd(@RequestBody Student student ){
        studentService.addStudent(student);
        return student;
    }

    @GetMapping
    public List<Student> All(){
        return studentService.getAll();
    }

    @DeleteMapping("/{id}")
    public String dele(@PathVariable int id){
        String msg = studentService.deleteStudent(id);
        return msg;
    }

    @PatchMapping("/{id}")
    public String updt(@PathVariable int id,@RequestBody Student student){
        String msg = studentService.updatestd(id,student);
        return msg;
    }


}
