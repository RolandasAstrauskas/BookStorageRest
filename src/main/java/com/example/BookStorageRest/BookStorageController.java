package com.example.BookStorageRest;


import com.example.BookStorageRest.Item.Book;
import com.example.BookStorageRest.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


@RestController
@RequestMapping("/book")
public class BookStorageController {


    @Autowired
    private BookService bookService;


    @PostMapping("/addBasicBook")
    public String addBasicBook(@RequestParam int barcode,
                               @RequestParam String book,
                               @RequestParam String author,
                               @RequestParam int quantity,
                               @RequestParam double price) {

        return bookService.addBook(barcode, book, author, quantity, price);
    }

    @PostMapping("/addScienceJournal")
    public String addScienceJournal(@RequestParam int barcode,
                                    @RequestParam String book,
                                    @RequestParam String author,
                                    @RequestParam int quantity,
                                    @RequestParam double price,
                                    @RequestParam int index) {
        return bookService.addJournal(barcode, book, author, quantity, price, index);
    }

    @PostMapping("/addAntiqueBook")
    public String addAntiqueBook(@RequestParam int barcode,
                                 @RequestParam String book,
                                 @RequestParam String author,
                                 @RequestParam int quantity,
                                 @RequestParam double price,
                                 @RequestParam int year) {
        return bookService.addABook(barcode, book, author, quantity, price, year);
    }

    @GetMapping("/find/{barcode}")
    public Object findByBarcode(@PathParam("barcode") Integer barcode) {
        return bookService.findByBarcode(barcode);
    }

    @GetMapping("/list")
    public Iterable<Book> getBooks() {
        return bookService.getAll();
    }

    @RequestMapping("/itemPrice/{barcode}")
    public Object priceByBarcode(@PathParam("barcode") Integer barcode) {
        return bookService.priceByBarcode(barcode);
    }

    @PostMapping("updateBook/{barcode}")
    public String updateByBarcodeBook(@PathParam("barcode") Integer barcode,
                                      @RequestParam String book,
                                      @RequestParam String author,
                                      @RequestParam int quantity,
                                      @RequestParam double price) {
        return bookService.updateByBarcodeBook(barcode, book, author, quantity, price);
    }

    @PostMapping("updateJournal/{barcode}")
    public String updateByBarcodeJournal(@PathParam("barcode") Integer barcode,
                                         @RequestParam String book,
                                         @RequestParam String author,
                                         @RequestParam int quantity,
                                         @RequestParam double price,
                                         @RequestParam int index) {
        return bookService.updateByBarcodeJournal(barcode, book, author, quantity, price, index);
    }

    @PostMapping("updateABook/{barcode}")
    public String updateByBarcodeABook(@PathParam("barcode") Integer barcode,
                                       @RequestParam String book,
                                       @RequestParam String author,
                                       @RequestParam int quantity,
                                       @RequestParam double price,
                                       @RequestParam int year) {
        return bookService.updateByBarcodeABook(barcode, book, author, quantity, price, year);
    }
}