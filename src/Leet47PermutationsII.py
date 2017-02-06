class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.result=list()
        self.calc(list(),nums)
        temp = set([tuple(x) for x in self.result])
        return [list(x) for x in temp]

    def calc(self, temp, alter):
        """

        :param temp: List[int]
        :param alter: List[int]
        """
        if len(alter) == 0:
            self.result.append(list(temp))
        else:
            for index,x in enumerate(alter):
                temp.append(x)
                self.calc(temp,alter[:index]+alter[index+1:])
                temp.pop()



if __name__ == '__main__':
    temp = Solution()
    print(temp.permuteUnique([3,3,0,0,2,3,2]))