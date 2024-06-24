package com.example.book;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Book.class}, version = 1, exportSchema = false)
public abstract class BookRoomDatabase extends RoomDatabase  {

    public abstract BookDao bookDao();

    private static volatile BookRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static BookRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BookRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    BookRoomDatabase.class, "book_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                BookDao dao = INSTANCE.bookDao();
                dao.deleteAll();

                Book book = new Book("9780393974379, 0393974375", "Java Progrmming", "Kim N. King", "Aimed at the traditional CS1 course, Java Programming emphasizes object-oriented design, problem-solving," +
                        " and good programming style, without overwhelming students with extraneous information.", "W.W. Norton", "2000" );
                dao.insert(book);
                book = new Book("9781420000009, 1420000004", "Java Programming for engineers", "Julio Sanches and Maria p. Canton", "While teaching Java programming at Minnesota State University," +
                        " the authors noticed that engineering students were enrolling in Java programming courses in order to obtain basic programming skills," +
                        " but there were no Java books suitable for courses intended for engineers.", "CRC Press", "2002" );
                dao.insert(book);

            });
        }
    };
}
