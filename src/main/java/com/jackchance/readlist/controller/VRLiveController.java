package com.jackchance.readlist.controller;

import com.jackchance.readlist.data.live.LiveMessage;
import com.jackchance.readlist.jpa.LiveMessageListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: LiJiaChang
 * @Date: 2019/3/25 22:07
 */

@RestController
@RequestMapping("/livelist")
public class VRLiveController {

    @Autowired
    private LiveMessageListRepository repository;

    public VRLiveController(LiveMessageListRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<LiveMessage> getLiveMessages() {
        return this.repository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public LiveMessage postLiveMessage(@RequestBody LiveMessage liveMessage){
        return this.repository.save(liveMessage);
    }

}
