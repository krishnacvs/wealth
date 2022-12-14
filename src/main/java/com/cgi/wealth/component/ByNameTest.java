package com.cgi.wealth.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ByNameTest implements ByName{
    @Override
    public void doTest() {
        log.info("ByNameTest is in progress");
    }
}
