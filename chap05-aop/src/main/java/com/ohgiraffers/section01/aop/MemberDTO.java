package com.ohgiraffers.section01.aop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberDTO {
    private Long id;
    private String name;
    private MemberDTO() {}

}
