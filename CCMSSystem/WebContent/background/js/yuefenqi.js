new Vue({
   el:"#agingMonth",
   data:{
    agingMonth:{
         id:'',
       monthMoney:'',
       monthInterest:'',
       notReturnMoney:'',
       agingRate:'',
       monthNper:'',
       agingRefund:'',
       returnMoney:'',
       aging:'',
       monthNper:'',
       agingPoundage:'',
       installments:'',
       agingType:'',
       agingTime:''
    },
    agingMonths:[]
   },
   methods:{
	   queryAllAgingMonthById:function(){
     var _this=this;
     var  id= GetQueryString("id")
     axios.get("/queryAllAgingMonthById",{params:{id:id}})
     .then(function(response){
      _this.agingMonths=response.data.agingMonths;
     })
    }
   },
   created:function(){
    this.queryAllAgingMonthById();
   },
 })
 function GetQueryString(name){
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
 }