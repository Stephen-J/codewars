// https://www.codewars.com/kata/54c27a33fb7da0db0100040e

import "dart:math" as Math;

isSquare(n) {
  print(Math.sqrt(n));
  return false; // Fix me!
}

void main() {
  print(isSquare(-1));
  print(isSquare(0));
  print(isSquare(3));
  print(isSquare(4));
}
