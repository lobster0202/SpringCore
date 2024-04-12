package com.ohgiraffers.section01.autowired.subsection01.field;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        /* autowired를 쓸때는 basePackage에 대한 정보를 쓴다. */
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        /* (석현) bookServiceField만 적으면 제대로 못 가져올 수도 있어서 BookService의 정보까지 확실하게 가져와야 함 */
        BookService bookService = context.getBean("bookServiceField", BookService.class);

        /* (석현) forEach는 함수를 인자로 받아서 함수를 반복적으로 실행하는 함수
         *        Collection의 각 요소를 System.out.println 메소드를 통해서 출력하겠다 라는 의미 */
        /* 전체 도서 목록 조회 후 출력 확인 */
        bookService.selectAllBooks().forEach(System.out::println);

        System.out.println(bookService.searchBookBySequence(1));
        System.out.println(bookService.searchBookBySequence(2));

    }
}
