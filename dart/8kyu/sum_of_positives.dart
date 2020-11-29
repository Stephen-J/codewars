// https://www.codewars.com/kata/5715eaedb436cf5606000381

int positiveSum(List<int> arr) {
  List<int> positives = arr.where((n) => n >= 0).toList();
  if (!positives.isEmpty) {
    return arr.where((n) => n >= 0).reduce((a, b) => a + b);
  } else {
    return 0;
  }
}

void main() {
  print(positiveSum([]));
  print(positiveSum([-1, -2, -3, -4, -5]));
  print(positiveSum([1, 2, 3, 4, 5])); //15
  print(positiveSum([1, -2, 3, 4, 5])); //13
}
