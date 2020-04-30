# stream-stat

Tech Stack:
- java 8
- Springboot
- postgres

Components
- scheduled jobs for: 
    - generate 5 random numbers (0-100) every 5 seconds
    - store those numbers and associated sum to db every second
    - db clean up job running every 5 hours to clean up the stream data
    
    
- Database snapshot (sample)

```

  id  |       created_at        | number_stream  | sum |       updated_at        
------+-------------------------+----------------+-----+-------------------------
  374 | 2020-05-01 03:13:03.148 | 19,66,83,35,99 | 302 | 2020-05-01 03:13:03.148
  375 | 2020-05-01 03:13:04.151 | 93,27,48,47,42 | 257 | 2020-05-01 03:13:04.151
  376 | 2020-05-01 03:13:05.155 | 71,91,88,74,87 | 411 | 2020-05-01 03:13:05.155
  377 | 2020-05-01 03:13:06.155 | 28,11,41,64,55 | 199 | 2020-05-01 03:13:06.155
  378 | 2020-05-01 03:13:07.158 | 68,69,83,66,73 | 359 | 2020-05-01 03:13:07.158
  379 | 2020-05-01 03:13:08.158 | 84,16,21,12,30 | 163 | 2020-05-01 03:13:08.158

```
    
Usage:
- Run as a springboot app (modify db details for local postgres)

Endpoint:

```bash
curl -X GET http://localhost:8080/kristal/cumulator/samples
{"last5MinutesSum":52064,"last10MinutesSum":125496,"last30MinutesSum":173152}
```

As of 2020-April-30th this has been also deployed at Heroku:

Link:: https://damp-beach-02547.herokuapp.com/kristal/cumulator/samples