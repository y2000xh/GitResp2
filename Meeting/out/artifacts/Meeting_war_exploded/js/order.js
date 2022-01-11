window.onload = function() {
	//增加函数
	function add(select, opt) {
		select.options[select.length] = opt;
	}
	
	//删除函数
	function del(select, i) {
		var opt = select.options[i]; // 获取删除对象
		select.remove(i); //删除
		return opt; //返回被删除对象
	}
	
	//获得按钮对象
	var toRight = document.getElementById('toRight');
	var toLeft = document.getElementById('toLeft');
	
	//获得列表框对象
	var select1 = document.getElementById('showEmps');
	var select2 = document.getElementById('selEmps');
	
	//右移事件
	toRight.onclick = function() {
	
		//获得选中对象的下标
		var index = select1.selectedIndex;
	
		if(index == -1) {
			alert('没有选中任何元素');
			return;
		}
	
		//左侧删除选中对象,获取选中对象
		var opt = del(select1, index);
	
		//右侧添加对象
		add(select2, opt);
	}
	
	//左移事件
	toLeft.onclick = function() {
	
		//获得选中对象的下标
		var index = select2.selectedIndex;
	
		if(index == -1) {
			alert('没有选中任何元素');
			return;
		}
		//右侧删除选中对象,获取选中对象
		var opt = del(select2, index);
	
		//左侧添加对象
		add(select1, opt);
	}
}