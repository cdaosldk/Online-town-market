package com.example.townmarket.user.service;

import static org.hamcrest.core.Is.isA;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.example.townmarket.commons.jwtUtil.JwtUtil;
import com.example.townmarket.user.dto.SignupRequestDto;
import com.example.townmarket.user.entity.User;
import com.example.townmarket.user.repository.UserRepository;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

  @Mock
  UserRepository userRepository;

  @Mock
  JwtUtil jwtUtil;

  @Mock
  PasswordEncoder passwordEncoder;

  @InjectMocks
  UserServiceImpl userService;

  @Test
  @DisplayName("회원가입 성공 테스트")
  void signup() {

    //given
    SignupRequestDto requestDto = SignupRequestDto.builder()
        .username("username1")
        .password("password")
        .phoneNumber("010-xxxx-xxxx")
        .build();

    String username = requestDto.getUsername();
    String phoneNumber = requestDto.getPhoneNumber();

    User user = mock(User.class);

    given(userRepository.existsByUsername(username)).willReturn(
        false);
    given(userRepository.existsByPhoneNumber(phoneNumber)).willReturn(false);

    //when
    String signup = userService.signup(requestDto);

    //then
    verify(userRepository, times(1)).save(any());
    Assertions.assertThat(signup).isEqualTo("회원가입 성공");
  }
}