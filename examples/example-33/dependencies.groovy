def map = [:]

def addDependency(Map<String, String[]> map, String item, String dependentItem) {
    if (map.containsKey(dependentItem)) {
        map[dependentItem] << item
    } else {
        map[dependentItem] = [item]
    }
}

def getDependents(Map<String, String[]> map, String item, int levels) {
    if (levels <= 0 || !map.containsKey(item)) {
        return []
    }

    def dependents = []
    map[item]?.each { dependent ->
        dependents << dependent
        dependents += getDependents(map, dependent, levels - 1)
    }
    dependents
}

// example of loading the dependencies from Figure 6:
addDependency(map, 'bff-1', 'service-1')
addDependency(map, 'bff-1', 'service-2')
addDependency(map, 'bff-2', 'service-2')
addDependency(map, 'bff-2', 'service-3')
addDependency(map, 'service-1', 'service-2')
addDependency(map, 'service-3', 'service-2')
addDependency(map, 'queue-1', 'service-3')
addDependency(map, 'service-4', 'queue-1')