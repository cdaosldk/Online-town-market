package com.example.townmarket.common.domain.chat.dto;

import com.example.townmarket.common.domain.chat.entity.ChatRoom;
import com.example.townmarket.common.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoomListDto {

  private long roomId;
  private String profileImg;
  private String nickname;
  private String region;
  private String productName;
  private boolean isSeller; // 추가된 필드

  public ChatRoomListDto(ChatRoom room, User currentUser) {
    this.roomId = room.getId();
    this.productName = room.getProduct().getProductName();
    this.isSeller = room.getProduct().getUser().getId().equals(currentUser.getId()); // 판매자 여부 설정

    if (isSeller) {
      // 판매자인 경우
      this.profileImg = room.getUser().getProfile().getImg_url();
      this.nickname = room.getUser().getProfile().getNickName();
      this.region = room.getUser().getRegion();
    } else {
      // 구매자인 경우
      this.profileImg = room.getProduct().getUser().getProfile().getImg_url();
      this.nickname = room.getProduct().getUser().getProfile().getNickName();
      this.region = room.getProduct().getUser().getRegion();
    }
  }
}
