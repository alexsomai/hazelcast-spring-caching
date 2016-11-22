package org.demo.caching.service;

import org.demo.caching.model.User;

import java.util.List;

/**
 * @author Alexandru Somai
 *         date 7/4/2015
 */
public interface UserService {

    User getUser(Long id);

    List<User> getUsers();

    User createOrUpdateUser(Long id, String firstName, String lastName);

    void deleteUser(Long id);
}
