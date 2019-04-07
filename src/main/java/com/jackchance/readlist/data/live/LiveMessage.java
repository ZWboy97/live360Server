package com.jackchance.readlist.data.live;


import javax.persistence.*;

@Entity
@Table(name = "t_live_message")
public class LiveMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer liveRoomId;
    private String liveName;
    private String liveDesc;
    private Long publishTime;
    private String message;
    private String coverImageUrl;
    private Boolean isVr;
    private Integer liveStatus;
    private Long createTime;

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public Integer getLiveRoomId() {
        return liveRoomId;
    }

    public void setLiveRoomId(Integer liveRoomId) {
        this.liveRoomId = liveRoomId;
    }

    public String getLiveName() {
        return liveName;
    }

    public void setLiveName(String name) {
        this.liveName = name;
    }

    public String getLiveDesc() {
        return liveDesc;
    }

    public void setLiveDesc(String desc) {
        this.liveDesc = desc;
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

    public Boolean getIsVr() {
        return isVr;
    }

    public void setIsVr(Boolean vr) {
        isVr = vr;
    }

    public Integer getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(Integer liveStatus) {
        this.liveStatus = liveStatus;
    }
}
