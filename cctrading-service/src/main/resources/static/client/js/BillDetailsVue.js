new Vue({
   el:"#BillDetails",
   data:{
	   billDetails:{
	   		id:'',
	   		transactionDes:'',
	   		transactionMoney:'',
	   		transactionTime:'',
	   		transactionCoin:'',
	   		creditCard:'',
	   },
	   bill:{
	   		id:'',
	   		creditCard:'',
	   		billNum:'',
	   		billMoney:'',
	   		hasPay:'',
	   		minRepay:'',
	   		residueRepay:'',
	   		repayDate:'', 
	   		billDate:'',
       },
        cid : '',
        jid:"",
		current : 0,
		creditCards: [{
			id :'',
			cardType:'',
			cardNum: '',
			cardState:''
		   }],
	   billDetailes:[],
       billNum1:"",
       billNum2:'',
       result:"",
       name:'',
   },
   methods:{
	  selectAllCreditCard : function() {
			var _this = this;
		axios.get("http://10.1.12.66:8086/trading/queryCreditCardByClient")
			.then(function(response) {
			_this.creditCards=response.data.scs;
			_this.cid = _this.creditCards[0].id;
			_this.name=response.data.name;
				console.log(_this.cid);
				_this.queryBillByDate();
				_this.queryBillDetailsBybillId();
		 })
	 },
		 addClass : function(index) {
			this.current = index;
	   },
		 choseId : function(c) {
			this.cid = c;
		},
		
	queryBillDetailsBybillId:function(){
         var _this=this;
         
             _this.bill.creditCard=this.cid;
     axios.post("http://10.1.12.66:8086/trading/queryBillDetailsBybillId",_this.bill)
       .then(function(response){
       _this.billDetailes=response.data.lbds;
       _this.result=response.data.result;
         console.log();
     })
    },
    
    queryBillByDate:function(){
	     var _this=this;
	     _this.bill.creditCard=_this.cid;
	     axios.post("http://10.1.12.66:8086/trading/queryBillByDate",_this.bill)
	     .then(function(response){
	    	 console.log();
	    	 if(response.data.bill!=null){
	    		 _this.bill=response.data.bill;
	    	 }else{
	    		 _this.bill=response.data.billq;
	    	 }
	      _this.result=response.data.result;
	      if(_this.result==1){
	    	  alert("该卡本月暂无账单")
	      };
	      
	      console.log(_this.bill);
	     })
	   },
	   chage:function(event){
		   this.billNum1=event.target.value;
	   },
	findbill:function(event){
		var _this=this;
	 _this.bill.billNum=""+this.billNum1+event.target.value;
     _this.bill.creditCard=this.cid;
     	console.log(_this.bill);
     axios.post("http://10.1.12.66:8086/trading/queryBillByDate",_this.bill)
     .then(function(response){
    	 if(response.data.bill!=null){
    		 _this.bill=response.data.bill;
    	 }else{
    		 _this.bill=response.data.billq;
    	 }
	      _this.result=response.data.result;

	      if(_this.result==1){
	    	  alert("该卡本月暂无账单")
	      };
	      console.log(_this.bill);
	     })
		   
	   },
   },
  
   created:function(){
    this.selectAllCreditCard();
   },
 })



