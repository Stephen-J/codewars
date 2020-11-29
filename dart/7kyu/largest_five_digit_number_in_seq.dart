// https://www.codewars.com/kata/51675d17e0c1bed195000001
int solution(String digits) {
  int zero = "0".codeUnitAt(0);
  List<int> points = digits.codeUnits;
  int tmp = 0;
  for (int i = 0; i < points.length - 4; i++) {
    String n = points.sublist(i, i + 5).map((item) => item - zero).join();
    if (int.parse(n) > tmp) tmp = int.parse(n);
  }
  return tmp;
}

void main() {
  print(solution("1234567890"));
}
