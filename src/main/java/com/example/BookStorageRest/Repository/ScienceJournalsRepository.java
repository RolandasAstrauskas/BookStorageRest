package com.example.BookStorageRest.Repository;

import com.example.BookStorageRest.Item.ScienceJournal;
import org.springframework.data.repository.CrudRepository;

public interface ScienceJournalsRepository extends CrudRepository<ScienceJournal, Integer> {

    ScienceJournal findByBarcode(Integer barcode);

    }
