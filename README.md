BloodBank
=========
Description: This application is a POC for Online Blood bank where it facilitates the people who need blood and people who wish to donate blood meet each other.

There are couple of spring profiles defined in mongo-config.xml. (dev and ibm). By default it is set as dev in web.xml.
The spring profile ibm will be used while deploying this application in IBM bluemix.
Spring profile dev will use the mongo db running in your local desktop.
Spring profile ibm will use the mongo db service in the IBM Bluemix cloud platform.
