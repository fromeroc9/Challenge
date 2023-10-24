export const typeText = (locator: string, value: string, xpath: boolean = false): void => {
    let option = { parseSpecialCharSequences : false }
    let action = (!xpath) ? cy.get(locator).type(value, option) : cy.xpath(locator).type(value, option);
}

export const click = (locator: string, xpath: boolean = false): void => {
    (!xpath) ? cy.get(locator).click() : cy.xpath(locator).click();
}

export const clear = (locator: string, xpath: boolean = false): void => {
    (!xpath) ? cy.get(locator).clear() : cy.xpath(locator).clear();
}

export const selectByVisibleText = (locator: string, value: string, xpath: boolean = false): void => {
    (!xpath) ? cy.get(locator).select(value) : cy.xpath(locator).select(value);
}

export const wait = (time: number): void => {
    cy.wait(time)
}

export const getValue = (locator: string, xpath: boolean = false) => {
    let action = (!xpath) ? cy.get(locator) : cy.xpath(locator);
    return action.invoke('val');
}

export const getText = (locator: string, xpath: boolean = false) : any =>{
    let action = (!xpath) ? cy.get(locator) : cy.xpath(locator);
    return action.then(e => { return e.text()} )
}

let xframe = (locator : string, xpath: boolean = false) => {
    return cy.xframe(locator, xpath);
}

export const iclick = (framelocator : string, locator: string, xpath: boolean = false): void => {
    (!xpath) ? xframe(framelocator).find(locator).click() : xframe(framelocator).xpath(locator).click();
}

export const itypeText = (framelocator : string, locator: string, value: string, xpath: boolean = false): void => {
    (!xpath) ? xframe(framelocator).find(locator).type(value) : xframe(framelocator).xpath(locator).type(value);
}

export const iclear = (framelocator : string, locator: string, xpath: boolean = false): void => {
    (!xpath) ? xframe(framelocator).find(locator).click() : xframe(framelocator).xpath(locator).click();
}

export const iselectByVisibleText = (framelocator : string, locator: string, value: string, xpath: boolean = false): void => {
    (!xpath) ? xframe(framelocator).find(locator).select(value) : xframe(framelocator).xpath(locator).select(value);
}

export const ExcelReader = (file:string, sheet: string, jsonName:string = '') : Array<any> =>{
    let data : any = [];
    cy.ExcelReader(file, sheet).then((rows : any) => {
        rows.forEach( (element : any) => {
            data.push(element);
        });
        if (jsonName != ''){
            cy.writeFile("cypress/resources/fixtures/"+jsonName+".json", rows)
        }
    })
    return data;
}

export const JSONWrite = (filename : String, data : any) : void => {
    cy.writeFile("cypress/resources/fixtures/"+filename+".json", data)
}

export const JSONReader = (file: string) : Array<any> =>{
    let data : any = [];
    cy.fixture(file).then((response) => {
        response.forEach( (element : any) => {
            cy.log(element);
            data.push(element);
        });
    })
    return data;
}