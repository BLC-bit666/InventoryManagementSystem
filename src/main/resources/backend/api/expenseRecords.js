// 获取费用记录列表
function getExpenseRecordsList(params) {
  return $axios({
    url: '/expenseRecords/page',
    method: 'get',
    params
  })
}

// 添加费用记录
function addExpenseRecord(params) {
  return $axios({
    url: '/expenseRecords',
    method: 'post',
    data: { ...params }
  })
}

// 编辑费用记录
function editExpenseRecord(params) {
  return $axios({
    url: '/expenseRecords',
    method: 'put',
    data: { ...params }
  })
}

// 根据ID查询费用记录详情
function queryExpenseRecordById(id) {
  return $axios({
    url: `/expenseRecords/${id}`,
    method: 'get'
  })
}

// 删除费用记录
function deleteExpenseRecord(id) {
  return $axios({
    url: `/expenseRecords/${id}`,
    method: 'delete'
  })
}
