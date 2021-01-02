package com.example.BookStorageRest.Repository;

import com.example.BookStorageRest.Item.AntiqueBook;
import org.springframework.data.repository.CrudRepository;

public interface AntiqueBookRepository extends CrudRepository<AntiqueBook, Integer> {

    AntiqueBook findByBarcode(Integer barcode);

}
