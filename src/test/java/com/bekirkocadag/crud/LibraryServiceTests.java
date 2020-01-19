package com.bekirkocadag.crud;

import com.bekirkocadag.crud.configuration.DatabaseConfiguration;
import com.bekirkocadag.crud.dtos.LibraryRequest;
import com.bekirkocadag.crud.models.LibraryModel;
import com.bekirkocadag.crud.repositories.LibraryRepository;
import com.bekirkocadag.crud.services.LibraryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.beans.Beans;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class LibraryServiceTests {

    @Mock
    private LibraryRepository libraryRepository;

    @InjectMocks
    private LibraryService libraryService;

    private static long bookId = 1l;


    @Test
    public void shouldTrueIfFindBook(){
        String bookName = "Bekir Kocadag";
        String writerName = "Hayatım";

        LibraryModel book = new LibraryModel(bookName, writerName);

        when(libraryRepository.save(book)).thenReturn(book);

        LibraryRequest libraryRequest = new LibraryRequest();
        libraryRequest.setBookName(bookName);
        libraryRequest.setWriterName(writerName);
       // assertTrue(libraryService.addLibrary(libraryRequest));
    }

    @Test
    public void testLibraryNotFoundException() throws Exception {

        String errorMessage = "Player Not Found";
 /*
        when(libraryRepository.findOne(bookId)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> libraryService.findById(bookId))
                .isInstanceOf(Exception.class)
                .hasMessage(errorMessage);
*/
    }
}