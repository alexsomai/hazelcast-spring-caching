package org.demo.caching.controller;

import org.demo.caching.model.User;
import org.demo.caching.service.DemoCachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexandru Somai
 *         date 7/4/2015
 */
@RestController
public class DemoCachingController {

    @Autowired
    private DemoCachingService demoCachingService;

    @RequestMapping(value = "/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public User getUser(@RequestParam(value = "id") Optional<Long> optionalId) {
        if (optionalId.isPresent()) {
            return demoCachingService.getUser(optionalId.get());
        }

        return null;
    }

    @RequestMapping(value = "/findAllUsers", method = RequestMethod.GET)
    public List<User> findAllUsers() {
        return demoCachingService.findAllUsers();
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public void updateUser(@RequestParam(value = "id", required = true) Optional<Long> optionalId,
                           @RequestParam String firstName, @RequestParam String lastName) {

        optionalId.ifPresent(id -> demoCachingService.updateUser(id, firstName, lastName));
    }

}