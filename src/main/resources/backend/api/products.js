// 获取产品列表
function getProductList(params) {
  return $axios({
    url: '/products/page',
    method: 'get',
    params
  })
}

// 添加产品
function addProduct(params) {
  return $axios({
    url: '/products',
    method: 'post',
    data: { ...params }
  })
}

// 编辑产品
function editProduct(params) {
  return $axios({
    url: '/products',
    method: 'put',
    data: { ...params }
  })
}

// 根据ID查询产品详情
function queryProductById(id) {
  return $axios({
    url: `/products/${id}`,
    method: 'get'
  })
}


// 删除产品
function deleteProduct(id) {
  return $axios({
    url: `/products/${id}`,
    method: 'delete'
  })
}
