package com.example.townmarket.user.repository;

import com.example.townmarket.user.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByPhoneNumber(String phoneNumber);

  Boolean existsByEmail(String email);


  Boolean existsByNickname(String nickname);

  Optional<User> findByPhoneNumber(String phone);
  Optional<User> findByEmail(String email);


  Optional<User> findByKakaoId(Long kakaoId);
}
