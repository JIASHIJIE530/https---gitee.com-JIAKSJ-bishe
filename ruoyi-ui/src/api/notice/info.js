import request from '@/utils/request'

// 查询公告列表
export function listInfo(query) {
  return request({
    url: '/notice/info/list',
    method: 'get',
    params: query
  })
}

// 查询公告详细
export function getInfo(id) {
  return request({
    url: '/notice/info/' + id,
    method: 'get'
  })
}

// 新增公告
export function addInfo(data) {
  return request({
    url: '/notice/info',
    method: 'post',
    data: data
  })
}

// 修改公告
export function updateInfo(data) {
  return request({
    url: '/notice/info',
    method: 'put',
    data: data
  })
}

// 删除公告
export function delInfo(id) {
  return request({
    url: '/notice/info/' + id,
    method: 'delete'
  })
}
