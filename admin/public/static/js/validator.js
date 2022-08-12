import {warning} from './toast'
import {isLength,isEmpty} from "./tool";

function  quire(value, text) {
    if (isEmpty(value)) {
      warning(text + "不能为空");
      return false;
    } else {
      return true
    }
  }

  function length(value, text, min, max) {
    if (isEmpty(value)) {
      return true;
    }
    if (isLength(value, min, max)) {
     warning(text + "长度" + min + "~" + max + "位");
      return false;
    } else {
      return true
    }
  }
  export {
    quire, length
  }
