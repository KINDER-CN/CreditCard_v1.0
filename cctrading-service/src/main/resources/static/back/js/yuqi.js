new Vue({
			el:"#a",
			data:{
				overdue:[
					{
						id:'',
						clientName:'',
						clientIDcard:'',
						cardNum:'',
						overdueNum:'',
						overMoney:'',
						overDate:'',
						overSPayDate:'',
						overState:'',
						overReturnDate:'',
						overSPayMoney:'',
					}
				]
			},
			methods:{
				queryAllOverdue:function(){
					var _this=this;
					axios.get("http://10.1.12.66:8086/trading/queryAllOverdue")
					.then(function(response){
						_this.overdue=response.data.overdue;
						console.log(_this.overdue);
					})
				}
			},
			created:function(){
				this.queryAllOverdue();
			},
	})