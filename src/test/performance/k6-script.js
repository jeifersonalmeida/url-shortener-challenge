import http from 'k6/http';
import { check } from 'k6';

export const options = {
  vus: 300,
  duration: '30s',
//  iterations: 100
};

const urls = [
  'https://www.google.com.br/',
  'https://www.youtube.com/',
  'https://spring.io/',
  'https://stackoverflow.com/',
  'https://stackoverflow.com/questions/37751759/generating-a-random-link-through-javascript-html',
  'https://stackoverflow.com/questions/50093012/how-can-i-create-a-random-automatic-redirect-url?noredirect=1&lq=1',
  'https://github.com/grafana/k6/tree/master/examples',
];

function getRandomURL() {
  return urls[parseInt(Math.random() * urls.length)];
}

export default function () {
  const urls = [];
  for (let i = 0; i < 10; i++) {
    const body = {
      urlToShort: getRandomURL(),
    };
    const postResponse = http.post(
      'http://localhost:8081/',
      JSON.stringify(body),
      { headers: { 'Content-Type': 'application/json' } },
    );
    urls.push({
      url: body.urlToShort,
      shortUrl: postResponse.json().url,
    });
  }
  for (let i = 0; i < 100; i++) {
    const url = urls[parseInt(Math.random() * urls.length)];
    const getResponse = http.get(`http://localhost:8081/${url.shortUrl}`);
    check(getResponse, {
      'is status 200': (r) => r.status === 200,
      'is correct url': (r) => r.json().url === url.url,
    });
  }
}