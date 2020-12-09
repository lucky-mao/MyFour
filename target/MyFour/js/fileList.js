//时间范围
layui.use('laydate', function() {
    var laydate = layui.laydate;
    //日期范围
    laydate.render({
        elem: '#test6'
        ,range: true
    });
});
layui.use('table', function() {
    var table = layui.table;

    table.render({
        elem: '#test'
        , url: '/test/table/demo1.json'
        , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        , defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
            title: '提示'
            , layEvent: 'LAYTABLE_TIPS'
            , icon: 'layui-icon-tips'
        }]
        , title: '用户数据表'
        , cols: [[
            {type: 'checkbox', fixed: 'left'}
            , {field: 'username', title: '用户名', width: 120, edit: 'text'}
            , {field: 'joinTime', title: '注册时间', width: 120}
            , {field: 'experience', title: '积分', width: 80, sort: true}
            , {field: 'upload', title: '上传文档数', width: 200, sort: true}
            , {field: 'download', title: '下载文档数', width: 200, sort: true}
            , {field: 'state', title: '用户状态', width: 150, sort: true}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150}
        ]]
        , page: true
    });

    //头工具栏事件
    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        switch(obj.event){
            case 'getCheckData':
                var data = checkStatus.data;
                layer.alert(JSON.stringify(data));
                break;
            case 'getCheckLength':
                var data = checkStatus.data;
                layer.msg('选中了：'+ data.length + ' 个');
                break;
            case 'isAll':
                layer.msg(checkStatus.isAll ? '全选': '未全选');
                break;

            //自定义头工具栏右侧图标 - 提示
            case 'LAYTABLE_TIPS':
                layer.alert('这是工具栏右侧自定义的一个图标按钮');
                break;
        };
    });
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#test'
            ,url:'/test/table/demo1.json'
            ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                title: '提示'
                ,layEvent: 'LAYTABLE_TIPS'
                ,icon: 'layui-icon-tips'
            }]
            ,title: '用户数据表'
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                , {field: 'username', title: '用户名', width: 120, edit: 'text'}
                , {field: 'joinTime', title: '注册时间', width: 120}
                , {field: 'experience', title: '积分', width: 80, sort: true}
                , {field: 'upload', title: '上传文档数', width: 200, sort: true}
                , {field: 'download', title: '下载文档数', width: 200, sort: true}
                , {field: 'state', title: '用户状态', width: 150, sort: true}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150}
            ]]
            ,page: true
        });

        //头工具栏事件
        table.on('toolbar(test)', function(obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'getCheckData':
                    var data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：' + data.length + ' 个');
                    break;
                case 'isAll':
                    layer.msg(checkStatus.isAll ? '全选' : '未全选');
                    break;

                //自定义头工具栏右侧图标 - 提示
                case 'LAYTABLE_TIPS':
                    layer.alert('这是工具栏右侧自定义的一个图标按钮');
                    break;
            };
        });
        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
                layer.prompt({
                    formType: 2
                    ,value: data.email
                }, function(value, index){
                    obj.update({
                        email: value
                    });
                    layer.close(index);
                });
            }
        });
    });
});
layui.use('table', function(){
    var table = layui.table;

    //方法级渲染
    table.render({
        elem: '#LAY_table_user'
        ,url: '/demo/table/user/'
        ,cols: [[
            {checkbox: true, fixed: true}
            , {field: 'username', title: '用户名', width: 120, edit: 'text'}
            , {field: 'joinTime', title: '注册时间', width: 120}
            , {field: 'experience', title: '积分', width: 80, sort: true}
            , {field: 'upload', title: '上传文档数', width: 200, sort: true}
            , {field: 'download', title: '下载文档数', width: 200, sort: true}
            , {field: 'state', title: '用户状态', width: 150, sort: true}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150}
        ]]
        ,id: 'testReload'
        ,page: true
        ,height: 310
    });

    var $ = layui.$, active = {
        reload: function(){
            var demoReload = $('#demoReload');

            //执行重载
            table.reload('testReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {
                    key: {
                        id: demoReload.val()
                    }
                }
            }, 'data');
        }
    };

    $('.demoTable .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
});
