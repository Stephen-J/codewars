// https://www.codewars.com/kata/59d9ff9f7905dfeed50000b0

List<int> solve(List<String> arr) {
  int a = "a".codeUnitAt(0);
  return arr.map((item) => item.toLowerCase()).map((item) {
    int count = 0;
    for (int i = 0; i < item.length; i++) {
      if (item[i].codeUnitAt(0) - a == i) count++;
    }
    return count;
  }).toList();
}

void main() {
  print(solve(["abode", "ABc", "xyzD"])); //[4, 3, 1]
}
