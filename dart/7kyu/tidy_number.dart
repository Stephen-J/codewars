// https://www.codewars.com/kata/5a87449ab1710171300000fd

bool tidyNumber(n) {
  List<int> digits = n.toString().codeUnits;
  bool result = true;
  for (int i = 0; i < digits.length - 1; i++) {
    if (digits[i] > digits[i + 1]) {
      result = false;
      break;
    }
  }
  return result;
}

void main() {
  print(tidyNumber(12));
  print(tidyNumber(102));
}
