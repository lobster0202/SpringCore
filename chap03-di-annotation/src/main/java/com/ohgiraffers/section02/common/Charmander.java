package com.ohgiraffers.section02.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
/*  @Primary 어노테이션을 설정하면 @Autowired로 동일한 타입의 여러 빈(bean)을 찾게 되는 경우
*   연결할 때 자동으로 우선 시 되는 타입으로 설정된다.
*   동일한 타입의 클래스 중 한 개만 @Primary 어노테이션을 사용할 수 있다.                  */
public class Charmander implements Pokemon {
    @Override
    public void attack() {
        System.out.println("파이리 불꽃 공격");
    }
}
