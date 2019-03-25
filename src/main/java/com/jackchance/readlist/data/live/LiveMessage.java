package com.jackchance.readlist.data.live;


import javax.persistence.*;

@Entity
@Table(name = "t_live_message")
public class LiveMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer liveRoomId;
    private String name;
    private String desc;
    private Long publishTime;
    private String message;
    private String coverImageUrl;
    private Boolean isVr;
    private Integer liveStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLiveRoomId() {
        return liveRoomId;
    }

    public void setLiveRoomId(Integer liveRoomId) {
        this.liveRoomId = liveRoomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Long publishTime) {
        this.publishTime = publishTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public Boolean getVr() {
        return isVr;
    }

    public void setVr(Boolean vr) {
        isVr = vr;
    }

    public Integer getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(Integer liveStatus) {
        this.liveStatus = liveStatus;
    }
}
