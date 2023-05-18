import request from '@/utils/request'

export function list() {
    return request({
      url: '/node/list',
      method: 'get',
    })
  }

export function deleted(id) {
  return request({
    url: '/node/deleted/' + id,
    method: 'post',
  })
}

export function update(data) {
  return request({
    url: '/node/update',
    method: 'post',
    data
  })
}

export function insert(data) {
  return request({
    url: '/node/insert',
    method: 'post',
    data
  })
}

export function selected(data) {
  return request({
    url: '/node/selected',
    method: 'post',
    data
  })
}

export function createMap() {
  return request({
    url: '/node/createMap',
    method: 'get',
  })
}

export function createTree() {
  return request({
    url: '/node/createTree',
    method: 'get',
  })
}