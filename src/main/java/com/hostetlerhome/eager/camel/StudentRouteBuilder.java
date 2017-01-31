package com.hostetlerhome.eager.camel;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by mikeh on 1/23/17.
 */
@Component
public class StudentRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("direct:students")
                .bean("studentRepository","findAll")
                .split(simple("${in.body}"))
                .log(LoggingLevel.WARN,"Name ${in.body.lastName} is taking ${in.body.subject.name}")
                .end()
                .end();
    }
}
