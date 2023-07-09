// 获取供应商列表
function getSupplierList(params) {
    return $axios({
        url: '/suppliers/page',
        method: 'get',
        params
    })
}
function getSupplierOptionList() {
    return $axios({
        url: '/suppliers/option',
        method: 'get',
    })
}

// 添加供应商
function addSupplier(params) {
    return $axios({
        url: '/suppliers',
        method: 'post',
        data: { ...params }
    })
}

// 编辑供应商
function editSupplier(params) {
    return $axios({
        url: '/suppliers',
        method: 'put',
        data: { ...params }
    })
}

// 根据ID查询供应商详情
function querySupplierById(id) {
    return $axios({
        url: `/suppliers/${id}`,
        method: 'get'
    })
}
// 删除供应商
function deleteSupplier(id) {
    return $axios({
        url: `/suppliers/${id}`,
        method: 'delete'
    })
}
