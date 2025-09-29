package kr.ac.kopo.minn.bookmarket.service;

import kr.ac.kopo.minn.bookmarket.domain.Order;

public interface OrderService {
    void confirmOrders(String bookId, long quantity);//책번호랑 재고수량
    Long saveOrder(Order order);
}
