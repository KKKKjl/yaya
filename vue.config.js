var path = require('path')

function resolve(dir) {
    return path.join(__dirname, './', dir)
}

module.exports = {
    devServer: {
        port: 3001,
        proxy: {
            '/api': {
                target: 'https://sm.ms',
                ws: true,
                changeOrigin: true,
                pathRewrite: {
                    '^/api': '/api/'
                }
            }
        }
    }
}