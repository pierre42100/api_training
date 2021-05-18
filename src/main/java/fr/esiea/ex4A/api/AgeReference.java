package fr.esiea.ex4A.api;

import java.util.Objects;

public class AgeReference {
    private final String name;
    private final String country;

    public AgeReference(String name, UserCountry country) {
        this.name = name;
        this.country = country.toString();
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgeReference that = (AgeReference) o;
        return Objects.equals(name, that.name) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country);
    }
}
