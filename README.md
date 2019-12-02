Twisub
======

Application for Twitter subscription.


#### Building docker images:

```sh
$ gradlew :buildImages
```

#### Configuration

[docker-compose.yaml](docker/docker-compose.yaml) file:

```yaml
...
  ms-twitterclient:
    container_name: ms-twitterclient
    image: com.jstructure.twisub/twitterclient:0.0.1-SNAPSHOT
    environment:
      APP_TWITTER_CONSUMERKEY: ...
      APP_TWITTER_CONSUMERSECRET: ...
      APP_TWITTER_ACCESSTOKEN: ...
      APP_TWITTER_ACCESSTOKENSECRET: ...
...
```

#### Running docker containers

```sh
$ cd docker
$ docker-compose up
```
