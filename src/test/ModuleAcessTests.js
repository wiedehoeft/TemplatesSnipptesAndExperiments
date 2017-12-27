"use strict";
const personModule = require("../modules/modulePattern/PersonModule");
const CjsModule = require("../modules/cjs/CjsModule");
const assert = require('assert');
const umdModule = require ("../modules/umd/umdModule");

describe("We want to test how we can access the different module formates", () => {

    it("Test access when module pattern is used", () => {
        // Without node modules we can only access the JS-files in browser
    });

    it("Test access when CJS pattern is used", () => {
        const cjsModuleInstance = new CjsModule();
        assert.equal(cjsModuleInstance.hello(), "hello");
    });

    it("Test access when AMD pattern is used", () => {
        // Without node modules we can only access the JS-files in browser
    });

    it("Test access when UMD pattern is used", () => {
        assert.equal(umdModule.hello(), "hello");
    });
});
