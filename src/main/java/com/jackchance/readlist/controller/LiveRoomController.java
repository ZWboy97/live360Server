package com.jackchance.readlist.controller;

import com.jackchance.readlist.data.Const;
import com.jackchance.readlist.data.live.LiveRoom;
import com.jackchance.readlist.jpa.LiveRoomListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author: LiJiaChang
 * @Date: 2019/4/7 10:20
 */
@RestController
@RequestMapping("/live360/liverooms")
public class LiveRoomController {

    @Autowired
    private LiveRoomListRepository repository;

    public LiveRoomController(LiveRoomListRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<LiveRoom> getAllLiveRoom() {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        return this.repository.findAll(sort);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public LiveRoom postLiveRoom(@RequestBody LiveRoom liveRoom) {
        String liveName = String.valueOf(liveRoom.hashCode());
        String pushUrl = Const.PUSH_RTMP_PREFIX + "/live360/" + liveName;
        String pullRTMPUrl = pushUrl + ".flv";
        String pullHLSUrl = pushUrl + ".hls";
        String playbackUrl = pushUrl + ".mp4";
        liveRoom.setHostId(00000001);
        liveRoom.setRoomStatus(1);
        liveRoom.setPlaybackUrl(playbackUrl);
        liveRoom.setPushUrl(pushUrl);
        liveRoom.setPullHLSUrl(pullHLSUrl);
        liveRoom.setPullRTMPUrl(pullRTMPUrl);
        Date date = new Date();
        liveRoom.setCreateTime(date.getTime());
        return this.repository.save(liveRoom);
    }

    @RequestMapping(value = "/{roomid}", method = RequestMethod.GET)
    public LiveRoom getLiveRoomById(@PathVariable Integer roomId) {
        return this.repository.findById(roomId).get();
    }

    @RequestMapping(value = "/{roomid}", method = RequestMethod.DELETE)
    public void deleteLiveRoomById(@PathVariable Integer roomId) {
        this.repository.deleteById(roomId);
    }


}
