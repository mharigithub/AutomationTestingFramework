# Automation Testing Framework
Cucumber-Java-Maven based Automation framework for Mobile App and Website Application testing.

## To Run Tests on Local device
- Start appium server at 0.0.0.0 at port 4723
- For parallel testing use parallel testNG local xml files. 
- Update Thread count in testngLocal.xml
- Update Tag in TestNGParallelRunner*

## Maven commands
- ``mvn clean test -PMobileCloudParallel``
- ``mvn clean test -PMobileCloudSequential``
- ``mvn clean test -POnlineCloudParallel``
- ``mvn clean test -POnlineCloudSequential``

## To Run Tests on Browserstack device
- For parallel testing use parallel testNG cloud xml files.
- Update Thread count in testngCloud.xml
- Update Tag in TestNGParallelRunner1Mobile,2 for mobile
- Update Tag in TestNGParallelRunner1Online,2 for online

## Framework Features:
- Mobile App Testing (On both local and cloud)
- Web App Testing (On cloud)
- Parallel Testing
- Jira integration
- Jenkins integration

## Setup for Cloud Execution (BrowserStack)
- Generate app url using 
- To capture appium logs ``curl -u "haribabumaila_Elu5RJ:nSqD7s61yDhRpefqbTRb" \
  https://api.browserstack.com/automate/sessions/<session-id>/appiumlogs
  ``
## Setup For Local Device Execution
- ### Softwares:
- JDK (v11)
- Android Studio (for adb and for executing on android virtual devices)
- Appium (v1.21)
- IntelliJ
- Git
- Maven

- ### Set Env variables in Windows machine:
- JAVA_HOME with C:\Program Files\Java\jdk-17.0.2
- Path with %JAVA_HOME%\bin

- ### Set Env variables in Appium Server:
- ANDROID_HOME with C:\Users\user\AppData\Local\Android\Sdk
- JAVA_HOME with C:\Program Files (x86)\Java\jre1.8.0_311

## Jenkins:
- #### Step1: installing maven in Jenkins Agent
  - MAVEN_HOME with C:\Program Files\apache-maven-3.6.1-bin\apache-maven-3.6.1
  - M2_HOME with C:\Program Files\apache-maven-3.6.1-bin\apache-maven-3.6.1
  - JAVA_HOME with C:\Program Files\Java\jdk-17.0.2
  - Path with C:\Program Files\Java\jdk-17.0.2\bin
  - Path with C:\Program Files\apache-maven-3.6.1-bin\apache-maven-3.6.1\bin
- #### Step2: installing maven plugins in Jenkins
  - Go to "Manage Jenkins" -> "Manage Plugins" -> click "Available" tab -> enter "maven" in search box.
  - In search results select Maven Integration plugin and click on Download Now And Install After Restart button
- #### Step3: Maven and JDK configuration in Global Tool Configuration in Jenkins
  - #### If Step1 is done Step3 is not needed and vice versa
  - Navigate to Global Tool Configuration
  - Scroll down and click on Add Maven
  - Provide name as something like Maven3, Select install automaticall checkbox, select version in the Install From Apache dropdown and Save
- #### Step4: Creating jenkins job using pipeline

## ADB
- With Android Studio ADB will be installed automatically.
- To enable developer options: About Phone->Software Information-> Tap Build Number multiple times
- Navigate to Developer options and turn on USB debugging
- Navigate to C:\Users\user\AppData\Local\Android\Sdk\platform-tools in command prompt and type ``adb``
- Now type `adb devices` to view the list of devices connected and their IDs
- To install apk type ``adb -s <DEVICE ID> install <PATH TO APK>``

## GitHub
- ### SSH key generation
  - Open git bash and enter
    `
    ssh-keygen -t rsa
    `
  - Enter location or just press enter for default location
  - Set password if required or just press enter
  - Navigate to /c/Users/username/.ssh/id_rsa location
  - Open id_rsa publisher file in Notepad and copy everything
  - Open GitHub in browser
  - Go to profiles and click on SSH Keys tab
  - Paste the copied key and click Add

- ### For uploading new project to GitHub
  - Right click in the project folder and click git bash here and type ``git init`` command. Now ".git" folder will be created.
  - Enter `git add .` command to add all the project files.
  - Use `git commit -m "code change description"` to commit the files.
  - Create branch with branch name as "main" ``git branch -M main``
  - Add a new remote connection to your local project folder using below command
    ````
    git remote add origin https://github.com/harigithub1/AutomationFramework.git
    ````
  - Push the project using `git push -u origin main`.
  - To push code to feature branch ``git branch featurebranchname``, `git push origin featurebranchname`.

- ### For importing existing project from GitHub and creating feature branch
  - Clone the project:
    ````
    git clone https://github.com/harigithub1/AutomationFramework.git
    ````
  - Create your feature branch: `git branch my-new-feature-branch-name`
  - Add your code changes: `git add my-file-name`
  - Commit your changes: `git commit -m "commit message"`
  - Push to the branch: `git push origin my-new-feature-branch-name`
  - Open GitHub and create a pull request to main branch
  - To delete feature branch in github: `git push -d origin feature-branch-name`

## Jira and ZephyrSquadCloud integration
#### Keys for interacting with Jira/ZephyrSquadCloud APIs
- ZephyrSquadCloud Rest API link1: https://support.smartbear.com/zephyr-squad-cloud/docs/api/index.html
- ZephyrSquadCloud Rest API link2 (interactive api): https://zephyrsquad.docs.apiary.io/#reference/execution/update-execution/update-execution
- ZephyrSquadCloud Access key and Zephyr Secret key:
  - To generate ZephyrSquadCloud Access key and Secret key refer https://support.smartbear.com/zephyr-squad-cloud/docs/api/api-keys.html
- Jira Account ID:
  - Its is available in the URL after clicking on the profile link in jira.
- Jira basic authorization token: follow below steps to generate basic authorization token for jira:
  - Step1: Get Jira API key from Jira account settings
  - Step2: Generate base64 encoded string of "JiraEmailID:JiraApiKey", append Basic keyword and use it as Authorization header.
    - To generate base64 encoded string: www.base64encode.org
    - Example: "Authorization: Basic base64-encoded-string"
    - For detailed info follow https://developer.atlassian.com/cloud/jira/platform/basic-auth-for-rest-apis/
- Link to download Jar for interacting with Jira and ZephyrSquadCloud APIs: https://support.smartbear.com/zephyr-squad-cloud/docs/api/jwt-token.html