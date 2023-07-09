// 查询列表接口
const getPurchaseOrdersPage = (params) => {
  return $axios({
    url: '/purchaseOrders/page',
    method: 'get',
    params
  })
}

// 删除接口

function deletePurchaseOrders(id) {
  return $axios({
    url: `/purchaseOrders/${id}`,
    method: 'delete'
  })
}



// 查询详情
const queryPurchaseOrdersById = (id) => {
  return $axios({
    url: `/purchaseOrders/${id}`,
    method: 'get'
  })
}



// 起售停售---批量起售停售接口
const purchaseOrdersStatusByStatus = (params) => {
  return $axios({
    url: `/purchaseOrders/status/${params.status}`,
    method: 'post',
    params: { ids: params.id }
  })
}



