/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.medicus.common.service.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.medicus.common.service.exception.NoSuchStudent_ExternshipException;
import com.medicus.common.service.model.Student_Externship;
import com.medicus.common.service.model.impl.Student_ExternshipImpl;
import com.medicus.common.service.model.impl.Student_ExternshipModelImpl;
import com.medicus.common.service.service.persistence.Student_ExternshipPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the student_ externship service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Student_ExternshipPersistence
 * @see com.medicus.common.service.service.persistence.Student_ExternshipUtil
 * @generated
 */
@ProviderType
public class Student_ExternshipPersistenceImpl extends BasePersistenceImpl<Student_Externship>
	implements Student_ExternshipPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Student_ExternshipUtil} to access the student_ externship persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Student_ExternshipImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Student_ExternshipModelImpl.ENTITY_CACHE_ENABLED,
			Student_ExternshipModelImpl.FINDER_CACHE_ENABLED,
			Student_ExternshipImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Student_ExternshipModelImpl.ENTITY_CACHE_ENABLED,
			Student_ExternshipModelImpl.FINDER_CACHE_ENABLED,
			Student_ExternshipImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Student_ExternshipModelImpl.ENTITY_CACHE_ENABLED,
			Student_ExternshipModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public Student_ExternshipPersistenceImpl() {
		setModelClass(Student_Externship.class);
	}

	/**
	 * Caches the student_ externship in the entity cache if it is enabled.
	 *
	 * @param student_Externship the student_ externship
	 */
	@Override
	public void cacheResult(Student_Externship student_Externship) {
		entityCache.putResult(Student_ExternshipModelImpl.ENTITY_CACHE_ENABLED,
			Student_ExternshipImpl.class, student_Externship.getPrimaryKey(),
			student_Externship);

		student_Externship.resetOriginalValues();
	}

	/**
	 * Caches the student_ externships in the entity cache if it is enabled.
	 *
	 * @param student_Externships the student_ externships
	 */
	@Override
	public void cacheResult(List<Student_Externship> student_Externships) {
		for (Student_Externship student_Externship : student_Externships) {
			if (entityCache.getResult(
						Student_ExternshipModelImpl.ENTITY_CACHE_ENABLED,
						Student_ExternshipImpl.class,
						student_Externship.getPrimaryKey()) == null) {
				cacheResult(student_Externship);
			}
			else {
				student_Externship.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all student_ externships.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Student_ExternshipImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the student_ externship.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Student_Externship student_Externship) {
		entityCache.removeResult(Student_ExternshipModelImpl.ENTITY_CACHE_ENABLED,
			Student_ExternshipImpl.class, student_Externship.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Student_Externship> student_Externships) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Student_Externship student_Externship : student_Externships) {
			entityCache.removeResult(Student_ExternshipModelImpl.ENTITY_CACHE_ENABLED,
				Student_ExternshipImpl.class, student_Externship.getPrimaryKey());
		}
	}

	/**
	 * Creates a new student_ externship with the primary key. Does not add the student_ externship to the database.
	 *
	 * @param studentExternshipId the primary key for the new student_ externship
	 * @return the new student_ externship
	 */
	@Override
	public Student_Externship create(long studentExternshipId) {
		Student_Externship student_Externship = new Student_ExternshipImpl();

		student_Externship.setNew(true);
		student_Externship.setPrimaryKey(studentExternshipId);

		return student_Externship;
	}

	/**
	 * Removes the student_ externship with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studentExternshipId the primary key of the student_ externship
	 * @return the student_ externship that was removed
	 * @throws NoSuchStudent_ExternshipException if a student_ externship with the primary key could not be found
	 */
	@Override
	public Student_Externship remove(long studentExternshipId)
		throws NoSuchStudent_ExternshipException {
		return remove((Serializable)studentExternshipId);
	}

	/**
	 * Removes the student_ externship with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the student_ externship
	 * @return the student_ externship that was removed
	 * @throws NoSuchStudent_ExternshipException if a student_ externship with the primary key could not be found
	 */
	@Override
	public Student_Externship remove(Serializable primaryKey)
		throws NoSuchStudent_ExternshipException {
		Session session = null;

		try {
			session = openSession();

			Student_Externship student_Externship = (Student_Externship)session.get(Student_ExternshipImpl.class,
					primaryKey);

			if (student_Externship == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStudent_ExternshipException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(student_Externship);
		}
		catch (NoSuchStudent_ExternshipException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Student_Externship removeImpl(
		Student_Externship student_Externship) {
		student_Externship = toUnwrappedModel(student_Externship);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(student_Externship)) {
				student_Externship = (Student_Externship)session.get(Student_ExternshipImpl.class,
						student_Externship.getPrimaryKeyObj());
			}

			if (student_Externship != null) {
				session.delete(student_Externship);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (student_Externship != null) {
			clearCache(student_Externship);
		}

		return student_Externship;
	}

	@Override
	public Student_Externship updateImpl(Student_Externship student_Externship) {
		student_Externship = toUnwrappedModel(student_Externship);

		boolean isNew = student_Externship.isNew();

		Student_ExternshipModelImpl student_ExternshipModelImpl = (Student_ExternshipModelImpl)student_Externship;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (student_Externship.getCreateDate() == null)) {
			if (serviceContext == null) {
				student_Externship.setCreateDate(now);
			}
			else {
				student_Externship.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!student_ExternshipModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				student_Externship.setModifiedDate(now);
			}
			else {
				student_Externship.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (student_Externship.isNew()) {
				session.save(student_Externship);

				student_Externship.setNew(false);
			}
			else {
				student_Externship = (Student_Externship)session.merge(student_Externship);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(Student_ExternshipModelImpl.ENTITY_CACHE_ENABLED,
			Student_ExternshipImpl.class, student_Externship.getPrimaryKey(),
			student_Externship, false);

		student_Externship.resetOriginalValues();

		return student_Externship;
	}

	protected Student_Externship toUnwrappedModel(
		Student_Externship student_Externship) {
		if (student_Externship instanceof Student_ExternshipImpl) {
			return student_Externship;
		}

		Student_ExternshipImpl student_ExternshipImpl = new Student_ExternshipImpl();

		student_ExternshipImpl.setNew(student_Externship.isNew());
		student_ExternshipImpl.setPrimaryKey(student_Externship.getPrimaryKey());

		student_ExternshipImpl.setStudentExternshipId(student_Externship.getStudentExternshipId());
		student_ExternshipImpl.setStudentId(student_Externship.getStudentId());
		student_ExternshipImpl.setEmployerId(student_Externship.getEmployerId());
		student_ExternshipImpl.setStartDate(student_Externship.getStartDate());
		student_ExternshipImpl.setEndDate(student_Externship.getEndDate());
		student_ExternshipImpl.setNoOfHoursPerWeek(student_Externship.getNoOfHoursPerWeek());
		student_ExternshipImpl.setMidPointReview(student_Externship.getMidPointReview());
		student_ExternshipImpl.setMidPointReviewComment(student_Externship.getMidPointReviewComment());
		student_ExternshipImpl.setFinalReview(student_Externship.getFinalReview());
		student_ExternshipImpl.setFinalReviewComment(student_Externship.getFinalReviewComment());
		student_ExternshipImpl.setCreateDate(student_Externship.getCreateDate());
		student_ExternshipImpl.setCreatedBy(student_Externship.getCreatedBy());
		student_ExternshipImpl.setModifiedDate(student_Externship.getModifiedDate());
		student_ExternshipImpl.setModifiedBy(student_Externship.getModifiedBy());

		return student_ExternshipImpl;
	}

	/**
	 * Returns the student_ externship with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the student_ externship
	 * @return the student_ externship
	 * @throws NoSuchStudent_ExternshipException if a student_ externship with the primary key could not be found
	 */
	@Override
	public Student_Externship findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStudent_ExternshipException {
		Student_Externship student_Externship = fetchByPrimaryKey(primaryKey);

		if (student_Externship == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStudent_ExternshipException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return student_Externship;
	}

	/**
	 * Returns the student_ externship with the primary key or throws a {@link NoSuchStudent_ExternshipException} if it could not be found.
	 *
	 * @param studentExternshipId the primary key of the student_ externship
	 * @return the student_ externship
	 * @throws NoSuchStudent_ExternshipException if a student_ externship with the primary key could not be found
	 */
	@Override
	public Student_Externship findByPrimaryKey(long studentExternshipId)
		throws NoSuchStudent_ExternshipException {
		return findByPrimaryKey((Serializable)studentExternshipId);
	}

	/**
	 * Returns the student_ externship with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the student_ externship
	 * @return the student_ externship, or <code>null</code> if a student_ externship with the primary key could not be found
	 */
	@Override
	public Student_Externship fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(Student_ExternshipModelImpl.ENTITY_CACHE_ENABLED,
				Student_ExternshipImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Student_Externship student_Externship = (Student_Externship)serializable;

		if (student_Externship == null) {
			Session session = null;

			try {
				session = openSession();

				student_Externship = (Student_Externship)session.get(Student_ExternshipImpl.class,
						primaryKey);

				if (student_Externship != null) {
					cacheResult(student_Externship);
				}
				else {
					entityCache.putResult(Student_ExternshipModelImpl.ENTITY_CACHE_ENABLED,
						Student_ExternshipImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(Student_ExternshipModelImpl.ENTITY_CACHE_ENABLED,
					Student_ExternshipImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return student_Externship;
	}

	/**
	 * Returns the student_ externship with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param studentExternshipId the primary key of the student_ externship
	 * @return the student_ externship, or <code>null</code> if a student_ externship with the primary key could not be found
	 */
	@Override
	public Student_Externship fetchByPrimaryKey(long studentExternshipId) {
		return fetchByPrimaryKey((Serializable)studentExternshipId);
	}

	@Override
	public Map<Serializable, Student_Externship> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Student_Externship> map = new HashMap<Serializable, Student_Externship>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Student_Externship student_Externship = fetchByPrimaryKey(primaryKey);

			if (student_Externship != null) {
				map.put(primaryKey, student_Externship);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(Student_ExternshipModelImpl.ENTITY_CACHE_ENABLED,
					Student_ExternshipImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Student_Externship)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_STUDENT_EXTERNSHIP_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Student_Externship student_Externship : (List<Student_Externship>)q.list()) {
				map.put(student_Externship.getPrimaryKeyObj(),
					student_Externship);

				cacheResult(student_Externship);

				uncachedPrimaryKeys.remove(student_Externship.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(Student_ExternshipModelImpl.ENTITY_CACHE_ENABLED,
					Student_ExternshipImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the student_ externships.
	 *
	 * @return the student_ externships
	 */
	@Override
	public List<Student_Externship> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the student_ externships.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Student_ExternshipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of student_ externships
	 * @param end the upper bound of the range of student_ externships (not inclusive)
	 * @return the range of student_ externships
	 */
	@Override
	public List<Student_Externship> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the student_ externships.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Student_ExternshipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of student_ externships
	 * @param end the upper bound of the range of student_ externships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of student_ externships
	 */
	@Override
	public List<Student_Externship> findAll(int start, int end,
		OrderByComparator<Student_Externship> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the student_ externships.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Student_ExternshipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of student_ externships
	 * @param end the upper bound of the range of student_ externships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of student_ externships
	 */
	@Override
	public List<Student_Externship> findAll(int start, int end,
		OrderByComparator<Student_Externship> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Student_Externship> list = null;

		if (retrieveFromCache) {
			list = (List<Student_Externship>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_STUDENT_EXTERNSHIP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STUDENT_EXTERNSHIP;

				if (pagination) {
					sql = sql.concat(Student_ExternshipModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Student_Externship>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Student_Externship>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the student_ externships from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Student_Externship student_Externship : findAll()) {
			remove(student_Externship);
		}
	}

	/**
	 * Returns the number of student_ externships.
	 *
	 * @return the number of student_ externships
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STUDENT_EXTERNSHIP);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return Student_ExternshipModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the student_ externship persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(Student_ExternshipImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_STUDENT_EXTERNSHIP = "SELECT student_Externship FROM Student_Externship student_Externship";
	private static final String _SQL_SELECT_STUDENT_EXTERNSHIP_WHERE_PKS_IN = "SELECT student_Externship FROM Student_Externship student_Externship WHERE studentExternshipId IN (";
	private static final String _SQL_COUNT_STUDENT_EXTERNSHIP = "SELECT COUNT(student_Externship) FROM Student_Externship student_Externship";
	private static final String _ORDER_BY_ENTITY_ALIAS = "student_Externship.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Student_Externship exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(Student_ExternshipPersistenceImpl.class);
}