package sia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import sia.domain.Professor;
import sia.domain.Student;
import sia.domain.User;
import sia.domain.forms.RegistrationProfessorForm;
import sia.domain.forms.RegistrationStudentForm;
import sia.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/register")
public class RegisterController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(path = "/student/create", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User createStudent(@RequestBody RegistrationStudentForm registrationStudentForm) {
        return userService.save(registrationStudentForm.toStudent(passwordEncoder));
    }

    @GetMapping(path = "/student/get", produces = "application/json")
    public Student getStudent(@RequestBody String email) {
        return (Student) userService.findByEmail(email);

    }

    @PatchMapping(path="/student/update", consumes = "application/json")
    public Student updateStudent(@RequestBody RegistrationStudentForm data) {
        Student student = (Student) userService.findByEmail(data.getEmail());

        if (data.getName() != null)
            student.setName(data.getName());
        if (data.getEmail() != null)
            student.setEmail(data.getEmail());
        if (data.getPhone() != null)
            student.setPhone(data.getPhone());
        if (data.getAcademicSemester() != 0)
            student.setAcademicSemester(data.getAcademicSemester());
        if (data.getDegree() != null)
            student.setDegree(data.getDegree());

        userService.save(student);

        return student;
    }

    @DeleteMapping(path = "/student/delete", consumes = "text/plain")
    public void deleteStudent(@RequestBody String email) {
        userService.delete(email);
    }

    @PostMapping(path = "/professor/create", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User createProfessor(@RequestBody RegistrationProfessorForm registrationProfessorForm) {
        return userService.save(registrationProfessorForm.toProfessor(passwordEncoder));
    }

    @GetMapping(path = "/professor/get", produces = "application/json")
    public Professor getProfessor(@RequestBody String email) {
        return (Professor) userService.findByEmail(email);

    }

    @PatchMapping(path="/professor/update", consumes = "application/json")
    public Professor updateProfessor(@RequestBody RegistrationProfessorForm data) {
        Professor professor = (Professor) userService.findByEmail(data.getEmail());

        if (data.getName() != null)
            professor.setName(data.getName());
        if (data.getEmail() != null)
            professor.setEmail(data.getEmail());
        if (data.getPhone() != null)
            professor.setPhone(data.getPhone());
        if (data.getCareer() != null)
            professor.setCareer(data.getCareer());
        if (data.getYearsOfExperience() != 0)
            professor.setYearsOfExperience(data.getYearsOfExperience());

        userService.save(professor);

        return professor;
    }

    @DeleteMapping(path = "/professor/delete", consumes = "text/plain")
    public void deleteProfessor(@RequestBody String email) {

        userService.delete(email);
    }
}
