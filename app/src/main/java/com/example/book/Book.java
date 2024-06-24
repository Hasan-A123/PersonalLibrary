package com.example.book;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "book_table")
public class Book implements Serializable {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "isbn_number")
    private String mIsbnNo;

    @NonNull
    @ColumnInfo(name = "title")
    private String mTitle;


    @NonNull
    @ColumnInfo(name = "author")
    private String mAuthor;


    @NonNull
    @ColumnInfo(name = "description")
    private String mDescription;


    @NonNull
    @ColumnInfo(name = "publisher")
    private String mPublisher;


    @NonNull
    @ColumnInfo(name = "published_date")
    private String mPublishedDate;


    public Book(@NonNull String mIsbnNo, @NonNull String mTitle, @NonNull String mAuthor, @NonNull String mDescription, @NonNull String mPublisher, @NonNull String mPublishedDate) {
        this.mIsbnNo = mIsbnNo;
        this.mTitle = mTitle;
        this.mAuthor = mAuthor;
        this.mDescription = mDescription;
        this.mPublisher = mPublisher;
        this.mPublishedDate = mPublishedDate;
    }



    @NonNull
    public String getIsbnNo() {
        return mIsbnNo;
    }


    @NonNull
    public String getTitle() {
        return mTitle;
    }



    @NonNull
    public String getAuthor() {
        return mAuthor;
    }



    @NonNull
    public String getDescription() {
        return mDescription;
    }



    @NonNull
    public String getPublisher() {
        return mPublisher;
    }


    @NonNull
    public String getPublishedDate() {
        return mPublishedDate;
    }


    @Override
    public String toString() {
        return "Book{" +
                "IsbnNo='" + mIsbnNo + '\'' +
                ", Title='" + mTitle + '\'' +
                ", Author='" + mAuthor + '\'' +
                ", Description='" + mDescription + '\'' +
                ", Publisher='" + mPublisher + '\'' +
                ", PublishedDate='" + mPublishedDate + '\'' +
                '}';
    }

}
