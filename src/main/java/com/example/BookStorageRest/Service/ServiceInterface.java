package com.example.BookStorageRest.Service;


import com.example.BookStorageRest.Item.Book;

public interface ServiceInterface {

    String addBook(int barcode, String book, String author,
                   int quantity, double price);

    String addJournal(int barcode, String book, String author,
                      int quantity, double price, int index);

    String addABook(int barcode, String book, String author,
                    int quantity, double price, int year);

    Object findByBarcode(Integer barcode);

    Iterable<Book> getAll();

    String updateByBarcodeBook(Integer barcode, String book, String author,
                         int quantity,double price);

    String updateByBarcodeJournal(Integer barcode, String book, String author,
                               int quantity,double price, int scienceIndex);

    String updateByBarcodeABook(Integer barcode, String book, String author,
                               int quantity,double price, int releaseYear);


    Object priceByBarcode(Integer barcode);

   }
