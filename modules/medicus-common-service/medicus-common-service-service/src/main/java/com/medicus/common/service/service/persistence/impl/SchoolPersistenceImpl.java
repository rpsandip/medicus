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
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.medicus.common.service.exception.NoSuchSchoolException;
import com.medicus.common.service.model.School;
import com.medicus.common.service.model.impl.SchoolImpl;
import com.medicus.common.service.model.impl.SchoolModelImpl;
import com.medicus.common.service.service.persistence.SchoolPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the school service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sandip.patel
 * @see SchoolPersistence
 * @see com.medicus.common.service.service.persistence.SchoolUtil
 * @generated
 */
@ProviderType
public class SchoolPersistenceImpl extends BasePersistenceImpl<School>
	implements SchoolPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SchoolUtil} to access the school persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SchoolImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SchoolModelImpl.ENTITY_CACHE_ENABLED,
			SchoolModelImpl.FINDER_CACHE_ENABLED, SchoolImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SchoolModelImpl.ENTITY_CACHE_ENABLED,
			SchoolModelImpl.FINDER_CACHE_ENABLED, SchoolImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SchoolModelImpl.ENTITY_CACHE_ENABLED,
			SchoolModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(SchoolModelImpl.ENTITY_CACHE_ENABLED,
			SchoolModelImpl.FINDER_CACHE_ENABLED, SchoolImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByname",
			new String[] { String.class.getName() },
			SchoolModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(SchoolModelImpl.ENTITY_CACHE_ENABLED,
			SchoolModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByname",
			new String[] { String.class.getName() });

	/**
	 * Returns the school where name = &#63; or throws a {@link NoSuchSchoolException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching school
	 * @throws NoSuchSchoolException if a matching school could not be found
	 */
	@Override
	public School findByname(String name) throws NoSuchSchoolException {
		School school = fetchByname(name);

		if (school == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchSchoolException(msg.toString());
		}

		return school;
	}

	/**
	 * Returns the school where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching school, or <code>null</code> if a matching school could not be found
	 */
	@Override
	public School fetchByname(String name) {
		return fetchByname(name, true);
	}

	/**
	 * Returns the school where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching school, or <code>null</code> if a matching school could not be found
	 */
	@Override
	public School fetchByname(String name, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof School) {
			School school = (School)result;

			if (!Objects.equals(name, school.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SCHOOL_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				List<School> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SchoolPersistenceImpl.fetchByname(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					School school = list.get(0);

					result = school;

					cacheResult(school);

					if ((school.getName() == null) ||
							!school.getName().equals(name)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, school);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_NAME, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (School)result;
		}
	}

	/**
	 * Removes the school where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the school that was removed
	 */
	@Override
	public School removeByname(String name) throws NoSuchSchoolException {
		School school = findByname(name);

		return remove(school);
	}

	/**
	 * Returns the number of schools where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching schools
	 */
	@Override
	public int countByname(String name) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SCHOOL_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "school.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "school.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(school.name IS NULL OR school.name = '')";

	public SchoolPersistenceImpl() {
		setModelClass(School.class);
	}

	/**
	 * Caches the school in the entity cache if it is enabled.
	 *
	 * @param school the school
	 */
	@Override
	public void cacheResult(School school) {
		entityCache.putResult(SchoolModelImpl.ENTITY_CACHE_ENABLED,
			SchoolImpl.class, school.getPrimaryKey(), school);

		finderCache.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { school.getName() }, school);

		school.resetOriginalValues();
	}

	/**
	 * Caches the schools in the entity cache if it is enabled.
	 *
	 * @param schools the schools
	 */
	@Override
	public void cacheResult(List<School> schools) {
		for (School school : schools) {
			if (entityCache.getResult(SchoolModelImpl.ENTITY_CACHE_ENABLED,
						SchoolImpl.class, school.getPrimaryKey()) == null) {
				cacheResult(school);
			}
			else {
				school.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all schools.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SchoolImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the school.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(School school) {
		entityCache.removeResult(SchoolModelImpl.ENTITY_CACHE_ENABLED,
			SchoolImpl.class, school.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((SchoolModelImpl)school);
	}

	@Override
	public void clearCache(List<School> schools) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (School school : schools) {
			entityCache.removeResult(SchoolModelImpl.ENTITY_CACHE_ENABLED,
				SchoolImpl.class, school.getPrimaryKey());

			clearUniqueFindersCache((SchoolModelImpl)school);
		}
	}

	protected void cacheUniqueFindersCache(SchoolModelImpl schoolModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] { schoolModelImpl.getName() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_NAME, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_NAME, args,
				schoolModelImpl);
		}
		else {
			if ((schoolModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { schoolModelImpl.getName() };

				finderCache.putResult(FINDER_PATH_COUNT_BY_NAME, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_NAME, args,
					schoolModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(SchoolModelImpl schoolModelImpl) {
		Object[] args = new Object[] { schoolModelImpl.getName() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

		if ((schoolModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
			args = new Object[] { schoolModelImpl.getOriginalName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
		}
	}

	/**
	 * Creates a new school with the primary key. Does not add the school to the database.
	 *
	 * @param schoolId the primary key for the new school
	 * @return the new school
	 */
	@Override
	public School create(long schoolId) {
		School school = new SchoolImpl();

		school.setNew(true);
		school.setPrimaryKey(schoolId);

		return school;
	}

	/**
	 * Removes the school with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param schoolId the primary key of the school
	 * @return the school that was removed
	 * @throws NoSuchSchoolException if a school with the primary key could not be found
	 */
	@Override
	public School remove(long schoolId) throws NoSuchSchoolException {
		return remove((Serializable)schoolId);
	}

	/**
	 * Removes the school with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the school
	 * @return the school that was removed
	 * @throws NoSuchSchoolException if a school with the primary key could not be found
	 */
	@Override
	public School remove(Serializable primaryKey) throws NoSuchSchoolException {
		Session session = null;

		try {
			session = openSession();

			School school = (School)session.get(SchoolImpl.class, primaryKey);

			if (school == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSchoolException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(school);
		}
		catch (NoSuchSchoolException nsee) {
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
	protected School removeImpl(School school) {
		school = toUnwrappedModel(school);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(school)) {
				school = (School)session.get(SchoolImpl.class,
						school.getPrimaryKeyObj());
			}

			if (school != null) {
				session.delete(school);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (school != null) {
			clearCache(school);
		}

		return school;
	}

	@Override
	public School updateImpl(School school) {
		school = toUnwrappedModel(school);

		boolean isNew = school.isNew();

		SchoolModelImpl schoolModelImpl = (SchoolModelImpl)school;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (school.getCreateDate() == null)) {
			if (serviceContext == null) {
				school.setCreateDate(now);
			}
			else {
				school.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!schoolModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				school.setModifiedDate(now);
			}
			else {
				school.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (school.isNew()) {
				session.save(school);

				school.setNew(false);
			}
			else {
				school = (School)session.merge(school);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SchoolModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(SchoolModelImpl.ENTITY_CACHE_ENABLED,
			SchoolImpl.class, school.getPrimaryKey(), school, false);

		clearUniqueFindersCache(schoolModelImpl);
		cacheUniqueFindersCache(schoolModelImpl, isNew);

		school.resetOriginalValues();

		return school;
	}

	protected School toUnwrappedModel(School school) {
		if (school instanceof SchoolImpl) {
			return school;
		}

		SchoolImpl schoolImpl = new SchoolImpl();

		schoolImpl.setNew(school.isNew());
		schoolImpl.setPrimaryKey(school.getPrimaryKey());

		schoolImpl.setSchoolId(school.getSchoolId());
		schoolImpl.setName(school.getName());
		schoolImpl.setAddress1(school.getAddress1());
		schoolImpl.setCity(school.getCity());
		schoolImpl.setState(school.getState());
		schoolImpl.setCountry(school.getCountry());
		schoolImpl.setZipcode(school.getZipcode());
		schoolImpl.setContactNumber(school.getContactNumber());
		schoolImpl.setWebsiteLink(school.getWebsiteLink());
		schoolImpl.setContactPersonName(school.getContactPersonName());
		schoolImpl.setContactPersonPhoneNumber(school.getContactPersonPhoneNumber());
		schoolImpl.setContactPersonEmail(school.getContactPersonEmail());
		schoolImpl.setStatus(school.getStatus());
		schoolImpl.setCreateDate(school.getCreateDate());
		schoolImpl.setCreatedBy(school.getCreatedBy());
		schoolImpl.setModifiedDate(school.getModifiedDate());
		schoolImpl.setModifiedBy(school.getModifiedBy());

		return schoolImpl;
	}

	/**
	 * Returns the school with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the school
	 * @return the school
	 * @throws NoSuchSchoolException if a school with the primary key could not be found
	 */
	@Override
	public School findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSchoolException {
		School school = fetchByPrimaryKey(primaryKey);

		if (school == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSchoolException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return school;
	}

	/**
	 * Returns the school with the primary key or throws a {@link NoSuchSchoolException} if it could not be found.
	 *
	 * @param schoolId the primary key of the school
	 * @return the school
	 * @throws NoSuchSchoolException if a school with the primary key could not be found
	 */
	@Override
	public School findByPrimaryKey(long schoolId) throws NoSuchSchoolException {
		return findByPrimaryKey((Serializable)schoolId);
	}

	/**
	 * Returns the school with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the school
	 * @return the school, or <code>null</code> if a school with the primary key could not be found
	 */
	@Override
	public School fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SchoolModelImpl.ENTITY_CACHE_ENABLED,
				SchoolImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		School school = (School)serializable;

		if (school == null) {
			Session session = null;

			try {
				session = openSession();

				school = (School)session.get(SchoolImpl.class, primaryKey);

				if (school != null) {
					cacheResult(school);
				}
				else {
					entityCache.putResult(SchoolModelImpl.ENTITY_CACHE_ENABLED,
						SchoolImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SchoolModelImpl.ENTITY_CACHE_ENABLED,
					SchoolImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return school;
	}

	/**
	 * Returns the school with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param schoolId the primary key of the school
	 * @return the school, or <code>null</code> if a school with the primary key could not be found
	 */
	@Override
	public School fetchByPrimaryKey(long schoolId) {
		return fetchByPrimaryKey((Serializable)schoolId);
	}

	@Override
	public Map<Serializable, School> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, School> map = new HashMap<Serializable, School>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			School school = fetchByPrimaryKey(primaryKey);

			if (school != null) {
				map.put(primaryKey, school);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SchoolModelImpl.ENTITY_CACHE_ENABLED,
					SchoolImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (School)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SCHOOL_WHERE_PKS_IN);

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

			for (School school : (List<School>)q.list()) {
				map.put(school.getPrimaryKeyObj(), school);

				cacheResult(school);

				uncachedPrimaryKeys.remove(school.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SchoolModelImpl.ENTITY_CACHE_ENABLED,
					SchoolImpl.class, primaryKey, nullModel);
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
	 * Returns all the schools.
	 *
	 * @return the schools
	 */
	@Override
	public List<School> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the schools.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchoolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of schools
	 * @param end the upper bound of the range of schools (not inclusive)
	 * @return the range of schools
	 */
	@Override
	public List<School> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the schools.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchoolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of schools
	 * @param end the upper bound of the range of schools (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of schools
	 */
	@Override
	public List<School> findAll(int start, int end,
		OrderByComparator<School> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the schools.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchoolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of schools
	 * @param end the upper bound of the range of schools (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of schools
	 */
	@Override
	public List<School> findAll(int start, int end,
		OrderByComparator<School> orderByComparator, boolean retrieveFromCache) {
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

		List<School> list = null;

		if (retrieveFromCache) {
			list = (List<School>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SCHOOL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SCHOOL;

				if (pagination) {
					sql = sql.concat(SchoolModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<School>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<School>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the schools from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (School school : findAll()) {
			remove(school);
		}
	}

	/**
	 * Returns the number of schools.
	 *
	 * @return the number of schools
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SCHOOL);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SchoolModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the school persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SchoolImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SCHOOL = "SELECT school FROM School school";
	private static final String _SQL_SELECT_SCHOOL_WHERE_PKS_IN = "SELECT school FROM School school WHERE schoolId IN (";
	private static final String _SQL_SELECT_SCHOOL_WHERE = "SELECT school FROM School school WHERE ";
	private static final String _SQL_COUNT_SCHOOL = "SELECT COUNT(school) FROM School school";
	private static final String _SQL_COUNT_SCHOOL_WHERE = "SELECT COUNT(school) FROM School school WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "school.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No School exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No School exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(SchoolPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"state"
			});
}