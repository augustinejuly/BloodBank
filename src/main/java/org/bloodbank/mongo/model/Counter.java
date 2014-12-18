package org.bloodbank.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="counters")
public class Counter {
	
	@Id
	private final String name;
	
	private Long seq;

	public Counter(String name, Long seq) {
		this.name = name;
		this.seq = seq;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

}
