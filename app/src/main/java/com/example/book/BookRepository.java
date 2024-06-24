package com.example.book;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class BookRepository {

    private final BookDao mBookDao;
    private final LiveData<List<Book>> mAllBooks;


    BookRepository(Application application) {
        BookRoomDatabase db = BookRoomDatabase.getDatabase(application);
        mBookDao = db.bookDao();
        mAllBooks = mBookDao.getAllBooks();
    }


    LiveData<List<Book>> getAllBooks() {
        return mAllBooks;
    }

    void update(Book book) {
        BookRoomDatabase.databaseWriteExecutor.execute(() -> {
            mBookDao.update(book);
        });

    }
    void insert(Book book) {
        BookRoomDatabase.databaseWriteExecutor.execute(() -> {
            mBookDao.insert(book);
        });
    }
}
