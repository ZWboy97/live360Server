package com.jackchance.readlist.jpa;

import com.jackchance.readlist.data.live.LiveMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: LiJiaChang
 * @Date: 2019/3/25 22:11
 */
public interface LiveMessageListRepository extends JpaRepository<LiveMessage, Integer> {

    List<LiveMessage> findAllById(Integer id);

}
