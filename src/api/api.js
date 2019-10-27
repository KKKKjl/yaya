import axios from '@/utils/request';
import base from '@/api/base';

export function getPosts() {
	return axios.get(`${base.sq}/getPosts`)
}

export default {
	getPosts
}