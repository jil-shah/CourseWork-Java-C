# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def addTwoNumbers(self, l1, l2,carry=0):
        """
        :type l1:ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        tempSum = l1.val + l2.val + carry #add ones digit
        carry = tempSum//10  ##divide by 10 which is the carry
        ans = ListNode(tempSum%10)  ##
        
        if (l1.next or l2.next or carry):
            if not l1.next:
                l1.next = ListNode(0)
            if not l2.next:
                l2.next = ListNode(0)
            ans.next = self.addTwoNumbers(l1.next,l2.next,carry)
        return ans
