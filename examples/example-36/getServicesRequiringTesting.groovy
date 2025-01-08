def getServicesRequiringTesting(String changedService, Map dependencies) {
    [changedService] + getDependents(dependencies, changedService)
}