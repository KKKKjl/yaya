var path = require('path')

function resolve(dir) {
    return path.join(__dirname, './', dir)
}

module.exports = {
    pwa: {
        name: 'yaya',
        themeColor: '#ffffff',
        msTileColor: '#000000',
        appleMobileWebAppCapable: 'yes',
        appleMobileWebAppStatusBarStyle: 'black'
    },
    devServer: {
        port: 3001,
        proxy: {
            '/api': {
                target: 'http://localhost:8081',
                ws: true,
                changeOrigin: true,
                pathRewrite: {
                    '^/api': '/v1/api'
                }
            },
            '/upload': {
                target: 'https://sm.ms/api',
                ws: true,
                changeOrigin: true,
                pathRewrite: {
                    '^/upload': '/upload'
                }
            }
        }
    }
}