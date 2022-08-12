let SESSION_KEY_COURSE;
SESSION_KEY_COURSE = "SESSION_KEY_COURSE"; // 课程管理页面点击章管理时，保存课程信息
let SESSION_KEY_CHAPTER;
SESSION_KEY_CHAPTER = "SESSION_KEY_CHAPTER"; // 章管理页面点击节管理时，保存章信息
let SESSION_KEY_LOGIN_USER;
SESSION_KEY_LOGIN_USER = "SESSION_KEY_LOGIN_USER"; // 登录信息


    function get(key) {
        let v = sessionStorage.getItem(key);
        if (v && typeof(v) !== "undefined" && v !== "undefined") {
            return JSON.parse(v);
        }
    }
     function set(key, data) {
        sessionStorage.setItem(key, JSON.stringify(data));
    }
    function  remove(key) {
        sessionStorage.removeItem(key);
    }
   function clear() {
        sessionStorage.clear();
    }
export {
        clear,remove,get,set,SESSION_KEY_COURSE,SESSION_KEY_CHAPTER,SESSION_KEY_LOGIN_USER
}