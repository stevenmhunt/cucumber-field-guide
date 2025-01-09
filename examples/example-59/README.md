# Example 59: Running Selenium Grid with Docker

## Starting a Docker container for Selenium Grid
```bash
docker run -d --name selenium-hub --network <network> \
  -p 4442-4444:4442-4444 \
  selenium/hub
```

## Starting a Selenium Grid Node
```bash
docker run -d --name selenium-firefox-node-1 --network <network> \
  -e SE_EVENT_BUS_HOST=selenium-hub \
  -e SE_EVENT_BUS_PUBLISH_PORT=4442 \
  -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 \
  selenium/node-firefox
```