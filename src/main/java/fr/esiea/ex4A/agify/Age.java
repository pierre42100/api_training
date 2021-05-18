package fr.esiea.ex4A.agify;

import com.google.gson.annotations.SerializedName;

public class Age {
    @SerializedName("name") private final String name;
    @SerializedName("age") private final int age;
    @SerializedName("count") private final int count;
    @SerializedName("country_id") private final String countryId;

    public Age(String name, int age, int count, String countryId) {
        this.name = name;
        this.age = age;
        this.count = count;
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getCount() {
        return count;
    }

    public String getCountryId() {
        return countryId;
    }
}

