// https://www.codewars.com/kata/59df2f8f08c6cec835000012

String meeting(String s) {
  List<String> parsedNames = s
      .split(';')
      .map((fullname) => fullname.split(':').reversed.join(', '))
      .map((fullname) => "(${fullname.toUpperCase()})")
      .toList();
  parsedNames.sort();
  return parsedNames.join();
}

void main() {
  print(meeting(
      "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill"));
  //"(CORWILL, ALFRED)(CORWILL, FRED)(CORWILL, RAPHAEL)(CORWILL, WILFRED)(TORNBULL, BARNEY)(TORNBULL, BETTY)(TORNBULL, BJON)"
}
