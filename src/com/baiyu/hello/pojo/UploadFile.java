package com.baiyu.hello.pojo;

import org.springframework.web.multipart.MultipartFile;


public class UploadFile {
    private MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
