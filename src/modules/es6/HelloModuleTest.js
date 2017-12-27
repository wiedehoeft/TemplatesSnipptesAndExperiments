"use strict";
import {HelloModule} from "./HelloModule";

describe("We want to test how we can access the different module formates", () => {

    it("Test access to ES6 module", () => {
        new HelloModule();
    });
});