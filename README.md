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
    
    
Usage:
- Run as a springboot app (modify db details for local postgres)

Endpoint:

```bash
curl -X GET http://localhost:8080/kristal/cumulator/samples
{"last5MinutesSum":52064,"last10MinutesSum":125496,"last30MinutesSum":173152}
```
