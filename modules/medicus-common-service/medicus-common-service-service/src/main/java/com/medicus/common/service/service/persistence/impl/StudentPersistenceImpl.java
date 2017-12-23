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
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.medicus.common.service.exception.NoSuchStudentException;
import com.medicus.common.service.model.Student;
import com.medicus.common.service.model.impl.StudentImpl;
import com.medicus.common.service.model.impl.StudentModelImpl;
import com.medicus.common.service.service.persistence.StudentPersistence;

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
 * The persistence implementation for the student service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sandip.patel
 * @see StudentPersistence
 * @see com.medicus.common.service.service.persistence.StudentUtil
 * @generated
 */
@ProviderType
public class StudentPersistenceImpl extends BasePersistenceImpl<Student>
	implements StudentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StudentUtil} to access the student persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StudentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			StudentModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the students where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching students
	 */
	@Override
	public List<Student> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the students where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @return the range of matching students
	 */
	@Override
	public List<Student> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the students where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching students
	 */
	@Override
	public List<Student> findByUuid(String uuid, int start, int end,
		OrderByComparator<Student> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the students where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching students
	 */
	@Override
	public List<Student> findByUuid(String uuid, int start, int end,
		OrderByComparator<Student> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Student> list = null;

		if (retrieveFromCache) {
			list = (List<Student>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Student student : list) {
					if (!Objects.equals(uuid, student.getUuid())) {
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

			query.append(_SQL_SELECT_STUDENT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StudentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first student in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student
	 * @throws NoSuchStudentException if a matching student could not be found
	 */
	@Override
	public Student findByUuid_First(String uuid,
		OrderByComparator<Student> orderByComparator)
		throws NoSuchStudentException {
		Student student = fetchByUuid_First(uuid, orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
	}

	/**
	 * Returns the first student in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student, or <code>null</code> if a matching student could not be found
	 */
	@Override
	public Student fetchByUuid_First(String uuid,
		OrderByComparator<Student> orderByComparator) {
		List<Student> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last student in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student
	 * @throws NoSuchStudentException if a matching student could not be found
	 */
	@Override
	public Student findByUuid_Last(String uuid,
		OrderByComparator<Student> orderByComparator)
		throws NoSuchStudentException {
		Student student = fetchByUuid_Last(uuid, orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
	}

	/**
	 * Returns the last student in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student, or <code>null</code> if a matching student could not be found
	 */
	@Override
	public Student fetchByUuid_Last(String uuid,
		OrderByComparator<Student> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Student> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the students before and after the current student in the ordered set where uuid = &#63;.
	 *
	 * @param studentId the primary key of the current student
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student
	 * @throws NoSuchStudentException if a student with the primary key could not be found
	 */
	@Override
	public Student[] findByUuid_PrevAndNext(long studentId, String uuid,
		OrderByComparator<Student> orderByComparator)
		throws NoSuchStudentException {
		Student student = findByPrimaryKey(studentId);

		Session session = null;

		try {
			session = openSession();

			Student[] array = new StudentImpl[3];

			array[0] = getByUuid_PrevAndNext(session, student, uuid,
					orderByComparator, true);

			array[1] = student;

			array[2] = getByUuid_PrevAndNext(session, student, uuid,
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

	protected Student getByUuid_PrevAndNext(Session session, Student student,
		String uuid, OrderByComparator<Student> orderByComparator,
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

		query.append(_SQL_SELECT_STUDENT_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

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
			query.append(StudentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(student);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Student> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the students where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Student student : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(student);
		}
	}

	/**
	 * Returns the number of students where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching students
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDENT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "student.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "student.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(student.uuid IS NULL OR student.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			StudentModelImpl.UUID_COLUMN_BITMASK |
			StudentModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the students where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching students
	 */
	@Override
	public List<Student> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the students where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @return the range of matching students
	 */
	@Override
	public List<Student> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the students where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching students
	 */
	@Override
	public List<Student> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Student> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the students where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching students
	 */
	@Override
	public List<Student> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Student> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Student> list = null;

		if (retrieveFromCache) {
			list = (List<Student>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Student student : list) {
					if (!Objects.equals(uuid, student.getUuid()) ||
							(companyId != student.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_STUDENT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StudentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first student in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student
	 * @throws NoSuchStudentException if a matching student could not be found
	 */
	@Override
	public Student findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Student> orderByComparator)
		throws NoSuchStudentException {
		Student student = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
	}

	/**
	 * Returns the first student in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student, or <code>null</code> if a matching student could not be found
	 */
	@Override
	public Student fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Student> orderByComparator) {
		List<Student> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last student in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student
	 * @throws NoSuchStudentException if a matching student could not be found
	 */
	@Override
	public Student findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Student> orderByComparator)
		throws NoSuchStudentException {
		Student student = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
	}

	/**
	 * Returns the last student in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student, or <code>null</code> if a matching student could not be found
	 */
	@Override
	public Student fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Student> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Student> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the students before and after the current student in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param studentId the primary key of the current student
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student
	 * @throws NoSuchStudentException if a student with the primary key could not be found
	 */
	@Override
	public Student[] findByUuid_C_PrevAndNext(long studentId, String uuid,
		long companyId, OrderByComparator<Student> orderByComparator)
		throws NoSuchStudentException {
		Student student = findByPrimaryKey(studentId);

		Session session = null;

		try {
			session = openSession();

			Student[] array = new StudentImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, student, uuid,
					companyId, orderByComparator, true);

			array[1] = student;

			array[2] = getByUuid_C_PrevAndNext(session, student, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Student getByUuid_C_PrevAndNext(Session session, Student student,
		String uuid, long companyId,
		OrderByComparator<Student> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_STUDENT_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			query.append(StudentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(student);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Student> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the students where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Student student : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(student);
		}
	}

	/**
	 * Returns the number of students where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching students
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STUDENT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "student.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "student.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(student.uuid IS NULL OR student.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "student.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_STUDENTCAMPUSID = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBystudentCampusId",
			new String[] { String.class.getName() },
			StudentModelImpl.STUNDETCAMPUSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STUDENTCAMPUSID = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBystudentCampusId", new String[] { String.class.getName() });

	/**
	 * Returns the student where stundetCampusId = &#63; or throws a {@link NoSuchStudentException} if it could not be found.
	 *
	 * @param stundetCampusId the stundet campus ID
	 * @return the matching student
	 * @throws NoSuchStudentException if a matching student could not be found
	 */
	@Override
	public Student findBystudentCampusId(String stundetCampusId)
		throws NoSuchStudentException {
		Student student = fetchBystudentCampusId(stundetCampusId);

		if (student == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("stundetCampusId=");
			msg.append(stundetCampusId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchStudentException(msg.toString());
		}

		return student;
	}

	/**
	 * Returns the student where stundetCampusId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param stundetCampusId the stundet campus ID
	 * @return the matching student, or <code>null</code> if a matching student could not be found
	 */
	@Override
	public Student fetchBystudentCampusId(String stundetCampusId) {
		return fetchBystudentCampusId(stundetCampusId, true);
	}

	/**
	 * Returns the student where stundetCampusId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param stundetCampusId the stundet campus ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching student, or <code>null</code> if a matching student could not be found
	 */
	@Override
	public Student fetchBystudentCampusId(String stundetCampusId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { stundetCampusId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_STUDENTCAMPUSID,
					finderArgs, this);
		}

		if (result instanceof Student) {
			Student student = (Student)result;

			if (!Objects.equals(stundetCampusId, student.getStundetCampusId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_STUDENT_WHERE);

			boolean bindStundetCampusId = false;

			if (stundetCampusId == null) {
				query.append(_FINDER_COLUMN_STUDENTCAMPUSID_STUNDETCAMPUSID_1);
			}
			else if (stundetCampusId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STUDENTCAMPUSID_STUNDETCAMPUSID_3);
			}
			else {
				bindStundetCampusId = true;

				query.append(_FINDER_COLUMN_STUDENTCAMPUSID_STUNDETCAMPUSID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStundetCampusId) {
					qPos.add(stundetCampusId);
				}

				List<Student> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_STUDENTCAMPUSID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"StudentPersistenceImpl.fetchBystudentCampusId(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Student student = list.get(0);

					result = student;

					cacheResult(student);

					if ((student.getStundetCampusId() == null) ||
							!student.getStundetCampusId().equals(stundetCampusId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_STUDENTCAMPUSID,
							finderArgs, student);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_STUDENTCAMPUSID,
					finderArgs);

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
			return (Student)result;
		}
	}

	/**
	 * Removes the student where stundetCampusId = &#63; from the database.
	 *
	 * @param stundetCampusId the stundet campus ID
	 * @return the student that was removed
	 */
	@Override
	public Student removeBystudentCampusId(String stundetCampusId)
		throws NoSuchStudentException {
		Student student = findBystudentCampusId(stundetCampusId);

		return remove(student);
	}

	/**
	 * Returns the number of students where stundetCampusId = &#63;.
	 *
	 * @param stundetCampusId the stundet campus ID
	 * @return the number of matching students
	 */
	@Override
	public int countBystudentCampusId(String stundetCampusId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STUDENTCAMPUSID;

		Object[] finderArgs = new Object[] { stundetCampusId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDENT_WHERE);

			boolean bindStundetCampusId = false;

			if (stundetCampusId == null) {
				query.append(_FINDER_COLUMN_STUDENTCAMPUSID_STUNDETCAMPUSID_1);
			}
			else if (stundetCampusId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STUDENTCAMPUSID_STUNDETCAMPUSID_3);
			}
			else {
				bindStundetCampusId = true;

				query.append(_FINDER_COLUMN_STUDENTCAMPUSID_STUNDETCAMPUSID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStundetCampusId) {
					qPos.add(stundetCampusId);
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

	private static final String _FINDER_COLUMN_STUDENTCAMPUSID_STUNDETCAMPUSID_1 =
		"student.stundetCampusId IS NULL";
	private static final String _FINDER_COLUMN_STUDENTCAMPUSID_STUNDETCAMPUSID_2 =
		"student.stundetCampusId = ?";
	private static final String _FINDER_COLUMN_STUDENTCAMPUSID_STUNDETCAMPUSID_3 =
		"(student.stundetCampusId IS NULL OR student.stundetCampusId = '')";

	public StudentPersistenceImpl() {
		setModelClass(Student.class);
	}

	/**
	 * Caches the student in the entity cache if it is enabled.
	 *
	 * @param student the student
	 */
	@Override
	public void cacheResult(Student student) {
		entityCache.putResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentImpl.class, student.getPrimaryKey(), student);

		finderCache.putResult(FINDER_PATH_FETCH_BY_STUDENTCAMPUSID,
			new Object[] { student.getStundetCampusId() }, student);

		student.resetOriginalValues();
	}

	/**
	 * Caches the students in the entity cache if it is enabled.
	 *
	 * @param students the students
	 */
	@Override
	public void cacheResult(List<Student> students) {
		for (Student student : students) {
			if (entityCache.getResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
						StudentImpl.class, student.getPrimaryKey()) == null) {
				cacheResult(student);
			}
			else {
				student.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all students.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StudentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the student.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Student student) {
		entityCache.removeResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentImpl.class, student.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((StudentModelImpl)student);
	}

	@Override
	public void clearCache(List<Student> students) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Student student : students) {
			entityCache.removeResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
				StudentImpl.class, student.getPrimaryKey());

			clearUniqueFindersCache((StudentModelImpl)student);
		}
	}

	protected void cacheUniqueFindersCache(StudentModelImpl studentModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] { studentModelImpl.getStundetCampusId() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_STUDENTCAMPUSID, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_STUDENTCAMPUSID, args,
				studentModelImpl);
		}
		else {
			if ((studentModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_STUDENTCAMPUSID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						studentModelImpl.getStundetCampusId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_STUDENTCAMPUSID,
					args, Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_STUDENTCAMPUSID,
					args, studentModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(StudentModelImpl studentModelImpl) {
		Object[] args = new Object[] { studentModelImpl.getStundetCampusId() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_STUDENTCAMPUSID, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_STUDENTCAMPUSID, args);

		if ((studentModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_STUDENTCAMPUSID.getColumnBitmask()) != 0) {
			args = new Object[] { studentModelImpl.getOriginalStundetCampusId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_STUDENTCAMPUSID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_STUDENTCAMPUSID, args);
		}
	}

	/**
	 * Creates a new student with the primary key. Does not add the student to the database.
	 *
	 * @param studentId the primary key for the new student
	 * @return the new student
	 */
	@Override
	public Student create(long studentId) {
		Student student = new StudentImpl();

		student.setNew(true);
		student.setPrimaryKey(studentId);

		String uuid = PortalUUIDUtil.generate();

		student.setUuid(uuid);

		student.setCompanyId(companyProvider.getCompanyId());

		return student;
	}

	/**
	 * Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studentId the primary key of the student
	 * @return the student that was removed
	 * @throws NoSuchStudentException if a student with the primary key could not be found
	 */
	@Override
	public Student remove(long studentId) throws NoSuchStudentException {
		return remove((Serializable)studentId);
	}

	/**
	 * Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the student
	 * @return the student that was removed
	 * @throws NoSuchStudentException if a student with the primary key could not be found
	 */
	@Override
	public Student remove(Serializable primaryKey)
		throws NoSuchStudentException {
		Session session = null;

		try {
			session = openSession();

			Student student = (Student)session.get(StudentImpl.class, primaryKey);

			if (student == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStudentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(student);
		}
		catch (NoSuchStudentException nsee) {
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
	protected Student removeImpl(Student student) {
		student = toUnwrappedModel(student);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(student)) {
				student = (Student)session.get(StudentImpl.class,
						student.getPrimaryKeyObj());
			}

			if (student != null) {
				session.delete(student);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (student != null) {
			clearCache(student);
		}

		return student;
	}

	@Override
	public Student updateImpl(Student student) {
		student = toUnwrappedModel(student);

		boolean isNew = student.isNew();

		StudentModelImpl studentModelImpl = (StudentModelImpl)student;

		if (Validator.isNull(student.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			student.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (student.getCreateDate() == null)) {
			if (serviceContext == null) {
				student.setCreateDate(now);
			}
			else {
				student.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!studentModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				student.setModifiedDate(now);
			}
			else {
				student.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (student.isNew()) {
				session.save(student);

				student.setNew(false);
			}
			else {
				student = (Student)session.merge(student);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StudentModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((studentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { studentModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { studentModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((studentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						studentModelImpl.getOriginalUuid(),
						studentModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						studentModelImpl.getUuid(),
						studentModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}
		}

		entityCache.putResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentImpl.class, student.getPrimaryKey(), student, false);

		clearUniqueFindersCache(studentModelImpl);
		cacheUniqueFindersCache(studentModelImpl, isNew);

		student.resetOriginalValues();

		return student;
	}

	protected Student toUnwrappedModel(Student student) {
		if (student instanceof StudentImpl) {
			return student;
		}

		StudentImpl studentImpl = new StudentImpl();

		studentImpl.setNew(student.isNew());
		studentImpl.setPrimaryKey(student.getPrimaryKey());

		studentImpl.setUuid(student.getUuid());
		studentImpl.setStudentId(student.getStudentId());
		studentImpl.setCompanyId(student.getCompanyId());
		studentImpl.setStundetCampusId(student.getStundetCampusId());
		studentImpl.setCampusId(student.getCampusId());
		studentImpl.setSchoolId(student.getSchoolId());
		studentImpl.setFirstName(student.getFirstName());
		studentImpl.setMiddleName(student.getMiddleName());
		studentImpl.setLastName(student.getLastName());
		studentImpl.setProfileImageId(student.getProfileImageId());
		studentImpl.setDateOfBirth(student.getDateOfBirth());
		studentImpl.setGender(student.getGender());
		studentImpl.setContactNumber(student.getContactNumber());
		studentImpl.setHomePhoneNumber(student.getHomePhoneNumber());
		studentImpl.setEmailAddress(student.getEmailAddress());
		studentImpl.setPrimaryLanguage(student.getPrimaryLanguage());
		studentImpl.setSecondaryLanguage(student.getSecondaryLanguage());
		studentImpl.setAddress(student.getAddress());
		studentImpl.setCity(student.getCity());
		studentImpl.setZipcode(student.getZipcode());
		studentImpl.setState(student.getState());
		studentImpl.setPace(student.getPace());
		studentImpl.setEthnicityDesc(student.getEthnicityDesc());
		studentImpl.setGpa(student.getGpa());
		studentImpl.setResumeFileEntryId(student.getResumeFileEntryId());
		studentImpl.setProfession(student.getProfession());
		studentImpl.setPractices(student.getPractices());
		studentImpl.setHired(student.isHired());
		studentImpl.setGraduationDate(student.getGraduationDate());
		studentImpl.setActivelySeekingEmployment(student.isActivelySeekingEmployment());
		studentImpl.setHaveExternship(student.isHaveExternship());
		studentImpl.setStatus(student.getStatus());
		studentImpl.setCreateDate(student.getCreateDate());
		studentImpl.setCreatedBy(student.getCreatedBy());
		studentImpl.setModifiedDate(student.getModifiedDate());
		studentImpl.setModifiedBy(student.getModifiedBy());

		return studentImpl;
	}

	/**
	 * Returns the student with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the student
	 * @return the student
	 * @throws NoSuchStudentException if a student with the primary key could not be found
	 */
	@Override
	public Student findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStudentException {
		Student student = fetchByPrimaryKey(primaryKey);

		if (student == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStudentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return student;
	}

	/**
	 * Returns the student with the primary key or throws a {@link NoSuchStudentException} if it could not be found.
	 *
	 * @param studentId the primary key of the student
	 * @return the student
	 * @throws NoSuchStudentException if a student with the primary key could not be found
	 */
	@Override
	public Student findByPrimaryKey(long studentId)
		throws NoSuchStudentException {
		return findByPrimaryKey((Serializable)studentId);
	}

	/**
	 * Returns the student with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the student
	 * @return the student, or <code>null</code> if a student with the primary key could not be found
	 */
	@Override
	public Student fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
				StudentImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Student student = (Student)serializable;

		if (student == null) {
			Session session = null;

			try {
				session = openSession();

				student = (Student)session.get(StudentImpl.class, primaryKey);

				if (student != null) {
					cacheResult(student);
				}
				else {
					entityCache.putResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
						StudentImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
					StudentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return student;
	}

	/**
	 * Returns the student with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param studentId the primary key of the student
	 * @return the student, or <code>null</code> if a student with the primary key could not be found
	 */
	@Override
	public Student fetchByPrimaryKey(long studentId) {
		return fetchByPrimaryKey((Serializable)studentId);
	}

	@Override
	public Map<Serializable, Student> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Student> map = new HashMap<Serializable, Student>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Student student = fetchByPrimaryKey(primaryKey);

			if (student != null) {
				map.put(primaryKey, student);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
					StudentImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Student)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_STUDENT_WHERE_PKS_IN);

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

			for (Student student : (List<Student>)q.list()) {
				map.put(student.getPrimaryKeyObj(), student);

				cacheResult(student);

				uncachedPrimaryKeys.remove(student.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
					StudentImpl.class, primaryKey, nullModel);
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
	 * Returns all the students.
	 *
	 * @return the students
	 */
	@Override
	public List<Student> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the students.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @return the range of students
	 */
	@Override
	public List<Student> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the students.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of students
	 */
	@Override
	public List<Student> findAll(int start, int end,
		OrderByComparator<Student> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the students.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of students
	 */
	@Override
	public List<Student> findAll(int start, int end,
		OrderByComparator<Student> orderByComparator, boolean retrieveFromCache) {
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

		List<Student> list = null;

		if (retrieveFromCache) {
			list = (List<Student>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_STUDENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STUDENT;

				if (pagination) {
					sql = sql.concat(StudentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the students from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Student student : findAll()) {
			remove(student);
		}
	}

	/**
	 * Returns the number of students.
	 *
	 * @return the number of students
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STUDENT);

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
		return StudentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the student persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(StudentImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_STUDENT = "SELECT student FROM Student student";
	private static final String _SQL_SELECT_STUDENT_WHERE_PKS_IN = "SELECT student FROM Student student WHERE studentId IN (";
	private static final String _SQL_SELECT_STUDENT_WHERE = "SELECT student FROM Student student WHERE ";
	private static final String _SQL_COUNT_STUDENT = "SELECT COUNT(student) FROM Student student";
	private static final String _SQL_COUNT_STUDENT_WHERE = "SELECT COUNT(student) FROM Student student WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "student.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Student exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Student exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(StudentPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "state"
			});
}