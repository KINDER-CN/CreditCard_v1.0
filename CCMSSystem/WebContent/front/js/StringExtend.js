String.prototype.trimRight = function() {
	return this.replace(/ +$/,"");
}

String.prototype.trimLeft = function() {
	return this.replace(/^ +/,"");
}

String.prototype.trim = function() {
	return this.replace(/(^ +)|( +$)/,"");
}

// 分转成元
String.prototype.toYuan = function() {
    var Value = this.trim();
    if (Value.length == 0)
        return "";
    if (isNaN(Value))
        return "";

    var nYuan = parseInt(Value, 10) / 100;
    Value = nYuan.toString(10);
    var index = Value.lastIndexOf(".");
    if (index == -1)
        return Value + ".00";
    else if (index == Value.length - 1)
        return Value + "00";
    else if (index == Value.length - 2)
        return Value + "0";
    else
        return Value;
}

// 分转成元（带千分位）
String.prototype.toYuanEx = function() {
    var Value = this.toYuan();
    if (Value.length == 0)
        return "";

    for (var Index = Value.lastIndexOf(".") - 3; Index > 0; Index -= 3)
    {
        var v1 = Value.substr(0, Index);
        var v2 = Value.substring(Index);
        Value = v1 + "," + v2;
    }
    return Value;
}

// 元转成分
String.prototype.toFen = function() {
    var Value = this.trim();
    if (Value.length == 0)
        return "";
    if (isNaN(Value))
        return "";

    var nFen = parseFloat(Value) * 100;
    nFen = Math.round(nFen);
    return nFen.toString(10);
}

String.prototype.getDate = function() {
    if (this.length == 8) // YYYYMMDD
    {
        var Year  = this.substring(0, 4).toString(10);
        var Month = this.substring(4, 6).toString(10);
        var Day   = this.substring(6, 8).toString(10);
        return new Date(Year, Month, Day);
    }
    else if (this.length == 10) // YYYY-MM-DD
    {
        var Year  = this.substring(0, 4).toString(10);
        var Month = this.substring(5, 7).toString(10);
        var Day   = this.substring(8, 10).toString(10);
        return new Date(Year, Month, Day);
    }
    else if (this.length == 14) // YYYYMMDDHHMMSS
    {
        var Year   = this.substring(0, 4).toString(10);
        var Month  = this.substring(4, 6).toString(10);
        var Day    = this.substring(6, 8).toString(10);
        var Hour   = this.substring(8,10).toString(10);
        var Minute = this.substring(10,12).toString(10);
        var Second = this.substring(12,14).toString(10);
        return new Date(Year, Month, Day, Hour, Minute, Second);
    }    
    else if (this.length == 19) // YYYY-MM-DD HH:MM:SS
    {
        var Year   = this.substring(0, 4).toString(10);
        var Month  = this.substring(5, 7).toString(10);
        var Day    = this.substring(8, 10).toString(10);
        var Hour   = this.substring(11,13).toString(10);
        var Minute = this.substring(14,16).toString(10);
        var Second = this.substring(17,19).toString(10);
        return new Date(Year, Month, Day, Hour, Minute, Second);
    }
    else
    {
        return null;
    }     
}

// 显示日期(YYYY-MM-DD)
String.prototype.showDate = function() {
    var Value = this.trim();
    if (Value.length < 8)
        return "";
        
    var nYear  = Value.substring(0, 4);
    var nMonth = Value.substring(4, 6);
    var nDay   = Value.substring(6, 8);
    return nYear + "-" + nMonth + "-" + nDay;
}

// 显示日期时间(YYYY-MM-DD HH:MM:SS)
String.prototype.showDateTime = function() {
    var Value = this.trim();
    if (Value.length < 14)
        return "";

    var nYear   = Value.substring(0, 4);
    var nMonth  = Value.substring(4, 6);
    var nDay    = Value.substring(6, 8);
    var nHour   = Value.substring(8, 10);
    var nMinute = Value.substring(10, 12);
    var nSecond = Value.substring(12, 14);
    return nYear + "-" + nMonth + "-" + nDay + " " + nHour + ":" + nMinute + ":" + nSecond;
}

// 是否有效的日期
String.prototype.isValidDate = function() {
    var Value = this.trim();
    if (Value.length != 8)
        return false;

    for (var i = 0; i < 8; i++)
    {
        if((Value.charAt(i) < '0') || (Value.charAt(i) > '9'))
            return false;
    }

    var Year  = Value.substring(0, 4);
    var Month = Value.substring(4, 6);
    var Day   = Value.substring(6, 8);
    if (Month > 12)
        return false;
    if (Day > 31)
        return false;
    if ((Month==4||Month==6||Month==9||Month==11) && (Day>30))
        return false;
    if (Month == 2)
    {
        if (Day > 29)
            return false;
        if((Year%400!=0) && (Year%4!=0 || Year%100==0) && (Day>28))
            return false;
    }

    return true;
}