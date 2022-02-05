package ru.skillbox;

public class Dimensions {
    private final int height;
    private final int width;
    private final int length;

    public Dimensions(int height, int width, int length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public int getHeight() {
        return height;
    }
    public Dimensions setHeight(int height){
        return new Dimensions( height, width, length);
    }

    public int getWidth() {
        return width;
    }
    public Dimensions setWidth(int width) {
        return new Dimensions(height, width, length);
    }

    public int getLength() {
        return length;
    }
    public Dimensions setLength(int length) {
        return new Dimensions(height, width, length);
    }

    public int Volume() {
        return height * width * length;
    }





}
