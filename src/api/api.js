import axios from '@/utils/request';
import base from '@/api/base';
import qs from 'qs';

export function getPosts() {
	return axios.get(`${base.lh}/posts`)
}

export function uploadImage(params) {
	return axios.post(`${base.sq}/upload`, params)
}

export function register(params) {
	return axios.post(`${base.lh}/register`, qs.stringify(params))
}

export function login(params) {
	return axios.post(`${base.lh}/auth`, qs.stringify(params))
}

export function getUserInfo() {
	return axios.get(`${base.lh}/user`)
}

export function addPost(params) {
	return axios.post(`${base.lh}/post`, qs.stringify(params))
}

export function addComment(params) {
	return axios.post(`${base.lh}/comment`, qs.stringify(params))
}

export function getComments(params) {
	return axios.get(`${base.lh}/comments`, params)
}

export default {
	getPosts,
	uploadImage,
	login,
	register,
	getUserInfo,
	addPost,
	addComment,
	getComments
}