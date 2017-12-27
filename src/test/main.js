requirejs.config({
    baseUrl: '../modules',
});

requirejs(["amdModule"], function(amdModule) {
    console.log("From amd main.js: " + amdModule.hello);
});

requirejs(["umdModule"], function(umdModule) {
    console.log("From umd main.js: " + umdModule.hello());
});
