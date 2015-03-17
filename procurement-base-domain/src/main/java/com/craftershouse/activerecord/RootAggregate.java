package com.craftershouse.activerecord;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.craftershouse.context.ApplicationContextProvider;
import com.craftershouse.jpa.repository.JpaRepositorySpecificationExecutor;

@MappedSuperclass
public class RootAggregate<R extends JpaRepositorySpecificationExecutor<T, Long>, T>
		implements JpaRepositorySpecificationExecutor<T, Long> {

	private Class<R> repositoryClazz;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Transient
	protected R repository;

	public RootAggregate() {
		repositoryClazz = getParametrizedType();
		if (ApplicationContextProvider.getContext() != null)
			repository = ApplicationContextProvider.getContext().getBean(repositoryClazz);
	}

	public Class<R> getParametrizedType() {

		ParameterizedType type = (ParameterizedType) getClass()
				.getGenericSuperclass();

		Type t = type.getActualTypeArguments()[0];

		return (Class<R>) t;

	}

	public R getAll() {
		return repository;
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		return this.repository.findAll(pageable);
	}

	public <S extends T> S save() {
		return this.repository.save((S) this);
	}

	@Override
	public <S extends T> S save(S entity) {
		return this.repository.save(entity);
	}

	@Override
	public T findOne(Long id) {
		return this.repository.findOne(id);
	}

	@Override
	public boolean exists(Long id) {
		return this.repository.exists(id);
	}

	@Override
	public long count() {
		return this.repository.count();
	}

	@Override
	public void delete(Long id) {
		this.repository.delete(id);
	}

	@Override
	public void delete(T entity) {
		this.repository.delete(entity);
	}

	@Override
	public void delete(Iterable<? extends T> entities) {
		this.repository.delete(entities);
	}

	@Override
	public void deleteAll() {
		this.repository.deleteAll();
	}

	@Override
	public List<T> findAll() {
		return this.repository.findAll();
	}

	@Override
	public List<T> findAll(Sort sort) {
		return this.repository.findAll(sort);
	}

	@Override
	public List<T> findAll(Iterable<Long> ids) {
		return this.repository.findAll(ids);
	}

	@Override
	public <S extends T> List<S> save(Iterable<S> entities) {
		return this.repository.save(entities);
	}

	@Override
	public void flush() {
		this.repository.flush();
	}

	@Override
	public <S extends T> S saveAndFlush(S entity) {
		return this.repository.saveAndFlush(entity);
	}

	@Override
	public void deleteInBatch(Iterable<T> entities) {
		this.repository.deleteInBatch(entities);
	}

	@Override
	public void deleteAllInBatch() {
		this.repository.deleteAllInBatch();
	}

	@Override
	public T getOne(Long id) {
		return this.repository.getOne(id);
	}

	@Override
	public T findOne(Specification<T> spec) {
		return this.repository.findOne(spec);
	}

	@Override
	public List<T> findAll(Specification<T> spec) {
		return this.repository.findAll(spec);
	}

	@Override
	public Page<T> findAll(Specification<T> spec, Pageable pageable) {
		return this.repository.findAll(spec, pageable);
	}

	@Override
	public List<T> findAll(Specification<T> spec, Sort sort) {
		return this.repository.findAll(spec, sort);
	}

	@Override
	public long count(Specification<T> spec) {
		return this.repository.count(spec);
	}

}
