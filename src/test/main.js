requirejs.config({
    baseUrl: '../modules'
});

requirejs(["amd/amdModule"], function(amdModule) {
    console.log("From amd main.js: " + amdModule.hello);
});

requirejs(["umd/umdModule"], function(umdModule) {
    console.log("From umd main.js: " + umdModule.hello());
});
