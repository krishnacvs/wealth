package com.cgi.wealth.lib.eight;

import java.util.*;
import java.util.concurrent.SynchronousQueue;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Compiler is guessing the code
 */
public class MobileLamda {

    public static void main(String[] args) {
        var mobileLamda = new MobileLamda();
//        mobileLamda.lambdaInStream();
//        mobileLamda.intConsumerTest();
//        mobileLamda.stringFunctionTest();
//        mobileLamda.numberFunctionTest();
//        mobileLamda.lambdaAndFunctionInStream();
        //mobileLamda.parallelOperation();
        //mobileLamda.intConsumerTest();
        //System.out.println(mobileLamda.randomSupplier());
        mobileLamda.testUrinaryOperator();
    }

    private void testUrinaryOperator() {
        int i = 5;
        i = 7;
        UnaryOperator<Integer> operator = (input) -> input * input;
        System.out.println(operator.apply(i));
    }

    private void stringFunctionTest() {
        Function<String, String> l = (String x) -> x + "test";
        String x = l.apply("This is a ");
        System.out.println(x);
    }

    private void numberFunctionTest() {
        Function<Double, Double> l = (Double x) -> x + 3;
        Function<Double, Double> pow = (Double x) -> Math.pow(x,2);
        Double ex = l.andThen(pow).apply(3.0);
        System.out.println("EX "+ex);

        Function<Double, Double> half  = (Double y) -> y + 3.0;
        Function<Double, Double> p = (Double y) -> Math.pow(y,2);
        Double yx = l.compose(p).apply(3.0);
        System.out.println("YX "+yx);

        Function<Double, Double> i  = Function.identity();
        Double zx = l.compose(i).apply(3.0);
        System.out.println("zX "+zx);
    }

    private void intConsumerTest() {
        DoubleConsumer l = (double x) -> System.out.println(Math.pow(x,x));
        l.accept(9);
    }

    private void lambdaInStream() {
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        MathSquare s = (int x)->x * x;
        var squares = numbers.stream().map(x -> s.calculate(x)).collect(Collectors.toList());
        System.out.println(squares);
    }

    private void lambdaAndFunctionInStream() {
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        Function<Integer, Integer> s = (Integer x)->x * x;
        var squares = numbers.stream().map(x -> s.apply(x)).collect(Collectors.toList());
        System.out.println(squares);
    }

    private void parallelOperation(){
        List<Integer> dataList = Collections.synchronizedList(new LinkedList<>());
        IntStream.range(0,100).parallel().forEach(s ->dataList.add(s));
        System.out.println(dataList.size());
        var maxOffSet = Collections.max(dataList);
        System.out.println("maxList "+maxOffSet+"-"+dataList.get(maxOffSet));

        Set<Integer> dataSet = Collections.synchronizedSet(new HashSet<Integer>());
        IntStream.range(0,1000).parallel().forEach(s ->dataSet.add(s));
        System.out.println(dataSet.size());


        SynchronousQueue<Integer> dataQue = new SynchronousQueue<>();
        IntStream.range(0,10000).parallel().forEach(s -> {
            try {
                dataQue.put(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        maxOffSet = Collections.max(dataQue);
        System.out.println("size "+dataQue.size()+"max offset "+maxOffSet);

    }

    private void threadLambda(){
        Thread t1 = new Thread(()-> System.out.println("Thread t1"));
    }

    private void predicateLambda(){
        Predicate p = (i) -> Objects.isNull(i);

        List<String> dummyStrings = Arrays.asList(new String[]{"John", "Snow"});

        dummyStrings.forEach(t->p.test(t));
    }

    private int randomSupplier(){
        Supplier<Integer> randomValue = () -> new Random().nextInt();
        return  randomValue.get();
    }

}


@FunctionalInterface
interface MathSquare {
    int calculate(int x);

    default int add(int x, int y){
        return x+y;
    }
}
