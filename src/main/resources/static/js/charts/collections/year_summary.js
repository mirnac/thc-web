google.charts.load('current', {packages: ['corechart', 'bar']});
google.charts.setOnLoadCallback(drawTitleSubtitle);

function drawTitleSubtitle() {

    var interventionsSummaryUrl = getBaseUrl()+'statistics/interventions/summary/year';
    $.get( interventionsSummaryUrl, function( interventionsSummaryData ) {

        var data = new google.visualization.DataTable();

        data.addColumn('string', 'Mes');
        data.addColumn('number', 'Mensajes');
        data.addColumn('number', 'Llamadas/Visitas');

        console.log(interventionsSummaryData);
        var result = [];
        for(var i = 1; i<=12;i++ ){
            var smsCount = interventionsSummaryData[i] != null?interventionsSummaryData[i].smsCount:0;
            var intCount = interventionsSummaryData[i] != null?interventionsSummaryData[i].callsCount:0;
            result.push([months[i-1],smsCount,intCount]);
        }

        data.addRows(result);

        var options = {
            chart: {
                title: 'Resumen de Intervenciones por Mes'
            },
            hAxis: {
                title: 'Mes',
            }
        };

        var materialChart = new google.charts.Bar(document.getElementById('year_sum_div'));
        materialChart.draw(data, options);
    });

}