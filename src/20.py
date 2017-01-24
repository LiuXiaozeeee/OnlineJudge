# -*- coding：utf-8 -*-

__author__ = 'LiuXiaozeeee'


class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        l = list(s)

        stack = []
        while l:
            if not stack:
                stack.append(l.pop())
            elif self.isMatch(l[-1],stack[-1]):
                l.pop()
                stack.pop()
            else:
                stack.append(l.pop())
        if stack:
            return False
        else:
            return True


    def isMatch(self,fchar,schar):
        if fchar == '(' and schar == ')' \
                or fchar == '{' and schar == '}' \
                or fchar == '[' and schar == ']':
            return True
        else:
            return False


if __name__ == '__main__':
    temp = ['[][][][][]', '', '[{}]', '[{]}', '()']
    xx = Solution()

    for xxx in temp :
        tempx = xx.isValid(xxx)
        print(tempx)