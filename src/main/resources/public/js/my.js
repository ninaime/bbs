 // 全局时间戳转换指令注册
Vue.directive('time',{
	bind: function (el,binding) {
		let getTime = new Date(binding.value)
		el.innerHTML = `${getTime.getFullYear()}-${getTime.getMonth()+1}-${getTime.getDate()}`;
	}
})