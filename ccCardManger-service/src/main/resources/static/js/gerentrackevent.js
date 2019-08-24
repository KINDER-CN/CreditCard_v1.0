function buttonEvent(a) {
	try {
		if(typeof window._paq == "undefined") {
			return
		}
		if(a.onclick != null) {
			javascript: _paq.push(["trackEvent", getTrackURl(), getTrackURl() + "_" + a.id, a.innerHTML])
		}
		else {
			javascript: _paq.push(["trackEvent", getTrackURl(), getTrackURl() + "_" + $(a).attr("id"), ($(a).html())])
		}
	} catch(b) {}
}

function selectEvent(a) {
	try {
		if(typeof window._paq == "undefined") {
			return
		}
		javascript: _paq.push(["trackEvent", getTrackURl(), getTrackURl() + "_" + a.id, a[a.selectedIndex].text])
	} catch(b) {}
}

function inputEvent(a) {
	try {
		if(typeof window._paq == "undefined") {
			return
		}
		javascript: _paq.push(["trackEvent", getTrackURl(), getTrackURl() + "_" + a.id, a.value])
	} catch(b) {}
}

function getQueryString(d, b) {
	var c = new RegExp("(\\?|&)" + b + "=([^&]*)(&|$)");
	var a = d.match(c);
	if(a != null) {
		return a[2]
	} else {
		return null
	}
}

function getURlFteWithoutHash() {
	var g = window.location.pathname + window.location.search;
	var d;
	var f = g.indexOf("?");
	var c = getQueryString(g, "pid");
	var b = getQueryString(g, "sid");
	var a = getQueryString(g, "cls");
	if(f != -1) {
		if(c || b || a) {
			d = g.substr(0, f + 1);
			if(c != null) {
				d = d + "pid=" + c
			}
			if(b != null) {
				d = d + "#sid=" + b
			}
			if(a != null) {
				d = d + "#cls=" + a
			}
			var e = new RegExp("([^\\?]+\\?)(#?)(.*)");
			if(d.match(e)[2] !== "") {
				d = d.match(e)[1] + d.match(e)[3]
			}
		} else {
			d = g.substr(0, f)
		}
	} else {
		return g
	}
	return d
}

function getTrackURl() {
	if(window.location.href.indexOf("cfwap") != -1 || window.location.href.indexOf("concreditwap") != -1 || window.location.href.indexOf("lshop") != -1) {
		var customUrl;
		if(typeof(eval(window.wtk.WTKgetEventUrl)) == "function") {
			return window.wtk.WTKgetEventUrl()
		} else {
			var str = getURlFteWithoutHash();
			return str + window.location.hash
		}
	} else {
		var str = getURlFteWithoutHash();
		return str + window.location.hash
	}
}

function sendUrl(a) {
	try {
		if(typeof window._paq == "undefined") {
			return
		}
		_paq.push(["setCustomUrl", a]);
		_paq.push(["trackPageView"])
	} catch(b) {}
}

function buttonEvent_webAnalytics(a) {
	try {
		if(typeof window.WAConst == "undefined") {
			return
		}
		window._iss && _iss.behaviorQueueNew && _iss.behaviorQueueNew({
			type: "custom",
			option: {
				category: getTrackURl(),
				action: getTrackURl() + "_" + a.id,
				optValue: a.innerHTML
			}
		})
	} catch(b) {}
}

function trackEvent_select_webAnalytics(a) {
	try {
		if(typeof window.WAConst == "undefined") {
			return
		}
		window._iss && _iss.behaviorQueueNew && _iss.behaviorQueueNew({
			type: "custom",
			option: {
				category: getTrackURl(),
				action: getTrackURl() + "_" + a.id,
				optValue: a[a.selectedIndex].text
			}
		})
	} catch(b) {}
}

function trackEvent_input_webAnalytics(a) {
	try {
		if(typeof window.WAConst == "undefined") {
			return
		}
		window._iss && _iss.behaviorQueueNew && _iss.behaviorQueueNew({
			type: "custom",
			option: {
				category: getTrackURl(),
				action: getTrackURl() + "_" + a.id,
				optValue: a.value
			}
		})
	} catch(b) {}
};