package com.example.BookStorageRest.Item;

import javax.persistence.Entity;
import java.util.Calendar;

@Entity
public class AntiqueBook extends Book {

    private int releaseYear;

    public AntiqueBook() {
    }

    @Override
    public double totalPriceCalculator() {
        return super.totalPriceCalculator() * ((getCurrentYear() - this.releaseYear) / 10);
    }


    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }


    private int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}
