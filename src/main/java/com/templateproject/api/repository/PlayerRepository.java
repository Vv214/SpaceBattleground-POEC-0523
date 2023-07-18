package com.templateproject.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.templateproject.api.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
