package com.tsf.PlayerRestApi.Repository;

import com.tsf.PlayerRestApi.Model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
