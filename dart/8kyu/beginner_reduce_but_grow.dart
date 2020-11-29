// https://www.codewars.com/kata/57f780909f7e8e3183000078

int grow(List<int> arr) => arr.reduce((a, b) => a * b);

void main() {
  print(grow([1, 2, 3]));
}
