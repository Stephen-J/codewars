// https://www.codewars.com/kata/583203e6eb35d7980400002a

int getCodeUnit(String s) => s.codeUnitAt(0);

List<int> eyes = ':;'.split('').map(getCodeUnit).toList();
List<int> noses = '-~'.split('').map(getCodeUnit).toList();
List<int> mouths = ')D'.split('').map(getCodeUnit).toList();

bool isSmiley(List<int> str) {
  bool found = false;
  if (eyes.contains(str[0])) {
    if (str.length == 2) {
      found = mouths.contains(str[1]);
    } else if (str.length == 3) {
      found = noses.contains(str[1]) && mouths.contains(str[2]);
    }
  }
  return found;
}

int countSmileys(List<String> arr) {
  return arr.fold(
      0, (count, str) => isSmiley(str.codeUnits) ? count + 1 : count);
}

void main() {
  print("Starting ...");
  print(countSmileys([])); // 0
  print(countSmileys([':)', ';(', ';}', ':-D'])); // 2
}
