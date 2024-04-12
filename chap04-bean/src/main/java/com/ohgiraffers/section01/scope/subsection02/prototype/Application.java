package com.ohgiraffers.section01.scope.subsection02.prototype;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName : " + beanName);
        }

        // (석현) bean이름 설정을 안해줬으면 메소드 이름으로 가져오면 됨
        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);

        cart1.addItem(carpBread);
        cart1.addItem(milk);
//        cart1.addItem(water);

        System.out.println("cart1에 담긴 아이템 : " + cart1.getItem());

        /* scope가 singleton이라서 결과값이 겹치게 됨
        *  따라서 getBean으로 cart를 부르면 객체의 이름을 다르게 해도
        *  속(주소 값)이 똑같은 애가 됨 */
        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItem(water);

        System.out.println("cart2에 담긴 아이템 : " + cart2.getItem());

        System.out.println("cart1의 hashcode : " + cart1.hashCode());
        System.out.println("cart2의 hashcode : " + cart2.hashCode());

        /*  Spring Framwork에서 Bean의 기본 스코프는 singleton이다.
        *   singleton 스코프를 갖는 bEan은 어플리케이션 내에서 유일한 인스턴스를 갖는다.
        *   컨테이너는 cart라는 bean을 딸 한개만 가지고 있기 때문에 둘은 같은 주소값을 가지고 있다. */


    }
}
