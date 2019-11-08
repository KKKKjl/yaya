var path = require('path')

function resolve(dir) {
    return path.join(__dirname, './', dir)
}

module.exports = {
    devServer: {
        port: 3001,
        proxy: {
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