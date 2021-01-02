package com.example.BookStorageRest.Repository;

import com.example.BookStorageRest.Item.Book;
import org.springframework.data.repository.CrudRepository;

public interface BasicBookRepository extends CrudRepository<Book, Integer> {

    Book findByBarcode(Integer barcode);
}


