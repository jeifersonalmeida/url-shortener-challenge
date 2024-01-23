#docker run --rm -i -v $PWD:/app -w /app grafana/k6 new

docker run --rm --network host -i grafana/k6 run - < k6-script.js