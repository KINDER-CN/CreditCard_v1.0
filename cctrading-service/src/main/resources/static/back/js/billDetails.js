new Vue({
   el:"#billDetails",
   data:{
    billDetails:{
         id:'',
         transactionDes:'',
         transactionType:'',
         transactionMoney:'',
         transactionTime:'',
         transactionCoin:'',
         payTime:'',
         billId:'',
         creditCard:'',
         aging:''
    },
    billDetailsId:[]
   },
   methods:{
	   queryBillDetailsById:function(){
     var _this=this;
     var  id= GetQueryString("id")
     axios.get("http://10.1.12.66:8086/trading/queryBillDetailsById",{params:{id:id}})
     .then(function(response){
      _this.billDetailsId=response.data.billDetailsId;
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