// 获取采购订单详情列表
function getSalesOrderDetailsList(params) {
  return $axios({
    url: '/salesOrderDetails/page',
    method: 'get',
    params
  });
}
