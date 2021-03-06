layui.define(['table', 'form'], function (exports) {
    let $ = layui.$
        , admin = layui.admin
        , view = layui.view
        , table = layui.table
        , form = layui.form;

    table.render({
        elem: '#table-role-list'
        , url: './role/list'
        , toolbar: '#table-role-header-tpl'
        , defaultToolbar: []
        , cols: [[
            {field: 'roleId', width: 80, title: 'ID'}
            , {field: 'roleName', title: '角色'}
            , {field: 'roleSign', title: '标识'}
            , {field: 'description', title: '描述'}
            , {title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#table-role-list-tool'}
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
    table.on('toolbar(table-role-list-filter)', function (data) {
        if (data.event === 'add') {
            event.add()
        }
    });

    //监听表格列工具条
    table.on('tool(table-role-list-filter)', function (data) {
        console.log(data)
        if (data.event === 'edit') {
            event.edit(data)
        } else if (data.event === 'disable') {
            event.disable(data)
        } else if (data.event === 'enable') {
            event.enable(data)
        }
    });

    let event = {
        add: function () {
            admin.popup({
                title: '添加角色'
                , area: ['500px', '480px']
                , id: 'popup-user-role-add'
                , success: function (layero, index) {
                    view(this.id).render('user/role/add', {_popup: index}).done(function () {
                        form.render(null, 'role-form');
                    })
                }
            });
        },
        disable: function (data) {
            // 更新状态后，可在界面不刷新的情况下，更新修改的这一行，table模块提供了update方法，但不支持通过tool生成的列
            $.ajax({
                type: 'post'
                , url: '/role/disable'
                , data: {
                    roleId: data.data.roleId
                }
                , dataType: 'json'
                , success: function (response) {
                    table.reload('table-role-list');
                }
                , error: function (error, code) {

                }
            })
        },
        enable: function (data) {
            $.ajax({
                type: 'post'
                , url: '/role/enable'
                , data: {
                    roleId: data.data.roleId
                }
                , dataType: 'json'
                , success: function (response) {
                    table.reload('table-role-list');
                }
                , error: function (error, code) {

                }
            })
        },
        edit: function (data) {
            admin.popup({
                title: '编辑角色'
                , area: ['500px', '480px']
                , id: 'popup-user-role-add'
                , success: function (layero, index) {
                    view(this.id).render('user/role/add', $.extend(data.data, {_popup: index})).done(function () {
                        form.render(null, 'role-form');
                    })
                }
            });
        },
        save: function (data, callback) {
            let url = '/role/edit'
            if (!data.roleId) {
                url = '/role/add'
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
        }
    }

    exports('role', {
        event: event
    })
});