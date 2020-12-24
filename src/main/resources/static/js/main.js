loadBefore();
$(function () {
    initLeftMenus();
})

//过程动画
function loadBefore() {
    var width = $(window).width();
    var height = $(window).height();
    var html = "<div id='loading' style='position:absolute;left:0;width:100%;height:" + height + "px;top:0;background:#E0ECFF;opacity:1;filter:alpha(opacity=100);'>" +
        "<div style='position:absolute;cursor1:wait;left:" + ((width / 2) - 75) + "px;top:200px;width:150px;height:16px;padding:12px 5px 10px 30px;" +
        "background:#fff url('/easyui/themes/default/images/loading.gif') no-repeat scroll 5px 10px;border:2px solid #ccc;color:#000;'>" +
        "正在加载，请等待..." +
        "</div>" +
        "</div>";
    window.onload = function () {
        var mask = document.getElementById('loading');
        mask.parentNode.removeChild(mask);
    };
    document.write(html);
}

function initLeftMenus() {
    //向后台请求数据
    $.getJSON("/index/getAll", null, function (data) {
        loadMenus(data);
    })


}

function loadMenus(data) {
    $(data).each(function (i, o) {
        var chidrens = "<ul>"
        $(o.chidrens).each(function (k, j) {
            chidrens += "<li><div><a onClick='openPage(this)' rel='" + j.url + "'>" +
                "<span class='" + j.icon + "'>&nbsp;&nbsp;</span>" + j.menuname
                + "</a></div></li>";
        })
        chidrens += "</ul>";
        $('#main_menus').accordion('add', {
            title: o.menuname,
            content: chidrens,
            selected: false
        });
        $('#main_menus').accordion("select", 0);
    })

}

//打开选项卡
function openPage(obj) {
    var title = $(obj).text();
    var url = $(obj).attr("rel");
    if ($("#main_tabs").tabs("exists", title)) {//已存在
        $("#main_tabs").tabs("select", title);
    } else {//不存在
        //新增选项卡
        $('#main_tabs').tabs('add', {
            title: title,
            href: url,
            closable: true,
            tools: [{
                iconCls: 'icon-mini-refresh',
                handler: function () {
                    alert('refresh');
                }
            }]
        });
    }
}

//json转换treeJson
function convertTreeJson(rows) {
    var treeJson = [];//树形菜单数据
    //得到根节点
    for (var i = 0; i < rows.length; i++) {
        var row = rows[i];//每一个节点
        if (!exists(rows, row.parentId)) {
            treeJson.push({"id": row.id, "text": row.text, "state": row.state});
        }
    }
    //操作children
    var parentJson = [];
    for (var i = 0; i < treeJson.length; i++) {
        parentJson.push(treeJson[i]);
    }
    while (parentJson.length) {
        var sonJson = parentJson.shift();// 得到父节点
        //得到子节点
        for (var i = 0; i < rows.length; i++) {
            var row = rows[i];
            if (row.parentId == sonJson.id) {
                var child = {id: row.id, text: row.text};
                if (sonJson.children) {
                    sonJson.children.push(child);
                } else {//第一次添加子节点
                    sonJson.children = [child];
                }
                parentJson.push(child);
            }
        }
    }
    return treeJson;
}

//通过判断id是否和父id相同
function exists(rows, parentId) {
    for (var i = 0; i < rows.length; i++) {
        if (rows[i].id == parentId) {
            return true;
        }
    }
    return false;
}
