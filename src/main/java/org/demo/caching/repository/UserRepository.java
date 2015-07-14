package org.demo.caching.repository;

import org.demo.caching.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alexandru Somai
 *         date 7/4/2015
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
