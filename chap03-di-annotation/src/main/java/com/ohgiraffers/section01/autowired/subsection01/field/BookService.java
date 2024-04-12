package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* @Service : @Component의 세분화 어노테이션의 한 종류로 Sevice 계층에서 사용한다. */
@Service("bookServiceField")
public class BookService {

    /* BookDAO 타입의 빈(Bean) 객체를 이 프로퍼티에 자동으로 주입해준다.
    * (석현) 새로 객체 선언을 하지 않아도 메소드를 쓸 수 있음
    * 필드 주입인 경우 final을 쓸 수가 없음                          */
    @Autowired
    private BookDAO bookDAO;

    public List<BookDTO> selectAllBooks() {
        return bookDAO.selectBookList();
    }

    public BookDTO searchBookBySequence(int sequence) {
        return bookDAO.selectOneBook(sequence);
    }
}
