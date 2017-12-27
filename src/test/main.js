requirejs.config({
    baseUrl: '../modules/amd',
});

requirejs(["amdModule"], function(amdModule) {
    console.log("From main.js: " + amdModule.hello);
});
