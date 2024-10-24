import request from '@/utils/request'

// 查询物料信息列表
export function listInfo(query) {
  return request({
    url: '/material/info/list',
    method: 'get',
    params: query
  })
}

// 查询物料信息详细
export function getInfo(id) {
  return request({
    url: '/material/info/' + id,
    method: 'get'
  })
}

// 新增物料信息
export function addInfo(data) {
  return request({
    url: '/material/info',
    method: 'post',
    data: data
  })
}

// 修改物料信息
export function updateInfo(data) {
  return request({
    url: '/material/info',
    method: 'put',
    data: data
  })
}

// 删除物料信息
export function delInfo(id) {
  return request({
    url: '/material/info/' + id,
    method: 'delete'
  })
}
