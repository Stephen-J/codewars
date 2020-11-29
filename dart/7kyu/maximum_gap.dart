// https://www.codewars.com/kata/5a7893ef0025e9eb50000013

int maxGap(nums) {
  nums.sort();
  int gap = 0;
  for (int i = 0; i < nums.length - 1; i++) {
    if (nums[i + 1] - nums[i] > gap) gap = nums[i + 1] - nums[i];
  }
  return gap;
}

void main() {
  print(maxGap([13, 10, 5, 2, 9]));
}
