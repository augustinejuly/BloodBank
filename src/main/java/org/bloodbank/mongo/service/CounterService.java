package org.bloodbank.mongo.service;

import java.util.concurrent.atomic.AtomicBoolean;

import org.bloodbank.mongo.model.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


@Service
public class CounterService {

	@Autowired 
	private MongoOperations mongoOperation;

	private static AtomicBoolean isCollectionExists = new AtomicBoolean(false);

	public long getNextSequence(String collectionName) {

		if(!isCollectionExists.get()) {
			if(!mongoOperation.collectionExists(Counter.class)) {
				System.out.println("Collection does not exist...!");
				mongoOperation.save(new Counter(collectionName, 0L));
				isCollectionExists.set(true);
			}
		}

		Counter counter = mongoOperation.findAndModify(new Query(Criteria.where("_id").is(collectionName)), 
				new Update().inc("seq", 1),
				new FindAndModifyOptions().returnNew(true),
				Counter.class);
		return counter.getSeq();
	}
}
