package kr.ac.kopo.minn.bookmarket.repository;

import kr.ac.kopo.minn.bookmarket.domain.Cart;

public interface CartRepository {
    Cart create(Cart cart);
    Cart read (String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);//전체 카드 삭제
}

