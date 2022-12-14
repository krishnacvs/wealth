package com.cgi.wealth.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Slf4j
@Component
public class ByTypeOne implements ByType{

    public void doTest() {
        log.info("ByTypeOne Test in progress");
    }
}
