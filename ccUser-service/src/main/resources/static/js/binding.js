new Vue({
	el:'#app',
	data:{
		timer:60,
        stop:true,
        Interval:null,
		code:'',
		scode:'',
		bankCard:'',
		credit:{
			cardNum:'',
			cardType:'',
			carPassword:'',
			cardValidity:'',
			cardSecurityCode:'',
			cardLimit:'',
			cardShortLimit:'',
			cardCashLimit:'',
			cardState:'',
			cardBinding:'',
			repayCard:'',
			client:'',
			cardAnnual:'',
			cardBalance:'',
			cardBillday:'',
			cardRefundDay:'',
			cardpoint:'',
			cardPhone:'',
		},
		userName:'',
		userIDcard:'',
		day:'',
		three:'',
		name:'',
		IDcard:'',
		oldpsd:'',
		newpsd:'',
		querypsd:'',
		oldphone:'',
		newphone:'',
		//前端提示所需字段
		//银行卡
		flag:true,
		mess:'',
		//身份证
		flag1:true,
		mess1:'',
		//有效期
		flag2:true,
		mess2:'',
		//证件人姓名
		flag3:true,
		mess3:'',
		//卡背末三位
		flag4:true,
		mess4:'',
		//手机号
		flag5:true,
		mess5:'',
		//验证码
		flag6:true,
		mess6:'',
	},
	methods:{
		//查找银行卡
		findCard:function(){
			var _this=this;
			var pattern = /^([1-9]{1})(\d{15}|\d{17})$/
			if(this.credit.cardNum!=""){
				if(_this.credit.cardNum.match(pattern)){
					_this.flag=true;
					axios.post("/client/creditCard/queryBankCard",this.credit)
				.then(function(response){
					if(response.data.bankCard!=""){
						_this.bankCard=response.data.bankCard;
						_this.userName=response.data.name;
						_this.userIDcard=response.data.idcard;
						_this.day=response.data.day;
						_this.three=response.data.num;
					}
				})
			}else{
				_this.mess="请输入正确的卡号";
				_this.flag=false;
			}
			}else{
				_this.mess="请输入本行信用卡";
				_this.flag=false;
			}
		},
		//身份证号码校验
		checkIDcard (){
			var idcardnum = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
			if(this.IDcard!=""){
				if(this.IDcard.match(idcardnum)){
					this.flag1=true;
					this.mess1="";
				}else{
					this.flag1=false;
					this.mess1="请输入正确的身份证号";
				}
			}else{
				this.flag1=false;
				this.mess1="请输入身份证号";
			}
		},
		//发送验证码及倒计时
		update () {
            if(this.timer <= 0)
            {
                this.stop = !this.stop;
                clearInterval(this.Interval);
                this.timer=60;
            }
            else{
                this.timer--;
            }
        },
        startTimer :function() {
            this.Interval = setInterval(this.update, 1000);
            console.log(this.Interval);
        },
		callMsg:function(){
			var _this=this;
			if(this.newphone!=""){
				_this.credit.cardPhone=this.newphone;
			}
			axios.post("/client/client/checkphone",_this.credit.cardPhone)
			.then(function(response){
				if(response.data.flag==true){
					_this.stop=!this.stop;
                    _this.startTimer();
                    _this.scode=response.data.scode;
                    alert(response.data.scode);
				}
			})
		},
		//提交绑定信用卡方法
		cardBinding:function(){
			var _this=this;
			this.checkIDcard();
			if(this.name==this.userName){
				_this.mess3="";
				_this.flag3=true;
				if(this.IDcard==this.userIDcard){
					_this.mess1=""
					_this.flag1=true;
					if(this.credit.cardValidity==this.day){
						_this.mess4="";
						_this.flag4=true;
						if(this.credit.cardSecurityCode==this.three){
							_this.mess5="";
							_this.flag5=true;
							if(this.code==this.scode){
								_this.mess6="";
								_this.flag6=true;
								axios.post("/client/creditCard/addBindingCard",_this.credit)
								.then(function(response){
									if(response.data.flag==true){
					                    alert("绑定成功");
					                    window.location.href='loginIndex.html';
									}else{
										alert(response.data.mess);
									}
								})
							}else{
								/*alert("验证码不正确");*/
								_this.mess6="验证码不正确";
								_this.flag6=false;
							}
						}else{
							/*alert("安全码不正确")*/
						_this.mess5="安全码不正确";
						_this.flag5=false;
						}
					}else{
						/*alert(this.credit.cardValidity)
						alert("日期信息不匹配");*/
						_this.mess4="有效日期信息不匹配";
						_this.flag4=false;
					}
				}else{
					_this.mess1="身份证信息不匹配"
					_this.flag1=false;
				}
			}else{
				_this.mess3="持卡人姓名不匹配";
				_this.flag3=false;
			}
			
			
		},
		//验证身份证信息
		/*checkIDcard:function(){
			var _this=this;
			if(this.name!=""){
				if(this.IDcard!=""){
					axios.post("/client/client/idcard",{name:_this.name,IDcard:_this.IDcard})
					.then(function(response){
						console.log(response.data);
					})
				}else{
					alert("请输入身份证号")
				}
			}else{
				alert("请输入身份证姓名")
			}
		},*/
		//修改手机号
		chagePhone:function(){
			var _this=this;
			if(this.oldphone!=""){
				if(this.newphone!=""){
					if(this.code=this.scode){
						axios.get("/client/client/updateClientPhone",{params:{oldPhone:_this.oldphone,newPhone:_this.newphone}})
						.then(function(response){
							if(response.data.flag){
								alert("更换号码成功");
								window.location.href='setting.html';
							}else{
								alert(response.data.mess);
							}
							
						})	
					}else{
						alert("验证码不正确");
					}
				}
			}
		},
		//修改密码
		chage:function(){
			var _this=this;
			if(this.newpsd==this.querypsd){
				axios.get('/client/client/updatePsd',{params:{oldpsd:_this.oldpsd,newpsd:_this.newpsd}})
				.then(function(response){
					if(response.data.flag){
						alert("修改成功");
						window.location.href='setting.html';
					}else{
						alert(response.data.mess);
					}
				})
			}
		}
	}
})