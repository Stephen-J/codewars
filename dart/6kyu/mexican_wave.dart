// https://www.codewars.com/kata/58f5c63f1e26ecda7e000029

List<String> wave(String str) {
  List<String> result = List<String>();
  for (int i = 0; i < str.length; i++) {
    if (str[i] != ' ') {
      result.add(str.replaceRange(i, i + 1, str[i].toUpperCase()));
    }
  }
  return result;
}

void main() {
  var t = 'aaaaa';
  print(t[0].toUpperCase());
  print(wave('hello'));
  print(wave('a    b    '));
}
