// https://www.codewars.com/kata/513e08acc600c94f01000001
int round(int n) {
  if (n > 255) {
    return 255;
  } else if (n < 0) {
    return 0;
  } else {
    return n;
  }
}

Map<int, String> convertMap = {
  0: '0',
  1: '1',
  2: '2',
  3: '3',
  4: '4',
  5: '5',
  6: '6',
  7: '7',
  8: '8',
  9: '9',
  10: 'A',
  11: 'B',
  12: 'C',
  13: 'D',
  14: 'E',
  15: 'F',
};

String convert(int n) {
  int lower = n & 15;
  int upper = (n & (15 << 4)) >> 4;
  return "${convertMap[upper]}${convertMap[lower]}";
}

String rgb(int r, int g, int b) => [r, g, b].map(round).map(convert).join();

void main() {
  print(16 & (15 << 4) >> 4);
  print(1 << 4);
  //print(15 << 4);
  //print(17 >> 4);
  //print(1 & 1);
  print(rgb(255, 255, 255));
  print(rgb(148, 0, 211));
  print(rgb(8, 10, 2));
  print(rgb(144, 195, 212));
  print(rgb(148, -20, 211)); // FFFFFF
}
