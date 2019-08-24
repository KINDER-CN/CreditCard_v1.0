new Vue({
   el:"#agingMonth",
   data:{
	   agingMonth:{
   		id:'',
   		monthMoney:'',
   		monthNper:'',
   		monthInterest:'',
   		agingRate:'',
   		agingRefund:'',
   		agingType:'',
   		installments:''
	   },
	   agingMonths:[],
	   name:'',
   },
   methods:{
	    queryAgingMonth:function(){
	       var _this=this;
	       var  id= GetQueryString("id")
	    axios.get("http://10.1.12.66:8086/trading/queryAgingMonth",{params:{id:id}})
	       .then(function(response){
	           _this.agingMonths=response.data.lams;
	           console.log(_this.agingMonths);
	           _this.name=response.data.name;
         })
      }
   },
		   created:function(){
		    this.queryAgingMonth();
	 },
 })
	function GetQueryString(name){
	    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	    var r = window.location.search.substr(1).match(reg);
	    if(r!=null)return  unescape(r[2]); return null;
	}