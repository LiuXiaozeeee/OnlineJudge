class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if (len(nums) == 0):
            return 1;
        nums = list(set(nums))
        for i in range(len(nums)):
            if (nums[i] <= 0):
                nums[i]  = len(nums) +1
        nums.sort()

        for index, value in enumerate(nums):
            if (index+1 != value):
                return index+1
        return len(nums)+1


if __name__ == "__main__":
    xx = Solution()
    print(xx.firstMissingPositive([1,2,4]))