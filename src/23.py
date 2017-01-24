# -*- coding:utf-8 -*-

from heapq import *
__author__ = 'LiuXiaozeeee'

class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        l = [ ]
        for x in lists:
            temp = []
            while x:
                temp.append(x.val)
                x = x.next
            l.append(temp)

        lx = list(merge(*l))
        print(lx)
        return createListNode(lx)

def createListNode(list):
    """
    change list into ListNode
    :param list: list
    :return:ListNode
    """
    head = ListNode(-1)
    head_const = head

    for x in list:
        head.next = ListNode(x)
        head = head.next
    return head_const.next


if __name__ == '__main__':
    a = createListNode([1,2,3])
    b = createListNode([4,5,6])
    c = createListNode([7,8,9])
    temp = Solution()
    tempx = temp.mergeKLists([a,b,c])
    pass









