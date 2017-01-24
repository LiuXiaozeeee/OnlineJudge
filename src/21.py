# -*- coding:utf-8 -*-

__author__ = 'LiuXiaozeeee'
class ListNode(object):
    def __init__(self,x):
        self.val = x
        self.next = None

class Solution(object):
    def mergeTwoList(self,l1,l2):
        """
        merge two list
        :param l1: ListNode
        :param l2: ListNode
        :return: ListNode
        """
        lresult = ListNode(-1)
        lresult_head = lresult
        while l1 and l2:
            if l1.val < l2.val:
                temp = ListNode(l1.val)
                l1 = l1.next
            else:
                temp = ListNode(l2.val)
                l2 = l2.next
            lresult.next = temp
            lresult = lresult.next
        if not l1:
            #l1 is empty, add l2 to lresult
            lresult.next = l2
        else:
            lresult.next = l1
        return lresult
