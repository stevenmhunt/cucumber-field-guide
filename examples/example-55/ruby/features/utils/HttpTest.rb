module HttpTest
  @requests = []
  @responses = []
  @ignore_errors = false

  def add_request(request)
      @requests.unshift(request)
  end

  def add_response(response)
      @responses.unshift(response)
  end

  def get_requests
      @requests
  end

  def get_responses
      @responses
  end

  def get_ignore_errors
      @ignore_errors
  end

  def set_ignore_errors(val)
      @ignore_errors = val
  end

  def reset
      @ignore_errors = false
      @requests = []
      @responses = []
  end

  module_function :add_request
  module_function :add_response
  module_function :get_requests
  module_function :get_responses
  module_function :get_ignore_errors
  module_function :set_ignore_errors
  module_function :reset
end
