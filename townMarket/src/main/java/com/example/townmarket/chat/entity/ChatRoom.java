package com.example.townmarket.chat.entity;

import com.example.townmarket.product.entity.Product;
import com.example.townmarket.user.entity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoom {

  /**
   * 컬럼 - 연관관계 컬럼을 제외한 컬럼을 정의합니다.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "room_id")
  private Long id;

  @Column(name = "room_name")
  private String roomName;

  @Column(nullable = false, name = "product_id")
  private Long productId;

  @Column(nullable = false, name = "seller_id")
  private Long seller;

  @Column(nullable = false, name = "visitor_id")
  private Long buyer;

  @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<ChatMessage> message = new LinkedHashSet<>();


  /**
   * 생성자 - 약속된 형태로만 생성가능하도록 합니다.
   */
  public ChatRoom(Product product, User user) {
    this.roomName = product.getProductName();
    this.productId = product.getId();
    this.seller = product.getUserId();
    this.buyer = user.getId();
    this.user = user;
  }


  /**
   * 연관관계 - Foreign Key 값을 따로 컬럼으로 정의하지 않고 연관 관계로 정의합니다.
   */
  @ManyToOne
  private User user;

  /**
   * 연관관계 편의 메소드 - 반대쪽에는 연관관계 편의 메소드가 없도록 주의합니다.
   */

  /**
   * 서비스 메소드 - 외부에서 엔티티를 수정할 메소드를 정의합니다. (단일 책임을 가지도록 주의합니다.)
   */
}
