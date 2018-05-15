
/*
 * CODIGO JAVASCRIPT PARA MOVIMIENTOS DEL TEMPLATE
 */



function change() {
    const ims = document.querySelectorAll('.ce');
    const im_arr = Array.from(ims);
    let prev = -1;

    if (random_piker(im_arr.length) < im_arr.length) {
        const nuevo = random_piker(im_arr.length);
        if (nuevo !== prev) {
            im_arr[nuevo].innerHTML = `<img src="../style/resources/${random_piker_im(14)}.jpg" alt="food">`;
            prev = nuevo;
        }
    }

}

function random_piker(size) {
    return Math.floor(Math.random() * size);
}

function random_piker_im(size) {
    return Math.floor(Math.random() * size) + 1;
}


setInterval('change();', 2000);






/* JQUERY */




/*+++++++++++++++++++++++++++++++++++*/
/* PARALLAX EFFECT */
/*+++++++++++++++++++++++++++++++++++*/




$(document).ready(function () {

    $(window).scroll(function () {
        parallax( );
    });

    $('.js_sec_2').waypoint(function (direction) {
        if (direction === 'down')
            $('nav').addClass('stick');
        else if (direction === 'up')
            $('nav').removeClass('stick');

    }, {
        offset: '40px;'
    });

    $('a[href*="#"]').click(function (event) {
        if (location.pathname.replace(/^\//, '') === this.pathname.replace(/^\//, '')
                &&
                location.hostname === this.hostname) {
            var target = $(this.hash);
            target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
            if (target.length) {
                event.preventDefault();
                $('html, body').animate({
                    scrollTop: target.offset().top
                }, 1000);
                return false;
            }
        }
    });
    $('.scroll_plan').click(function () {
        $('html, body').animate({scrollTop: $('.js_plan').offset().top}, 1500);
    });
    $('.scroll_sec2').click(function () {
        $('html, body').animate({scrollTop: $('.js_sec_2').offset().top}, 1000);
    });
    $('.js_menu_mobile').click(function () {
        const menu = $('.js_menu_nav');
        const menu_icon = $('.menu_icon');
        menu.slideToggle(200);
        if (menu_icon.hasClass('ion-android-close')) {
            menu_icon.removeClass('ion-android-close');
            menu_icon.addClass('ion-drag');
        } else {
            menu_icon.removeClass('ion-drag');
            menu_icon.addClass('ion-android-close');
        }

    });
});




function parallax( ) {

    const scroll_num = $(window).scrollTop(); // numero que representa el movimeinto de scroll
    const scroll_factor = 0.35;
    const parallax = scroll_num * scroll_factor;

    $(".parallax").css({
        'background-position': 'center ' + (parallax) + 'px'
    });

}
;

