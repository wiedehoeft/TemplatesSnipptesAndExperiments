"use strict";

function demoModule() {

    this.hello = function() {
        return "hello";
    };

    this.goodbye = function() {
        return "goodbye";
    };
}

module.exports = demoModule;