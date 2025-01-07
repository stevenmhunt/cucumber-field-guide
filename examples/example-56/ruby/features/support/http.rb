require 'uri'
require 'net/http'
require 'json'
require './features/utils/HttpTest'

def execute_http_request_internal(url:, method: 'GET', headers: {}, body: nil)
    uri = URI.parse(url)
    http = Net::HTTP.new(uri.host, uri.port)
    http.use_ssl = uri.scheme == 'https'

    request_class = Net::HTTP.const_get(method.capitalize)
    request = request_class.new(uri)

    request.body = body.to_json if %w[POST PUT PATCH].include?(method.upcase) && body

    headers.each { |key, value| request[key] = value }

    http.request(request)
rescue NameError
    raise "Unsupported HTTP method: #{method}"
end

def execute_http_request(request)
    url = "#{Settings.http.baseUrl}#{request[:url]}"
    ignore_errors = HttpTest.get_ignore_errors || Settings.http.ignoreErrors
    HttpTest.add_request(request)
    res = execute_http_request_internal(
        url: url,
        method: request[:method],
        headers: request[:headers],
        body: request[:body]
    )
ensure
    HttpTest.add_response(res)
    raise "HTTP Error: #{res.code} #{res.message}" if !ignore_errors &&
                                                      res.code.to_i >= 400

    res
end

Before('@http-ignore-errors') do
    HttpTest.set_ignore_errors(true)
end

After do
    HttpTest.reset
end
