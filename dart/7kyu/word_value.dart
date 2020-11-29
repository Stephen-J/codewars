// https://www.codewars.com/kata/598d91785d4ce3ec4f000018

List<int> wordValue(List<String> arr) {
  int a = 'a'.codeUnitAt(0);
  int z = 'z'.codeUnitAt(0);
  return arr
      .asMap()
      .map<int, int>((index, str) => MapEntry(
          index,
          (index + 1) *
              str.codeUnits
                  .where((item) => item >= a && item <= z)
                  .fold(0, (prev, v) => (prev + v - a + 1))))
      .values
      .toList();
}

void main() {
  print(wordValue(["abc"]));
  print(wordValue(["abcabc"]));
  print(wordValue(["abc", "abc abc"]));
}
