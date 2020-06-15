
google.charts.load('current', {packages: ['corechart', 'line']});
google.charts.setOnLoadCallback(drawBasic);

    function drawBasic() {
        var overdueSummaryUrl = getBaseUrl()+'statistics/overdue/summary';
        $.get( overdueSummaryUrl, function( overdueSummaryData ) {

            var data = new google.visualization.DataTable();
            data.addColumn('date', 'Fecha');
            data.addColumn('number', 'Monto en Mora');

                var result = [];
                for(var i = 0; i< overdueSummaryData.length;i++ ){
                    var dateSplit =  overdueSummaryData[i].date.split("-");
                    var summDate = new Date();
                    summDate.setFullYear(dateSplit[0],dateSplit[1]-1,dateSplit[2]);
                    result.push([summDate,overdueSummaryData[i].amount]);
                }

                data.addRows(result);

            var options = {
                hAxis: {
                    title: 'Fecha',
                    slantedText:true,
                    slantedTextAngle: 45,
                    showTextEvery:2
                },
                vAxis: {
                    title: 'Monto en Mora'
                },
                pointSize:5
            };

            var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
            chart.draw(data, options);

        });
    }

