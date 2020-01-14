package com.bekirkocadag.crud.services;

import com.bekirkocadag.crud.dtos.LibraryRequest;
import com.bekirkocadag.crud.models.LibraryModel;
import com.bekirkocadag.crud.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author H.Bekir Kocadag
 */
@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    public List<LibraryModel> findAll(){
        List<LibraryModel> tmpList = libraryRepository.findAll();
        return tmpList;
    }

    public LibraryModel addLibrary(LibraryRequest request) {
        LibraryModel libraryModel = new LibraryModel();
        libraryModel.setBookName(request.getBookName());
        libraryModel.setWriterName(request.getWriterName());

        libraryModel = libraryRepository.save(libraryModel);

        return libraryModel;
    }

    public LibraryModel findById(Long id) {
        return libraryRepository.findOne(id);
    }

    public LibraryModel updateLibrary(Long id, LibraryRequest request) {
         LibraryModel updatedLibrary = Optional.ofNullable(libraryRepository.findOne(id)).map(library -> {
             library.setBookName(request.getBookName());
             library.setWriterName(request.getWriterName());
            return library;
        }).get();
        return  libraryRepository.save(updatedLibrary);
    }

    public void deleteLibrary(Long id) {
        libraryRepository.delete(id);
    }
}
