require 'logging'

log = Logging.logger['example_logger']
log.level = :info

log.add_appenders \
    Logging.appenders.stdout(level: :warn),
    Logging.appenders.file('output.log', layout: Logging.layouts.json)
