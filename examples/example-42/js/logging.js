const { createLogger, format, transports } = require('winston');

const log = createLogger({
    level: 'info',
    format: format.simple(),
    transports: [
        new transports.Console({ level: 'warn' }),
        new transports.File({
            filename: 'output.log',
            format: format.combine(format.timestamp(), format.json())
        })
    ]
});

export { log };