package ru.skillbox;

public class Country {
    private String nameCountry;
    private int population;
    private float square;
    private String nameOfCapital;
    private boolean accessToTheSea;

    public Country(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public float getSquare() {
        return square;
    }

    public void setSquare(float square) {
        this.square = square;
    }

    public String getNameOfCapital() {
        return nameOfCapital;
    }

    public void setNameOfCapital(String nameOfCapital) {
        this.nameOfCapital = nameOfCapital;
    }

    public boolean isAccessToTheSea() {
        return accessToTheSea;
    }

    public void setAccessToTheSea(boolean accessToTheSea) {
        this.accessToTheSea = accessToTheSea;
    }


}
