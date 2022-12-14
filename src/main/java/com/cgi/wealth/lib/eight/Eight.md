**Functional Programming**
Functions can be passed to another functions and can be return from other functions 

**Lambda**
Anonymous functions that can be Passed into another method as argument

**Functional Interfaces that are already there in Java 8**
- Consumer  (This consumes the input) having a abstract Method Accept(Object obj)
- Predicate (This Functional Interface is used to test some condition) having abstract method test(Object obj)
- only Supplies does not accept, or return anything back having Method get()
- Function  Functional interface is used to apply some operation and return the object back, having method Object apply(Object obj)
    - BinaryOperator
      - Double
      - Int

What is :: (Double Column Operator) or Method reference.

- :: Operator of method reference can be used if we want to use an existing method available as Lambda.
- Function<String, String> fun = String::toUpperCase;




