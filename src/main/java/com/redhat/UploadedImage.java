package com.redhat;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public class UploadedImage implements Serializable {

    private String name;

    private int index;

    private BufferedImage image;

    public BufferedImage getImage() {

        return image;
    }

    public void setImage(BufferedImage image) {

        this.image = image;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getIndex() {

        return index;
    }

    public void setIndex(int index) {

        this.index = index;
    }

    @Override
    public String toString() {

        return "UploadedImage{" +
                "name='" + name + '\'' +
                ", index=" + index +
                ", image=" + image +
                '}';
    }

}