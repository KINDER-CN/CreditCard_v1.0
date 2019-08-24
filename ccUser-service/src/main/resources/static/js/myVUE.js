    	new Vue({
    		el:'#reg_login',
    		data:{
    			clientPhone:'',
    			code:'',
    			scode:'',
    			timer:60,
                stop:true,
                Interval:null
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
    				axios.post("/client/checkphone",_this.clientPhone)
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
    				if(_this.code!=""){
    					if(/*_this.code == _this.scode*/true){
        					axios.post("/client/client/clientLogin",this.clientPhone)
        					.then(function(response){
        						if(response.data.flag){
        							window.location.href='loginIndex.html';
        						}else{
        							alert(response.data.msg);
        						}
        					})
        				}else{
        					alert("验证码输入错误");
        				}
    				}
    			}
    		},
    	})