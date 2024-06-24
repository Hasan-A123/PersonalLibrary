package com.example.book;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class BookViewModel extends AndroidViewModel {

    private final BookRepository mRepository;

    private final LiveData<List<Book>>mAllBooks;



    public BookViewModel(Application application) {
        super(application);
        mRepository = new BookRepository(application);
        mAllBooks = mRepository.getAllBooks();

    }

    LiveData<List<Book>> getAllBooks() {
        return mAllBooks;
    }


    void insert(Book book) {
        mRepository.insert(book);
    }

    void update(Book book) {
        mRepository.update(book);
    }

}
