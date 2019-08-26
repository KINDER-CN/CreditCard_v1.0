package com.zl.dao.gu;

import java.util.List;

import com.zl.pojo.client.ClientBill;
import com.zl.pojo.htfenye.FenYe;
import com.zl.pojo.manger.Manger;
import com.zl.pojo.manger.MangerRole;
/**
 * 管理员管理模块
 */
public interface guanliyuanmokuaiDao {
	/**
	 * 登录模块
	 */
	public Manger login(Manger manger);
	/**
	 * 查询单个管理员
	 */
	public Manger queryMangerById(int id);
	/**
	 * 查询所有管理员
	 */
	public List<MangerRole> queryAllManger();
	/**
	 * 模糊查询所有管理员
	 */
	public List<MangerRole> queryMangerByLike(String mangerName);
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
	/**
	 * 分页
	 */
	public List<MangerRole> fenYeMangerRole(FenYe fenYe);
	/**
	 * 分页总数
	 */
	public int fenYeAllMangerRole(FenYe fenYe);
}
