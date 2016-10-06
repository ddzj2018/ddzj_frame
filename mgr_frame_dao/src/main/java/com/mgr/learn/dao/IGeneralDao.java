package com.mgr.learn.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mgr.learn.domain.dbtype.DataSourceType;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
/**
 * 通用mongo操作接口
 * @author zhouchangwei
 *
 * @param <T>
 */
public interface IGeneralDao<T> {
	/**
	 * 主键查询
	 * @param id
	 * @param entityClass
	 * @param collectionName
	 * @param dataSource
	 * @return
	 */
	public T findById(String id,Class<T> entityClass,String collectionName, DataSourceType dataSource);
	/**
	 * 查询一条记录
	 * @param query
	 * @param entityClass
	 * @param collectionName
	 * @param dataSource
	 * @return
	 */
	public T findOne(Query query,Class<T> entityClass,String collectionName, DataSourceType dataSource);
	/**
	 * 分页查询
	 * @param page
	 * @param pageSize
	 * @param entityClass
	 * @param collectionName
	 * @param dataSource
	 * @return
	 */
	public List<T> find(int page, int pageSize, Class<T> entityClass,String collectionName, DataSourceType dataSource);
	/**
	 * 查询对象列表
	 * @param query
	 * @param entityClass
	 * @param collectionName
	 * @param dataSource
	 * @return
	 */
	public List<T> find(Query query, Class<T> entityClass,String collectionName, DataSourceType dataSource);
	/**
	 * 统计记录数
	 * @param query
	 * @param collectionName
	 * @param dataSource
	 * @return
	 */
	public long count(Query query, String collectionName,DataSourceType dataSource);
	/**
	 * 插入数据
	 * @param query
	 * @param update
	 * @param collectionName
	 * @param dataSource
	 * @return
	 */
	public void insert(T entity,String collectionName, DataSourceType dataSource);
	/**
	 * 保存数据
	 * @param query
	 * @param update
	 * @param collectionName
	 * @param dataSource
	 * @return
	 */
	public void save(T entity,String collectionName, DataSourceType dataSource);
	/**
	 * 更新数据
	 * @param query
	 * @param update
	 * @param collectionName
	 * @param dataSource
	 * @return
	 */
	public WriteResult upSert(Query query, Update update,String collectionName, DataSourceType dataSource);
	/**
	 * 删除过期历史数据
	 * @param query
	 * @param collectionName
	 * @param dataSource
	 */
	public WriteResult removeHistoryData(Query query, String collectionName,DataSourceType dataSource);
	/**
	 * 删除表
	 * @param collectionName
	 * @param dataSource
	 */
	public void dropCollection(String collectionName, DataSourceType dataSource);
	/**
	 * 查询某一列值去重列表
	 * @param query
	 * @param collectionName
	 * @param columnName
	 * @param dataSource
	 * @return
	 */
	public List<String> distinctColumnValue(DBObject query,String collectionName, String columnName, DataSourceType dataSource);
	/**
	 * 查询某一列的值列表
	 * @param query
	 * @param collectionName
	 * @param columnName
	 * @param dataSource
	 * @return
	 */
	public List<String> findColumnValue(DBObject query, String collectionName,String columnName, DataSourceType dataSource);
	/**
	 * mapReduce 去重统计
	 * @param query
	 * @param collectionName
	 * @param columnName
	 * @param mapTable
	 * @param dataSource
	 * @return
	 */
	public long mapReduce(DBObject query ,String collectionName,String columnName,String mapTable, DataSourceType dataSource);
	/**
	 * group统计总交易金额和总交易笔数
	 * @param criteria
	 * @param collectionName
	 * @param groupColumn
	 * @return
	 */
	public List<DBObject> groupQuota(Criteria criteria,String collectionName,String groupColumn, DataSourceType dataSource);

}
