function init()
{
    // ID の登録
    // ID はクヲートで括り、複数指定は , コンマで区切る
    var idList = new Array(
        "sample"
    );

    // 動くスピード　（　1000 = 1秒 ）
    var intervalTime = 20;
    
    // 動かす幅 （ 単位 = ピクセル ）
    var directLength = 5;

    // ----- 以下プログラム ------ //
    
    
    if (!(document.getElementById || document.all) ||
        (document.body && document.body.style.overflow == undefined)) return ; 
    var o, oList = new Array();

    for (var i in idList)
    {
        o = document[document.all ? "all": "getElementById"](idList[i]);
        oList[idList[i]] = {
            obj     : o, 
            height  : o.offsetHeight,
            width   : o.offsetWidth,
            flag    : false
        };
        with (o.style)
        {   
            width =
            height = "1px";
            visibility =
            overflow = "hidden"
        }
    }

    opnClz = function (_oId, _direc, _oX, _oY)
    {
        if ((_oId = oList[_oId]))
        {
            with(_oId.obj.style)
            {
                visibility = "visible";
                if (_direc == "x") height = _oId.height+ "px";
                else width = _oId.width+ "px";
                
                if (_oX && _oY)
                {
                    position = "absolute";
                    top  = _oY;
                    left = _oX;
                }
            }
            _oId.direc = _direc == "x"? "width": "height";
            
            if (_oId.timeId)
            {
                clearInterval(_oId.timeId);
                _oId.flag = !_oId.flag;
            }
            else
                _oId.len = _oId.flag? _oId[_oId.direc] : 0;
           
            var drcLen = _oId.flag? Math.round(directLength* 2)* -1 : directLength;
            
            var opcz = function()
            {
                _oId.len += drcLen;
                
                if (_oId[_oId.direc] > _oId.len && _oId.len > 0)
                {
                    _oId.obj.style[_oId.direc] = _oId.len+ "px";
                }
                else
                {   
                    _oId.obj.style[_oId.direc] = (!_oId.flag ? _oId[_oId.direc] :1)+ "px";
                    if (_oId.flag) with(_oId.obj.style)
                    {
                        width  = 
                        height = "1px";
                        visibility = "hidden";
                    }
                    _oId.flag = !_oId.flag;
                    _oId.timeId = clearInterval(_oId.timeId);
                }
            } // END opcz()

            _oId.timeId = setInterval(opcz, intervalTime);
        }
    } // END opnClz()
}

function opnClz(){};



//onload = init;
init();
/* _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/ 

もしページ読み込み完了後をきらうなら

onload = init;

を消して

init();

とする。
こうすることで読み込みを待たずスグに反映される。

_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/ */