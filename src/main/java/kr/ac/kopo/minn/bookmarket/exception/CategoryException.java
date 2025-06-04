package kr.ac.kopo.minn.bookmarket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//카테고리를 찾을수 없을때 처리
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CategoryException extends RuntimeException {
    private String errorMessage;
    public CategoryException() {
        super();
        errorMessage = "요청한 도서 분야를 찾을수 없습니다";
        System.out.println(errorMessage);
    }
}
