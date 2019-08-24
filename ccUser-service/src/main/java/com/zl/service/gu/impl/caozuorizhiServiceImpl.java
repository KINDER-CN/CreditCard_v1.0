package com.zl.service.gu.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.gu.caozuorizhiDao;
import com.zl.pojo.manger.OperateLog;
import com.zl.service.gu.caozuorizhiService;
@Service
public class caozuorizhiServiceImpl implements caozuorizhiService {
	@Autowired
	public caozuorizhiDao cd;
	@Override
	public int insertOperateLog(OperateLog operateLog) {
		int i=cd.insertOperateLog(operateLog);
		return i;
	}

	@Override
	public List<OperateLog> queryAllOperateLog() {
		return cd.queryAllOperateLog();
	}

}
