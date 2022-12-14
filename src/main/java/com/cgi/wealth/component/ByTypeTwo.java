package com.cgi.wealth.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ByTypeTwo implements ByType{
    public void doTest() {
        log.info("ByTypeTwo Test in progress");
    }
}
