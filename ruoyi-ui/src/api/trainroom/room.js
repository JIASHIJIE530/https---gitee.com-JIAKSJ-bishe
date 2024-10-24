import request from '@/utils/request'

// 查询实训室信息列表
export function listRoom(query) {
  return request({
    url: '/trainroom/room/list',
    method: 'get',
    params: query
  })
}

// 查询实训室信息详细
export function getRoom(id) {
  return request({
    url: '/trainroom/room/' + id,
    method: 'get'
  })
}

// 新增实训室信息
export function addRoom(data) {
  return request({
    url: '/trainroom/room',
    method: 'post',
    data: data
  })
}

// 修改实训室信息
export function updateRoom(data) {
  return request({
    url: '/trainroom/room',
    method: 'put',
    data: data
  })
}

// 删除实训室信息
export function delRoom(id) {
  return request({
    url: '/trainroom/room/' + id,
    method: 'delete'
  })
}
