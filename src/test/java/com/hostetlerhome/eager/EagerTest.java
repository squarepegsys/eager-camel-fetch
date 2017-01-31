package com.hostetlerhome.eager;

import com.hostetlerhome.eager.db.repo.StudentRepository;
import org.apache.camel.ProducerTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by mikeh on 1/23/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EagerTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    ProducerTemplate producerTemplate;

    @Test
    public void testData() {

        assert studentRepository.findAll().size()==3;

    }

    @Test
    public void camelRoute() {

        producerTemplate.requestBody("direct:students", 3);
    }
}
