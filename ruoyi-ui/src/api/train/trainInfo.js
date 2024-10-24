import request from '@/utils/request'

// 查询实训列表
export function listTrainInfo(query) {
  return request({
    url: '/train/trainInfo/list',
    method: 'get',
    params: query
  })
}

// 查询实训详细
export function getTrainInfo(id) {
  return request({
    url: '/train/trainInfo/' + id,
    method: 'get'
  })
}

// 新增实训
export function addTrainInfo(data) {
  return request({
    url: '/train/trainInfo',
    method: 'post',
    data: data
  })
}

// 修改实训
export function updateTrainInfo(data) {
  return request({
    url: '/train/trainInfo',
    method: 'put',
    data: data
  })
}

// 删除实训
export function delTrainInfo(id) {
  return request({
    url: '/train/trainInfo/' + id,
    method: 'delete'
  })
}
