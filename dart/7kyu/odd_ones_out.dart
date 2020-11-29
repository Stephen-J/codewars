// https://www.codewars.com/kata/5d376cdc9bcee7001fcb84c0

List<int> oddOnesOut(List<int> nums) {
  Map<int, int> counts = nums.fold({}, (prev, curr) {
    prev[curr] == null ? prev[curr] = 1 : prev[curr]++;
    return prev;
  });
  return nums.where((item) => counts[item] % 2 == 0).toList();
}

void main() {
  print(oddOnesOut([1, 2, 3, 1, 3, 3]));
}
