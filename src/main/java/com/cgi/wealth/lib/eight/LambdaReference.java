package com.cgi.wealth.lib.eight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LambdaReference{
    public static void main(String[] args) {
        LambdaReference lr = new LambdaReference();
        lr.testMethodReference();
    }

    private void testMethodReference() {
        List<ReferenceClass> sList = new ArrayList<>();
        ReferenceClass methodReferenceClass1 = new ReferenceClass();
        ReferenceClass methodReferenceClass2 = new ReferenceClass();
        sList.add(methodReferenceClass1);
        sList.add(methodReferenceClass2);
        sList.stream().forEach(ReferenceClass::show);

        List<Integer> integerList = Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9});
        List<ReferenceClass> referenceList = integerList
                .stream()
                .map(ReferenceClass::new)
                .collect(Collectors.toList());
        referenceList
                .stream()
                .forEach(ReferenceClass::show);

        StaticReferenceInterface mri = ReferenceClass::staticTest;
        mri.test();

        List<Integer> peekList = referenceList
                .stream()
                .peek(System.out::println)
                .map(r -> r.ref)
                .collect(Collectors.toList());
    }
}

interface StaticReferenceInterface {
    void test();
}

    class ReferenceClass {
        public int ref;
        public ReferenceClass(){

        }

        public ReferenceClass(Integer input) {
            this.ref = input;
        }

        public void show(){
            System.out.println("Show the result");
        }

        static void staticTest(){
            System.out.println("static result");
        }
    }