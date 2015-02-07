package com.craftershouse.identity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.craftershouse.identity.Role;


/**
 * 
 * @author Bisso
 *
 * @param <T>
 */
@Repository
public interface RoleRepository<T extends Role> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
		
}
