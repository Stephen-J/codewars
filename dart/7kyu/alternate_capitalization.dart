// https://www.codewars.com/kata/59cfc000aeb2844d16000075

List<String> capitalize(String x) {
  StringBuffer lowerString = StringBuffer();
  StringBuffer upperString = StringBuffer();
  String lower;
  String upper;
  for (int i = 0; i < x.length; i++) {
    lower = x[i].toLowerCase();
    upper = x[i].toUpperCase();
    if (i % 2 == 0) {
      lowerString.write(lower);
      upperString.write(upper);
    } else {
      lowerString.write(upper);
      upperString.write(lower);
    }
  }
  return [upperString.toString(), lowerString.toString()];
}

void main() {
  print(capitalize("abcdef"));
}
