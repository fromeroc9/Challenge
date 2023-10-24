import { defineConfig } from "cypress";
import createBundler from "@bahmutov/cypress-esbuild-preprocessor";
import { addCucumberPreprocessorPlugin, afterRunHandler } from "@badeball/cypress-cucumber-preprocessor";
import { createEsbuildPlugin } from "@badeball/cypress-cucumber-preprocessor/esbuild";
const fs = require("fs");

export async function setupNodeEvents(
    on: Cypress.PluginEvents, config: Cypress.PluginConfigOptions): Promise<Cypress.PluginConfigOptions> {

    await addCucumberPreprocessorPlugin(on, config, {
        omitAfterRunHandler: true,
    });
    
    const bundler = createBundler({
        plugins: [createEsbuildPlugin(config)],
    })

    on("file:preprocessor", bundler);

    on('after:run', async (results: any) => {
        await afterRunHandler(config);
        if (results) {
            fs.mkdirSync("cypress/target/runner", { recursive: true });
            fs.writeFile("cypress/target/runner/results.json", JSON.stringify(results));
        }
    })

    return config;
}
export default defineConfig({
    projectId: "",
    e2e: {
        viewportWidth: 1376,
        viewportHeight: 768,
        screenshotOnRunFailure: true,
        video: true,
        videoCompression: false,
        trashAssetsBeforeRuns: true,
        specPattern: "**/*.feature",
        fixturesFolder: "cypress/resources/fixtures",
        screenshotsFolder: "cypress/target/screenshots",
        videosFolder: "cypress/target/video",
        supportFile: "cypress/support/e2e.ts",
        setupNodeEvents,
    }
});