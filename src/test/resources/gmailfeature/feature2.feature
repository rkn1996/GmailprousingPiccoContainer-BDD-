Feature: Login
@tag
Scenario Outline: validate uid field
Given launch site using "<bn>"
When enter "<u>" as userid
And click uid next
Then validate output for "<uc>" as uid criteria
Examples: 
|     bn     |             u              |       uc      |
|   Chrome   |      kumarnayakroshan305   |     valid     |
|   Chrome   |      kumarnayakroshan323f  |    invalid    |
|   Chrome   |                            |     blank     |

@tag
Scenario Outline: validate pwd field
Given launch site using "<bn>"
When enter "kumarnayakroshan305" as userid
And click uid next
And enter "<p>" as password
And click pwd next
Then validate output for "<pc>" as pwd criteria
Examples: 
|    bn      |            p               |       pc      |
|   Chrome   |      xxxxxxxxxxxxxxxxxx    |     valid     |
|   Chrome   |      rknawf34              |    invalid    |
|   Chrome   |                            |     blank     |
