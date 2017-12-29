# TemplatesSnipptesAndExperiments

1. Clone project
2. Execute ```npm i``` for npm install
3. Import code in your favourite IDE

Project-Structure
* src/modules contains examples for different module formats
* src/test contains examples how the modules can be accessed
* Correlation of files
  * modulePattern/, amd/, umd/
    * `ModuleAccess.html` and `main.js`: Open in browser and have a look at developer console 
    * `ModuleAccessTests.js`: Run with mocha after transpiling (TODO: add script steps)
    * `qunitTest.html` and `tests.js`: Open in browser
  * cjs/
    * `ModuleAccessTests.js`: Run with mocha after transpiling (TODO: add script steps)
* src/webpack/
  * contains examples of mixins the module formats, to show that wepback can handle
  all given formats
  * Run `npm run build` and then open index.html to see results  
