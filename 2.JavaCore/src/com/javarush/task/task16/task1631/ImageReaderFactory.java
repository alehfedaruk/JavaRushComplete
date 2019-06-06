package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes img) {
        if (img == ImageTypes.BMP) {
            return new BmpReader();
        } else if (img == ImageTypes.JPG) {
            return new JpgReader();
        } else if (img == ImageTypes.PNG) {
            return new PngReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
    }
}