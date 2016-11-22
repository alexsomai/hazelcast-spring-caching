package org.demo.caching.controller;

import org.demo.caching.model.User;
import org.demo.caching.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Alexandru Somai
 *         date 7/4/2015
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/users/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
    public User createOrUpdateUser(@PathVariable("id") Long id,
                                   @RequestParam String firstName, @RequestParam String lastName) {

        return userService.createOrUpdateUser(id, firstName, lastName);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
