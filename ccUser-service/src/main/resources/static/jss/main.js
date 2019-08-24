new Vue({
   el:"#queryOp",
   data:{
	 clients:[
     {
      id:'',
      clientName:'',
      clientIDcard:'',
      clientPhone:''
     }
    ]
   },
   methods:{
	   queryAllClient:function(){
     var _this=this;
     axios.get("http://localhost:8082/gu/queryAllClient",_this.id)
     .then(function(response){
      _this.clients=response.data.clients;
      console.log(response);
     })
    }
   },
   created:function(){
    this.queryAllClient();
   },
 })


new Vue({
	   el:"#queryCli",
	   data:{
		   clientBills:[
	     {
	      id:'',
	      clientId:'',
	      clientName:'',
	      clientIDcard:'',
	      billNum:'',
	      billMoney:'',
	      hasPay:'',
	      repayDate:''
	     }
	    ]
	   },
	   methods:{
		   queryAllBillDetails:function(){
	     var _this=this;
	     axios.get("http://localhost:8082/gu/queryAllBillDetails",_this.id)
	     .then(function(response){
	      _this.clientBills=response.data.clientBills;
	      console.log(response);
	     })
	    }
	   },
	   created:function(){
	    this.queryAllBillDetails();
	   },
	 })

new Vue({
	   el:"#queryMa",
	   data:{
		   mangerRoles:[
	     {
	    	 id:'',
	    	 mangerName:'',
	    	 mPassword:'',
	    	 mPhone:'',
	    	 role:''
	     }
	    ]
	   },
	   methods:{
		   queryAllManger:function(){
	     var _this=this;
	     axios.get("http://localhost:8082/gu/queryAllManger",_this.id)
	     .then(function(response){
	      _this.mangerRoles=response.data.mangerRoles;
	      console.log(response);
	     })
	    }
	   },
	   created:function(){
	    this.queryAllManger();
	   },
	 })




new Vue({
	   el:"#queryC",
	   data:{
		   urls:'',
		   client:
		   {
	    	 id:'',
	    	 clientId:'',
	    	 clientName:'',
	    	 clientSex:'',
	    	 clientNational:'',
	    	 clientIDcard:'',
	    	 clientBirthday:'',
	    	 clientMarriage:'',
	    	 clientEdu:'',
	    	 creditPoint:'',
	    	 password:'',
	    	 questionId:'',
	    	 clientAnswer:'',
	    	 clientHousing:'',
	    	 clientAddress:'',
	    	 postalcode:'',
	    	 clientEmail:'',
	    	 clientPhone:''
	     }
	   },
	   methods:{
		   queryClientById:function(){
	     var _this=this;
	     var  id= GetQueryString("id")
	     axios.get("http://localhost:8082/gu/queryClientById",{params:{id:id}})
	     .then(function(response){
	      _this.client=response.data.client;
	      console.log(_this.client);
	     })
	    }
	   },
	   created:function(){
	    this.queryClientById();
	   },
	 })
	 function GetQueryString(name){
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  unescape(r[2]); return null;
	 }

new Vue({
	   el:"#queryCID",
	   data:{
		   clientBillDetails:
		   [{
			   clientName:'',
			   transactionType:'',
			   transactionTime:'',
			   transactionMoney:'',
			   payTime:''
	     }]
	   },
	   methods:{
		   queryBillDetailsById:function(){
	     var _this=this;
	     var  clientName= decodeURIComponent(GetQueryString("clientName"));
	     alert(clientName);
	     console.log(clientName);
	     axios.get("http://localhost:8082/gu/queryBillDetailsById",{params:{clientName:clientName}})
	     .then(function(response){
	      _this.clientBillDetails=response.data.clientBillDetails;
	      console.log(_this.clientBillDetails);
	     })
	    }
	   },
	   created:function(){
	    this.queryBillDetailsById();
	   },
	 })
	 function GetQueryString(name){
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  unescape(r[2]); return null;
	 }