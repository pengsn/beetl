/**
 * 除了首页之外的滚动效果
 */
var width = window.innerWidth || document.body.clientWidth;
var proportion = 1366/width;
var windowTop = 500/proportion;//初始化可视区域距离页面顶端的距离
var navBox=document.getElementById("nav-box");
if(IEVersion() === 9){
    navBox.style.filter="alpha(opacity=100)";
}


//导航菜单滑动事件
$(window).scroll(function () {
    var scrolls = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop ;//获取当前可视区域距离页面顶端的距离
    if (scrolls >= windowTop) {
        if(IEVersion() === 6 || IEVersion() === 7 || IEVersion() === 8) {
            navBox.style.background="rgb(0,57,120)";
            navBox.style.filter="alpha(opacity=80)";
        } else {
            navBox.style.background="rgba(0,57,120,0.8)";
        }
    } else {
        if(IEVersion() === 6 || IEVersion() === 7 || IEVersion() === 8){
            navBox.style.background="rgb(0,57,120)";
            navBox.style.filter="alpha(opacity=50)";
        } else {
            navBox.style.background="rgba(0,57,120,0.2)";
        }
    }
});

// 获取IE版本
function IEVersion() {
    // 取得浏览器的userAgent字符串
    var userAgent = navigator.userAgent;
    // 判断是否为小于IE11的浏览器
    var isLessIE11 = userAgent.indexOf('compatible') > -1 && userAgent.indexOf('MSIE') > -1;
    // 判断是否为IE的Edge浏览器
    var isEdge = userAgent.indexOf('Edge') > -1 && !isLessIE11;
    // 判断是否为IE11浏览器
    var isIE11 = userAgent.indexOf('Trident') > -1 && userAgent.indexOf('rv:11.0') > -1;
    if (isLessIE11) {
        var IEReg = new RegExp('MSIE (\\d+\\.\\d+);');
        // 正则表达式匹配浏览器的userAgent字符串中MSIE后的数字部分，，这一步不可省略！！！
        IEReg.test(userAgent);
        // 取正则表达式中第一个小括号里匹配到的值
        var IEVersionNum = parseFloat(RegExp['$1']);
        if (IEVersionNum === 7) {
            // IE7
            return 7
        } else if (IEVersionNum === 8) {
            // IE8
            return 8
        } else if (IEVersionNum === 9) {
            // IE9
            return 9
        } else if (IEVersionNum === 10) {
            // IE10
            return 10
        } else {
            // IE版本<7
            return 6
        }
    } else if (isEdge) {
        // edge
        return 'edge'
    } else if (isIE11) {
        // IE11
        return 11
    } else {
        // 不是ie浏览器
        return -1
    }
}