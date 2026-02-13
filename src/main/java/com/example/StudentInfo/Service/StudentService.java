package com.example.StudentInfo.Service;

import com.example.StudentInfo.Model.Student;
import com.example.StudentInfo.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repository;


  //  private List<Student> students = new ArrayList<>();

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public String addStudent(Student student){
        repository.save(student);
        return "Successfully added";

    }

    public List<Student> getAll(){
        return repository.findAll();
    }


    public String deleteStudent(int id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return "user Deleted";
        }
        else{
            return "Student does not exist";
        }

    }


    public String updatestd(int id,Student student){
        if(repository.existsById(id)){
                Student s = repository.findById(id).orElseThrow(() -> new RuntimeException("Error"));

            s.setAge(student.getAge());
            s.setName(student.getName());
            s.setEmail(student.getEmail());
            repository.save(student);
            return "user updated    "+s;
        }
        else{
            return "User not exist";
        }
    }



}
