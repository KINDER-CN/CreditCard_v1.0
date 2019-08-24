new Vue({
   el:"#a",
   data:{
    bill:{
    	id:'',
		billNum:'',
		billMoney:'',
		hasPay:'',
		srepayDate:'',
		repayDate:'',
		billDate:'',
		billState:''
    },
    bills:[]
   },
   methods:{
	   queryBillById:function(){
     var _this=this;
     var  id= GetQueryString("id")
     axios.get("/queryBillById",{params:{id:id}})
     .then(function(response){
      _this.billId=response.data.billId;
     })
    }
   },
   created:function(){
    this.queryBillById();
   },
 })
 function GetQueryString(name){
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
 }