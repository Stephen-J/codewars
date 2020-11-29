// https://www.codewars.com/kata/5a63948acadebff56f000018
int maxProduct(List<int> arr, int size) {
  arr.sort();
  return arr.skip(arr.length - size).reduce((value, item) => value * item);
}

void main() {
  print(maxProduct([4, 3, 5], 2));
}
