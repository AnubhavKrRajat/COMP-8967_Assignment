import json
import requests
url = "https://internship-project-auth.herokuapp.com/LoginUser"
url1 = "https://internship-project-auth.herokuapp.com/RegisterUser"
# val = requests.post(url, headers={"content-type": "application/json"}, data=json.dumps({"email": "sagar@is.banana", "password": "banana"}))
# print(val)

val2 = requests.post(url1, headers={"content-type": "application/json"}, data=json.dumps({"name":"Sagar Sharma","email": "sagar1@is.banana", "password": "banana"}))
print(val2)