package com.ywqf.dto.in;

public class PublishDto {
    private String title;
    private String content;
    private int publishWorkerId;
    private int announcementId;

    public int getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(int announcementId) {
        this.announcementId = announcementId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPublishWorkerId() {
        return publishWorkerId;
    }

    public void setPublishWorkerId(int publishWorkerId) {
        this.publishWorkerId = publishWorkerId;
    }
}
