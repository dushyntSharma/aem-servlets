package com.aem.mind.core.dao;

import java.util.List;

import com.aem.mind.core.models.JDBCData;

public interface ServletDao {

	void registerData(List<JDBCData> mb);

}
