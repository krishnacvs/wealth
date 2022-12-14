package com.cgi.wealth.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class QualificationExercise {

    @PostConstruct
    public void init() throws Exception
    {
        System.out.println(
                "Bean QualificationExercise has been "
                        + "instantiated and I'm "
                        + "the init() method");
    }

    @Autowired
    @Qualifier("Engineering")
    Qualification qualification;

    public QualificationExercise() {
        System.out.println(
                "Bean QualificationExercise has been "
                        + "contructed and I'm "
                        + "the contructor() method");
    }

    public QualificationExercise(Qualification qualification) {
        this.qualification = qualification;
    }

    public void printQualification(){

        System.out.println("QualificationExercise:: printQualification "+qualification.degreeName());
    }

    @PreDestroy
    public void destroy() throws Exception
    {
        System.out.println(
                "Container has been closed "
                        + "and I'm the destroy() method");
    }
}
