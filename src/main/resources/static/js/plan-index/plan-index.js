
    // 分页
    // layui.use(['laypage', 'layer'], function () {
    //     var laypage = layui.laypage
    //         , layer = layui.layer;
    //
    //     //总页数低于页码总数
    //     laypage.render({
    //         elem: 'demo7',
    //         count: 50 //数据总数
    //     });
    //
    //     //总页数大于页码总数
    //     laypage.render({
    //         elem: 'demo7'
    //         , count: 70 //数据总数
    //         , jump: function (obj) {
    //             console.log(obj)
    //         }
    //     });
    //     laypage.render({
    //         elem: 'demo7'
    //         , count: 100
    //         , layout: ['prev', 'page', 'next', 'skip']
    //         , jump: function (obj) {
    //             console.log(obj)
    //         }
    //     });
    //     laypage.render({
    //         elem: 'demo7'
    //         , count: 100
    //         , theme: '#c83939'
    //     });
    // });
// 滚动条
    $(document).ready(function () {

        // $("#page-seek-menu").niceScroll();
        $("#page-seek-menu").niceScroll({
            cursorborder: "1px solid rgb(66, 66, 66)"
        });

        $(".tab-item").mouseover(function(){
            $(".plan-war").removeClass("show-war");
            $(this).addClass("on").siblings().removeClass("on");
        });
        $("#tab-item").mouseenter(function(){
            $(".plan-war").addClass("show-war");
        });
    });

    $("#menu-handler").click(function () {
        // alert("aa")
        $("#page-seek").toggleClass("seek");
        $("#menu-handler").toggleClass("off");
        // $(".page").toggleClass("page-to");
    });
    $(".menu-bd a").click(function () {
        $(this).addClass('active').siblings().removeClass('active');
    });

    $(".ri-info").mouseenter(function(){
        $(".author").css("opacity",1);
        $(".play").css("opacity",1);
    })
    $(".ri-info").mouseleave(function(){
        $(".author").css("opacity",0);
        $(".play").css("opacity",0);
    })

