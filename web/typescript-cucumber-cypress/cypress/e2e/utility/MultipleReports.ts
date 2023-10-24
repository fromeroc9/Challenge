const report = require('multiple-cucumber-html-reporter');
const fs = require('fs');

fs.readFile('cypress/target/runner/results.json', (err = '', data = '') => {
    if (err) {
        throw err;
    }
    var runInfos = JSON.parse(data);

    report.generate({
        durationInMS: false,
        displayDuration: true,
        openReportInBrowser: true,
        disableLog : true,
        displayReportTime : true,
        jsonDir: 'cypress/target/cucumber',
        reportPath: 'cypress/target/reports/multiple-reporte',
        metadata: {
            // app : {
            //     name : 'APP Prueba',
            // },
            browser: {
                name: runInfos.browserName,
                version: runInfos.browserVersion
            },
            device: 'Cypress',
            platform: {
                name: runInfos.osName
            }
        },
        customData: {
            title: 'Información de la Ejecución',
            data: [
                { label: 'Proyecto', value: 'Projecto de Niubiz' },
                { label: 'Release', value: '10.3.0' },
                { label: 'Ciclo', value: 'B11221.34321' },
                { label: 'Inicio de la Ejecución', value: new Date(runInfos.startedTestsAt).toLocaleString()},
                { label: 'Finalización de la Ejecución', value: new Date(runInfos.endedTestsAt).toLocaleString()}
            ]
        },
        pageTitle: `
            Reporte Cypress</title>
        `,
        reportName: 'Reporte Cypress',
    });
})