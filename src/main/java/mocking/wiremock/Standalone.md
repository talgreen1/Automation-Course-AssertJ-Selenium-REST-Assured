Standalone Mode
===================

You can start the mock server as a stand alon from the command line.
Just download the file wiremock-standalone-2.18.0.jar and run it like this:

`java -jar wiremock-standalone-2.18.0.jar --port 7979 --root-dir c:/temp/mappings`

--root-dir: Specified the directory of the mapping json files

JSON Mapping Samples
--------------------

***Simple Mapping:***
```json
{
    "request" : {
      "url" : "/postReq",
      "method" : "POST",
      "bodyPatterns" : [ {
        "equalToJson" : "{\"name\":\"John\"}"
      } ]
    },
    "response" : {
      "status" : 200,
      "body" : "{ \"name\":\"John\", \"age\":31, \"city\":\"New York\" }",
      "headers" : {
        "Content-Type" : "application/json"
      }
    },
    "uuid" : "b51e0c3a-9a2c-428b-b4d5-65d47ceb38a6"
  }
```

***Mapping for proxy:***

```json
{
  "request": {
    "method": "GET",
    "urlPattern": ".*"
  },
  "response": {
    "proxyBaseUrl" : "http://httpbin.org/"
  }
}
```

HTTP Access
-----------
You can access the server from http:
http://<IP>:<PORT>/__admin/
http://<IP>:<PORT>/__admin/mappings



