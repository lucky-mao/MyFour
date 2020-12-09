package com.cykj.bean;

import java.util.List;

public class DisFile {
    private int did;
    private List<File> files;

    public DisFile(int did, List<File> files) {
        this.did = did;
        this.files = files;
    }

    public DisFile() {
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
