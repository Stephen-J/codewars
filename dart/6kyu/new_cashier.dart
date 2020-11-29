// https://www.codewars.com/kata/5d23d89906f92a00267bb83d
//New Cashier Does Not Know About Space or Shift

List<String> menu = [
  'burger',
  'fries',
  'chicken',
  'pizza',
  'sandwich',
  'onionrings',
  'milkshake',
  'coke'
];

String getOrder(String input) => menu
    .map((menuItem) => menuItem.allMatches(input))
    .where((matches) => matches.length > 0)
    .map((matches) => List.filled(matches.length, matches.first.group(0)))
    .expand((item) => item)
    .map((item) => item.replaceRange(0, 1, item.substring(0, 1).toUpperCase()))
    .toList()
    .join(' ');

void main() {
  print(getOrder(
      "milkshakepizzachickenfriescokeburgerpizzasandwichmilkshakepizza"));
}
