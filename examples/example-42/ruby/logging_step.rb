Given('test values are logged') do
    log.debug 'this message will not be seen because of the log level.'
    log.info 'this message will be in the file but not shown on the screen.'
    log.warn 'this message will be in both the file and on the screen.'
end