package com.cykj.mapper;

import com.cykj.bean.DisFile;
import com.cykj.bean.File;

import java.util.List;

public interface FileMapper {
    public List<DisFile> selectFile();
    public List<File> selectDisf();
    public List<File> sdfile();
}
