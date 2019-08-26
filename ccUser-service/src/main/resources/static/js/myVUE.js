    	new Vue({
    		el:'#reg_login',
    		data:{
    			clientPhone:'',
    			code:'',
    			scode:'',
    			timer:60,
                stop:true,
                Interval:null,
                mess:'',
                flag:false,
    		},
    		methods:{
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
    			callMsg:function(clientPhone){
    				var _this=this;
    				axios.post("/client/client/checkphone",_this.clientPhone)
    				.then(function(response){
    					if(response.data.flag==true){
    						_this.stop=!this.stop;
    	                    _this.startTimer();
    	                    _this.scode=response.data.scode;
    	                    alert(response.data.scode);
    					}
    				})
    			},
    			//登录
    			login :function(){
    				var _this = this;
    				if(this.clientPhone!=""){
    					if(_this.code!=""){
    					_this.flag=false;
        				_this.mess="";
    					if(_this.code == _this.scode){
        					axios.post("/client/client/clientLogin",this.clientPhone)
        					.then(function(response){
        						if(response.data.flag){
        							window.location.href='loginIndex.html';
        						}else{
        							_this.flag=true;
        							alert(response.data.mess);
        						}
        					})
        				}else{
        					_this.flag=true;
        					_this.mess="验证码错误";
        				}
    				}else{
    					_this.flag=true;
        				_this.mess="请输入验证码";
    				}
    			}		
    		}
    			,
    			//校验手机号码格式
    			checkPhone :function(){
    				//手机验证正则
    				var phone=/^1[3,5,7,8]\d{9}$/;
    				if(this.clientPhone==""){
    					this.mess="请输入手机号";
    					this.flag=true;
    				}else if(this.clientPhone.match(phone)){
    					this.mess="";
    					this.flag=false;
    					
    				}else{
    					this.mess="请输入正确的手机格式";
    					this.flag=true;
    				}
    			},
    			//校验验证码
    			checkCode:function(){
    				//验证码 正则
    				var c=/^[0-9]{6}$/
    				//校验验证码
    					if(this.code==""){
    						this.mess="请输入验证码";
    						this.flag=true;
    					}else if(this.code.match(c)){
    						this.mess="";
    						this.flag=false;
    					}else{
    						this.mess="请输入6位数字验证码";
    						this.flag=true;
    					}
    			}
    		},
    	})