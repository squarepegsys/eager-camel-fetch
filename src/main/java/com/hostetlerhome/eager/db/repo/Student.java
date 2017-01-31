package com.hostetlerhome.eager.db.repo;

import javax.persistence.*;

/**
 * Created by mikeh on 1/10/17.
 */
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column
    private String firstName;

    @Column
    private  String lastName;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="subject_id")
    private Subject subject;

    public Student() {

    }

    public Student(String firstName, String lastName, Subject subject) {

        this.firstName=firstName;
        this.lastName=lastName;
        this.subject=subject;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Student[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}
