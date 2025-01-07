Given('an HTTP {string} call {string} is made') do |method, url|
  execute_http_request({
                           url: url,
                           method: method,
                           headers: {},
                           body: nil
                       })
end

Then('the HTTP call should have returned an HTTP {int}') do |status|
    expect(HttpTest.get_responses[0].code).to eq(status.to_s)
end
