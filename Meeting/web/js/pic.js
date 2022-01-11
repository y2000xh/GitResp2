window.onload = function(){
	var image = document.getElementById('image');
	var pic = document.getElementById("pic");
	image.onchange = function(){
		var rd = new FileReader();//创建文件读取对象
		var files = this.files[0];//获取file组件中的文件
		
//		console.log(files.type);
		//文件类型判断
		if(!/image\/\w+/.test(files.type)){ 
	        alert("看清楚，这个需要图片！");
	        this.value = '';
			pic.src = '';
	        return false;
	    }
		
		//限值文件的大小 以字节(byte)未单位
		if(files.size > 100*1024){
			alert('文件过大无法显示');
			this.value = '';
			pic.src = '';
			return false;
		}
		
		rd.readAsDataURL(files);//文件读取装换为base64类型
        rd.onloadend = function(e) {
            //加载完毕之后获取结果赋值给img
            console.log(this.result);//this.result是base64类型的参数
            pic.src = this.result;
        }
	}
}