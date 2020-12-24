var json;
$(function () {
    loadYclrk();
})

function loadYclrk() {
    $('#yclgl').datagrid({
        url: "/yclrk/getYclrkVoList ",// /yclrk/getYclrkVos
        method: "POST",
        loadFilter: function (data) {
            json = data;
            return data;
        }

    })
}

function khmcInfo(value, row, index) {
    return json.rows[index].khmc.khmc_name;
}

function gcmcInfo(value, row, index) {
    //console.log( json.rows[index].gcmc.gcmc_name);
    return json.rows[index].gcmc.gcmc_name;
}

function options(value, row, index) {

    return "<button onclick='openUpdateYclgl(" + JSON.stringify(row) + ")'>修改</button>&nbsp;&nbsp;<button onclick='deleteYclgl(" + row.yclrk_id + ")'>删除</button>&nbsp;&nbsp;"

}

function query() {

}

//原材料入库
function openYclgl() {
    $('#yclgl_window').dialog({
        title: '新增原材料',
        width: 400,
        height: 400,
        closed: false,
        cache: false,
        modal: true,
        buttons: [{
            text: '保存',
            handler: function () {
                //1.获取表单中数据
                //2.ajax传递后端
                $('#yclgl_info').form('submit', {
                    url: "/yclrk/add",
                    onSubmit: function (param) {
                        //param.id = 1000;  隐藏参数
                        //验证  return false 阻止表单提交
                    },
                    success: function (data) {
                        //3.回调函数
                        if (data == "true") {//成功: 提示成功
                            $.messager.alert('消息', '新增成功！');
                            $("#yclgl_info").form("reset");//清空表单
                            $("#yclgl").datagrid("reload")//刷新表格
                            $('#yclgl_window').window('close');//关闭窗口
                        } else {//失败： 提示错误
                            $.messager.alert('警告', '新增失败！');
                        }
                    }
                });
            }
        }, {
            text: '关闭',
            handler: function () {
                $("#yclgl_info").form()("reset");//清空表单
                $('#yclgl_window').window('close');
            }
        }]
    });
    $('#yclgl_window').window('open');
}

//修改
function updateYclgl() {
    var row = $("#yclgl").datagrid("getSelected");
    if (row) {
        openUpdateYclgl(row);
    } else {
        $.messager.alert('提示', '请选择你要修改的工程！');
    }

}

//修改原材料入库信息
function openUpdateYclgl(row) {
    $('#yclgl_window').dialog({
        title: '新增原材料',
        width: 400,
        height: 400,
        closed: false,
        cache: false,
        modal: true,
        buttons: [{
            text: '保存',
            handler: function () {
                //1.获取表单中数据
                //2.ajax传递后端
                $('#yclgl_info').form('submit', {
                    url: "/yclrk/update",
                    onSubmit: function (param) {
                        param.yclrk_id = row.yclrk_id;
                        console.log(param)
                        //param.id = 1000;  隐藏参数
                        //验证  return false 阻止表单提交
                    },
                    success: function (data) {
                        //3.回调函数
                        if (data == "true") {//成功: 提示成功
                            $.messager.alert('消息', '新增成功！');
                            $("#").form("reset");//清空表单
                            $("#yclgl").datagrid("reload")//刷新表格
                            $('#yclgl_window').window('close');//关闭窗口
                        } else {//失败： 提示错误
                            $.messager.alert('警告', '新增失败！');
                        }
                    }
                });
            }
        }, {
            text: '关闭',
            handler: function () {
                $("#yclgl_info").form()("reset");//清空表单
                $('#yclgl_window').window('close');
            }
        }]
    });
    //加载表单数据
    $('#yclgl_window').form('load', {
        yclrk_no: row.yclrk_no,
        yclrk_material_name: row.yclrk_material_name,
        khmc_id: row.khmc.khmc_id,
        gcmc_id: row.gcmc.gcmc_id,
        yclrk_team: row.yclrk_team,
        yclrk_checkout: row.yclrk_checkout,
        yclrk_standard_width: row.yclrk_standard_height,
        yclrk_standard_height: row.yclrk_standard_width,
        yclrk_time: row.yclrk_time,
        yclrk_amount: row.yclrk_amount,
        yclrk_shelves: "否",
    });
    $('#yclgl_window').window('open');
}

//删除

function deleteYclgl(yclrk_id) {
    var ids = [];//删除的gcmc_ids数组
    if (yclrk_id) {//单个id
        ids.push(yclrk_id);
    } else {//批量
        var rows = $("#yclgl").datagrid("getSelections");
        if (rows && rows.length > 0) {
            $(rows).each(function (i, o) {
                ids.push(o.yclrk_id);
            });
        }
    }
    if (ids.length == 0) {
        $.messager.alert('提示', '请选择你要删除的工程！');
        return;
    }
    $.messager.confirm('确认', '您确认想要删除记录吗？', function (r) {
        $.post("/yclrk/delete", {"ids": ids}, function (data) {
            if (data == true) {
                $.messager.alert('消息', '删除成功！');
                $("#yclgl").datagrid("reload")//刷新表格
            } else {
                $.messager.alert('警告', '删除失败！');
            }
        })
    });
}

//搜索原材料入库信息
function query(value, name) {
    var json = {};
    json[name] = value;
    $('#yclgl').datagrid({
        queryParams: json,
        url: "/yclrk/getYclrk"
    });
}


