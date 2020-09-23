package com.revature.project2.models;

public enum Genre {

    // values declared within enums are constants and are comma separated
    BASEBALL("Baseball"),
    COWBOY("Cowboy"),
    BEANIE("Beanie"),
    VISOR("Visor"),
    SUN("Sun");

    private String genreName;

    // enum constructors are implicitly private
    Genre(String name) {
        this.genreName = name;
    }

    public static Genre getByName(String name) {

        for (Genre genre : Genre.values()) {
            if (genre.genreName.equals(name)) {
                return genre;
            }
        }

        return BASEBALL;

    }

    @Override
    public String toString() {
        return genreName;
    }

}
