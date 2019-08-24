package com.zl.service.gu;

import java.util.List;

import com.zl.pojo.manger.Manger;
import com.zl.pojo.manger.MangerRole;
/**
 * 管理员管理模块
 */
public interface guanliyuanmokuaiService {
	/**
	 * 登录模块
	 */
	public Manger login(Manger manger);
	/**
	 * 查询所有管理员
	 */
	public List<MangerRole> queryAllManger();
	/**
	 * 查询单个管理员
	 */
	public Manger queryMangerById(int id);
	/**
	 * 修改管理员
	 */
	public int updateMangerById(Manger manger);
	/**
	 * 删除管理员
	 */
	public int updateManger(int id);
	/**
	 * 增加管理员
	 */
	public int insertManger(Manger manger);
}
