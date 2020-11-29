// https://www.codewars.com/kata/5a53a17bfd56cb9c14000003

import 'dart:math';

String disariumNumber(n) {
  String nstr = n.toString();
  int zero = '0'.codeUnitAt(0);
  int v = nstr.codeUnits
      .asMap()
      .map((index, value) => MapEntry(index, pow(value - zero, index + 1)))
      .values
      .fold(0, (prev, curr) => prev + curr);
  if (v == n) {
    return 'Disarium !!';
  } else {
    return 'Not !!';
  }
}

void main() {
  String s = "0123456789";
  print(s.codeUnits);
  print(pow(2, 2));
  print(2 ^ 2);
  print(disariumNumber(89));
  print(disariumNumber(564));
}
