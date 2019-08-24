package com.zl.service.gu.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.gu.guanliyuanmokuaiDao;
import com.zl.pojo.manger.Manger;
import com.zl.pojo.manger.MangerRole;
import com.zl.service.gu.guanliyuanmokuaiService;
@Service
public class guanliyuanmokuaiServiceImpl implements guanliyuanmokuaiService {
	@Autowired
	public guanliyuanmokuaiDao gd;
	@Override
	public List<MangerRole> queryAllManger() {
		return gd.queryAllManger();
	}

	@Override
	public int updateMangerById(Manger manger) {
		int i=gd.updateMangerById(manger);
		return i;
	}

	@Override
	public int updateManger(int id) {
		int i=gd.updateManger(id);
		return i;
	}

	@Override
	public int insertManger(Manger manger) {
		int i=gd.insertManger(manger);
		return i;
	}
	@Override
	public Manger login(Manger manger) {
		return gd.login(manger);
	}
	@Override
	public Manger queryMangerById(int id) {
		return gd.queryMangerById(id);
	}


}
