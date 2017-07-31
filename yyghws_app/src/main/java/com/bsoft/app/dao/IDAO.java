package com.bsoft.app.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.bsoft.app.model.YyOrder;
import com.bsoft.app.model.YyWorkPb;

public interface IDAO {

	public int queryForCount(String classifying, String where,
			Map<String, Object> params) throws DataAccessException;

	public int queryForCount(String classifying, String where, Object[] params)
			throws DataAccessException;

	public Map<String, Object> queryForMap(String classifying, String where,
			Map<String, Object> params) throws DataAccessException;

	public Map<String, Object> queryForMap(String classifying, String where,
			Object[] params) throws DataAccessException;

	public Map<String, Object> queryForMap(final String hql,
			final Map<String, Object> params) throws DataAccessException;

	public Map<String, Object> queryForMap(final String hql,
			final Object[] params) throws DataAccessException;

	public List<Map<String, Object>> queryForList(String classifying,
			String where, Map<String, Object> params)
			throws DataAccessException;

	public List<Map<String, Object>> queryForList(String classifying,
			String where, Object[] params) throws DataAccessException;

	public List<Map<String, Object>> queryForList(final String hql,
			final Map<String, Object> params) throws DataAccessException;

	public List<Map<String, Object>> queryForList(final String hql,
			final Object[] params) throws DataAccessException;

	public List<Map<String, Object>> queryForPage(String classifying,
			String where, int start, int limit, Map<String, Object> params)
			throws DataAccessException;

	public List<Map<String, Object>> queryForPage(String classifying,
			String where, int start, int limit, Object[] params)
			throws DataAccessException;

	public List<Map<String, Object>> queryForPage(String hql, int start,
			int limit, Map<String, Object> params) throws DataAccessException;

	public List<Map<String, Object>> queryForPage(String hql, int start,
			int limit, Object[] params) throws DataAccessException;

	public void update(String classifying, Map<String, Object> record)
			throws DataAccessException;

	public int update(String classifying, String clause, String where,
			Object[] params) throws DataAccessException;

	public int delete(String classifying, String fieldName, String value)
			throws DataAccessException;

	public int delete(String classifying, String where, Object[] params)
			throws DataAccessException;

	public void save(String classifying, Map<String, Object> data)
			throws DataAccessException;
	
	public <T> void save(String classifying, T data)
			throws DataAccessException;
	
	public <T> List<T> queryList(String classifying,
			String where, Object[] params) throws DataAccessException;
	
	public <T> T queryT(String classifying, String where,
			Object[] params) throws DataAccessException;
	
	public List<Map<String, Object>> queryForListSQL(String classifying,
			Object[] params) throws DataAccessException;
	
	public <T> void update(T record)
			throws DataAccessException;
	
	public <T> void save(T data)
			throws DataAccessException;
	
	public <T> void delete(T record) throws DataAccessException;
	
	public <T> T get(Class classifying, T record) throws DataAccessException;
	
	public <T> T getById(Class classifying, Serializable id) throws DataAccessException;
	
	public <T> List<T> queryListSql(String sql,
			String where, Object[] params) throws DataAccessException;
	
	public void addOrder(YyWorkPb pb, YyOrder yyOrder) throws DataAccessException;
	
	public void cancelOrder(YyWorkPb pb, YyOrder yyOrder) throws DataAccessException;
	
	public <T> List<T> queryListIn(String hql, String name, List<String> params) throws DataAccessException;
}
