package com.footprints.api.domain.history.entity;


import com.footprints.api.common.BaseTimeEntity;
import com.footprints.api.domain.member.entity.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
@ToString
public class History extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    /* 주문 번호 */
    private String orderId;

    /* 상품 번호 */
    private int bookId;

    /* 주문 수량 */
    private int bookCount;

    /* vam_orderItem 기본키 */
    private int orderItemId;

    /* 상품 한 개 가격 */
    private int bookPrice;

    /* 할인 적용된 가격 */
    private int salePrice;

    /* 총 가격(할인 적용된 가격 * 주문 수량) */
    private int totalPrice;

}