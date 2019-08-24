package com.zl.action.gu;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.zl.pojo.business.BillDetails;
import com.zl.pojo.client.Client;
import com.zl.pojo.client.ClientBill;
import com.zl.pojo.client.ClientBillDetails;
import com.zl.pojo.manger.CardType;
import com.zl.pojo.manger.Manger;
import com.zl.pojo.manger.MangerRole;
import com.zl.pojo.manger.OperateLog;
import com.zl.service.gu.caozuorizhiService;
import com.zl.service.gu.guanliyuanmokuaiService;
import com.zl.service.gu.jiaoyilishiService;
import com.zl.service.gu.kazhongguanliService;
import com.zl.service.gu.zhanghuguanlimokuaiService;
import com.zl.util.Base64Util;
@Controller
@RequestMapping("/gu")
public class guController<R> {
   @Autowired
   private caozuorizhiService cs;
   @Autowired
   private guanliyuanmokuaiService gs;
   @Autowired
   private jiaoyilishiService js;
   @Autowired
   private kazhongguanliService ks;
   @Autowired
   private zhanghuguanlimokuaiService zs;
   
   /**
    * 图片上传
    *//*
   @RequestMapping("/upload")
	@ResponseBody
	public Map<String,Object> upload(String name,@RequestParam("imgFile") CommonsMultipartFile imgFile){
		Map<String,Object> map=new HashMap<>();
		if(imgFile.getSize()>0) {
			//获取原始文件名称
			String oldFileName=imgFile.getOriginalFilename();//aaa.jpg
			//创建新文件名称
			String newFileName=UUID.randomUUID().toString()+oldFileName.substring(oldFileName.lastIndexOf("."));
			//创建新文件
			File newFile=new File("D:/apache-tomcat-8.0.50/webapps/img/"+newFileName);
			//如果文件不存在我们手动创建出来
			if(!newFile.exists()) {
				newFile.mkdir();
			}
			//把旧文件中的数据写新文件中
			try {
				imgFile.transferTo(newFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			map.put("flag", true);
			map.put("url", "../img/"+newFileName);
			System.out.println(newFileName+";;;;;;;;;;;;;;;;;;");
		}
		return map;
	}*/
   /**
    * 管理员管理模块
    */
   //登录
   @RequestMapping("/login")
   @ResponseBody
   public Map<String,Object> login(@RequestBody Manger manger){
	   Map<String,Object> result=new HashMap<String,Object>();
	   manger=gs.login(manger);
	   if(manger!=null){
		   result.put("manger", manger);
		   System.out.println("11111111111");
	   }else {
		   result.put("code", 401);
	   }
	return result;
   }
   //查询所有管理员
   @RequestMapping("/queryAllManger")
   @ResponseBody
   public Map<String,Object> queryAllManger(Integer pageNum,Integer pageSize){
	   Map<String,Object> result=new HashMap<String,Object>();
	   List<MangerRole> mangerRoles= gs.queryAllManger();
	   result.put("mangerRoles", mangerRoles);
	   System.out.println(mangerRoles);
	return result;
   }
   //查询单个管理员
   @RequestMapping("/queryMangerById")
   @ResponseBody
   public Map<String,Object> queryMangerById(int id) {
	   Map<String,Object> result=new HashMap<String,Object>();
	   Manger manger=gs.queryMangerById(id);
	   if(manger!=null) {
		   result.put("manger",manger);
	   }else {
		   System.out.println("失败");
	   }
	return result;
   }
   	//修改管理员
   @RequestMapping("/updateMangerById")
   @ResponseBody
   public Map<String,Object> updateMangerById(@RequestBody Manger manger) {
	   Map<String,Object> result=new HashMap<String,Object>();
	   System.out.println("修改管理员");
	   System.out.println(manger);
	   int i=gs.updateMangerById(manger);
	   if(i>0) {
		   System.out.println("修改成功");
	   }else {
		  
	   }
	return result;
   }
   //删除管理员(撤销管理员权限)
   @RequestMapping("/updateManger")
   @ResponseBody
   public Map<String,Object> updateManger(int id) {
	   Map<String,Object> result=new HashMap<String,Object>();
	   int i=gs.updateManger(id);
	   if(i>0) {
		   result.put("message", "删除成功");
	   }else {
		   result.put("message", "删除失败");
	   }
	return result;
	   
   }
   //增加管理员
   @RequestMapping("/insertManger")
   @ResponseBody
   public Map<String,Object> insertManger(@RequestBody Manger manger) {
	   Map<String,Object> result=new HashMap<String,Object>();
	   int i=gs.insertManger(manger);
	   if(i>0) {
		   result.put("manger", i);
		   System.out.println("11111111111");
	   }else {
	   }
	return result;
	   
   }
   /**
    * 账户管理模块
    */
   //查询所有账户
   @RequestMapping("/queryAllClient")
   @ResponseBody
   public Map<String,Object> queryAllClient(){
	   Map<String,Object> result=new HashMap<String,Object>();
	   List<Client> clients=zs.queryAllClient();
	   result.put("clients", clients);
	return result;
   }
   //模糊查询
   @RequestMapping("/queryClientByLike")
   @ResponseBody
   public Map<String,Object> queryClientByLike(String clientName) {
	   System.out.println(1);
	   Map<String,Object> result=new HashMap<String,Object>();
	   List<Client> clients=zs.queryClientByLike(clientName);
	   System.out.println(clients);
	   result.put("clients", clients);
	return result;
	   
   }
   //点击详情
   @RequestMapping("/queryClientById")
   @ResponseBody
   public Map<String,Object> queryClientById(int id) {
	   Map<String,Object> result=new HashMap<String,Object>();
	   Client client=zs.queryClientById(id);
	   result.put("client", client);
	return result;
	   
   }
   /**
    * 交易记录模块
    */
   //查询账单表所有信息
   @RequestMapping("/queryAllBillDetails")
   @ResponseBody
   public Map<String,Object> queryAllBillDetails(){
	   Map<String,Object> result=new HashMap<String,Object>();
	   List<BillDetails> clientBills=js.queryAllBillDetails();
	   result.put("clientBills", clientBills);
	return result;
   }
   //查询该账户的交易信息
   @RequestMapping("/queryBillDetailsById")
   @ResponseBody
   public Map<String,Object> queryBillDetailsById(String clientName) throws UnsupportedEncodingException {
	   Map<String,Object> result=new HashMap<String,Object>();
	   ClientBillDetails clientBillDetails=js.queryBillDetailsById(clientName);
	   result.put("clientBillDetails", clientBillDetails);
	return result;
	   
   }
   //模糊查询账单表
   @RequestMapping("/queryBillDetailsByLike")
   @ResponseBody
   public Map<String,Object> queryBillDetailsByLike(String clientIdcard){
	   System.out.println(clientIdcard);
	   Map<String,Object> result=new HashMap<String,Object>();
	   List<ClientBill> clientBills=js.queryBillDetailsByLike(clientIdcard);
	   System.out.println(clientBills);
	   result.put("clientBills", clientBills);
	return result;
	   
   }
   /**
    * 操作日志模块
    */
   //增加日志
   @RequestMapping("/insertOperateLog")
   @ResponseBody
   public Map<String,Object> insertOperateLog(OperateLog operateLog) {
	   Map<String,Object> result=new HashMap<String,Object>();
	   int i=cs.insertOperateLog(operateLog);
	   if(i>0) {
		   result.put("code","200");
		   result.put("message", "日志添加成功");
		   result.put("operateLog", operateLog);
	   }else {
		   result.put("code","400");
		   result.put("message", "日志添加失败");
	   }
	return result;
	   
   }
   //查询最后五条日志
   @RequestMapping("/queryAllOperateLog")
   @ResponseBody
   public Map<String,Object> queryAllOperateLog(){
	   Map<String,Object> result=new HashMap<String,Object>();
	   List<OperateLog> operateLogs=cs.queryAllOperateLog();
	   result.put("operateLogs", operateLogs);
	return result;
	   
   }
   /**
    * 卡种管理模块
    */
 //查询卡种表所有信息
   @RequestMapping("/queryAllCardType")
   @ResponseBody
   public Map<String,Object> queryAllCardType(){
	   Map<String,Object> result=new HashMap<String,Object>();
	   List<CardType> cardTypes=ks.queryAllCardType();
	   result.put("cardTypes", cardTypes);
	   System.out.println(cardTypes);
	return result;
   }
   //查询单个卡片
   @RequestMapping("/queryCardTypeById")
   @ResponseBody
   public Map<String,Object> queryCardTypeById(int id) {
	   Map<String,Object> result=new HashMap<String,Object>();
	   CardType cardType=ks.queryCardTypeById(id);
	   if(cardType!=null) {
		   result.put("cardType",cardType);
	   }else {
		   System.out.println("失败");
	   }
	return result;
	   
   }
   //修改卡种表
   @RequestMapping("/updateCardType")
   @ResponseBody
   public Map<String,Object> updateCardType(@RequestBody CardType cardType) {
	   cardType.getCardPic();
	   String a=Base64Util.Base64ToImage(cardType.getCardPic());
	   cardType.setCardPic(a);
	   Map<String,Object> result=new HashMap<String,Object>();  
	   int i=ks.updateCardType(cardType);
	return result;
	   
   }
   //增加信用卡种类
   @RequestMapping("/insertCardType")
   @ResponseBody
   public Map<String,Object> insertCardType(@RequestBody CardType cardType) {
	   cardType.getCardPic();
	   String a=Base64Util.Base64ToImage(cardType.getCardPic());
	   cardType.setCardPic(a);
	   System.out.println(cardType);
	   Map<String,Object> result=new HashMap<String,Object>();
	   int i=ks.insertCardType(cardType);
	   System.out.println(i);
	   return result;
   }
   //删除信用卡
   @RequestMapping("/deleteCardTypeById")
   @ResponseBody
   public Map<String,Object> deleteCardTypeById(int id) {
	   Map<String,Object> result=new HashMap<String,Object>();
	   int i=ks.deleteCardTypeById(id);
	   System.out.println(i);
	return result;
	   
   }
}
