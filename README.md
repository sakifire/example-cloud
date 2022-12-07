# OpenShift SpringBoot Deploy on you Local PC Or Laptop

How easy for a developer to deploy Spring Boot application in Open Shift

odo is a CLI tool for easily developing and deploying applications on OpenShift. Similar to oc - the OpenShift CLI, which is more operations-focused 
and need solid understanding of Kubernetes concepts. odo is designed to be simple and concise so you can focus on coding. odo's syntax and design are centered 
around concepts already familiar to developers, such as project, application, and component. 

# Technology or Tools Stack before you start.
  * Java
  * Spring Boot
  * Openshift CRC 1.14/1.15
  * Spring Tools 4 for Eclipse
  
# Spring Boot Hello world aplicationon deploy in OpenShift CRC using odo.

Scope of the project is to deploy spring boot webapplication on Openshift and scale up to mulitple instance in your local PC/Laptop.

# Git pull the code locally
    * git init
    * git pull https://github.com/ngecom/openshiftSpringBoot.git
    * mvn package
    * Verify locally by executing "java -jar helloopenshift.jar"

# Login to openshift as developer and create a project in openshift
    * rakesh@rakesh-ThinkPad-P50:~/IDE/crc-linux-1.15.0-amd64$ oc login -u developer -p developer
    * rakesh@rakesh-ThinkPad-P50:~/IDE/crc-linux-1.15.0-amd64$ oc new-project my-project --display-name="HelloWorld"
  
# Create Spring Boot Web component in Openshift

    * rakesh@rakesh-ThinkPad-P50:~/MyWorks/Openshift/helloopenshift$ odo create java helloopenshift --binary=target/helloopenshift.jar
    * rakesh@rakesh-ThinkPad-P50:~/MyWorks/Openshift/helloopenshift$ odo push
 
With an odo create command, a configuration file called config.yaml has been created in the local directory of the component that contains information about the component for deployment. You can view the configuration settings of the component in config.yaml by the following command:

     rakesh@rakesh-ThinkPad-P50:~/MyWorks/Openshift/helloopenshift$ odo config view
     COMPONENT SETTINGS
     ------------------------------------------------
     PARAMETER         CURRENT_VALUE
     Type              java
     Application       app
     Project           my-project
     SourceType        binary
     Ref               
     SourceLocation    target/helloopenshift.jar
     Ports             8080/TCP,8443/TCP,8778/TCP
     Name              helloopenshift
     MinMemory         
     MaxMemory         
     DebugPort         
     Ignore            
     MinCPU            
     MaxCPU 
     
# Expose the Web application to Public
    * rakesh@rakesh-ThinkPad-P50:~/MyWorks/Openshift/helloopenshift$ odo url create --port 8080
    * rakesh@rakesh-ThinkPad-P50:~/MyWorks/Openshift/helloopenshift$ odo push
            Validation
         ✓  Checking component [224ms]

        Configuration changes
         ✓  Retrieving component data [36ms]
         ✓  Applying configuration [57ms]

        Applying URL changes
         ✓  URL helloopenshift-8080: http://helloopenshift-8080-app-my-project.apps-crc.testing created

        Pushing to component helloopenshift of type binary
         ✓  Checking file changes for pushing [2ms]
         ✓  Waiting for component to start [11ms]
         ✓  Syncing files to the component [411ms]
         ✓  Building component [2s]

# Access the application from outside world
  * http://helloopenshift-8080-app-my-project.apps-crc.testing
  * Scale and Test with some concurrent client requests
 <img src="https://github.com/ngecom/openshiftSpringBoot/blob/master/scale2.png">
     
