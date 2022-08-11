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
                    <button class="btn btn-xs btn-success">
                        <i class="ace-icon fa fa-check bigger-120"></i>
                    </button>

                    <button class="btn btn-xs btn-info">
                        <i class="ace-icon fa fa-pencil bigger-120"></i>
                    </button>

                    <button class="btn btn-xs btn-danger">
                        <i class="ace-icon fa fa-trash-o bigger-120"></i>
                    </button>

                    <button class="btn btn-xs btn-warning">
                        <i class="ace-icon fa fa-flag bigger-120"></i>
                    </button>
                </div>

                <div class="hidden-md hidden-lg">
                    <div class="inline pos-rel">
                        <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown" data-position="auto">
                            <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                        </button>

                        <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                            <li>
                                <a href="#" class="tooltip-info" data-rel="tooltip" title="View">
																			<span class="blue">
																				<i class="ace-icon fa fa-search-plus bigger-120"></i>
																			</span>
                                </a>
                            </li>

                            <li>
                                <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit">
																			<span class="green">
																				<i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																			</span>
                                </a>
                            </li>

                            <li>
                                <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
																			<span class="red">
																				<i class="ace-icon fa fa-trash-o bigger-120"></i>
																			</span>
                                </a>
                            </li>
                        </ul>
                    </div>
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
                        <h4 class="modal-title">新增课程</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">名称</label>
                                <div class="col-sm-10">
                                    <input v-model="chapter.name" class="form-control"  placeholder="名称">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">课程ID</label>
                                <div class="col-sm-10">
                                    <input v-model="chapter.courseId" class="form-control"  placeholder="课程ID">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button v-on:click="save()" type="button" class="btn btn-primary">保存</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div>
    </div>
</template>

<script>
    //import {getCurrentInstance} from 'vue'
    import myPagination from "@/components/pagination";
  //  import myPagination from "../../components/pagination";
    export default {
        components: {myPagination},
        component: 'myChapter',
        data:function(){
            return{
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
                                _this.chapters = response.data.list;
                                _this.$refs.pagination.render(page,response.data.total)
                            }
                        );
            }  ,
            save(){
                let _this=this;
                //  let url ='http://127.0.0.1:9000/business/admin/chapter/list';
                //  url +='?page=${page}&size=_this.$refs.pagination.size';
                _this.$ajax.get('http://127.0.0.1:9000/business/admin/chapter/save',{
                        params: {
                            name:_this.chapter.name,
                          courseId: _this.chapter.courseId
                        }
                    }
                    ,{emulateJSON: true}
                )
                    .then((response) => {

                            console.log("查询章列表结果：", response);

                        }
                    );
            }

        }
    }
</script>