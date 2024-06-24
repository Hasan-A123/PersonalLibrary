package com.example.book;

import junit.framework.TestCase;

public class BookTest extends TestCase {

    public void testGetIsbnNo() {
        //Arrange
        Book book= new Book("9781802233704", "Java Programming for Beginners",
                "Will Norton", "A java book for beginners", "Giovanna De Rosa",
                "2021");
        //Act
        String IsbnNo= book.getIsbnNo();
        //Assert
        assertEquals("9781802233704", IsbnNo );

    }

    public void testGetTitle() {
        //Arrange
        Book book= new Book("9781802233704", "Java Programming for Beginners",
                "Will Norton", "A java book for beginners", "Giovanna De Rosa",
                "2021");
        //Act
        String Title= book.getTitle();
        //Assert
        assertEquals("Java Programming for Beginners", Title );

    }

    public void testGetAuthor() {
        //Arrange
        Book book= new Book("9781802233704", "Java Programming for Beginners",
                "Will Norton", "A java book for beginners", "Giovanna De Rosa",
                "2021");
        //Act
        String Author= book.getAuthor();
        //Assert
        assertEquals("Will Norton", Author );
    }

    public void testGetDescription() {
        //Arrange
        Book book= new Book("9781802233704", "Java Programming for Beginners",
                "Will Norton", "A java book for beginners", "Giovanna De Rosa",
                "2021");
        //Act
        String Description= book.getDescription();
        //Assert
        assertEquals("A java book for beginners", Description );
    }

    public void testGetPublisher() {
        //Arrange
        Book book= new Book("9781802233704", "Java Programming for Beginners",
                "Will Norton", "A java book for beginners", "Giovanna De Rosa",
                "2021");
        //Act
        String Publisher= book.getPublisher();
        //Assert
        assertEquals("Giovanna De Rosa", Publisher );
    }

    public void testGetPublishedDate() {
        //Arrange
        Book book= new Book("9781802233704", "Java Programming for Beginners",
                "Will Norton", "A java book for beginners", "Giovanna De Rosa",
                "2021");
        //Act
        String PublishedDate= book.getPublishedDate();
        //Assert
        assertEquals("2021", PublishedDate );
    }

    public void testTestToString() {
        //Arrange
        Book book= new Book("9781802233704", "Java Programming for Beginners",
                "Will Norton", "A java book for beginners", "Giovanna De Rosa",
                "2021");
        //Act
        String ToString =book.toString();
        //Assert
        assertEquals("Book{IsbnNo='9781802233704', Title='Java Programming for Beginners', Author='Will Norton', Description='A java book for beginners', Publisher='Giovanna De Rosa', PublishedDate='2021'}", ToString );
    }
}
