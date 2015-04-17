package com.gc.java.core.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gc on 18.04.2015.
 */
public class GenericTest {

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<Apple>();
        apples.add(new Apple());
        List<?> unknownFruit = apples;
        for (Object o : unknownFruit) {
            System.out.println(o);
        }
        //unknownFruit.add(new Apple()); - not allowed type is unknown
        unknownFruit.add(null); // allowed only



        List<? extends Fruit> upperBounded = apples;
        for (Fruit fruit : upperBounded) {
            System.out.println(fruit);
        }
        //upperBounded.add(new Apple()); not allowed exact type is unknown besides it child of Fruit nevertheless
        //upperBounded.add(new Fruit()); exact type is unknown

        List<? super Apple> lowerBounded = new ArrayList<Apple>();
        //lowerBounded.add(new Fruit()); not allowed exact type of ? is unknown
        lowerBounded.add(new Apple());
        lowerBounded.add(new GreenApple());
        Object o = lowerBounded.get(0);
        System.out.println(o);

    }

}

class Fruit {

}

class Apple extends Fruit {

}

class GreenApple extends Apple {

}

class Orange extends Fruit {

}
