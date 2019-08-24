new Vue({
   el:"#agingbill",
   data:{
	   aging:{
   		  id:'',
	      agingNum:'',
	      agingLines:'',
	      agingNper:'',
	      agingTime:'',
	      agingRate:'',
	      agingState:'',
	      agingEndTime:'',
	      creditCard:''
	     },
        agings:[],
        cid : '',
		current : 0,
		creditCards: [{
			id : '',
			cardType : '',
			cardNum : '',
			cardState:''
		}],
	     name:'',
   },
   methods:{
      queryAllAging:function(){
         var _this=this;
		 _this.aging.creditCard=this.cid;
       axios.post("http://10.1.12.66:8086/trading/queryAgingByClient",_this.aging)
        .then(function(response){
          _this.agings=response.data.las;
         console.log(_this.agings);
      })
     },
     selectAllCreditCard : function() {
 		var _this = this;
 		_this.cid=_this.creditCards[0].id
 		axios.get("http://10.1.12.66:8086/trading/queryCreditCardByClient")
 		.then(function(response) {
 		_this.creditCards=response.data.scs;
 		_this.name=response.data.name;
 		_this.queryAllAging();
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