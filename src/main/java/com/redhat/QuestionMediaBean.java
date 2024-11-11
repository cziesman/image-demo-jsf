package com.redhat;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuestionMediaBean {

    private static final Logger LOG = LoggerFactory.getLogger(QuestionMediaBean.class);

    private final List<UploadedImage> images = new ArrayList<>();

    public QuestionMediaBean() {

        System.setProperty("java.awt.headless", "true");

        loadImages();
    }

    public List<UploadedImage> getImages() {

        return images;
    }

    /*
        Encodes a BufferedImage as Base64 for display in a JSP using the 'data' URI.
     */
    public String encodedImage(int index) throws IOException {

        int scaleWidthPixels = 128;

        BufferedImage image = getImages().get(index).getImage();

        Image scaled = image.getScaledInstance(scaleWidthPixels, -1, BufferedImage.SCALE_SMOOTH);
        image = new BufferedImage(scaled.getWidth(null), scaled.getHeight(null), BufferedImage.TYPE_INT_RGB);
        image.getGraphics().drawImage(scaled, 0, 0, null);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(image, "jpeg", out);

        byte[] bytes = out.toByteArray();
        String encoded = Base64.getEncoder().encodeToString(bytes);
        encoded = encoded.replace(System.lineSeparator(), "");

        return "data:image/jpeg;base64," + encoded;
    }

    /*
        Uses a static image to simulate a DB with stored images.
     */
    protected void loadImages() {

        for (int index = 0; index < 4; index++) {
            try {
                UploadedImage uploadedImage = new UploadedImage();

                uploadedImage.setIndex(index);
                uploadedImage.setName("img" + index + ".jpg");
                uploadedImage.setImage(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("images/img.jpg"))));

                images.add(uploadedImage);
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
                throw new RuntimeException(e);
            }
        }
    }

}