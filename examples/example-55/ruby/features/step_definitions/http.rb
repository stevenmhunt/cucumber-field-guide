Given('an HTTP {string} call {string} is made') do |method, url|
  execute_http_request({
                           url: url,
                           method: method,
                           headers: {},
                           body: nil
                       })
end
