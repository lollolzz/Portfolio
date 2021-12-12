// index 페이지에 작성하여도 되지만 js폴더 안의 파일을 가져올 수 있는지 확인 하기 위하여 해봄~
 $(function(){

    $('.slider > ul').bxSlider({
        slideWidth: 980,
        pager: false,
        controls: false,
        auto: true
    });

    $('#tabs').tabs();

});