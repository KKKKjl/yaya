import axios from '@/utils/request';
// import base from '@/api/base';
import qs from 'qs';

export function getPosts() {
	return axios.get(`/api/posts`)
}

export function uploadImage(params) {
	return axios.post(`/upload`, params)
}

export function register(params) {
	return axios.post(`/api/register`, qs.stringify(params))
}

export function login(params) {
	return axios.post(`/api/auth`, qs.stringify(params))
}

export function getUserInfo() {
	return axios.get(`/api/user`)
}

export function addPost(params) {
	return axios.post(`/api/post`, qs.stringify(params))
}

export function addComment(params) {
	return axios.post(`/api/comment`, qs.stringify(params))
}

export function getComments(params) {
	return axios.get(`/api/comments`, params)
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