package com.bekirkocadag.crud.controllers;


import com.bekirkocadag.crud.dtos.LibraryRequest;
import com.bekirkocadag.crud.models.LibraryModel;
import com.bekirkocadag.crud.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author H.Bekir Kocadag
 */
@RestController
@RequestMapping(value = "/library", produces = "application/json")
public class LibraryController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/library/list")
    public LibraryModel greeting(@RequestParam(required=false, defaultValue="World") String name) {
        System.out.println("==== in greeting ====");
        return new LibraryModel(counter.incrementAndGet(), "book name", "writer name");
    }



    @Autowired
    private LibraryService libraryService;

    @RequestMapping(value = "/list")
    public List<LibraryModel> listAllLibrary() {
        return libraryService.findAll();
    }

    @RequestMapping(value = "/list/{id}")
    public LibraryModel findById(@PathVariable Long id) {
        return libraryService.findById(id);
    }

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public LibraryModel addLibrary(@RequestBody LibraryRequest request) {
        return libraryService.addLibrary(request);
    }

    @RequestMapping(value = "/update/{id}" , method = RequestMethod.PUT)
    public LibraryModel updateLibrary(@PathVariable Long id, @RequestBody LibraryRequest request) {
        return libraryService.updateLibrary(id,request);
    }

    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
    public boolean deleteLibrary(@PathVariable Long id) {
        LibraryModel tmp = findById(id);
        if(null != tmp) {
            libraryService.deleteLibrary(id);
            return true;
        } else {
            return false;
        }
    }
}
