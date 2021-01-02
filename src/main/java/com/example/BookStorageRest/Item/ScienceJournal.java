package com.example.BookStorageRest.Item;

import javax.persistence.Entity;

@Entity
public class ScienceJournal extends Book {

    private int scienceIndex;

    public ScienceJournal() {
    }

    public int getScienceIndex() {
        return scienceIndex;
    }

    public void setScienceIndex(int scienceIndex) {
        this.scienceIndex = scienceIndex;
    }

    @Override
    public double totalPriceCalculator() {
        return super.totalPriceCalculator() * this.scienceIndex;
    }
}
