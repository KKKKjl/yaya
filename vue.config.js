var path = require('path')

function resolve(dir) {
    return path.join(__dirname, './', dir)
}

module.exports = {
    devServer: {
        port: 3001
        // proxy: {
        //     '/v1/api': {
        //         target: 'http://localhost:8081',
        //         ws: true,
        //         changeOrigin: true,
        //         pathRewrite: {
        //             '^/v1/api': '/v1/api'
        //         }
        //     }
        // }
    }
}