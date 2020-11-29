// https://www.codewars.com/kata/57eae20f5500ad98e50002c5
String noSpace(String x) {
  List<int> units = List.from(x.codeUnits);
  units.removeWhere((unit) => unit == " ".codeUnitAt(0));
  return String.fromCharCodes(units);
}

void main() {
  print(noSpace("This is a test"));
}
