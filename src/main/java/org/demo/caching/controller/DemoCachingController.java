package org.demo.caching.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alexandru Somai
 *         date 7/4/2015
 */
@RestController
public class DemoCachingController {

    @RequestMapping(value = "/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}