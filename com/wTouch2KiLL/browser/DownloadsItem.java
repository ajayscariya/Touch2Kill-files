package com.wTouch2KiLL.browser;

import java.io.Serializable;
import mf.javax.xml.XMLConstants;

public class DownloadsItem implements Serializable {
    private Long date;
    private String description;
    private String file_path;
    private long id_d;
    private String link_d;
    private String name;
    private Integer progress;
    private Status status;

    public enum Status {
        Ok,
        InProgress,
        Fail
    }

    public String getName() {
        return this.name;
    }

    public DownloadsItem(long id, String name, String link_d) {
        this.progress = Integer.valueOf(0);
        this.status = Status.InProgress;
        this.description = XMLConstants.NULL_NS_URI;
        this.id_d = id;
        this.link_d = link_d;
        this.name = name;
    }

    public DownloadsItem(String name) {
        this.progress = Integer.valueOf(0);
        this.status = Status.InProgress;
        this.description = XMLConstants.NULL_NS_URI;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getProgress() {
        return this.progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long getId_d() {
        return this.id_d;
    }

    public void setId_d(long id_d) {
        this.id_d = id_d;
    }

    public String getLink_d() {
        return this.link_d;
    }

    public void setLink_d(String link_d) {
        this.link_d = link_d;
    }

    public String getFile_path() {
        return this.file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public Long getDate() {
        return this.date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
