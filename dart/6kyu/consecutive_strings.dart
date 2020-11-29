// https://www.codewars.com/kata/56a5d994ac971f1ac500003e

bool invalidInput(strarr, k) =>
    strarr.length == 0 || strarr.length < k || k <= 0;

String longestConsec(strarr, k) {
  String longest = '';
  if (!invalidInput(strarr, k)) {
    for (int i = 0; i < strarr.length - k + 1; i++) {
      String tmp = strarr.sublist(i, i + k).join();
      if (tmp.length > longest.length) longest = tmp;
    }
  }
  return longest;
}

void main() {
  print(longestConsec(["zone", "abigail", "theta", "form", "libe", "zas"], 2));
  print(longestConsec(["zone", "abigail", "theta", "form", "libe", "zas"], -1));
}
