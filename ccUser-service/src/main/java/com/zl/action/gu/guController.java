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
import javax.servlet.http.HttpSession;

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
import com.zl.pojo.htfenye.FenYe;
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
import com.zl.util.MD5Util;
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
    * 管理员管理模块
    */
   //登录
   @RequestMapping("/login")
   @ResponseBody
   public Map<String,Object> login(@RequestBody Manger manger,HttpSession session){
	   Map<String,Object> result=new HashMap<String,Object>();
	   manger.setmPassword(MD5Util.getMD5(manger.getmPassword()));
	   manger=gs.login(manger);
	   if(manger!=null){
		   result.put("manger", manger);
		   System.out.println("11111111111");
		   session.setAttribute("manger", manger);
	   }else {
		   result.put("code", 401);
	   }
	return result;
   }
   //查询所有管理员
   /*@RequestMapping("/queryAllManger")
   @ResponseBody
   public Map<String,Object> queryAllManger(Integer pageNum,Integer pageSize){
	   Map<String,Object> result=new HashMap<String,Object>();
	   List<MangerRole> mangerRoles= gs.queryAllManger();
	   result.put("mangerRoles", mangerRoles);
	   System.out.println(mangerRoles);
	return result;
   }*/
 //查询所有管理员
   @RequestMapping("/queryAllMangerByLike")
   @ResponseBody
   public Map<String,Object> queryAllManger(@RequestBody FenYe fenYe){
	   Map<String,Object> result=new HashMap<String,Object>();
	   List<MangerRole> mangerRoles= gs.fenYeMangerRole(fenYe);
	   System.out.println(mangerRoles);
	   int i =gs.fenYeAllMangerRole(fenYe);
	   if(i%fenYe.getRows()>0) {
		   i=(i/fenYe.getRows())+1;
	   }else {
		   i=i/fenYe.getRows();
	   }
	   result.put("mangerRoles", mangerRoles);
	   result.put("i",i);
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
   public Map<String,Object> queryClientByLike(@RequestBody FenYe fenYe) {
	   System.out.println(1);
	   System.out.println(fenYe);
	   Map<String,Object> result=new HashMap<String,Object>();
	   List<Client> clients=zs.fenYeClient(fenYe);
	   int i =zs.fenYeAllClient(fenYe);
	   if(i%fenYe.getRows()>0) {
		   i=(i/fenYe.getRows())+1;
	   }else {
		   i=i/fenYe.getRows();
	   }
	   System.out.println(clients);
	   result.put("clients", clients);
	   result.put("i",i);
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
   public Map<String,Object> queryBillDetailsByLike(@RequestBody FenYe fenYe){
	   Map<String,Object> result=new HashMap<String,Object>();
	   List<ClientBill> clientBills=js.fenYeClientBill(fenYe);
	   int i=js.fenYeAllClientBill(fenYe);
	   if(i%fenYe.getRows()>0) {
		   i=(i/fenYe.getRows())+1;
	   }else {
		   i=i/fenYe.getRows();
	   }
	   System.out.println(clientBills);
	   result.put("clientBills", clientBills);
	   result.put("i", i);
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
   public Map<String,Object> queryAllOperateLog(HttpSession session){
	   Map<String,Object> result=new HashMap<String,Object>();
	   Manger manger=new Manger();
	   manger=(Manger) session.getAttribute("manger");
	   List<OperateLog> operateLogs=cs.queryAllOperateLog();
	   result.put("operateLogs", operateLogs);
	   result.put("name", manger.getMangerName());
	return result;
	   
   }
   /**
    * 卡种管理模块
    */
 //查询卡种表所有信息
   @RequestMapping("/queryAllCardTypeByLike")
   @ResponseBody
   public Map<String,Object> queryAllCardType(@RequestBody FenYe fenYe){
	   System.out.println(fenYe);
	   Map<String,Object> result=new HashMap<String,Object>();
	   List<CardType> cardTypes=ks.fenYeCardType(fenYe);
	   int i=ks.fenYeAllCardType(fenYe);
	   if(i%fenYe.getRows()>0) {
		   i=(i/fenYe.getRows())+1;
	   }else {
		   i=i/fenYe.getRows();
	   }
	   System.out.println(cardTypes);
	   result.put("cardTypes", cardTypes);
	   result.put("i", i);
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
