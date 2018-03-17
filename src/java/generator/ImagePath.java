package generator;

import java.io.File;

public enum ImagePath {
    IMAGE_1(File.separator + "img" + File.separator + "image1.png"),
    IMAGE_2(File.separator + "img" + File.separator + "image2.png"),
    IMAGE_3(File.separator + "img" + File.separator + "image3.png"),
    IMAGE_4(File.separator + "img" + File.separator + "image4.png"),
    IMAGE_5(File.separator + "img" + File.separator + "image5.png");

    private String path;

    ImagePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
