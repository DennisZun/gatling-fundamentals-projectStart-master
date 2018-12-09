var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "10",
        "ok": "3",
        "ko": "7"
    },
    "minResponseTime": {
        "total": "7",
        "ok": "7",
        "ko": "8"
    },
    "maxResponseTime": {
        "total": "46",
        "ok": "13",
        "ko": "46"
    },
    "meanResponseTime": {
        "total": "14",
        "ok": "11",
        "ko": "15"
    },
    "standardDeviation": {
        "total": "11",
        "ok": "3",
        "ko": "13"
    },
    "percentiles1": {
        "total": "11",
        "ok": "12",
        "ko": "10"
    },
    "percentiles2": {
        "total": "12",
        "ok": "13",
        "ko": "11"
    },
    "percentiles3": {
        "total": "31",
        "ok": "13",
        "ko": "35"
    },
    "percentiles4": {
        "total": "43",
        "ok": "13",
        "ko": "44"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 3,
        "percentage": 30
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 7,
        "percentage": 70
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "0.909",
        "ok": "0.273",
        "ko": "0.636"
    }
},
contents: {
"req_get-specific-vi-565cd": {
        type: "REQUEST",
        name: "Get specific Video Game",
path: "Get specific Video Game",
pathFormatted: "req_get-specific-vi-565cd",
stats: {
    "name": "Get specific Video Game",
    "numberOfRequests": {
        "total": "10",
        "ok": "3",
        "ko": "7"
    },
    "minResponseTime": {
        "total": "7",
        "ok": "7",
        "ko": "8"
    },
    "maxResponseTime": {
        "total": "46",
        "ok": "13",
        "ko": "46"
    },
    "meanResponseTime": {
        "total": "14",
        "ok": "11",
        "ko": "15"
    },
    "standardDeviation": {
        "total": "11",
        "ok": "3",
        "ko": "13"
    },
    "percentiles1": {
        "total": "11",
        "ok": "12",
        "ko": "10"
    },
    "percentiles2": {
        "total": "12",
        "ok": "13",
        "ko": "11"
    },
    "percentiles3": {
        "total": "31",
        "ok": "13",
        "ko": "35"
    },
    "percentiles4": {
        "total": "43",
        "ok": "13",
        "ko": "44"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 3,
        "percentage": 30
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 7,
        "percentage": 70
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "0.909",
        "ok": "0.273",
        "ko": "0.636"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
