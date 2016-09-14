$(document).ready(function(){

    var level, timer1, timer2, timer3;
    var $all=$('.all');
    var $ghost=$('#ghost');
    var $monster=$('#monster');
    var $scarab=$('#scarab');
    var $helperbone=$('#helperbone');
    var $button=$('#button');
    var $ask=$('#ask');
    var $ask2=$('#ask2');
    var $table=$('.ask');
    var $buttonno=$('#buttonno');
    var $timer=$('#timer');
    var $torch=$('#torch');
    var $window=$(window);
    var sec=40;
    var ret='false';

    $ghost.attr('src',GHOSTPIC);
    $scarab.attr('src',SCARABPIC);
    $monster.attr('src',MONSTERPIC);
    $helperbone.attr('src',HELPERBONE);
    $torch.attr('src',TORCH[0]);

    $(window).ready(function(){

        level=1;
        $table.show();
        $all.css('background','url('+FON[level-1]+')');
        $all.css('background-size','contain');
        $all.css('background-repeat','no-repeat');
        $ask2.html('Welcome to the game!');
        $ask.html(NOTES[0]);
    });

    var hideskull=function(){
        clearInterval(timer);
        $helperbone.animate({
            bottom:'-100px'
        }, 700);
        setTimeout(function(){
            $helperbone.hide();
            $torch.show();
            var x=1;
            var timer=setInterval(function(){
                $torch.attr('src',TORCH[x]);
                x+=1;
                if (x==2){
                    x=0;
                }
            },500);
            $helperbone.hide();
        }, 700);
    };
    var showskull=function(){
        $torch.hide();
        $helperbone.show();
        $helperbone.animate({
            bottom:'0px'
        }, 700);
    };
    
    $table.click(function(){
        $table.hide();
        if(level==1){
            timer();
            $ghost.show();
            start();
        }else if(level==2){
            $ghost.show();
            $scarab.show();
            start();
        }else if(level==3){
            $ghost.show();
            $monster.show();
            start();
        }else if(level=='lose'){
            $timer.show();
            $table.hide();
            $ghost.show();
            $buttonno.hide();
            level=1;
            ret='false';
            start();
            timer();
            sec=40;
        }else if(level=='win'){
            $table.hide();
            $ghost.show();
            $buttonno.hide();
            level=1;
            ret='false';
            $timer.show();
            start();
            timer();
            sec=40;
        }
        hideskull();
    });

    $buttonno.click(function(){
        clearTimeout(timeroftimers);
        $timer.html('Time: 0');
        $ask2.html('');
        $ask.html('Well played! See you later');
        $button.hide();
        $buttonno.hide();
    });

    function start(){

        //Ghost

        $ghost.css('left',$window.width()/2);
        $ghost.css('top',$window.height()/2);

        //Monster

        $monster.css('left',$window.width()/2);
        $monster.css('top',$window.height()/2);

        //Scarab

        $scarab.css('left',$window.width()/2);
        $scarab.css('top',$window.height()/2);

        var srcwid=$window.width()/2.2;
        var srchei=$window.height()/1.1;

        var op=(Math.random()*0.9)+0.1;
        var mleft=Math.floor(Math.random()*$window.width()/2)-$window.width()/4;
        var mtop=Math.floor(Math.random()*$window.height()/2)+$window.height()/4;
        $ghost.animate({left: srcwid+mleft, top: srchei-mtop, opacity: op},1000);

        if(level==1){
            timer1 = setInterval(function(){
                var op=(Math.random()*0.9)+0.1;
                mleft=Math.floor(Math.random()*$window.width()/2)-$window.width()/4;
                mtop=Math.floor(Math.random()*$window.height()/2)+$window.height()/4;
                $ghost.animate({left: srcwid+mleft, top: srchei-mtop, opacity: op},1000);
            }, 1000);
        } else if(level==2){

            mleft=Math.floor(Math.random()*$window.width()/2)-$window.width()/4;
            mtop=Math.floor(Math.random()*$window.height()/2)+$window.height()/4;
            $scarab.animate({left: srcwid+mleft, top: srchei-mtop},800);

            timer1 = setInterval(function(){
                var op=(Math.random()*0.9)+0.1;
                mleft=Math.floor(Math.random()*$window.width()/2)-$window.width()/4;
                mtop=Math.floor(Math.random()*$window.height()/2)+$window.height()/4;
                $ghost.animate({left: srcwid+mleft, top: srchei-mtop, opacity: op},400);
            }, 400);
            timer2 = setInterval(function(){
                mleft=Math.floor(Math.random()*$window.width()/2)-$window.width()/4;
                mtop=Math.floor(Math.random()*$window.height()/2)+$window.height()/4;
                $scarab.animate({left: srcwid+mleft, top: srchei-mtop},800);
            }, 800);
        } else if(level==3){

            mleft=Math.floor(Math.random()*$window.width()/2)-$window.width()/4;
            mtop=Math.floor(Math.random()*$window.height()/2)+$window.height()/4;
            $monster.animate({left: srcwid+mleft, top: srchei-mtop},500);

            timer1 = setInterval(function(){
                op=(Math.random()*0.9)+0.1;
                mleft=Math.floor(Math.random()*$window.width()/2)-$window.width()/4;
                mtop=Math.floor(Math.random()*$window.height()/2)+$window.height()/4;
                $ghost.animate({left: srcwid+mleft, top: srchei-mtop, opacity: op},500);
            }, 500);
            timer3 = setInterval(function(){
                mleft=Math.floor(Math.random()*$window.width()/2)-$window.width()/4;
                mtop=Math.floor(Math.random()*$window.height()/2)+$window.height()/4;
                $monster.animate({left: srcwid+mleft, top: srchei-mtop},500);
            }, 500);
        }
    }

    $ghost.click(function(){
        $all.css('background','url('+FON[level-1]+')' );
        $all.css('background-size','contain');
        $all.css('background-repeat','no-repeat');

        $ghost.hide();
        clearInterval(timer1);
        if(level==1){
            setTimeout(function(){
                $table.show();
                showskull();
                $ask2.html('Level 2');
                $ask.html(NOTES[1]);
            }, 500);
            level=2;
        }else if(level==2){
            clearInterval(timer2);
            $scarab.hide();
            setTimeout(function(){
                $table.show();
                showskull();
                $ask2.html('Level 3');
                $ask.html(NOTES[2]);
            }, 500);
            level=3;
        }else if(level==3){
            clearInterval(timer3);
            $monster.hide();
            setTimeout(function(){
                $table.show();
                showskull();
                level='win';
                ret='true';
                $ask.html('Your time: '+(40-sec)+"<br/>Tap to restart");
                $ask2.html(NOTES[4]);
                $timer.hide();
            }, 500);
            level='end';
        }
    });

    $monster.click(function(){
        clearInterval(timer1);
        clearInterval(timer2);
        clearInterval(timer3);
        level='lose';
        $ghost.hide();
        $monster.hide();
        $timer.hide();
        setTimeout(function(){
            $table.show();
            $buttonno.show();
            showskull();
            ret='true';
            $ask2.html(NOTES[3]);
            $ask.html('Restart?');
        }, 500);
    });

    $scarab.click(function(){
        clearInterval(timer1);
        clearInterval(timer2);
        $scarab.hide();

        $ghost.css('left',$window.width()/2);
        $ghost.css('top',$window.height()/2);

        var srcwid=$window.width()/2.2;
        var srchei=$window.height()/1.1;

        timer1 = setInterval(function(){
            var op=(Math.random()*0.9)+0.1;
            var mleft=Math.floor(Math.random()*$window.width()/2)-$window.width()/4;
            var mtop=Math.floor(Math.random()*$window.height()/2)+$window.height()/4;
            $ghost.animate({left: srcwid+mleft, top: srchei-mtop, opacity: op},1000);
        }, 1000);
    });

    function timer(){
        sec=sec-1;
        $timer.html('Time: '+sec);
        if(sec==0 && (level!='lose' || level!='end')){
            clearInterval(timer1);
            clearInterval(timer2);
            clearInterval(timer3);
            $table.show();
            showskull();
            $ask2.html('');
            ret='true';
            sec=40;
            $ask2.html('Timeout, you lose.');
            $ask.html('Restart?');
            level = 1;
            $button.show();
            $buttonno.hide();
        }
        if(ret=='true'){
            return;
        }
        setTimeout(timer,1000);
    }
});
