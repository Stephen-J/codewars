// https://www.codewars.com/kata/5a55f04be6be383a50000187/dart
String specialNumber(n) {
  int zero = "0".codeUnitAt(0);
  return n
      .toString()
      .codeUnits
      .fold("Special!!", (prev, curr) => curr - zero > 5 ? "Not!!" : prev);
}

void main() {
  print(specialNumber(100));
  print(specialNumber(7777));
  print(specialNumber(1));
}
