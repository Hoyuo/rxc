buildscript {
    extra.set(
        "supportedResConfigs",
        if (project.hasProperty("supportedResConfigs"))
            (project.property("supportedResConfigs") as? String)?.split(",")
        else
            null
    )
}
