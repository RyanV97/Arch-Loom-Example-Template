# Architectury Loom 1.16.5 Template
Based on: *https://github.com/architectury/architectury-loom*

## Setup
Simply set this project wherever you like, and import build.gradle into IntelliJ and let it do the rest!
If you get an error about the java version, make sure to set your project/gradle to use **Java 16**

If you run into an error similar to this:
![](https://i.imgur.com/Q42XGsd.png)
Then you simply need to change the version of Java being used by Gradle to **Java 16**:
(File -> Settings -> Build, Execution, Deployment -> Build Tools -> Gradle)

You can either download the JDK through IntelliJ or I'd recommend downloading your java versions through AdoptOpenJDK/Adoptium - https://adoptium.net/
![](https://i.imgur.com/jDsNL72.png)


Make sure to reimport your gradle project after changing this
Open the Gradle tab on the right, and click the refresh button

![](https://i.imgur.com/fgsruAb.png)

## Mappings
By default this template will apply the Official Mojang (Mojmap) mappings, however if you wish to change this, take a look in `build.gradle`, find the `dependencies` block, and change `mappings` to whichever mappings you prefer.

If you wish to change to Yarn, you can simply comment the curernt: `mappings minecraft.officialMojangMappings()` line, and uncomment the `mappings "net.fabricmc:yarn:${project.yarn_mappings}:v2"` line right below it.

## Sources
If you wish to generate Sources so that you can more easily browse pre-existing code, make sure to run the `genSources` gradle task


## Run Configs
If you can't see the run configurations in the top right, you may need to close and re-open the IntelliJ project, and they should appear in the dropdown.
