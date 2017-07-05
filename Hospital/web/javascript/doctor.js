var yesPicture = '<img width="30px;" src="/Hospital/image/yes.png">';
var noPicture = '<img width="30px;" src="/Hospital/image/no.png">';
var isPassPatientName=false;
var isPassTime=false;

var year;
var month;
var day;
var startTime;
var endTime;


$.getScript('http://php.weather.sina.com.cn/iframe/index/w_cl.php?code=js&day=1&city=&dfc=1&charset=utf-8',
    function (a) {
        var s = "", r = "", q = "";
        for (s in window.SWther.w) {
            q = SWther.w[s][0];
            r = {
                city: s,
                date: SWther.add.now.split(" ")[0] || "",
                day_weather: q.s1,
                night_weather: q.s2,
                day_temp: q.t1,
                night_temp: q.t2,
                day_wind: q.p1,
                night_wind: q.p2
            }
            $("#city").text(r.city);
            $("#temp").text(r.night_temp + '°C~' + r.day_temp + '°C');
            $("#weather").text(r.day_weather + '/' + r.night_weather);
            $("#date").text(r.date);
        }
    });


$(document).ready(function () {
    $('#patientId').change(function () {
        isPassPatientName=false;
        var patientId = $('#patientId').val();
        if (!isNaN(patientId)) {
            $.post("appointmentGetPatientName.do", {'patientId': patientId}, function (data, status) {
                if(data!='findNamefailure') {
                    $('#patientName').html(data+yesPicture);
                    isPassPatientName=true;
                }else {
                    $('#patientName').html('不存在此病人id'+noPicture);
                }
            })
        } else {
            $('#patientName').html('请输入数字'+noPicture);
        }
    })

    $('#startTime').change(timeChange);
    $('#year').change(timeChange);
    $('#month').change(timeChange);
    $('#day').change(timeChange);
    $('#endTime').change(timeChange);

    $('#chooseNurse').click(function () {
        var nurseId=$('#nurse').val();
        var nuresText = $('#nurse [value='+nurseId+']').text();
        if(nurseId==-1) {
            alert('你还没选择护士！');
        }else if($('#nurses [chooseNurseId=' + nurseId + ']').length>=1){
            alert('你已经选择了该护士！');
        }else {
            var string = '<div style="font-size:15px; margin: 2px;" chooseNurseId='+nurseId+'>'+nuresText+'   <button onclick="removeNurse('+nurseId+')" type="button" class="btn btn-info btn-sm">删除</button></div> ';
            $('#nurses').append(string);
        }
    })

    $('#appointment').click(function () {

        var operationName = $('#operationName').val();
        var operationRoom = $('#operationRoom').val();
        var patient = $('#patientId').val();
        var analgesist = $('#analgesist').val();
        var nurses = $('#nurses div');
        var doctor = $('#doctor').attr('doctor-id');

        if(isPassPatientName&&year!=-1&&month!=-1&&day!=-1&&startTime!=-1&&endTime!=-1&&nurses.length>0&&operationRoom!=-1&&analgesist!=-1&&operationName!='') {
            // alert('appointment!');
            var info = new Object();
            var array = new Array();

            nurses.each(function () {
                array.push($(this).attr('chooseNurseId'));
            })

            info.operationName=operationName;
            info.doctor=doctor;
            info.patient=patient;
            info.date=year+'年'+month+'月'+day+'日';
            info.startTime=startTime;
            info.endTime=endTime;
            info.operationRoom=operationRoom;
            info.analgesist=analgesist;
            info.nurses=array;

            $.post("appointmentSubmit.do",{'info':JSON.stringify(info)},function (data,status) {
                if(data=='success'&&status=='success') {
                    alert('手术预约成功！');
                    window.location.reload();
                }else{
                    alert('预约失败！');
                }
            })
        }else {
            alert('请填好完整信息！');
        }
    })
});



function timeChange() {

    year=$('#year').val();
    month=$('#month').val();
    day=$('#day').val();
    startTime=$('#startTime').val();
    endTime=$('#endTime').val();
    isPassTime=false;

    if(year==-1||month==-1||day==-1||startTime==-1||endTime==-1){
        $('#endTimeNotice').html('请选择完整时间'+noPicture);
        timeChangeReset();
    }else if(Number(endTime)<=Number(startTime)){
        $('#endTimeNotice').html('时间选择错误'+noPicture);
        timeChangeReset();
    }else {
        $.post("judgeDoctorTime.do",{'date':year+'年'+month+'月'+day+'日','startTime':startTime,'endTime':endTime},function (data,status) {
            if(data=='success'&&status=='success') {
                $('#endTimeNotice').html(yesPicture);
                appointmentTimeChange();
            }else{
                $('#endTimeNotice').html('此时间段手术冲突'+noPicture);
                timeChangeReset();
            }
        })
    }
}

function appointmentTimeChange() {
    $.post("appointmentTimeChange.do",{'date':year+'年'+month+'月'+day+'日','startTime':startTime,'endTime':endTime},function (data,status) {
        if(data!='failure'&&status=='success') {
            var dataObj = eval("(" + data + ")");
            var operatioinString =  '<option value="-1">请选择</option>';
            var analgesistString =  '<option value="-1">请选择</option>';
            var nurseString =  '<option value="-1">请选择</option>';

            for (var i = 0; i < dataObj.operationRooms.length; i++) {
                operatioinString = operatioinString +'<option value="'+dataObj.operationRooms[i].id+'">'+dataObj.operationRooms[i].id+'&nbsp;'+dataObj.operationRooms[i].location+'</option>';
            }

            for (var i = 0; i < dataObj.analgesists.length; i++) {
                analgesistString = analgesistString +'<option value="'+dataObj.analgesists[i].id+'">'+dataObj.analgesists[i].id+'&nbsp;'+dataObj.analgesists[i].name+'</option>';
            }

            for (var i = 0; i < dataObj.nurses.length; i++) {
                nurseString = nurseString +'<option value="'+dataObj.nurses[i].id+'">'+dataObj.nurses[i].id+'&nbsp;'+dataObj.nurses[i].name+'</option>';
            }

            $('#operationRoom').html(operatioinString);
            $('#analgesist').html(analgesistString);
            $('#nurse').html(nurseString);
            $('#nurses').empty();
        }
    })
}

function timeChangeReset() {
    $('#operationRoom').html('<option value="-1">未选择</option>');
    $('#analgesist').html('<option value="-1">未选择</option>');
    $('#nurse').html('<option value="-1">未选择</option>');
    $('#nurses').empty();
}


function removeNurse(id) {
    $('#nurses [chooseNurseId=' + id + ']').remove();
}