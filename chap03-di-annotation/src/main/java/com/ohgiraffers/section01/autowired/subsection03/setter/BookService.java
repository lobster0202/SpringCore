package com.ohgiraffers.section01.autowired.subsection03.setter;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceSetter")
public class BookService {

    private BookDAO bookDAO;

    /* BookDAO 타입의 빈(bean) 객체를 setter에 자동으로 주입해준다.
    *  이번에는 setter 메소드에 의존성을 주입하는 것                 */
    @Autowired
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
    public List<BookDTO> selectAllBooks() {
        return bookDAO.selectBookList();
    }

    public BookDTO searchBookBySequence(int sequnce) {
        return bookDAO.selectOneBook(sequnce);
    }
}
