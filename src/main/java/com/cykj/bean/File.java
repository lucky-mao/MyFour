package com.cykj.bean;

public class File {
    private int fid;
    private String fname;
    private int fileSize;
    private String fileRoad;
    private int did;
    private DisFile disFile;
    public File(int fid, String fname, int fileSize, String fileRoad, int did) {
        this.fid = fid;
        this.fname = fname;
        this.fileSize = fileSize;
        this.fileRoad = fileRoad;
        this.did = did;
    }

    public DisFile getDisFile() {
        return disFile;
    }

    public void setDisFile(DisFile disFile) {
        this.disFile = disFile;
    }

    public File() {
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileRoad() {
        return fileRoad;
    }

    public void setFileRoad(String fileRoad) {
        this.fileRoad = fileRoad;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }
}
