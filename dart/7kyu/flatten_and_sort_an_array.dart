// https://www.codewars.com/kata/57ee99a16c8df7b02d00045f

List<int> flattenAndSort(List<List<int>> nums) {
  List<int> result = nums.fold([], (init, elem) {
    init.addAll(elem);
    return init;
  });
  result.sort();
  return result;
}

void main() {
  print(flattenAndSort([
    [3, 2, 1],
    [4, 6, 5],
    [],
    [9, 7, 8]
  ]));
}
