package com.jackchance.readlist.jpa;

import com.jackchance.readlist.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: LiJiaChang
 * @Date: 2019/4/23 14:40
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserById(Integer id);

    User findUserByUserName(String userName);

}
