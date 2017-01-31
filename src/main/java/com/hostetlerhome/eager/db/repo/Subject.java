package com.hostetlerhome.eager.db.repo;

import javax.persistence.*;

/**
 * Created by mikeh on 1/23/17.
 */
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
