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

