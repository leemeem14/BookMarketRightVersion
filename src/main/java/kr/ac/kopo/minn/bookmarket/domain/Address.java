package kr.ac.kopo.minn.bookmarket.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue
    private int id;
    private String country;
    private String zipcode; //우편번호
    private String addressName; //기본주소
    private String detailAddress; // 상세주소
}
