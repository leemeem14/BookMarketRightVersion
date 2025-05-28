package kr.ac.kopo.minn.bookmarket.repository;

import kr.ac.kopo.minn.bookmarket.domain.Book;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private List<Book> listOfBooks = new ArrayList<Book>();

    public BookRepositoryImpl() {
        Book book1 = new Book();
        book1.setBookId("isbn0001");
        book1.setName("스프링부트완전정복");
        book1.setUnitPrice(BigDecimal.valueOf(35000));
        book1.setAuthor("송미영");
        book1.setDescription("스프링 부트는 스프링을 기반으로 쉽고 빠르게 웹 애플리케이션을 개발할 수 있는 도구이다. " +
                "이 책에서는 스프링 부트의 기본 개념을 쉽게 이해하고 다양한 실습 예제로 빠르게 익힐 수 있다. " +
                "그리고 단계별 실습을 따라 하다 보면 도서 쇼핑몰 구축 프로젝트를 완성할 수 있다. " +
                "개념-실습-프로젝트의 3단계 학습으로 스프링 부트를 제대로 익힌다면 개발 시간을 단축하고 생산성을 높일 수 있는 개발자로 성장할 수 있다.");
        book1.setPublisher("길벗캠퍼스");
        book1.setCategory("IT교재");
        book1.setUnitsInStock(1000);
        book1.setReleaseDate("2024/12/31");
        book1.setCondition("신규도서");
        book1.setFileName("isbn0001.jpg");

        Book book2 = new Book();
        book2.setBookId("isbn0002");
        book2.setName("앨리스 죽이기");
        book2.setUnitPrice(BigDecimal.valueOf(34000));
        book2.setAuthor("고바야시 야스미");
        book2.setDescription("《앨리스 죽이기》는 고바야시 야스미의 2011년작 공포 미스터리 장편소설으로, '메르헨 죽이기 시리즈'의 첫 작품이다." +
                " 루이스 캐럴의 동화 《이상한 나라의 앨리스》를 바탕으로 한 세계관 속에서, 이상한 나라와 지구를 오가며 연쇄 살인범을 추적하는 과정을 그렸다.");
        book2.setPublisher("검은숲");
        book2.setCategory("일본소설");
        book2.setUnitsInStock(800);
        book2.setReleaseDate("2015/12/21");
        book2.setCondition("신규도서");
        book2.setFileName("isbn0002.jpg");

        Book book3 = new Book();
        book3.setBookId("isbn0003");
        book3.setName("도로시 죽이기");
        book3.setUnitPrice(BigDecimal.valueOf(25000));
        book3.setAuthor("고바야시 야스미");
        book3.setDescription("꿈과 현실 사이를 오가며 연쇄살인마를 추적하는 과정을 그린 <앨리스 죽이기>. " +
                "<앨리스 죽이기>의 후속작 <도로시 죽이기>에서 '고바야시 월드'는 더 확장되고 공고해진다." +
                " <도로시 죽이기>는 영화, 뮤지컬 등 다양한 장르로 변주되어 사랑받는 동화 <오즈의 마법사>의 설정에," +
                " 작가가 <앨리스 죽이기>를 통해 완벽하게 구축해놓은 세계관을 더한 작품이다.");
        book3.setPublisher("검은숲");
        book3.setCategory("일본소설");
        book3.setUnitsInStock(1000);
        book3.setReleaseDate("2018/06/07");
        book3.setCondition("신규도서");
        book3.setFileName("isbn0003.jpg");

        listOfBooks.add(book1);
        listOfBooks.add(book2);
        listOfBooks.add(book3);
    }

    @Override
    public List<Book> getAllBookList() {
        return listOfBooks;
    }

    @Override
    public Book getBookById(String bookId) {
        Book bookInfo = null;
        for (Book book : listOfBooks) {
            if (book != null && book.getBookId()!=null && book.getBookId().equals(bookId)) {
                bookInfo = book;
                break;
            }
        }

        if(bookInfo==null){
            throw new IllegalArgumentException("도서번호가 "+ bookId +"인 해당 도서를 찾을 수 없습니다.");
        }

        return bookInfo;
    }

    @Override
    public List<Book> getBookListByCategory(String category) {
        List<Book> booksByCategory = new ArrayList<>();
        for (Book book : listOfBooks) {
            if (book.getCategory()!=null && book.getCategory().equals(category)) {
                booksByCategory.add(book);
            }
        }
        return booksByCategory;
    }

    @Override
    public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {
        Set<Book> booksByPublisher = new HashSet<Book>();
        Set<Book> booksByCategory = new HashSet<Book>();
        Set<String> booksByFilter = filter.keySet();

        if(booksByFilter.contains("publisher")){
            for (int i=0; i < filter.get("publisher").size(); i++ ) {
                String publisherName = filter.get("publisher").get(i);
                for (Book book : listOfBooks) {
                    if(publisherName.equalsIgnoreCase(book.getPublisher())){
                        booksByPublisher.add(book);
                    }
                }
            }
        }

        if(booksByFilter.contains("category")){
            for (int i=0; i < filter.get("category").size(); i++ ) {
                String categoryName = filter.get("category").get(i);
                List<Book> list = getBookListByCategory(categoryName);
                booksByCategory.addAll(list);
            }
        }

//        저장된 요소 중에서 두 Set의 비교하여 같은 값만 남기고 나머지는 제거하는 역할(교집합만 남김)
        booksByCategory.retainAll(booksByPublisher);

        return booksByCategory;
    }

    @Override
    public void setNewBook(Book book) {
        listOfBooks.add(book);
    }
}
