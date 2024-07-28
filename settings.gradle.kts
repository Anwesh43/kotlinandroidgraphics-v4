pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "GraphicsKotlinProject4"
include(":app")
include(":linedividerotupview")
include(":linerottoarcview")
include(":bilinedroprotview")
include(":bisectlinesweeprightview")
include(":linearccompleteupview")
include(":linerotsqleftview")
include(":linefromdownupview")
include(":linewitharcrotview")
include(":linebentsqupview")
include(":linepartrotshiftview")
include(":halfarcrotfullview")
include(":altbirotupview")
include(":linebentjoinupview")
include(":linerotmoresqview")
include(":bentlinerotview")
include(":breakarclineholdview")
include(":biarcompleteview")
include(":linetoarccompleteview")
include(":linerotintoarcview")
include(":linewitharcleftview")
include(":sqrotfromarcview")
include(":linerotangleleftview")
include(":linesqrotholderview")
include(":linehalfarcbreakview")
include(":linehalfarcrotleftview")
