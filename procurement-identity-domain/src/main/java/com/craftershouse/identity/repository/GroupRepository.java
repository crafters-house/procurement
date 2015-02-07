package com.craftershouse.identity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.craftershouse.identity.Group;


/**
 * 
 * @author Bisso
 *
 * @param <T>
 */
@Repository
public interface GroupRepository<T extends Group> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
		
}
