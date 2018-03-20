package com.northeastern.msd.team102.plagiarismchecker.repository;


import com.northeastern.msd.team102.plagiarismchecker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for User entity.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * findByUsernameAndPassword method returns a user for specified username and password
     * @param username
     * @param password
     * @return user
     */
    User findByUsernameAndPassword(String username, String password);

    /**
     * findByUsername method returns a user for specified username
     * @param username
     * @return user
     */
    User findByUsername(String username);

    /**
     * findById method returns a user for specified user id.
     * @param userId
     * @return user
     */
    User findById(long userId);

    /**
     * findByUserType method returns a user for specified user type.
     * @param userType
     * @return user
     */
    User findByUserType(String userType);
}

