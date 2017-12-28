const path = require('path');

module.exports = {
    entry: './src/webpack/src/index.js',
    output: {
        filename: 'bundle.js',
        path: path.resolve(__dirname, 'src/webpack/dist')
    },
    resolve: {
        modules: [
            'src/webpack/src',
            'node_modules'
        ]
    }
};