layui.define(['table', 'form'], function (exports) {
    let type = {
        1: '菜单',
        2: '图标',
        3: '图片'
    }
    let $ = layui.$
        , admin = layui.admin
        , view = layui.view
        , table = layui.table
        , form = layui.form;

    table.render({
        elem: '#table-resource-list'
        , url: './resource/list'
        , page: true
        , toolbar: '#table-resource-header-tpl'
        , defaultToolbar: []
        , cols: [[
            {field: 'resourceId', width: 60, title: 'ID'}
            , {field: 'resourceName', title: '名称'}
            , {field: 'resourceSign', title: '标识'}
            , {
                field: 'resourceType', title: '类型', width: 80, templet: function (item) {
                    return type[item.resourceType]
                }
            }
            , {field: 'resourceIcon', title: '图标'}
            , {field: 'resourceUri', title: '地址'}
            , {field: 'resourceOrder', title: '顺序', width: 60}
            , {field: 'parentName', title: '上级'}
            , {title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#table-resource-list-tool'}
        ]]
        , parseData: function (response) {
            return {
                "code": response.status,
                "msg": response.message,
                "count": response.data.length,
                "data": response.data
            };
        }
        , text: '对不起，加载出现异常！'
    });

    // 监听表格顶部工具条
    table.on('toolbar(table-resource-list-filter)', function (data) {
        console.log(data)
        if (data.event === 'add') {
            event.add()
        }
    });

    //监听表格列工具条
    table.on('tool(table-resource-list-filter)', function (data) {
        console.log(data)
        if (data.event === 'edit') {
            event.edit(data)
        } else if (data.event === 'del') {
            event.del(data)
        }
    });

    let event = {
        add: function () {
            admin.popup({
                title: '添加资源'
                , area: ['820px', '580px']
                , id: 'popup-resource-add'
                , success: function (layero, index) {
                    view(this.id).render('user/resource/add', {_popup: index}).done(function () {
                        form.render(null, 'resource-form');
                    })
                }
            });
        },
        del: function (data) {
            // 更新状态后，可在界面不刷新的情况下，更新修改的这一行，table模块提供了update方法，但不支持通过tool生成的列
            $.ajax({
                type: 'post'
                , url: '/role/disable'
                , data: {
                    roleId: data.data.roleId
                }
                , dataType: 'json'
                , success: function (response) {
                    table.reload('user-role-list');
                }
                , error: function (error, code) {

                }
            })
        },
        edit: function (data) {
            admin.popup({
                title: '编辑资源'
                , area: ['820px', '580px']
                , id: 'popup-resource-edit'
                , success: function (layero, index) {
                    view(this.id).render('user/resource/add', $.extend(data.data, {_popup: index})).done(function () {
                        form.render(null, 'resource-form');
                    })
                }
            });
        },
        save: function (data, callback) {
            let url = '/resource/edit'
            if (!data.resourceId) {
                url = '/resource/add'
            }
            $.ajax({
                type: 'post'
                , url: url
                , data: data
                , dataType: 'json'
                , success: function (response) {
                    callback()
                }
                , error: function (error, code) {

                }
            })
        },
        load: function (callback) {
            $.ajax({
                type: 'get'
                , url: '/resource/tree'
                , data: {}
                , dataType: 'json'
                , success: function (response) {
                    console.log(response)
                    let data = response.data
                    data.unshift({
                        id: 0,
                        title: '无'
                    })
                    callback(data)
                }
                , error: function (error, code) {

                }
            })
        }
    }

    exports('resource', {
        type: type,
        event: event
    })
});