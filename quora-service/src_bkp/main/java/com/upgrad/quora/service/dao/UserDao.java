package com.upgrad.quora.service.dao;

import com.upgrad.quora.service.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class UserDao {
   @PersistenceContext
   private EntityManager entityManager;

   public UserEntity createUser(UserEntity userentity){
       entityManager.persist(userentity);
       return userentity;

   }
    /**
     * This methods gets the user details based on the username passed.
     *
     * @param userName username of the user whose information is to be fetched.
     * @return null if the user with given username doesn't exist in DB.
     */
    public UserEntity getUserByUserName(final String userName) {
        try {
            return entityManager
                    .createNamedQuery("userByUserName", UserEntity.class)
                    .setParameter("userName", userName)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    /**
     * This methods gets the user details based on the email passed.
     *
     * @param email email of the user whose information is to be fetched.
     * @return null if the user with given email doesn't exist in DB.
     */
    public UserEntity getUserByEmail(final String email) {
        try {
            return entityManager
                    .createNamedQuery("userByEmail", UserEntity.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

}
