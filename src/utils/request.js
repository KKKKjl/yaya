import axios from 'axios';

// 创建axios实例
var instance = axios.create({
	timeout: 3000
})

// 请求拦截
instance.interceptors.request.use(config => {
	return config
}, error => {
	return Promise.error(error)
})

// 响应拦截
instance.interceptors.response.use(response => {
	if (response.status != 200) {
		return Promise.reject(response);
	}
	return Promise.resolve(response)
}, error => {
	return Promise.reject(error.response)
})

export default instance;