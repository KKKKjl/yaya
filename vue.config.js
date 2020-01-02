var path = require('path')

module.exports = {
    pwa: {
        name: 'yaya',
        themeColor: '#ffffff',
        msTileColor: '#000000',
        appleMobileWebAppCapable: 'yes',
        appleMobileWebAppStatusBarStyle: 'black',
        workboxPluginMode: 'InjectManifest',
        workboxOptions: {
            swSrc: 'src/service-worker.js',
        }

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