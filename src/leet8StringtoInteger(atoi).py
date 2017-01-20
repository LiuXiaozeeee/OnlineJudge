__Author__ = 'LiuXiaozeeee'


class Solution(object):
    def myAtoi(self, string):
        """
        :param string: str
        :return: int
        """

        l = list(string)
        aim = 0
        # ctrl 标记变量,0 表示在前字符串, 1 表示在数字中 2 表示在后字符串
        ctrl = 0
        mulsub = [0, 0, 0]
        flag = 1
        for i in l:
            if (not (i <= '9' and '0' <= i)) and ctrl == 0:
                if i == '-':
                    mulsub[1] += 1
                elif i == '+':
                    mulsub[0] += 1
                elif i == ' ' and sum(mulsub[:2]) == 0:
                    mulsub[2] += 1
                else:
                    return 0
            if (not (i <= '9' and '0' <= i)) and ctrl == 1:
                break
            if (i <= '9' and '0' <= i):
                if ctrl == 0:
                    ctrl = 1
                    if (sum(mulsub[:2]) >= 2):
                        return 0
                    if (mulsub[1] == 1):
                        flag = -1
                aim = aim * 10 + ord(i) - ord('0')
        if aim >= 2147483647 and flag == 1:
            return 2147483647
        if aim >= 2147483648 and flag == -1:
            return -2147483648
        return aim * flag
