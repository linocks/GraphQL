package com.linocks.graphql.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookResource {

    @GetMapping("/")
    public String allBooks(){

        return "works";
    }
}
