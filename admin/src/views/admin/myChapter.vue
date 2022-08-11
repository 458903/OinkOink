<template>
    <div>
    <table id="simple-table" class="table  table-bordered table-hover">
        <thead>
                <tr>
                    <th>ID</th>
                    <th>名称</th>
                    <th>课程ID</th>
                    <th>操作</th>
                </tr>
        </thead>

        <tbody>
        <tr v-for="chapter in chapters" :key="chapter.id">
            <td>{{chapter.id}}</td>
            <td>{{chapter.name}}</td>
            <td>{{chapter.courseId}}</td>
            <td>
                <div class="hidden-sm hidden-xs btn-group">
                    <button class="btn btn-xs btn-purple" data-toggle="modal" data-target="#myModel">
                        <i class="ace-icon fa fa-pencil bigger-120"></i>
                    </button>
                    <button v-on:click="del(chapter.id)" class="btn btn-xs btn-pink">
                        <i class="ace-icon fa fa-trash-o bigger-120"></i>
                    </button>

                </div>
            </td>
        </tr>
          </tbody>
    </table>

        <myPagination ref="pagination" v-bind:list="list" ></myPagination>
        <p>
            <button v-on:click="list(1)" class="btn btn-pink">
                <i class="ace-icon fa fa-refresh"></i>
                刷新
            </button>&nbsp;
            <!-- 按钮触发模态框 -->
            <button class="btn btn-purple" data-toggle="modal" data-target="#myModel">
                <i class="ace-icon fa fa-user"></i>
                新增</button>

        </p>
        <!-- 模态框（Modal1） -->
        <div class="modal fade" id="myModel" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">
                            <i class="ace-icon fa fa-spinner fa-spin orange bigger-125"></i>
                            新增课程</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">
                                    <i class="ace-icon fa fa-calendar smaller-90"></i>
                                    名称</label>
                                <div class="col-sm-10">
                                    <input v-model="chapter.name" class="form-control"  placeholder="名称">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">
                                    <i class="ace-icon fa fa-calendar-o smaller-90"></i>
                                    课程ID</label>
                                <div class="col-sm-10">
                                    <input v-model="chapter.courseId" class="form-control"  placeholder="课程ID">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-purple" data-dismiss="modal">
                            <i class="ace-icon fa fa-unlock"></i>
                            关闭</button>
                        <button v-on:click="save()" type="button" class="btn btn-pink">
                            <i class="ace-icon fa fa-leaf"></i>
                            保存</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div>
    </div>
</template>

<script>

  //import $ from  'bootstrap/dist/js/bootstrap.js'
  import myPagination from "@/components/pagination";
  import Swal from 'sweetalert2';

    export default {
        components: {myPagination},
        component: 'myChapter',
        data:function(){
            return{
                content:{},
                chapter:{},
                chapters:[]
            }
        },
        mounted:function() {
            let _this=this;
            _this.list(1);
            //this.$parent.activeSidebar("business-chapter-sidebar");
        },
        methods:{
            list(page){
                let _this=this;
              //  let url ='http://127.0.0.1:9000/business/admin/chapter/list';
              //  url +='?page=${page}&size=_this.$refs.pagination.size';
                    _this.$ajax.get('http://127.0.0.1:9000/business/admin/chapter/list',{
                        params: {
                            page:page,
                            size: _this.$refs.pagination.size
                        }
                    }
                   ,{emulateJSON: true}
                    )
                        .then((response) => {
                                //response.headers("Access-Control-Allow-Origin","*")
                                console.log("查询章列表结果：", response);
                                _this.chapters = response.data.content.list;
                                _this.$refs.pagination.render(page,response.data.content.total)
                            }
                        );
            }  ,
            save(){
                let _this=this;
                _this.$ajax.get('http://127.0.0.1:9000/business/admin/chapter/save',{
                        params: {
                            name:_this.chapter.name,
                          courseId: _this.chapter.courseId
                        }},{emulateJSON: true}
                ).then((response) => {console.log("查询章列表结果：", response);
                    Swal.fire({
                        position: 'top-end',
                        icon: 'success',
                        title: 'Your work has been saved',
                        showConfirmButton: false,
                        timer: 1500
                    })
                })
            },
            del(id){
                let _this=this;
                Swal.fire({
                    title: '确定要删除吗?',
                    text: "注意，删除后不可恢复!",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#FFB6C1',
                    cancelButtonColor: '#BA55D3',
                    confirmButtonText: '确认!'
                }).then((result) => {
                    if (result.isConfirmed) {
                        _this.$ajax.get('http://127.0.0.1:9000/business/admin/chapter/delete/'+id,{emulateJSON: true}
                        ).then((response) => {console.log("删除章列表结果：", response);
                            /*Swal.fire(
                                '删除成功!',
                                '您的数据已删除.',
                                'success'
                            );*/
                            Swal.fire({
                                title: '删除成功',
                                showClass: {
                                    popup: 'animate__animated animate__fadeInDown'
                                },
                                hideClass: {
                                    popup: 'animate__animated animate__fadeOutUp'
                                }
                            })
                        })
                    }
                })



            }
               }
            }
</script>