import $ from 'jquery'
import './jquery.blockUI.min'
function show () {
    $.blockUI({
      message: '<img src="/static/image/loading.gif" />',
      css: {
        zIndex: "10011",
        padding: "10px",
        left: "50%",
        width: "80px",
        marginLeft: "-40px",
      }
    });
  }
  function  hide() {
    // 本地查询速度太快，loading显示一瞬间，故意做个延迟
    setTimeout(function () {
      $.unblockUI();
    }, 500)
  }
export{
show,
  hide
}
