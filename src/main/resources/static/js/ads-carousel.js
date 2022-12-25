let cont = 0;
let xx;
function loopSlider() {
  xx = setInterval(function () {
    switch (cont) {
      case 0: {
        fadeOut(document.querySelector("#slider-1"));
        setTimeout(function () {
            fadeIn(document.querySelector("#slider-2"));
            document.querySelector("#sButton1").classList.remove("bg-purple-800");
            document.querySelector("#sButton2").classList.add("bg-purple-800");
            cont = 1;
        }, 400);
        break;

      }
      case 1: {
        fadeOut(document.querySelector("#slider-2"));
        setTimeout(function () {
            fadeIn(document.querySelector("#slider-1"));
            document.querySelector("#sButton2").classList.remove("bg-purple-800");
            document.querySelector("#sButton1").classList.add("bg-purple-800");
            cont = 0;
        }, 400);

        break;
      }
    }
  }, 8000);
}

function reinitLoop(time) {

  clearInterval(xx);
  setTimeout(loopSlider(), time);
}

function sliderButton1() {
  fadeOut(document.querySelector("#slider-2"));
    setTimeout(function () {
        fadeIn(document.querySelector("#slider-1"));
        document.querySelector("#sButton2").classList.remove("bg-purple-800");
        document.querySelector("#sButton1").classList.add("bg-purple-800");
        reinitLoop(4000);
        cont = 0;
    }, 400);
}

function sliderButton2() {
  fadeOut(document.querySelector("#slider-1"));
  setTimeout(function () {
    fadeIn(document.querySelector("#slider-2"));
    document.querySelector("#sButton1").classList.remove("bg-purple-800");
    document.querySelector("#sButton2").classList.add("bg-purple-800");
    reinitLoop(4000);
    cont = 1;
  }, 400);
}

document.addEventListener("DOMContentLoaded", function () {
    hide(document.querySelector("#slider-2"));
    document.querySelector("#sButton1").classList.add("bg-purple-800");
    
    loopSlider();
});

  function hide(el) {
    el.style.display = 'none';
  }
        // ** FADE OUT FUNCTION **
        function fadeOut(el) {
            el.style.opacity = 1;
            (function fade() {
                if ((el.style.opacity -= .1) < 0) {
                    el.style.display = "none";
                } else {
                    requestAnimationFrame(fade);
                }
            })();
        }

        // ** FADE IN FUNCTION **
        function fadeIn(el, display) {
            el.style.opacity = 0;
            el.style.display = display || "block";
            (function fade() {
                var val = parseFloat(el.style.opacity);
                if (!((val += .1) > 1)) {
                    el.style.opacity = val;
                    requestAnimationFrame(fade);
                }
            })();
        }