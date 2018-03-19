

$(document).ready(function () {

    $(window.parent.document).find("#myIframe").load(function(){
        var main = $(window.parent.document).find("#myIframe");
        var thisheight = $(document).height()+30;
        main.height(thisheight);
    });


    var main = $(window.parent.document).find("#operationInfo");
    $.post("/Hospital/getOperationInfo.do",function (data,status) {
        if(data=='havaOperationInfo'&&status=='success') {
            main.text('你有新的手术安排待查看')
        }else {
            main.text('');
        }
    })
})


