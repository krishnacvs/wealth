package com.cgi.wealth.component;

import com.cgi.wealth.lib.Assistant;
import com.cgi.wealth.lib.Cloak;
import com.cgi.wealth.lib.Mobile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class MobileComponent implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        execute();
    }

    private void execute() {
        Mobile mobile = new Mobile();
        mobile.onInt();
        mobile.isEqual("A","A");
        mobile.isEqual("A","a");
        mobile.isEqual("A","B");

        String A = "A";
        String B = "B";
        mobile.isEqual(A,B);
        var stringBuffer = new StringBuffer();
        stringBuffer.append("A");
        stringBuffer.append("A");
        A = stringBuffer.toString();
        B = "AA";
        mobile.isEqual(A,B);

        mobile.add(A,B);

        mobile.zeroDividedBy(10);

        mobile.genericsList();

        Assistant.Operator operator = new Assistant.Operator();
        operator.doJob();
        var a = 10;
        System.out.println("The value of a is "+a);
        System.out.println(mobile.incrementByOne(a));
        System.out.println("The value of a is "+a);
        var vararg = mobile.toArray(1,2,3,4,5);
        System.out.println(vararg);
    }
}
