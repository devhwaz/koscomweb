docker ^
  run -dit --restart unless-stopped  ^
  --detach  ^
  --name webapp ^
  --publish 9999:8080 ^
  carami/webapp:0.1
