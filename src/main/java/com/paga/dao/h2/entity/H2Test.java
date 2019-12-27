package com.paga.dao.h2.entity;

import javax.persistence.*;

/**
 * 用户表
 */

@Entity
@Table(name = "H2_TEST")
public class H2Test {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqGenerator")
	@SequenceGenerator(name = "SeqGenerator", sequenceName = " SEQ_TEST_ID")
	@Column(name = "ID",nullable = false)
	private int id;
	@Column(name = "USER_CODE")
	private String userCode;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Test [id=" + id + ", userCode=" + userCode + "]";
	}

}
