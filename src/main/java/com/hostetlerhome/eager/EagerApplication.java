package com.hostetlerhome.eager;

import com.hostetlerhome.eager.db.repo.Student;
import com.hostetlerhome.eager.db.repo.StudentRepository;
import com.hostetlerhome.eager.db.repo.Subject;
import com.hostetlerhome.eager.db.repo.SubjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mikeh on 1/10/17.
 */
@SpringBootApplication(scanBasePackages ="com.hostetlerhome.eager")
public class EagerApplication {

    private static final Logger log = LoggerFactory.getLogger(EagerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EagerApplication.class);
    }

    @Bean
    public CommandLineRunner loadData(StudentRepository studentRepository,  SubjectRepository subjectRepository) {

        return (args) -> {


            Subject subject = new Subject();
            subject.setName("Calculus");


            subject = subjectRepository.save(subject);


            List<Student> students = new ArrayList<>();
            
            String[] names = {"Johnny English","Sara Smith","Basil Fawlty"};

            for (String name : names){

                String[] parts = name.split(" ");
                students.add(new Student(parts[0],parts[1], subject));

            }

            students  = studentRepository.save(students);




        };
    }


}
