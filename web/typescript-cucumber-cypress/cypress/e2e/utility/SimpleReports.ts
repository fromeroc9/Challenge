const reporter = require('cucumber-html-reporter');
const fsx = require('fs');

fsx.readFile('cypress/target/runner/results.json', (err = '', data = '') => {
    if (err) {
        throw err;
    }
    var runInfos = JSON.parse(data);
    const options = {
        theme: 'bootstrap',
        jsonFile: 'cypress/target/cucumber/cucumber-report.json',
        output: 'cypress/target/reports/simple-report/simple-report.html',
        reportSuiteAsScenarios: true,
        scenarioTimestamp: true,
        launchReport: true,
        metadata: {
            "App Version": "0.3.2",
            "Test Environment": "STAGING",
            "Browser": runInfos.browserName,
            "Platform": runInfos.osName,
            "Inicio de la Ejecución": new Date(runInfos.startedTestsAt).toLocaleString(),
            "Finalización de la Ejecución": new Date(runInfos.endedTestsAt).toLocaleString()
        }
    };
    reporter.generate(options);
})