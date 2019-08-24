new Vue({
   el:"#billmonth",
   data:{
	   billDetails:{
   		id:'',
   		transactionDes:'',
   		transactionMoney:'',
   		transactionTime:'',
   		transactionCoin:'',
   		creditCard:'',
     },
		cid :'',
		current : 0,
		creditCards: [{
			id : '',
			cardType : '',
			cardNum : '',
			cardState:''
		}],
		   billDetailes:[],
     name:'',
	   },
methods:{
	  queryBillDetailsBybillId2:function(){
	       var _this=this;
	       _this.billDetails.creditCard=this.cid;
	       
	     axios.post("http://10.1.12.66:8086/trading/queryBillDetailsBybillId2",_this.billDetails)
	     .then(function(response){
	      _this.billDetailes=response.data.lbds;
	      console.log(_this.billDetailes);
	 })
  },
	   selectAllCreditCard : function() {
			var _this = this;
			
		axios.get("http://10.1.12.66:8086/trading/queryCreditCardByClient")
		  .then(function(response) {
			  _this.name=response.data.name;
		_this.creditCards=response.data.scs;
		_this.cid = _this.creditCards[0].id;
		_this.queryBillDetailsBybillId2();
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