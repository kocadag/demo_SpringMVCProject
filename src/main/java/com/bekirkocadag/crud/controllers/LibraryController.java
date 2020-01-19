package com.bekirkocadag.crud.controllers;


import com.bekirkocadag.crud.dtos.LibraryRequest;
import com.bekirkocadag.crud.models.LibraryModel;
import com.bekirkocadag.crud.services.LibraryService;
import com.captcha.botdetect.web.servlet.SimpleCaptcha;
import com.cedarsoftware.util.io.JsonObject;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
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
    @GetMapping("/library/**")
    public LibraryModel greeting(@RequestParam(required=false, defaultValue="Bekir") LibraryModel libraryModel) {
        if(null == libraryModel) {
            return new LibraryModel(counter.incrementAndGet(), "","");
        } else {
            return new LibraryModel(libraryModel.getId(), libraryModel.getBookName(), libraryModel.getWriterName());
        }
    }

    @Autowired
    private LibraryService libraryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<LibraryModel> listAllLibrary() {
        return libraryService.findAll();
    }

    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    public LibraryModel findById(@PathVariable Long id) {
        return libraryService.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public LibraryModel addLibrary(@RequestBody LibraryRequest request) {
        return libraryService.addLibrary(request);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public LibraryModel updateLibrary(@PathVariable Long id, @RequestBody LibraryRequest request) {
        return libraryService.updateLibrary(id,request);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public boolean deleteLibrary(@PathVariable Long id) {
        LibraryModel tmp = findById(id);
        if(null != tmp) {
            libraryService.deleteLibrary(id);
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(value = "/simple-captcha-endpoint",
            method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseBody
    public String yourFormPostAction(HttpServletRequest request) throws IOException {
        System.out.println("Bekir");
/*
        JsonParser parser = new JsonParser() {
            @Override
            public Map<String, Object> parseMap(String json) {
                return null;
            }

            @Override
            public List<Object> parseList(String json) {
                return null;
            }
        };
        JsonObject formDataObj = (JsonObject) parser.parse(request.getReader());

        String userEnteredCaptchaCode = formDataObj.get("userEnteredCaptchaCode").getAsString();
        String captchaId = formDataObj.get("captchaId").getAsString();

        // create a captcha instance to be used for the captcha validation
        SimpleCaptcha yourFirstCaptcha = SimpleCaptcha.load(request);
        // execute the captcha validation
        boolean isHuman = yourFirstCaptcha.validate(userEnteredCaptchaCode, captchaId);

        if (isHuman == false) {
            // captcha validation failed; notify the frontend
            // consider logging the attempt
            return "{\"success\":false}";
        } else {
            // captcha validation succeeded; execute the protected action
            // do not forget to notify the frontend about the results
            return "{\"success\":true}";
        }
*/
        return "{\"success\":true}";
    }
}