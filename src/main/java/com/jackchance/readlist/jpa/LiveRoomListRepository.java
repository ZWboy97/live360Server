package com.jackchance.readlist.jpa;

import com.jackchance.readlist.data.live.LiveRoom;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @Author: LiJiaChang
 * @Date: 2019/4/7 10:17
 */
public interface LiveRoomListRepository extends JpaRepository<LiveRoom,Integer > {

    @Override
    List<LiveRoom> findAll();

    @Override
    Optional<LiveRoom> findById(Integer integer);

    @Override
    List<LiveRoom> findAll(Sort sort);
}
