package com.ohgiraffers.section02.initdestroy.subection01.java;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        /* (석현) init 메소드는 bean객체가 생성될 때 실행이 되는데 destroy 메소드는 close가 돼야지 실행이 됨 */
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
        cart1.addItem(carpBread);
        cart1.addItem(water);

        System.out.println("cart1에 담은 물품 : " + cart1.getItem());

        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItem(milk);

        System.out.println("cart2에 담은 물품 : " + cart2.getItem());

        ((AnnotationConfigApplicationContext)context).close();







    }
}
