package org.bloodbank.mongo.service;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

public class MongoTemplateFactoryBean implements FactoryBean<MongoOperations>,BeanFactoryPostProcessor{
	

	@Override
	public MongoOperations getObject() throws Exception {
		
		JSONObject service = getServiceByName("mongodb-sr");
		JSONObject credentials = service.getJSONObject("credentials");
		String host = credentials.getString("hostname");
		int port = credentials.getInt("port");
		String db = credentials.getString("db");
		String username = credentials.getString("username");
		String password = credentials.getString("password");
		
		MongoClient mongoClient = new MongoClient(host,port);
		MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, db, new UserCredentials(username, password));
		/*MongoClient mongoClient = new MongoClient("localhost",27017);
		MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, "ibm");*/
		mongoTemplate.setWriteConcern(WriteConcern.SAFE);
		return mongoTemplate;
	}

	@Override
	public Class<?> getObjectType() {
		return MongoOperations.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
	
	private static JSONObject getServiceByName(String serviceName) {
		JSONObject service = null;
		JSONObject envServices = new JSONObject(System.getenv("VCAP_SERVICES"));
		Iterator<String> keys = envServices.keys();
		
		while(keys.hasNext()){
			String key = keys.next();
			JSONArray jsonArray = envServices.getJSONArray(key);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject tempService = jsonArray.getJSONObject(i);
				if(serviceName.equals(tempService.get("name"))) {
					service = tempService;
					break;
				}
			}
			if(service != null) {
				break;
			}
		}
		
		return service;
	}

	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
	}

}
