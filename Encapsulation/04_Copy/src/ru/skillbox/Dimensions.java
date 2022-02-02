package ru.skillbox;

public class Dimensions {
    private final float height;
    private final float width;
    private final float length;

    public Dimensions(float height, float width, float length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public float getHeight() {
        return height;
    }
    public Dimensions setHeight(float height){
        return new Dimensions( height, width, length);
    }

    public float getWidth() {
        return width;
    }
    public Dimensions setWidth(float width) {
        return new Dimensions(height, width, length);
    }

    public float getLength() {
        return length;
    }
    public Dimensions setLength() {
        return new Dimensions(height, width, length);
    }

    public float Volume() {
        return height * width * length;
    }





}
