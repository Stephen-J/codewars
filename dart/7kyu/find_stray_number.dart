// https://www.codewars.com/kata/57f609022f4d534f05000024

int stray(List<int> numbers) {
  Map<int, int> counts = {};
  numbers.forEach(
      (item) => counts[item] == null ? counts[item] = 1 : counts[item]++);
  print(counts);
  return counts.entries
      .where((item) => item.value == 1)
      .first
      .key; // your code here
}

void main() {
  print(stray([1, 1, 2]));
  print(stray([3, 3, 3, 3, 3, 5, 3, 3, 3, 3, 3, 3]));
}
