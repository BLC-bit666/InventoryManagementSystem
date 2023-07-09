// 查询列表接口
function getSalesOrdersPage(params) {
  return $axios({
    url: '/salesOrders/page',
    method: 'get',
    params
  })
}

// 删除接口
function deleteSalesOrders(id) {
  return $axios({
    url: `/salesOrders/${id}`,
    method: 'delete'
  })
}


