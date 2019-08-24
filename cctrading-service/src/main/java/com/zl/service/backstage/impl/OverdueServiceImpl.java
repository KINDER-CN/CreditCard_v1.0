package com.zl.service.backstage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.backstage.OverdueDao;
import com.zl.pojo.Query;
import com.zl.pojo.business.Overdue;
import com.zl.service.backstage.OverdueService;

@Service

public class OverdueServiceImpl implements OverdueService{
	@Autowired
	private OverdueDao od;
	
	@Override
	public List<Overdue> queryAllOverdue() {
		return od.queryAllOverdue();
	}

	@Override
	public Overdue queryOverdueById(int id) {
		return od.queryOverdueById(id);
	}

	@Override
	public int updateOverdue(Overdue overdue) {
		return od.updateOverdue(overdue);
	}

	@Override
	public int addOverdue(Overdue overdue) {
		return od.addOverdue(overdue);
	}

	@Override
	public Overdue queryOverdueByLike(Query query) {
		return od.queryOverdueByLike(query);
	}

}
