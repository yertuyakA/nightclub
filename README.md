# nightclub
backend for Night club app (test task)

Для запуска 
docker-compose up

SWAGGER:
(http://localhost:8082/swagger-ui/index.html)(url)

для проверки
[localhost:8082/actuator/heatlh](url)


Ability to register attendance of user with username=${username} night club with name=${nightClubName}:
POST
[localhost:8082/api/v1/guest/register](url)
[{
    "username":"Person Personovich",
    "name":"CLUB NUMBER 3"
}](url)

Functionality for providing information about all visitors of some night-club (i.e. visitors of ${nightClubName})
GET
[localhost:8082/api/v1/club/listGuest/CLUB NUMBER 1](url)

Provision information of all night clubs which user with username=${username}  has visited already
GET 
[localhost:8082/api/v1/club/history/attendance/Person Personovich](url)

Provision information of all night clubs which user HASN'T visited yet]
GET 
[localhost:8082/api/v1/club/history/noVisit/Person Personovich](url)
