import axios from '@/utils/request';
import base from '@/api/base';
// import qs from 'qs';

export function getPosts() {
	return axios.get(`${base.sq}/getPosts`)
}

export function uploadImage(params) {
	return axios.post('https://sm.ms/api/upload', params)
}

export default {
	getPosts,
	uploadImage
}