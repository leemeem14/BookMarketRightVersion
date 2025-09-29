package kr.ac.kopo.minn.bookmarket.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private long id;
    private String bookId;
    private int quantity;
    private BigDecimal totalPrice;
}
