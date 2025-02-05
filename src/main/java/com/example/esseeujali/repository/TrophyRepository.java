package com.example.esseeujali.repository;

import com.example.esseeujali.model.Trophy;
import com.example.esseeujali.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TrophyRepository extends JpaRepository<Trophy, Long> {
    List<Trophy> findByUserAndDescriptionContaining(User user, String descriptionPart);
}
