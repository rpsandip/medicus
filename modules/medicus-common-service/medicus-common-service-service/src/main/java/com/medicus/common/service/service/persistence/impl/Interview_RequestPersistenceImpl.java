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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.medicus.common.service.exception.NoSuchInterview_RequestException;
import com.medicus.common.service.model.Interview_Request;
import com.medicus.common.service.model.impl.Interview_RequestImpl;
import com.medicus.common.service.model.impl.Interview_RequestModelImpl;
import com.medicus.common.service.service.persistence.Interview_RequestPK;
import com.medicus.common.service.service.persistence.Interview_RequestPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the interview_ request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sandip.patel
 * @see Interview_RequestPersistence
 * @see com.medicus.common.service.service.persistence.Interview_RequestUtil
 * @generated
 */
@ProviderType
public class Interview_RequestPersistenceImpl extends BasePersistenceImpl<Interview_Request>
	implements Interview_RequestPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Interview_RequestUtil} to access the interview_ request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Interview_RequestImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Interview_RequestModelImpl.ENTITY_CACHE_ENABLED,
			Interview_RequestModelImpl.FINDER_CACHE_ENABLED,
			Interview_RequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Interview_RequestModelImpl.ENTITY_CACHE_ENABLED,
			Interview_RequestModelImpl.FINDER_CACHE_ENABLED,
			Interview_RequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Interview_RequestModelImpl.ENTITY_CACHE_ENABLED,
			Interview_RequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARTNERID =
		new FinderPath(Interview_RequestModelImpl.ENTITY_CACHE_ENABLED,
			Interview_RequestModelImpl.FINDER_CACHE_ENABLED,
			Interview_RequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBypartnerId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARTNERID =
		new FinderPath(Interview_RequestModelImpl.ENTITY_CACHE_ENABLED,
			Interview_RequestModelImpl.FINDER_CACHE_ENABLED,
			Interview_RequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBypartnerId",
			new String[] { Long.class.getName() },
			Interview_RequestModelImpl.PARTNERID_COLUMN_BITMASK |
			Interview_RequestModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARTNERID = new FinderPath(Interview_RequestModelImpl.ENTITY_CACHE_ENABLED,
			Interview_RequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypartnerId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the interview_ requests where partnerId = &#63;.
	 *
	 * @param partnerId the partner ID
	 * @return the matching interview_ requests
	 */
	@Override
	public List<Interview_Request> findBypartnerId(long partnerId) {
		return findBypartnerId(partnerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the interview_ requests where partnerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param partnerId the partner ID
	 * @param start the lower bound of the range of interview_ requests
	 * @param end the upper bound of the range of interview_ requests (not inclusive)
	 * @return the range of matching interview_ requests
	 */
	@Override
	public List<Interview_Request> findBypartnerId(long partnerId, int start,
		int end) {
		return findBypartnerId(partnerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the interview_ requests where partnerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param partnerId the partner ID
	 * @param start the lower bound of the range of interview_ requests
	 * @param end the upper bound of the range of interview_ requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching interview_ requests
	 */
	@Override
	public List<Interview_Request> findBypartnerId(long partnerId, int start,
		int end, OrderByComparator<Interview_Request> orderByComparator) {
		return findBypartnerId(partnerId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the interview_ requests where partnerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param partnerId the partner ID
	 * @param start the lower bound of the range of interview_ requests
	 * @param end the upper bound of the range of interview_ requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching interview_ requests
	 */
	@Override
	public List<Interview_Request> findBypartnerId(long partnerId, int start,
		int end, OrderByComparator<Interview_Request> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARTNERID;
			finderArgs = new Object[] { partnerId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARTNERID;
			finderArgs = new Object[] { partnerId, start, end, orderByComparator };
		}

		List<Interview_Request> list = null;

		if (retrieveFromCache) {
			list = (List<Interview_Request>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Interview_Request interview_Request : list) {
					if ((partnerId != interview_Request.getPartnerId())) {
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

			query.append(_SQL_SELECT_INTERVIEW_REQUEST_WHERE);

			query.append(_FINDER_COLUMN_PARTNERID_PARTNERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Interview_RequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(partnerId);

				if (!pagination) {
					list = (List<Interview_Request>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Interview_Request>)QueryUtil.list(q,
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
	 * Returns the first interview_ request in the ordered set where partnerId = &#63;.
	 *
	 * @param partnerId the partner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interview_ request
	 * @throws NoSuchInterview_RequestException if a matching interview_ request could not be found
	 */
	@Override
	public Interview_Request findBypartnerId_First(long partnerId,
		OrderByComparator<Interview_Request> orderByComparator)
		throws NoSuchInterview_RequestException {
		Interview_Request interview_Request = fetchBypartnerId_First(partnerId,
				orderByComparator);

		if (interview_Request != null) {
			return interview_Request;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("partnerId=");
		msg.append(partnerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInterview_RequestException(msg.toString());
	}

	/**
	 * Returns the first interview_ request in the ordered set where partnerId = &#63;.
	 *
	 * @param partnerId the partner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interview_ request, or <code>null</code> if a matching interview_ request could not be found
	 */
	@Override
	public Interview_Request fetchBypartnerId_First(long partnerId,
		OrderByComparator<Interview_Request> orderByComparator) {
		List<Interview_Request> list = findBypartnerId(partnerId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last interview_ request in the ordered set where partnerId = &#63;.
	 *
	 * @param partnerId the partner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interview_ request
	 * @throws NoSuchInterview_RequestException if a matching interview_ request could not be found
	 */
	@Override
	public Interview_Request findBypartnerId_Last(long partnerId,
		OrderByComparator<Interview_Request> orderByComparator)
		throws NoSuchInterview_RequestException {
		Interview_Request interview_Request = fetchBypartnerId_Last(partnerId,
				orderByComparator);

		if (interview_Request != null) {
			return interview_Request;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("partnerId=");
		msg.append(partnerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInterview_RequestException(msg.toString());
	}

	/**
	 * Returns the last interview_ request in the ordered set where partnerId = &#63;.
	 *
	 * @param partnerId the partner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interview_ request, or <code>null</code> if a matching interview_ request could not be found
	 */
	@Override
	public Interview_Request fetchBypartnerId_Last(long partnerId,
		OrderByComparator<Interview_Request> orderByComparator) {
		int count = countBypartnerId(partnerId);

		if (count == 0) {
			return null;
		}

		List<Interview_Request> list = findBypartnerId(partnerId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the interview_ requests before and after the current interview_ request in the ordered set where partnerId = &#63;.
	 *
	 * @param interview_RequestPK the primary key of the current interview_ request
	 * @param partnerId the partner ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next interview_ request
	 * @throws NoSuchInterview_RequestException if a interview_ request with the primary key could not be found
	 */
	@Override
	public Interview_Request[] findBypartnerId_PrevAndNext(
		Interview_RequestPK interview_RequestPK, long partnerId,
		OrderByComparator<Interview_Request> orderByComparator)
		throws NoSuchInterview_RequestException {
		Interview_Request interview_Request = findByPrimaryKey(interview_RequestPK);

		Session session = null;

		try {
			session = openSession();

			Interview_Request[] array = new Interview_RequestImpl[3];

			array[0] = getBypartnerId_PrevAndNext(session, interview_Request,
					partnerId, orderByComparator, true);

			array[1] = interview_Request;

			array[2] = getBypartnerId_PrevAndNext(session, interview_Request,
					partnerId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Interview_Request getBypartnerId_PrevAndNext(Session session,
		Interview_Request interview_Request, long partnerId,
		OrderByComparator<Interview_Request> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INTERVIEW_REQUEST_WHERE);

		query.append(_FINDER_COLUMN_PARTNERID_PARTNERID_2);

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
			query.append(Interview_RequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(partnerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(interview_Request);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Interview_Request> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the interview_ requests where partnerId = &#63; from the database.
	 *
	 * @param partnerId the partner ID
	 */
	@Override
	public void removeBypartnerId(long partnerId) {
		for (Interview_Request interview_Request : findBypartnerId(partnerId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(interview_Request);
		}
	}

	/**
	 * Returns the number of interview_ requests where partnerId = &#63;.
	 *
	 * @param partnerId the partner ID
	 * @return the number of matching interview_ requests
	 */
	@Override
	public int countBypartnerId(long partnerId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARTNERID;

		Object[] finderArgs = new Object[] { partnerId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INTERVIEW_REQUEST_WHERE);

			query.append(_FINDER_COLUMN_PARTNERID_PARTNERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(partnerId);

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

	private static final String _FINDER_COLUMN_PARTNERID_PARTNERID_2 = "interview_Request.id.partnerId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPUSID = new FinderPath(Interview_RequestModelImpl.ENTITY_CACHE_ENABLED,
			Interview_RequestModelImpl.FINDER_CACHE_ENABLED,
			Interview_RequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycampusId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPUSID =
		new FinderPath(Interview_RequestModelImpl.ENTITY_CACHE_ENABLED,
			Interview_RequestModelImpl.FINDER_CACHE_ENABLED,
			Interview_RequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycampusId",
			new String[] { Long.class.getName() },
			Interview_RequestModelImpl.CAMPUSID_COLUMN_BITMASK |
			Interview_RequestModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPUSID = new FinderPath(Interview_RequestModelImpl.ENTITY_CACHE_ENABLED,
			Interview_RequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycampusId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the interview_ requests where campusId = &#63;.
	 *
	 * @param campusId the campus ID
	 * @return the matching interview_ requests
	 */
	@Override
	public List<Interview_Request> findBycampusId(long campusId) {
		return findBycampusId(campusId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the interview_ requests where campusId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campusId the campus ID
	 * @param start the lower bound of the range of interview_ requests
	 * @param end the upper bound of the range of interview_ requests (not inclusive)
	 * @return the range of matching interview_ requests
	 */
	@Override
	public List<Interview_Request> findBycampusId(long campusId, int start,
		int end) {
		return findBycampusId(campusId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the interview_ requests where campusId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campusId the campus ID
	 * @param start the lower bound of the range of interview_ requests
	 * @param end the upper bound of the range of interview_ requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching interview_ requests
	 */
	@Override
	public List<Interview_Request> findBycampusId(long campusId, int start,
		int end, OrderByComparator<Interview_Request> orderByComparator) {
		return findBycampusId(campusId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the interview_ requests where campusId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campusId the campus ID
	 * @param start the lower bound of the range of interview_ requests
	 * @param end the upper bound of the range of interview_ requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching interview_ requests
	 */
	@Override
	public List<Interview_Request> findBycampusId(long campusId, int start,
		int end, OrderByComparator<Interview_Request> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPUSID;
			finderArgs = new Object[] { campusId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPUSID;
			finderArgs = new Object[] { campusId, start, end, orderByComparator };
		}

		List<Interview_Request> list = null;

		if (retrieveFromCache) {
			list = (List<Interview_Request>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Interview_Request interview_Request : list) {
					if ((campusId != interview_Request.getCampusId())) {
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

			query.append(_SQL_SELECT_INTERVIEW_REQUEST_WHERE);

			query.append(_FINDER_COLUMN_CAMPUSID_CAMPUSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Interview_RequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campusId);

				if (!pagination) {
					list = (List<Interview_Request>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Interview_Request>)QueryUtil.list(q,
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
	 * Returns the first interview_ request in the ordered set where campusId = &#63;.
	 *
	 * @param campusId the campus ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interview_ request
	 * @throws NoSuchInterview_RequestException if a matching interview_ request could not be found
	 */
	@Override
	public Interview_Request findBycampusId_First(long campusId,
		OrderByComparator<Interview_Request> orderByComparator)
		throws NoSuchInterview_RequestException {
		Interview_Request interview_Request = fetchBycampusId_First(campusId,
				orderByComparator);

		if (interview_Request != null) {
			return interview_Request;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campusId=");
		msg.append(campusId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInterview_RequestException(msg.toString());
	}

	/**
	 * Returns the first interview_ request in the ordered set where campusId = &#63;.
	 *
	 * @param campusId the campus ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interview_ request, or <code>null</code> if a matching interview_ request could not be found
	 */
	@Override
	public Interview_Request fetchBycampusId_First(long campusId,
		OrderByComparator<Interview_Request> orderByComparator) {
		List<Interview_Request> list = findBycampusId(campusId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last interview_ request in the ordered set where campusId = &#63;.
	 *
	 * @param campusId the campus ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interview_ request
	 * @throws NoSuchInterview_RequestException if a matching interview_ request could not be found
	 */
	@Override
	public Interview_Request findBycampusId_Last(long campusId,
		OrderByComparator<Interview_Request> orderByComparator)
		throws NoSuchInterview_RequestException {
		Interview_Request interview_Request = fetchBycampusId_Last(campusId,
				orderByComparator);

		if (interview_Request != null) {
			return interview_Request;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campusId=");
		msg.append(campusId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInterview_RequestException(msg.toString());
	}

	/**
	 * Returns the last interview_ request in the ordered set where campusId = &#63;.
	 *
	 * @param campusId the campus ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interview_ request, or <code>null</code> if a matching interview_ request could not be found
	 */
	@Override
	public Interview_Request fetchBycampusId_Last(long campusId,
		OrderByComparator<Interview_Request> orderByComparator) {
		int count = countBycampusId(campusId);

		if (count == 0) {
			return null;
		}

		List<Interview_Request> list = findBycampusId(campusId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the interview_ requests before and after the current interview_ request in the ordered set where campusId = &#63;.
	 *
	 * @param interview_RequestPK the primary key of the current interview_ request
	 * @param campusId the campus ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next interview_ request
	 * @throws NoSuchInterview_RequestException if a interview_ request with the primary key could not be found
	 */
	@Override
	public Interview_Request[] findBycampusId_PrevAndNext(
		Interview_RequestPK interview_RequestPK, long campusId,
		OrderByComparator<Interview_Request> orderByComparator)
		throws NoSuchInterview_RequestException {
		Interview_Request interview_Request = findByPrimaryKey(interview_RequestPK);

		Session session = null;

		try {
			session = openSession();

			Interview_Request[] array = new Interview_RequestImpl[3];

			array[0] = getBycampusId_PrevAndNext(session, interview_Request,
					campusId, orderByComparator, true);

			array[1] = interview_Request;

			array[2] = getBycampusId_PrevAndNext(session, interview_Request,
					campusId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Interview_Request getBycampusId_PrevAndNext(Session session,
		Interview_Request interview_Request, long campusId,
		OrderByComparator<Interview_Request> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INTERVIEW_REQUEST_WHERE);

		query.append(_FINDER_COLUMN_CAMPUSID_CAMPUSID_2);

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
			query.append(Interview_RequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(campusId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(interview_Request);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Interview_Request> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the interview_ requests where campusId = &#63; from the database.
	 *
	 * @param campusId the campus ID
	 */
	@Override
	public void removeBycampusId(long campusId) {
		for (Interview_Request interview_Request : findBycampusId(campusId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(interview_Request);
		}
	}

	/**
	 * Returns the number of interview_ requests where campusId = &#63;.
	 *
	 * @param campusId the campus ID
	 * @return the number of matching interview_ requests
	 */
	@Override
	public int countBycampusId(long campusId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPUSID;

		Object[] finderArgs = new Object[] { campusId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INTERVIEW_REQUEST_WHERE);

			query.append(_FINDER_COLUMN_CAMPUSID_CAMPUSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campusId);

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

	private static final String _FINDER_COLUMN_CAMPUSID_CAMPUSID_2 = "interview_Request.campusId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STUDENTID =
		new FinderPath(Interview_RequestModelImpl.ENTITY_CACHE_ENABLED,
			Interview_RequestModelImpl.FINDER_CACHE_ENABLED,
			Interview_RequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystudentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID =
		new FinderPath(Interview_RequestModelImpl.ENTITY_CACHE_ENABLED,
			Interview_RequestModelImpl.FINDER_CACHE_ENABLED,
			Interview_RequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystudentId",
			new String[] { Long.class.getName() },
			Interview_RequestModelImpl.STUDENTID_COLUMN_BITMASK |
			Interview_RequestModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STUDENTID = new FinderPath(Interview_RequestModelImpl.ENTITY_CACHE_ENABLED,
			Interview_RequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystudentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the interview_ requests where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @return the matching interview_ requests
	 */
	@Override
	public List<Interview_Request> findBystudentId(long studentId) {
		return findBystudentId(studentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the interview_ requests where studentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param studentId the student ID
	 * @param start the lower bound of the range of interview_ requests
	 * @param end the upper bound of the range of interview_ requests (not inclusive)
	 * @return the range of matching interview_ requests
	 */
	@Override
	public List<Interview_Request> findBystudentId(long studentId, int start,
		int end) {
		return findBystudentId(studentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the interview_ requests where studentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param studentId the student ID
	 * @param start the lower bound of the range of interview_ requests
	 * @param end the upper bound of the range of interview_ requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching interview_ requests
	 */
	@Override
	public List<Interview_Request> findBystudentId(long studentId, int start,
		int end, OrderByComparator<Interview_Request> orderByComparator) {
		return findBystudentId(studentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the interview_ requests where studentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param studentId the student ID
	 * @param start the lower bound of the range of interview_ requests
	 * @param end the upper bound of the range of interview_ requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching interview_ requests
	 */
	@Override
	public List<Interview_Request> findBystudentId(long studentId, int start,
		int end, OrderByComparator<Interview_Request> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID;
			finderArgs = new Object[] { studentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STUDENTID;
			finderArgs = new Object[] { studentId, start, end, orderByComparator };
		}

		List<Interview_Request> list = null;

		if (retrieveFromCache) {
			list = (List<Interview_Request>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Interview_Request interview_Request : list) {
					if ((studentId != interview_Request.getStudentId())) {
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

			query.append(_SQL_SELECT_INTERVIEW_REQUEST_WHERE);

			query.append(_FINDER_COLUMN_STUDENTID_STUDENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Interview_RequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentId);

				if (!pagination) {
					list = (List<Interview_Request>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Interview_Request>)QueryUtil.list(q,
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
	 * Returns the first interview_ request in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interview_ request
	 * @throws NoSuchInterview_RequestException if a matching interview_ request could not be found
	 */
	@Override
	public Interview_Request findBystudentId_First(long studentId,
		OrderByComparator<Interview_Request> orderByComparator)
		throws NoSuchInterview_RequestException {
		Interview_Request interview_Request = fetchBystudentId_First(studentId,
				orderByComparator);

		if (interview_Request != null) {
			return interview_Request;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentId=");
		msg.append(studentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInterview_RequestException(msg.toString());
	}

	/**
	 * Returns the first interview_ request in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interview_ request, or <code>null</code> if a matching interview_ request could not be found
	 */
	@Override
	public Interview_Request fetchBystudentId_First(long studentId,
		OrderByComparator<Interview_Request> orderByComparator) {
		List<Interview_Request> list = findBystudentId(studentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last interview_ request in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interview_ request
	 * @throws NoSuchInterview_RequestException if a matching interview_ request could not be found
	 */
	@Override
	public Interview_Request findBystudentId_Last(long studentId,
		OrderByComparator<Interview_Request> orderByComparator)
		throws NoSuchInterview_RequestException {
		Interview_Request interview_Request = fetchBystudentId_Last(studentId,
				orderByComparator);

		if (interview_Request != null) {
			return interview_Request;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentId=");
		msg.append(studentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInterview_RequestException(msg.toString());
	}

	/**
	 * Returns the last interview_ request in the ordered set where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interview_ request, or <code>null</code> if a matching interview_ request could not be found
	 */
	@Override
	public Interview_Request fetchBystudentId_Last(long studentId,
		OrderByComparator<Interview_Request> orderByComparator) {
		int count = countBystudentId(studentId);

		if (count == 0) {
			return null;
		}

		List<Interview_Request> list = findBystudentId(studentId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the interview_ requests before and after the current interview_ request in the ordered set where studentId = &#63;.
	 *
	 * @param interview_RequestPK the primary key of the current interview_ request
	 * @param studentId the student ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next interview_ request
	 * @throws NoSuchInterview_RequestException if a interview_ request with the primary key could not be found
	 */
	@Override
	public Interview_Request[] findBystudentId_PrevAndNext(
		Interview_RequestPK interview_RequestPK, long studentId,
		OrderByComparator<Interview_Request> orderByComparator)
		throws NoSuchInterview_RequestException {
		Interview_Request interview_Request = findByPrimaryKey(interview_RequestPK);

		Session session = null;

		try {
			session = openSession();

			Interview_Request[] array = new Interview_RequestImpl[3];

			array[0] = getBystudentId_PrevAndNext(session, interview_Request,
					studentId, orderByComparator, true);

			array[1] = interview_Request;

			array[2] = getBystudentId_PrevAndNext(session, interview_Request,
					studentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Interview_Request getBystudentId_PrevAndNext(Session session,
		Interview_Request interview_Request, long studentId,
		OrderByComparator<Interview_Request> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INTERVIEW_REQUEST_WHERE);

		query.append(_FINDER_COLUMN_STUDENTID_STUDENTID_2);

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
			query.append(Interview_RequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(studentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(interview_Request);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Interview_Request> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the interview_ requests where studentId = &#63; from the database.
	 *
	 * @param studentId the student ID
	 */
	@Override
	public void removeBystudentId(long studentId) {
		for (Interview_Request interview_Request : findBystudentId(studentId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(interview_Request);
		}
	}

	/**
	 * Returns the number of interview_ requests where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @return the number of matching interview_ requests
	 */
	@Override
	public int countBystudentId(long studentId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STUDENTID;

		Object[] finderArgs = new Object[] { studentId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INTERVIEW_REQUEST_WHERE);

			query.append(_FINDER_COLUMN_STUDENTID_STUDENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentId);

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

	private static final String _FINDER_COLUMN_STUDENTID_STUDENTID_2 = "interview_Request.id.studentId = ?";

	public Interview_RequestPersistenceImpl() {
		setModelClass(Interview_Request.class);
	}

	/**
	 * Caches the interview_ request in the entity cache if it is enabled.
	 *
	 * @param interview_Request the interview_ request
	 */
	@Override
	public void cacheResult(Interview_Request interview_Request) {
		entityCache.putResult(Interview_RequestModelImpl.ENTITY_CACHE_ENABLED,
			Interview_RequestImpl.class, interview_Request.getPrimaryKey(),
			interview_Request);

		interview_Request.resetOriginalValues();
	}

	/**
	 * Caches the interview_ requests in the entity cache if it is enabled.
	 *
	 * @param interview_Requests the interview_ requests
	 */
	@Override
	public void cacheResult(List<Interview_Request> interview_Requests) {
		for (Interview_Request interview_Request : interview_Requests) {
			if (entityCache.getResult(
						Interview_RequestModelImpl.ENTITY_CACHE_ENABLED,
						Interview_RequestImpl.class,
						interview_Request.getPrimaryKey()) == null) {
				cacheResult(interview_Request);
			}
			else {
				interview_Request.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all interview_ requests.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Interview_RequestImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the interview_ request.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Interview_Request interview_Request) {
		entityCache.removeResult(Interview_RequestModelImpl.ENTITY_CACHE_ENABLED,
			Interview_RequestImpl.class, interview_Request.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Interview_Request> interview_Requests) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Interview_Request interview_Request : interview_Requests) {
			entityCache.removeResult(Interview_RequestModelImpl.ENTITY_CACHE_ENABLED,
				Interview_RequestImpl.class, interview_Request.getPrimaryKey());
		}
	}

	/**
	 * Creates a new interview_ request with the primary key. Does not add the interview_ request to the database.
	 *
	 * @param interview_RequestPK the primary key for the new interview_ request
	 * @return the new interview_ request
	 */
	@Override
	public Interview_Request create(Interview_RequestPK interview_RequestPK) {
		Interview_Request interview_Request = new Interview_RequestImpl();

		interview_Request.setNew(true);
		interview_Request.setPrimaryKey(interview_RequestPK);

		return interview_Request;
	}

	/**
	 * Removes the interview_ request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param interview_RequestPK the primary key of the interview_ request
	 * @return the interview_ request that was removed
	 * @throws NoSuchInterview_RequestException if a interview_ request with the primary key could not be found
	 */
	@Override
	public Interview_Request remove(Interview_RequestPK interview_RequestPK)
		throws NoSuchInterview_RequestException {
		return remove((Serializable)interview_RequestPK);
	}

	/**
	 * Removes the interview_ request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the interview_ request
	 * @return the interview_ request that was removed
	 * @throws NoSuchInterview_RequestException if a interview_ request with the primary key could not be found
	 */
	@Override
	public Interview_Request remove(Serializable primaryKey)
		throws NoSuchInterview_RequestException {
		Session session = null;

		try {
			session = openSession();

			Interview_Request interview_Request = (Interview_Request)session.get(Interview_RequestImpl.class,
					primaryKey);

			if (interview_Request == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInterview_RequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(interview_Request);
		}
		catch (NoSuchInterview_RequestException nsee) {
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
	protected Interview_Request removeImpl(Interview_Request interview_Request) {
		interview_Request = toUnwrappedModel(interview_Request);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(interview_Request)) {
				interview_Request = (Interview_Request)session.get(Interview_RequestImpl.class,
						interview_Request.getPrimaryKeyObj());
			}

			if (interview_Request != null) {
				session.delete(interview_Request);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (interview_Request != null) {
			clearCache(interview_Request);
		}

		return interview_Request;
	}

	@Override
	public Interview_Request updateImpl(Interview_Request interview_Request) {
		interview_Request = toUnwrappedModel(interview_Request);

		boolean isNew = interview_Request.isNew();

		Interview_RequestModelImpl interview_RequestModelImpl = (Interview_RequestModelImpl)interview_Request;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (interview_Request.getCreateDate() == null)) {
			if (serviceContext == null) {
				interview_Request.setCreateDate(now);
			}
			else {
				interview_Request.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!interview_RequestModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				interview_Request.setModifiedDate(now);
			}
			else {
				interview_Request.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (interview_Request.isNew()) {
				session.save(interview_Request);

				interview_Request.setNew(false);
			}
			else {
				interview_Request = (Interview_Request)session.merge(interview_Request);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Interview_RequestModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((interview_RequestModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARTNERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						interview_RequestModelImpl.getOriginalPartnerId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PARTNERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARTNERID,
					args);

				args = new Object[] { interview_RequestModelImpl.getPartnerId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PARTNERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARTNERID,
					args);
			}

			if ((interview_RequestModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPUSID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						interview_RequestModelImpl.getOriginalCampusId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CAMPUSID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPUSID,
					args);

				args = new Object[] { interview_RequestModelImpl.getCampusId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CAMPUSID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPUSID,
					args);
			}

			if ((interview_RequestModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						interview_RequestModelImpl.getOriginalStudentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STUDENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID,
					args);

				args = new Object[] { interview_RequestModelImpl.getStudentId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STUDENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STUDENTID,
					args);
			}
		}

		entityCache.putResult(Interview_RequestModelImpl.ENTITY_CACHE_ENABLED,
			Interview_RequestImpl.class, interview_Request.getPrimaryKey(),
			interview_Request, false);

		interview_Request.resetOriginalValues();

		return interview_Request;
	}

	protected Interview_Request toUnwrappedModel(
		Interview_Request interview_Request) {
		if (interview_Request instanceof Interview_RequestImpl) {
			return interview_Request;
		}

		Interview_RequestImpl interview_RequestImpl = new Interview_RequestImpl();

		interview_RequestImpl.setNew(interview_Request.isNew());
		interview_RequestImpl.setPrimaryKey(interview_Request.getPrimaryKey());

		interview_RequestImpl.setPartnerId(interview_Request.getPartnerId());
		interview_RequestImpl.setStudentId(interview_Request.getStudentId());
		interview_RequestImpl.setSchoolId(interview_Request.getSchoolId());
		interview_RequestImpl.setCampusId(interview_Request.getCampusId());
		interview_RequestImpl.setStatus(interview_Request.getStatus());
		interview_RequestImpl.setCreateDate(interview_Request.getCreateDate());
		interview_RequestImpl.setCreatedBy(interview_Request.getCreatedBy());
		interview_RequestImpl.setModifiedDate(interview_Request.getModifiedDate());
		interview_RequestImpl.setModifiedBy(interview_Request.getModifiedBy());

		return interview_RequestImpl;
	}

	/**
	 * Returns the interview_ request with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the interview_ request
	 * @return the interview_ request
	 * @throws NoSuchInterview_RequestException if a interview_ request with the primary key could not be found
	 */
	@Override
	public Interview_Request findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInterview_RequestException {
		Interview_Request interview_Request = fetchByPrimaryKey(primaryKey);

		if (interview_Request == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInterview_RequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return interview_Request;
	}

	/**
	 * Returns the interview_ request with the primary key or throws a {@link NoSuchInterview_RequestException} if it could not be found.
	 *
	 * @param interview_RequestPK the primary key of the interview_ request
	 * @return the interview_ request
	 * @throws NoSuchInterview_RequestException if a interview_ request with the primary key could not be found
	 */
	@Override
	public Interview_Request findByPrimaryKey(
		Interview_RequestPK interview_RequestPK)
		throws NoSuchInterview_RequestException {
		return findByPrimaryKey((Serializable)interview_RequestPK);
	}

	/**
	 * Returns the interview_ request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the interview_ request
	 * @return the interview_ request, or <code>null</code> if a interview_ request with the primary key could not be found
	 */
	@Override
	public Interview_Request fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(Interview_RequestModelImpl.ENTITY_CACHE_ENABLED,
				Interview_RequestImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Interview_Request interview_Request = (Interview_Request)serializable;

		if (interview_Request == null) {
			Session session = null;

			try {
				session = openSession();

				interview_Request = (Interview_Request)session.get(Interview_RequestImpl.class,
						primaryKey);

				if (interview_Request != null) {
					cacheResult(interview_Request);
				}
				else {
					entityCache.putResult(Interview_RequestModelImpl.ENTITY_CACHE_ENABLED,
						Interview_RequestImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(Interview_RequestModelImpl.ENTITY_CACHE_ENABLED,
					Interview_RequestImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return interview_Request;
	}

	/**
	 * Returns the interview_ request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param interview_RequestPK the primary key of the interview_ request
	 * @return the interview_ request, or <code>null</code> if a interview_ request with the primary key could not be found
	 */
	@Override
	public Interview_Request fetchByPrimaryKey(
		Interview_RequestPK interview_RequestPK) {
		return fetchByPrimaryKey((Serializable)interview_RequestPK);
	}

	@Override
	public Map<Serializable, Interview_Request> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Interview_Request> map = new HashMap<Serializable, Interview_Request>();

		for (Serializable primaryKey : primaryKeys) {
			Interview_Request interview_Request = fetchByPrimaryKey(primaryKey);

			if (interview_Request != null) {
				map.put(primaryKey, interview_Request);
			}
		}

		return map;
	}

	/**
	 * Returns all the interview_ requests.
	 *
	 * @return the interview_ requests
	 */
	@Override
	public List<Interview_Request> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the interview_ requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of interview_ requests
	 * @param end the upper bound of the range of interview_ requests (not inclusive)
	 * @return the range of interview_ requests
	 */
	@Override
	public List<Interview_Request> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the interview_ requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of interview_ requests
	 * @param end the upper bound of the range of interview_ requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of interview_ requests
	 */
	@Override
	public List<Interview_Request> findAll(int start, int end,
		OrderByComparator<Interview_Request> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the interview_ requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Interview_RequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of interview_ requests
	 * @param end the upper bound of the range of interview_ requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of interview_ requests
	 */
	@Override
	public List<Interview_Request> findAll(int start, int end,
		OrderByComparator<Interview_Request> orderByComparator,
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

		List<Interview_Request> list = null;

		if (retrieveFromCache) {
			list = (List<Interview_Request>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_INTERVIEW_REQUEST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INTERVIEW_REQUEST;

				if (pagination) {
					sql = sql.concat(Interview_RequestModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Interview_Request>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Interview_Request>)QueryUtil.list(q,
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
	 * Removes all the interview_ requests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Interview_Request interview_Request : findAll()) {
			remove(interview_Request);
		}
	}

	/**
	 * Returns the number of interview_ requests.
	 *
	 * @return the number of interview_ requests
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_INTERVIEW_REQUEST);

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
		return Interview_RequestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the interview_ request persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(Interview_RequestImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_INTERVIEW_REQUEST = "SELECT interview_Request FROM Interview_Request interview_Request";
	private static final String _SQL_SELECT_INTERVIEW_REQUEST_WHERE = "SELECT interview_Request FROM Interview_Request interview_Request WHERE ";
	private static final String _SQL_COUNT_INTERVIEW_REQUEST = "SELECT COUNT(interview_Request) FROM Interview_Request interview_Request";
	private static final String _SQL_COUNT_INTERVIEW_REQUEST_WHERE = "SELECT COUNT(interview_Request) FROM Interview_Request interview_Request WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "interview_Request.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Interview_Request exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Interview_Request exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(Interview_RequestPersistenceImpl.class);
}