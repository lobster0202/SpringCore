package com.ohgiraffers.section01.scope.subsection02.prototype;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ContextConfiguration {

    @Bean
    public Product carpBread() {
        return new Bread("붕어빵", 1000, new java.util.Date());
    }
    @Bean
    public Product milk() {
        return new Beverage("바나나우유", 1500, 500);
    }
    @Bean
    public Product water() {
        return new Beverage("지리산암반수", 3000, 500);
    }
    @Bean
//    @Scope("singleton") 으로 돼있다고 보면 됨
    @Scope("prototype")
    public ShoppingCart cart() {
        return new ShoppingCart();
    }

    /*  XML 파일에서 <bean> 태그를 이용할 경우
    *   <bean id="cart> class="com.ohgiraffers.section1.xmlconfig.ShoppingCart" scope="prototype"/ */
}
