package com.mgr.learn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mgr.learn.dao.IGeneralDao;
import com.mgr.learn.domain.dbtype.DataSourceType;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MapReduceOutput;
import com.mongodb.WriteResult;
/**
 * 通用mongo操作接口实现类
 * @author zhouchangwei
 *
 * @param <T>
 */
@Repository
public class GeneralDaoImpl<T> implements IGeneralDao<T> {

	private static Logger logger = Logger.getLogger(GeneralDaoImpl.class);
	
	@Autowired(required = false)
	protected MongoTemplate mongoTemplateUserMaster;
	@Autowired(required = false)
	protected MongoTemplate mongoTemplateUserSlave;
	/**
	 * 主键查询
	 * @param id
	 * @param entityClass
	 * @param collectionName
	 * @param dataSource
	 * @return
	 */
	public T findById(String id,Class<T> entityClass,String collectionName, DataSourceType dataSource){
		MongoTemplate mongoTemplate = getMongoTemplate(dataSource);
		return mongoTemplate.findById(id, entityClass, collectionName);
	}
	/**
	 * 查询一条记录
	 * @param query
	 * @param entityClass
	 * @param collectionName
	 * @param dataSource
	 * @return
	 */
	public T findOne(Query query,Class<T> entityClass,String collectionName, DataSourceType dataSource){
		MongoTemplate mongoTemplate = getMongoTemplate(dataSource);
		return mongoTemplate.findOne(query, entityClass, collectionName);
	}
	/**
	 * 分页查询
	 * @param page
	 * @param pageSize
	 * @param entityClass
	 * @param collectionName
	 * @param dataSource
	 * @return
	 */
	public List<T> find(int page, int pageSize, Class<T> entityClass,String collectionName, DataSourceType dataSource) {
		MongoTemplate mongoTemplate = getMongoTemplate(dataSource);
		Query query =new Query();
		query.limit(pageSize);
		query.skip((page - 1) * pageSize);
		return mongoTemplate.find(query, entityClass, collectionName);
	}
	/**
	 * 查询对象列表
	 * @param query
	 * @param entityClass
	 * @param collectionName
	 * @param dataSource
	 * @return
	 */
	public List<T> find(Query query, Class<T> entityClass,String collectionName, DataSourceType dataSource) {
		MongoTemplate mongoTemplate = getMongoTemplate(dataSource);
		return mongoTemplate.find(query, entityClass, collectionName);
	}
	/**
	 * 统计记录数
	 * @param query
	 * @param collectionName
	 * @param dataSource
	 * @return
	 */
	public long count(Query query, String collectionName,DataSourceType dataSource) {
		MongoTemplate mongoTemplate = getMongoTemplate(dataSource);
		return mongoTemplate.count(query, collectionName);
	}
	/**
	 * 插入数据
	 * @param query
	 * @param update
	 * @param collectionName
	 * @param dataSource
	 * @return
	 */
	public void insert(T entity,String collectionName, DataSourceType dataSource) {
		MongoTemplate mongoTemplate = getMongoTemplate(dataSource);
		mongoTemplate.insert(entity, collectionName);
	}
	/**
	 * 保存数据
	 * @param query
	 * @param update
	 * @param collectionName
	 * @param dataSource
	 * @return
	 */
	public void save(T entity,String collectionName, DataSourceType dataSource) {
		MongoTemplate mongoTemplate = getMongoTemplate(dataSource);
		mongoTemplate.save(entity, collectionName);
	}
	
