package com.zl.service;

import java.util.List;

import com.zl.pojo.business.Aging;
import com.zl.pojo.business.AgingMonth;
import com.zl.pojo.business.AgingRate;
import com.zl.pojo.business.CreditCard;
import com.zl.pojo.client.Client;

/**
 * 前台分期模块
 * @author aaron
 */
public interface AgingClientService {
/**
 * 提交分期申请 添加分期概括表 	
 * @param aging
 * @return
 */
 public int addAging(Aging aging); 
/**
 *  根据信用卡查询分期概括 
 * @param client
 * @return
 */
 public List<Aging> queryAgingByClient(int client);
/**
 *  根据分期概况表查询详情表	
 * @param Aging
 * @return
 */
 public List<AgingMonth> queryAgingMonthByAging(int Aging);
/**
 * 根据客户id查询客户信用比对是否有分期资格	
 * @param clientId
 * @return
 */
public Client queryCreditPointByClientId(int clientId);
/**
 *  生成分期详情表	
 * @param agingMonth
 * @return
 */
 public int addAgingMonth(AgingMonth agingMonth);
 public AgingRate queryAgingRate(int id);
 public List<Client> queryClient();
 public List<CreditCard> queryCreditCard();

}
