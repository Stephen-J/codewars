// https://www.codewars.com/kata/54ff3102c1bad923760001f3

import "dart:core";

final List<int> vowels =
    ['a', 'e', 'i', 'o', 'u'].map((v) => v.codeUnitAt(0)).toList();

int getCount(String inputStr) =>
    inputStr.codeUnits.fold(0, (a, b) => vowels.contains(b) ? a + 1 : a);

void main() {
  print(vowels.contains('b'.codeUnitAt(0)));
  print(getCount("This a"));
}
