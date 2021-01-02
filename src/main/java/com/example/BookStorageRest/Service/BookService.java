package com.example.BookStorageRest.Service;

import com.example.BookStorageRest.Item.AntiqueBook;
import com.example.BookStorageRest.Item.Book;
import com.example.BookStorageRest.Item.ScienceJournal;
import com.example.BookStorageRest.Repository.AntiqueBookRepository;
import com.example.BookStorageRest.Repository.BasicBookRepository;
import com.example.BookStorageRest.Repository.ScienceJournalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService implements ServiceInterface {

    @Autowired
    private BasicBookRepository basicBookRepository;
    @Autowired
    private ScienceJournalsRepository scienceJournalsRepository;
    @Autowired
    private AntiqueBookRepository antiqueBookRepository;


    @Override
    public String addBook(int barcode, String book, String author, int quantity, double price) {
        if (basicBookRepository.findByBarcode(barcode) != null) {
            return "This barcode is used!";
        }
        Book books = new Book();
        books.setBarcode(barcode);
        books.setBookName("\"" + book + "\"");
        books.setBookAuthor(author);
        books.setQuantity(quantity);
        books.setUnitPrice(price);
        basicBookRepository.save(books);
        return "New book added!";
    }

    @Override
    public String addJournal(int barcode, String book, String author, int quantity, double price, int index) {
        if (basicBookRepository.findByBarcode(barcode) != null) {
            return "This barcode is used!";
        } else if (index < 0 || index > 10) {
            return "Index must be from 1 to 10";
        }
        ScienceJournal scienceJournal = new ScienceJournal();
        scienceJournal.setBarcode(barcode);
        scienceJournal.setBookName("\"" + book + "\"");
        scienceJournal.setBookAuthor(author);
        scienceJournal.setQuantity(quantity);
        scienceJournal.setUnitPrice(price);
        scienceJournal.setScienceIndex(index);
        scienceJournalsRepository.save(scienceJournal);
        return "New journal added!";
    }

    @Override
    public String addABook(int barcode, String book, String author, int quantity, double price, int year) {
        if (basicBookRepository.findByBarcode(barcode) != null) {
            return "This barcode is used!";
        } else if (year >= 1900) {
            return "The year must be before 1900";
        }
        AntiqueBook antiqueBook = new AntiqueBook();
        antiqueBook.setBarcode(barcode);
        antiqueBook.setBookName("\"" + book + "\"");
        antiqueBook.setBookAuthor(author);
        antiqueBook.setQuantity(quantity);
        antiqueBook.setUnitPrice(price);
        antiqueBook.setReleaseYear(year);
        antiqueBookRepository.save(antiqueBook);
        return "New antique book added!";
    }

    @Override
    public Object findByBarcode(Integer barcode) {
        if (basicBookRepository.findByBarcode(barcode) == null) {
            return "Invalid barcode";
        }
        return basicBookRepository.findByBarcode(barcode);
    }

    @Override
    public Iterable<Book> getAll() {
        return basicBookRepository.findAll();
    }

    @Override
    public String updateByBarcodeBook(Integer barcode, String book, String author,
                                      int quantity, double price) {
        if (basicBookRepository.findByBarcode(barcode) == null) {
            return "This barcode is empty!";
        }
        Book newBooks = basicBookRepository.findByBarcode(barcode);
        newBooks.setBookName(book);
        newBooks.setBookAuthor(author);
        newBooks.setQuantity(quantity);
        newBooks.setUnitPrice(price);
        basicBookRepository.save(newBooks);
        return "Updated!";

    }

    @Override
    public String updateByBarcodeJournal(Integer barcode, String book, String author, int quantity, double price, int scienceIndex) {
        if (basicBookRepository.findByBarcode(barcode) == null) {
            return "This barcode is empty!";
        }
        ScienceJournal scienceJournal = scienceJournalsRepository.findByBarcode(barcode);
        scienceJournal.setBookName(book);
        scienceJournal.setBookAuthor(author);
        scienceJournal.setQuantity(quantity);
        scienceJournal.setUnitPrice(price);
        scienceJournal.setScienceIndex(scienceIndex);
        scienceJournalsRepository.save(scienceJournal);
        return "Updated!";
    }

    @Override
    public String updateByBarcodeABook(Integer barcode, String book, String author, int quantity, double price, int releaseYear) {
        if (basicBookRepository.findByBarcode(barcode) == null) {
            return "This barcode is empty!";
        }
        AntiqueBook antiqueBook = antiqueBookRepository.findByBarcode(barcode);
        antiqueBook.setBookName(book);
        antiqueBook.setBookAuthor(author);
        antiqueBook.setQuantity(quantity);
        antiqueBook.setUnitPrice(price);
        antiqueBook.setReleaseYear(releaseYear);
        antiqueBookRepository.save(antiqueBook);
        return "Updated!";
    }

    @Override
    public Object priceByBarcode(Integer barcode) {
        if (basicBookRepository.findByBarcode(barcode) == null) {
            return "Invalid barcode";
        }
        return basicBookRepository.findByBarcode(barcode).totalPriceCalculator();
    }
}
