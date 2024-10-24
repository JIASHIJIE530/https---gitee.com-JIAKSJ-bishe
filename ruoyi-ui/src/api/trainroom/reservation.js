import request from '@/utils/request'

// 查询预约记录列表
export function listReservation(query) {
  return request({
    url: '/trainroom/reservation/list',
    method: 'get',
    params: query
  })
}

// 查询预约记录详细
export function getReservation(id) {
  return request({
    url: '/trainroom/reservation/' + id,
    method: 'get'
  })
}

// 新增预约记录
export function addReservation(data) {
  return request({
    url: '/trainroom/reservation',
    method: 'post',
    data: data
  })
}

// 修改预约记录
export function updateReservation(data) {
  return request({
    url: '/trainroom/reservation',
    method: 'put',
    data: data
  })
}

// 删除预约记录
export function delReservation(id) {
  return request({
    url: '/trainroom/reservation/' + id,
    method: 'delete'
  })
}
