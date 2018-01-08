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

import com.medicus.common.service.exception.NoSuchCampusException;
import com.medicus.common.service.model.Campus;
import com.medicus.common.service.model.impl.CampusImpl;
import com.medicus.common.service.model.impl.CampusModelImpl;
import com.medicus.common.service.service.persistence.CampusPersistence;

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
 * The persistence implementation for the campus service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sandip.patel
 * @see CampusPersistence
 * @see com.medicus.common.service.service.persistence.CampusUtil
 * @generated
 */
@ProviderType
public class CampusPersistenceImpl extends BasePersistenceImpl<Campus>
	implements CampusPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CampusUtil} to access the campus persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CampusImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CampusModelImpl.ENTITY_CACHE_ENABLED,
			CampusModelImpl.FINDER_CACHE_ENABLED, CampusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CampusModelImpl.ENTITY_CACHE_ENABLED,
			CampusModelImpl.FINDER_CACHE_ENABLED, CampusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CampusModelImpl.ENTITY_CACHE_ENABLED,
			CampusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SCHOOLID = new FinderPath(CampusModelImpl.ENTITY_CACHE_ENABLED,
			CampusModelImpl.FINDER_CACHE_ENABLED, CampusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByschoolId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHOOLID =
		new FinderPath(CampusModelImpl.ENTITY_CACHE_ENABLED,
			CampusModelImpl.FINDER_CACHE_ENABLED, CampusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByschoolId",
			new String[] { Long.class.getName() },
			CampusModelImpl.SCHOOLID_COLUMN_BITMASK |
			CampusModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SCHOOLID = new FinderPath(CampusModelImpl.ENTITY_CACHE_ENABLED,
			CampusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByschoolId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the campuses where schoolId = &#63;.
	 *
	 * @param schoolId the school ID
	 * @return the matching campuses
	 */
	@Override
	public List<Campus> findByschoolId(long schoolId) {
		return findByschoolId(schoolId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the campuses where schoolId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param schoolId the school ID
	 * @param start the lower bound of the range of campuses
	 * @param end the upper bound of the range of campuses (not inclusive)
	 * @return the range of matching campuses
	 */
	@Override
	public List<Campus> findByschoolId(long schoolId, int start, int end) {
		return findByschoolId(schoolId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campuses where schoolId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param schoolId the school ID
	 * @param start the lower bound of the range of campuses
	 * @param end the upper bound of the range of campuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campuses
	 */
	@Override
	public List<Campus> findByschoolId(long schoolId, int start, int end,
		OrderByComparator<Campus> orderByComparator) {
		return findByschoolId(schoolId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the campuses where schoolId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param schoolId the school ID
	 * @param start the lower bound of the range of campuses
	 * @param end the upper bound of the range of campuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching campuses
	 */
	@Override
	public List<Campus> findByschoolId(long schoolId, int start, int end,
		OrderByComparator<Campus> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHOOLID;
			finderArgs = new Object[] { schoolId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SCHOOLID;
			finderArgs = new Object[] { schoolId, start, end, orderByComparator };
		}

		List<Campus> list = null;

		if (retrieveFromCache) {
			list = (List<Campus>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Campus campus : list) {
					if ((schoolId != campus.getSchoolId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CAMPUS_WHERE);

			query.append(_FINDER_COLUMN_SCHOOLID_SCHOOLID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CampusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(schoolId);

				if (!pagination) {
					list = (List<Campus>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Campus>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first campus in the ordered set where schoolId = &#63;.
	 *
	 * @param schoolId the school ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campus
	 * @throws NoSuchCampusException if a matching campus could not be found
	 */
	@Override
	public Campus findByschoolId_First(long schoolId,
		OrderByComparator<Campus> orderByComparator)
		throws NoSuchCampusException {
		Campus campus = fetchByschoolId_First(schoolId, orderByComparator);

		if (campus != null) {
			return campus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("schoolId=");
		msg.append(schoolId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampusException(msg.toString());
	}

	/**
	 * Returns the first campus in the ordered set where schoolId = &#63;.
	 *
	 * @param schoolId the school ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campus, or <code>null</code> if a matching campus could not be found
	 */
	@Override
	public Campus fetchByschoolId_First(long schoolId,
		OrderByComparator<Campus> orderByComparator) {
		List<Campus> list = findByschoolId(schoolId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last campus in the ordered set where schoolId = &#63;.
	 *
	 * @param schoolId the school ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campus
	 * @throws NoSuchCampusException if a matching campus could not be found
	 */
	@Override
	public Campus findByschoolId_Last(long schoolId,
		OrderByComparator<Campus> orderByComparator)
		throws NoSuchCampusException {
		Campus campus = fetchByschoolId_Last(schoolId, orderByComparator);

		if (campus != null) {
			return campus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("schoolId=");
		msg.append(schoolId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampusException(msg.toString());
	}

	/**
	 * Returns the last campus in the ordered set where schoolId = &#63;.
	 *
	 * @param schoolId the school ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campus, or <code>null</code> if a matching campus could not be found
	 */
	@Override
	public Campus fetchByschoolId_Last(long schoolId,
		OrderByComparator<Campus> orderByComparator) {
		int count = countByschoolId(schoolId);

		if (count == 0) {
			return null;
		}

		List<Campus> list = findByschoolId(schoolId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the campuses before and after the current campus in the ordered set where schoolId = &#63;.
	 *
	 * @param campusId the primary key of the current campus
	 * @param schoolId the school ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campus
	 * @throws NoSuchCampusException if a campus with the primary key could not be found
	 */
	@Override
	public Campus[] findByschoolId_PrevAndNext(long campusId, long schoolId,
		OrderByComparator<Campus> orderByComparator)
		throws NoSuchCampusException {
		Campus campus = findByPrimaryKey(campusId);

		Session session = null;

		try {
			session = openSession();

			Campus[] array = new CampusImpl[3];

			array[0] = getByschoolId_PrevAndNext(session, campus, schoolId,
					orderByComparator, true);

			array[1] = campus;

			array[2] = getByschoolId_PrevAndNext(session, campus, schoolId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Campus getByschoolId_PrevAndNext(Session session, Campus campus,
		long schoolId, OrderByComparator<Campus> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAMPUS_WHERE);

		query.append(_FINDER_COLUMN_SCHOOLID_SCHOOLID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CampusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(schoolId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(campus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Campus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the campuses where schoolId = &#63; from the database.
	 *
	 * @param schoolId the school ID
	 */
	@Override
	public void removeByschoolId(long schoolId) {
		for (Campus campus : findByschoolId(schoolId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(campus);
		}
	}

	/**
	 * Returns the number of campuses where schoolId = &#63;.
	 *
	 * @param schoolId the school ID
	 * @return the number of matching campuses
	 */
	@Override
	public int countByschoolId(long schoolId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SCHOOLID;

		Object[] finderArgs = new Object[] { schoolId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAMPUS_WHERE);

			query.append(_FINDER_COLUMN_SCHOOLID_SCHOOLID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(schoolId);

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

	private static final String _FINDER_COLUMN_SCHOOLID_SCHOOLID_2 = "campus.schoolId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(CampusModelImpl.ENTITY_CACHE_ENABLED,
			CampusModelImpl.FINDER_CACHE_ENABLED, CampusImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByname",
			new String[] { String.class.getName() },
			CampusModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(CampusModelImpl.ENTITY_CACHE_ENABLED,
			CampusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByname",
			new String[] { String.class.getName() });

	/**
	 * Returns the campus where name = &#63; or throws a {@link NoSuchCampusException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching campus
	 * @throws NoSuchCampusException if a matching campus could not be found
	 */
	@Override
	public Campus findByname(String name) throws NoSuchCampusException {
		Campus campus = fetchByname(name);

		if (campus == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchCampusException(msg.toString());
		}

		return campus;
	}

	/**
	 * Returns the campus where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching campus, or <code>null</code> if a matching campus could not be found
	 */
	@Override
	public Campus fetchByname(String name) {
		return fetchByname(name, true);
	}

	/**
	 * Returns the campus where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching campus, or <code>null</code> if a matching campus could not be found
	 */
	@Override
	public Campus fetchByname(String name, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof Campus) {
			Campus campus = (Campus)result;

			if (!Objects.equals(name, campus.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CAMPUS_WHERE);

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

				List<Campus> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CampusPersistenceImpl.fetchByname(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Campus campus = list.get(0);

					result = campus;

					cacheResult(campus);

					if ((campus.getName() == null) ||
							!campus.getName().equals(name)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, campus);
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
			return (Campus)result;
		}
	}

	/**
	 * Removes the campus where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the campus that was removed
	 */
	@Override
	public Campus removeByname(String name) throws NoSuchCampusException {
		Campus campus = findByname(name);

		return remove(campus);
	}

	/**
	 * Returns the number of campuses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching campuses
	 */
	@Override
	public int countByname(String name) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAMPUS_WHERE);

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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "campus.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "campus.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(campus.name IS NULL OR campus.name = '')";

	public CampusPersistenceImpl() {
		setModelClass(Campus.class);
	}

	/**
	 * Caches the campus in the entity cache if it is enabled.
	 *
	 * @param campus the campus
	 */
	@Override
	public void cacheResult(Campus campus) {
		entityCache.putResult(CampusModelImpl.ENTITY_CACHE_ENABLED,
			CampusImpl.class, campus.getPrimaryKey(), campus);

		finderCache.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { campus.getName() }, campus);

		campus.resetOriginalValues();
	}

	/**
	 * Caches the campuses in the entity cache if it is enabled.
	 *
	 * @param campuses the campuses
	 */
	@Override
	public void cacheResult(List<Campus> campuses) {
		for (Campus campus : campuses) {
			if (entityCache.getResult(CampusModelImpl.ENTITY_CACHE_ENABLED,
						CampusImpl.class, campus.getPrimaryKey()) == null) {
				cacheResult(campus);
			}
			else {
				campus.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all campuses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CampusImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the campus.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Campus campus) {
		entityCache.removeResult(CampusModelImpl.ENTITY_CACHE_ENABLED,
			CampusImpl.class, campus.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CampusModelImpl)campus);
	}

	@Override
	public void clearCache(List<Campus> campuses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Campus campus : campuses) {
			entityCache.removeResult(CampusModelImpl.ENTITY_CACHE_ENABLED,
				CampusImpl.class, campus.getPrimaryKey());

			clearUniqueFindersCache((CampusModelImpl)campus);
		}
	}

	protected void cacheUniqueFindersCache(CampusModelImpl campusModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] { campusModelImpl.getName() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_NAME, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_NAME, args,
				campusModelImpl);
		}
		else {
			if ((campusModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { campusModelImpl.getName() };

				finderCache.putResult(FINDER_PATH_COUNT_BY_NAME, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_NAME, args,
					campusModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(CampusModelImpl campusModelImpl) {
		Object[] args = new Object[] { campusModelImpl.getName() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

		if ((campusModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
			args = new Object[] { campusModelImpl.getOriginalName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
		}
	}

	/**
	 * Creates a new campus with the primary key. Does not add the campus to the database.
	 *
	 * @param campusId the primary key for the new campus
	 * @return the new campus
	 */
	@Override
	public Campus create(long campusId) {
		Campus campus = new CampusImpl();

		campus.setNew(true);
		campus.setPrimaryKey(campusId);

		return campus;
	}

	/**
	 * Removes the campus with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param campusId the primary key of the campus
	 * @return the campus that was removed
	 * @throws NoSuchCampusException if a campus with the primary key could not be found
	 */
	@Override
	public Campus remove(long campusId) throws NoSuchCampusException {
		return remove((Serializable)campusId);
	}

	/**
	 * Removes the campus with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the campus
	 * @return the campus that was removed
	 * @throws NoSuchCampusException if a campus with the primary key could not be found
	 */
	@Override
	public Campus remove(Serializable primaryKey) throws NoSuchCampusException {
		Session session = null;

		try {
			session = openSession();

			Campus campus = (Campus)session.get(CampusImpl.class, primaryKey);

			if (campus == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCampusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(campus);
		}
		catch (NoSuchCampusException nsee) {
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
	protected Campus removeImpl(Campus campus) {
		campus = toUnwrappedModel(campus);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(campus)) {
				campus = (Campus)session.get(CampusImpl.class,
						campus.getPrimaryKeyObj());
			}

			if (campus != null) {
				session.delete(campus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (campus != null) {
			clearCache(campus);
		}

		return campus;
	}

	@Override
	public Campus updateImpl(Campus campus) {
		campus = toUnwrappedModel(campus);

		boolean isNew = campus.isNew();

		CampusModelImpl campusModelImpl = (CampusModelImpl)campus;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (campus.getCreateDate() == null)) {
			if (serviceContext == null) {
				campus.setCreateDate(now);
			}
			else {
				campus.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!campusModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				campus.setModifiedDate(now);
			}
			else {
				campus.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (campus.isNew()) {
				session.save(campus);

				campus.setNew(false);
			}
			else {
				campus = (Campus)session.merge(campus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CampusModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((campusModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHOOLID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						campusModelImpl.getOriginalSchoolId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SCHOOLID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHOOLID,
					args);

				args = new Object[] { campusModelImpl.getSchoolId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SCHOOLID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCHOOLID,
					args);
			}
		}

		entityCache.putResult(CampusModelImpl.ENTITY_CACHE_ENABLED,
			CampusImpl.class, campus.getPrimaryKey(), campus, false);

		clearUniqueFindersCache(campusModelImpl);
		cacheUniqueFindersCache(campusModelImpl, isNew);

		campus.resetOriginalValues();

		return campus;
	}

	protected Campus toUnwrappedModel(Campus campus) {
		if (campus instanceof CampusImpl) {
			return campus;
		}

		CampusImpl campusImpl = new CampusImpl();

		campusImpl.setNew(campus.isNew());
		campusImpl.setPrimaryKey(campus.getPrimaryKey());

		campusImpl.setCampusId(campus.getCampusId());
		campusImpl.setSchoolId(campus.getSchoolId());
		campusImpl.setName(campus.getName());
		campusImpl.setAddress1(campus.getAddress1());
		campusImpl.setCity(campus.getCity());
		campusImpl.setState(campus.getState());
		campusImpl.setCountry(campus.getCountry());
		campusImpl.setZipcode(campus.getZipcode());
		campusImpl.setContactNumber(campus.getContactNumber());
		campusImpl.setWebsiteLink(campus.getWebsiteLink());
		campusImpl.setContactPersonName(campus.getContactPersonName());
		campusImpl.setContactPersonPhoneNumber(campus.getContactPersonPhoneNumber());
		campusImpl.setContactPersonEmail(campus.getContactPersonEmail());
		campusImpl.setStatus(campus.getStatus());
		campusImpl.setCreateDate(campus.getCreateDate());
		campusImpl.setCreatedBy(campus.getCreatedBy());
		campusImpl.setModifiedDate(campus.getModifiedDate());
		campusImpl.setModifiedBy(campus.getModifiedBy());

		return campusImpl;
	}

	/**
	 * Returns the campus with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the campus
	 * @return the campus
	 * @throws NoSuchCampusException if a campus with the primary key could not be found
	 */
	@Override
	public Campus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCampusException {
		Campus campus = fetchByPrimaryKey(primaryKey);

		if (campus == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCampusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return campus;
	}

	/**
	 * Returns the campus with the primary key or throws a {@link NoSuchCampusException} if it could not be found.
	 *
	 * @param campusId the primary key of the campus
	 * @return the campus
	 * @throws NoSuchCampusException if a campus with the primary key could not be found
	 */
	@Override
	public Campus findByPrimaryKey(long campusId) throws NoSuchCampusException {
		return findByPrimaryKey((Serializable)campusId);
	}

	/**
	 * Returns the campus with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the campus
	 * @return the campus, or <code>null</code> if a campus with the primary key could not be found
	 */
	@Override
	public Campus fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CampusModelImpl.ENTITY_CACHE_ENABLED,
				CampusImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Campus campus = (Campus)serializable;

		if (campus == null) {
			Session session = null;

			try {
				session = openSession();

				campus = (Campus)session.get(CampusImpl.class, primaryKey);

				if (campus != null) {
					cacheResult(campus);
				}
				else {
					entityCache.putResult(CampusModelImpl.ENTITY_CACHE_ENABLED,
						CampusImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CampusModelImpl.ENTITY_CACHE_ENABLED,
					CampusImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return campus;
	}

	/**
	 * Returns the campus with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param campusId the primary key of the campus
	 * @return the campus, or <code>null</code> if a campus with the primary key could not be found
	 */
	@Override
	public Campus fetchByPrimaryKey(long campusId) {
		return fetchByPrimaryKey((Serializable)campusId);
	}

	@Override
	public Map<Serializable, Campus> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Campus> map = new HashMap<Serializable, Campus>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Campus campus = fetchByPrimaryKey(primaryKey);

			if (campus != null) {
				map.put(primaryKey, campus);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CampusModelImpl.ENTITY_CACHE_ENABLED,
					CampusImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Campus)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CAMPUS_WHERE_PKS_IN);

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

			for (Campus campus : (List<Campus>)q.list()) {
				map.put(campus.getPrimaryKeyObj(), campus);

				cacheResult(campus);

				uncachedPrimaryKeys.remove(campus.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CampusModelImpl.ENTITY_CACHE_ENABLED,
					CampusImpl.class, primaryKey, nullModel);
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
	 * Returns all the campuses.
	 *
	 * @return the campuses
	 */
	@Override
	public List<Campus> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of campuses
	 * @param end the upper bound of the range of campuses (not inclusive)
	 * @return the range of campuses
	 */
	@Override
	public List<Campus> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the campuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of campuses
	 * @param end the upper bound of the range of campuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of campuses
	 */
	@Override
	public List<Campus> findAll(int start, int end,
		OrderByComparator<Campus> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the campuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of campuses
	 * @param end the upper bound of the range of campuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of campuses
	 */
	@Override
	public List<Campus> findAll(int start, int end,
		OrderByComparator<Campus> orderByComparator, boolean retrieveFromCache) {
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

		List<Campus> list = null;

		if (retrieveFromCache) {
			list = (List<Campus>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CAMPUS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CAMPUS;

				if (pagination) {
					sql = sql.concat(CampusModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Campus>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Campus>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the campuses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Campus campus : findAll()) {
			remove(campus);
		}
	}

	/**
	 * Returns the number of campuses.
	 *
	 * @return the number of campuses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CAMPUS);

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
		return CampusModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the campus persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CampusImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CAMPUS = "SELECT campus FROM Campus campus";
	private static final String _SQL_SELECT_CAMPUS_WHERE_PKS_IN = "SELECT campus FROM Campus campus WHERE campusId IN (";
	private static final String _SQL_SELECT_CAMPUS_WHERE = "SELECT campus FROM Campus campus WHERE ";
	private static final String _SQL_COUNT_CAMPUS = "SELECT COUNT(campus) FROM Campus campus";
	private static final String _SQL_COUNT_CAMPUS_WHERE = "SELECT COUNT(campus) FROM Campus campus WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "campus.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Campus exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Campus exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CampusPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"state"
			});
}