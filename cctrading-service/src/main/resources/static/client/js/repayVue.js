new Vue({
	el: '#repaycard',
	  data: {
		RepayMoneyAndPwd:{
		money:"",
		pwd:"",
		cardNum:"",
		bankNum:""
     },
		repayCard:{
		  repayCardNum:"",
		  repayName:"",
		  repayIDcard:"",
		  repayPhone:"",
	 },
		cid : '',
		current :-1,
		creditCards: [{
			id : '',
			cardType : '',
			cardNum : '',
			cardState:''
		}],
		bid:"",
		current2:-1,
		repayCards:[],
		result:"",
		resultBank:"",
		resultCard:"",
		result1:"",
	 	result2:"",
	 	result3:"",
	 	result4:"",
	 	result5:"",
	 	result6:"",
	 	resultBank:"",
	 	resultCard:"",
	 	resultbalance:"",
	 	name:'',
 	},	
 	
methods: {
	//展示信用列表
	selectAllCreditCard : function() {
		var _this = this;
	  axios.get("http://10.1.12.66:8086/trading/queryCreditCardByClient")
		.then(function(response) {
		_this.name=response.data.name;
		_this.creditCards=response.data.scs;
		_this.cid = _this.creditCards[0].id
		console.log(response);
	   })
	},
		addClass : function(index) {
		   this.current = index;
	},
		choseId : function(cid) {
		   this.cid = cid;
	},
	//展示还款卡列表
		queryrepayCard: function() {
			var _this = this;
		axios.get("http://10.1.12.66:8086/trading/queryrepayCard")
	     .then(function(response) {
		_this.repayCards=response.data.lbcs;
		_this.bid = _this.repayCards[0].id
			console.log(response);
	    })
    },
		addcc : function(index2) {
	     this.current2 = index2;
	},
		chosecardId : function(bid) {
		  this.bid = bid;
	},
	//添加还款卡
		addcard: function() {
		 var _this=this;
		 var idcard = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
		 var cardid = /^\d{16,19}$/;
	     var phone =/^[1]([3-9])[0-9]{9}$/;
	     var name =/^[\u4e00-\u9fa5]{0,}$/;
		 if(!(idcard.test(_this.repayCard.repayIDcard))){
			 _this.result1=true;
		 }else{
			 _this.result1=false;
		 };
		 if(!(cardid.test(_this.repayCard.repayCardNum))){
			 _this.result2=true;
		 }else{
			 _this.result2=false;
		 };
		 if(!(phone.test(_this.repayCard.repayPhone))){
			 _this.result3=true;
		 }else{
			 _this.result3=false;
		 };
		 if(!(name.test(_this.repayCard.repayName))){
			 _this.result4=true;
		 }else{
			 _this.result4=false;
		 };
		if((idcard.test(_this.repayCard.repayIDcard))&&(cardid.test(_this.repayCard.repayCardNum))&&(phone.test(_this.repayCard.repayPhone))&&(name.test(_this.repayCard.repayName))){
			var con=confirm("请确认信息，是否确认绑定该储蓄卡");
		};
		if(con==true){
			axios.post('http://10.1.12.66:8086/trading/addRepayCard',_this.repayCard)
	    	.then(
	    		window.location.href='repay.html'
	    	)
	    	.catch(function (error) {
	            console.log(error); 
	         })
		};
		
	},
	liji:function() {
		var _this=this;
		if(_this.current<0||_this.current2<0){
			 alert("请选择信用卡片及还款卡片")
			 window.location.href='repay.html'
		 };
	},
	//还款
	repaybtu: function() {
		 var _this=this;
		 _this.RepayMoneyAndPwd.cardNum = this.cid;
		 _this.RepayMoneyAndPwd.bankNum = this.bid;
		 var money1 =/^[0-9]+(.[0-9]{1})?$/;
		 var passwd=/^\d{6}$/;
		 if(!(money1.test(_this.RepayMoneyAndPwd.money))){
			 _this.result5=true;
		 }else{
			 _this.result5=false;
		 };
		 if(!(passwd.test(_this.RepayMoneyAndPwd.pwd))){
			 _this.result6=true;
		 }else{
			 _this.result6=false;
		 };
	 if((money1.test(_this.RepayMoneyAndPwd.money))&&(passwd.test(_this.RepayMoneyAndPwd.pwd))){
		 var pay=confirm("请确认信息，是否确认还款");
	 };
	 if(pay==true){
		 axios.post('http://10.1.12.66:8086/trading/repay',_this.RepayMoneyAndPwd)
	    	.then(function(response){
			_this.result=response.data.result;
			_this.resultBank=response.data.resultBank;
			_this.resultCard=response.data.resultCard;
			_this.resultbalance=response.data.resultbalance;
			
	    	if(_this.result<1){
	    		alert("密码错误！！！");	
	        };
	        if(_this.resultbalance==2){
	        	alert("储蓄卡余额不足！！")
	        };
	        if((_this.resultBank>0)&&(_this.resultCard>0)){
	        	alert("还款成功，请查看账单信息")
	    		window.location.href='bill.html'
	        }else{
	        	alert("还款失败！！")
	        };
	   })
			  .catch(function (error) {
	            console.log(error); 
	       })
	   }
	},
	  
	},
		created:function(){
		    this.selectAllCreditCard();
		    this. queryrepayCard();
		},
	
})
