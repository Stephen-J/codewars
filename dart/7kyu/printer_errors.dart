// https://www.codewars.com/kata/56541980fa08ab47a0000040

String printerError(String s) {
  int m = "m".codeUnitAt(0);
  List<int> errors = s.codeUnits.fold([0, 0], (prev, curr) {
    if (curr > m) {
      prev[0]++;
    }
    prev[1]++;
    return prev;
  });
  return "${errors[0]}/${errors[1]}";
}

void main() {
  print(printerError("aaabbbbhaijjjm")); //"0/14"
  print(printerError("aaaxbbbbyyhwawiwjjjwwm")); //"8/22"
}
