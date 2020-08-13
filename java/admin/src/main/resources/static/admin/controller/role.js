layui.define(['table', 'form'], function (exports) {
    let $ = layui.$
        , admin = layui.admin
        , view = layui.view
        , table = layui.table
        , form = layui.form;

    table.render({
        elem: '#user-role-list'
        , url: './role/list'
        , cols: [[
            {field: 'roleId', width: 80, title: 'ID'}
            , {field: 'roleName', title: '角色'}
            , {field: 'roleSign', title: '标识'}
            , {field: 'description', title: '描述'}
            , {title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#tool-user-role-admin'}
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

    //监听工具条
    table.on('tool(user-role-list-filter)', function (btn) {
        let data = btn.data;
        console.log(data)
        if (btn.event === 'edit') {
            event.edit(data)
        } else if (btn.event === 'disable') {
            event.disable(btn, data)
        } else if (btn.event === 'enable') {
            event.enable(btn, data)
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
                        form.render(null, 'user-role-form');
                    })
                }
            });
        },
        disable: function (ele, data) {
            // ele.disable()
            $.ajax({
                type: 'post'
                , url: '/role/disable'
                , data: {
                    roleId: data.roleId
                }
                , dataType: 'json'
                , success: function (response) {
                    table.reload('user-role-list');
                }
                , error: function (error, code) {

                }
            })
        },
        enable: function (ele, data) {
            $.ajax({
                type: 'post'
                , url: '/role/enable'
                , data: {
                    roleId: data.roleId
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
                title: '编辑角色'
                , area: ['500px', '480px']
                , id: 'popup-user-role-add'
                , success: function (layero, index) {
                    view(this.id).render('user/role/add', $.extend(data, {_popup: index})).done(function () {
                        form.render(null, 'user-role-form');
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