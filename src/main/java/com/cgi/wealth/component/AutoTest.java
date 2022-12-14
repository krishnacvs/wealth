package com.cgi.wealth.component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AutoTest {

    private ByName byNameTest;


    @Autowired
    private ByType typeTest;

    public ByName getByNameTest() {
        return byNameTest;
    }

    @Autowired
    public void setByNameTest(ByName byNameTest) {
        this.byNameTest = byNameTest;
    }

    public ByType getTypeTest() {
        return typeTest;
    }

    public void setTypeTest(ByType typeTest) {
        this.typeTest = typeTest;
    }
}
