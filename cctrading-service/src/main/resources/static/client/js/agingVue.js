new Vue({
	el: '#aging',
	data: {
		aging:{
			creditCard:"",
			agingNper:"",
			agingLines:""
		},
		bill:{
			cardNum : '',
			billMoney:'',
			residueRepay:""
		},
		result:'',
		cid : '',
		current : -1,
		creditCards: [{
			id : '',
			cardType : '',
			cardNum : '',
			cardState:''
		}],
		money1:'',
		result1:'',
		name:'',
	},	
methods: {
	queryBillMoney:function(){
	     var _this=this;
	     _this.bill.creditCard=this.cid;
	     axios.post("http://10.1.12.66:8086/trading/queryAgingMoney",_this.bill)
	     .then(function(response){
	    	 if(response.data.bill!=null){
	   	      _this.bill=response.data.bill;
	    	 }else{
	   	      _this.bill=response.data.bill2;
	    	 }
	      console.log();
	     })
	    },
		submit: function() {
		 var _this=this;
		 var money1 =/^[0-9]+(.[0-9]{1})?$/;
		 if(!(money1.test(_this.aging.agingLines))){
			 _this.result1=true;
		 }else{
			 _this.result1=false;
		 };
		 if(_this.aging.agingNper!=0){
			 if((money1.test(_this.aging.agingLines))){
				 var pay=confirm("请确认信息，是否提交申请");
			 }
		 }else{
			 alert("请选择期数")
		 }
		 
		
		 if(pay==true){
			 if(_this.aging.agingLines<=_this.bill.residueRepay&&_this.aging.agingLines>=500){
				 _this.aging.creditCard=this.cid;
			    	axios.post('http://10.1.12.66:8086/trading/addAging',_this.aging)
			    	.then(
						alert(_this.aging.creditCard),
						window.location.href='aging_bill.html'
			    		)
			    		.catch(function (error) {
			               console.log(error);
			       })
			 }else{
				 alert("金额不符合要求！*分期金额小于最高可分期金额并且大于500")
			 }
			 
		 }
		 
   },
  shenqing:function() {
	  var _this=this;
		if(_this.current<0){
			 alert("请选择信用卡片及还款卡片");
		 };
  },
   jisuan:function(event) {
		 var _this=this;
	 _this.aging.agingNper=event.target.value;
  	   axios.post('http://10.1.12.66:8086/trading/jisuanqi',_this.aging)
  	.then(function(response){
	      _this.result=response.data.result;
	      console.log();
  		})
  		.catch(function (error) {
             console.log(error);
     })
 },
	selectAllCreditCard : function() {
		var _this = this;
		_this.cid = _this.creditCards[0].id
		axios.get("http://10.1.12.66:8086/trading/queryCreditCardByClient")
		.then(function(response) {
		_this.creditCards=response.data.scs;
		_this.name=response.data.name;
			console.log(response);
		})
	},
		addClass : function(index) {
			this.current = index;
		},
		choseId : function(c) {
			this.cid = c;
		},
	},
		 created:function(){
		  this.selectAllCreditCard();
	   },
	})