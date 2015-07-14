package org.demo.caching.service;

import org.demo.caching.model.User;
import org.demo.caching.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexandru Somai
 *         date 7/4/2015
 */
@Service
@CacheConfig(cacheNames = "users")
public class DemoCachingServiceImpl implements DemoCachingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoCachingServiceImpl.class);

    private static final Long SLEEP_PERIOD = 3000L;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    @Cacheable()
    //condition = "#id == 2"
    //unless = "#result.username.equals('Claude.Richardson')"
    public User getUser(Long id) {
        LOGGER.info("Getting from DB the User with id: {}", id);

        try {
            Thread.sleep(SLEEP_PERIOD);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        User user = userRepository.findOne(id);

        LOGGER.info("User {} was retrieved from DB", user);

        return user;
    }

    @Transactional
    @Override
    @CacheEvict(allEntries = true)
    public List<User> findAllUsers() {
        Iterable<User> iterator = userRepository.findAll();

        List<User> userList = new ArrayList<>();
        iterator.forEach(userList::add);

        return userList;
    }

    @Transactional
    @Override
    @CachePut(key = "#id")
    public User updateUser(Long id, String firstName, String lastName) {
        User user = userRepository.findOne(id);

        user.setFirstName(firstName);
        user.setLastName(lastName);

        return userRepository.save(user);
    }

}
