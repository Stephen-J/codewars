// https://www.codewars.com/kata/5506b230a11c0aeab3000c1f

import "dart:core";
import "dart:math";

int evaporator(double content, double evap_per_day, double threshold) {
  int numDays = 0;
  double amountLeft = 1.0;
  while (amountLeft > threshold / 100) {
    amountLeft -= amountLeft * (evap_per_day / 100);
    numDays++;
  }
  return numDays;
}

void main() {
  print(evaporator(10, 10, 10)); //, equals(22));
  print(evaporator(10, 10, 5)); //, equals(29));
  print(evaporator(100, 5, 5)); //, equals(59));
  print(10 * (1 - 0.1 * 22));
}
