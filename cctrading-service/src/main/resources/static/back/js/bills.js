new Vue({
			el:"#a",
			data:{
				agingThree:[
					{
						id:'',
						billNum:'',
						billMoney:'',
						hasPay:'',
						srepayDate:'',
						repayDate:'',
						billDate:'',
						billState:''
					}
				]
			},
			methods:{
				queryAllBill:function(){
					var _this=this;
					axios.get("http://10.1.12.66:8086/trading/queryAllBill")
					.then(function(response){
						_this.agingThree=response.data.agingThree;
						console.log(_this.agingThree);
					})
				}
			},
			created:function(){
				this.queryAllBill();
			},
	})
