package com.estimate.pojo;

import java.util.ArrayList;
import java.util.List;

public class OlderTree {
    private String id;
    private String title;
    private String pid;
    private List<OlderTree> children = new ArrayList<>();

    public OlderTree() {
    }

    public OlderTree(String id, String title, String pid) {
        this.id = id;
        this.title = title;
        this.pid = pid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public List<OlderTree> getChildren() {
        return children;
    }

    public void setChildren(List<OlderTree> children) {
        this.children = children;
    }
}
