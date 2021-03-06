# Robotic Cleaner RESTful API
This is the RESTful API for the coding practice: https://github.com/marshmallow-insurance/java-backend-test

## How to build and run it.
To build: 

        ./gradlew clean build

To start Spring Boot server: 
* Run Application.java as a java application
* or Gradle Wrapper: `./gradlew bootRun`

End points:

        http://localhost:8080/

## Sample Request and Response
Please also find `resource/marshmallow.postman_collection.json` and import into postman for test
#### Passing valid task
```json
{
    "areaSize" : [5, 5],
    "startingPosition" : [1, 2],
    "oilPatches" : [
      [1, 0],
      [2, 2],
      [2, 3]
    ],
    "navigationInstructions" : "NNESEESWNWW"
}
```
Response: 200 OK
```json
{
    "finalPosition": [
        1,
        3
    ],
    "oilPatchesCleaned": 1
}
```

#### Revisit oil patch location
```json
{
  "areaSize" : [3, 3],
  "startingPosition" : [1, 1],
  "oilPatches" : [
    [1, 2],
    [2, 2]
  ],
  "navigationInstructions" : "NESWNESWNESW"
}
```
Response: 200 OK
```json
{
    "finalPosition": [
        1,
        1
    ],
    "oilPatchesCleaned": 2
}
```

#### Robot navigated outside boundary
```json
{
  "areaSize" : [3, 3],
  "startingPosition" : [1, 1],
  "oilPatches" : [
    [1, 2],
    [2, 2]
  ],
  "navigationInstructions" : "NNNNN"
}
```
Response: 400 Bad Request
```
Robot cannot be navigated outside of boundary!
```
#### Invalid Navigation Instruction
```json
{
  "areaSize" : [3, 3],
  "startingPosition" : [1, 1],
  "oilPatches" : [
    [1, 2],
    [2, 2]
  ],
  "navigationInstructions" : "NASW"
}
```
Response: 400 Bad Request
```
Invalid navigation instruction passed!
```

#### Invalid coordinates passed
```json
{
  "areaSize" : [-1, 3],
  "startingPosition" : [1, 1],
  "oilPatches" : [
    [1, 2],
    [2, 2]
  ],
  "navigationInstructions" : "N"
}
```
Response: 400 Bad Request
```
Invalid coordinates passed!
```

#### Starting location outside Boundary
```json
{
  "areaSize" : [3, 3],
  "startingPosition" : [4, 1],
  "oilPatches" : [
    [1, 2],
    [2, 2]
  ],
  "navigationInstructions" : "N"
}
```
Response: 400 Bad Request
```
Robot starting position outside boundary!
```

#### Input validation failure
```json
{
  "areaSize" : [3, 3, 2],
  "startingPosition" : [4, 1],
  "oilPatches" : [
    [1, 2],
    [2, 2]
  ],
  "navigationInstructions" : "N"
}
```
Response: 400 Bad Request
```
areaSize size must be between 2 and 2
```

## What's next
* Dockerize
* Stubs


