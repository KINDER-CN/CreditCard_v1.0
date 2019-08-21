package com.zl.service.front.impl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * 客户服务层实现类，用于编写有关客户业务服务的所有接口的业务逻辑代码
 * @author KINDER
 *
 */
import org.springframework.stereotype.Service;

import com.zl.dao.front.ClientDao;
import com.zl.pojo.client.Client;
import com.zl.pojo.client.ShowClientCard;
import com.zl.service.front.ClientService;
import com.zl.util.MD5Util;

@Service
public class ClientServiceImpl implements ClientService{
	@Autowired
	private ClientDao cd;
	/**
	 * 登录服务
	 */
	@Override
	public Client clientLogin(Client client) {
		return cd.clientLogin(client);
	}
	/**
	 * 注册服务
	 */
	@Override
	public int clientRegister(Client client) {
		if(client!=null) {
			client.setPassword(MD5Util.MD5(client.getPassword()));
		}
		return cd.clientRegister(client);
	}
	/**
	 * 修改手机号
	 */
	@Override
	public int updateClientPhone(Client client) {
		return cd.updateClientPhone(client);
	}
	/**
	 * 验证原手机号是否正确
	 */
	@Override
	public Client queryClientPhone(Client client) {
		return cd.queryClientPhone(client);
	}
	
	
	@Override
	public List<ShowClientCard> queryClientCard(int clientId) {
		List<ShowClientCard> list =cd.queryClientCard(clientId);
		for(int i=0;i<list.size();i++) {
			if(cd.queryBillByCardId(list.get(i).getId())!=null) {
				ShowClientCard s=cd.queryBillByCardId(list.get(i).getId());
				list.get(i).setBillMoney(s.getBillMoney());
				list.get(i).setRepayDay(s.getRepayDay());
			}else {
				Date date = new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
				String day=sdf.format(date);
				String day2=day+"-"+15;
				list.get(i).setBillMoney("0.00");
				try {
					list.get(i).setRepayDay(sdf.parse(day2));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(list);
		return list;
	}
	@Override
	public Client queryClientByPsdAndId(Client client) {
		// TODO Auto-generated method stub
		return cd.queryClientByPsdAndId(client);
	}
	@Override
	public int updatePassword(Client client) {
		// TODO Auto-generated method stub
		return cd.updatePassword(client);
	}
	
	
	
}
