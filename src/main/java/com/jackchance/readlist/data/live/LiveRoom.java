package com.jackchance.readlist.data.live;

import javax.persistence.*;

@Entity
@Table(name = "t_live_room")
public class LiveRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer hostId;
    private String roomName;
    private String roomDesc;
    private String roomCoverImageUrl;
    private Integer roomStatus;
    private String pullRTMPUrl;
    private String pullHLSUrl;
    private String playbackUrl;
    private Long startTime;
    private Long endTime;
    private Boolean isVr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHostId() {
        return hostId;
    }

    public void setHostId(Integer hostId) {
        this.hostId = hostId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    public String getRoomCoverImageUrl() {
        return roomCoverImageUrl;
    }

    public void setRoomCoverImageUrl(String roomCoverImageUrl) {
        this.roomCoverImageUrl = roomCoverImageUrl;
    }

    public Integer getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Integer roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getPullRTMPUrl() {
        return pullRTMPUrl;
    }

    public void setPullRTMPUrl(String pullRTMPUrl) {
        this.pullRTMPUrl = pullRTMPUrl;
    }

    public String getPullHLSUrl() {
        return pullHLSUrl;
    }

    public void setPullHLSUrl(String pullHLSUrl) {
        this.pullHLSUrl = pullHLSUrl;
    }

    public String getPlaybackUrl() {
        return playbackUrl;
    }

    public void setPlaybackUrl(String playbackUrl) {
        this.playbackUrl = playbackUrl;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Boolean getVr() {
        return isVr;
    }

    public void setVr(Boolean vr) {
        isVr = vr;
    }
}
