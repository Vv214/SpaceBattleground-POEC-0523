package com.templateproject.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.templateproject.api.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    public Player findByNickname(String nickname);

    public Player deletePlayerByNickname(String nickname);

    public Player findByLevel(Integer level);

    @Query("SELECT p FROM Player p WHERE p.id = :id")
    Player findByPlayerId(@Param("id") Integer id);
}
