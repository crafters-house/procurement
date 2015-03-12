package com.craftershouse.identity.repository;

import org.springframework.stereotype.Repository;

import com.craftershouse.identity.User;
import com.craftershouse.jpa.repository.JpaRepositorySpecificationExecutor;


/**
 * 
 * @author Bisso
 *
 * @param <T>
 */
@Repository
public interface UserRepository extends JpaRepositorySpecificationExecutor<User, Long> {
		
}