	/**
	 * 更新数据
	 * @param query
	 * @param update
	 * @param collectionName
	 * @param dataSource
	 * @return
	 */
	public WriteResult upSert(Query query, Update update,String collectionName, DataSourceType dataSource) {
		MongoTemplate mongoTemplate = getMongoTemplate(dataSource);
		WriteResult wr = mongoTemplate.upsert(query, update, collectionName);
		return wr;
	}
	/**
	 * 删除过期历史数据
	 * @param query
	 * @param collectionName
	 * @param dataSource
	 */
	public WriteResult removeHistoryData(Query query, String collectionName,DataSourceType dataSource) {
		MongoTemplate mongoTemplate = getMongoTemplate(dataSource);
		return mongoTemplate.remove(query, collectionName);
	}
	/**
	 * 删除表
	 * @param collectionName
	 * @param dataSource
	 */
	public void dropCollection(String collectionName, DataSourceType dataSource) {
		MongoTemplate mongoTemplate = getMongoTemplate(dataSource);
		mongoTemplate.dropCollection(collectionName);
	}
	/**
	 * 查询某一列值去重列表
	 * @param query
	 * @param collectionName
	 * @param columnName
	 * @param dataSource
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> distinctColumnValue(DBObject query,String collectionName, String columnName, DataSourceType dataSource) {
		MongoTemplate mongoTemplate = getMongoTemplate(dataSource);
		DBCollection dbc = mongoTemplate.getCollection(collectionName);
		return dbc.distinct(columnName, query);
	}
	/**
	 * 查询某一列的值列表
	 * @param query
	 * @param collectionName
	 * @param columnName
	 * @param dataSource
	 * @return
	 */
	public List<String> findColumnValue(DBObject query, String collectionName,String columnName, DataSourceType dataSource) {
		MongoTemplate mongoTemplate = getMongoTemplate(dataSource);
		List<String> resultList = new ArrayList<String>();
		try {
			DBCollection dbc = mongoTemplate.getCollection(collectionName);
			DBCursor dbCursor = dbc.find(query);
			while (dbCursor.hasNext()) {
				resultList.add(dbCursor.next().get(columnName).toString());
			}
		} catch (Exception e) {
			logger.error("==exception query mongo db error: ", e);
		}
		return resultList;
	}
	/**
	 * mapReduce 去重统计
	 * @param query
	 * @param collectionName
	 * @param columnName
	 * @param mapTable
	 * @param dataSource
	 * @return
	 */
	public long mapReduce(DBObject query ,String collectionName,String columnName,String mapTable, DataSourceType dataSource){
		MongoTemplate mongoTemplate = getMongoTemplate(dataSource);
		DBCollection dbCollection = mongoTemplate.getCollection(collectionName);
		String mapFunction="function(){emit(this."+columnName+",{\"count\":1})}";
		String reduceFunction="function(key, values) {var total=0; for(var i=0; i < values.length; i++) {total+=values[i].count;} return {count:total}}";		
		MapReduceOutput mro=dbCollection.mapReduce(mapFunction, reduceFunction, mapTable, query);
		String countString=mro.getCommandResult().get("counts").toString();
		JSONObject resultObj = JSONObject.fromObject(countString);
		return Long.valueOf(resultObj.get("output").toString());
	}
	/**
	 * group统计总交易金额和总交易笔数
	 * @param criteria
	 * @param collectionName
	 * @param groupColumn
	 * @return
	 */
	public List<DBObject> groupQuota(Criteria criteria,String collectionName,String groupColumn, DataSourceType dataSource) {
		MongoTemplate mongoTemplate = getMongoTemplate(dataSource);
		try {
			Aggregation aggregation = Aggregation.newAggregation(
					Aggregation.match(criteria),
					Aggregation.group(groupColumn).sum("quota").as("totalQuota").count().as("totalCount"),
					Aggregation.project("totalQuota", "totalCount")
			);
			AggregationResults<DBObject> results = mongoTemplate.aggregate(aggregation, collectionName, DBObject.class);
		    List<DBObject> fieldList = results.getMappedResults();
		    return fieldList;
		} catch (Exception e) {
			logger.error("==exception count group total quota and total count :"+e, e);
		}
		return null;			
	}
	/**
	 * 数据源赋值
	 * @param dataSource
	 * @return
	 */
	protected MongoTemplate getMongoTemplate(DataSourceType dataSource) {
		MongoTemplate mongoTemplate;
		switch (dataSource) {
		case USER_MASTER:
			mongoTemplate = this.mongoTemplateUserMaster;
			break;
		case USER_SLAVE:
			mongoTemplate = this.mongoTemplateUserSlave;
			break;
		default:
			return null;
		}
		return mongoTemplate;
	}
}
