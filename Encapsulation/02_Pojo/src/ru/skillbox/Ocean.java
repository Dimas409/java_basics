package ru.skillbox;

public class Ocean {
    private String nameOcean;
    private float square;
    private int averageDepth;

    public Ocean(String nameOcean, float square) {
        this.nameOcean = nameOcean;
        this.square = square;
    }

    public String getNameOcean() {
        return nameOcean;
    }

    public void setNameOcean(String nameOcean) {
        this.nameOcean = nameOcean;
    }

    public float getSquare() {
        return square;
    }

    public void setSquare(float square) {
        this.square = square;
    }

    public int getAverageDepth() {
        return averageDepth;
    }

    public void setAverageDepth(int averageDepth) {
        this.averageDepth = averageDepth;
    }
}
