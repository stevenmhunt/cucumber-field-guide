def generateTagExpression(List<String> services) {
    services.collect { service -> "@$service" }.join(' or ')
}