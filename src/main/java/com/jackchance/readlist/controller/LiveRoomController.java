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
        String paraments = "";
        if (liveRoom.getEnableHLS()) {
            paraments += "hls";
        }
        if (liveRoom.getEnableDVR()) {
            paraments += ".dvr";
        }
        if (liveRoom.getEnableTransform()) {
            paraments += ".transform";
        }
        String baseUrl = Const.RTMP_PREFIX + "/live360/" + liveName;
        String pushUrl = baseUrl;
        if (!paraments.equals("")) {
            pushUrl += "...vhost..." + paraments;
        }
        String pullRTMPUrl = pushUrl + ".flv";
        String pullHLSUrl = Const.HTTP_PREFIX + "/live360/" + liveName + ".m3u8";
        String playbackUrl = Const.HTTP_PREFIX + "/Live360WebPlayer/Live360Player.html?appname=live360&id=" + liveName;
        liveRoom.setHostId(00000001);
        liveRoom.setRoomStatus(1);
        liveRoom.setPlaybackUrl(playbackUrl);
        liveRoom.setPushUrl(pushUrl);
        liveRoom.setPullHLSUrl(pullHLSUrl);
        liveRoom.setPullRTMPUrl(pullRTMPUrl);
        Date date = new Date();
        liveRoom.setCreateTime(date.getTime());
        liveRoom.setEnableVr(liveRoom.getVR());
        if (liveRoom.getEnableDVR()) {
            String dvrUrl = Const.HTTP_PREFIX + "/live360/" + liveName + ".flv";
            liveRoom.setDvrUrl(dvrUrl);
        }
        if (liveRoom.getEnableTransform()) {
            String transformUrl = Const.RTMP_PREFIX + "/live360/" + liveName + "...vhost..." + paraments;
            liveRoom.setTransformUrl(transformUrl);
        }
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

    @RequestMapping(value = "/{roomid}", method = RequestMethod.POST)
    public void updateLiveRoom(@RequestBody LiveRoom liveRoom) {
        this.repository.saveAndFlush(liveRoom);
    }


}
