$(function () {
    loadKhgl();
    loadGcgl();
})

//初始化工程信息
function loadGcgl() {
    $('#khgl_gcgl').datagrid({
        url: "/gcmc/getAll",
        method: "POST"
    })
}

//加载客户名称及点击事件
function loadKhgl() {
    $('#khgl_yhgl').tree({
        url: "/khmc/getAll",
        method: "POST",
        loadFilter: function (data) {
            console.log(data);
            return convertTreeJson(data);
        },
        onClick: function (node) {
            var requestUrl = node.id == 0 ? "getAll" : ("getGcmcsByKhId/" + node.id)
            $('#khgl_gcgl').datagrid({
                url: "/gcmc/" + requestUrl
            })
        },
        onLoadSuccess: function (node, data) {
            var node = $('#khgl_yhgl').tree('find', 0);
            $('#khgl_yhgl').tree('select', node.target);
        }
    });
}

//展示工程
function options(value, row, index) {
    return "<button onclick='openUpdateGcmc(" + JSON.stringify(row) + ")'>修改</button>&nbsp;&nbsp;<button onclick='deleteGcmc(" + row.gcmc_id + ")'>删除</button>&nbsp;&nbsp;"

}

//新增工程
function openGcmc() {
    $('#gcmc_window').dialog({
        title: '新增工程',
        width: 400,
        height: 200,
        closed: false,
        cache: false,
        modal: true,
        buttons: [{
            text: '保存',
            handler: function () {
                //1.获取表单中数据
                //2.ajax传递后端
                $('#gcmc_info').form('submit', {
                    url: "/gcmc/add",
                    onSubmit: function (param) {
                        //param.id = 1000;  隐藏参数
                        //验证  return false 阻止表单提交
                    },
                    success: function (data) {
                        //3.回调函数
                        if (data == "true") {//成功: 提示成功
                            $.messager.alert('消息', '新增成功！');
                            $("#gcmc_info").form("reset");//清空表单
                            $("#khgl_gcgl").datagrid("reload")//刷新表格
                            $('#gcmc_window').window('close');//关闭窗口
                        } else {//失败： 提示错误
                            $.messager.alert('警告', '新增失败！');
                        }
                    }
                });
            }
        }, {
            text: '关闭',
            handler: function () {
                $("#gcmc_info").form()("reset");//清空表单
                $('#gcmc_window').window('close');
            }
        }]
    });
    $('#gcmc_window').window('open');
}

//修改
function updateGcmc() {
    var row = $("#khgl_gcgl").datagrid("getSelected");
    if (row) {
        openUpdateGcmc(row);
    } else {
        $.messager.alert('提示', '请选择你要修改的工程！');
    }

}

function openUpdateGcmc(row) {
    $('#gcmc_window').dialog({
        title: '修改工程',
        width: 400,
        height: 400,
        closed: true,
        cache: false,
        modal: true,
        buttons: [{
            text: '保存',
            handler: function () {
                //1.获取表单中数据
                //2.ajax传递后端
                $('#gcmc_info').form('submit', {
                    url: "/gcmc/update",
                    onSubmit: function (param) {
                        param.gcmc_id = row.gcmc_id;
                        //param.id = 1000;  隐藏参数
                        //验证  return false 阻止表单提交
                    },
                    success: function (data) {
                        //3.回调函数
                        if (data == "true") {//成功: 提示成功
                            $.messager.alert('消息', '修改成功！');
                            $("#gcmc_info").form("reset");//清空表单
                            $("#khgl_gcgl").datagrid("reload")//刷新表格
                            $('#gcmc_window').window('close');//关闭窗口
                        } else {//失败： 提示错误
                            $.messager.alert('警告', '修改失败！');
                        }
                    }
                });
            }
        }, {
            text: '关闭',
            handler: function () {
                $("#gcmc_info").from("reset");//清空表单
                $('#gcmc_window').window('close');
            }
        }]
    });
    //加载表单数据
    $('#gcmc_window').form('load', {
        gcmc_name: row.gcmc_name,
        khmc_id: row.khmc_id
    });
    $('#gcmc_window').window('open');
}

///删除工程
function deleteGcmc(gcmc_id) {//未赋值就是undefiand
    var ids = [];//删除的gcmc_ids数组
    if (gcmc_id) {//单个id
        ids.push(gcmc_id);
    } else {//批量
        var rows = $("#khgl_gcgl").datagrid("getSelections");
        if (rows && rows.length > 0) {
            $(rows).each(function (i, o) {
                ids.push(o.gcmc_id);
            });
        }
    }
    if (ids.length == 0) {
        $.messager.alert('提示', '请选择你要删除的工程！');
        return;
    }
    $.messager.confirm('确认', '您确认想要删除记录吗？', function (r) {
        $.post("/gcmc/delete", {"ids": ids}, function (data) {
            if (data == true) {
                $.messager.alert('消息', '删除成功！');
                $("#khgl_gcgl").datagrid("reload")//刷新表格
            } else {
                $.messager.alert('警告', '删除失败！');
            }
        })
    });
}

//搜索工程信息
function query(value, name) {
    var json = {};
    json[name] = value;
    $('#khgl_gcgl').datagrid({
        queryParams: json,
        url: "/gcmc/getGcmcs"
    });
}