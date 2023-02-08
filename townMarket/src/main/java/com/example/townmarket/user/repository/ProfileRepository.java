package com.example.townmarket.user.repository;

import com.example.townmarket.user.entity.Profile;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
  Optional<Profile> findByNickName(String newNickname);

}
