// https://www.codewars.com/kata/55908aad6620c066bc00002a

bool XO(String str) {
  str.toUpperCase();
  int matchx = 'x'.allMatches(str).length;
  int matchy = 'o'.allMatches(str).length;
  return matchx == matchy;
}

void main() {
  print(XO("xo"));
  print(XO("xxo"));
  print(XO("aaaaaaaa"));
}
