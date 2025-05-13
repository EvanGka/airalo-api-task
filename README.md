
This is Java + RestAssured + TestNG framework that validates the following Airalo endpoints:
- [Request Access Token](https://partners-doc.airalo.com/#919334c1-0800-4e49-a9b9-3a98a51217b7)
- [Submit Order](https://partners-doc.airalo.com/#768fbbc7-b649-4fb5-9755-be579333a2d9)
- [Get eSIMs List](https://partners-doc.airalo.com/#994a7fbb-fbda-451d-a3bc-98028a8e676d)


How to run the tests:
1. Clone the repo
2. Right click on the `apitests` package 
3. Select `Run tests in apitests`


Technical details:
- I created a separate class, `TokenAuth` to create the Bearer token
- I have added an assertion to the TokenAuth class that helps to ensure a valid Bearer token is created before any other endpoint is called
- I created the `BaseTest` where I pass the base url of Airalo's endpoint
- I'm using `TestNG` for the assertions and the `BeforeClass` annotation