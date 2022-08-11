 import Swal from 'sweetalert2';
const Toast=Swal.fire({
    toast:true,
    position: 'top-end',
    icon: 'success',
    title: 'Your work has been saved',
    showConfirmButton: false,
    timer: 1500
});
 let toast;
 toast={
success:function (message) {
Toast.fire({
    icon: 'success',
    title: 'message',
});

}}